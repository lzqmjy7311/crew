package com.huateng.ebank.entity.data.mng;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Calendar;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import com.huateng.ebank.entity.data.mng.TblCronTaskJob;
import com.huateng.util.ContextUtil;

/**
 * 定时任务总调度
 * 
 * @author wangpeng
 * 
 */
public class HTscheduler {
	private static Log logger = LogFactory.getLog(HTscheduler.class);
	
	public static void main(String[] arg) throws Exception {
		HTscheduler scheduler =HTscheduler.getInstance();

		TblCronTaskJob jobBean = new TblCronTaskJob();
		jobBean.setJobno(1);
		jobBean.setDesc0("测试任务-持续执行（失败）");
		jobBean
				.setProcessFunction("com.huateng.swt.monitor.scheduler.bean.TestJob");
		jobBean.setRepeatCnt(-1);
		jobBean.setRepeatTime(1l);
		jobBean.setRuntime(JobConstant.RUN_TIME_EVERY_MONTH_DAY);
		jobBean.setDaysOfMonth(1);
		jobBean.setStartTime("145100");
		jobBean.setEndTime("193000");
		scheduler.startJob(jobBean);

		jobBean = new TblCronTaskJob();
		jobBean.setJobno(2);
		jobBean.setDesc0("测试任务2");
		jobBean
				.setProcessFunction("com.huateng.swt.monitor.scheduler.bean.TestJob");
		jobBean.setRepeatCnt(-1);
		jobBean.setRepeatTime(1l);
		jobBean.setRuntime(JobConstant.RUN_TIME_DAILY);
		jobBean.setStartTime("143000");
		jobBean.setEndTime("142000");
		//scheduler.startJob(jobBean);

	}

	protected HTscheduler() throws Exception{
		_schedulerFactory=(HTschedulerFactory)ContextUtil.getBean("QuartzSchedulerFactory");//
		_scheduler = _schedulerFactory.getScheduler();
//		if (_scheduler.isStarted() == false) {// 启动总调度
//			_scheduler.start();
//		}
		logger.info("当前scheduler的实例名为"+_scheduler.getSchedulerInstanceId());
	}

	private Scheduler _scheduler;
	private HTschedulerFactory _schedulerFactory;
	private static HTscheduler _htScheduler;

	/* get instance */
	public static synchronized HTscheduler getInstance() throws Exception{
		if (_htScheduler == null) {
			_htScheduler = new HTscheduler();
		}
		return _htScheduler;
	}

	/**启动任务*/
	public boolean startJob(TblCronTaskJob jobBean) throws Exception {

		JobDetail job = new JobDetail();//任务实例
		job.setJobClass(Class.forName(jobBean.getProcessFunction()));
		job.setName(jobBean.getJobno()+JobConstant.JOB_NAME_POST_FIX);//名字即为标识 =jobno+后缀

		JobDataMap dataMap = new JobDataMap();
		//HashMap context = new HashMap();//执行中需要的上下文信息
		initJobContext(dataMap);
		
		HashMap parameters=getJobParameters(jobBean);//参数集合
		
		dataMap.put(JobConstant.JOBBEAN_KEY,jobBean);
		//dataMap.put(JobConstant.JOB_CONTEXT,context);//持久化的情况下  不能保存非基本类型的数据
		dataMap.put(JobConstant.JOB_PARAMETERS,parameters);
		job.setJobDataMap(dataMap);
		//job.setJobDataAsMap(dataMap);

		CronTrigger trigger = new CronTrigger();//触发器
		trigger.setName(jobBean.getJobno()+JobConstant.TRIGGER_NAME_POST_FIX);
		trigger.setJobName(job.getName());

		//执行日表达式（全时段）
        CronExpression expression=CronExpressionUtil.getHourlyCronExpress(jobBean.getRuntime(), jobBean.getRepeatTime(),jobBean.getDaysOfMonth());
        if(expression==null) return false;//返回空则表明不运行该job
		trigger.setCronExpression(expression);

		//修改为使用全局触发器,在配置内注入
//		TriggerListener triggerlistener = new TriggerListenerImpl(jobBean
//				.getJobno()
//				+ JobConstant.TRIGGER_LISTENER_NAME_POST_FIX);//触发监听器
//		_scheduler.addTriggerListener(triggerlistener);
//		trigger.addTriggerListener(triggerlistener.getName());
		
		Calendar timeRange=JobCalendarUtil.getDailyColendar(jobBean.getStartTime(),jobBean.getEndTime());//执行时间段
		_scheduler.addCalendar(jobBean.getJobno()+JobConstant.JOB_CALENDAR_NAME_POST_FIX, timeRange,true,true);
		trigger.setCalendarName(jobBean.getJobno()+JobConstant.JOB_CALENDAR_NAME_POST_FIX);

		_scheduler.scheduleJob(job, trigger);
	
		logger.info("启动任务【"+jobBean.getDesc0()+"】");
		return true;
	}

