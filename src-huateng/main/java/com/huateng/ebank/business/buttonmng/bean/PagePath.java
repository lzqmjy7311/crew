package com.huateng.ebank.business.buttonmng.bean;

public class PagePath {
	
   private String pageName;
   private String pid;
   private String id;
   private boolean isDirectory;
   private String state;
    
public boolean isDirectory() {
	return isDirectory;
}
public void setDirectory(boolean isDirectory) {
	this.isDirectory = isDirectory;
}
public String getPageName() {
	return pageName;
}
public void setPageName(String pageName) {
	this.pageName = pageName;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
   
   
   
	
	
	
}
