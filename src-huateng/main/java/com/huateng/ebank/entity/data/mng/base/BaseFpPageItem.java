package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FP_PAGE_ITEM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FP_PAGE_ITEM"
 */

public abstract class BaseFpPageItem  implements Serializable {

	public static String REF = "FpPageItem";
	public static String PROP_LAST_UPD_TS = "lastUpdTs";
	public static String PROP_NAME = "name";
	public static String PROP_STATUS = "status";
	public static String PROP_DEFAULTNO = "defaultno";
	public static String PROP_DESC_INFO = "descInfo";
	public static String PROP_TYPEID = "typeid";
	public static String PROP_OP_ITEM_ID = "opItemId";
	public static String PROP_ID = "id";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_VIEWTYPE = "viewtype";


	// constructors
	public BaseFpPageItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFpPageItem (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFpPageItem (
		java.lang.String id,
		java.lang.String name,
		java.lang.String descInfo,
		java.lang.String typeid,
		java.lang.String viewtype,
		java.lang.String defaultno,
		java.lang.String status) {

		this.setId(id);
		this.setName(name);
		this.setDescInfo(descInfo);
		this.setTypeid(typeid);
		this.setViewtype(viewtype);
		this.setDefaultno(defaultno);
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
	private java.lang.String typeid;
	private java.lang.String viewtype;
	private java.lang.String defaultno;
	private java.lang.String opItemId;
	private java.lang.String status;
	private java.lang.String lastUpdTs;
	private java.lang.String lastUpdTlr;



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
	 * Return the value associated with the column: TYPEID
	 */
	public java.lang.String getTypeid () {
		return typeid;
	}

	/**
	 * Set the value related to the column: TYPEID
	 * @param typeid the TYPEID value
	 */
	public void setTypeid (java.lang.String typeid) {
		this.typeid = typeid;
	}



	/**
	 * Return the value associated with the column: VIEWTYPE
	 */
	public java.lang.String getViewtype () {
		return viewtype;
	}

	/**
	 * Set the value related to the column: VIEWTYPE
	 * @param viewtype the VIEWTYPE value
	 */
	public void setViewtype (java.lang.String viewtype) {
		this.viewtype = viewtype;
	}



	/**
	 * Return the value associated with the column: DEFAULTNO
	 */
	public java.lang.String getDefaultno () {
		return defaultno;
	}

	/**
	 * Set the value related to the column: DEFAULTNO
	 * @param defaultno the DEFAULTNO value
	 */
	public void setDefaultno (java.lang.String defaultno) {
		this.defaultno = defaultno;
	}



	/**
	 * Return the value associated with the column: OP_ITEM_ID
	 */
	public java.lang.String getOpItemId () {
		return opItemId;
	}

	/**
	 * Set the value related to the column: OP_ITEM_ID
	 * @param opItemId the OP_ITEM_ID value
	 */
	public void setOpItemId (java.lang.String opItemId) {
		this.opItemId = opItemId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.FpPageItem)) return false;
		else {
			com.huateng.ebank.entity.data.mng.FpPageItem fpPageItem = (com.huateng.ebank.entity.data.mng.FpPageItem) obj;
			if (null == this.getId() || null == fpPageItem.getId()) return false;
			else return (this.getId().equals(fpPageItem.getId()));
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