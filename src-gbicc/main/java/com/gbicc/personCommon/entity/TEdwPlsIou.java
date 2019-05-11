package com.gbicc.personCommon.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Model class of 借据表.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class TEdwPlsIou implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/*
    * 借据编号.
    */
    private String duebillno;
    /*
    * 账户ID.
    */
    private String loanacno;
    /*
    * 放款日期.
    */
    private Date begindate;
    /*
    * 客户编号.
    */
    private String custid;
    /*
    * 客户名称.
    */
    private String custname;
    /*
    * 借款合同编号.
    */
    private String contno;
    /*
    * 单据序号.
    */
    private String listid;
    /*
    * 单据类型.
    */
    private String listtype;
    /*
    * 业务类型.
    */
    private String busitype;
    /*
    * 业务编号.
    */
    private String loanid;
    /*
    * 会计科目.
    */
    private String subjid;
    /*
    * 产品代码.
    */
    private String prodid;
    /*
    * 贷款金额.
    */
    private BigDecimal tcapi;
    /*
    * 贷款期限.
    */
    private Integer tterm;
    /*
    * 到期日期.
    */
    private Date enddate;
    /*
    * 存款账号.
    */
    private String saveacno;
    /*
    * 经办行 : （机构ID）.
    */
    private String bankid;
    /*
    * 经办人 : 客户经理ID.
    */
    private String operid;

    public TEdwPlsIou() {
    }

	
    public TEdwPlsIou(String duebillno) {
        this.duebillno = duebillno;
    }
    public TEdwPlsIou(String duebillno, String loanacno, Date begindate, String custid, String custname, String contno, String listid, String listtype, String busitype, String loanid, String subjid, String prodid, BigDecimal tcapi, Integer tterm, Date enddate, String saveacno, String bankid, String operid) {
       this.duebillno = duebillno;
       this.loanacno = loanacno;
       this.begindate = begindate;
       this.custid = custid;
       this.custname = custname;
       this.contno = contno;
       this.listid = listid;
       this.listtype = listtype;
       this.busitype = busitype;
       this.loanid = loanid;
       this.subjid = subjid;
       this.prodid = prodid;
       this.tcapi = tcapi;
       this.tterm = tterm;
       this.enddate = enddate;
       this.saveacno = saveacno;
       this.bankid = bankid;
       this.operid = operid;
    }
   
	/**
    * Get the 借据编号
    */	
    public String getDuebillno() {
        return this.duebillno;
    }
	/**
    * Set the 借据编号
    */	
    public void setDuebillno(String duebillno) {
        this.duebillno = duebillno;
    }
	/**
    * Get the 账户ID
    */	
    public String getLoanacno() {
        return this.loanacno;
    }
	/**
    * Set the 账户ID
    */	
    public void setLoanacno(String loanacno) {
        this.loanacno = loanacno;
    }
	/**
    * Get the 放款日期
    */	
    public Date getBegindate() {
        return this.begindate;
    }
	/**
    * Set the 放款日期
    */	
    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }
	/**
    * Get the 客户编号
    */	
    public String getCustid() {
        return this.custid;
    }
	/**
    * Set the 客户编号
    */	
    public void setCustid(String custid) {
        this.custid = custid;
    }
	/**
    * Get the 客户名称
    */	
    public String getCustname() {
        return this.custname;
    }
	/**
    * Set the 客户名称
    */	
    public void setCustname(String custname) {
        this.custname = custname;
    }
	/**
    * Get the 借款合同编号
    */	
    public String getContno() {
        return this.contno;
    }
	/**
    * Set the 借款合同编号
    */	
    public void setContno(String contno) {
        this.contno = contno;
    }
	/**
    * Get the 单据序号
    */	
    public String getListid() {
        return this.listid;
    }
	/**
    * Set the 单据序号
    */	
    public void setListid(String listid) {
        this.listid = listid;
    }
	/**
    * Get the 单据类型
    */	
    public String getListtype() {
        return this.listtype;
    }
	/**
    * Set the 单据类型
    */	
    public void setListtype(String listtype) {
        this.listtype = listtype;
    }
	/**
    * Get the 业务类型
    */	
    public String getBusitype() {
        return this.busitype;
    }
	/**
    * Set the 业务类型
    */	
    public void setBusitype(String busitype) {
        this.busitype = busitype;
    }
	/**
    * Get the 业务编号
    */	
    public String getLoanid() {
        return this.loanid;
    }
	/**
    * Set the 业务编号
    */	
    public void setLoanid(String loanid) {
        this.loanid = loanid;
    }
	/**
    * Get the 会计科目
    */	
    public String getSubjid() {
        return this.subjid;
    }
	/**
    * Set the 会计科目
    */	
    public void setSubjid(String subjid) {
        this.subjid = subjid;
    }
	/**
    * Get the 产品代码
    */	
    public String getProdid() {
        return this.prodid;
    }
	/**
    * Set the 产品代码
    */	
    public void setProdid(String prodid) {
        this.prodid = prodid;
    }
	/**
    * Get the 贷款金额
    */	
    public BigDecimal getTcapi() {
        return this.tcapi;
    }
	/**
    * Set the 贷款金额
    */	
    public void setTcapi(BigDecimal tcapi) {
        this.tcapi = tcapi;
    }
	/**
    * Get the 贷款期限
    */	
    public Integer getTterm() {
        return this.tterm;
    }
	/**
    * Set the 贷款期限
    */	
    public void setTterm(Integer tterm) {
        this.tterm = tterm;
    }
	/**
    * Get the 到期日期
    */	
    public Date getEnddate() {
        return this.enddate;
    }
	/**
    * Set the 到期日期
    */	
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
	/**
    * Get the 存款账号
    */	
    public String getSaveacno() {
        return this.saveacno;
    }
	/**
    * Set the 存款账号
    */	
    public void setSaveacno(String saveacno) {
        this.saveacno = saveacno;
    }
	/**
    * Get the 经办行 : （机构ID）
    */	
    public String getBankid() {
        return this.bankid;
    }
	/**
    * Set the 经办行 : （机构ID）
    */	
    public void setBankid(String bankid) {
        this.bankid = bankid;
    }
	/**
    * Get the 经办人 : 客户经理ID
    */	
    public String getOperid() {
        return this.operid;
    }
	/**
    * Set the 经办人 : 客户经理ID
    */	
    public void setOperid(String operid) {
        this.operid = operid;
    }

}
