package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseFpPageDetail;



public class FpPageDetail extends BaseFpPageDetail {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public FpPageDetail () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public FpPageDetail (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public FpPageDetail (
		java.lang.String id,
		java.lang.String name,
		java.lang.String descInfo,
		java.lang.String pagfeUrl,
		java.lang.String paramList,
		java.lang.String parent,
		java.lang.String status) {

		super (
			id,
			name,
			descInfo,
			pagfeUrl,
			paramList,
			parent,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}