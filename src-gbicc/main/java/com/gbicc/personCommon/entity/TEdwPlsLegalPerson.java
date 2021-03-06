package com.gbicc.personCommon.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Model class of 法人信息表.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class TEdwPlsLegalPerson implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/*
    */
    private String custid;
    /*
    */
    private String custname;
    /*
    */
    private String paperkind;
    /*
    */
    private String paperid;
    /*
    */
    private String liceid;
    /*
    */
    private String orgaid;
    /*
    */
    private BigDecimal regifund;
    /*
    */
    private String leadcustname;
    /*
    */
    private String leadcustpaperkino;
    /*
    */
    private String leadcustpaperid;
    /*
    */
    private BigDecimal factcapi;
    /*
    */
    private Integer staffnum;
    /*
    */
    private String creveid;
    /*
    */
    private String lreveid;
    /*
    */
    private String controlid;
    /*
    */
    private String controlname;
    /*
    */
    private String controlpaperkind;
    /*
    */
    private String controlpaperid;
    /*
    */
    private String holdcustid;
    /*
    */
    private String holdcustname;
    /*
    */
    private String holdcustpaperkind;
    /*
    */
    private String holdcustpaperid;

    public TEdwPlsLegalPerson() {
    }

	
    public TEdwPlsLegalPerson(String custid) {
        this.custid = custid;
    }
    public TEdwPlsLegalPerson(String custid, String custname, String paperkind, String paperid, String liceid, String orgaid, BigDecimal regifund, String leadcustname, String leadcustpaperkino, String leadcustpaperid, BigDecimal factcapi, Integer staffnum, String creveid, String lreveid, String controlid, String controlname, String controlpaperkind, String controlpaperid, String holdcustid, String holdcustname, String holdcustpaperkind, String holdcustpaperid) {
       this.custid = custid;
       this.custname = custname;
       this.paperkind = paperkind;
       this.paperid = paperid;
       this.liceid = liceid;
       this.orgaid = orgaid;
       this.regifund = regifund;
       this.leadcustname = leadcustname;
       this.leadcustpaperkino = leadcustpaperkino;
       this.leadcustpaperid = leadcustpaperid;
       this.factcapi = factcapi;
       this.staffnum = staffnum;
       this.creveid = creveid;
       this.lreveid = lreveid;
       this.controlid = controlid;
       this.controlname = controlname;
       this.controlpaperkind = controlpaperkind;
       this.controlpaperid = controlpaperid;
       this.holdcustid = holdcustid;
       this.holdcustname = holdcustname;
       this.holdcustpaperkind = holdcustpaperkind;
       this.holdcustpaperid = holdcustpaperid;
    }
   
	/**
    */	
    public String getCustid() {
        return this.custid;
    }
	/**
    */	
    public void setCustid(String custid) {
        this.custid = custid;
    }
	/**
    */	
    public String getCustname() {
        return this.custname;
    }
	/**
    */	
    public void setCustname(String custname) {
        this.custname = custname;
    }
	/**
    */	
    public String getPaperkind() {
        return this.paperkind;
    }
	/**
    */	
    public void setPaperkind(String paperkind) {
        this.paperkind = paperkind;
    }
	/**
    */	
    public String getPaperid() {
        return this.paperid;
    }
	/**
    */	
    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }
	/**
    */	
    public String getLiceid() {
        return this.liceid;
    }
	/**
    */	
    public void setLiceid(String liceid) {
        this.liceid = liceid;
    }
	/**
    */	
    public String getOrgaid() {
        return this.orgaid;
    }
	/**
    */	
    public void setOrgaid(String orgaid) {
        this.orgaid = orgaid;
    }
	/**
    */	
    public BigDecimal getRegifund() {
        return this.regifund;
    }
	/**
    */	
    public void setRegifund(BigDecimal regifund) {
        this.regifund = regifund;
    }
	/**
    */	
    public String getLeadcustname() {
        return this.leadcustname;
    }
	/**
    */	
    public void setLeadcustname(String leadcustname) {
        this.leadcustname = leadcustname;
    }
	/**
    */	
    public String getLeadcustpaperkino() {
        return this.leadcustpaperkino;
    }
	/**
    */	
    public void setLeadcustpaperkino(String leadcustpaperkino) {
        this.leadcustpaperkino = leadcustpaperkino;
    }
	/**
    */	
    public String getLeadcustpaperid() {
        return this.leadcustpaperid;
    }
	/**
    */	
    public void setLeadcustpaperid(String leadcustpaperid) {
        this.leadcustpaperid = leadcustpaperid;
    }
	/**
    */	
    public BigDecimal getFactcapi() {
        return this.factcapi;
    }
	/**
    */	
    public void setFactcapi(BigDecimal factcapi) {
        this.factcapi = factcapi;
    }
	/**
    */	
    public Integer getStaffnum() {
        return this.staffnum;
    }
	/**
    */	
    public void setStaffnum(Integer staffnum) {
        this.staffnum = staffnum;
    }
	/**
    */	
    public String getCreveid() {
        return this.creveid;
    }
	/**
    */	
    public void setCreveid(String creveid) {
        this.creveid = creveid;
    }
	/**
    */	
    public String getLreveid() {
        return this.lreveid;
    }
	/**
    */	
    public void setLreveid(String lreveid) {
        this.lreveid = lreveid;
    }
	/**
    */	
    public String getControlid() {
        return this.controlid;
    }
	/**
    */	
    public void setControlid(String controlid) {
        this.controlid = controlid;
    }
	/**
    */	
    public String getControlname() {
        return this.controlname;
    }
	/**
    */	
    public void setControlname(String controlname) {
        this.controlname = controlname;
    }
	/**
    */	
    public String getControlpaperkind() {
        return this.controlpaperkind;
    }
	/**
    */	
    public void setControlpaperkind(String controlpaperkind) {
        this.controlpaperkind = controlpaperkind;
    }
	/**
    */	
    public String getControlpaperid() {
        return this.controlpaperid;
    }
	/**
    */	
    public void setControlpaperid(String controlpaperid) {
        this.controlpaperid = controlpaperid;
    }
	/**
    */	
    public String getHoldcustid() {
        return this.holdcustid;
    }
	/**
    */	
    public void setHoldcustid(String holdcustid) {
        this.holdcustid = holdcustid;
    }
	/**
    */	
    public String getHoldcustname() {
        return this.holdcustname;
    }
	/**
    */	
    public void setHoldcustname(String holdcustname) {
        this.holdcustname = holdcustname;
    }
	/**
    */	
    public String getHoldcustpaperkind() {
        return this.holdcustpaperkind;
    }
	/**
    */	
    public void setHoldcustpaperkind(String holdcustpaperkind) {
        this.holdcustpaperkind = holdcustpaperkind;
    }
	/**
    */	
    public String getHoldcustpaperid() {
        return this.holdcustpaperid;
    }
	/**
    */	
    public void setHoldcustpaperid(String holdcustpaperid) {
        this.holdcustpaperid = holdcustpaperid;
    }

}
