package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseRoleReportParam;



public class RoleReportParam extends BaseRoleReportParam {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public RoleReportParam () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public RoleReportParam (
		java.lang.String reportType,
		java.lang.Integer roleId) {

		super (
			reportType,
			roleId);
	}

/*[CONSTRUCTOR MARKER END]*/


}