package com.gbicc.common.Industry.entity;

import java.io.Serializable;

/**
 * This is an object that contains data related to the T_CW_INDUSTRY_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="T_CW_INDUSTRY_INFO"
 */

public abstract class BaseIndustryInfo  implements Serializable {

	public static String REF = "IndustryInfo";
	public static String PROP_STATUS = "status";
	public static String PROP_UP_FUNC_CODE = "upFuncCode";
	public static String PROP_FUNC_TYPE = "funcType";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_FUNC_CLASS = "funcClass";
	public static String PROP_ISDIRECTORY = "isdirectory";
	public static String PROP_MISC = "misc";
	public static String PROP_PAGEPATH = "pagepath";
	public static String PROP_FUNCNAME = "funcname";
	public static String PROP_WORKFLOW_FLAG = "workflowFlag";
	public static String PROP_LASTDIRECTORY = "lastdirectory";
	public static String PROP_SHOWSEQ = "showseq";
	public static String PROP_FUNC_DESC = "funcDesc";
	public static String PROP_ID = "id";
	public static String PROP_LOCATION = "location";
	public static String PROP_ICON_CLS = "iconCls";


	// constructors
	public BaseIndustryInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIndustryInfo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String funcname;
	private java.lang.String pagepath;
	private java.lang.Integer location;
	private java.lang.Integer isdirectory;
	private java.lang.String lastdirectory;
	private java.lang.Integer showseq;
	private java.lang.String funcClass;
	private java.lang.String funcType;
	private java.lang.String workflowFlag;
	private java.lang.String upFuncCode;
	private java.lang.String funcDesc;
	private java.lang.String status;
	private java.lang.String miscflgs;
	private java.lang.String misc;
	private java.lang.String iconCls;



	public java.lang.String getIconCls() {
		return iconCls;
	}

	public void setIconCls(java.lang.String iconCls) {
		this.iconCls = iconCls;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="FUNCID"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: FUNCNAME
	 */
	public java.lang.String getFuncname () {
		return funcname;
	}

	/**
	 * Set the value related to the column: FUNCNAME
	 * @param funcname the FUNCNAME value
	 */
	public void setFuncname (java.lang.String funcname) {
		this.funcname = funcname;
	}



	/**
	 * Return the value associated with the column: PAGEPATH
	 */
	public java.lang.String getPagepath () {
		return pagepath;
	}

	/**
	 * Set the value related to the column: PAGEPATH
	 * @param pagepath the PAGEPATH value
	 */
	public void setPagepath (java.lang.String pagepath) {
		this.pagepath = pagepath;
	}



	/**
	 * Return the value associated with the column: LOCATION
	 */
	public java.lang.Integer getLocation () {
		return 2;
	}

	/**
	 * Set the value related to the column: LOCATION
	 * @param location the LOCATION value
	 */
	public void setLocation (java.lang.Integer location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: ISDIRECTORY
	 */
	public java.lang.Integer getIsdirectory () {
		return 1;
	}

	/**
	 * Set the value related to the column: ISDIRECTORY
	 * @param isdirectory the ISDIRECTORY value
	 */
	public void setIsdirectory (java.lang.Integer isdirectory) {
		this.isdirectory = isdirectory;
	}



	/**
	 * Return the value associated with the column: LASTDIRECTORY
	 */
	public java.lang.String getLastdirectory () {
		return lastdirectory;
	}

	/**
	 * Set the value related to the column: LASTDIRECTORY
	 * @param lastdirectory the LASTDIRECTORY value
	 */
	public void setLastdirectory (java.lang.String lastdirectory) {
		this.lastdirectory = lastdirectory;
	}



	/**
	 * Return the value associated with the column: SHOWSEQ
	 */
	public java.lang.Integer getShowseq () {
		return 1;
	}

	/**
	 * Set the value related to the column: SHOWSEQ
	 * @param showseq the SHOWSEQ value
	 */
	public void setShowseq (java.lang.Integer showseq) {
		this.showseq = showseq;
	}



	/**
	 * Return the value associated with the column: FUNC_CLASS
	 */
	public java.lang.String getFuncClass () {
		return funcClass;
	}

	/**
	 * Set the value related to the column: FUNC_CLASS
	 * @param funcClass the FUNC_CLASS value
	 */
	public void setFuncClass (java.lang.String funcClass) {
		this.funcClass = funcClass;
	}



	/**
	 * Return the value associated with the column: FUNC_TYPE
	 */
	public java.lang.String getFuncType () {
		return funcType;
	}

	/**
	 * Set the value related to the column: FUNC_TYPE
	 * @param funcType the FUNC_TYPE value
	 */
	public void setFuncType (java.lang.String funcType) {
		this.funcType = funcType;
	}



	/**
	 * Return the value associated with the column: WORKFLOW_FLAG
	 */
	public java.lang.String getWorkflowFlag () {
		return workflowFlag;
	}

	/**
	 * Set the value related to the column: WORKFLOW_FLAG
	 * @param workflowFlag the WORKFLOW_FLAG value
	 */
	public void setWorkflowFlag (java.lang.String workflowFlag) {
		this.workflowFlag = workflowFlag;
	}



	/**
	 * Return the value associated with the column: UP_FUNC_CODE
	 */
	public java.lang.String getUpFuncCode () {
		return upFuncCode;
	}

	/**
	 * Set the value related to the column: UP_FUNC_CODE
	 * @param upFuncCode the UP_FUNC_CODE value
	 */
	public void setUpFuncCode (java.lang.String upFuncCode) {
		this.upFuncCode = upFuncCode;
	}



	/**
	 * Return the value associated with the column: FUNC_DESC
	 */
	public java.lang.String getFuncDesc () {
		return funcDesc;
	}

	/**
	 * Set the value related to the column: FUNC_DESC
	 * @param funcDesc the FUNC_DESC value
	 */
	public void setFuncDesc (java.lang.String funcDesc) {
		this.funcDesc = funcDesc;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: MISCFLGS
	 */
	public java.lang.String getMiscflgs () {
		return miscflgs;
	}

	/**
	 * Set the value related to the column: MISCFLGS
	 * @param miscflgs the MISCFLGS value
	 */
	public void setMiscflgs (java.lang.String miscflgs) {
		this.miscflgs = miscflgs;
	}



	/**
	 * Return the value associated with the column: MISC
	 */
	public java.lang.String getMisc () {
		return misc;
	}

	/**
	 * Set the value related to the column: MISC
	 * @param misc the MISC value
	 */
	public void setMisc (java.lang.String misc) {
		this.misc = misc;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof IndustryInfo)) return false;
		else {
			IndustryInfo IndustryInfo = (IndustryInfo) obj;
			if (null == this.getId() || null == IndustryInfo.getId()) return false;
			else return (this.getId().equals(IndustryInfo.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}