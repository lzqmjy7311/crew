/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.ebank.entity.data.mng;

/**
 * 定时任务常量
 * @author wangpeng
 * 
 */

public class JobConstant {

	/**
	 * 任务运行时间：不跑
	 */
	public static final String RUN_TIME_NONE = "9N";
	/**
	 * 任务运行时间：每日
	 */
	public static final String RUN_TIME_DAILY = "90";
	/**
	 * 任务运行时间：每旬（固定在周五批量）
	 */
	public static final String RUN_TIME_EVERY_TEN_DAYS = "91";
	/**
	 * 任务运行时间：每月初
	 */
	public static final String RUN_TIME_MONTHLY_BEGIN = "93";
	/**
	 * 任务运行时间：每月末
	 */
	public static final String RUN_TIME_MONTHLY_END = "98";
	/**
	 * 任务运行时间：每季
	 */
	public static final String RUN_TIME_EVERY_SEASON = "94";
	/**
	 * 任务运行时间：每半年
	 */
	public static final String RUN_TIME_EVERY_HALF_YEAR = "95";
	/**
	 * 任务运行时间：每年
	 */
	public static final String RUN_TIME_YEARLY = "96";
	/**
	 * 任务运行时间：每月某日
	 */
	public static final String RUN_TIME_EVERY_MONTH_DAY= "97";

	/**
	 * 任务运行时间：星期一
	 */
	public static final String RUN_TIME_WEEKDAY_MONDAY = "41";
	/**
	 * 任务运行时间：星期二
	 */
	public static final String RUN_TIME_WEEKDAY_TUESDAY = "42";
	/**
	 * 任务运行时间：星期三
	 */
	public static final String RUN_TIME_WEEKDAY_WEDNESDAY = "43";
	/**
	 * 任务运行时间：星期四
	 */
	public static final String RUN_TIME_WEEKDAY_THURSDAY = "44";
	/**
	 * 任务运行时间：星期五
	 */
	public static final String RUN_TIME_WEEKDAY_FRIDAY = "45";
	/**
	 * 任务运行时间：星期六
	 */
	public static final String RUN_TIME_WEEKDAY_SATURDAY = "46";
	/**
	 * 任务运行时间：星期日
	 */
	public static final String RUN_TIME_WEEKDAY_SUNDAY = "47";
	
	/**
	 * jobdatamap中jobbean的key
	 */
	public static final String JOBBEAN_KEY="jobbean";
	
	/**
	 * 是否最后一次运行
	 */
	public static final String IS_LAST_RUNNING="islastrunning";
	
	/**
	 * 是否任务已经运行结束
	 */
	public static final String HAS_JOB_FINISHED="jobfinished";
	
	/**
	 * 上次任务结束时间
	 */
	public static final String PREVIOUS_FINISHED_TIME="previousfinishtime";
	
	/**
	 * 任务执行成功次数
	 */
	public static final String JOB_SUCCESS_COUNT="jobsuccesscount";
	
	/**
	 * 任务上下文
	 */
	public static final String JOB_CONTEXT="jobcontext";
	
	/**
	 * 任务参数集合
	 */
	public static final String JOB_PARAMETERS="jobparameters";
	
	/**
	 * 任务运行结果_成功
	 */
	public static final String JOB_EXECUTE_RESULT_SUCCESS="0";
	
	/**
	 * 任务运行结果_失败
	 */
	public static final String JOB_EXECUTE_RESULT_FAIL="1";
	
	/**
	 * 任务运行结果_忽略
	 */
	/**modified by wangpeng 20091007 BMS-2050 修正参数错误问题 begin**/
	public static final String JOB_EXECUTE_RESULT_IGNORE="2";
	/**modified by wangpeng 20091007 BMS-2050 修正参数错误问题 end**/
	
	/**
	 * 日任务结束
	 */
	public static final String DAILY_JOB_FINISHED="1";
	
	/**
	 * 日任务结束
	 */
	public static final String DAILY_JOB_NOT_FINISHED="0";
	
	/**
	 * 任务名后缀
	 */
	public static final String JOB_NAME_POST_FIX="_job";
	
	/**
	 * 触发器后缀
	 */
	public static final String TRIGGER_NAME_POST_FIX="_trigger";
	
	/**
	 * 触发监听器后缀
	 */
	public static final String TRIGGER_LISTENER_NAME_POST_FIX="_triggerlistener";
	
	/**
	 * 执行日历后缀
	 */
	public static final String JOB_CALENDAR_NAME_POST_FIX="_calendar";
	
	/**added by wangpeng 20091015 BMS-2087 begin*/
	/**
	 * 任务启动模式-自动启动
	 */
	public static final String JOB_START_MODE_AUTO="1";
	/**
	 * 任务启动模式-手动启动
	 */
	public static final String JOB_START_MODE_MANUAL="0";
	/**added by wangpeng 20091015 BMS-2087 end*/
}
