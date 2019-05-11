package com.huateng.ebank.business.dataquery.bean;

import java.io.Serializable;
/**
 * 日志与操作员关联视图
 * @author 111111
 *
 */
public class TblCsBizLogView implements Serializable{
	private java.lang.String id;
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
	private java.lang.String tlrName;
	private java.lang.String misc;
	
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
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
	public java.lang.String getBrCode() {
		return brCode;
	}
	public void setBrCode(java.lang.String brCode) {
		this.brCode = brCode;
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
	public java.lang.String getTlrName() {
		return tlrName;
	}
	public void setTlrName(java.lang.String tlrName) {
		this.tlrName = tlrName;
	}
	public java.lang.String getMisc() {
		return misc;
	}
	public void setMisc(java.lang.String misc) {
		this.misc = misc;
	}
	public TblCsBizLogView(String id, String txnDate, String txnStartTime,
			String txnEndTime, Long txnRunTime, String brCode, String oprCode,
			String ipAdr, String funcId, String oprTxnCd, String txnBizLog1,
			String txnBizLog2, String txnStatus, String txnFailLog,
			String tlrName) {
		super();
		this.id = id;
		this.txnDate = txnDate;
		this.txnStartTime = txnStartTime;
		this.txnEndTime = txnEndTime;
		this.txnRunTime = txnRunTime;
		this.brCode = brCode;
		this.oprCode = oprCode;
		this.ipAdr = ipAdr;
		this.funcId = funcId;
		this.oprTxnCd = oprTxnCd;
		this.txnBizLog1 = txnBizLog1;
		this.txnBizLog2 = txnBizLog2;
		this.txnStatus = txnStatus;
		this.txnFailLog = txnFailLog;
		this.tlrName = tlrName;
	}
	
}
