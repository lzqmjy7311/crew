package com.gbicc.job.entity;
// Generated 2016-3-17 12:35:41 by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * TPubRulExecuteLog generated by hbm2java
 */
public class TPubRulExecuteLog  implements java.io.Serializable {


    /*
    */
    private String execId;
    /*
    * 规则日期.
    */
    private String ruleId;
    /*
    * 规则编号.
    */
    private String ruleCode;
    /*
    * 开始日期.
    */
    private Date startTime;
    /*
    * 结束日期.
    */
    private Date endTime;
    /*
    * 执行时间 .
    */
    private BigDecimal execTime;
    /*
    * 执行标识:1成功 0失败.
    */
    private String isSuccess;
    /*
    * 500.
    */
    private String errorMsg;
    /*
    * 数据日期(yyyymmdd).
    */
    private String rowDate;

    public TPubRulExecuteLog() {
    }

	
    public TPubRulExecuteLog(String execId, String ruleId, String ruleCode, String isSuccess) {
        this.execId = execId;
        this.ruleId = ruleId;
        this.ruleCode = ruleCode;
        this.isSuccess = isSuccess;
    }
    public TPubRulExecuteLog(String execId, String ruleId, String ruleCode, Date startTime, Date endTime, BigDecimal execTime, String isSuccess, String errorMsg, String rowDate) {
       this.execId = execId;
       this.ruleId = ruleId;
       this.ruleCode = ruleCode;
       this.startTime = startTime;
       this.endTime = endTime;
       this.execTime = execTime;
       this.isSuccess = isSuccess;
       this.errorMsg = errorMsg;
       this.rowDate = rowDate;
    }
   
	/**
    */	
    public String getExecId() {
        return this.execId;
    }
	/**
    */	
    public void setExecId(String execId) {
        this.execId = execId;
    }
	/**
    * Get the 规则日期
    */	
    public String getRuleId() {
        return this.ruleId;
    }
	/**
    * Set the 规则日期
    */	
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
	/**
    * Get the 规则编号
    */	
    public String getRuleCode() {
        return this.ruleCode;
    }
	/**
    * Set the 规则编号
    */	
    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }
	/**
    * Get the 开始日期
    */	
    public Date getStartTime() {
        return this.startTime;
    }
	/**
    * Set the 开始日期
    */	
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
	/**
    * Get the 结束日期
    */	
    public Date getEndTime() {
        return this.endTime;
    }
	/**
    * Set the 结束日期
    */	
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
	/**
    * Get the 执行时间 
    */	
    public BigDecimal getExecTime() {
        return this.execTime;
    }
	/**
    * Set the 执行时间 
    */	
    public void setExecTime(BigDecimal execTime) {
        this.execTime = execTime;
    }
	/**
    * Get the 执行标识:1成功 0失败
    */	
    public String getIsSuccess() {
        return this.isSuccess;
    }
	/**
    * Set the 执行标识:1成功 0失败
    */	
    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }
	/**
    * Get the 500
    */	
    public String getErrorMsg() {
        return this.errorMsg;
    }
	/**
    * Set the 500
    */	
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
	/**
    * Get the 数据日期(yyyymmdd)
    */	
    public String getRowDate() {
        return this.rowDate;
    }
	/**
    * Set the 数据日期(yyyymmdd)
    */	
    public void setRowDate(String rowDate) {
        this.rowDate = rowDate;
    }




}


