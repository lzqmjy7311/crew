package com.gbicc.company.single.outputentity;
// Generated 2016-1-15 16:51:03 by Hibernate Tools 3.2.2.GA



/**
 * TRewL02IndChangeDetailId generated by hbm2java
 */
public class L02  implements java.io.Serializable {

	private static final long serialVersionUID = -480594373265384412L;
	
	/*
    * ID.
    */
    private String id;
    /*
    * 变更事项.
    */
    private String itemName;
    /*
    * 变更前内容.
    */
    private String itemChBefore;
    /*
    * 变更后内容.
    */
    private String itemChAfter;
    /*
    * 变更日期.
    */
    private String itemChDate;
    /*
    * 关联基本信息主键.
    */
    private String baseId;
    /*
    * 预警表ID.
    */
    private String warnId;
    /*
    * 数据日期.
    */
    private String dataDt;

    public L02() {
    }

	/**
    * Get the ID
    */	
    public String getId() {
        return this.id;
    }
	/**
    * Set the ID
    */	
    public void setId(String id) {
        this.id = id;
    }
	/**
    * Get the 变更事项
    */	
    public String getItemName() {
        return this.itemName;
    }
	/**
    * Set the 变更事项
    */	
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
	/**
    * Get the 变更前内容
    */	
    public String getItemChBefore() {
        return this.itemChBefore;
    }
	/**
    * Set the 变更前内容
    */	
    public void setItemChBefore(String itemChBefore) {
        this.itemChBefore = itemChBefore;
    }
	/**
    * Get the 变更后内容
    */	
    public String getItemChAfter() {
        return this.itemChAfter;
    }
	/**
    * Set the 变更后内容
    */	
    public void setItemChAfter(String itemChAfter) {
        this.itemChAfter = itemChAfter;
    }
	/**
    * Get the 变更日期
    */	
    public String getItemChDate() {
        return this.itemChDate;
    }
	/**
    * Set the 变更日期
    */	
    public void setItemChDate(String itemChDate) {
        this.itemChDate = itemChDate;
    }
	/**
    * Get the 关联基本信息主键
    */	
    public String getBaseId() {
        return this.baseId;
    }
	/**
    * Set the 关联基本信息主键
    */	
    public void setBaseId(String baseId) {
        this.baseId = baseId;
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