package com.gbicc.company.single.outputentity;
// Generated 2016-1-12 19:22:04 by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;

/**
 * 帐务交易流水表
 */
public class A01  implements java.io.Serializable {

	private static final long serialVersionUID = 7622092984430900692L;
	
	/*
    */
    private String txnSerialId;
    /*
    */
    private String recdId;
    /*
    */
    private String txnDt;
    /*
    */
    private String inacctDt;
    /*
    */
    private String txnTm;
    /*
    */
    private String acctId;
    /*
    */
    private String aioAccntAcctId;
    /*
    */
    private String cardId;
    /*
    */
    private String cardTypeSelfServEquip;
    /*
    */
    private String custId;
    /*
    */
    private String prodId;
    /*
    */
    private String itemId;
    /*
    */
    private String acctOrg;
    /*
    */
    private BigDecimal bal;
    /*
    */
    private String acctAttri;
    /*
    */
    private BigDecimal cardBal;
    /*
    */
    private String oppoAcctId;
    /*
    */
    private String oppoCustNm;
    /*
    */
    private String oppoBank;
    /*
    */
    private String oppoTxnCcy;
    /*
    */
    private String txnOrg;
    /*
    */
    private String txnTlr;
    /*
    */
    private String authTlr;
    /*
    */
    private String tmlId;
    /*
    */
    private String txnCateg;
    /*
    */
    private String txnSrcSelfServEquip;
    /*
    */
    private String txnChn;
    /*
    */
    private String txnCd;
    /*
    */
    private String ccy;
    /*
    */
    private BigDecimal txnAmt;
    /*
    */
    private BigDecimal txnAftrBal;
    /*
    */
    private BigDecimal txnInt;
    /*
    */
    private BigDecimal fee;
    /*
    */
    private String txnAbstr;
    /*
    */
    private String rvsAcctInd;
    /*
    */
    private String validInd;
    /*
    */
    private String debCrdInd;
    /*
    */
    private String curTransInd;
    /*
    */
    private String txnSucceInd;
    /*
    */
    private String uuid;
    /*
    */
    private String outSysCd;
    /*
    */
    private String chnSerialId;
    /*
    */
    private String outSerialId;
    /*
    */
    private String agentBank;
    /*
    */
    private String nonCardPayInd;
    /*
    */
    private String withdrInd;
    /*
    */
    private String fincInd;
    /*
    */
    private String merchantTypeCd;
    /*
    */
    private String etlProcDt;
    /*
    * 预警表ID.
    */
    private String warnId;
    /*
    * 数据日期.
    */
    private String dataDt;
    
    private String custName;
    
    public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public A01() {
    }

