package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class BaseSysCurrrate  implements Serializable {


	private java.lang.String curcd;
	private java.lang.String currrateDate;
	public static String REF = "TblCurrrate";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_ID = "id";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_BUY_RATE = "buyrate";
	public static String PROP_EXCHG_RATE = "exchgrate";
	public static String PROP_SELL_RATE= "sellrate";
	public static String PROP_TO_CURCD = "tocurcd";


	// constructors
	public BaseSysCurrrate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysCurrrate (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String lastUpdTlr;
	private java.lang.String lastUpdDate;
	private java.lang.String tocurcd;
	private java.math.BigDecimal buyrate;
	private java.math.BigDecimal exchgrate;
	private java.math.BigDecimal sellrate;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
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


	public java.lang.String getCurcd() {
		return curcd;
	}

	public void setCurcd(java.lang.String curcd) {
		this.curcd = curcd;
	}



	public java.lang.String getCurrrateDate() {
		return currrateDate;
	}

	public void setCurrrateDate(java.lang.String currrateDate) {
		this.currrateDate = currrateDate;
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



	public java.lang.String getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(java.lang.String lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.SysCurrrate)) return false;
		else {
			com.huateng.ebank.entity.data.mng.SysCurrrate Currrate = (com.huateng.ebank.entity.data.mng.SysCurrrate) obj;
			if (null == this.getId() || null == Currrate.getId()) return false;
			else return (this.getId().equals(Currrate.getId()));
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

	public java.lang.String getTocurcd() {
		return tocurcd;
	}

	public void setTocurcd(java.lang.String tocurcd) {
		this.tocurcd = tocurcd;
	}

	public java.math.BigDecimal getBuyrate() {
		return buyrate;
	}

	public void setBuyrate(java.math.BigDecimal buyrate) {
		this.buyrate = buyrate;
	}

	public java.math.BigDecimal getExchgrate() {
		return exchgrate;
	}

	public void setExchgrate(java.math.BigDecimal exchgrate) {
		this.exchgrate = exchgrate;
	}

	public java.math.BigDecimal getSellrate() {
		return sellrate;
	}

	public void setSellrate(java.math.BigDecimal sellrate) {
		this.sellrate = sellrate;
	}







}