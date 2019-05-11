package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.BiTlrFavt;


/**
 * This is an object that contains data related to the BI_TLR_FAVT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_TLR_FAVT"
 */

public abstract class BaseBiTlrFavt  implements Serializable {

	public static String REF = "BiTlrFavt";
	public static String PROP_FUNC_ID = "funcId";
	public static String PROP_TLR_NO = "tlrNo";
	public static String PROP_ID = "id";
	public static String PROP_SHOW_SEQ = "showSeq";
	public static String PROP_FUNC_TYPE="funcType";

	// constructors
	public BaseBiTlrFavt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiTlrFavt (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String tlrNo;
	private java.lang.String funcId;
	private java.lang.Integer showSeq;
	private java.lang.String funcType;



	public java.lang.String getFuncType() {
		return funcType;
	}

	public void setFuncType(java.lang.String funcType) {
		this.funcType = funcType;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
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
	 * Return the value associated with the column: TLR_NO
	 */
	public java.lang.String getTlrNo () {
		return tlrNo;
	}

	/**
	 * Set the value related to the column: TLR_NO
	 * @param tlrNo the TLR_NO value
	 */
	public void setTlrNo (java.lang.String tlrNo) {
		this.tlrNo = tlrNo;
	}



	/**
	 * Return the value associated with the column: FUNC_ID
	 */
	public java.lang.String getFuncId () {
		return funcId;
	}

	/**
	 * Set the value related to the column: FUNC_ID
	 * @param funcId the FUNC_ID value
	 */
	public void setFuncId (java.lang.String funcId) {
		this.funcId = funcId;
	}



	/**
	 * Return the value associated with the column: SHOW_SEQ
	 */
	public java.lang.Integer getShowSeq () {
		return showSeq;
	}

	/**
	 * Set the value related to the column: SHOW_SEQ
	 * @param showSeq the SHOW_SEQ value
	 */
	public void setShowSeq (java.lang.Integer showSeq) {
		this.showSeq = showSeq;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof BiTlrFavt)) return false;
		else {
			BiTlrFavt biTlrFavt = (BiTlrFavt) obj;
			if (null == this.getId() || null == biTlrFavt.getId()) return false;
			else return (this.getId().equals(biTlrFavt.getId()));
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