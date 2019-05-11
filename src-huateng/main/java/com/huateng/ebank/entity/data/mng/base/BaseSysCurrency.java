package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.SysCurrency;


/**
 * This is an object that contains data related to the SYS_CURRENCY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYS_CURRENCY"
 */

public abstract class BaseSysCurrency  implements Serializable {

	public static String REF = "SysCurrency";
	public static String PROP_CNNAME = "cnname";
	public static String PROP_ENNAME = "enname";
	public static String PROP_SHOWSEQ = "showSeq";
	public static String PROP_CURSYMBOL = "cursymBol";
	public static String PROP_ISUSD = "isUsd";
	public static String PROP_ID = "id";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_CREATE_TLR = "createTlr";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_LAST_UPD_Tlr = "lastUpdTlr";
	public static String PROP_ST = "st";
	public static String PROP_LOCK = "lock";
	public static String PROP_DRATEDAYS = "dratedays";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_DEL ="del";
	public static String PROP_CURNO ="curno";
	public static String PROP_MIN_UNIT ="minunit";
	public static String PROP_BASE_UNIT ="baseunit";
	public static String PROP_CUR_EDICD ="curedicd";
	public static String PROP_CUR_EDINAME ="curediname";

	// constructors
	public BaseSysCurrency () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysCurrency (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String cnname;
	private java.lang.String enname;
	private java.lang.String createDate;
	private java.lang.String lastUpdDate;
	private java.lang.String lastUpdTlr;
	private java.lang.String createTlr;
	private java.lang.String cursymBol;
	private java.lang.String isUsd;
	private java.lang.Integer showSeq;
	private boolean lock;
	private java.lang.String st;
	private java.lang.String dratedays;
	private boolean del;
	private java.lang.String curno;
	private java.lang.String minunit;
	private java.lang.String baseunit;
	private java.lang.String curedicd;
	private java.lang.String curediname;







	public java.lang.String getDratedays() {
		return dratedays;
	}

	public void setDratedays(java.lang.String dratedays) {
		this.dratedays = dratedays;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getCnname() {
		return cnname;
	}

	public void setCnname(java.lang.String cnname) {
		this.cnname = cnname;
	}

	public java.lang.String getEnname() {
		return enname;
	}

	public void setEnname(java.lang.String enname) {
		this.enname = enname;
	}



	public java.lang.String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.lang.String createDate) {
		this.createDate = createDate;
	}

	public java.lang.String getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(java.lang.String lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	public java.lang.String getLastUpdTlr() {
		return lastUpdTlr;
	}

	public void setLastUpdTlr(java.lang.String lastUpdTlr) {
		this.lastUpdTlr = lastUpdTlr;
	}

	public java.lang.String getCreateTlr() {
		return createTlr;
	}

	public void setCreateTlr(java.lang.String createTlr) {
		this.createTlr = createTlr;
	}

	public java.lang.String getCursymBol() {
		return cursymBol;
	}

	public void setCursymBol(java.lang.String cursymBol) {
		this.cursymBol = cursymBol;
	}


	public java.lang.String getIsUsd() {
		return isUsd;
	}

	public void setIsUsd(java.lang.String isUsd) {
		this.isUsd = isUsd;
	}

	public java.lang.Integer getShowSeq() {
		return showSeq;
	}

	public void setShowSeq(java.lang.Integer showSeq) {
		this.showSeq = showSeq;
	}

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

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof SysCurrency)) return false;
		else {
			SysCurrency sysCurrency = (SysCurrency) obj;
			if (null == this.getId() || null == sysCurrency.getId()) return false;
			else return (this.getId().equals(sysCurrency.getId()));
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

	public java.lang.String getCurno() {
		return curno;
	}

	public void setCurno(java.lang.String curno) {
		this.curno = curno;
	}

	public java.lang.String getMinunit() {
		return minunit;
	}

	public void setMinunit(java.lang.String minunit) {
		this.minunit = minunit;
	}

	public java.lang.String getBaseunit() {
		return baseunit;
	}

	public void setBaseunit(java.lang.String baseunit) {
		this.baseunit = baseunit;
	}

	public java.lang.String getCuredicd() {
		return curedicd;
	}

	public void setCuredicd(java.lang.String curedicd) {
		this.curedicd = curedicd;
	}

	public java.lang.String getCurediname() {
		return curediname;
	}

	public void setCurediname(java.lang.String curediname) {
		this.curediname = curediname;
	}




}