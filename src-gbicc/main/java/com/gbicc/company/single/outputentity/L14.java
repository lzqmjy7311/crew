package com.gbicc.company.single.outputentity;
// Generated 2016-1-15 16:51:03 by Hibernate Tools 3.2.2.GA



/**
 * TRewL14BlacklistInfoId generated by hbm2java
 */
public class L14  implements java.io.Serializable {

	private static final long serialVersionUID = -4107285606897320389L;
	
	/*
    */
    private String blacklistId;
    /*
    */
    private String blacklistCustomerName;
    /*
    */
    private String blacklistOrgnCd;
    /*
    */
    private String putinCause;
    /*
    */
    private String putinTime;
    /*
    */
    private String fstBankName;
    /*
    */
    private String userNum;
    /*
    */
    private String blackTypeCd;
    /*
    */
    private String blackCustomerTypeCd;
    /*
    * 预警表ID.
    */
    private String fdWarnId;
    /*
    * 数据日期.
    */
    private String fdDataDt;

    public L14() {
    }

	/**
    */	
    public String getBlacklistId() {
        return this.blacklistId;
    }
	/**
    */	
    public void setBlacklistId(String blacklistId) {
        this.blacklistId = blacklistId;
    }
	/**
    */	
    public String getBlacklistCustomerName() {
        return this.blacklistCustomerName;
    }
	/**
    */	
    public void setBlacklistCustomerName(String blacklistCustomerName) {
        this.blacklistCustomerName = blacklistCustomerName;
    }
	/**
    */	
    public String getBlacklistOrgnCd() {
        return this.blacklistOrgnCd;
    }
	/**
    */	
    public void setBlacklistOrgnCd(String blacklistOrgnCd) {
        this.blacklistOrgnCd = blacklistOrgnCd;
    }
	/**
    */	
    public String getPutinCause() {
        return this.putinCause;
    }
	/**
    */	
    public void setPutinCause(String putinCause) {
        this.putinCause = putinCause;
    }
	/**
    */	
    public String getPutinTime() {
        return this.putinTime;
    }
	/**
    */	
    public void setPutinTime(String putinTime) {
        this.putinTime = putinTime;
    }
	/**
    */	
    public String getFstBankName() {
        return this.fstBankName;
    }
	/**
    */	
    public void setFstBankName(String fstBankName) {
        this.fstBankName = fstBankName;
    }
	/**
    */	
    public String getUserNum() {
        return this.userNum;
    }
	/**
    */	
    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }
	/**
    */	
    public String getBlackTypeCd() {
        return this.blackTypeCd;
    }
	/**
    */	
    public void setBlackTypeCd(String blackTypeCd) {
        this.blackTypeCd = blackTypeCd;
    }
	/**
    */	
    public String getBlackCustomerTypeCd() {
        return this.blackCustomerTypeCd;
    }
	/**
    */	
    public void setBlackCustomerTypeCd(String blackCustomerTypeCd) {
        this.blackCustomerTypeCd = blackCustomerTypeCd;
    }
	/**
    * Get the 预警表ID
    */	
    public String getFdWarnId() {
        return this.fdWarnId;
    }
	/**
    * Set the 预警表ID
    */	
    public void setFdWarnId(String warnId) {
        this.fdWarnId = warnId;
    }
	/**
    * Get the 数据日期
    */	
    public String getFdDataDt() {
        return this.fdDataDt;
    }
	/**
    * Set the 数据日期
    */	
    public void setFdDataDt(String dataDt) {
        this.fdDataDt = dataDt;
    }
}