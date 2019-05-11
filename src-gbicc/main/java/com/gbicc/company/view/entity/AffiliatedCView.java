package com.gbicc.company.view.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the AFFILIATED_C_VIEW database table.
 * 
 */
public class AffiliatedCView implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal advanceBalance;
	private String affiCustNum;
	private String affiTpCd;
	private String businessLicenseNum;
	private String custname;
	private String customerNum;
	private String foundedDate;
	private Integer outstandingAdvanceCount;
	private BigDecimal registeredCapital;

	public AffiliatedCView() {
	}


	public BigDecimal getAdvanceBalance() {
		return this.advanceBalance;
	}

	public void setAdvanceBalance(BigDecimal advanceBalance) {
		this.advanceBalance = advanceBalance;
	}

	public String getAffiTpCd() {
		return this.affiTpCd;
	}

	public void setAffiTpCd(String affiTpCd) {
		this.affiTpCd = affiTpCd;
	}


	public String getBusinessLicenseNum() {
		return this.businessLicenseNum;
	}

	public void setBusinessLicenseNum(String businessLicenseNum) {
		this.businessLicenseNum = businessLicenseNum;
	}


	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}


	public String getCustomerNum() {
		return this.customerNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}


	public String getFoundedDate() {
		return this.foundedDate;
	}

	public void setFoundedDate(String foundedDate) {
		this.foundedDate = foundedDate;
	}


	public Integer getOutstandingAdvanceCount() {
		return this.outstandingAdvanceCount;
	}

	public void setOutstandingAdvanceCount(Integer outstandingAdvanceCount) {
		this.outstandingAdvanceCount = outstandingAdvanceCount;
	}


	public BigDecimal getRegisteredCapital() {
		return this.registeredCapital;
	}

	public void setRegisteredCapital(BigDecimal registeredCapital) {
		this.registeredCapital = registeredCapital;
	}


	public String getAffiCustNum() {
		return affiCustNum;
	}


	public void setAffiCustNum(String affiCustNum) {
		this.affiCustNum = affiCustNum;
	}

}