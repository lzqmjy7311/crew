package com.huateng.ebank.business.management.bean;


import java.util.Date;

public class FunctionInfoBean {
	private String id;
	private String funcname;
	private String pagepath;
	private Integer location;
	private Integer isdirectory;
	private String lastdirectory;
	private Integer showseq;
	private String funcClass;
	private String funcType;
	private String workflowFlag;
	private String upFuncCode;
	private String funcDesc;
	private String status;
	private Date effectDate;
	private Date expireDate;
	private String timestamps;
	private String miscflgs;
	private String misc;
	private String iconCls;
	private String opr;	// ����/�޸ı�־
	public Date getEffectDate() {
		return effectDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}

	public String getFuncClass() {
		return funcClass;
	}
	public String getFuncDesc() {
		return funcDesc;
	}
	public String getFuncname() {
		return funcname;
	}
	public String getFuncType() {
		return funcType;
	}
	public String getIconCls() {
		return iconCls;
	}
	public String getId() {
		return id;
	}
	public Integer getIsdirectory() {
		return isdirectory;
	}
	public String getLastdirectory() {
		return lastdirectory;
	}
	public Integer getLocation() {
		return location;
	}
	public String getMisc() {
		return misc;
	}
	public String getMiscflgs() {
		return miscflgs;
	}
	/**
	 * @return the opr
	 */
	public String getOpr() {
		return opr;
	}
	public String getPagepath() {
		return pagepath;
	}
	public Integer getShowseq() {
		return showseq;
	}
	public String getStatus() {
		return status;
	}
	public String getTimestamps() {
		return timestamps;
	}
	public String getUpFuncCode() {
		return upFuncCode;
	}
	public String getWorkflowFlag() {
		return workflowFlag;
	}
	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public void setFuncClass(String funcClass) {
		this.funcClass = funcClass;
	}
	public void setFuncDesc(String funcDesc) {
		this.funcDesc = funcDesc;
	}
	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}
	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setIsdirectory(Integer isdirectory) {
		this.isdirectory = isdirectory;
	}
	public void setLastdirectory(String lastdirectory) {
		this.lastdirectory = lastdirectory;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	public void setMisc(String misc) {
		this.misc = misc;
	}
	public void setMiscflgs(String miscflgs) {
		this.miscflgs = miscflgs;
	}
	/**
	 * @param opr the opr to set
	 */
	public void setOpr(String opr) {
		this.opr = opr;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	public void setShowseq(Integer showseq) {
		this.showseq = showseq;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTimestamps(String timestamps) {
		this.timestamps = timestamps;
	}
	public void setUpFuncCode(String upFuncCode) {
		this.upFuncCode = upFuncCode;
	}
	public void setWorkflowFlag(String workflowFlag) {
		this.workflowFlag = workflowFlag;
	}

}
