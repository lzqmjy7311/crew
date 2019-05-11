package com.gbicc.person.riskrulelist.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.gbicc.util.DateUtils;
/**
 * @author kfc
 * @time   2015年11月17日10:37:32
 * @desc   质量监督参数维护表
 */
public class RiskruleList implements Serializable {

	private static final long serialVersionUID = -2631760787710321156L;

	private String id;
	
	private String bankName;//经办行
	private String productName;//产品名称
	private String lounAcc;//贷款账号
	private String custName;//客户名称
	private String warningLevel;//预警优先级
	private Double loanAmt;//贷款金额
	private Double loanBalance;// 贷款余额
	private Date warnDate;//预警日期
	private String operator;//经办人
	private String ruleDesc;//规则说明
	private Date changeDate;//状态改变日期
	private String warnSignal;//预警信号
	private String ruleID;//规则ID
	private String ruleCode;//规则代码
	private String isNewcust;//是否新开户L.OPERNAME  as 
	private String warnDateStr;//预警日期
	
	public String getWarnDateStr() {
		if(this.warnDate!=null){
			return DateUtils.formatDate(this.warnDate);
		}
		return "";
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getlounAcc() {
		return lounAcc;
	}
	public void setlounAcc(String lounAcc) {
		this.lounAcc = lounAcc;
	}
	public String getcustName() {
		return custName;
	}
	public void setcustName(String custName) {
		this.custName = custName;
	}
	public String getWarningLevel() {
		return warningLevel;
	}
	public void setWarningLevel(String warningLevel) {
		this.warningLevel = warningLevel;
	}
	public Double getloanAmt() {
		return loanAmt;
	}
	public void setloanAmt(Double loanAmt) {
		this.loanAmt = loanAmt;
	}
	public Double getloanBalance() {
		return loanBalance;
	}
	public void setloanBalance(Double loanBalance) {
		this.loanBalance = loanBalance;
	}
	public Date getwarnDate() {
		return warnDate;
	}
	public void setwarnDate(Date warnDate) {
		this.warnDate = warnDate;
	}
	public String getruleDesc() {
		return ruleDesc;
	}
	public void setruleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
		
	}
	public String getoperator() {
		return operator;
	}
	public void setoperator(String operator) {
		this.operator = operator;
		
	}
	public Date getchangeDate() {
		return changeDate;
	}
	public void setchangeDate(Date changeDate) {
		this.changeDate = changeDate;	
	}
	public String getwarnSignal() {
		return warnSignal;
	}
	public void setwarnSignal(String warnSignal) {
		this.warnSignal = warnSignal;
		
	}
	public String getruleID() {
		return ruleID;
	}
	public void setruleID(String ruleID) {
		this.ruleID = ruleID;	
	}
	public String getisNewcust() {
		return isNewcust;
	}
	public void setisNewcust(String isNewcust) {
		this.isNewcust = isNewcust;	
	}	
	
}

