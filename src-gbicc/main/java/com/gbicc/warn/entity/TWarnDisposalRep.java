package com.gbicc.warn.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.gbicc.person.customer.entity.TCustomer;


/**
 * @author xudongdong
 *
 * 版本：2015年11月2日 下午7:10:03
 * 类说明：个人预警处置报告
 */
public class TWarnDisposalRep implements Serializable {

	private static final long serialVersionUID = -2631760787710321152L;

	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	 
	    /*
	    * 客户编号.
	    */
	    private String customerId;
	    /**
	     * 任务id
	     */
	    private String taskId;
	    /*
	    * 客户代码.
	    */
	    private String custCode;
	    /*
	    * 客户名称.
	    */
	    private String custName;
	    /*
	    * 客户类型.
	    */
	    private String custType;
	    /*
	    * 贷款金额.
	    */
	    private String loanAccount;
	    /*
	    * 产品号.
	    */
	    private String productCode;
	    /*
	    * 贷款金额.
	    */
	    private Double loanAmount;
	    /*
	    * 贷款余额.
	    */
	    private Double loanBalance;
	    /*
	    * 贷款周期.
	    */
	    private Integer loanPeriod;
	    /*
	    * 操作人.
	    */
	    private String operator;
	    /*
	    * 操作行.
	    */
	    private String operBank;
	    /*
	    * 所属行业.
	    */
	    private String industry;
	    /*
	    * 担保方式.
	    */
	    private String guaranteeMethod;
	    /*
	    * 浮动比例.
	    */
	    private Double slidingScales;
	    /*
	    * 账号状态.
	    */
	    private String accountStatus;
	    /*
	    * 风险分类.
	    */
	    private String riskClass;
	    /*
	    * 查访方式.
	    */
	    private String visitWay;
	    /*
	    * 查访地址.
	    */
	    private String visitAdd;
	    /*
	    * 主调查人.
	    */
	    private String leadInvestigator;
	    /*
	    * 辅调查人.
	    */
	    private String assInvestigator;
	    /*
	    * 调查日期.
	    */
	    private Date surveyDate;
	    /*
	    * 预警信号.
	    */
	    private TWarnSignal warnSignalId;
	    /*
	    * 授信控制措施.
	    */
	    private String creLimconMeasures;
	    /*
	    * 其他控制措施.
	    */
	    private String otherConMeasures;
	    /*
	    */
	    private String addConMeasures;
	    /*
	    * 申报意见.
	    */
	    private String declarationOpi;
	    /*
	    * 是否涉及或者将涉及重大债权债务纠纷、法律诉讼.
	    */
	    private String isZdzqzwjfflss;
	    /*
	    * 恶意逃废银行债务.
	    */
	    private String isEytfyhzf;
	    /*
	    * 是否对银行的态度发生变化，缺乏合作态度.
	    */
	    private String isTdfsbh;
	    /*
	    * 是否存在提供虚假资料.
	    */
	    private String isTgxjzl;
	    /*
	    * 是否存在财务恶化.
	    */
	    private String isCweh;
	    /*
	    * 是否有转移资产.
	    */
	    private String isZyzc;
	    /*
	    * 是否存在承包、租赁、联营、合并、合作、分立、产权转让、重组、改制.
	    */
	    private String isCzlhhfccg;
	    /*
	    * 是否存在重要资质被吊销.
	    */
	    private String isZzdx;
	    /*
	    * 是否存在停产、半停产状态.
	    */
	    private String isTcbtc;
	    /*
	    * 是否存在破产、已破产状态.
	    */
	    private String isPcbpc;
	    /*
	    * 是否有负面报道.
	    */
	    private String isFmbd;
	    /*
	    * 是否有重大灾害.
	    */
	    private String isZdzh;
	    /*
	    * 是否投资不熟悉新业务、产品、市场.
	    */
	    private String isBsxxycs;
	    /*
	    * 是否有需要说明的事项.
	    */
	    private String isXysmsx;
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getLoanAccount() {
		return loanAccount;
	}

