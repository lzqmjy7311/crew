package com.huateng.fs.micro.demo.bean;

import java.util.ArrayList;
import java.util.List;

/*
<Field id="version" type="RBS" desc="消息版本号" name="" length="20"  initValue="" xpath=""/>
<Field id="rspcode" type=RBS"" desc="应答码" name="" length="4"  initValue="" xpath=""/>
<Field id="rspmsg" type="RBS" desc="应带消息" name="" length="20"  initValue="" xpath=""/>
<Buffer id="Merchant" type="Buffer.Element.CERes_Merchant" desc="商户信息" name="CERes_merchant" >
<Field id="acqBIN" type="RBS" desc="acqBIN" name="Acquirer BIN" length="11"  initValue="" xpath=""/>
<Field id="merID" type="RBS" desc="merID" name="Merchant ID" length="24"  initValue="" xpath=""/>
<Field id="password" type="RBS" desc="password" name="Merchant.password" length="8"  initValue="" xpath=""/>
<Field id="name" type="RBS" desc="name" name="Merchant.name" length="25" initValue="" xpath=""/>
<Field id="country" type="RBS" desc="country" name="Merchant.country" length="3" initValue="" xpath=""/>
</Buffer> 
 */
public class TestOutputBean {
	private String version;
	private String rspcode;
	private String rspmsg;
	private List<Purchase> array = new ArrayList<Purchase>();
	
	public List<Purchase> getArray() {
		return array;
	}

	public void setArray(List<Purchase> array) {
		this.array = array;
	}

	private Merchant merchant;

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

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	
	

}
