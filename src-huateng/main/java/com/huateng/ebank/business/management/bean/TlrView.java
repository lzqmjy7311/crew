package com.huateng.ebank.business.management.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 操作员视图类
 *
 * @author hyurain_yang
 *
 */
public class TlrView {
	private String brcode;
	private String brno;
	private String brname;
	private String tlrno;
	private String extTlrno;
	private String passwd;
	private String tlrName;
	private String status;
	private String loginIp;
	private String flag;
	private String creatDate;
	private String latelyLoginTime;
	private String latelyLogoutTime;
	private Date effectDate;
	private Date expireDate;
	private String defRoleid;

	//部门信息 add by tanyang

	private long departmentCode;
	private String departmentName;


	public String getDefRoleid() {
		return defRoleid;
	}

	public void setDefRoleid(String defRoleid) {
		this.defRoleid = defRoleid;
	}

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public String getBrno() {
		return brno;
	}

	public void setBrno(String brno) {
		this.brno = brno;
	}

	public String getTlrno() {
		return tlrno;
	}

	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}

	public String getExtTlrno() {
		return extTlrno;
	}

	public void setExtTlrno(String extTlrno) {
		this.extTlrno = extTlrno;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	public String getLatelyLoginTime() {
		return latelyLoginTime;
	}

	public void setLatelyLoginTime(String latelyLoginTime) {
		this.latelyLoginTime = latelyLoginTime;
	}

	public String getLatelyLogoutTime() {
		return latelyLogoutTime;
	}

	public void setLatelyLogoutTime(String latelyLogoutTime) {
		this.latelyLogoutTime = latelyLogoutTime;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getBrname() {
		return brname;
	}

	public void setBrname(String brname) {
		this.brname = brname;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	//部门信息 add by tanyang
	public long getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(long departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



}
