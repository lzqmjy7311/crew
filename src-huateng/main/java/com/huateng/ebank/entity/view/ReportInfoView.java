/*
 * Created on 2005-7-14
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.entity.view;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ReportInfoView {
	private boolean selected = false;
    private String  reporttype  = "";
    private String  reportname = "";
    private int  roleid = 0;
    private String roleName = "";


	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return Returns the reportname.
	 */
	public String getReportname() {
		return reportname;
	}
	/**
	 * @param reportname The reportname to set.
	 */
	public void setReportname(String reportname) {
		this.reportname = reportname;
	}
	/**
	 * @return Returns the reporttype.
	 */
	public String getReporttype() {
		return reporttype;
	}
	/**
	 * @param reporttype The reporttype to set.
	 */
	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
	}
	/**
	 * @return Returns the roleid.
	 */
	public int getRoleid() {
		return roleid;
	}
	/**
	 * @param roleid The roleid to set.
	 */
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	/**
	 * @return Returns the selected.
	 */
	public boolean isSelected() {
		return selected;
	}
	/**
	 * @param selected The selected to set.
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
