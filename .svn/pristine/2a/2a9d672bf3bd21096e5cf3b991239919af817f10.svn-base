/**
 * 
 */
package com.huateng.ebank.entity.data.mng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

import com.huateng.ebank.entity.data.mng.TblCronTaskJob;


/**
 * 触发器监听
 * 
 * @author wangpeng
 * 
 */
public class TriggerListenerImpl implements TriggerListener {
	Log logger = LogFactory.getLog(TriggerListenerImpl.class);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private String name;

	public TriggerListenerImpl() {

	}

	public TriggerListenerImpl(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#triggerComplete(org.quartz.Trigger,
	 * org.quartz.JobExecutionContext, int)
	 */
	public void triggerComplete(Trigger arg0, JobExecutionContext arg1, int arg2) {
		// TODO Auto-generated method stub
		JobDataMap jobContext = arg1.getJobDetail().getJobDataMap();
		TblCronTaskJob jobBean = (TblCronTaskJob) jobContext
				.get(JobConstant.JOBBEAN_KEY);
		logger.info("#########任务[" + jobBean.getDesc0() + "] 此次触发完成中  "
				+ Calendar.getInstance().getTime() + "#########");
		Boolean hasFinished = (Boolean) jobContext
				.get(JobConstant.HAS_JOB_FINISHED);
		if (hasFinished != null && hasFinished) {
			Calendar c = Calendar.getInstance();
			/**modified by wangpeng BMS-2915 SimpleDateFormat非线程安全导致时间混乱问题修复 begin*/
			SimpleDateFormat dateFmt = new SimpleDateFormat("yyyyMMddHHmmss");
			jobContext.put(JobConstant.PREVIOUS_FINISHED_TIME, dateFmt
					.format(c.getTime()));
			/**modified by wangpeng BMS-2915 SimpleDateFormat非线程安全导致时间混乱问题修复 end*/
			logger.info("#########任务[" + jobBean.getDesc0() + "] 改日执行已结束  "
					+ Calendar.getInstance().getTime() + "#########");
		}
		logger.info("#########任务[" + jobBean.getDesc0() + "] 此次触发已完成  "
				+ Calendar.getInstance().getTime() + "#########");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#triggerFired(org.quartz.Trigger,
	 * org.quartz.JobExecutionContext)
	 */
	public void triggerFired(Trigger arg0, JobExecutionContext arg1) {
		// TODO Auto-generated method stub
		JobDataMap jobContext = arg1.getJobDetail().getJobDataMap();
		boolean lastDailyTime = false;
		Date nextDate = arg0.getNextFireTime();
		Date currentDate = Calendar.getInstance().getTime();

		Calendar currentC = Calendar.getInstance();
		currentC.setTime(currentDate);
		Calendar nextC = Calendar.getInstance();

		nextC.setTime(nextDate);
		/*modified by wangpeng 20101129 jira:BMS-2890 begin*/
		currentC.set(Calendar.HOUR_OF_DAY, 0);
		/*modified by wangpeng 20101129 jira:BMS-2890 end*/
		currentC.set(Calendar.MINUTE, 0);
		currentC.set(Calendar.SECOND, 0);
		currentC.set(Calendar.MILLISECOND, 0);

		/*modified by wangpeng 20101129 jira:BMS-2890 begin*/
		nextC.set(Calendar.HOUR_OF_DAY, 0);
		/*modified by wangpeng 20101129 jira:BMS-2890 end*/
		nextC.set(Calendar.MINUTE, 0);
		nextC.set(Calendar.SECOND, 0);
		nextC.set(Calendar.MILLISECOND, 0);

		if (nextC.compareTo(currentC) > 0) {
			lastDailyTime = true;
		}

		jobContext.put(JobConstant.IS_LAST_RUNNING, lastDailyTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#triggerMisfired(org.quartz.Trigger)
	 */
	public void triggerMisfired(Trigger arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.TriggerListener#vetoJobExecution(org.quartz.Trigger,
	 * org.quartz.JobExecutionContext)
	 */
	public boolean vetoJobExecution(Trigger arg0, JobExecutionContext arg1) {
		JobDataMap jobContext = arg1.getJobDetail().getJobDataMap();
		TblCronTaskJob jobBean = (TblCronTaskJob) arg1.getJobDetail()
				.getJobDataMap().get(JobConstant.JOBBEAN_KEY);
		logger.info("#########任务[" + jobBean.getDesc0() + "] 否决触发判断开始  "
				+ Calendar.getInstance().getTime() + "#########");
		String strPreFinishedTime = (String) jobContext
				.get(JobConstant.PREVIOUS_FINISHED_TIME);
		if (strPreFinishedTime != null) {
			try {
				/**modified by wangpeng BMS-2915 SimpleDateFormat非线程安全导致时间混乱问题修复 begin*/
				SimpleDateFormat dateFmt = new SimpleDateFormat("yyyyMMddHHmmss");
				Date previousFinishedTime = dateFmt
						.parse(strPreFinishedTime);
				/**modified by wangpeng BMS-2915 SimpleDateFormat非线程安全导致时间混乱问题修复 end*/
				Calendar currentDate = Calendar.getInstance();
				Calendar previousDate = Calendar.getInstance();
				previousDate.setTime(previousFinishedTime);
				/*modified by wangpeng 20101129 jira:BMS-2890 begin*/
				currentDate.set(Calendar.HOUR_OF_DAY, 0);
				/*modified by wangpeng 20101129 jira:BMS-2890 end*/
				currentDate.set(Calendar.MINUTE, 0);
				currentDate.set(Calendar.SECOND, 0);
				currentDate.set(Calendar.MILLISECOND, 0);

				/*modified by wangpeng 20101129 jira:BMS-2890 begin*/
				previousDate.set(Calendar.HOUR_OF_DAY, 0);
				/*modified by wangpeng 20101129 jira:BMS-2890 end*/
				previousDate.set(Calendar.MINUTE, 0);
				previousDate.set(Calendar.SECOND, 0);
				previousDate.set(Calendar.MILLISECOND, 0);
				if (currentDate.compareTo(previousDate) == 0) {
					logger.info("#########任务[" + jobBean.getDesc0()
							+ "] 已否决此次触发 " + Calendar.getInstance().getTime()
							+ "#########");
					return true;
				}
			} catch (ParseException e) {
				logger.info("#########任务[" + jobBean.getDesc0()
						+ "] 因获取上一执行日期出错已否决此次触发 " + Calendar.getInstance().getTime()
						+ "#########");
				e.printStackTrace();
				return true;
			}
		}
		logger.info("#########任务[" + jobBean.getDesc0() + "] 未否决此次触发  "
				+ Calendar.getInstance().getTime() + "#########");
		return false;
	}

}