	/**停止任务*/
	public void stopJob(int jobNo) throws SchedulerException {
		_scheduler.deleteJob(jobNo + "_job", Scheduler.DEFAULT_GROUP);// 详细任务
	}

	/**重启任务*/
	public void restartJob(TblCronTaskJob jobBean) throws Exception {
		stopJob(jobBean.getJobno());// 先停止
		startJob(jobBean);
	}
	
	private HashMap getJobParameters(TblCronTaskJob job){
		HashMap parameters=new HashMap();
		/* modify by shen_antonio 20100606 JIRA: BMS-2771 begin .*/
		String processParam  = job.getProcessParam();
		if(!StringUtils.isEmpty(processParam)){
			String[] paramArg = processParam.split(";");
			String paramString = "", paramKey,paramValue;
			for(int i= 0;i<paramArg.length;i++){
				paramString = paramArg[i];
				if(paramString.indexOf("=")>=1){
					paramKey = paramString.substring(0,paramString.indexOf("="));
					if(paramString.indexOf("=") + 1 == paramString.length()){
						logger.error("#####JOB[" + job.getJobno() + "] process_param error," + "param value[" + paramString + "] should param_value ");	
					}else{
						paramValue = paramString.substring(paramString.indexOf("=")+1);
						parameters.put(paramKey, paramValue);
					}
				}
				else if(paramString.indexOf("=")==0){
					logger.error("#####JOB[" + job.getJobno() + "] process_param error," + "param value[" + paramString + "] should param_key ");	
				}else{
					logger.error("#####JOB[" + job.getJobno() + "] process_param error," + "param value[" + paramString + "] should contain '=' ");
				}
			}
		}
		/* modify by shen_antonio 20100606 JIRA: BMS-2771 end .*/
		return parameters;
	}
	
	/**初始化job上下文**/
	private void initJobContext(Map jobContext){
		jobContext.put(JobConstant.HAS_JOB_FINISHED, false);
		jobContext.put(JobConstant.IS_LAST_RUNNING, false);
		jobContext.put(JobConstant.JOB_SUCCESS_COUNT, 0);
	}
	
	/**added by wangpeng 20091014 BMS-2087 begin*/
	public Boolean isJobRunning(int jobNo){
		try{
		JobDetail job=this._scheduler.getJobDetail(jobNo+JobConstant.JOB_NAME_POST_FIX,Scheduler.DEFAULT_GROUP);
		if(job==null) return false;
		return true;
		}catch(SchedulerException e){
			//e.printStackTrace();
			return false;
		}
	}
	/**added by wangpeng 20091014 BMS-2087 end*/
	
	/* modify by shen_antonio 20100601 JIAR: BMS-2769 begin.*/
	/** 
	* @Title: shutdown  scheduler
	* @Description: TODO
	* @param @throws SchedulerException     
	* @return void
	* @author shen_antonio
	* @date 2010-5-31 下午04:05:29 
	* @throws 
	*/ 
	public void shutdown()throws SchedulerException {
		_scheduler.shutdown();
	}
	/* modify by shen_antonio 20100601 JIAR: BMS-2769 end.*/
}
