package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BIZ_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BIZ_LOG"
 */

public abstract class BaseBizLog  implements Serializable {

	public static String REF = "BizLog";
	public static String PROP_IP = "ip";
	public static String PROP_CURCD = "curcd";
	public static String PROP_TLRNO = "tlrno";
	public static String PROP_TLSRNO = "tlsrno";
	public static String PROP_MISC = "misc";
	public static String PROP_TXAMT = "txamt";
	public static String PROP_BRANCH_BRCODE = "branchBrcode";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_CONTRACTNO = "contractno";
	public static String PROP_STATUS = "status";
	public static String PROP_CUSTCD = "custcd";
	public static String PROP_TXDATE = "txdate";
	public static String PROP_BRCODE = "brcode";
	public static String PROP_BIZ_FUNC_CODE = "bizFuncCode";
	public static String PROP_ERR_CODE = "errCode";
	public static String PROP_ID = "id";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_APPNO = "appno";
	public static String PROP_TXTIME = "txtime";


	// constructors
	public BaseBizLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBizLog (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBizLog (
		long id,
		java.util.Date txdate,
		java.lang.String brcode,
		java.lang.String tlrno,
		java.lang.String tlsrno) {

		this.setId(id);
		this.setTxdate(txdate);
		this.setBrcode(brcode);
		this.setTlrno(tlrno);
		this.setTlsrno(tlsrno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.util.Date txdate;
	private java.lang.String brcode;
	private java.lang.String tlrno;
	private java.lang.String tlsrno;
	private java.lang.String branchBrcode;
	private java.util.Date txtime;
	private java.lang.String ip;
	private java.lang.String bizFuncCode;
	private java.lang.String errCode;
	private java.lang.String status;
	private java.lang.String contractno;
	private java.lang.String custcd;
	private java.lang.String appno;
	private java.lang.String curcd;
	private java.math.BigDecimal txamt;
	private java.util.Date timestamps;
	private java.lang.String miscflgs;
	private java.lang.String misc;



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
	 * Return the value associated with the column: IP
	 */
	public java.lang.String getIp () {
		return ip;
	}

	/**
	 * Set the value related to the column: IP
	 * @param ip the IP value
	 */
	public void setIp (java.lang.String ip) {
		this.ip = ip;
	}



	/**
	 * Return the value associated with the column: BIZ_FUNC_CODE
	 */
	public java.lang.String getBizFuncCode () {
		return bizFuncCode;
	}

	/**
	 * Set the value related to the column: BIZ_FUNC_CODE
	 * @param bizFuncCode the BIZ_FUNC_CODE value
	 */
	public void setBizFuncCode (java.lang.String bizFuncCode) {
		this.bizFuncCode = bizFuncCode;
	}



	/**
	 * Return the value associated with the column: ERR_CODE
	 */
	public java.lang.String getErrCode () {
		return errCode;
	}

	/**
	 * Set the value related to the column: ERR_CODE
	 * @param errCode the ERR_CODE value
	 */
	public void setErrCode (java.lang.String errCode) {
		this.errCode = errCode;
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
	 * Return the value associated with the column: CURCD
	 */
	public java.lang.String getCurcd () {
		return curcd;
	}

	/**
	 * Set the value related to the column: CURCD
	 * @param curcd the CURCD value
	 */
	public void setCurcd (java.lang.String curcd) {
		this.curcd = curcd;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.BizLog)) return false;
		else {
			com.huateng.ebank.entity.data.mng.BizLog bizLog = (com.huateng.ebank.entity.data.mng.BizLog) obj;
			return (this.getId() == bizLog.getId());
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			return (int) this.getId();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}