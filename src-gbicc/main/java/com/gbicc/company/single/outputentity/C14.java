package com.gbicc.company.single.outputentity;
// Generated 2016-1-12 19:22:04 by Hibernate Tools 3.2.2.GA



/**
 * TRewC14CorpGcircleId generated by hbm2java
 */
public class C14  implements java.io.Serializable {

	private static final long serialVersionUID = -3700644845705232060L;
	
	/*
    */
    private String customerNum;
    /*
    */
    private String gcircleCd;
    /*
    */
    private String gcCustIdTpCd;
    /*
    */
    private String gcCustIdNum;
    /*
    */
    private String gcCustTpCd;
    /*
    */
    private String gcCustNum;
    /*
    */
    private String gcCustCoreNum;
    /*
    */
    private String id;
    /*
    * 预警表ID.
    */
    private String warnId;
    /*
    * 数据日期.
    */
    private String dataDt;

    public C14() {
    }

	/**
    */	
    public String getCustomerNum() {
        return this.customerNum;
    }
	/**
    */	
    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }
	/**
    */	
    public String getGcircleCd() {
        return this.gcircleCd;
    }
	/**
    */	
    public void setGcircleCd(String gcircleCd) {
        this.gcircleCd = gcircleCd;
    }
	/**
    */	
    public String getGcCustIdTpCd() {
        return this.gcCustIdTpCd;
    }
	/**
    */	
    public void setGcCustIdTpCd(String gcCustIdTpCd) {
        this.gcCustIdTpCd = gcCustIdTpCd;
    }
	/**
    */	
    public String getGcCustIdNum() {
        return this.gcCustIdNum;
    }
	/**
    */	
    public void setGcCustIdNum(String gcCustIdNum) {
        this.gcCustIdNum = gcCustIdNum;
    }
	/**
    */	
    public String getGcCustTpCd() {
        return this.gcCustTpCd;
    }
	/**
    */	
    public void setGcCustTpCd(String gcCustTpCd) {
        this.gcCustTpCd = gcCustTpCd;
    }
	/**
    */	
    public String getGcCustNum() {
        return this.gcCustNum;
    }
	/**
    */	
    public void setGcCustNum(String gcCustNum) {
        this.gcCustNum = gcCustNum;
    }
	/**
    */	
    public String getGcCustCoreNum() {
        return this.gcCustCoreNum;
    }
	/**
    */	
    public void setGcCustCoreNum(String gcCustCoreNum) {
        this.gcCustCoreNum = gcCustCoreNum;
    }
	/**
    */	
    public String getId() {
        return this.id;
    }
	/**
    */	
    public void setId(String id) {
        this.id = id;
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