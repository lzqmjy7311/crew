package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.BiNationregion;

/**
 * This is an object that contains data related to the BI_NATIONREGION table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="BI_NATIONREGION"
 */

public abstract class BaseBiNationregion implements Serializable {

	public static String REF = "BiNationregion";
	public static String PROP_CHINA_NAME = "chinaName";
	public static String PROP_ID = "id";
	public static String PROP_CHINA_SHORT_NAME = "chinaShortName";
	public static String PROP_NATIONREGION_NUMBER = "nationregionNumber";
	public static String PROP_ENG_SHORT_NAME = "engShortName";
	public static String PROP_ENG_NAME = "engName";
	public static String PROP_CRT_DT = "crtDt";
	public static String PROP_LAST_UPD_TMS = "lastUpdTms";
	public static String PROP_ST = "st";
	public static String PROP_LOCK = "lock";
	public static String PROP_LAST_UPD_OPER = "lastUpdOper";
	public static String PROP_DEL = "del";

	// constructors
	public BaseBiNationregion() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiNationregion(java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String chinaName;
	private java.lang.String nationregionNumber;
	private java.lang.String chinaShortName;
	private java.lang.String engName;
	private java.lang.String engShortName;
	private java.lang.String crtDt;
	private java.lang.String lastUpdTms;
	private boolean lock;
	private java.lang.String st;
	private java.lang.String lastUpdOper;
	private boolean del;

	public java.lang.String getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(java.lang.String crtDt) {
		this.crtDt = crtDt;
	}

	public java.lang.String getLastUpdTms() {
		return lastUpdTms;
	}

	public void setLastUpdTms(java.lang.String lastUpdTms) {
		this.lastUpdTms = lastUpdTms;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public java.lang.String getSt() {
		return st;
	}

	public void setSt(java.lang.String st) {
		this.st = st;
	}

	public java.lang.String getLastUpdOper() {
		return lastUpdOper;
	}

	public void setLastUpdOper(java.lang.String lastUpdOper) {
		this.lastUpdOper = lastUpdOper;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	/**
	 * Return the unique identifier of this class
	 *
	 * @hibernate.id column="NATIONREGION_CODE"
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 *
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: NATIONREGION_NUMBER
	 */
	public java.lang.String getNationregionNumber() {
		return nationregionNumber;
	}

	/**
	 * Set the value related to the column: NATIONREGION_NUMBER
	 *
	 * @param nationregionNumber
	 *            the NATIONREGION_NUMBER value
	 */
	public void setNationregionNumber(java.lang.String nationregionNumber) {
		this.nationregionNumber = nationregionNumber;
	}

	public java.lang.String getChinaName() {
		return chinaName;
	}

	public void setChinaName(java.lang.String chinaName) {
		this.chinaName = chinaName;
	}

	public java.lang.String getChinaShortName() {
		return chinaShortName;
	}

	public void setChinaShortName(java.lang.String chinaShortName) {
		this.chinaShortName = chinaShortName;
	}

	public java.lang.String getEngName() {
		return engName;
	}

	public void setEngName(java.lang.String engName) {
		this.engName = engName;
	}

	public java.lang.String getEngShortName() {
		return engShortName;
	}

	public void setEngShortName(java.lang.String engShortName) {
		this.engShortName = engShortName;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof BiNationregion))
			return false;
		else {
			BiNationregion biNationregion = (BiNationregion) obj;
			if (null == this.getId() || null == biNationregion.getId())
				return false;
			else
				return (this.getId().equals(biNationregion.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}