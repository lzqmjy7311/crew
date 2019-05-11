package com.huateng.fp.demo.bean;

import com.huateng.fs.micro.demo.bean.Merchant;
import com.huateng.fs.micro.demo.bean.Purchase;

public class SwitchAddBean {
	private String version;
	private String xtype;
	private String xclass;
	private String pan;
	private Merchant merchant;
	private Purchase purchase;
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
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
}
