package com.gbicc.engine.rule.util;

import javax.sql.DataSource;

import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class Spring4Groovy {

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName,Class<T> clz){
		return (T)ApplicationContextUtils.getBean(beanName);
	}
	
	public static DataSource getDefaultDataSource(){
		return getBean("defaultDataSource",DataSource.class);
	}
}
