package com.gbicc.person.monitor.entity;


/**
 * 
 * @date    2015年11月5日
 * @author  tangdu
 * @desc    预警处置业务 主表
 */
public class TPlYjMonitor extends TPlTask implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3205593170045332533L;
	/*
    */
    private String id;
    private String ruleId;
    private String ruleCode;
    private String ruleName;
    private String ruleDesc;
    
    /**
	    * 所属行业
	    */
	    private String waykind;
	 
	   /**
	    * 贷款余额
	    */
	    private Double unpaidCount;
	   /**
	    * 担保方式
	    */
	    private String assukind;
	   /**
	    * 浮动比例
	    */
	    private Double floatinterate;
	   /**
	    * 账号状态
	    */
	    private String acflag;
	    /**
	     * 风险分类
	     */
	    private String riskflag;
	    /**
	     * 产品名称
	     */
	    private String prodname;
	    /**
	    * 规则表中id
	    */
	    private String ruleTrigId;
	    

    public TPlYjMonitor() {
    }

    public TPlYjMonitor(String id) {
       this.id = id;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getWaykind() {
		return waykind;
	}

	public void setWaykind(String waykind) {
		this.waykind = waykind;
	}

	public Double getUnpaidCount() {
		return unpaidCount;
	}

	public void setUnpaidCount(Double unpaidCount) {
		this.unpaidCount = unpaidCount;
	}

	public String getAssukind() {
		return assukind;
	}

	public void setAssukind(String assukind) {
		this.assukind = assukind;
	}

	public Double getFloatinterate() {
		return floatinterate;
	}

	public void setFloatinterate(Double floatinterate) {
		this.floatinterate = floatinterate;
	}

	public String getAcflag() {
		return acflag;
	}

	public void setAcflag(String acflag) {
		this.acflag = acflag;
	}

	public String getRiskflag() {
		return riskflag;
	}

	public void setRiskflag(String riskflag) {
		this.riskflag = riskflag;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getRuleTrigId() {
		return ruleTrigId;
	}

	public void setRuleTrigId(String ruleTrigId) {
		this.ruleTrigId = ruleTrigId;
	}
	
    

}


