package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseRoleInfo;

public class RoleInfo extends BaseRoleInfo {
	private static final long serialVersionUID = 1L;
	private String roleList;
	private String statusModFlag;
	private String fucUrl;
	
	/**
	 * 岗位ID
	 */
	private Integer roleId;
	public Integer getRoleId() {
		return this.getId();
	}

	/**
	 * OrgId
	 */
	private String orgId;
	
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * 是否默认选中
	 * 1 选中 0 不选中
	 */
	private String selected="0";
	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	/**
	 * 是否默认
	 * 1 是 0 否
	 */
	private String isDefault="0";

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * CM 对公
	 * PL 对私
	 */
	private String roleSysType;
	
	public String getRoleSysType() {
		return roleSysType;
	}

	public void setRoleSysType(String roleSysType) {
		this.roleSysType = roleSysType;
	}

	public String getFucUrl() {
		return fucUrl;
	}

	public void setFucUrl(String fucUrl) {
		this.fucUrl = fucUrl;
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public RoleInfo() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public RoleInfo(java.lang.Integer id) {
		super(id);
	}

	public String getRoleList() {
		return roleList;
	}

	public void setRoleList(String roleList) {
		this.roleList = roleList;
	}

	public String getStatusModFlag() {
		return statusModFlag;
	}

	public void setStatusModFlag(String statusModFlag) {
		this.statusModFlag = statusModFlag;
	}

	/* [CONSTRUCTOR MARKER END] */

}