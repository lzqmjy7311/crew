package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.Bctl;


/**
 * This is an object that contains data related to the BCTL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BCTL"
 */

public abstract class BaseBctl  implements Serializable {

	public static String REF = "Bctl";
	public static String PROP_STATUS = "status";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_OTHER_AREA_FLAG = "otherAreaFlag";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_AUTHLVL = "authlvl";
	public static String PROP_BLN_BRANCH_BRCODE = "blnBranchBrcode";
	public static String PROP_BRATTR = "brattr";
	public static String PROP_BLN_UP_BRCODE = "blnUpBrcode";
	public static String PROP_BRCLASS = "brclass";
	public static String PROP_BRNO = "brno";
	public static String PROP_ADDRESS = "address";
	public static String PROP_BRNAME = "brname";
	public static String PROP_FINANCE_CODE = "financeCode";
	public static String PROP_LINKMAN = "linkman";
	public static String PROP_BLN_BRANCH_CLASS = "blnBranchClass";
	public static String PROP_LAST_UPD_FUNC = "lastUpdFunc";
	public static String PROP_POSTNO = "postno";
	public static String PROP_TXN_BRCODE = "txnBrcode";
	public static String PROP_TELENO = "teleno";
	public static String PROP_BRCODE = "brcode";
	public static String PROP_MISC = "misc";
	public static String PROP_REGIONALISM = "regionalism";
	public static String PROP_BLN_MANAGE_BRCODE = "blnManageBrcode";
	public static String PROP_ST = "st";
	public static String PROP_LOCK = "lock";
	public static String PROP_DEL ="del";

