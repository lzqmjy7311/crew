package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.TlrRoleRel;


/**
 * This is an object that contains data related to the TLR_ROLE_REL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TLR_ROLE_REL"
 */

public abstract class BaseTlrRoleRel  implements Serializable {

	public static String REF = "TlrRoleRel";
	public static String PROP_STATUS = "status";
	public static String PROP_TLRNO = "tlrno";
	public static String PROP_ISDEFAULT = "isDefault";
	public static String PROP_ID = "id";
	public static String PROP_ROLE_ID = "roleId";

	private java.lang.String isDefault;//是否默认角色
	public java.lang.String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(java.lang.String isDefault) {
		this.isDefault = isDefault;
	}

	// constructors
	public BaseTlrRoleRel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTlrRoleRel (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String tlrno;
	private java.lang.Integer roleId;
	private java.lang.String status;



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
	 * Return the value associated with the column: TLRNO
	 */
	public java.lang.String getTlrno () {
		return tlrno;
	}

	/**
	 * Set the value related to the column: TLRNO
	 * @param tlrno the TLRNO value
	 */
	public void setTlrno (java.lang.String tlrno) {
		this.tlrno = tlrno;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof TlrRoleRel)) return false;
		else {
			TlrRoleRel tlrRoleRel = (TlrRoleRel) obj;
			if (null == this.getId() || null == tlrRoleRel.getId()) return false;
			else return (this.getId().equals(tlrRoleRel.getId()));
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