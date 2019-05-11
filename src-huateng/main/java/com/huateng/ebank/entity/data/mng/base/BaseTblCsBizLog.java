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

public abstract class BaseTblCsBizLog  implements Serializable {

	public static String REF = "TblBizLog";
	public static String PROP_ID = "id";
	public static String PROP_LOGID = "logId";
	public static String PROP_TXNDATE = "txnDate";
	public static String PROP_TXNSTARTTIME = "txnStartTime";
	public static String PROP_TXNENDTIME = "txnEndTime";
	public static String PROP_TXNRUNTIME = "txnRunTime";
	public static String PROP_BRCODE = "brCode";
	public static String PROP_OPRCODE = "oprCode";
	public static String PROP_IPADR = "ipAdr";
	public static String PROP_FUNCID = "funcId";
	public static String PROP_OPRTXNCD = "oprTxnCd";
	public static String PROP_TXNBIZLOG1 = "txnBizLog1";
	public static String PROP_TXNBIZLOG2 = "txnBizLog2";
	public static String PROP_TXNSTATUS = "txnStatus";
	public static String PROP_TXNFAILLOG = "txnFailLog";

	// constructors
	public BaseTblCsBizLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTblCsBizLog (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}


	// primary key
	private java.lang.String id;
	private java.lang.String logId;
	private java.lang.String txnDate;
	private java.lang.String txnStartTime;
	private java.lang.String txnEndTime;
	private java.lang.Long txnRunTime;
	private java.lang.String brCode;
	private java.lang.String oprCode;
	private java.lang.String ipAdr;
	private java.lang.String funcId;
	private java.lang.String oprTxnCd;
	private java.lang.String txnBizLog1;
	private java.lang.String txnBizLog2;
	private java.lang.String txnStatus;
	private java.lang.String txnFailLog;

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getLogId() {
		return logId;
	}

	public void setLogId(java.lang.String logId) {
		this.logId = logId;
	}

	public java.lang.String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(java.lang.String txnDate) {
		this.txnDate = txnDate;
	}

	public java.lang.String getTxnStartTime() {
		return txnStartTime;
	}

	public void setTxnStartTime(java.lang.String txnStartTime) {
		this.txnStartTime = txnStartTime;
	}

	public java.lang.String getTxnEndTime() {
		return txnEndTime;
	}

	public void setTxnEndTime(java.lang.String txnEndTime) {
		this.txnEndTime = txnEndTime;
	}

	public java.lang.Long getTxnRunTime() {
		return txnRunTime;
	}

	public void setTxnRunTime(java.lang.Long txnRunTime) {
		this.txnRunTime = txnRunTime;
	}

	public java.lang.String getOprCode() {
		return oprCode;
	}

	public void setOprCode(java.lang.String oprCode) {
		this.oprCode = oprCode;
	}

	public java.lang.String getIpAdr() {
		return ipAdr;
	}

	public void setIpAdr(java.lang.String ipAdr) {
		this.ipAdr = ipAdr;
	}

	public java.lang.String getFuncId() {
		return funcId;
	}

	public void setFuncId(java.lang.String funcId) {
		this.funcId = funcId;
	}

	public java.lang.String getOprTxnCd() {
		return oprTxnCd;
	}

	public void setOprTxnCd(java.lang.String oprTxnCd) {
		this.oprTxnCd = oprTxnCd;
	}

	public java.lang.String getTxnBizLog1() {
		return txnBizLog1;
	}

	public void setTxnBizLog1(java.lang.String txnBizLog1) {
		this.txnBizLog1 = txnBizLog1;
	}

	public java.lang.String getTxnBizLog2() {
		return txnBizLog2;
	}

	public void setTxnBizLog2(java.lang.String txnBizLog2) {
		this.txnBizLog2 = txnBizLog2;
	}

	public java.lang.String getTxnStatus() {
		return txnStatus;
	}

	public void setTxnStatus(java.lang.String txnStatus) {
		this.txnStatus = txnStatus;
	}

	public java.lang.String getTxnFailLog() {
		return txnFailLog;
	}

	public void setTxnFailLog(java.lang.String txnFailLog) {
		this.txnFailLog = txnFailLog;
	}

	public java.lang.String getBrCode() {
		return brCode;
	}

	public void setBrCode(java.lang.String brCode) {
		this.brCode = brCode;
	}











}