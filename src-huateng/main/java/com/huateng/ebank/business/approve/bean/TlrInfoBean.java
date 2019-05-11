package com.huateng.ebank.business.approve.bean;

import java.io.Serializable;
import java.util.List;

public class TlrInfoBean  implements Serializable {
	private String brcode;
	private String tlrno;
	private String tlrName;
	private String flag;
	private boolean selected = false;
	private String roleId;
	private String roleName;
	private String password;
	private String brcodeOld;
	private String tlrnoOld;
	private String tlrNameOld;
	private String flagOld;
	private List rolelist;
	private String restFlg;
	private String selectedFlg;
	private String newFlg;
	public String getNewFlg() {
		return newFlg;
	}
	public void setNewFlg(String newFlg) {
		this.newFlg = newFlg;
	}
	public String getSelectedFlg() {
		return selectedFlg;
	}
	public void setSelectedFlg(String selectedFlg) {
		this.selectedFlg = selectedFlg;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public List getRolelist() {
		return rolelist;
	}
	public void setRolelist(List rolelist) {
		this.rolelist = rolelist;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public String getTlrno() {
		return tlrno;
	}
	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}
	public String getTlrName() {
		return tlrName;
	}
	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getBrcodeOld() {
		return brcodeOld;
	}
	public void setBrcodeOld(String brcodeOld) {
		this.brcodeOld = brcodeOld;
	}
	public String getTlrnoOld() {
		return tlrnoOld;
	}
	public void setTlrnoOld(String tlrnoOld) {
		this.tlrnoOld = tlrnoOld;
	}
	public String getTlrNameOld() {
		return tlrNameOld;
	}
	public void setTlrNameOld(String tlrNameOld) {
		this.tlrNameOld = tlrNameOld;
	}
	public String getFlagOld() {
		return flagOld;
	}
	public void setFlagOld(String flagOld) {
		this.flagOld = flagOld;
	}
	public String getRestFlg() {
		return restFlg;
	}
	public void setRestFlg(String restFlg) {
		this.restFlg = restFlg;
	};
}