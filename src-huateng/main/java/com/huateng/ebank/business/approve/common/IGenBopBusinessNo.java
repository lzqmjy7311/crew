package com.huateng.ebank.business.approve.common;

import java.util.Map;

import com.huateng.ebank.framework.exceptions.CommonException;

public interface IGenBopBusinessNo {
	public static final String BUSI_TYPE = "BUSI_TYPE";
	public static final String APP_TYPE = "APP_TYPE";
	public static final String WORK_DATE = "WORK_DATE";
	public static final String BUSINSESS_NO = "BUSINSESS_NO";
	public static final String PARAM_VALUE = "PARAM_VALUE";
	public static final String OBJECT_BEAN = "OBJECT_BEAN";
	public static final String FILE_TYPE = "FILE_TYPE";
	public static final String CUS_TYPE = "CUS_TYPE";


	public void updateBopBusiNo(Map<String, Object> paramMap) throws CommonException;
}
