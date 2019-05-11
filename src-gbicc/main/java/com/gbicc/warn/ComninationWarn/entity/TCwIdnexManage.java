package com.gbicc.warn.ComninationWarn.entity;
// Generated 2015-12-31 9:36:10 by Hibernate Tools 3.2.2.GA


import java.util.Date;

/**
 * TCwIdnexManage generated by hbm2java
 */
public class TCwIdnexManage  implements java.io.Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
    */
    private String id;
    /*
    * 指标编号.
    */
    private String indexCode;
    /*
    * 指标名称.
    */
    private String indexName;
    /*
    * 指标分类.
    */
    private String indexType;
    /*
    * 展示类型.
    */
    private String gatherType;
    /*
    * 监测频率.
    */
    private String monitorRpe;
    /*
    * 阀值1.
    */
    private Double threshold1;
    /*
    * 阀值2.
    */
    private Double threshold2;
    /*
    * 创建人.
    */
    private String creditUser;
    /*
    * 跟新人.
    */
    private String updateUser;
    /*
    * 修改日期.
    */
    private Date updateed;
    /*
    * 创建日期.
    */
    private Date credited;
    /*
    * 指标类型（1递增，0递减）.
    */
    private String indexType2;
    /*
    */
    private String thresholdVersion;
    /*
    */
    private String zbDescripe;
    /*
     * 指标维度
     */
    private String gatherTypeHave;
    
    public TCwIdnexManage() {
    }

	
    public TCwIdnexManage(String id, String indexCode) {
        this.id = id;
        this.indexCode = indexCode;
    }
    public TCwIdnexManage(String id, String indexCode, String indexName, String indexType, String gatherType, String monitorRpe, Double threshold1, Double threshold2, String creditUser, String updateUser, Date updateed, Date credited, String indexType2, String thresholdVersion, String zbDescripe, String gatherTypeHave) {
       this.id = id;
       this.indexCode = indexCode;
       this.indexName = indexName;
       this.indexType = indexType;
       this.gatherType = gatherType;
       this.monitorRpe = monitorRpe;
       this.threshold1 = threshold1;
       this.threshold2 = threshold2;
       this.creditUser = creditUser;
       this.updateUser = updateUser;
       this.updateed = updateed;
       this.credited = credited;
       this.indexType2 = indexType2;
       this.thresholdVersion = thresholdVersion;
       this.zbDescripe = zbDescripe;
       this.gatherTypeHave = gatherTypeHave;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getIndexCode() {
        return this.indexCode;
    }
    
    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }
    public String getIndexName() {
        return this.indexName;
    }
    
    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
    public String getIndexType() {
        return this.indexType;
    }
    
    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }
    public String getGatherType() {
        return this.gatherType;
    }
    
    public void setGatherType(String gatherType) {
        this.gatherType = gatherType;
    }
    public String getMonitorRpe() {
        return this.monitorRpe;
    }
    
    public void setMonitorRpe(String monitorRpe) {
        this.monitorRpe = monitorRpe;
    }
    public Double getThreshold1() {
        return this.threshold1;
    }
    
    public void setThreshold1(Double threshold1) {
        this.threshold1 = threshold1;
    }
    public Double getThreshold2() {
        return this.threshold2;
    }
    
    public void setThreshold2(Double threshold2) {
        this.threshold2 = threshold2;
    }
    public String getCreditUser() {
        return this.creditUser;
    }
    
    public void setCreditUser(String creditUser) {
        this.creditUser = creditUser;
    }
    public String getUpdateUser() {
        return this.updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    public Date getUpdateed() {
        return this.updateed;
    }
    
    public void setUpdateed(Date updateed) {
        this.updateed = updateed;
    }
    public Date getCredited() {
        return this.credited;
    }
    
    public void setCredited(Date credited) {
        this.credited = credited;
    }
    public String getIndexType2() {
        return this.indexType2;
    }
    
    public void setIndexType2(String indexType2) {
        this.indexType2 = indexType2;
    }
    public String getThresholdVersion() {
        return this.thresholdVersion;
    }
    
    public void setThresholdVersion(String thresholdVersion) {
        this.thresholdVersion = thresholdVersion;
    }
    public String getZbDescripe() {
        return this.zbDescripe;
    }
    
    public void setZbDescripe(String zbDescripe) {
        this.zbDescripe = zbDescripe;
    }


	public String getGatherTypeHave() {
		return gatherTypeHave;
	}


	public void setGatherTypeHave(String gatherTypeHave) {
		this.gatherTypeHave = gatherTypeHave;
	}




}

