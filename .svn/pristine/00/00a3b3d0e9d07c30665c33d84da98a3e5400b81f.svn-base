package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the REPORT_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="REPORT_INFO"
 */

public abstract class BaseReportInfo  implements Serializable {

	public static String REF = "ReportInfo";
	public static String PROP_REPORT_NAME = "reportName";
	public static String PROP_REPORT_TYPE = "reportType";
	public static String PROP_FILE_NAME = "fileName";
	public static String PROP_REPORT_CODE = "reportCode";
	public static String PROP_OPEN_FLAG = "openFlag";


	// constructors
	public BaseReportInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReportInfo (java.lang.String reportType) {
		this.setReportType(reportType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String reportType;

	// fields
	private java.lang.String openFlag;
	private java.lang.String reportCode;
	private java.lang.String reportName;
	private java.lang.String fileName;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="REPORT_TYPE"
     */
	public java.lang.String getReportType () {
		return reportType;
	}

	/**
	 * Set the unique identifier of this class
	 * @param reportType the new ID
	 */
	public void setReportType (java.lang.String reportType) {
		this.reportType = reportType;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: OPEN_FLAG
	 */
	public java.lang.String getOpenFlag () {
		return openFlag;
	}

	/**
	 * Set the value related to the column: OPEN_FLAG
	 * @param openFlag the OPEN_FLAG value
	 */
	public void setOpenFlag (java.lang.String openFlag) {
		this.openFlag = openFlag;
	}



	/**
	 * Return the value associated with the column: REPORT_CODE
	 */
	public java.lang.String getReportCode () {
		return reportCode;
	}

	/**
	 * Set the value related to the column: REPORT_CODE
	 * @param reportCode the REPORT_CODE value
	 */
	public void setReportCode (java.lang.String reportCode) {
		this.reportCode = reportCode;
	}



	/**
	 * Return the value associated with the column: REPORT_NAME
	 */
	public java.lang.String getReportName () {
		return reportName;
	}

	/**
	 * Set the value related to the column: REPORT_NAME
	 * @param reportName the REPORT_NAME value
	 */
	public void setReportName (java.lang.String reportName) {
		this.reportName = reportName;
	}



	/**
	 * Return the value associated with the column: FILE_NAME
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: FILE_NAME
	 * @param fileName the FILE_NAME value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.ReportInfo)) return false;
		else {
			com.huateng.ebank.entity.data.mng.ReportInfo reportInfo = (com.huateng.ebank.entity.data.mng.ReportInfo) obj;
			if (null == this.getReportType() || null == reportInfo.getReportType()) return false;
			else return (this.getReportType().equals(reportInfo.getReportType()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getReportType()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getReportType().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}