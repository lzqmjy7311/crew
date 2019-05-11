package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the APPLYDTL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="APPLYDTL"
 */

public abstract class BaseApplydtl  implements Serializable {

	public static String REF = "Applydtl";
	public static String PROP_LAST_UPD_FUNC = "lastUpdFunc";
	public static String PROP_TLSRNO = "tlsrno";
	public static String PROP_MISC = "misc";
	public static String PROP_FUNC_CODE = "funcCode";
	public static String PROP_UNTREAD = "untread";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_ATTITUDE = "attitude";
	public static String PROP_CONTRACTNO = "contractno";
	public static String PROP_ROLE_ID = "roleId";
	public static String PROP_TXN_DATE = "txnDate";
	public static String PROP_CINO = "cino";
	public static String PROP_MEETING_FLAG = "meetingFlag";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_BRCODE = "brcode";
	public static String PROP_AUTO_FLAG = "autoFlag";
	public static String PROP_APPROVER = "approver";
	public static String PROP_AUTO_APPROVER = "autoApprover";
	public static String PROP_ID = "id";
	public static String PROP_APPNO = "appno";
	public static String PROP_REASON = "reason";


	// constructors
	public BaseApplydtl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApplydtl (String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private String id;

	// fields
	private java.lang.String appno;
	private java.lang.String approver;
	private java.lang.String apptype;
	private java.lang.String attitude;
	private java.lang.String autoApprover;
	private java.lang.String autoFlag;
	private java.lang.String brcode;
	private java.lang.String cino;
	private java.lang.String contractno;
	private java.lang.String funcCode;
	private java.lang.String lastUpdDate;
	private java.lang.String lastUpdFunc;
	private java.lang.String lastUpdTlr;
	private java.lang.String meetingFlag;
	private java.lang.String misc;
	private java.lang.String reason;
	private java.lang.Integer roleId;
	private java.lang.String tlsrno;
	private java.lang.String txnDate;
	private java.lang.String untread;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ID"
     */
	public String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (String id) {
		this.id = id;
	}




	/**
	 * Return the value associated with the column: APPNO
	 */
	public java.lang.String getAppno () {
		return appno;
	}

	/**
	 * Set the value related to the column: APPNO
	 * @param appno the APPNO value
	 */
	public void setAppno (java.lang.String appno) {
		this.appno = appno;
	}



	/**
	 * Return the value associated with the column: APPROVER
	 */
	public java.lang.String getApprover () {
		return approver;
	}

	/**
	 * Set the value related to the column: APPROVER
	 * @param approver the APPROVER value
	 */
	public void setApprover (java.lang.String approver) {
		this.approver = approver;
	}



	/**
	 * Return the value associated with the column: APPTYPE
	 */
	public java.lang.String getApptype () {
		return apptype;
	}

	/**
	 * Set the value related to the column: APPTYPE
	 * @param apptype the APPTYPE value
	 */
	public void setApptype (java.lang.String apptype) {
		this.apptype = apptype;
	}



	/**
	 * Return the value associated with the column: ATTITUDE
	 */
	public java.lang.String getAttitude () {
		return attitude;
	}

	/**
	 * Set the value related to the column: ATTITUDE
	 * @param attitude the ATTITUDE value
	 */
	public void setAttitude (java.lang.String attitude) {
		this.attitude = attitude;
	}



	/**
	 * Return the value associated with the column: AUTO_APPROVER
	 */
	public java.lang.String getAutoApprover () {
		return autoApprover;
	}

	/**
	 * Set the value related to the column: AUTO_APPROVER
	 * @param autoApprover the AUTO_APPROVER value
	 */
	public void setAutoApprover (java.lang.String autoApprover) {
		this.autoApprover = autoApprover;
	}



	/**
	 * Return the value associated with the column: AUTO_FLAG
	 */
	public java.lang.String getAutoFlag () {
		return autoFlag;
	}

	/**
	 * Set the value related to the column: AUTO_FLAG
	 * @param autoFlag the AUTO_FLAG value
	 */
	public void setAutoFlag (java.lang.String autoFlag) {
		this.autoFlag = autoFlag;
	}



	/**
	 * Return the value associated with the column: BRCODE
	 */
	public java.lang.String getBrcode () {
		return brcode;
	}

	/**
	 * Set the value related to the column: BRCODE
	 * @param brcode the BRCODE value
	 */
	public void setBrcode (java.lang.String brcode) {
		this.brcode = brcode;
	}



	/**
	 * Return the value associated with the column: CINO
	 */
	public java.lang.String getCino () {
		return cino;
	}

	/**
	 * Set the value related to the column: CINO
	 * @param cino the CINO value
	 */
	public void setCino (java.lang.String cino) {
		this.cino = cino;
	}



	/**
	 * Return the value associated with the column: CONTRACTNO
	 */
	public java.lang.String getContractno () {
		return contractno;
	}

	/**
	 * Set the value related to the column: CONTRACTNO
	 * @param contractno the CONTRACTNO value
	 */
	public void setContractno (java.lang.String contractno) {
		this.contractno = contractno;
	}



	/**
	 * Return the value associated with the column: FUNC_CODE
	 */
	public java.lang.String getFuncCode () {
		return funcCode;
	}

	/**
	 * Set the value related to the column: FUNC_CODE
	 * @param funcCode the FUNC_CODE value
	 */
	public void setFuncCode (java.lang.String funcCode) {
		this.funcCode = funcCode;
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
	 * Return the value associated with the column: MEETING_FLAG
	 */
	public java.lang.String getMeetingFlag () {
		return meetingFlag;
	}

	/**
	 * Set the value related to the column: MEETING_FLAG
	 * @param meetingFlag the MEETING_FLAG value
	 */
	public void setMeetingFlag (java.lang.String meetingFlag) {
		this.meetingFlag = meetingFlag;
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
	 * Return the value associated with the column: REASON
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: REASON
	 * @param reason the REASON value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}



	/**
	 * Return the value associated with the column: ROLE_ID
	 */
	public java.lang.Integer getRoleId () {
		return roleId;
	}

	/**
	 * Set the value related to the column: ROLE_ID
	 * @param roleId the ROLE_ID value
	 */
	public void setRoleId (java.lang.Integer roleId) {
		this.roleId = roleId;
	}


	/**
	 * Return the value associated with the column: TLSRNO
	 */
	public java.lang.String getTlsrno () {
		return tlsrno;
	}

	/**
	 * Set the value related to the column: TLSRNO
	 * @param tlsrno the TLSRNO value
	 */
	public void setTlsrno (java.lang.String tlsrno) {
		this.tlsrno = tlsrno;
	}



	/**
	 * Return the value associated with the column: TXN_DATE
	 */
	public java.lang.String getTxnDate () {
		return txnDate;
	}

	/**
	 * Set the value related to the column: TXN_DATE
	 * @param txnDate the TXN_DATE value
	 */
	public void setTxnDate (java.lang.String txnDate) {
		this.txnDate = txnDate;
	}



	/**
	 * Return the value associated with the column: UNTREAD
	 */
	public java.lang.String getUntread () {
		return untread;
	}

	/**
	 * Set the value related to the column: UNTREAD
	 * @param untread the UNTREAD value
	 */
	public void setUntread (java.lang.String untread) {
		this.untread = untread;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.Applydtl)) return false;
		else {
			com.huateng.ebank.entity.data.mng.Applydtl applydtl = (com.huateng.ebank.entity.data.mng.Applydtl) obj;
			return (this.getId().equals(applydtl.getId()));
		}
	}

	public int hashCode () {
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}