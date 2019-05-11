package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;

import com.huateng.ebank.entity.data.mng.BranchFuncRel;


/**
 * This is an object that contains data related to the BRANCH_FUNC_REL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BRANCH_FUNC_REL"
 */

public abstract class BaseBranchFuncRel  implements Serializable {

	public static String REF = "BranchFuncRel";
	public static String PROP_FUNCID = "funcid";
	public static String PROP_ID = "id";
	public static String PROP_BRCODE = "brcode";


	// constructors
	public BaseBranchFuncRel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBranchFuncRel (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String brcode;
	private java.lang.String funcid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="ID"
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
		if (!(obj instanceof BranchFuncRel)) return false;
		else {
			BranchFuncRel branchFuncRel = (BranchFuncRel) obj;
			if (null == this.getId() || null == branchFuncRel.getId()) return false;
			else return (this.getId().equals(branchFuncRel.getId()));
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