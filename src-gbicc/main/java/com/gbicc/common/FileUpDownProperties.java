package com.gbicc.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileUpDownProperties {
	private static Properties config = new Properties();
	static {
		InputStream in = FileUpDownProperties.class.getClassLoader()
				.getResourceAsStream("fileUpDownConfig.properties");
		try {
			config.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("No fileUpDownConfig.properties defined error");
		}
	} 
	
	// 根据key读取value
	public static String readValue(String key) {
		try {
			String value = config.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ConfigInfoError" + e.toString());
			return null;
		}
	}
	
	// 读取properties的全部信息
	public static Map<String, String> readAllProperties() {
		Map<String, String> properties = new HashMap<String, String>();
		try {
			Enumeration en = config.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String Property = config.getProperty(key);
				properties.put(key, Property);
			}
		} catch (Exception e) {
			System.err.println("ConfigInfoError" + e.toString());
		}
		return properties;
	}

}
