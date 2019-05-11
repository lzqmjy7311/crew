package com.gbicc.person.customer.entity;
// Generated 2015-11-24 10:47:45 by Hibernate Tools 3.2.2.GA


import java.util.Date;

import com.huateng.ebank.entity.data.mng.TlrInfo;

/**
 * TPlCustGreatEvent generated by hbm2java
 */
public class TPlCustGreatEvent  implements java.io.Serializable {

	private static final long serialVersionUID = 2341197841201822384L;
	
	/*
    */
    private String id;
    /*
    * 客户表ID.
    */
    private String custId;
    /*
    * 登记用户.
    */
    private TlrInfo registerUser;
    /*
    * 登记时间.
    */
    private Date registerDate;

    public TPlCustGreatEvent() {
    }

	
    public TPlCustGreatEvent(String id) {
        this.id = id;
    }
    public TPlCustGreatEvent(String id, String custId, TlrInfo registerUser, Date registerDate) {
       this.id = id;
       this.custId = custId;
       this.registerUser = registerUser;
       this.registerDate = registerDate;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getCustId() {
        return this.custId;
    }
    
    public void setCustId(String custId) {
        this.custId = custId;
    }
    public TlrInfo getRegisterUser() {
        return this.registerUser;
    }
    
    public void setRegisterUser(TlrInfo registerUser) {
        this.registerUser = registerUser;
    }
    public Date getRegisterDate() {
        return this.registerDate;
    }
    
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}