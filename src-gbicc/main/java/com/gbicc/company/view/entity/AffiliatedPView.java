package com.gbicc.company.view.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the AFFILIATED_P_VIEW database table.
 * 
 */
public class AffiliatedPView implements Serializable {
	private static final long serialVersionUID = 1L;
	private String affiCustCoreNum;
	private String affiTpCd;
	private String custname;
	private String customerNum;
	private String affiCustNum;
	private String highestEduTpCd;
	private BigDecimal loanBalance;
	private String refNum;
	private String residential;
	private Integer unpaidCount;
	private String creditLevel;

	public AffiliatedPView() {
	}


	public String getAffiCustCoreNum() {
		return this.affiCustCoreNum;
	}

	public void setAffiCustCoreNum(String affiCustCoreNum) {
		this.affiCustCoreNum = affiCustCoreNum;
	}


	public String getAffiTpCd() {
		return this.affiTpCd;
	}

	public void setAffiTpCd(String affiTpCd) {
		this.affiTpCd = affiTpCd;
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


	public String getHighestEduTpCd() {
		return this.highestEduTpCd;
	}

	public void setHighestEduTpCd(String highestEduTpCd) {
		this.highestEduTpCd = highestEduTpCd;
	}


	public BigDecimal getLoanBalance() {
		return this.loanBalance;
	}

	public void setLoanBalance(BigDecimal loanBalance) {
		this.loanBalance = loanBalance;
	}


	public String getRefNum() {
		return this.refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}


	public String getResidential() {
		return this.residential;
	}

	public void setResidential(String residential) {
		this.residential = residential;
	}


	public Integer getUnpaidCount() {
		return this.unpaidCount;
	}

	public void setUnpaidCount(Integer unpaidCount) {
		this.unpaidCount = unpaidCount;
	}


	public String getAffiCustNum() {
		return affiCustNum;
	}


	public void setAffiCustNum(String affiCustNum) {
		this.affiCustNum = affiCustNum;
	}


	public String getCreditLevel() {
		return creditLevel;
	}


	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}

}