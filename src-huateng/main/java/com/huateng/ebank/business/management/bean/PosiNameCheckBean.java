/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.management.bean;

/**
 *
 * @author haizhou.li
 * 岗位名称校验Bean
 */
public class PosiNameCheckBean {
   private String roleName;
   private String flag;
public String getOrgCode() {
	return roleName;
}
public void setOrgCode(String orgCode) {
	this.roleName = orgCode;
}
public String getFlag() {
	return flag;
}
public void setFlag(String flag) {
	this.flag = flag;
}

}