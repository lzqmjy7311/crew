package com.gbicc.person.QualitySup.entity;

import java.io.Serializable;
import java.util.Date;

	/**
	 * @author kfc
	 * @time   2015年11月11日14:40:32
	 * @desc   质量监督参数维护表
	 */
	public class QualitySup implements Serializable {

		private static final long serialVersionUID = -2631760787710321156L;

		/*
		    * id.
		    */
		    private String id;
		    /*
		    * 预警优先级.
		    */
		    private String warnLevel;
		    /*
		    * 贷款账号.
		    */
		    private String loanAcct;
		    /*
		    * 客户名称.
		    */
		    private String custName;
		    /*
		    * 客户代码.
		    */
		    private String custCode;
		    /*
		    */
		    private String loanVariety;
		    /*
		    * 贷款金额.
		    */
		    private Double loanAmt;
		    /*
		    * 贷款余额.
		    */
		    private Double loanBalance;
		    /*
		    * 贷款期限.
		    */
		    private String loanTerm;
		    /*
		    * 状态.
		    */
		    private String rptStatus;
		    /*
		    * 任务到期日期.
		    */
		    private Date taskMatureDate;
		    /*
		    * 经办人.
		    */
		    private String handler;
		    /*
		    * 报告ID.
		    */
		    private String reportId;
		    /*
		    */
		    private String reportUrl;
		    /*
		    * 任务类型1、鑫风贷 2、鑫薪贷 3、鑫速贷 4、鑫享贷.
		    */
		    private String taskType;
		    /*
		    * 预警规则.
		    */
		    private String warnRule;
		    /*
		    * 预警描述.
		    */
		    private String warnDesc;
		    /*
		    * 产品名称.
		    */
		    private String productName;
		    /*
		    * 经办行.
		    */
		    private String bankname;
		    /*
		    */
		    private Double qualitysupperc;
		    /*
		    */
		    private Date startDate;
		    /*
		    */
		    private Date endDate;
		    
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public String getWarnLevel() {
				return warnLevel;
			}
			public void setWarnLevel(String warnLevel) {
				this.warnLevel = warnLevel;
			}
			public String getLoanAcct() {
				return loanAcct;
			}
			public void setLoanAcct(String loanAcct) {
				this.loanAcct = loanAcct;
			}
			public String getCustName() {
				return custName;
			}
			public void setCustName(String custName) {
				this.custName = custName;
			}
			public String getCustCode() {
				return custCode;
			}
			public void setCustCode(String custCode) {
				this.custCode = custCode;
			}
			public String getLoanVariety() {
				return loanVariety;
			}
			public void setLoanVariety(String loanVariety) {
				this.loanVariety = loanVariety;
			}
			public Double getLoanAmt() {
				return loanAmt;
			}
			public void setLoanAmt(Double loanAmt) {
				this.loanAmt = loanAmt;
			}
			public Double getLoanBalance() {
				return loanBalance;
			}
			public void setLoanBalance(Double loanBalance) {
				this.loanBalance = loanBalance;
			}
			public String getLoanTerm() {
				return loanTerm;
			}
			public void setLoanTerm(String loanTerm) {
				this.loanTerm = loanTerm;
			}
			public String getRptStatus() {
				return rptStatus;
			}
			public void setRptStatus(String rptStatus) {
				this.rptStatus = rptStatus;
			}
			public Date getTaskMatureDate() {
				return taskMatureDate;
			}
			public void setTaskMatureDate(Date taskMatureDate) {
				this.taskMatureDate = taskMatureDate;
			}
			public String getHandler() {
				return handler;
			}
			public void setHandler(String handler) {
				this.handler = handler;
			}
			public String getReportId() {
				return reportId;
			}
			public void setReportId(String reportId) {
				this.reportId = reportId;
			}
			public String getReportUrl() {
				return reportUrl;
			}
			public void setReportUrl(String reportUrl) {
				this.reportUrl = reportUrl;
			}
			public String getTaskType() {
				return taskType;
			}
			public void setTaskType(String taskType) {
				this.taskType = taskType;
			}
			public String getWarnRule() {
				return warnRule;
			}
			public void setWarnRule(String warnRule) {
				this.warnRule = warnRule;
			}
			public String getWarnDesc() {
				return warnDesc;
			}
			public void setWarnDesc(String warnDesc) {
				this.warnDesc = warnDesc;
			}
			public String getProductName() {
				return productName;
			}
			public void setProductName(String productName) {
				this.productName = productName;
			}
			public String getBankname() {
				return bankname;
			}
			public void setBankname(String bankname) {
				this.bankname = bankname;
			}
			public Double getQualitysupperc() {
				return qualitysupperc;
			}
			public void setQualitysupperc(Double qualitysupperc) {
				this.qualitysupperc = qualitysupperc;
			}
			public Date getStartDate() {
				return startDate;
			}
			public void setStartDate(Date startDate) {
				this.startDate = startDate;
			}
			public Date getEndDate() {
				return endDate;
			}
			public void setEndDate(Date endDate) {
				this.endDate = endDate;
			}
		
		
		
		
	}

