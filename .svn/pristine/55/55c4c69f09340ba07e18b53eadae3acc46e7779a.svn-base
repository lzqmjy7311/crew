/**
 *
 */
package com.huateng.ebank.entity.data.mng;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import com.huateng.ebank.entity.data.mng.TblCronTaskJob;
import com.huateng.ebank.entity.data.mng.TblCronTaskJobLog;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.monitor.scheduler.operation.ExecuteJobOperation;
import com.huateng.ebank.monitor.scheduler.service.ITaskJobScheduler;
import com.huateng.exception.AppException;
import com.huateng.util.ContextUtil;

/**
 * 定时任务基类
 * @author wangpeng
 *
 */
public abstract class BaseJobDetail implements StatefulJob{
	private static Log logger = LogFactory.getLog(BaseJobDetail.class);
	/* add by shen_antonio 20100714 jira:BMS-2809 begin.*/
	private static final String TRANSACTION_FLAG = "_transaction_flag_";
	/* add by shen_antonio 20100714 jira:BMS-2809 end.*/
	

    public BaseJobDetail() {
    }

    public void execute(JobExecutionContext arg0)throws JobExecutionException{
    	executeInternal(arg0);
    }

	private void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		JobDataMap jobContext = arg0.getJobDetail().getJobDataMap();
		TblCronTaskJob jobBean=(TblCronTaskJob)jobContext.get(JobConstant.JOBBEAN_KEY);
		HashMap jobParameters=(HashMap)jobContext.get(JobConstant.JOB_PARAMETERS);
		int repeatCount=jobBean.getRepeatCnt();//需要成功执行次数
		int successCount=(Integer)jobContext.get(JobConstant.JOB_SUCCESS_COUNT);//已成功次数
		String success=JobConstant.JOB_EXECUTE_RESULT_IGNORE;//return
		boolean lastDailyTime=(Boolean)jobContext.get(JobConstant.IS_LAST_RUNNING);//是否当日最后一次
		boolean hasJobFinished=false;//任务是否执行结束
		String message="";
		logger.info("#########任务["+jobBean.getDesc0()+"] 此次轮询开始  "+Calendar.getInstance().getTime()+"#########");
		try{
			/* modify by shen_antonio 20091025 jira: BMS-2026 begin .*/
			//success=executeJob(jobParameters);
			Object transactionFlag = jobParameters.get(TRANSACTION_FLAG);
			
			/* modify by shen_antonio 20100714 jira:BMS-2809 begin .*/
			if( transactionFlag!= null && transactionFlag.toString().equalsIgnoreCase("false")){
				success=executeJob(jobParameters);
			}else{
				OperationContext operationContext = new OperationContext();
				operationContext.setAttribute(ExecuteJobOperation.INPUT_JOB_OBJECT, this);
				operationContext.setAttribute(ExecuteJobOperation.INTPUT_JOB_PARAMETER, jobParameters);
				OPCaller.call(ExecuteJobOperation.ID, operationContext);
				success = (String)operationContext.getAttribute(ExecuteJobOperation.OUTPUT_RESULT_STRING);
			}
			/* modify by shen_antonio 20100714 jira:BMS-2809 end.*/
			
			/* modify by shen_antonio 20091025 jira: BMS-2026 end .*/
		}catch (Exception e) {
			message=e.getMessage();
			e.printStackTrace();
			success=JobConstant.JOB_EXECUTE_RESULT_FAIL;
		}

