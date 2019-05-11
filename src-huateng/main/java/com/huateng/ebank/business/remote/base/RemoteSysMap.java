package com.huateng.ebank.business.remote.base;

import java.util.ResourceBundle;

public class RemoteSysMap {

	
	private static final String BUNDLE_NAME = "remoteAppConfig"; //外系统名称-地址配置
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public static  String getValue(String key){
		return RESOURCE_BUNDLE.getString(key);
	}
	
	public static void main(String arg[]){
		System.out.println(RemoteSysMap.getValue("111"));
	}
}
