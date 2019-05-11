/**
 * 
 */
package com.huateng.ebank.entity.data.mng;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerListener;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.huateng.ebank.entity.data.mng.TblCronTaskJob;


/**
 * 专门用于启动详细日间任务
 * @author wangpeng
 *
 */
public class JobStarter extends QuartzJobBean {

	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDetail jobStarter=arg0.getJobDetail();
		JobDataMap map=jobStarter.getJobDataMap();
		TblCronTaskJob jobBean=(TblCronTaskJob)map.get("jobbean");
		Scheduler scheduler=arg0.getScheduler();
		
		try{
		String startTime=jobBean.getStartTime();
		String endTime=jobBean.getEndTime();
		
		SimpleDateFormat format=new SimpleDateFormat("HHmmss");
		Date startDate=format.parse(startTime);
		Date endDate=format.parse(endTime);
		
		JobDetail jobDetail=new JobDetail();
		jobDetail.setJobClass(Class.forName(jobBean.getProcessFunction()));
		jobDetail.setName(jobBean.getJobno()+"_job");
		jobDetail.setJobDataMap(map);
		
		SimpleTrigger trigger=new SimpleTrigger();
		trigger.setName(jobBean.getJobno()+"_trigger");
		trigger.setRepeatCount(-1);
		trigger.setStartTime(startDate);
		trigger.setEndTime(endDate);
		trigger.setRepeatInterval(1000*60*jobBean.getRepeatTime());
		
		TriggerListener listener=new TriggerListenerImpl(jobBean.getJobno()+"");
		scheduler.addTriggerListener(listener);
		trigger.addTriggerListener(listener.getName());
		
		scheduler.scheduleJob(jobDetail,trigger);
		
		}catch(Exception e){
			throw new JobExecutionException(e);
		}
	}
	
	

}
