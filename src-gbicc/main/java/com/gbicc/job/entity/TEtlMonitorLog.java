package com.gbicc.job.entity;

// Generated 2016-3-17 12:35:41 by Hibernate Tools 3.2.2.GA

/**
 * TEtlJobErrorLog generated by hbm2java
 */
public class TEtlMonitorLog implements java.io.Serializable {

	
	private static final long serialVersionUID = 698187014594937211L;

	
	public TEtlMonitorLog() {
	}

	/*
    */
	private String monitorLogID;
	/*
    */
	private String hostName;
	/*
    */
	private String etlID;
	
	/*
    */
	private String etlName;
	/*
    */
	private String dateTime;
	/*
    */
	private String result;
	/*
    */
	private String businessDate;

	

	public String getMonitorLogID() {
		return monitorLogID;
	}
	public void setMonitorLogID(String monitorLogID) {
		this.monitorLogID = monitorLogID;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getEtlID() {
		return etlID;
	}
	public void setEtlID(String etlID) {
		this.etlID = etlID;
	}
	public String getEtlName() {
		return etlName;
	}
	public void setEtlName(String etlName) {
		this.etlName = etlName;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	
}