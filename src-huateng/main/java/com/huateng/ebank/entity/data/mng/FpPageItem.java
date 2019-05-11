package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseFpPageItem;



public class FpPageItem extends BaseFpPageItem {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FpPageItem () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FpPageItem (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FpPageItem (
		java.lang.String id,
		java.lang.String name,
		java.lang.String descInfo,
		java.lang.String typeid,
		java.lang.String viewtype,
		java.lang.String defaultno,
		java.lang.String status) {

		super (
			id,
			name,
			descInfo,
			typeid,
			viewtype,
			defaultno,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}