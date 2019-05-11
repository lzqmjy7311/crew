package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseFpPageOptItem;



public class FpPageOptItem extends BaseFpPageOptItem {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FpPageOptItem () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FpPageOptItem (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FpPageOptItem (
		java.lang.String id,
		java.lang.String name,
		java.lang.String descInfo,
		java.lang.String viewtype,
		java.lang.String typeid,
		java.lang.String status) {

		super (
			id,
			name,
			descInfo,
			viewtype,
			typeid,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}