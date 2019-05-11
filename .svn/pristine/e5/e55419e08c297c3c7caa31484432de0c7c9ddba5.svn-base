package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the RELATION_CODE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="RELATION_CODE"
 */

public abstract class BaseRelationCode  implements Comparable, Serializable {

	public static String REF = "RelationCode";
	public static String PROP_LAST_UPD_FUNC = "lastUpdFunc";
	public static String PROP_CUS_TYPE = "cusType";
	public static String PROP_RELATION_NAME = "relationName";
	public static String PROP_NEED_CUSTNO = "needCustno";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_UNIQUE = "unique";
	public static String PROP_NEED_MEMORABILIA = "needMemorabilia";
	public static String PROP_OPPOSITE_CODE = "oppositeCode";
	public static String PROP_ID = "id";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_RELATION_DESC = "relationDesc";


	// constructors
	public BaseRelationCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRelationCode (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRelationCode (
		java.lang.String id,
		java.lang.String relationName,
		java.lang.String cusType,
		java.lang.String unique,
		java.lang.String needCustno,
		java.lang.String needMemorabilia) {

		this.setId(id);
		this.setRelationName(relationName);
		this.setCusType(cusType);
		this.setUnique(unique);
		this.setNeedCustno(needCustno);
		this.setNeedMemorabilia(needMemorabilia);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String relationName;
	private java.lang.String oppositeCode;
	private java.lang.String relationDesc;
	private java.lang.String cusType;
	private java.lang.String unique;
	private java.lang.String needCustno;
	private java.lang.String needMemorabilia;
	private java.lang.String lastUpdTlr;
	private java.lang.String lastUpdFunc;
	private java.util.Date lastUpdDate;
	private java.util.Date timestamps;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="RELATION_CODE"
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
	 * Return the value associated with the column: RELATION_NAME
	 */
	public java.lang.String getRelationName () {
		return relationName;
	}

	/**
	 * Set the value related to the column: RELATION_NAME
	 * @param relationName the RELATION_NAME value
	 */
	public void setRelationName (java.lang.String relationName) {
		this.relationName = relationName;
	}



	/**
	 * Return the value associated with the column: OPPOSITE_CODE
	 */
	public java.lang.String getOppositeCode () {
		return oppositeCode;
	}

	/**
	 * Set the value related to the column: OPPOSITE_CODE
	 * @param oppositeCode the OPPOSITE_CODE value
	 */
	public void setOppositeCode (java.lang.String oppositeCode) {
		this.oppositeCode = oppositeCode;
	}



	/**
	 * Return the value associated with the column: RELATION_DESC
	 */
	public java.lang.String getRelationDesc () {
		return relationDesc;
	}

	/**
	 * Set the value related to the column: RELATION_DESC
	 * @param relationDesc the RELATION_DESC value
	 */
	public void setRelationDesc (java.lang.String relationDesc) {
		this.relationDesc = relationDesc;
	}



	/**
	 * Return the value associated with the column: CUS_TYPE
	 */
	public java.lang.String getCusType () {
		return cusType;
	}

	/**
	 * Set the value related to the column: CUS_TYPE
	 * @param cusType the CUS_TYPE value
	 */
	public void setCusType (java.lang.String cusType) {
		this.cusType = cusType;
	}



	/**
	 * Return the value associated with the column: IS_UNIQUE
	 */
	public java.lang.String getUnique () {
		return unique;
	}

	/**
	 * Set the value related to the column: IS_UNIQUE
	 * @param unique the IS_UNIQUE value
	 */
	public void setUnique (java.lang.String unique) {
		this.unique = unique;
	}



	/**
	 * Return the value associated with the column: NEED_CUSTNO
	 */
	public java.lang.String getNeedCustno () {
		return needCustno;
	}

	/**
	 * Set the value related to the column: NEED_CUSTNO
	 * @param needCustno the NEED_CUSTNO value
	 */
	public void setNeedCustno (java.lang.String needCustno) {
		this.needCustno = needCustno;
	}



	/**
	 * Return the value associated with the column: NEED_MEMORABILIA
	 */
	public java.lang.String getNeedMemorabilia () {
		return needMemorabilia;
	}

	/**
	 * Set the value related to the column: NEED_MEMORABILIA
	 * @param needMemorabilia the NEED_MEMORABILIA value
	 */
	public void setNeedMemorabilia (java.lang.String needMemorabilia) {
		this.needMemorabilia = needMemorabilia;
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
	 * Return the value associated with the column: LAST_UPD_FUNC
	 */
	public java.lang.String getLastUpdFunc () {
		return lastUpdFunc;
	}

	/**
	 * Set the value related to the column: LAST_UPD_FUNC
	 * @param lastUpdFunc the LAST_UPD_FUNC value
	 */
	public void setLastUpdFunc (java.lang.String lastUpdFunc) {
		this.lastUpdFunc = lastUpdFunc;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_DATE
	 */
	public java.util.Date getLastUpdDate () {
		return lastUpdDate;
	}

	/**
	 * Set the value related to the column: LAST_UPD_DATE
	 * @param lastUpdDate the LAST_UPD_DATE value
	 */
	public void setLastUpdDate (java.util.Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}



	/**
	 * Return the value associated with the column: TIMESTAMPS
	 */
	public java.util.Date getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: TIMESTAMPS
	 * @param timestamps the TIMESTAMPS value
	 */
	public void setTimestamps (java.util.Date timestamps) {
		this.timestamps = timestamps;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.RelationCode)) return false;
		else {
			com.huateng.ebank.entity.data.mng.RelationCode relationCode = (com.huateng.ebank.entity.data.mng.RelationCode) obj;
			if (null == this.getId() || null == relationCode.getId()) return false;
			else return (this.getId().equals(relationCode.getId()));
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

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}