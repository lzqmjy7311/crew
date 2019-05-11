package com.gbicc.task.entity;

import java.io.Serializable;
import java.util.Date;

import com.gbicc.person.customer.entity.TCustomer;

/**
 * 
 * @author xudongdong
 *
 * 版本：2015年10月30日 下午1:33:38
 * 类说明：任务类实体
 */
public class TTask implements Serializable {

	private static final long serialVersionUID = -2631760787710321152L;

	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 客户ID
	 */
	private TCustomer customerId;
	/**
	 * 客户编号
	 */
	private String custCode;
	/**
	 * 客户名称
	 */
	private String custName;
	/**
	 * 客户类型
	 */
	private String custType;
	/**
	 * 贷款账号
	 */
	private String loanAccount;
	/**
	 * 产品号
	 */
	private String productCode;	
	/**
	 * 贷款金额
	 */
	private Double loanAmount;
	/**
	 * 贷款余额
	 */
	private Double loanBalance;
	/**
	 * 贷款期限
	 */
	private Integer loanPeriod;
	/**
	 * 经办人
	 */
    private String operator;
    /**
     * 经办行
     */
    private String operBank;
	/**
	 * 任务类别
	 */
	private String taskType;
	/**
	 * 任务开始日期
	 */
    private Date createDate ;
    /**
     * 任务结束日期
     */
    private Date dueDate;
    /**
     * 任务超时天数
     */
    private Integer outDays;
    /**
     * 任务处理人
     */
    private String dearPeople;
	public TCustomer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(TCustomer customerId) {
		this.customerId = customerId;
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

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getOutDays() {
		return outDays;
	}

	public void setOutDays(Integer outDays) {
		this.outDays = outDays;
	}

	public String getDearPeople() {
		return dearPeople;
	}

	public void setDearPeople(String dearPeople) {
		this.dearPeople = dearPeople;
	}
    
}
