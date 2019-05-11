package com.gbicc.person.monitor.entity;
// Generated 2015-11-10 15:05:11 by Hibernate Tools 3.2.2.GA


import java.util.Date;

/**
 * 用途监控实体类
 * @date    2015年11月10日
 * @author  tangdu
 * @desc
 */
public class TPlYtReport  implements java.io.Serializable {

	private static final long serialVersionUID = -2887204107621530889L;
	/*
    * ID主键.
    */
    private String id;
    /*
    * 借据编号.
    */
    private String lendCode;
    /*
    * 查访方式（1,现场;2,非现场）.
    */
    private String checkWay;
    /**
     * 授信额度控制
     */
    private String lmtCtrl;
    public String getLmtCtrl() {
		return lmtCtrl;
	}

	public void setLmtCtrl(String lmtCtrl) {
		this.lmtCtrl = lmtCtrl;
	}

	/*
    * 风险控制措施.
    */
    private String riskCtrl;
    /*
    * 其他措施说明.
    */
    private String otherCtrlDesc;
    /*
    * 附加处理措施（可多选）.
    */
    private String appendCtrl;
    /*
    * 措施意见.
    */
    private String applyOpin;
    /*
    * 贷款品种.
    */
    private String loanVariety;
    /*
    * 客户名称.
    */
    private String custName;
    /*
    * 客户编号.
    */
    private String custCode;
    /*
     * 贷款账号
     */
    private String loanNo;
    /*
    * 贷款金额.
    */
    private Double loanAmt;
    /*
    * 贷款余额.
    */
    private Double loanBalance;
    /*
    * 措施完成时间.
    */
    private Date measCompleteDate;
    /*
    * 主调查人.
    */
    private String mainSurvPer;
    /*
    * 辅助调查人.修改成--》经办人
    */
    private String assistSurvPer;
    /*
    * 查访地点.
    */
    private String checkAddress;
    /*
    * 所属行业.
    */
    private String custTrade;
    /*
    * 调查日期.
    */
    private Date surveyDate;
    /*
    * 产品编号.
    */
    private String productCode;
    /*
    * 信贷资金使用是否与授信审批用途一致.
    */
    private String operResult;
    /*
    * 信贷资金使用是否与客户经营范围一致.
    */
    private String buesResult;
    /*
    * 担保抵押是否落实.
    */
    private String guarResult;
    /*
     * 担保方式
     */
    private String guarType;
    public String getGuarType() {
		return guarType;
	}

	public void setGuarType(String guarType) {
		this.guarType = guarType;
	}

	/*
	 * 贷款客户联系电话
	 */
	private String custPhone;
	
	/*
	 *贷款客户联系地址 
	 */
	private String custAddress;

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	/*
    * 有无其他预警信号.
    */
    private String earnResult;
    /*
    * 贷款资金是否已使用完.
    */
    private String loanResult;
    /*
     * 是否取得征信凭证
     */
    private String hasCert;

	public String getHasCert() {
		return hasCert;
	}

	/**
	 * 是否加强监控频率
	 */
	private String frequency;

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public void setHasCert(String hasCert) {
		this.hasCert = hasCert;
	}


	public TPlYtReport() {
    }

	
    public TPlYtReport(String id) {
        this.id = id;
    }
    public TPlYtReport(String id, String lendCode, String checkWay, String riskCtrl, String otherCtrlDesc, String appendCtrl, String applyOpin, String loanVariety, String custName, String custCode, Double loanAmt, Double loanBalance, Date measCompleteDate, String mainSurvPer, String assistSurvPer, String checkAddress, String custTrade, Date surveyDate, String productCode, String operResult, String buesResult, String guarResult, String earnResult) {
       this.id = id;
       this.lendCode = lendCode;
       this.checkWay = checkWay;
       this.riskCtrl = riskCtrl;
       this.otherCtrlDesc = otherCtrlDesc;
       this.appendCtrl = appendCtrl;
       this.applyOpin = applyOpin;
       this.loanVariety = loanVariety;
       this.custName = custName;
       this.custCode = custCode;
       this.loanAmt = loanAmt;
       this.loanBalance = loanBalance;
       this.measCompleteDate = measCompleteDate;
       this.mainSurvPer = mainSurvPer;
       this.assistSurvPer = assistSurvPer;
       this.checkAddress = checkAddress;
       this.custTrade = custTrade;
       this.surveyDate = surveyDate;
       this.productCode = productCode;
       this.operResult = operResult;
       this.buesResult = buesResult;
       this.guarResult = guarResult;
       this.earnResult = earnResult;
    }
   
