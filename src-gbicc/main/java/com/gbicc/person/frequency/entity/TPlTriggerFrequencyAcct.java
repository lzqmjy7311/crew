package com.gbicc.person.frequency.entity;
// Generated 2015-11-16 11:15:22 by Hibernate Tools 3.2.2.GA


import java.util.Date;

/**
 * 
 * @author xudongdong
 *
 * 版本：2015年11月16日 上午11:26:57
 * 类说明：调整监控频率
 */
public class TPlTriggerFrequencyAcct  implements java.io.Serializable {


    /*
    */
    private String id;
    /*
    * 贷款账号.
    */
    private String loanAcct;
    /*
    * 客户名称.
    */
    private String custName;
    /*
    * 预警等级.
    */
    private String warnLevel;
    /*
    * 人工发起（调整频率）日期.
    */
    private Date warnDate;
    /*
    * 贷款产品.
    */
    private String loanVariety;
    /*
    * 监控频率.
    */
    private String frequency;
    /*
    * 贷款金额.
    */
    private Double loanAmt;
    /*
    * 贷款余额.
    */
    private Double loanBalance;
    /*
    * 贷款期限.
    */
    private String loanTerm;
    /*
     * 流程状态 3 退回  2提交审核 4审核通过.
     */
    private String status;
    
    
    /**
     * 经办人
     */
	private String launchPer;
	/**
	 * 经办行
	 */
	private String launchBank;
	/**
	 * 系统监控频率
	 */
	private String sysFrequency;
	
	
	

    public TPlTriggerFrequencyAcct() {
    }

	
    public TPlTriggerFrequencyAcct(String id) {
        this.id = id;
    }
    public TPlTriggerFrequencyAcct(String id, String loanAcct, String custName, String warnLevel, Date warnDate, String loanVariety, String frequency, Double loanAmt, Double loanBalance, String loanTerm,String status,String launchPer,String launchBank,String sysFrequency) {
       this.id = id;
       this.loanAcct = loanAcct;
       this.custName = custName;
       this.warnLevel = warnLevel;
       this.warnDate = warnDate;
       this.loanVariety = loanVariety;
       this.frequency = frequency;
       this.loanAmt = loanAmt;
       this.loanBalance = loanBalance;
       this.loanTerm = loanTerm;
       this.status =status;  
       this.launchPer=launchPer;
       this.sysFrequency=sysFrequency;
       this.launchBank=launchBank;
        
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getLoanAcct() {
        return this.loanAcct;
    }
    
    public void setLoanAcct(String loanAcct) {
        this.loanAcct = loanAcct;
    }
    public String getCustName() {
        return this.custName;
    }
    
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getWarnLevel() {
        return this.warnLevel;
    }
    
    public void setWarnLevel(String warnLevel) {
        this.warnLevel = warnLevel;
    }
    public Date getWarnDate() {
        return this.warnDate;
    }
    
    public void setWarnDate(Date warnDate) {
        this.warnDate = warnDate;
    }
    public String getLoanVariety() {
        return this.loanVariety;
    }
    
    public void setLoanVariety(String loanVariety) {
        this.loanVariety = loanVariety;
    }
    public String getFrequency() {
        return this.frequency;
    }
    
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public Double getLoanAmt() {
        return this.loanAmt;
    }
    
    public void setLoanAmt(Double loanAmt) {
        this.loanAmt = loanAmt;
    }
    public Double getLoanBalance() {
        return this.loanBalance;
    }
    
    public void setLoanBalance(Double loanBalance) {
        this.loanBalance = loanBalance;
    }
    public String getLoanTerm() {
        return this.loanTerm;
    }
    
    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}





	public String getLaunchPer() {
		return launchPer;
	}


	public void setLaunchPer(String launchPer) {
		this.launchPer = launchPer;
	}


	public String getLaunchBank() {
		return launchBank;
	}


	public void setLaunchBank(String launchBank) {
		this.launchBank = launchBank;
	}


	public String getSysFrequency() {
		return sysFrequency;
	}


	public void setSysFrequency(String sysFrequency) {
		this.sysFrequency = sysFrequency;
	}




}


