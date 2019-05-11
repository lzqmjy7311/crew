package com.gbicc.person.monitor.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 工作台任务统计类型
 * @date    2015年12月15日
 * @author  tangdu
 * @desc
 */
public enum TaskType {

	OVERTASK("overTask"),
	NEWTASK("newTask"),
	TODOTASK("todoTask"),
	//二级行长岗位
	EJHZCHECKTASK("ejhzCheckTask"),
	EJHZPASSTASK("ejhzPassTask"),
	EJHZBACKTASK("ejhzBackTask"),
	//一级贷后管理岗审查
	YJDHSCHECKTASK("yjdhsCheckTask"),
	YJDHSPASSTASK("yjdhsPassTask"),
	YJDHSBACKTASK("yjdhsBackTask"),
	//一级贷后管理管理核
	YJDHGCHECKTASK("yjdhgCheckTask"),
	YJDHGPASSTASK("yjdhgPassTask"),
	YJDHGBACKTASK("yjdhgBackTask"),
	//客户经理
	CHECKTASK("checkTask"),
	PASSTASK("passTask"),
	BACKTASK("backTask"),
	//预警任务
	REDLEVEL("redLevel"),
	ORANGELEVEL("orangeLevel"),
	YELLOWLEVEL("yellowLevel");
	
	private String taskVal;
	TaskType(String taskVal){
		this.taskVal=taskVal;
	}
	
	public String getTask(){
		return this.taskVal;
	}
	public static TaskType getTaskType(String key){
		return mps.get(key);
	}
	
	private static final Map<String,TaskType> mps=new HashMap<String, TaskType>();
	static{
		for(TaskType t:values()){
			mps.put(t.getTask(), t);
		}
	}
}
