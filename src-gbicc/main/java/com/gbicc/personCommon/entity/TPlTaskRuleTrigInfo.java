package com.gbicc.personCommon.entity;
// Generated 2016-1-8 9:37:26 by Hibernate Tools 3.2.2.GA



import java.math.BigDecimal;
import java.util.Date;

/**
 * TEdwPlsAccount generated by hbm2java
 */
public class TPlTaskRuleTrigInfo  implements java.io.Serializable {

	private static final long serialVersionUID = 7878095355761945289L;
	    /**
	     * 账号编号
	     */
	    private String accId;
	    /**
	     * 产品名称
	     */
	    private String prodname;
	    /**
	     * 客户id
	     */
	    private String custid;
	    /**
	     * 贷款金额
	     */
	    private BigDecimal tcapi;
	    /**
	     * 贷款期限
	     */
	    private Integer tterm;
	    /**
	     * 责任人ID
	     */
	    private String dutyid;
	    /**
	     * 催收人ID
	     */
	    private String dutyid2;
	    /**
	     * 贷款余额
	     */
	    private BigDecimal bal;
	    /**
	     * 客户名称
	     */
	    private String custname;
	    /**
	     * 变更后的责任人IDf
	     */
	    private String dutyid_1;
	    /**
	     * 变更后的催收人ID
	     */
	    private String collid;
	    
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

    public String getAccId() {
        return this.accId;
    }
    
    public void setAccId(String accId) {
        this.accId = accId;
    }
    
    public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getCustid() {
        return this.custid;
    }
    
    public void setCustid(String custid) {
        this.custid = custid;
    }
    public BigDecimal getTcapi() {
        return this.tcapi;
    }
    
    public void setTcapi(BigDecimal tcapi) {
        this.tcapi = tcapi;
    }
    public Integer getTterm() {
        return this.tterm;
    }
    
    public void setTterm(Integer tterm) {
        this.tterm = tterm;
    }
    public String getDutyid() {
        return this.dutyid;
    }
    
    public void setDutyid(String dutyid) {
        this.dutyid = dutyid;
    }
    public String getDutyid2() {
        return this.dutyid2;
    }
    
    public void setDutyid2(String dutyid2) {
        this.dutyid2 = dutyid2;
    }
    public BigDecimal getBal() {
        return this.bal;
    }
    
    public void setBal(BigDecimal bal) {
        this.bal = bal;
    }
    public String getCustname() {
        return this.custname;
    }
    
    public void setCustname(String custname) {
        this.custname = custname;
    }
    public String getDutyid_1() {
        return this.dutyid_1;
    }
    
    public void setDutyid_1(String dutyid_1) {
        this.dutyid_1 = dutyid_1;
    }
    public String getCollid() {
        return this.collid;
    }
    
    public void setCollid(String collid) {
        this.collid = collid;
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
   
	
}