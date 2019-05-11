/**
 * 
 */
package com.huateng.ebank.entity.data.mng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.quartz.CronExpression;
import org.quartz.TriggerUtils;
import com.huateng.ebank.entity.data.mng.TblCronTaskJob;


/**
 * 执行表达式辅助类
 * @author wangpeng
 *
 */
public class CronExpressionUtil {
	public static CronExpression convertToCronExpress(TblCronTaskJob jobBean)throws ParseException{
		String cronStr=null;
		String startTime=jobBean.getStartTime();
		String endTime=jobBean.getEndTime();
		
		//获得每次的开始和结束时间
		SimpleDateFormat format=new SimpleDateFormat("HHmmss");
		Date startDate=format.parse(startTime);
		Date endDate=format.parse(endTime);
		Calendar cStart=Calendar.getInstance();
		Calendar cEnd=Calendar.getInstance();
		cStart.setTime(startDate);
		cEnd.setTime(endDate);
		
		//暂时只支持整时数的时间间距
		int startHour=cStart.get(Calendar.HOUR_OF_DAY);
		int endHour=cEnd.get(Calendar.HOUR_OF_DAY);
		int startMinute=cStart.get(Calendar.MINUTE);
		int endMinute=cEnd.get(Calendar.MINUTE);
		
		
		//时间间隔
		String minuteStringInterval="0/"+jobBean.getRepeatTime();
		
		cronStr="0 "+minuteStringInterval+" "+startHour+"-"+endHour;
		/**modified by wangpeng 20091008 BMS-2054 定时任务优化 begin*/
		if(jobBean.getRuntime().equals(JobConstant.RUN_TIME_DAILY)){//每日
			cronStr+=" * * ?";
		}else if(jobBean.getRuntime().equals(JobConstant.RUN_TIME_MONTHLY_END)){//每月末
			cronStr+=" L * ?";
		}else if(jobBean.getRuntime().equals(JobConstant.RUN_TIME_MONTHLY_BEGIN)){//每月初
		   cronStr+=" 1 * ?";
		}else if(jobBean.getRuntime().equals(JobConstant.RUN_TIME_MONTHLY_BEGIN)){//每月某日
		   cronStr+=" "+jobBean.getDaysOfMonth()+" * ?";
		}else if(jobBean.getRuntime().equals(JobConstant.RUN_TIME_NONE)){//不运行
			return null;
		}else{//不明代码不运行
			return null;
		}
		/**modified by wangpeng 20091008 BMS-2054 定时任务优化 end*/
		CronExpression cronExpress=new CronExpression(cronStr);
		return cronExpress;
	}
	
	public static CronExpression getHourlyCronExpress(String runTime,Long interval,Integer dayOfMonth)throws ParseException{
		String cronStr=null;
		
		//时间间隔
		String minuteStringInterval="0/"+interval;
		
		cronStr="0 "+minuteStringInterval+" *";

		if(runTime.equals(JobConstant.RUN_TIME_DAILY)){//每日
			cronStr+=" * * ?";
		}else if(runTime.equals(JobConstant.RUN_TIME_MONTHLY_END)){//每月末
			cronStr+=" L * ?";
		}else if(runTime.equals(JobConstant.RUN_TIME_MONTHLY_BEGIN)){//每月初
		   cronStr+=" 1 * ?";
		}else if(runTime.equals(JobConstant.RUN_TIME_EVERY_MONTH_DAY)){//每月某日
		   cronStr+=" "+dayOfMonth+" * ?";
		}else if(runTime.equals(JobConstant.RUN_TIME_NONE)){//不运行
			return null;
		}else{//不明代码不运行
			return null;
		}

		CronExpression cronExpress=new CronExpression(cronStr);
		return cronExpress;
	}
}
