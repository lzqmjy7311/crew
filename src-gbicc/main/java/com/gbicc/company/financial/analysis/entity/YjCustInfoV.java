package com.gbicc.company.financial.analysis.entity;

import java.math.BigDecimal;
// Generated 2015-12-19 15:43:42 by Hibernate Tools 3.2.2.GA



/**
 * YjCustInfoV generated by hbm2java
 */
public class YjCustInfoV  implements java.io.Serializable {


	 /**
	  * 账号号
	  */
	    private String loanacno;
	    /**
	     * 客户id
	     */
	    private String custid;
	   /**
	    * 客户名称
	    */
	    private String custname;
	   /**
	    * 所属行业
	    */
	    private String waykind;
	   /**
	    * 产品名称
	    */
	    private String prodname;
	    /**
	     * 贷款金额
	     */
	    private Double tcapi;
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

	 
	   
	    public String getLoanacno() {
	        return this.loanacno;
	    }
	    
	    public void setLoanacno(String loanacno) {
	        this.loanacno = loanacno;
	    }
	    public String getCustid() {
	        return this.custid;
	    }
	    
	    public void setCustid(String custid) {
	        this.custid = custid;
	    }
	    public String getCustname() {
	        return this.custname;
	    }
	    
	    public void setCustname(String custname) {
	        this.custname = custname;
	    }
	    public String getWaykind() {
	        return this.waykind;
	    }
	    
	    public void setWaykind(String waykind) {
	        this.waykind = waykind;
	    }
	    public String getProdname() {
	        return this.prodname;
	    }
	    
	    public void setProdname(String prodname) {
	        this.prodname = prodname;
	    }
	    public Double getTcapi() {
	        return this.tcapi;
	    }
	    
	    public void setTcapi(Double tcapi) {
	        this.tcapi = tcapi;
	    }
	    public Double getUnpaidCount() {
	        return this.unpaidCount;
	    }
	    
	    public void setUnpaidCount(Double unpaidCount) {
	        this.unpaidCount = unpaidCount;
	    }
	    public String getAssukind() {
	        return this.assukind;
	    }
	    
	    public void setAssukind(String assukind) {
	        this.assukind = assukind;
	    }
	    public Double getFloatinterate() {
	        return this.floatinterate;
	    }
	    
	    public void setFloatinterate(Double floatinterate) {
	        this.floatinterate = floatinterate;
	    }
	    public String getAcflag() {
	        return this.acflag;
	    }
	    
	    public void setAcflag(String acflag) {
	        this.acflag = acflag;
	    }
	    public String getRiskflag() {
	        return this.riskflag;
	    }
	    
	    public void setRiskflag(String riskflag) {
	        this.riskflag = riskflag;
	    }


}


