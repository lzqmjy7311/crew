package com.gbicc.rule.service;


public class RuleCallResult {
	private boolean success=true;
	private boolean isSynchronize;
	private String execid;
	private String rulecode;
	private String rowdate;
	private String message;
	public boolean isSynchronize() {
		return isSynchronize;
	}
	public void setSynchronize(boolean isSynchronize) {
		this.isSynchronize = isSynchronize;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getExecid() {
		return execid;
	}
	public void setExecid(String execid) {
		this.execid = execid;
	}
	public String getRulecode() {
		return rulecode;
	}
	public void setRulecode(String rulecode) {
		this.rulecode = rulecode;
	}
	public String getRowdate() {
		return rowdate;
	}
	public void setRowdate(String rowdate) {
		this.rowdate = rowdate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "RuleCallResult [success=" + success + ", isSynchronize="
				+ isSynchronize + ", execid=" + execid + ", rulecode="
				+ rulecode + ", rowdate=" + rowdate + ", message=" + message
				+ "]";
	}
}
