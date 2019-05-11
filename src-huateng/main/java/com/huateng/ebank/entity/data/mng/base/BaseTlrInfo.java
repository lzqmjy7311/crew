package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.TlrInfo;


/**
 * This is an object that contains data related to the TLR_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TLR_INFO"
 */

public abstract class BaseTlrInfo  implements Serializable {

	public static String REF = "TlrInfo";
	public static String PROP_STATUS = "status";
	public static String PROP_LASTLOGOUTTM = "lastlogouttm";
	public static String PROP_TLRNO = "tlrno";
	public static String PROP_TLR_TYPE = "tlrType";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_PASSWDENC = "passwdenc";
	public static String PROP_CHEK_DPWD_FLG = "chekDpwdFlg";
	public static String PROP_PASSWORD = "password";
	public static String PROP_LOGIN_IP = "loginIp";
	public static String PROP_ROLEID = "roleid";
	public static String PROP_FLAG = "flag";
	public static String PROP_PASSWDWARNINTERVAL = "passwdwarninterval";
	public static String PROP_LAST_UPD_TIME = "lastUpdTime";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_SESSION_ID = "sessionId";
	public static String PROP_PSWDERRDATE = "pswderrdate";
	public static String PROP_LASTACCESSTM = "lastaccesstm";
	public static String PROP_PSWDERRCNT = "pswderrcnt";
	public static String PROP_PASSWDCHGINTERVAL = "passwdchginterval";
	public static String PROP_FAILMAXLOGIN = "failmaxlogin";
	public static String PROP_EFFECT_DATE = "effectDate";
	public static String PROP_BRCODE = "brcode";
	public static String PROP_AGENT_TYPE = "agentType";
	public static String PROP_EXT_TLRNO = "extTlrno";
	public static String PROP_EMAIL = "email";
	public static String PROP_TLR_NAME = "tlrName";
	public static String PROP_TOTPSWDERRCNT = "totpswderrcnt";
	public static String PROP_MSRNO = "msrno";