	// constructors
	public BaseBctl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBctl (java.lang.String brcode) {
		this.setBrcode(brcode);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBctl (
		java.lang.String brcode,
		java.lang.String brno) {

		this.setBrcode(brcode);
		this.setBrno(brno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String brcode;

	// fields
	private java.lang.String brno;
	private java.lang.String brname;
	private java.lang.String brclass;
	private java.lang.String brattr;
	private java.lang.String blnBranchClass;
	private java.lang.String blnBranchBrcode;
	private java.lang.String blnManageBrcode;
	private java.lang.String blnUpBrcode;
	private java.lang.String txnBrcode;
	private java.lang.String authlvl;
	private java.lang.String linkman;
	private java.lang.String teleno;
	private java.lang.String address;
	private java.lang.String postno;
	private java.lang.String otherAreaFlag;
	private java.lang.String regionalism;
	private java.lang.String financeCode;
	private java.lang.String status;
	private java.lang.String miscflgs;
	private java.lang.String misc;
	private java.lang.String lastUpdTlr;
	private java.lang.String lastUpdFunc;
	public java.lang.String getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(java.lang.String lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}



	private java.lang.String lastUpdDate;
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

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="BRCODE"
     */
	public java.lang.String getBrcode () {
		return brcode;
	}

	/**
	 * Set the unique identifier of this class
	 * @param brcode the new ID
	 */
	public void setBrcode (java.lang.String brcode) {
		this.brcode = brcode;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: BRNO
	 */
	public java.lang.String getBrno () {
		return brno;
	}

	/**
	 * Set the value related to the column: BRNO
	 * @param brno the BRNO value
	 */
	public void setBrno (java.lang.String brno) {
		this.brno = brno;
	}



	/**
	 * Return the value associated with the column: BRNAME
	 */
	public java.lang.String getBrname () {
		return brname;
	}

	/**
	 * Set the value related to the column: BRNAME
	 * @param brname the BRNAME value
	 */
	public void setBrname (java.lang.String brname) {
		this.brname = brname;
	}



	/**
	 * Return the value associated with the column: BRCLASS
	 */
	public java.lang.String getBrclass () {
		return brclass;
	}

	/**
	 * Set the value related to the column: BRCLASS
	 * @param brclass the BRCLASS value
	 */
	public void setBrclass (java.lang.String brclass) {
		this.brclass = brclass;
	}



	/**
	 * Return the value associated with the column: BRATTR
	 */
	public java.lang.String getBrattr () {
		return brattr;
	}

	/**
	 * Set the value related to the column: BRATTR
	 * @param brattr the BRATTR value
	 */
	public void setBrattr (java.lang.String brattr) {
		this.brattr = brattr;
	}



	/**
	 * Return the value associated with the column: BLN_BRANCH_CLASS
	 */
	public java.lang.String getBlnBranchClass () {
		return blnBranchClass;
	}

	/**
	 * Set the value related to the column: BLN_BRANCH_CLASS
	 * @param blnBranchClass the BLN_BRANCH_CLASS value
	 */
	public void setBlnBranchClass (java.lang.String blnBranchClass) {
		this.blnBranchClass = blnBranchClass;
	}



	/**
	 * Return the value associated with the column: BLN_BRANCH_BRCODE
	 */
	public java.lang.String getBlnBranchBrcode () {
		return blnBranchBrcode;
	}

	/**
	 * Set the value related to the column: BLN_BRANCH_BRCODE
	 * @param blnBranchBrcode the BLN_BRANCH_BRCODE value
	 */
	public void setBlnBranchBrcode (java.lang.String blnBranchBrcode) {
		this.blnBranchBrcode = blnBranchBrcode;
	}



	/**
	 * Return the value associated with the column: BLN_MANAGE_BRCODE
	 */
	public java.lang.String getBlnManageBrcode () {
		return blnManageBrcode;
	}

	/**
	 * Set the value related to the column: BLN_MANAGE_BRCODE
	 * @param blnManageBrcode the BLN_MANAGE_BRCODE value
	 */
	public void setBlnManageBrcode (java.lang.String blnManageBrcode) {
		this.blnManageBrcode = blnManageBrcode;
	}



	/**
	 * Return the value associated with the column: BLN_UP_BRCODE
	 */
	public java.lang.String getBlnUpBrcode () {
		return blnUpBrcode;
	}

	/**
	 * Set the value related to the column: BLN_UP_BRCODE
	 * @param blnUpBrcode the BLN_UP_BRCODE value
	 */
	public void setBlnUpBrcode (java.lang.String blnUpBrcode) {
		this.blnUpBrcode = blnUpBrcode;
	}



	/**
	 * Return the value associated with the column: TXN_BRCODE
	 */
	public java.lang.String getTxnBrcode () {
		return txnBrcode;
	}

	/**
	 * Set the value related to the column: TXN_BRCODE
	 * @param txnBrcode the TXN_BRCODE value
	 */
	public void setTxnBrcode (java.lang.String txnBrcode) {
		this.txnBrcode = txnBrcode;
	}



	/**
	 * Return the value associated with the column: AUTHLVL
	 */
	public java.lang.String getAuthlvl () {
		return authlvl;
	}

	/**
	 * Set the value related to the column: AUTHLVL
	 * @param authlvl the AUTHLVL value
	 */
	public void setAuthlvl (java.lang.String authlvl) {
		this.authlvl = authlvl;
	}



	/**
	 * Return the value associated with the column: LINKMAN
	 */
	public java.lang.String getLinkman () {
		return linkman;
	}

	/**
	 * Set the value related to the column: LINKMAN
	 * @param linkman the LINKMAN value
	 */
	public void setLinkman (java.lang.String linkman) {
		this.linkman = linkman;
	}



	/**
	 * Return the value associated with the column: TELENO
	 */
	public java.lang.String getTeleno () {
		return teleno;
	}

	/**
	 * Set the value related to the column: TELENO
	 * @param teleno the TELENO value
	 */
	public void setTeleno (java.lang.String teleno) {
		this.teleno = teleno;
	}



	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: POSTNO
	 */
	public java.lang.String getPostno () {
		return postno;
	}

	/**
	 * Set the value related to the column: POSTNO
	 * @param postno the POSTNO value
	 */
	public void setPostno (java.lang.String postno) {
		this.postno = postno;
	}



	/**
	 * Return the value associated with the column: OTHER_AREA_FLAG
	 */
	public java.lang.String getOtherAreaFlag () {
		return otherAreaFlag;
	}

	/**
	 * Set the value related to the column: OTHER_AREA_FLAG
	 * @param otherAreaFlag the OTHER_AREA_FLAG value
	 */
	public void setOtherAreaFlag (java.lang.String otherAreaFlag) {
		this.otherAreaFlag = otherAreaFlag;
	}



	/**
	 * Return the value associated with the column: REGIONALISM
	 */
	public java.lang.String getRegionalism () {
		return regionalism;
	}

	/**
	 * Set the value related to the column: REGIONALISM
	 * @param regionalism the REGIONALISM value
	 */
	public void setRegionalism (java.lang.String regionalism) {
		this.regionalism = regionalism;
	}



	/**
	 * Return the value associated with the column: FINANCE_CODE
	 */
	public java.lang.String getFinanceCode () {
		return financeCode;
	}

	/**
	 * Set the value related to the column: FINANCE_CODE
	 * @param financeCode the FINANCE_CODE value
	 */
	public void setFinanceCode (java.lang.String financeCode) {
		this.financeCode = financeCode;
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



	/**
	 * Return the value associated with the column: MISC
	 */
	public java.lang.String getMisc () {
		return misc;
	}

	/**
	 * Set the value related to the column: MISC
	 * @param misc the MISC value
	 */
	public void setMisc (java.lang.String misc) {
		this.misc = misc;
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


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof Bctl)) return false;
		else {
			Bctl bctl = (Bctl) obj;
			if (null == this.getBrcode() || null == bctl.getBrcode()) return false;
			else return (this.getBrcode().equals(bctl.getBrcode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getBrcode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getBrcode().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}