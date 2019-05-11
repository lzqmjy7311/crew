package com.huateng.ebank.entity.view;

import java.util.ArrayList;
import java.util.List;

import com.huateng.ebank.entity.data.mng.RoleInfo;

/**
 * global info 扩展bean
 * @author pengning
 *
 */
public class ExtensBean {

	private String tlrName;//用户名称
	private List<RoleInfo> roleList = new ArrayList<RoleInfo>();//岗位列表
	private boolean headerOrg=false;//是否是总行机构
	
	public boolean getHeaderOrg() {
		return headerOrg;
	}
	public void setHeaderOrg(boolean headerOrg) {
		this.headerOrg = headerOrg;
	}
	public String getTlrName() {
		return tlrName;
	}
	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}
	public List<RoleInfo> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<RoleInfo> roleList) {
		this.roleList = roleList;
	}
	public ExtensBean() {
	}
	
	/**
	 * 用户角色类型 CM对公 PL对私
	 */
	private String roleSysType;
	public String getRoleSysType() {
		return roleSysType;
	}
	public void setRoleSysType(String roleSysType) {
		this.roleSysType = roleSysType;
	}

}
