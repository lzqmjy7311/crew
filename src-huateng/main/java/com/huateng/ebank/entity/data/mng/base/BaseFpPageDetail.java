package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FP_PAGE_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FP_PAGE_DETAIL"
 */

public abstract class BaseFpPageDetail  implements Serializable {

	public static String REF = "FpPageDetail";
	public static String PROP_LAST_UPD_TS = "lastUpdTs";
	public static String PROP_NAME = "name";
	public static String PROP_STATUS = "status";
	public static String PROP_OPT_DETAILS = "optDetails";
	public static String PROP_PARENT = "parent";
	public static String PROP_DESC_INFO = "descInfo";
	public static String PROP_PAGFE_URL = "pagfeUrl";
	public static String PROP_PARAM_LIST = "paramList";
	public static String PROP_ID = "id";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_SEQID = "seqid";


	// constructors
	public BaseFpPageDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFpPageDetail (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFpPageDetail (
		java.lang.String id,
		java.lang.String name,
		java.lang.String descInfo,
		java.lang.String pagfeUrl,
		java.lang.String paramList,
		java.lang.String parent,
		java.lang.String status) {

		this.setId(id);
		this.setName(name);
		this.setDescInfo(descInfo);
		this.setPagfeUrl(pagfeUrl);
		this.setParamList(paramList);
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
	private java.lang.String pagfeUrl;
	private java.lang.String paramList;
	private java.lang.String parent;
	private java.lang.String seqid;
	private java.lang.String optDetails;
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
	 * Return the value associated with the column: PAGFE_URL
	 */
	public java.lang.String getPagfeUrl () {
		return pagfeUrl;
	}

	/**
	 * Set the value related to the column: PAGFE_URL
	 * @param pagfeUrl the PAGFE_URL value
	 */
	public void setPagfeUrl (java.lang.String pagfeUrl) {
		this.pagfeUrl = pagfeUrl;
	}



	/**
	 * Return the value associated with the column: PARAM_LIST
	 */
	public java.lang.String getParamList () {
		return paramList;
	}

	/**
	 * Set the value related to the column: PARAM_LIST
	 * @param paramList the PARAM_LIST value
	 */
	public void setParamList (java.lang.String paramList) {
		this.paramList = paramList;
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
	 * Return the value associated with the column: OPT_DETAILS
	 */
	public java.lang.String getOptDetails () {
		return optDetails;
	}

	/**
	 * Set the value related to the column: OPT_DETAILS
	 * @param optDetails the OPT_DETAILS value
	 */
	public void setOptDetails (java.lang.String optDetails) {
		this.optDetails = optDetails;
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
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.FpPageDetail)) return false;
		else {
			com.huateng.ebank.entity.data.mng.FpPageDetail fpPageDetail = (com.huateng.ebank.entity.data.mng.FpPageDetail) obj;
			if (null == this.getId() || null == fpPageDetail.getId()) return false;
			else return (this.getId().equals(fpPageDetail.getId()));
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