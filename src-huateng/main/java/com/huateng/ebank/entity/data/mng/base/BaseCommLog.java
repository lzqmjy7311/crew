package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the COMM_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="COMM_LOG"
 */

public abstract class BaseCommLog  implements Comparable, Serializable {

	public static String REF = "CommLog";
	public static String PROP_LAST_UPD_FUNC = "lastUpdFunc";
	public static String PROP_TLSRNO = "tlsrno";
	public static String PROP_MISC = "misc";
	public static String PROP_FUNC_CODE = "funcCode";
	public static String PROP_INTERNO = "interno";
	public static String PROP_TXNCD = "txncd";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_ACCT_BRCODE = "acctBrcode";
	public static String PROP_BUSIKEY = "busikey";
	public static String PROP_CONTRACTNO = "contractno";
	public static String PROP_TXDATE = "txdate";
	public static String PROP_RES_CODE = "resCode";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_APPNO = "appno";
	public static String PROP_TXTIME = "txtime";
	public static String PROP_RCV_MSG = "rcvMsg";
	public static String PROP_TLRNO = "tlrno";
	public static String PROP_TXAMT = "txamt";
	public static String PROP_BRANCH_BRCODE = "branchBrcode";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_COUNTRY = "country";
	public static String PROP_TX_STATUS = "txStatus";
	public static String PROP_SRCNO = "srcno";
	public static String PROP_STATUS = "status";
	public static String PROP_CUSTCD = "custcd";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_BRCODE = "brcode";
	public static String PROP_EXTNO = "extno";
	public static String PROP_ID = "id";
	public static String PROP_DSTNO = "dstno";
	public static String PROP_ACCT_TLRNO = "acctTlrno";
	public static String PROP_SEND_MSG = "sendMsg";
	public static String PROP_PL_TLRNO = "plTlrno";


