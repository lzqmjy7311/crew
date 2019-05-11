package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the HOLIDAY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="HOLIDAY"
 */

public abstract class BaseHoliday  implements Comparable, Serializable {

	public static String REF = "Holiday";
	public static String PROP_LAST_UPD_OPER_ID = "lastUpdOperId";
	public static String PROP_LAST_UPD_TIME = "lastUpdTime";
	public static String PROP_YEAR = "year";
	public static String PROP_ID = "id";
	public static String PROP_HOLIDAY_DEF = "holidayDef";


	// constructors
	public BaseHoliday () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHoliday (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer year;
	private java.lang.String holidayDef;
	private java.lang.String lastUpdOperId;
	private java.lang.String lastUpdTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: YEAR
	 */
	public java.lang.Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: YEAR
	 * @param year the YEAR value
	 */
	public void setYear (java.lang.Integer year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: HOLIDAY_DEF
	 */
	public java.lang.String getHolidayDef () {
		return holidayDef;
	}

	/**
	 * Set the value related to the column: HOLIDAY_DEF
	 * @param holidayDef the HOLIDAY_DEF value
	 */
	public void setHolidayDef (java.lang.String holidayDef) {
		this.holidayDef = holidayDef;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_OPER_ID
	 */
	public java.lang.String getLastUpdOperId () {
		return lastUpdOperId;
	}

	/**
	 * Set the value related to the column: LAST_UPD_OPER_ID
	 * @param lastUpdOperId the LAST_UPD_OPER_ID value
	 */
	public void setLastUpdOperId (java.lang.String lastUpdOperId) {
		this.lastUpdOperId = lastUpdOperId;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_TIME
	 */
	public java.lang.String getLastUpdTime () {
		return lastUpdTime;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TIME
	 * @param lastUpdTime the LAST_UPD_TIME value
	 */
	public void setLastUpdTime (java.lang.String lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.Holiday)) return false;
		else {
			com.huateng.ebank.entity.data.mng.Holiday holiday = (com.huateng.ebank.entity.data.mng.Holiday) obj;
			if (null == this.getId() || null == holiday.getId()) return false;
			else return (this.getId().equals(holiday.getId()));
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