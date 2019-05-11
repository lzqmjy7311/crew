package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PF_SYS_PARAM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PF_SYS_PARAM"
 */

public abstract class BasePfSysParam  implements Serializable {

	public static String REF = "PfSysParam";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_LAST_UPD_FUNC = "lastUpdFunc";
	public static String PROP_PARAM_END_TM = "paramEndTm";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_PARAM_VALUE_TX = "paramValueTx";
	public static String PROP_PARAM_CHANG_FLAG = "paramChangFlag";
	public static String PROP_ID = "id";
	public static String PROP_PARAM_START_TM = "paramStartTm";
	public static String DESC0 = "desc0";
	public static String PROP_ST = "st";
	public static String PROP_LOCK = "lock";
	public static String PROP_DEL ="del";

	// constructors
	public BasePfSysParam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePfSysParam (com.huateng.ebank.entity.data.mng.PfSysParamPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.huateng.ebank.entity.data.mng.PfSysParamPK id;

	// fields
	private java.lang.String paramStartTm;
	private java.lang.String paramEndTm;
	private java.lang.String paramChangFlag;
	private java.lang.String paramValueTx;
	private java.lang.String lastUpdTlr;
	private java.lang.String lastUpdFunc;
	private java.lang.String lastUpdDate;
	private java.lang.String desc0;
	private boolean lock;
	private java.lang.String st;
	private boolean del;


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

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public java.lang.String getDesc0() {
		return desc0;
	}

	public void setDesc0(java.lang.String desc0) {
		this.desc0 = desc0;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.huateng.ebank.entity.data.mng.PfSysParamPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.huateng.ebank.entity.data.mng.PfSysParamPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: PARAM_START_TM
	 */
	public java.lang.String getParamStartTm () {
		return paramStartTm;
	}

	/**
	 * Set the value related to the column: PARAM_START_TM
	 * @param paramStartTm the PARAM_START_TM value
	 */
	public void setParamStartTm (java.lang.String paramStartTm) {
		this.paramStartTm = paramStartTm;
	}



	/**
	 * Return the value associated with the column: PARAM_END_TM
	 */
	public java.lang.String getParamEndTm () {
		return paramEndTm;
	}

	/**
	 * Set the value related to the column: PARAM_END_TM
	 * @param paramEndTm the PARAM_END_TM value
	 */
	public void setParamEndTm (java.lang.String paramEndTm) {
		this.paramEndTm = paramEndTm;
	}



	/**
	 * Return the value associated with the column: PARAM_CHANG_FLAG
	 */
	public java.lang.String getParamChangFlag () {
		return paramChangFlag;
	}

	/**
	 * Set the value related to the column: PARAM_CHANG_FLAG
	 * @param paramChangFlag the PARAM_CHANG_FLAG value
	 */
	public void setParamChangFlag (java.lang.String paramChangFlag) {
		this.paramChangFlag = paramChangFlag;
	}



	/**
	 * Return the value associated with the column: PARAM_VALUE_TX
	 */
	public java.lang.String getParamValueTx () {
		return paramValueTx;
	}

	/**
	 * Set the value related to the column: PARAM_VALUE_TX
	 * @param paramValueTx the PARAM_VALUE_TX value
	 */
	public void setParamValueTx (java.lang.String paramValueTx) {
		this.paramValueTx = paramValueTx;
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
	public java.lang.String getLastUpdDate () {
		return lastUpdDate;
	}

	/**
	 * Set the value related to the column: LAST_UPD_DATE
	 * @param lastUpdDate the LAST_UPD_DATE value
	 */
	public void setLastUpdDate (java.lang.String lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.PfSysParam)) return false;
		else {
			com.huateng.ebank.entity.data.mng.PfSysParam pfSysParam = (com.huateng.ebank.entity.data.mng.PfSysParam) obj;
			if (null == this.getId() || null == pfSysParam.getId()) return false;
			else return (this.getId().equals(pfSysParam.getId()));
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