    public String getLoanResult() {
		return loanResult;
	}


	public void setLoanResult(String loanResult) {
		this.loanResult = loanResult;
	}
	
    public String getLoanNo() {
		return loanNo;
	}


	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}


	public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getLendCode() {
        return this.lendCode;
    }
    
    public void setLendCode(String lendCode) {
        this.lendCode = lendCode;
    }
    public String getCheckWay() {
        return this.checkWay;
    }
    
    public void setCheckWay(String checkWay) {
        this.checkWay = checkWay;
    }
    public String getRiskCtrl() {
        return this.riskCtrl;
    }
    
    public void setRiskCtrl(String riskCtrl) {
        this.riskCtrl = riskCtrl;
    }
    public String getOtherCtrlDesc() {
        return this.otherCtrlDesc;
    }
    
    public void setOtherCtrlDesc(String otherCtrlDesc) {
        this.otherCtrlDesc = otherCtrlDesc;
    }
    public String getAppendCtrl() {
        return this.appendCtrl;
    }
    
    public void setAppendCtrl(String appendCtrl) {
        this.appendCtrl = appendCtrl;
    }
    public String getApplyOpin() {
        return this.applyOpin;
    }
    
    public void setApplyOpin(String applyOpin) {
        this.applyOpin = applyOpin;
    }
    public String getLoanVariety() {
        return this.loanVariety;
    }
    
    public void setLoanVariety(String loanVariety) {
        this.loanVariety = loanVariety;
    }
    public String getCustName() {
        return this.custName;
    }
    
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getCustCode() {
        return this.custCode;
    }
    
    public void setCustCode(String custCode) {
        this.custCode = custCode;
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
    public Date getMeasCompleteDate() {
        return this.measCompleteDate;
    }
    
    public void setMeasCompleteDate(Date measCompleteDate) {
        this.measCompleteDate = measCompleteDate;
    }
    public String getMainSurvPer() {
        return this.mainSurvPer;
    }
    
    public void setMainSurvPer(String mainSurvPer) {
        this.mainSurvPer = mainSurvPer;
    }
    public String getAssistSurvPer() {
        return this.assistSurvPer;
    }
    
    public void setAssistSurvPer(String assistSurvPer) {
        this.assistSurvPer = assistSurvPer;
    }
    public String getCheckAddress() {
        return this.checkAddress;
    }
    
    public void setCheckAddress(String checkAddress) {
        this.checkAddress = checkAddress;
    }
    public String getCustTrade() {
        return this.custTrade;
    }
    
    public void setCustTrade(String custTrade) {
        this.custTrade = custTrade;
    }
    public Date getSurveyDate() {
        return this.surveyDate;
    }
    
    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getOperResult() {
        return this.operResult;
    }
    
    public void setOperResult(String operResult) {
        this.operResult = operResult;
    }
    public String getBuesResult() {
        return this.buesResult;
    }
    
    public void setBuesResult(String buesResult) {
        this.buesResult = buesResult;
    }
    public String getGuarResult() {
        return this.guarResult;
    }
    
    public void setGuarResult(String guarResult) {
        this.guarResult = guarResult;
    }
    public String getEarnResult() {
        return this.earnResult;
    }
    
    public void setEarnResult(String earnResult) {
        this.earnResult = earnResult;
    }




}


