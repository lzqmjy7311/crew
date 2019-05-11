package com.gbicc.engine.rule;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Environment {
	private static final Logger log =LoggerFactory.getLogger(Environment.class);
	public static boolean IS_PRODUCT_ENVIRONMENT=true;
	public static String JDBC_URL;
	public static String JDBC_USER;
	public static String JDBC_PASSWORD;
	
	static{
		Properties properties =new Properties();
		InputStream ins =null;
		try {
			ins =Environment.class.getResourceAsStream("/environment_groovy.properties");
			if(ins!=null){
				properties.load(ins);
				IS_PRODUCT_ENVIRONMENT =false;
				JDBC_URL =properties.getProperty("JDBC_URL");
				JDBC_USER =properties.getProperty("JDBC_USER");
				JDBC_PASSWORD =properties.getProperty("JDBC_PASSWORD");
			}
		} catch (IOException e) {
			log.info("NOT found file 'classpath:/environment_groovy.properties', so this system should run in product environment.");
		} finally{
			if(ins!=null){try{ins.close();}catch(Exception e){}}
		}
	}
}
