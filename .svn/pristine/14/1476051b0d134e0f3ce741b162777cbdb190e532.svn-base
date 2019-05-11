package com.gbicc.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeTracer {
	private static final Logger log =LoggerFactory.getLogger(TimeTracer.class);
	private static Map<String,TimeTracer> tracers =new HashMap<String,TimeTracer>();
	
	public static TimeTracer getInstance(String name){
		TimeTracer result =tracers.get(name);
		if(result==null){
			result =new TimeTracer(name);
			tracers.put(name, result);
		}
		return result;
	}
	
	public static long getInterval(String name){
		return getInstance(name).getInterval();
	}
	
	private String name;
	private long last =new Date().getTime();
	
	public TimeTracer(){}
	
	public TimeTracer(String name){
		this.name =name;
	}
	
	public long getInterval(){
		long current =new Date().getTime();
		long result =current - last;
		last =current;
		return result;
	}
	
	public String message(String message){
		return name + " - " + message + " : " + getInterval() + " ms";
	}
	
	public void log(String message){
		log.info(message(message));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
