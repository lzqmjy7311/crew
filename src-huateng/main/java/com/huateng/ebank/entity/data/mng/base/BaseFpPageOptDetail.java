package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FP_PAGE_OPT_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FP_PAGE_OPT_DETAIL"
 */

public abstract class BaseFpPageOptDetail  implements Serializable {

	public static String REF = "FpPageOptDetail";
	public static String PROP_LAST_UPD_TS = "lastUpdTs";
	public static String PROP_OPT_CLAZZ = "optClazz";
	public static String PROP_NAME = "name";
	public static String PROP_STATUS = "status";
	public static String PROP_PARENT = "parent";
	public static String PROP_OPERATION = "operation";
	public static String PROP_DESC_INFO = "descInfo";
	public static String PROP_DEFAULT_CQID = "defaultCqid";
	public static String PROP_ID = "id";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_SEQID = "seqid";
	public static String PROP_OPT_SCRIPT = "optScript";
	public static String PROP_ICON = "icon";


	// constructors
	public BaseFpPageOptDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFpPageOptDetail (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFpPageOptDetail (
		java.lang.String id,
		java.lang.String name,
		java.lang.String descInfo,
		java.lang.String operation,
		java.lang.String parent,
		java.lang.String status,
		java.lang.String seqid,
		java.lang.String icon) {

		this.setId(id);
		this.setName(name);
		this.setDescInfo(descInfo);
		this.setOperation(operation);
		this.setParent(parent);
		this.setStatus(status);
		this.setSeqid(seqid);
		this.setIcon(icon);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String name;
	private java.lang.String descInfo;
	private java.lang.String operation;
	private java.lang.String optClazz;
	private java.lang.String optScript;
	private java.lang.String defaultCqid;
	private java.lang.String parent;
	private java.lang.String status;
	private java.lang.String seqid;
	private java.lang.String lastUpdTlr;
	private java.lang.String lastUpdTs;
	private java.lang.String icon;



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
	 * Return the value associated with the column: OPERATION
	 */
	public java.lang.String getOperation () {
		return operation;
	}

	/**
	 * Set the value related to the column: OPERATION
	 * @param operation the OPERATION value
	 */
	public void setOperation (java.lang.String operation) {
		this.operation = operation;
	}



	/**
	 * Return the value associated with the column: OPT_CLAZZ
	 */
	public java.lang.String getOptClazz () {
		return optClazz;
	}

	/**
	 * Set the value related to the column: OPT_CLAZZ
	 * @param optClazz the OPT_CLAZZ value
	 */
	public void setOptClazz (java.lang.String optClazz) {
		this.optClazz = optClazz;
	}



	/**
	 * Return the value associated with the column: OPT_SCRIPT
	 */
	public java.lang.String getOptScript () {
		return optScript;
	}

	/**
	 * Set the value related to the column: OPT_SCRIPT
	 * @param optScript the OPT_SCRIPT value
	 */
	public void setOptScript (java.lang.String optScript) {
		this.optScript = optScript;
	}



	/**
	 * Return the value associated with the column: DEFAULT_CQID
	 */
	public java.lang.String getDefaultCqid () {
		return defaultCqid;
	}

	/**
	 * Set the value related to the column: DEFAULT_CQID
	 * @param defaultCqid the DEFAULT_CQID value
	 */
	public void setDefaultCqid (java.lang.String defaultCqid) {
		this.defaultCqid = defaultCqid;
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
	 * Return the value associated with the column: SEQID
	 */
	public java.lang.String getSeqid () {
		return seqid;
	}

	/**
	 * Set the value related to the column: SEQID
	 * @param seqid the SEQID value
	 */
	public void setSeqid (java.lang.String seqid) {
		this.seqid = seqid;
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

	public java.lang.String getIcon() {
		return icon;
	}

	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.FpPageOptDetail)) return false;
		else {
			com.huateng.ebank.entity.data.mng.FpPageOptDetail fpPageOptDetail = (com.huateng.ebank.entity.data.mng.FpPageOptDetail) obj;
			if (null == this.getId() || null == fpPageOptDetail.getId()) return false;
			else return (this.getId().equals(fpPageOptDetail.getId()));
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