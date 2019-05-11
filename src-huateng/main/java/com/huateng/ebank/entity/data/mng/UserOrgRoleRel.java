package com.huateng.ebank.entity.data.mng;

import java.io.Serializable;

/**
 * 用户 机构 角色中间表
 * @date    2016年3月23日
 * @author  tangdu
 * @desc
 */
public class UserOrgRoleRel implements Serializable{
	private static final long serialVersionUID = -2181450296300814585L;
	private String id;
	private String userId;
	private String roleId;
	private String orgId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	
}
