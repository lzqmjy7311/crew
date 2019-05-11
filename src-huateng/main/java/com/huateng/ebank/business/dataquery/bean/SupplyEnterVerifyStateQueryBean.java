package com.huateng.ebank.business.dataquery.bean;

import java.io.Serializable;
import java.util.Date;

/*
 *
 * 补录审核情况查询bean
 */
public class SupplyEnterVerifyStateQueryBean implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String brNo;
	private String brName;
	private String workDate;
//	private String recordType;//记录类型
//	private Integer recordTotalCount;//记录总数
//	private Integer recordNotAddNeedCount;//不需要补录
//	private Integer recordAddNeedCount;//需要补录
//	private Date supplyEnterCheckTm;//补录确认时间
//	private Date attitudeCheckTm;//审核确认时间

	private String apptype;
	private String currentfile;
	private int noedit;//01-可编辑
	private int editWaitConfirm;//02-编辑待确认
	private int confirmWaitAudit;//03-确认待审核
	private int auditWaitConfirm;//04-审核未确认
	private int confirmPass;//05-审核已确认
	private int sendreport; // 06-已上报



	public SupplyEnterVerifyStateQueryBean() {
	}

	public SupplyEnterVerifyStateQueryBean(String brNo, String brName,
			String workDate, String recordType, Integer recordTotalCount,
			Integer recordNotAddNeedCount, Integer recordAddNeedCount,
			Date supplyEnterCheckTm, Date attitudeCheckTm) {
		super();
		this.brNo = brNo;
		this.brName = brName;
		this.workDate = workDate;
//		this.recordType = recordType;
//		this.recordTotalCount = recordTotalCount;
//		this.recordNotAddNeedCount = recordNotAddNeedCount;
//		this.recordAddNeedCount = recordAddNeedCount;
//		this.supplyEnterCheckTm = supplyEnterCheckTm;
//		this.attitudeCheckTm = attitudeCheckTm;
	}

	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
//	public String getRecordType() {
//		return recordType;
//	}
//	public void setRecordType(String recordType) {
//		this.recordType = recordType;
//	}
//	public int getRecordTotalCount() {
//		return recordTotalCount;
//	}
//	public void setRecordTotalCount(int recordTotalCount) {
//		this.recordTotalCount = recordTotalCount;
//	}
//	public int getRecordNotAddNeedCount() {
//		return recordNotAddNeedCount;
//	}
//	public void setRecordNotAddNeedCount(int recordNotAddNeedCount) {
//		this.recordNotAddNeedCount = recordNotAddNeedCount;
//	}
//	public int getRecordAddNeedCount() {
//		return recordAddNeedCount;
//	}
//	public void setRecordAddNeedCount(int recordAddNeedCount) {
//		this.recordAddNeedCount = recordAddNeedCount;
//	}
//	public Date getSupplyEnterCheckTm() {
//		return supplyEnterCheckTm;
//	}
//	public void setSupplyEnterCheckTm(Date supplyEnterCheckTm) {
//		this.supplyEnterCheckTm = supplyEnterCheckTm;
//	}
//	public Date getAttitudeCheckTm() {
//		return attitudeCheckTm;
//	}
//	public void setAttitudeCheckTm(Date attitudeCheckTm) {
//		this.attitudeCheckTm = attitudeCheckTm;
//	}

	public int getNoedit() {
		return noedit;
	}

	public void setNoedit(int noedit) {
		this.noedit = noedit;
	}

	public int getEditWaitConfirm() {
		return editWaitConfirm;
	}

	public void setEditWaitConfirm(int editWaitConfirm) {
		this.editWaitConfirm = editWaitConfirm;
	}

	public int getConfirmWaitAudit() {
		return confirmWaitAudit;
	}

	public void setConfirmWaitAudit(int confirmWaitAudit) {
		this.confirmWaitAudit = confirmWaitAudit;
	}

	public int getAuditWaitConfirm() {
		return auditWaitConfirm;
	}

	public void setAuditWaitConfirm(int auditWaitConfirm) {
		this.auditWaitConfirm = auditWaitConfirm;
	}


	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getCurrentfile() {
		return currentfile;
	}

	public void setCurrentfile(String currentfile) {
		this.currentfile = currentfile;
	}

	public int getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(int confirmPass) {
		this.confirmPass = confirmPass;
	}

	public int getSendreport() {
		return sendreport;
	}

	public void setSendreport(int sendreport) {
		this.sendreport = sendreport;
	}
}