	/**
    */	
    public String getTxnSerialId() {
        return this.txnSerialId;
    }
	/**
    */	
    public void setTxnSerialId(String txnSerialId) {
        this.txnSerialId = txnSerialId;
    }
	/**
    */	
    public String getRecdId() {
        return this.recdId;
    }
	/**
    */	
    public void setRecdId(String recdId) {
        this.recdId = recdId;
    }
	/**
    */	
    public String getTxnDt() {
        return this.txnDt;
    }
	/**
    */	
    public void setTxnDt(String txnDt) {
        this.txnDt = txnDt;
    }
	/**
    */	
    public String getInacctDt() {
        return this.inacctDt;
    }
	/**
    */	
    public void setInacctDt(String inacctDt) {
        this.inacctDt = inacctDt;
    }
	/**
    */	
    public String getTxnTm() {
        return this.txnTm;
    }
	/**
    */	
    public void setTxnTm(String txnTm) {
        this.txnTm = txnTm;
    }
	/**
    */	
    public String getAcctId() {
        return this.acctId;
    }
	/**
    */	
    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }
	/**
    */	
    public String getAioAccntAcctId() {
        return this.aioAccntAcctId;
    }
	/**
    */	
    public void setAioAccntAcctId(String aioAccntAcctId) {
        this.aioAccntAcctId = aioAccntAcctId;
    }
	/**
    */	
    public String getCardId() {
        return this.cardId;
    }
	/**
    */	
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
	/**
    */	
    public String getCardTypeSelfServEquip() {
        return this.cardTypeSelfServEquip;
    }
	/**
    */	
    public void setCardTypeSelfServEquip(String cardTypeSelfServEquip) {
        this.cardTypeSelfServEquip = cardTypeSelfServEquip;
    }
	/**
    */	
    public String getCustId() {
        return this.custId;
    }
	/**
    */	
    public void setCustId(String custId) {
        this.custId = custId;
    }
	/**
    */	
    public String getProdId() {
        return this.prodId;
    }
	/**
    */	
    public void setProdId(String prodId) {
        this.prodId = prodId;
    }
	/**
    */	
    public String getItemId() {
        return this.itemId;
    }
	/**
    */	
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
	/**
    */	
    public String getAcctOrg() {
        return this.acctOrg;
    }
	/**
    */	
    public void setAcctOrg(String acctOrg) {
        this.acctOrg = acctOrg;
    }
	/**
    */	
    public BigDecimal getBal() {
        return this.bal;
    }
	/**
    */	
    public void setBal(BigDecimal bal) {
        this.bal = bal;
    }
	/**
    */	
    public String getAcctAttri() {
        return this.acctAttri;
    }
	/**
    */	
    public void setAcctAttri(String acctAttri) {
        this.acctAttri = acctAttri;
    }
	/**
    */	
    public BigDecimal getCardBal() {
        return this.cardBal;
    }
	/**
    */	
    public void setCardBal(BigDecimal cardBal) {
        this.cardBal = cardBal;
    }
	/**
    */	
    public String getOppoAcctId() {
        return this.oppoAcctId;
    }
	/**
    */	
    public void setOppoAcctId(String oppoAcctId) {
        this.oppoAcctId = oppoAcctId;
    }
	/**
    */	
    public String getOppoCustNm() {
        return this.oppoCustNm;
    }
	/**
    */	
    public void setOppoCustNm(String oppoCustNm) {
        this.oppoCustNm = oppoCustNm;
    }
	/**
    */	
    public String getOppoBank() {
        return this.oppoBank;
    }
	/**
    */	
    public void setOppoBank(String oppoBank) {
        this.oppoBank = oppoBank;
    }
	/**
    */	
    public String getOppoTxnCcy() {
        return this.oppoTxnCcy;
    }
	/**
    */	
    public void setOppoTxnCcy(String oppoTxnCcy) {
        this.oppoTxnCcy = oppoTxnCcy;
    }
	/**
    */	
    public String getTxnOrg() {
        return this.txnOrg;
    }
	/**
    */	
    public void setTxnOrg(String txnOrg) {
        this.txnOrg = txnOrg;
    }
	/**
    */	
    public String getTxnTlr() {
        return this.txnTlr;
    }
	/**
    */	
    public void setTxnTlr(String txnTlr) {
        this.txnTlr = txnTlr;
    }
	/**
    */	
    public String getAuthTlr() {
        return this.authTlr;
    }
	/**
    */	
    public void setAuthTlr(String authTlr) {
        this.authTlr = authTlr;
    }
	/**
    */	
    public String getTmlId() {
        return this.tmlId;
    }
	/**
    */	
    public void setTmlId(String tmlId) {
        this.tmlId = tmlId;
    }
	/**
    */	
    public String getTxnCateg() {
        return this.txnCateg;
    }
	/**
    */	
    public void setTxnCateg(String txnCateg) {
        this.txnCateg = txnCateg;
    }
	/**
    */	
    public String getTxnSrcSelfServEquip() {
        return this.txnSrcSelfServEquip;
    }
	/**
    */	
    public void setTxnSrcSelfServEquip(String txnSrcSelfServEquip) {
        this.txnSrcSelfServEquip = txnSrcSelfServEquip;
    }
	/**
    */	
    public String getTxnChn() {
        return this.txnChn;
    }
	/**
    */	
    public void setTxnChn(String txnChn) {
        this.txnChn = txnChn;
    }
	/**
    */	
    public String getTxnCd() {
        return this.txnCd;
    }
	/**
    */	
    public void setTxnCd(String txnCd) {
        this.txnCd = txnCd;
    }
	/**
    */	
    public String getCcy() {
        return this.ccy;
    }
	/**
    */	
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }
	/**
    */	
    public BigDecimal getTxnAmt() {
        return this.txnAmt;
    }
	/**
    */	
    public void setTxnAmt(BigDecimal txnAmt) {
        this.txnAmt = txnAmt;
    }
	/**
    */	
    public BigDecimal getTxnAftrBal() {
        return this.txnAftrBal;
    }
	/**
    */	
    public void setTxnAftrBal(BigDecimal txnAftrBal) {
        this.txnAftrBal = txnAftrBal;
    }
	/**
    */	
    public BigDecimal getTxnInt() {
        return this.txnInt;
    }
	/**
    */	
    public void setTxnInt(BigDecimal txnInt) {
        this.txnInt = txnInt;
    }
	/**
    */	
    public BigDecimal getFee() {
        return this.fee;
    }
	/**
    */	
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
	/**
    */	
    public String getTxnAbstr() {
        return this.txnAbstr;
    }
	/**
    */	
    public void setTxnAbstr(String txnAbstr) {
        this.txnAbstr = txnAbstr;
    }
	/**
    */	
    public String getRvsAcctInd() {
        return this.rvsAcctInd;
    }
	/**
    */	
    public void setRvsAcctInd(String rvsAcctInd) {
        this.rvsAcctInd = rvsAcctInd;
    }
	/**
    */	
    public String getValidInd() {
        return this.validInd;
    }
	/**
    */	
    public void setValidInd(String validInd) {
        this.validInd = validInd;
    }
	/**
    */	
    public String getDebCrdInd() {
        return this.debCrdInd;
    }
	/**
    */	
    public void setDebCrdInd(String debCrdInd) {
        this.debCrdInd = debCrdInd;
    }
	/**
    */	
    public String getCurTransInd() {
        return this.curTransInd;
    }
	/**
    */	
    public void setCurTransInd(String curTransInd) {
        this.curTransInd = curTransInd;
    }
	/**
    */	
    public String getTxnSucceInd() {
        return this.txnSucceInd;
    }
	/**
    */	
    public void setTxnSucceInd(String txnSucceInd) {
        this.txnSucceInd = txnSucceInd;
    }
	/**
    */	
    public String getUuid() {
        return this.uuid;
    }
	/**
    */	
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
	/**
    */	
    public String getOutSysCd() {
        return this.outSysCd;
    }
	/**
    */	
    public void setOutSysCd(String outSysCd) {
        this.outSysCd = outSysCd;
    }
	/**
    */	
    public String getChnSerialId() {
        return this.chnSerialId;
    }
	/**
    */	
    public void setChnSerialId(String chnSerialId) {
        this.chnSerialId = chnSerialId;
    }
	/**
    */	
    public String getOutSerialId() {
        return this.outSerialId;
    }
	/**
    */	
    public void setOutSerialId(String outSerialId) {
        this.outSerialId = outSerialId;
    }
	/**
    */	
    public String getAgentBank() {
        return this.agentBank;
    }
	/**
    */	
    public void setAgentBank(String agentBank) {
        this.agentBank = agentBank;
    }
	/**
    */	
    public String getNonCardPayInd() {
        return this.nonCardPayInd;
    }
	/**
    */	
    public void setNonCardPayInd(String nonCardPayInd) {
        this.nonCardPayInd = nonCardPayInd;
    }
	/**
    */	
    public String getWithdrInd() {
        return this.withdrInd;
    }
	/**
    */	
    public void setWithdrInd(String withdrInd) {
        this.withdrInd = withdrInd;
    }
	/**
    */	
    public String getFincInd() {
        return this.fincInd;
    }
	/**
    */	
    public void setFincInd(String fincInd) {
        this.fincInd = fincInd;
    }
	/**
    */	
    public String getMerchantTypeCd() {
        return this.merchantTypeCd;
    }
	/**
    */	
    public void setMerchantTypeCd(String merchantTypeCd) {
        this.merchantTypeCd = merchantTypeCd;
    }
	/**
    */	
    public String getEtlProcDt() {
        return this.etlProcDt;
    }
	/**
    */	
    public void setEtlProcDt(String etlProcDt) {
        this.etlProcDt = etlProcDt;
    }
	/**
    * Get the 预警表ID
    */	
    public String getWarnId() {
        return this.warnId;
    }
	/**
    * Set the 预警表ID
    */	
    public void setWarnId(String warnId) {
        this.warnId = warnId;
    }
	/**
    * Get the 数据日期
    */	
    public String getDataDt() {
        return this.dataDt;
    }
	/**
    * Set the 数据日期
    */	
    public void setDataDt(String dataDt) {
        this.dataDt = dataDt;
    }
}