package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.Globalinfo;


/**
 * This is an object that contains data related to the GLOBALINFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GLOBALINFO"
 */

public abstract class BaseGlobalinfo  implements Serializable {

	public static String REF = "Globalinfo";
	public static String PROP_STATUS = "status";
	public static String PROP_SYSTEM_NAME = "systemName";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_SYSTEM_TYPE = "systemType";
	public static String PROP_TBSDY = "tbsdy";
	public static String PROP_LBHDATE = "lbhdate";
	public static String PROP_BHDATE = "bhdate";
	public static String PROP_ID = "id";


	// constructors
	public BaseGlobalinfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGlobalinfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String systemName;
	private java.lang.String tbsdy;
	private java.lang.String bhdate;
	private java.lang.String lbhdate;
	private java.lang.String status;
	private java.lang.String systemType;
	private java.lang.String miscflgs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: SYSTEM_NAME
	 */
	public java.lang.String getSystemName () {
		return systemName;
	}

	/**
	 * Set the value related to the column: SYSTEM_NAME
	 * @param systemName the SYSTEM_NAME value
	 */
	public void setSystemName (java.lang.String systemName) {
		this.systemName = systemName;
	}



	/**
	 * Return the value associated with the column: TBSDY
	 */
	public java.lang.String getTbsdy () {
		return tbsdy;
	}

	/**
	 * Set the value related to the column: TBSDY
	 * @param tbsdy the TBSDY value
	 */
	public void setTbsdy (java.lang.String tbsdy) {
		this.tbsdy = tbsdy;
	}



	/**
	 * Return the value associated with the column: BHDATE
	 */
	public java.lang.String getBhdate () {
		return bhdate;
	}

	/**
	 * Set the value related to the column: BHDATE
	 * @param bhdate the BHDATE value
	 */
	public void setBhdate (java.lang.String bhdate) {
		this.bhdate = bhdate;
	}



	/**
	 * Return the value associated with the column: LBHDATE
	 */
	public java.lang.String getLbhdate () {
		return lbhdate;
	}

	/**
	 * Set the value related to the column: LBHDATE
	 * @param lbhdate the LBHDATE value
	 */
	public void setLbhdate (java.lang.String lbhdate) {
		this.lbhdate = lbhdate;
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
	 * Return the value associated with the column: SYSTEM_TYPE
	 */
	public java.lang.String getSystemType () {
		return systemType;
	}

	/**
	 * Set the value related to the column: SYSTEM_TYPE
	 * @param systemType the SYSTEM_TYPE value
	 */
	public void setSystemType (java.lang.String systemType) {
		this.systemType = systemType;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof Globalinfo)) return false;
		else {
			Globalinfo globalinfo = (Globalinfo) obj;
			if (null == this.getId() || null == globalinfo.getId()) return false;
			else return (this.getId().equals(globalinfo.getId()));
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