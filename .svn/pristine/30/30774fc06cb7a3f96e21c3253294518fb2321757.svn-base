package com.huateng.fs.micro.demo.bean;

import java.util.ArrayList;
import java.util.List;

/*
	<Field id="version" type="RBS" desc="消息版本号" name="version" length="20"  initValue="" xpath=""/>
	<Field id="xtype" type="RBS" desc="交易类型" name="xtype" length="2" xpath=""/>
	<Field id="xclass" type="RBS" desc="交易类别" name="xclass" length="1" xpath=""/>
	<Field id="pan" type="RBS" desc="卡号" name="pan" length="19" xpath=""/>
    <Buffer id="Merchant" type="Buffer.Element.CERes_Merchant" desc="商户信息" name="CERes_merchant" >
		<Field id="acqBIN" type="RBS" desc="acqBIN" name="Acquirer BIN" length="11"  initValue="" xpath="/merchant/accqBIN"/>
		<Field id="merID" type="RBS" desc="merID" name="Merchant ID" length="24"  initValue="" xpath="/merchant/merID"/>
		<Field id="password" type="RBS" desc="password" name="Merchant.password" length="8"  initValue="" xpath="/merchant/password"/>
		<Field id="name" type="RBS" desc="name" name="Merchant.name" length="25" initValue="" xpath="/merchant/name"/>
		<Field id="country" type="RBS" desc="country" name="Merchant.country" length="3" initValue="" xpath="/merchant/country"/>
	</Buffer>
	<Array id="array" desc="数组List" name="array" xpath="">
		<Buffer id="Purchase" desc="交易信息" name="CEReq_Purchase" xpath="">
			<Field id="purchAmount" type="LZN" desc="交易金额" name="" length="12" xpath="" />
			<Field id="currency" type="RBS" desc="交易币种" name="" length="3" xpath="" />
			<Field id="exponent" type="RBS" desc="货币指数" name="" length="1" xpath="" />
			<Field id="trsFeeAmount" type="LZN" desc="交易手续费" name="" length="9" xpath="" />
		</Buffer>
	</Array>
 */
public class TestInputBean {

	private String version;
	private String xtype;
	private String xclass;
	private String pan;
	private Merchant merchant;
	private List<Purchase> array = new ArrayList<Purchase>();
	
	private String testAttr;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getXtype() {
		return xtype;
	}
	public void setXtype(String xtype) {
		this.xtype = xtype;
	}
	public String getXclass() {
		return xclass;
	}
	public void setXclass(String xclass) {
		this.xclass = xclass;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public List<Purchase> getArray() {
		return array;
	}
	public void setArray(List<Purchase> array) {
		this.array = array;
	}
	public String getTestAttr() {
		return testAttr;
	}
	public void setTestAttr(String testAttr) {
		this.testAttr = testAttr;
	}
	
	
	
}
