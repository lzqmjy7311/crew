package com.gbicc.bpm.entity;

import java.util.Date;

public class TaskDivertP {
	private String id;
	private String taskCode;
	private String rootFlag;
	private String taskType;
	private String taskTypeName;
	private String custCode;
	private String custName;
	private String taskStatusNo;
	private String taskStatus;
	private Date createTime;
	private String tlrInfo;
	private String tlrNo;
	private String tlrName;
	private String roleId;
	private String brCode;
	private String brName;
	private String brClass;

	public String getBrClass() {
		return brClass;
	}

	public void setBrClass(String brClass) {
		this.brClass = brClass;
	}

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getRootFlag() {
		return rootFlag;
	}

	public void setRootFlag(String rootFlag) {
		this.rootFlag = rootFlag;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskTypeName() {
		return taskTypeName;
	}

	public void setTaskTypeName(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getTaskStatusNo() {
		return taskStatusNo;
	}

	public void setTaskStatusNo(String taskStatusNo) {
		this.taskStatusNo = taskStatusNo;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTlrInfo() {
		return tlrInfo;
	}

	public void setTlrInfo(String tlrInfo) {
		this.tlrInfo = tlrInfo;
	}

	public String getTlrNo() {
		return tlrNo;
	}

	public void setTlrNo(String tlrNo) {
		this.tlrNo = tlrNo;
	}

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}