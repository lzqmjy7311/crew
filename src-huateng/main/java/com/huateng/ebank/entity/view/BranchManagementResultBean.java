package com.huateng.ebank.entity.view;

public class BranchManagementResultBean {

	private Integer id;
	private String brhNo;
	private String brhName;
	private String brhClass;
	private Integer blnUpBrhId;
	private String teleNo;
	private String address;
	private String postno;
	private String otherAreaFlag;
	private String ip;
	private String status;
	private String effectDate;
	private String expireDate;
	private String brhType;
	private String brhAttr;
	private String brhManageType;
	private Integer blnBrhNo;
	private String ubankNo;
	private Integer acctBrhId;
	private String acctBrhName;
	private String bopFinancOrgCode;
	private Integer lastUpdOperId;
	private String lastUpdTime;
	/** add by jornezhang 20091210 BMS-2334  增加票据系统多级机构管理模式 begin*/
	private Integer blnBrhRepNo;
	/** add by jornezhang 20091210 BMS-2334  增加票据系统多级机构管理模式 end*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrhNo() {
		return brhNo;
	}

	public void setBrhNo(String brhNo) {
		this.brhNo = brhNo;
	}

	public String getBrhName() {
		return brhName;
	}

	public void setBrhName(String brhName) {
		this.brhName = brhName;
	}

	public String getBrhClass() {
		return brhClass;
	}

	public void setBrhClass(String brhClass) {
		this.brhClass = brhClass;
	}

	public Integer getBlnUpBrhId() {
		return blnUpBrhId;
	}

	public void setBlnUpBrhId(Integer blnUpBrhId) {
		this.blnUpBrhId = blnUpBrhId;
	}

	public String getTeleNo() {
		return teleNo;
	}

	public void setTeleNo(String teleNo) {
		this.teleNo = teleNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostno() {
		return postno;
	}

	public void setPostno(String postno) {
		this.postno = postno;
	}

	public String getOtherAreaFlag() {
		return otherAreaFlag;
	}

	public void setOtherAreaFlag(String otherAreaFlag) {
		this.otherAreaFlag = otherAreaFlag;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getBrhType() {
		return brhType;
	}

	public void setBrhType(String brhType) {
		this.brhType = brhType;
	}

	public String getBrhAttr() {
		return brhAttr;
	}

	public void setBrhAttr(String brhAttr) {
		this.brhAttr = brhAttr;
	}

	public String getBrhManageType() {
		return brhManageType;
	}

	public void setBrhManageType(String brhManageType) {
		this.brhManageType = brhManageType;
	}



	public Integer getBlnBrhNo() {
		return blnBrhNo;
	}

	public void setBlnBrhNo(Integer blnBrhNo) {
		this.blnBrhNo = blnBrhNo;
	}

	public String getUbankNo() {
		return ubankNo;
	}

	public void setUbankNo(String ubankNo) {
		this.ubankNo = ubankNo;
	}

	public Integer getAcctBrhId() {
		return acctBrhId;
	}

	public void setAcctBrhId(Integer acctBrhId) {
		this.acctBrhId = acctBrhId;
	}

	public String getAcctBrhName() {
		return acctBrhName;
	}

	public void setAcctBrhName(String acctBrhName) {
		this.acctBrhName = acctBrhName;
	}

	public Integer getLastUpdOperId() {
		return lastUpdOperId;
	}

	public void setLastUpdOperId(Integer lastUpdOperId) {
		this.lastUpdOperId = lastUpdOperId;
	}

	public String getLastUpdTime() {
		return lastUpdTime;
	}

	public void setLastUpdTime(String lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	public String getBopFinancOrgCode() {
		return bopFinancOrgCode;
	}

	public void setBopFinancOrgCode(String bopFinancOrgCode) {
		this.bopFinancOrgCode = bopFinancOrgCode;
	}		
	/** add by jornezhang 20091210 BMS-2334  增加票据系统多级机构管理模式 begin*/
	public Integer getBlnBrhRepNo() {
		return blnBrhRepNo;
	}
	public void setBlnBrhRepNo(Integer blnBrhRepNo) {
		this.blnBrhRepNo = blnBrhRepNo;
	}
	/** add by jornezhang 20091210 BMS-2334  增加票据系统多级机构管理模式 end*/
}

