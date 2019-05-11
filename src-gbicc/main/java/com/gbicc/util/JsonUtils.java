package com.gbicc.util;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * JSON工具类
 * @date    2016年1月19日
 * @author  tangdu
 * @desc	
 */
public class JsonUtils {
	
	/**
	 * 获得日期序列化config
	 * @return
	 */
	public static JsonConfig getDateConfig(){
		JsonConfig config=new JsonConfig();
		config.registerJsonValueProcessor(Date.class,new JsonValueProcessor() {
			@Override
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				if(arg1==null){
					return "";
				}
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return dateFormat.format((Date)arg1);
			}
			@Override
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				return null;
			}
		});
		return config;
	}
	
	/**
	 * 将对象转换成JSON字符串
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj){
		try {
			if (obj instanceof Collection) {
				return JSONArray.fromObject(obj, JsonUtils.getDateConfig()).toString();
			} else {
				return JSONObject.fromObject(obj, JsonUtils.getDateConfig()).toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 讲JSON字符串转换成bean对象
	 * @param str
	 * @param clz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object toBean(String str,Class clz){
		try {
			return JSONObject.toBean(JSONObject.fromObject(str),clz);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}