package com.gbicc.company.single.outputentity;
// Generated 2016-1-12 19:22:04 by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;

/**
 * TRewC08DepotManageListId generated by hbm2java
 */
public class C08  implements java.io.Serializable {

	private static final long serialVersionUID = 2949378779736814619L;
	
	/*
    */
    private String depotManageListId;
    /*
    */
    private String resNum;
    /*
    */
    private Integer resAmount;
    /*
    */
    private BigDecimal resSum;
    /*
    */
    private String contractNum;
    /*
    */
    private String borrowNum;
    /*
    */
    private String resOpType;
    /*
    */
    private String resOpDate;
    /*
    */
    private String resOpUser;
    /*
    */
    private String resOpOrg;
    /*
    */
    private String resOpState;
    /*
    */
    private String depotManageId;
    /*
    */
    private String resSummary;
    /*
    */
    private String resOpNum;
    /*
    * 预警表ID.
    */
    private String warnId;
    /*
    * 数据日期.
    */
    private String dataDt;

    public C08() {
    }

    public C08(String depotManageListId) {
        this.depotManageListId = depotManageListId;
    }
   
	/**
    */	
    public String getDepotManageListId() {
        return this.depotManageListId;
    }
	/**
    */	
    public void setDepotManageListId(String depotManageListId) {
        this.depotManageListId = depotManageListId;
    }
	/**
    */	
    public String getResNum() {
        return this.resNum;
    }
	/**
    */	
    public void setResNum(String resNum) {
        this.resNum = resNum;
    }
	/**
    */	
    public Integer getResAmount() {
        return this.resAmount;
    }
	/**
    */	
    public void setResAmount(Integer resAmount) {
        this.resAmount = resAmount;
    }
	/**
    */	
    public BigDecimal getResSum() {
        return this.resSum;
    }
	/**
    */	
    public void setResSum(BigDecimal resSum) {
        this.resSum = resSum;
    }
	/**
    */	
    public String getContractNum() {
        return this.contractNum;
    }
	/**
    */	
    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }
	/**
    */	
    public String getBorrowNum() {
        return this.borrowNum;
    }
	/**
    */	
    public void setBorrowNum(String borrowNum) {
        this.borrowNum = borrowNum;
    }
	/**
    */	
    public String getResOpType() {
        return this.resOpType;
    }
	/**
    */	
    public void setResOpType(String resOpType) {
        this.resOpType = resOpType;
    }
	/**
    */	
    public String getResOpDate() {
        return this.resOpDate;
    }
	/**
    */	
    public void setResOpDate(String resOpDate) {
        this.resOpDate = resOpDate;
    }
	/**
    */	
    public String getResOpUser() {
        return this.resOpUser;
    }
	/**
    */	
    public void setResOpUser(String resOpUser) {
        this.resOpUser = resOpUser;
    }
	/**
    */	
    public String getResOpOrg() {
        return this.resOpOrg;
    }
	/**
    */	
    public void setResOpOrg(String resOpOrg) {
        this.resOpOrg = resOpOrg;
    }
	/**
    */	
    public String getResOpState() {
        return this.resOpState;
    }
	/**
    */	
    public void setResOpState(String resOpState) {
        this.resOpState = resOpState;
    }
	/**
    */	
    public String getDepotManageId() {
        return this.depotManageId;
    }
	/**
    */	
    public void setDepotManageId(String depotManageId) {
        this.depotManageId = depotManageId;
    }
	/**
    */	
    public String getResSummary() {
        return this.resSummary;
    }
	/**
    */	
    public void setResSummary(String resSummary) {
        this.resSummary = resSummary;
    }
	/**
    */	
    public String getResOpNum() {
        return this.resOpNum;
    }
	/**
    */	
    public void setResOpNum(String resOpNum) {
        this.resOpNum = resOpNum;
    }
	/**
    * Get the 预警表ID
    */	
    public String getWarnId() {
        return this.warnId;
    }
	/**
    * Set the 预警表ID
    */	
    public void setWarnId(String warnId) {
        this.warnId = warnId;
    }
	/**
    * Get the 数据日期
    */	
    public String getDataDt() {
        return this.dataDt;
    }
	/**
    * Set the 数据日期
    */	
    public void setDataDt(String dataDt) {
        this.dataDt = dataDt;
    }
}