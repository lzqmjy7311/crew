package com.gbicc.person.importtext.entity;


public class TOdsOutEiaIllInfoId  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
    * 编号.
    */
    private String id;
    /*
    * 被处罚单位名称.
    */
    private String custName;
    /*
    * 违法行为类别.
    */
    private String lawType;
    /*
    * 处罚措施.
    */
    private String dealResult;
    /*
    * 作出处罚单位名称.
    */
    private String dealOrg;
    /*
    * 处罚决定作出时间.
    */
    private String dealDate;
    /*
    * 组织机构代码.
    */
    private String custOrgCode;
    /*
    * 地址.
    */
    private String custAddress;
    /*
    * 处罚依据.
    */
    private String lawContent;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getLawType() {
		return lawType;
	}
	public void setLawType(String lawType) {
		this.lawType = lawType;
	}
	public String getDealResult() {
		return dealResult;
	}
	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}
	public String getDealOrg() {
		return dealOrg;
	}
	public void setDealOrg(String dealOrg) {
		this.dealOrg = dealOrg;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getCustOrgCode() {
		return custOrgCode;
	}
	public void setCustOrgCode(String custOrgCode) {
		this.custOrgCode = custOrgCode;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getLawContent() {
		return lawContent;
	}
	public void setLawContent(String lawContent) {
		this.lawContent = lawContent;
	}

}
