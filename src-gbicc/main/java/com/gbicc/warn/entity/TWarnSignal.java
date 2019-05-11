package com.gbicc.warn.entity;

import java.io.Serializable;
import java.util.Date;

import com.gbicc.person.customer.entity.TCustomer;


/**
 * @author xudongdong
 *
 * 版本：2015年11月2日 下午7:10:03
 * 类说明：预警信号实体类
 */
public class TWarnSignal implements Serializable {

	private static final long serialVersionUID = -2631760787710321152L;

	 /*
	    */
	    private String id;
	    /*
	    * 预警编号.
	    */
	    private String warnCode;
	    /*
	    * 预警等级.
	    */
	    private String warnLEvel;
	    /*
	    * 预警名称
	    */
	    private String affPerDesc;
	    /*
	    * 查证情况.
	    */
	    private String checkStatus;
	    /*
	    * 查证描述.
	    */
	    private String checkDesc;
	    /*
	    * 规则id.
	    */
	    private String ruleId;
	    /*
	     * 报表id.
	     */
	    private String reportId;
	    /*
	     * 账号ID
	     */
	    private String loanAccount;
	    /*
	     * 规则描述
	     */
	    private String warnDesc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWarnCode() {
		return warnCode;
	}
	public void setWarnCode(String warnCode) {
		this.warnCode = warnCode;
	}
	public String getWarnLEvel() {
		return warnLEvel;
	}
	public void setWarnLEvel(String warnLEvel) {
		this.warnLEvel = warnLEvel;
	}
	public String getAffPerDesc() {
		return affPerDesc;
	}
	public void setAffPerDesc(String affPerDesc) {
		this.affPerDesc = affPerDesc;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getCheckDesc() {
		return checkDesc;
	}
	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getLoanAccount() {
		return loanAccount;
	}
	public void setLoanAccount(String loanAccount) {
		this.loanAccount = loanAccount;
	}
	public String getWarnDesc() {
		return warnDesc;
	}
	public void setWarnDesc(String warnDesc) {
		this.warnDesc = warnDesc;
	}
    
	
}
