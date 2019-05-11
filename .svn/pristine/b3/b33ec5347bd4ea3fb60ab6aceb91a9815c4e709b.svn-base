package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.RoleInfo;


/**
 * This is an object that contains data related to the ROLE_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ROLE_INFO"
 */

public abstract class BaseRoleInfo  implements Serializable {

	public static String REF = "RoleInfo";
	public static String PROP_STATUS = "status";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_ROLE_TYPE = "roleType";
	public static String PROP_ROLE_NAME = "roleName";
	public static String PROP_EFFECT_DATE = "effectDate";
	public static String PROP_MISC = "misc";
	public static String PROP_BRCLASS = "brclass";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_ID = "id";


	// constructors
	public BaseRoleInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRoleInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String roleName;
	private java.lang.String status;
	private java.lang.String effectDate;
	private java.lang.String expireDate;
	private java.lang.String roleType;
	private java.lang.String brclass;
	private java.lang.String miscflgs;
	private java.lang.String misc;
	/** add by zhiyang.he 修改锁定状态 2012-09-6 begin*/
	private java.lang.String isLock;
	private java.lang.String st;
	private java.lang.String crtDt;
	private java.lang.String lastUpdTms;
	private java.lang.String lastUpdOper;
	/** add by zhiyang.he 修改锁定状态 2012-09-6 end*/


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="ROLE_ID"
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
	 * Return the value associated with the column: ROLE_NAME
	 */
	public java.lang.String getRoleName () {
		return roleName;
	}

	/**
	 * Set the value related to the column: ROLE_NAME
	 * @param roleName the ROLE_NAME value
	 */
	public void setRoleName (java.lang.String roleName) {
		this.roleName = roleName;
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
	 * Return the value associated with the column: ROLE_TYPE
	 */
	public java.lang.String getRoleType () {
		return roleType;
	}

	/**
	 * Set the value related to the column: ROLE_TYPE
	 * @param roleType the ROLE_TYPE value
	 */
	public void setRoleType (java.lang.String roleType) {
		this.roleType = roleType;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof RoleInfo)) return false;
		else {
			RoleInfo roleInfo = (RoleInfo) obj;
			if (null == this.getId() || null == roleInfo.getId()) return false;
			else return (this.getId().equals(roleInfo.getId()));
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
	/** add by zhiyang.he 修改锁定状态 2012-09-6 begin*/
	public java.lang.String getIsLock() {
		return isLock;
	}

	public void setIsLock(java.lang.String isLock) {
		this.isLock = isLock;
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