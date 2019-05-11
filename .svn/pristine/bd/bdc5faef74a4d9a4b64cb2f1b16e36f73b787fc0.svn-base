package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FP_PAGE_TYPE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FP_PAGE_TYPE"
 */

public abstract class BaseFpPageType  implements Serializable {

	public static String REF = "FpPageType";
	public static String PROP_LAST_UPD_TS = "lastUpdTs";
	public static String PROP_NAME = "name";
	public static String PROP_STATUS = "status";
	public static String PROP_PARENT = "parent";
	public static String PROP_DESC_INFO = "descInfo";
	public static String PROP_TYPE = "type";
	public static String PROP_ID = "id";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";


	// constructors
	public BaseFpPageType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFpPageType (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFpPageType (
		java.lang.String id,
		java.lang.String name,
		java.lang.String descInfo,
		java.lang.String type,
		java.lang.String parent,
		java.lang.String status) {

		this.setId(id);
		this.setName(name);
		this.setDescInfo(descInfo);
		this.setType(type);
		this.setParent(parent);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String name;
	private java.lang.String descInfo;
	private java.lang.String type;
	private java.lang.String parent;
	private java.lang.String status;
	private java.lang.String lastUpdTlr;
	private java.lang.String lastUpdTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="uuid.hex"
     *  column="ID"
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
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: DESC_INFO
	 */
	public java.lang.String getDescInfo () {
		return descInfo;
	}

	/**
	 * Set the value related to the column: DESC_INFO
	 * @param descInfo the DESC_INFO value
	 */
	public void setDescInfo (java.lang.String descInfo) {
		this.descInfo = descInfo;
	}



	/**
	 * Return the value associated with the column: TYPE
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE
	 * @param type the TYPE value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: PARENT
	 */
	public java.lang.String getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: PARENT
	 * @param parent the PARENT value
	 */
	public void setParent (java.lang.String parent) {
		this.parent = parent;
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
	 * Return the value associated with the column: LAST_UPD_TLR
	 */
	public java.lang.String getLastUpdTlr () {
		return lastUpdTlr;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TLR
	 * @param lastUpdTlr the LAST_UPD_TLR value
	 */
	public void setLastUpdTlr (java.lang.String lastUpdTlr) {
		this.lastUpdTlr = lastUpdTlr;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_TS
	 */
	public java.lang.String getLastUpdTs () {
		return lastUpdTs;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TS
	 * @param lastUpdTs the LAST_UPD_TS value
	 */
	public void setLastUpdTs (java.lang.String lastUpdTs) {
		this.lastUpdTs = lastUpdTs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.FpPageType)) return false;
		else {
			com.huateng.ebank.entity.data.mng.FpPageType fpPageType = (com.huateng.ebank.entity.data.mng.FpPageType) obj;
			if (null == this.getId() || null == fpPageType.getId()) return false;
			else return (this.getId().equals(fpPageType.getId()));
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