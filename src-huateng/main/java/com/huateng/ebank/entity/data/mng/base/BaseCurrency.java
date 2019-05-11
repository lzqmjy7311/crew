package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CURRENCY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CURRENCY"
 */

public abstract class BaseCurrency  implements Comparable, Serializable {

	public static String REF = "Currency";
	public static String PROP_ENNAME = "enname";
	public static String PROP_MINBILLUNIT = "minbillunit";
	public static String PROP_ISCUREXCH = "iscurexch";
	public static String PROP_CURSECUNIT = "cursecunit";
	public static String PROP_ISUSD = "isusd";
	public static String PROP_MINEXCHUNIT = "minexchunit";
	public static String PROP_ISCUREURO = "iscureuro";
	public static String PROP_CURSYMBOL = "cursymbol";
	public static String PROP_DRATEDAYS = "dratedays";
	public static String PROP_CURNO = "curno";
	public static String PROP_LSTUPDTS = "lstupdts";
	public static String PROP_MINCHGUNIT = "minchgunit";
	public static String PROP_ID = "id";
	public static String PROP_CNNAME = "cnname";
	public static String PROP_CURRNDUNIT = "currndunit";


	// constructors
	public BaseCurrency () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCurrency (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCurrency (
		java.lang.String id,
		java.lang.String curno,
		java.lang.String cnname,
		java.lang.String enname,
		java.lang.Short dratedays,
		java.lang.String cursymbol,
		java.lang.String isusd) {

		this.setId(id);
		this.setCurno(curno);
		this.setCnname(cnname);
		this.setEnname(enname);
		this.setDratedays(dratedays);
		this.setCursymbol(cursymbol);
		this.setIsusd(isusd);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String curno;
	private java.lang.String cnname;
	private java.lang.String enname;
	private java.lang.String cursymbol;
	private java.lang.String isusd;
	private java.math.BigDecimal cursecunit;
	private java.math.BigDecimal currndunit;
	private java.lang.String iscurexch;
	private java.lang.String iscureuro;
	private java.math.BigDecimal minbillunit;
	private java.math.BigDecimal minexchunit;
	private java.math.BigDecimal minchgunit;
	private short dratedays;
	private java.util.Date lstupdts;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="CURCD"
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
	 * Return the value associated with the column: CURNO
	 */
	public java.lang.String getCurno () {
		return curno;
	}

	/**
	 * Set the value related to the column: CURNO
	 * @param curno the CURNO value
	 */
	public void setCurno (java.lang.String curno) {
		this.curno = curno;
	}



	/**
	 * Return the value associated with the column: CNNAME
	 */
	public java.lang.String getCnname () {
		return cnname;
	}

	/**
	 * Set the value related to the column: CNNAME
	 * @param cnname the CNNAME value
	 */
	public void setCnname (java.lang.String cnname) {
		this.cnname = cnname;
	}



	/**
	 * Return the value associated with the column: ENNAME
	 */
	public java.lang.String getEnname () {
		return enname;
	}

	/**
	 * Set the value related to the column: ENNAME
	 * @param enname the ENNAME value
	 */
	public void setEnname (java.lang.String enname) {
		this.enname = enname;
	}



	/**
	 * Return the value associated with the column: CURSYMBOL
	 */
	public java.lang.String getCursymbol () {
		return cursymbol;
	}

	/**
	 * Set the value related to the column: CURSYMBOL
	 * @param cursymbol the CURSYMBOL value
	 */
	public void setCursymbol (java.lang.String cursymbol) {
		this.cursymbol = cursymbol;
	}



	/**
	 * Return the value associated with the column: ISUSD
	 */
	public java.lang.String getIsusd () {
		return isusd;
	}

	/**
	 * Set the value related to the column: ISUSD
	 * @param isusd the ISUSD value
	 */
	public void setIsusd (java.lang.String isusd) {
		this.isusd = isusd;
	}



	/**
	 * Return the value associated with the column: CURSECUNIT
	 */
	public java.math.BigDecimal getCursecunit () {
		return cursecunit;
	}

	/**
	 * Set the value related to the column: CURSECUNIT
	 * @param cursecunit the CURSECUNIT value
	 */
	public void setCursecunit (java.math.BigDecimal cursecunit) {
		this.cursecunit = cursecunit;
	}



	/**
	 * Return the value associated with the column: CURRNDUNIT
	 */
	public java.math.BigDecimal getCurrndunit () {
		return currndunit;
	}

	/**
	 * Set the value related to the column: CURRNDUNIT
	 * @param currndunit the CURRNDUNIT value
	 */
	public void setCurrndunit (java.math.BigDecimal currndunit) {
		this.currndunit = currndunit;
	}



	/**
	 * Return the value associated with the column: ISCUREXCH
	 */
	public java.lang.String getIscurexch () {
		return iscurexch;
	}

	/**
	 * Set the value related to the column: ISCUREXCH
	 * @param iscurexch the ISCUREXCH value
	 */
	public void setIscurexch (java.lang.String iscurexch) {
		this.iscurexch = iscurexch;
	}



	/**
	 * Return the value associated with the column: ISCUREURO
	 */
	public java.lang.String getIscureuro () {
		return iscureuro;
	}

	/**
	 * Set the value related to the column: ISCUREURO
	 * @param iscureuro the ISCUREURO value
	 */
	public void setIscureuro (java.lang.String iscureuro) {
		this.iscureuro = iscureuro;
	}



	/**
	 * Return the value associated with the column: MINBILLUNIT
	 */
	public java.math.BigDecimal getMinbillunit () {
		return minbillunit;
	}

	/**
	 * Set the value related to the column: MINBILLUNIT
	 * @param minbillunit the MINBILLUNIT value
	 */
	public void setMinbillunit (java.math.BigDecimal minbillunit) {
		this.minbillunit = minbillunit;
	}



	/**
	 * Return the value associated with the column: MINEXCHUNIT
	 */
	public java.math.BigDecimal getMinexchunit () {
		return minexchunit;
	}

	/**
	 * Set the value related to the column: MINEXCHUNIT
	 * @param minexchunit the MINEXCHUNIT value
	 */
	public void setMinexchunit (java.math.BigDecimal minexchunit) {
		this.minexchunit = minexchunit;
	}



	/**
	 * Return the value associated with the column: MINCHGUNIT
	 */
	public java.math.BigDecimal getMinchgunit () {
		return minchgunit;
	}

	/**
	 * Set the value related to the column: MINCHGUNIT
	 * @param minchgunit the MINCHGUNIT value
	 */
	public void setMinchgunit (java.math.BigDecimal minchgunit) {
		this.minchgunit = minchgunit;
	}



	/**
	 * Return the value associated with the column: DRATEDAYS
	 */
	public short getDratedays () {
		return dratedays;
	}

	/**
	 * Set the value related to the column: DRATEDAYS
	 * @param dratedays the DRATEDAYS value
	 */
	public void setDratedays (short dratedays) {
		this.dratedays = dratedays;
	}



	/**
	 * Return the value associated with the column: LSTUPDTS
	 */
	public java.util.Date getLstupdts () {
		return lstupdts;
	}

	/**
	 * Set the value related to the column: LSTUPDTS
	 * @param lstupdts the LSTUPDTS value
	 */
	public void setLstupdts (java.util.Date lstupdts) {
		this.lstupdts = lstupdts;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.Currency)) return false;
		else {
			com.huateng.ebank.entity.data.mng.Currency currency = (com.huateng.ebank.entity.data.mng.Currency) obj;
			if (null == this.getId() || null == currency.getId()) return false;
			else return (this.getId().equals(currency.getId()));
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