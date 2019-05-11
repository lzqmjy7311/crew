package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BIZ_FUNC_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BIZ_FUNC_INFO"
 */

public abstract class BaseBizFuncInfo  implements Serializable {

	public static String REF = "BizFuncInfo";
	public static String PROP_BIZ_FUNC_TYPE = "bizFuncType";
	public static String PROP_BIZ_FUNC_NAME = "bizFuncName";
	public static String PROP_MENU_FUNC_CODE = "menuFuncCode";
	public static String PROP_MISC = "misc";
	public static String PROP_ID = "id";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_LOG_TYPE = "logType";
	public static String PROP_MISCFLGS = "miscflgs";


	// constructors
	public BaseBizFuncInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBizFuncInfo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String bizFuncName;
	private java.lang.String menuFuncCode;
	private java.lang.String bizFuncType;
	private java.lang.String logType;
	private java.lang.String timestamps;
	private java.lang.String miscflgs;
	private java.lang.String misc;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="BIZ_FUNC_CODE"
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
	 * Return the value associated with the column: BIZ_FUNC_NAME
	 */
	public java.lang.String getBizFuncName () {
		return bizFuncName;
	}

	/**
	 * Set the value related to the column: BIZ_FUNC_NAME
	 * @param bizFuncName the BIZ_FUNC_NAME value
	 */
	public void setBizFuncName (java.lang.String bizFuncName) {
		this.bizFuncName = bizFuncName;
	}



	/**
	 * Return the value associated with the column: MENU_FUNC_CODE
	 */
	public java.lang.String getMenuFuncCode () {
		return menuFuncCode;
	}

	/**
	 * Set the value related to the column: MENU_FUNC_CODE
	 * @param menuFuncCode the MENU_FUNC_CODE value
	 */
	public void setMenuFuncCode (java.lang.String menuFuncCode) {
		this.menuFuncCode = menuFuncCode;
	}



	/**
	 * Return the value associated with the column: BIZ_FUNC_TYPE
	 */
	public java.lang.String getBizFuncType () {
		return bizFuncType;
	}

	/**
	 * Set the value related to the column: BIZ_FUNC_TYPE
	 * @param bizFuncType the BIZ_FUNC_TYPE value
	 */
	public void setBizFuncType (java.lang.String bizFuncType) {
		this.bizFuncType = bizFuncType;
	}



	/**
	 * Return the value associated with the column: LOG_TYPE
	 */
	public java.lang.String getLogType () {
		return logType;
	}

	/**
	 * Set the value related to the column: LOG_TYPE
	 * @param logType the LOG_TYPE value
	 */
	public void setLogType (java.lang.String logType) {
		this.logType = logType;
	}



	/**
	 * Return the value associated with the column: TIMESTAMPS
	 */
	public java.lang.String getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: TIMESTAMPS
	 * @param timestamps the TIMESTAMPS value
	 */
	public void setTimestamps (java.lang.String timestamps) {
		this.timestamps = timestamps;
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
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.BizFuncInfo)) return false;
		else {
			com.huateng.ebank.entity.data.mng.BizFuncInfo bizFuncInfo = (com.huateng.ebank.entity.data.mng.BizFuncInfo) obj;
			if (null == this.getId() || null == bizFuncInfo.getId()) return false;
			else return (this.getId().equals(bizFuncInfo.getId()));
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