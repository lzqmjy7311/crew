package com.huateng.ebank.business.approve.bean;

public class AnalyDataProcessCountBean {
	private String appType;
	private String fileType;
	private int count;

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public AnalyDataProcessCountBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnalyDataProcessCountBean(String appType, String fileType, int count) {
		super();
		this.appType = appType;
		this.fileType = fileType;
		this.count = count;
	}

}
