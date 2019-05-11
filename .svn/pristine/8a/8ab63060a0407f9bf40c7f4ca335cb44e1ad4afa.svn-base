package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ROLE_REPORT_PARAM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ROLE_REPORT_PARAM"
 */

public abstract class BaseRoleReportParam  implements Serializable {

	public static String REF = "RoleReportParam";


	// constructors
	public BaseRoleReportParam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRoleReportParam (
		java.lang.String reportType,
		java.lang.Integer roleId) {

		this.setReportType(reportType);
		this.setRoleId(roleId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private java.lang.String reportType;

	private java.lang.Integer roleId;



	/**
     * @hibernate.property
     *  column=REPORT_TYPE
	 * not-null=true
	 */
	public java.lang.String getReportType () {
		return this.reportType;
	}

	/**
	 * Set the value related to the column: REPORT_TYPE
	 * @param reportType the REPORT_TYPE value
	 */
	public void setReportType (java.lang.String reportType) {
		this.reportType = reportType;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
     * @hibernate.property
     *  column=ROLE_ID
	 * not-null=true
	 */
	public java.lang.Integer getRoleId () {
		return this.roleId;
	}

	/**
	 * Set the value related to the column: ROLE_ID
	 * @param roleId the ROLE_ID value
	 */
	public void setRoleId (java.lang.Integer roleId) {
		this.roleId = roleId;
		this.hashCode = Integer.MIN_VALUE;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.RoleReportParam)) return false;
		else {
			com.huateng.ebank.entity.data.mng.RoleReportParam roleReportParam = (com.huateng.ebank.entity.data.mng.RoleReportParam) obj;
			if (null != this.getReportType() && null != roleReportParam.getReportType()) {
				if (!this.getReportType().equals(roleReportParam.getReportType())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getRoleId() && null != roleReportParam.getRoleId()) {
				if (!this.getRoleId().equals(roleReportParam.getRoleId())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuffer sb = new StringBuffer();
			if (null != this.getReportType()) {
				sb.append(this.getReportType().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getRoleId()) {
				sb.append(this.getRoleId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}