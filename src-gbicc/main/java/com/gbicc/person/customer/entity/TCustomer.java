package com.gbicc.person.customer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author xudongdong
 *
 * 版本：2015年10月21日 上午10:23:21
 * 类说明：客户管理实体
 */
public class TCustomer implements Serializable {

	private static final long serialVersionUID = -2631760787710321152L;

	
	/*
	    */
	    private String productCode;
	    /*
	    */
	    private String loanAccount;
	    /*
	    */
	    private String custCode;
	    /*
	    */
	    private String custName;
	    /*
	    */
	    private BigDecimal loanAmount;
	    /*
	    */
	    private BigDecimal loanBalance;
	    /*
	    */
	    private BigDecimal floatinterate;
	    /*
	    */
	    private Integer loanPeriod;
	    /*
	    */
	    private String operator;
	    /*
	    */
	    private String operBank;
	    /*
	    */
	    private String paperkind;
	    /*
	    */
	    private String paperid;
	    /*
	    */
	    private Date birtdate;
	    /*
	    */
	    private String sexsign;
	    /*
	    */
	    private String mobilecall;
	    /*
	    */
	    private String workcorpid;
	    /*
	    */
	    private String workcorp;
	    /*
	    */
	    private String corpaddr;
	    /*
	    */
	    private String waykind;
	    /*
	    */
	    private BigDecimal yearinco;
	    /*
	    */
	    private BigDecimal balance;
	    /*
	    */
	    private BigDecimal amSalaryLast2M;
	    /*
	    */
	    private BigDecimal amSalaryLastM;
	    /*
	    */
	    private BigDecimal amPaymentLast2M;
	    /*
	    */
	    private BigDecimal amPaymentLastM;
	    /*
	    */
	    private String status;
	    /*
	    */
	    private Date statusDate;
	    /*
	    */
	    private Integer overCountMaxHis;
	    /*
	    */
	    private Integer unpaidCount;
	    /*
	    */
	    private String marrsign;
	    /*
	    */
	    private String educsign;
	    /*
	    */
	    private String degreesign;
	    /*
	    */
	    private String vocasign;
	    /*
	    */
	    private String natisign2;
	    /*
	    */
	    private String nativeplace;
	    /*
	    */
	    private String natisign1;
	    /*
	    */
	    private String natiflag;
	    /*
	    */
	    private String reginatu;
	    /*
	    */
	    private String contaddr;
	    /*
	    */
	    private String workyearmonth;
		public String getProductCode() {
			return productCode;
		}
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
		public String getLoanAccount() {
			return loanAccount;
		}
		public void setLoanAccount(String loanAccount) {
			this.loanAccount = loanAccount;
		}
		public String getCustCode() {
			return custCode;
		}
		public void setCustCode(String custCode) {
			this.custCode = custCode;
		}
		public String getCustName() {
			return custName;
		}
		public void setCustName(String custName) {
			this.custName = custName;
		}
		public BigDecimal getLoanAmount() {
			return loanAmount;
		}
		public void setLoanAmount(BigDecimal loanAmount) {
			this.loanAmount = loanAmount;
		}
		public BigDecimal getLoanBalance() {
			return loanBalance;
		}
		public void setLoanBalance(BigDecimal loanBalance) {
			this.loanBalance = loanBalance;
		}
		public BigDecimal getFloatinterate() {
			return floatinterate;
		}
		public void setFloatinterate(BigDecimal floatinterate) {
			this.floatinterate = floatinterate;
		}
		public Integer getLoanPeriod() {
			return loanPeriod;
		}
		public void setLoanPeriod(Integer loanPeriod) {
			this.loanPeriod = loanPeriod;
		}
		public String getOperator() {
			return operator;
		}
		public void setOperator(String operator) {
			this.operator = operator;
		}
		public String getOperBank() {
			return operBank;
		}
		public void setOperBank(String operBank) {
			this.operBank = operBank;
		}
		public String getPaperkind() {
			return paperkind;
		}
		public void setPaperkind(String paperkind) {
			this.paperkind = paperkind;
		}
		public String getPaperid() {
			return paperid;
		}
		public void setPaperid(String paperid) {
			this.paperid = paperid;
		}
		public Date getBirtdate() {
			return birtdate;
		}
		public void setBirtdate(Date birtdate) {
			this.birtdate = birtdate;
		}
		public String getSexsign() {
			return sexsign;
		}
		public void setSexsign(String sexsign) {
			this.sexsign = sexsign;
		}
		public String getMobilecall() {
			return mobilecall;
		}
		public void setMobilecall(String mobilecall) {
			this.mobilecall = mobilecall;
		}
		public String getWorkcorpid() {
			return workcorpid;
		}
		public void setWorkcorpid(String workcorpid) {
			this.workcorpid = workcorpid;
		}
		public String getWorkcorp() {
			return workcorp;
		}
		public void setWorkcorp(String workcorp) {
			this.workcorp = workcorp;
		}
		public String getCorpaddr() {
			return corpaddr;
		}
		public void setCorpaddr(String corpaddr) {
			this.corpaddr = corpaddr;
		}
		public String getWaykind() {
			return waykind;
		}
		public void setWaykind(String waykind) {
			this.waykind = waykind;
		}
		public BigDecimal getYearinco() {
			return yearinco;
		}
		public void setYearinco(BigDecimal yearinco) {
			this.yearinco = yearinco;
		}
		public BigDecimal getBalance() {
			return balance;
		}
		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}
		public BigDecimal getAmSalaryLast2M() {
			return amSalaryLast2M;
		}
		public void setAmSalaryLast2M(BigDecimal amSalaryLast2M) {
			this.amSalaryLast2M = amSalaryLast2M;
		}
		public BigDecimal getAmSalaryLastM() {
			return amSalaryLastM;
		}
		public void setAmSalaryLastM(BigDecimal amSalaryLastM) {
			this.amSalaryLastM = amSalaryLastM;
		}
		public BigDecimal getAmPaymentLast2M() {
			return amPaymentLast2M;
		}
		public void setAmPaymentLast2M(BigDecimal amPaymentLast2M) {
			this.amPaymentLast2M = amPaymentLast2M;
		}
		public BigDecimal getAmPaymentLastM() {
			return amPaymentLastM;
		}
		public void setAmPaymentLastM(BigDecimal amPaymentLastM) {
			this.amPaymentLastM = amPaymentLastM;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Date getStatusDate() {
			return statusDate;
		}
		public void setStatusDate(Date statusDate) {
			this.statusDate = statusDate;
		}
		public Integer getOverCountMaxHis() {
			return overCountMaxHis;
		}
		public void setOverCountMaxHis(Integer overCountMaxHis) {
			this.overCountMaxHis = overCountMaxHis;
		}
		public Integer getUnpaidCount() {
			return unpaidCount;
		}
		public void setUnpaidCount(Integer unpaidCount) {
			this.unpaidCount = unpaidCount;
		}
		public String getMarrsign() {
			return marrsign;
		}
		public void setMarrsign(String marrsign) {
			this.marrsign = marrsign;
		}
		public String getEducsign() {
			return educsign;
		}
		public void setEducsign(String educsign) {
			this.educsign = educsign;
		}
		public String getDegreesign() {
			return degreesign;
		}
		public void setDegreesign(String degreesign) {
			this.degreesign = degreesign;
		}
		public String getVocasign() {
			return vocasign;
		}
		public void setVocasign(String vocasign) {
			this.vocasign = vocasign;
		}
		public String getNatisign2() {
			return natisign2;
		}
		public void setNatisign2(String natisign2) {
			this.natisign2 = natisign2;
		}
		public String getNativeplace() {
			return nativeplace;
		}
		public void setNativeplace(String nativeplace) {
			this.nativeplace = nativeplace;
		}
		public String getNatisign1() {
			return natisign1;
		}
		public void setNatisign1(String natisign1) {
			this.natisign1 = natisign1;
		}
		public String getNatiflag() {
			return natiflag;
		}
		public void setNatiflag(String natiflag) {
			this.natiflag = natiflag;
		}
		public String getReginatu() {
			return reginatu;
		}
		public void setReginatu(String reginatu) {
			this.reginatu = reginatu;
		}
		public String getContaddr() {
			return contaddr;
		}
		public void setContaddr(String contaddr) {
			this.contaddr = contaddr;
		}
		public String getWorkyearmonth() {
			return workyearmonth;
		}
		public void setWorkyearmonth(String workyearmonth) {
			this.workyearmonth = workyearmonth;
		}

	


}
