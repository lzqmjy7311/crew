package com.gbicc.bpm.entity;
// Generated 2015-12-12 16:23:51 by Hibernate Tools 3.2.2.GA



/**
 * TLoanAccountRelDistribute generated by hbm2java
 */
public class TLoanAccountRelDistribute  implements java.io.Serializable {

	private static final long serialVersionUID = 7801498902092340458L;
	
	/*
    * ID主键.
    */
    private String id;
    /*
    * 分派表ID.
    */
    private String distId;
    /*
    * 帐户表ID.
    */
    private String loanacno;

    public TLoanAccountRelDistribute() {
    }

	
    public TLoanAccountRelDistribute(String id) {
        this.id = id;
    }
    public TLoanAccountRelDistribute(String id, String distId, String loanacno) {
       this.id = id;
       this.distId = distId;
       this.loanacno = loanacno;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getDistId() {
        return this.distId;
    }
    
    public void setDistId(String distId) {
        this.distId = distId;
    }
    public String getLoanacno() {
        return this.loanacno;
    }
    
    public void setLoanacno(String loanacno) {
        this.loanacno = loanacno;
    }
}