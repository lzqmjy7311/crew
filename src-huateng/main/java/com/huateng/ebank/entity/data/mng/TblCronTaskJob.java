package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseTblCronTaskJob;





public class TblCronTaskJob extends BaseTblCronTaskJob {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TblCronTaskJob () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TblCronTaskJob (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TblCronTaskJob (
		java.lang.String id,
		java.lang.Integer jobno,
		java.lang.String processFunction) {

		super (
			id,
			jobno,
			processFunction);
	}

/*[CONSTRUCTOR MARKER END]*/


}