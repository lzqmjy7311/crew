package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseFpPageOptDetail;



public class FpPageOptDetail extends BaseFpPageOptDetail {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FpPageOptDetail () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FpPageOptDetail (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FpPageOptDetail (
		java.lang.String id,
		java.lang.String name,
		java.lang.String descInfo,
		java.lang.String operation,
		java.lang.String parent,
		java.lang.String status,
		java.lang.String seqid,
		java.lang.String icon) {

		super (
			id,
			name,
			descInfo,
			operation,
			parent,
			status,
			seqid,
			icon);
	}

/*[CONSTRUCTOR MARKER END]*/


}