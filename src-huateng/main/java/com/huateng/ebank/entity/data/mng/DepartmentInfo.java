package com.huateng.ebank.entity.data.mng;

import java.util.Date;

import com.huateng.ebank.entity.data.mng.base.AbstractDepartmentInfo;

/**
 * DepartmentInfo entity.
 *
 * @author MyEclipse Persistence Tools
 */
public class DepartmentInfo extends AbstractDepartmentInfo implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public DepartmentInfo() {
	}

	/** minimal constructor */
	public DepartmentInfo(long departmentCode, String departmentName, String brcode, String status) {
		super(departmentCode, departmentName, brcode, status);
	}

	/** full constructor */
	public DepartmentInfo(long departmentCode, String departmentName,
			String brcode, String status, String lastUpdTlr, Date lastUpdDate,
			String BZ, String misc, String misc2, String misc3, String misc4) {
		super(departmentCode, departmentName, brcode, status, lastUpdTlr, lastUpdDate,
				BZ, misc, misc2, misc3, misc4);
	}

}