	// constructors
	public BaseTlrInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTlrInfo (java.lang.String tlrno) {
		this.setTlrno(tlrno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String tlrno;

	// fields
	private java.lang.String extTlrno;
	private java.lang.String tlrName;
	private java.lang.String tlrType;
	private java.lang.String agentType;
	private java.lang.String brcode;
	private java.lang.String password;
	private java.lang.String status;
	private java.lang.String chekDpwdFlg;
	private java.lang.String lastaccesstm;
	private java.lang.Integer roleid;
	private java.lang.Integer pswderrcnt;
	private java.lang.Integer totpswderrcnt;
	private java.lang.String pswderrdate;
	private java.lang.String lastlogouttm;
	private java.lang.String loginIp;
	private java.lang.String passwdenc;
	private java.lang.Integer failmaxlogin;
	private java.lang.Integer passwdchginterval;
	private java.lang.Integer passwdwarninterval;
	private java.lang.String sessionId;
	private java.lang.Integer msrno;
	private java.lang.String flag;
	private java.lang.String createDate;
	private java.lang.String effectDate;
	private java.lang.String expireDate;
	private java.lang.String email;
	/** add by zhiyang.he 修改锁定状态 2012-09-6 begin*/
	private java.lang.String isLockModify;
	private java.lang.String st;
	private java.lang.String crtDt;
	private java.lang.String lastUpdTms;
	private java.lang.String lastUpdOper;
	/** add by zhiyang.he 修改锁定状态 2012-09-6 end*/

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="TLRNO"
     */
	public java.lang.String getTlrno () {
		return tlrno;
	}

	/**
	 * Set the unique identifier of this class
	 * @param tlrno the new ID
	 */
	public void setTlrno (java.lang.String tlrno) {
		this.tlrno = tlrno;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: EXT_TLRNO
	 */
	public java.lang.String getExtTlrno () {
		return extTlrno;
	}

	/**
	 * Set the value related to the column: EXT_TLRNO
	 * @param extTlrno the EXT_TLRNO value
	 */
	public void setExtTlrno (java.lang.String extTlrno) {
		this.extTlrno = extTlrno;
	}



	/**
	 * Return the value associated with the column: TLR_NAME
	 */
	public java.lang.String getTlrName () {
		return tlrName;
	}

	/**
	 * Set the value related to the column: TLR_NAME
	 * @param tlrName the TLR_NAME value
	 */
	public void setTlrName (java.lang.String tlrName) {
		this.tlrName = tlrName;
	}



	/**
	 * Return the value associated with the column: TLR_TYPE
	 */
	public java.lang.String getTlrType () {
		return tlrType;
	}

	/**
	 * Set the value related to the column: TLR_TYPE
	 * @param tlrType the TLR_TYPE value
	 */
	public void setTlrType (java.lang.String tlrType) {
		this.tlrType = tlrType;
	}



	/**
	 * Return the value associated with the column: AGENT_TYPE
	 */
	public java.lang.String getAgentType () {
		return agentType;
	}

	/**
	 * Set the value related to the column: AGENT_TYPE
	 * @param agentType the AGENT_TYPE value
	 */
	public void setAgentType (java.lang.String agentType) {
		this.agentType = agentType;
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
	 * Return the value associated with the column: PASSWORD
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: PASSWORD
	 * @param password the PASSWORD value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
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
	 * Return the value associated with the column: CHEK_DPWD_FLG
	 */
	public java.lang.String getChekDpwdFlg () {
		return chekDpwdFlg;
	}

	/**
	 * Set the value related to the column: CHEK_DPWD_FLG
	 * @param chekDpwdFlg the CHEK_DPWD_FLG value
	 */
	public void setChekDpwdFlg (java.lang.String chekDpwdFlg) {
		this.chekDpwdFlg = chekDpwdFlg;
	}



	/**
	 * Return the value associated with the column: LASTACCESSTM
	 */
	public java.lang.String getLastaccesstm () {
		return lastaccesstm;
	}

	/**
	 * Set the value related to the column: LASTACCESSTM
	 * @param lastaccesstm the LASTACCESSTM value
	 */
	public void setLastaccesstm (java.lang.String lastaccesstm) {
		this.lastaccesstm = lastaccesstm;
	}



	/**
	 * Return the value associated with the column: ROLEID
	 */
	public java.lang.Integer getRoleid () {
		return roleid;
	}

	/**
	 * Set the value related to the column: ROLEID
	 * @param roleid the ROLEID value
	 */
	public void setRoleid (java.lang.Integer roleid) {
		this.roleid = roleid;
	}



	/**
	 * Return the value associated with the column: PSWDERRCNT
	 */
	public java.lang.Integer getPswderrcnt () {
		return pswderrcnt;
	}

	/**
	 * Set the value related to the column: PSWDERRCNT
	 * @param pswderrcnt the PSWDERRCNT value
	 */
	public void setPswderrcnt (java.lang.Integer pswderrcnt) {
		this.pswderrcnt = pswderrcnt;
	}



	/**
	 * Return the value associated with the column: TOTPSWDERRCNT
	 */
	public java.lang.Integer getTotpswderrcnt () {
		return totpswderrcnt;
	}

	/**
	 * Set the value related to the column: TOTPSWDERRCNT
	 * @param totpswderrcnt the TOTPSWDERRCNT value
	 */
	public void setTotpswderrcnt (java.lang.Integer totpswderrcnt) {
		this.totpswderrcnt = totpswderrcnt;
	}



	/**
	 * Return the value associated with the column: PSWDERRDATE
	 */
	public java.lang.String getPswderrdate () {
		return pswderrdate;
	}

	/**
	 * Set the value related to the column: PSWDERRDATE
	 * @param pswderrdate the PSWDERRDATE value
	 */
	public void setPswderrdate (java.lang.String pswderrdate) {
		this.pswderrdate = pswderrdate;
	}



	/**
	 * Return the value associated with the column: LASTLOGOUTTM
	 */
	public java.lang.String getLastlogouttm () {
		return lastlogouttm;
	}

	/**
	 * Set the value related to the column: LASTLOGOUTTM
	 * @param lastlogouttm the LASTLOGOUTTM value
	 */
	public void setLastlogouttm (java.lang.String lastlogouttm) {
		this.lastlogouttm = lastlogouttm;
	}



	/**
	 * Return the value associated with the column: LOGIN_IP
	 */
	public java.lang.String getLoginIp () {
		return loginIp;
	}

	/**
	 * Set the value related to the column: LOGIN_IP
	 * @param loginIp the LOGIN_IP value
	 */
	public void setLoginIp (java.lang.String loginIp) {
		this.loginIp = loginIp;
	}



	/**
	 * Return the value associated with the column: PASSWDENC
	 */
	public java.lang.String getPasswdenc () {
		return passwdenc;
	}

	/**
	 * Set the value related to the column: PASSWDENC
	 * @param passwdenc the PASSWDENC value
	 */
	public void setPasswdenc (java.lang.String passwdenc) {
		this.passwdenc = passwdenc;
	}



	/**
	 * Return the value associated with the column: FAILMAXLOGIN
	 */
	public java.lang.Integer getFailmaxlogin () {
		return failmaxlogin;
	}

	/**
	 * Set the value related to the column: FAILMAXLOGIN
	 * @param failmaxlogin the FAILMAXLOGIN value
	 */
	public void setFailmaxlogin (java.lang.Integer failmaxlogin) {
		this.failmaxlogin = failmaxlogin;
	}



	/**
	 * Return the value associated with the column: PASSWDCHGINTERVAL
	 */
	public java.lang.Integer getPasswdchginterval () {
		return passwdchginterval;
	}

	/**
	 * Set the value related to the column: PASSWDCHGINTERVAL
	 * @param passwdchginterval the PASSWDCHGINTERVAL value
	 */
	public void setPasswdchginterval (java.lang.Integer passwdchginterval) {
		this.passwdchginterval = passwdchginterval;
	}



	/**
	 * Return the value associated with the column: PASSWDWARNINTERVAL
	 */
	public java.lang.Integer getPasswdwarninterval () {
		return passwdwarninterval;
	}

	/**
	 * Set the value related to the column: PASSWDWARNINTERVAL
	 * @param passwdwarninterval the PASSWDWARNINTERVAL value
	 */
	public void setPasswdwarninterval (java.lang.Integer passwdwarninterval) {
		this.passwdwarninterval = passwdwarninterval;
	}



	/**
	 * Return the value associated with the column: SESSION_ID
	 */
	public java.lang.String getSessionId () {
		return sessionId;
	}

	/**
	 * Set the value related to the column: SESSION_ID
	 * @param sessionId the SESSION_ID value
	 */
	public void setSessionId (java.lang.String sessionId) {
		this.sessionId = sessionId;
	}



	/**
	 * Return the value associated with the column: MSRNO
	 */
	public java.lang.Integer getMsrno () {
		return msrno;
	}

	/**
	 * Set the value related to the column: MSRNO
	 * @param msrno the MSRNO value
	 */
	public void setMsrno (java.lang.Integer msrno) {
		this.msrno = msrno;
	}



	/**
	 * Return the value associated with the column: FLAG
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: FLAG
	 * @param flag the FLAG value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: CREATE_DATE
	 */
	public java.lang.String getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: CREATE_DATE
	 * @param createDate the CREATE_DATE value
	 */
	public void setCreateDate (java.lang.String createDate) {
		this.createDate = createDate;
	}

	/**
	 * Return the value associated with the column: EFFECT_DATE
	 */
	public java.lang.String getEffectDate () {
		return effectDate;
	}

	/**
	 * Set the value related to the column: EFFECT_DATE
	 * @param effectDate the EFFECT_DATE value
	 */
	public void setEffectDate (java.lang.String effectDate) {
		this.effectDate = effectDate;
	}



	/**
	 * Return the value associated with the column: EXPIRE_DATE
	 */
	public java.lang.String getExpireDate () {
		return expireDate;
	}

	/**
	 * Set the value related to the column: EXPIRE_DATE
	 * @param expireDate the EXPIRE_DATE value
	 */
	public void setExpireDate (java.lang.String expireDate) {
		this.expireDate = expireDate;
	}



	/**
	 * Return the value associated with the column: EMAIL
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: EMAIL
	 * @param email the EMAIL value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof TlrInfo)) return false;
		else {
			TlrInfo tlrInfo = (TlrInfo) obj;
			if (null == this.getTlrno() || null == tlrInfo.getTlrno()) return false;
			else return (this.getTlrno().equals(tlrInfo.getTlrno()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getTlrno()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getTlrno().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}
	/** add by zhiyang.he 修改锁定状态 2012-09-6 begin*/
	public java.lang.String getIsLockModify() {
		return isLockModify;
	}

	public void setIsLockModify(java.lang.String isLockModify) {
		this.isLockModify = isLockModify;
	}
	public java.lang.String getSt() {
		return st;
	}

	public void setSt(java.lang.String st) {
		this.st = st;
	}
	public java.lang.String getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(java.lang.String crtDt) {
		this.crtDt = crtDt;
	}

	public java.lang.String getLastUpdTms() {
		return lastUpdTms;
	}

	public void setLastUpdTms(java.lang.String lastUpdTms) {
		this.lastUpdTms = lastUpdTms;
	}

	public java.lang.String getLastUpdOper() {
		return lastUpdOper;
	}

	public void setLastUpdOper(java.lang.String lastUpdOper) {
		this.lastUpdOper = lastUpdOper;
	}
	/** add by zhiyang.he 修改锁定状态 2012-09-6 end*/

}