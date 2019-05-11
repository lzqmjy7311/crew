package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


public abstract class BasePfSysParamPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String magicId;
	private java.lang.String paramId;


	public BasePfSysParamPK () {}

	public BasePfSysParamPK (
		java.lang.String magicId,
		java.lang.String paramId) {

		this.setMagicId(magicId);
		this.setParamId(paramId);
	}


	/**
	 * Return the value associated with the column: MAGIC_ID
	 */
	public java.lang.String getMagicId () {
		return magicId;
	}

	/**
	 * Set the value related to the column: MAGIC_ID
	 * @param magicId the MAGIC_ID value
	 */
	public void setMagicId (java.lang.String magicId) {
		this.magicId = magicId;
	}



	/**
	 * Return the value associated with the column: PARAM_ID
	 */
	public java.lang.String getParamId () {
		return paramId;
	}

	/**
	 * Set the value related to the column: PARAM_ID
	 * @param paramId the PARAM_ID value
	 */
	public void setParamId (java.lang.String paramId) {
		this.paramId = paramId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.PfSysParamPK)) return false;
		else {
			com.huateng.ebank.entity.data.mng.PfSysParamPK mObj = (com.huateng.ebank.entity.data.mng.PfSysParamPK) obj;
			if (null != this.getMagicId() && null != mObj.getMagicId()) {
				if (!this.getMagicId().equals(mObj.getMagicId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getParamId() && null != mObj.getParamId()) {
				if (!this.getParamId().equals(mObj.getParamId())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuffer sb = new StringBuffer();
			if (null != this.getMagicId()) {
				sb.append(this.getMagicId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getParamId()) {
				sb.append(this.getParamId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}