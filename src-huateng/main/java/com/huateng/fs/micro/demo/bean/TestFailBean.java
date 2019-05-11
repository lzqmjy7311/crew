package com.huateng.fs.micro.demo.bean;

/*
 <?xml version="1.0" encoding="UTF-8"?>
<Buffer id="Error" type="Buffer.sample.Error" name="Error" desc="错误消息">
	<Field id="version" type="string" desc="消息版本号" name="version" length="20"  initValue=""/>
	<Field id="errorCode" type="string" desc="错误代码" name="errorCode" length="2" initValue=""/>
	<Field id="errorMessage" type="string" desc="错误描述" name="errorMessage" length="2048" initValue="" />
	<Field id="errorDetail" type="string" desc="错误详细描述" name="errorDetail" length="2048" initValue=""/>
</Buffer>
 */
public class TestFailBean {

	private String version;
	private String rspcode;
	private String rspmsg;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getRspcode() {
		return rspcode;
	}
	public void setRspcode(String rspcode) {
		this.rspcode = rspcode;
	}
	public String getRspmsg() {
		return rspmsg;
	}
	public void setRspmsg(String rspmsg) {
		this.rspmsg = rspmsg;
	}
	
	
}
