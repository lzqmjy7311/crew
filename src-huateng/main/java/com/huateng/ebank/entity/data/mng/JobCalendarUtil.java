/**
 * 
 */
package com.huateng.ebank.entity.data.mng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import org.quartz.impl.calendar.DailyCalendar;


/**
 * job执行日历辅助类
 * 
 * @author wangpeng
 * @since 2009/10/08
 */
public class JobCalendarUtil {
	public static org.quartz.Calendar getDailyColendar(String startTime,
			String endTime) throws ParseException {
		// 获得每次的开始和结束时间
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		Date startDate = format.parse(startTime);
		Date endDate = format.parse(endTime);

		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();
		calendarStart.setTime(startDate);
		calendarEnd.setTime(endDate);
		//---------added by wangpeng 20091022 BMS-2118 begin--------------//
		calendarStart.set(Calendar.SECOND, 0);
		calendarEnd.set(Calendar.SECOND, 0);
		//---------added by wangpeng 20091022 BMS-2118 end--------------//
		format = new SimpleDateFormat("HH:mm:ss");
		DailyCalendar timeRange;//时间段（配合cronexpression使用，可以排除掉设置的时间段外的触发）
		if (calendarStart.compareTo(calendarEnd) <= 0) {//不跨0点的时间设置,排除掉设置的时间段之外的触发
			calendarEnd.add(Calendar.SECOND, 1);//时间相同的情况下必须置endtime为大
			timeRange = new DailyCalendar(format
					.format(calendarStart.getTime()), format.format(calendarEnd.getTime()));
			timeRange.setInvertTimeRange(true);
		} else {//跨0点的时间设置，排除掉开始结束时间换位后的时间段的触发(跨天的时间设置有问题，有待修复)
			timeRange = new DailyCalendar(format
					.format(calendarEnd.getTime()), format.format(calendarStart.getTime()));
			timeRange.setInvertTimeRange(false);
		}

		return timeRange;
	}
}