		try{
		if(success.equals(JobConstant.JOB_EXECUTE_RESULT_IGNORE)){
			logger.info("#########任务["+jobBean.getDesc0()+"] 忽略此次轮询  "+Calendar.getInstance().getTime()+"#########");
			/**added by wangpeng BMS-2915  非持续执行定时任务 返回[忽略]结果误处理为执行一次错误修复 begin*/
			jobContext.put(JobConstant.HAS_JOB_FINISHED,false);//忽略的都为未结束的
			/**added by wangpeng BMS-2915  非持续执行定时任务 返回[忽略]结果误处理为执行一次错误修复 end */
			return;//忽略的返回
		}
		if(repeatCount>0) successCount++;//持续执行的不需要累加

		if(repeatCount!=-1&&successCount>=repeatCount){//达到需要执行的次数
			successCount=0;
			hasJobFinished=true;
			jobContext.put(JobConstant.HAS_JOB_FINISHED,hasJobFinished);
		}

		if(success.equals(JobConstant.JOB_EXECUTE_RESULT_SUCCESS)){//执行成功
			logger.info("#########任务["+jobBean.getDesc0()+"] 执行成功  "+Calendar.getInstance().getTime()+"#########");
			afterExeSuccess(jobParameters);//调用成功后的操作
			afterExe_internal(jobBean,true,message,lastDailyTime||hasJobFinished);
		}else if(success.equals(JobConstant.JOB_EXECUTE_RESULT_FAIL)){//执行失败
			logger.info("#########任务["+jobBean.getDesc0()+"] 执行失败  "+Calendar.getInstance().getTime()+"#########");
			afterExeFail(jobParameters);
			afterExe_internal(jobBean,false,message,lastDailyTime||hasJobFinished);
		}

		if(lastDailyTime&&repeatCount!=-1){//当日任务结束
			hasJobFinished=true;
			jobContext.put(JobConstant.HAS_JOB_FINISHED, hasJobFinished);//
		}

		jobContext.put(JobConstant.JOB_SUCCESS_COUNT, successCount);//设置执行次数到job data中
		logger.info("#########job["+jobBean.getDesc0()+"] 轮询执行第"+successCount+"次结束  "+Calendar.getInstance().getTime()+"#########");
		}catch(Exception e){
			message=e.getMessage();
			afterExe_internal(jobBean,success.equals(JobConstant.JOB_EXECUTE_RESULT_SUCCESS),message,lastDailyTime);
			logger.info("#########job["+jobBean.getDesc0()+"] 轮询出错  "+Calendar.getInstance().getTime()+"#########");
			e.printStackTrace();
			throw new JobExecutionException(e);
		}
	}

	/**记入日志表**/
	private TblCronTaskJobLog generateLog(TblCronTaskJob jobBean,boolean success,String message,boolean isFinished){
		TblCronTaskJobLog log=new TblCronTaskJobLog();
		log.setEndExcuteFlag(isFinished?JobConstant.DAILY_JOB_FINISHED:JobConstant.DAILY_JOB_NOT_FINISHED);
		log.setExceptionMsg(message);
		log.setExcuteOwn("");
		log.setExcuteResult(success?JobConstant.JOB_EXECUTE_RESULT_SUCCESS:JobConstant.JOB_EXECUTE_RESULT_FAIL);

		Calendar c=Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		log.setExcuteTime(format.format(c.getTime()));

		log.setFailFlag(success?"0":"1");
		log.setSucFlag(success?"1":"0");

		log.setJobno(jobBean.getJobno());
		log.setSubProceFunction(jobBean.getProcessFunction());

		return log;

	}


	/**执行结束后的操作*/
	private void afterExe_internal(TblCronTaskJob jobBean,boolean success,String message,boolean isFinished){
		try{
		ITaskJobScheduler schedulerService=(ITaskJobScheduler)ContextUtil.getContext().getBean("TaskJobScheduler");
		TblCronTaskJobLog log=generateLog(jobBean, success, message, isFinished);
		schedulerService.writeLog(log);

		Calendar c=Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		jobBean.setLastRunTime(format.format(c.getTime()));
		schedulerService.updateJob(jobBean);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * @return 0-成功执行 1-失败执行 2-跳过
	 */
	public abstract String executeJob(HashMap jobParameters)throws AppException;

	public abstract void afterExeSuccess(HashMap jobParameters)throws AppException;

	public abstract void afterExeFail(HashMap jobParameters)throws AppException;

}