	public void setLoanAccount(String loanAccount) {
		this.loanAccount = loanAccount;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(Double loanBalance) {
		this.loanBalance = loanBalance;
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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getGuaranteeMethod() {
		return guaranteeMethod;
	}

	public void setGuaranteeMethod(String guaranteeMethod) {
		this.guaranteeMethod = guaranteeMethod;
	}

	public Double getSlidingScales() {
		return slidingScales;
	}

	public void setSlidingScales(Double slidingScales) {
		this.slidingScales = slidingScales;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getRiskClass() {
		return riskClass;
	}

	public void setRiskClass(String riskClass) {
		this.riskClass = riskClass;
	}

	public String getVisitWay() {
		return visitWay;
	}

	public void setVisitWay(String visitWay) {
		this.visitWay = visitWay;
	}

	public String getVisitAdd() {
		return visitAdd;
	}

	public void setVisitAdd(String visitAdd) {
		this.visitAdd = visitAdd;
	}

	public String getLeadInvestigator() {
		return leadInvestigator;
	}

	public void setLeadInvestigator(String leadInvestigator) {
		this.leadInvestigator = leadInvestigator;
	}

	public String getAssInvestigator() {
		return assInvestigator;
	}

	public void setAssInvestigator(String assInvestigator) {
		this.assInvestigator = assInvestigator;
	}

	public Date getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}

	public TWarnSignal getWarnSignalId() {
		return warnSignalId;
	}

	public void setWarnSignalId(TWarnSignal warnSignalId) {
		this.warnSignalId = warnSignalId;
	}

	public String getCreLimconMeasures() {
		return creLimconMeasures;
	}

	public void setCreLimconMeasures(String creLimconMeasures) {
		this.creLimconMeasures = creLimconMeasures;
	}

	public String getOtherConMeasures() {
		return otherConMeasures;
	}

	public void setOtherConMeasures(String otherConMeasures) {
		this.otherConMeasures = otherConMeasures;
	}

	public String getAddConMeasures() {
		return addConMeasures;
	}

	public void setAddConMeasures(String addConMeasures) {
		this.addConMeasures = addConMeasures;
	}

	public String getDeclarationOpi() {
		return declarationOpi;
	}

	public void setDeclarationOpi(String declarationOpi) {
		this.declarationOpi = declarationOpi;
	}

	public String getIsZdzqzwjfflss() {
		return isZdzqzwjfflss;
	}

	public void setIsZdzqzwjfflss(String isZdzqzwjfflss) {
		this.isZdzqzwjfflss = isZdzqzwjfflss;
	}

	public String getIsEytfyhzf() {
		return isEytfyhzf;
	}

	public void setIsEytfyhzf(String isEytfyhzf) {
		this.isEytfyhzf = isEytfyhzf;
	}

	public String getIsTdfsbh() {
		return isTdfsbh;
	}

	public void setIsTdfsbh(String isTdfsbh) {
		this.isTdfsbh = isTdfsbh;
	}

	public String getIsTgxjzl() {
		return isTgxjzl;
	}

	public void setIsTgxjzl(String isTgxjzl) {
		this.isTgxjzl = isTgxjzl;
	}

	public String getIsCweh() {
		return isCweh;
	}

	public void setIsCweh(String isCweh) {
		this.isCweh = isCweh;
	}

	public String getIsZyzc() {
		return isZyzc;
	}

	public void setIsZyzc(String isZyzc) {
		this.isZyzc = isZyzc;
	}

	public String getIsCzlhhfccg() {
		return isCzlhhfccg;
	}

	public void setIsCzlhhfccg(String isCzlhhfccg) {
		this.isCzlhhfccg = isCzlhhfccg;
	}

	public String getIsZzdx() {
		return isZzdx;
	}

	public void setIsZzdx(String isZzdx) {
		this.isZzdx = isZzdx;
	}

	public String getIsTcbtc() {
		return isTcbtc;
	}

	public void setIsTcbtc(String isTcbtc) {
		this.isTcbtc = isTcbtc;
	}

	public String getIsPcbpc() {
		return isPcbpc;
	}

	public void setIsPcbpc(String isPcbpc) {
		this.isPcbpc = isPcbpc;
	}

	public String getIsFmbd() {
		return isFmbd;
	}

	public void setIsFmbd(String isFmbd) {
		this.isFmbd = isFmbd;
	}

	public String getIsZdzh() {
		return isZdzh;
	}

	public void setIsZdzh(String isZdzh) {
		this.isZdzh = isZdzh;
	}

	public String getIsBsxxycs() {
		return isBsxxycs;
	}

	public void setIsBsxxycs(String isBsxxycs) {
		this.isBsxxycs = isBsxxycs;
	}

	public String getIsXysmsx() {
		return isXysmsx;
	}

	public void setIsXysmsx(String isXysmsx) {
		this.isXysmsx = isXysmsx;
	}

	
}
