package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseBizLog;



public class BizLog extends BaseBizLog {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BizLog () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BizLog (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BizLog (
		long id,
		java.util.Date txdate,
		java.lang.String brcode,
		java.lang.String tlrno,
		java.lang.String tlsrno) {

		super (
			id,
			txdate,
			brcode,
			tlrno,
			tlsrno);
	}

/*[CONSTRUCTOR MARKER END]*/


}