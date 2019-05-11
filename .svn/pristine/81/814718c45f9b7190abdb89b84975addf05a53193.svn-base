package com.gbicc.bpm;

import java.util.Map;

/**
 * 
 * @date    2015年11月18日
 * @author  tangdu
 * @desc
 */
public class BpmDescUtil {

	private static final String tpl = "业务ID:${businessID},贷款账号:${custCode},客户名称:${custName}";

	public static String getDesc(String businessID, String custCode,
			String custName) {
		if(businessID==null){
			businessID="";
		}
		if(custCode==null){
			custCode="";
		}
		if(custName==null){
			custName="";
		}
		String _tpl = tpl;
		_tpl = _tpl.replace("${businessID}", businessID);
		_tpl = _tpl.replace("${custCode}", custCode);
		_tpl = _tpl.replace("${custName}", custName);
		return _tpl;
	}

	public static String getDesc(Map<String, String> params) {
		String _tpl = tpl;
		_tpl = _tpl.replace("${businessID}", params.get("businessID"));
		_tpl = _tpl.replace("${custCode}", params.get("custCode"));
		_tpl = _tpl.replace("${custName}", params.get("custName"));
		return _tpl;
	}

	public static void main(String[] args) {
		System.out.println(getDesc("ddd", "张d ", "ddddd"));
	}
}
