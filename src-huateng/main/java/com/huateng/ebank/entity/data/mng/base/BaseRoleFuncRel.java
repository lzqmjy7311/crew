package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.RoleFuncRel;


/**
 * This is an object that contains data related to the ROLE_FUNC_REL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ROLE_FUNC_REL"
 */

public abstract class BaseRoleFuncRel  implements Serializable {

	public static String REF = "RoleFuncRel";
	public static String PROP_FUNCID = "funcid";
	public static String PROP_ID = "id";
	public static String PROP_ROLE_ID = "roleId";


	// constructors
	public BaseRoleFuncRel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRoleFuncRel (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer roleId;
	private java.lang.String funcid;



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
	 * Return the value associated with the column: FUNCID
	 */
	public java.lang.String getFuncid () {
		return funcid;
	}

	/**
	 * Set the value related to the column: FUNCID
	 * @param funcid the FUNCID value
	 */
	public void setFuncid (java.lang.String funcid) {
		this.funcid = funcid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof RoleFuncRel)) return false;
		else {
			RoleFuncRel roleFuncRel = (RoleFuncRel) obj;
			if (null == this.getId() || null == roleFuncRel.getId()) return false;
			else return (this.getId().equals(roleFuncRel.getId()));
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