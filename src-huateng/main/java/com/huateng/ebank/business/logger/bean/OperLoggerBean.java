package com.huateng.ebank.business.logger.bean;


/**
 * 操作日志Bean
 * @author kevin_qin
 *
 */
public class OperLoggerBean {

	private static final long serialVersionUID = 1L;

	private String id;        //ID
	private String stdstartnm;//起始记录数
	private String stdquerynm;//查询记录数
	private String txnDate;//交易日期
	private String brcode;//机构号
	private String oprcode;//操作员号
	private String ipAdr;//IP地址
	private String oprtxncd;//操作
	private String txnBizLog;//日志信息
	private String txnStatus;//交易状态

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStdstartnm() {
		return stdstartnm;
	}
	public void setStdstartnm(String stdstartnm) {
		this.stdstartnm = stdstartnm;
	}
	public String getStdquerynm() {
		return stdquerynm;
	}
	public void setStdquerynm(String stdquerynm) {
		this.stdquerynm = stdquerynm;
	}
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public String getIpAdr() {
		return ipAdr;
	}
	public void setIpAdr(String ipAdr) {
		this.ipAdr = ipAdr;
	}
	public String getOprtxncd() {
		return oprtxncd;
	}
	public void setOprtxncd(String oprtxncd) {
		this.oprtxncd = oprtxncd;
	}
	public String getTxnBizLog() {
		return txnBizLog;
	}
	public void setTxnBizLog(String txnBizLog) {
		this.txnBizLog = txnBizLog;
	}
	public String getTxnStatus() {
		return txnStatus;
	}
	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}

}