	// constructors
	public BaseCommLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCommLog (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCommLog (
		long id,
		java.util.Date txdate,
		java.util.Date txtime) {

		this.setId(id);
		this.setTxdate(txdate);
		this.setTxtime(txtime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.util.Date txdate;
	private java.util.Date txtime;
	private java.lang.String brcode;
	private java.lang.String branchBrcode;
	private java.lang.String acctBrcode;
	private java.lang.String acctTlrno;
	private java.lang.String plTlrno;
	private java.lang.String tlrno;
	private java.lang.String tlsrno;
	private java.lang.String interno;
	private java.lang.String extno;
	private java.lang.String busikey;
	private java.lang.String srcno;
	private java.lang.String dstno;
	private java.lang.String funcCode;
	private java.lang.String txncd;
	private java.lang.String txStatus;
	private java.lang.String status;
	private java.lang.String resCode;
	private java.lang.String rcvMsg;
	private java.lang.String sendMsg;
	private java.lang.String custcd;
	private java.lang.String contractno;
	private java.lang.String appno;
	private java.lang.String country;
	private java.math.BigDecimal txamt;
	private java.lang.String miscflgs;
	private java.lang.String misc;
	private java.util.Date timestamps;
	private java.lang.String lastUpdTlr;
	private java.lang.String lastUpdFunc;
	private java.util.Date lastUpdDate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ID"
     */
	public long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TXDATE
	 */
	public java.util.Date getTxdate () {
		return txdate;
	}

	/**
	 * Set the value related to the column: TXDATE
	 * @param txdate the TXDATE value
	 */
	public void setTxdate (java.util.Date txdate) {
		this.txdate = txdate;
	}



	/**
	 * Return the value associated with the column: TXTIME
	 */
	public java.util.Date getTxtime () {
		return txtime;
	}

	/**
	 * Set the value related to the column: TXTIME
	 * @param txtime the TXTIME value
	 */
	public void setTxtime (java.util.Date txtime) {
		this.txtime = txtime;
	}



	/**
	 * Return the value associated with the column: BRCODE
	 */
	public java.lang.String getBrcode () {
		return brcode;
	}

	/**
	 * Set the value related to the column: BRCODE
	 * @param brcode the BRCODE value
	 */
	public void setBrcode (java.lang.String brcode) {
		this.brcode = brcode;
	}



	/**
	 * Return the value associated with the column: BRANCH_BRCODE
	 */
	public java.lang.String getBranchBrcode () {
		return branchBrcode;
	}

	/**
	 * Set the value related to the column: BRANCH_BRCODE
	 * @param branchBrcode the BRANCH_BRCODE value
	 */
	public void setBranchBrcode (java.lang.String branchBrcode) {
		this.branchBrcode = branchBrcode;
	}



	/**
	 * Return the value associated with the column: ACCT_BRCODE
	 */
	public java.lang.String getAcctBrcode () {
		return acctBrcode;
	}

	/**
	 * Set the value related to the column: ACCT_BRCODE
	 * @param acctBrcode the ACCT_BRCODE value
	 */
	public void setAcctBrcode (java.lang.String acctBrcode) {
		this.acctBrcode = acctBrcode;
	}



	/**
	 * Return the value associated with the column: ACCT_TLRNO
	 */
	public java.lang.String getAcctTlrno () {
		return acctTlrno;
	}

	/**
	 * Set the value related to the column: ACCT_TLRNO
	 * @param acctTlrno the ACCT_TLRNO value
	 */
	public void setAcctTlrno (java.lang.String acctTlrno) {
		this.acctTlrno = acctTlrno;
	}



	/**
	 * Return the value associated with the column: PL_TLRNO
	 */
	public java.lang.String getPlTlrno () {
		return plTlrno;
	}

	/**
	 * Set the value related to the column: PL_TLRNO
	 * @param plTlrno the PL_TLRNO value
	 */
	public void setPlTlrno (java.lang.String plTlrno) {
		this.plTlrno = plTlrno;
	}



	/**
	 * Return the value associated with the column: TLRNO
	 */
	public java.lang.String getTlrno () {
		return tlrno;
	}

	/**
	 * Set the value related to the column: TLRNO
	 * @param tlrno the TLRNO value
	 */
	public void setTlrno (java.lang.String tlrno) {
		this.tlrno = tlrno;
	}



	/**
	 * Return the value associated with the column: TLSRNO
	 */
	public java.lang.String getTlsrno () {
		return tlsrno;
	}

	/**
	 * Set the value related to the column: TLSRNO
	 * @param tlsrno the TLSRNO value
	 */
	public void setTlsrno (java.lang.String tlsrno) {
		this.tlsrno = tlsrno;
	}



	/**
	 * Return the value associated with the column: INTERNO
	 */
	public java.lang.String getInterno () {
		return interno;
	}

	/**
	 * Set the value related to the column: INTERNO
	 * @param interno the INTERNO value
	 */
	public void setInterno (java.lang.String interno) {
		this.interno = interno;
	}



	/**
	 * Return the value associated with the column: EXTNO
	 */
	public java.lang.String getExtno () {
		return extno;
	}

	/**
	 * Set the value related to the column: EXTNO
	 * @param extno the EXTNO value
	 */
	public void setExtno (java.lang.String extno) {
		this.extno = extno;
	}



	/**
	 * Return the value associated with the column: BUSIKEY
	 */
	public java.lang.String getBusikey () {
		return busikey;
	}

	/**
	 * Set the value related to the column: BUSIKEY
	 * @param busikey the BUSIKEY value
	 */
	public void setBusikey (java.lang.String busikey) {
		this.busikey = busikey;
	}



	/**
	 * Return the value associated with the column: SRCNO
	 */
	public java.lang.String getSrcno () {
		return srcno;
	}

	/**
	 * Set the value related to the column: SRCNO
	 * @param srcno the SRCNO value
	 */
	public void setSrcno (java.lang.String srcno) {
		this.srcno = srcno;
	}



	/**
	 * Return the value associated with the column: DSTNO
	 */
	public java.lang.String getDstno () {
		return dstno;
	}

	/**
	 * Set the value related to the column: DSTNO
	 * @param dstno the DSTNO value
	 */
	public void setDstno (java.lang.String dstno) {
		this.dstno = dstno;
	}



	/**
	 * Return the value associated with the column: FUNC_CODE
	 */
	public java.lang.String getFuncCode () {
		return funcCode;
	}

	/**
	 * Set the value related to the column: FUNC_CODE
	 * @param funcCode the FUNC_CODE value
	 */
	public void setFuncCode (java.lang.String funcCode) {
		this.funcCode = funcCode;
	}



	/**
	 * Return the value associated with the column: TXNCD
	 */
	public java.lang.String getTxncd () {
		return txncd;
	}

	/**
	 * Set the value related to the column: TXNCD
	 * @param txncd the TXNCD value
	 */
	public void setTxncd (java.lang.String txncd) {
		this.txncd = txncd;
	}



	/**
	 * Return the value associated with the column: TX_STATUS
	 */
	public java.lang.String getTxStatus () {
		return txStatus;
	}

	/**
	 * Set the value related to the column: TX_STATUS
	 * @param txStatus the TX_STATUS value
	 */
	public void setTxStatus (java.lang.String txStatus) {
		this.txStatus = txStatus;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: RES_CODE
	 */
	public java.lang.String getResCode () {
		return resCode;
	}

	/**
	 * Set the value related to the column: RES_CODE
	 * @param resCode the RES_CODE value
	 */
	public void setResCode (java.lang.String resCode) {
		this.resCode = resCode;
	}



	/**
	 * Return the value associated with the column: RCV_MSG
	 */
	public java.lang.String getRcvMsg () {
		return rcvMsg;
	}

	/**
	 * Set the value related to the column: RCV_MSG
	 * @param rcvMsg the RCV_MSG value
	 */
	public void setRcvMsg (java.lang.String rcvMsg) {
		this.rcvMsg = rcvMsg;
	}



	/**
	 * Return the value associated with the column: SEND_MSG
	 */
	public java.lang.String getSendMsg () {
		return sendMsg;
	}

	/**
	 * Set the value related to the column: SEND_MSG
	 * @param sendMsg the SEND_MSG value
	 */
	public void setSendMsg (java.lang.String sendMsg) {
		this.sendMsg = sendMsg;
	}



	/**
	 * Return the value associated with the column: CUSTCD
	 */
	public java.lang.String getCustcd () {
		return custcd;
	}

	/**
	 * Set the value related to the column: CUSTCD
	 * @param custcd the CUSTCD value
	 */
	public void setCustcd (java.lang.String custcd) {
		this.custcd = custcd;
	}



	/**
	 * Return the value associated with the column: CONTRACTNO
	 */
	public java.lang.String getContractno () {
		return contractno;
	}

	/**
	 * Set the value related to the column: CONTRACTNO
	 * @param contractno the CONTRACTNO value
	 */
	public void setContractno (java.lang.String contractno) {
		this.contractno = contractno;
	}



	/**
	 * Return the value associated with the column: APPNO
	 */
	public java.lang.String getAppno () {
		return appno;
	}

	/**
	 * Set the value related to the column: APPNO
	 * @param appno the APPNO value
	 */
	public void setAppno (java.lang.String appno) {
		this.appno = appno;
	}



	/**
	 * Return the value associated with the column: COUNTRY
	 */
	public java.lang.String getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: COUNTRY
	 * @param country the COUNTRY value
	 */
	public void setCountry (java.lang.String country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: TXAMT
	 */
	public java.math.BigDecimal getTxamt () {
		return txamt;
	}

	/**
	 * Set the value related to the column: TXAMT
	 * @param txamt the TXAMT value
	 */
	public void setTxamt (java.math.BigDecimal txamt) {
		this.txamt = txamt;
	}



	/**
	 * Return the value associated with the column: MISCFLGS
	 */
	public java.lang.String getMiscflgs () {
		return miscflgs;
	}

	/**
	 * Set the value related to the column: MISCFLGS
	 * @param miscflgs the MISCFLGS value
	 */
	public void setMiscflgs (java.lang.String miscflgs) {
		this.miscflgs = miscflgs;
	}



	/**
	 * Return the value associated with the column: MISC
	 */
	public java.lang.String getMisc () {
		return misc;
	}

	/**
	 * Set the value related to the column: MISC
	 * @param misc the MISC value
	 */
	public void setMisc (java.lang.String misc) {
		this.misc = misc;
	}



	/**
	 * Return the value associated with the column: TIMESTAMPS
	 */
	public java.util.Date getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: TIMESTAMPS
	 * @param timestamps the TIMESTAMPS value
	 */
	public void setTimestamps (java.util.Date timestamps) {
		this.timestamps = timestamps;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_TLR
	 */
	public java.lang.String getLastUpdTlr () {
		return lastUpdTlr;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TLR
	 * @param lastUpdTlr the LAST_UPD_TLR value
	 */
	public void setLastUpdTlr (java.lang.String lastUpdTlr) {
		this.lastUpdTlr = lastUpdTlr;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_FUNC
	 */
	public java.lang.String getLastUpdFunc () {
		return lastUpdFunc;
	}

	/**
	 * Set the value related to the column: LAST_UPD_FUNC
	 * @param lastUpdFunc the LAST_UPD_FUNC value
	 */
	public void setLastUpdFunc (java.lang.String lastUpdFunc) {
		this.lastUpdFunc = lastUpdFunc;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_DATE
	 */
	public java.util.Date getLastUpdDate () {
		return lastUpdDate;
	}

	/**
	 * Set the value related to the column: LAST_UPD_DATE
	 * @param lastUpdDate the LAST_UPD_DATE value
	 */
	public void setLastUpdDate (java.util.Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.CommLog)) return false;
		else {
			com.huateng.ebank.entity.data.mng.CommLog commLog = (com.huateng.ebank.entity.data.mng.CommLog) obj;
			return (this.getId() == commLog.getId());
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			return (int) this.getId();
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}