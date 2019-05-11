package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseTblCronTaskJobLog;







public class TblCronTaskJobLog extends BaseTblCronTaskJobLog {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TblCronTaskJobLog () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TblCronTaskJobLog (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TblCronTaskJobLog (
		java.lang.String id,
		java.lang.Integer jobno,
		java.lang.String subProceFunction) {

		super (
			id,
			jobno,
			subProceFunction);
	}

/*[CONSTRUCTOR MARKER END]*/


}