package com.huateng.ebank.entity.data.mng;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.entity.data.mng.base.BaseCurrency;
import com.huateng.ebank.framework.util.DataFormat;

public class Currency extends BaseCurrency {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Currency () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Currency (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Currency (
		java.lang.String id,
		java.lang.String curno,
		java.lang.String cnname,
		java.lang.String enname,
		java.lang.Short dratedays,
		java.lang.String cursymbol,
		java.lang.String isusd) {

		super (
			id,
			curno,
			cnname,
			enname,
			dratedays,
			cursymbol,
			isusd);
	}

	/* [CONSTRUCTOR MARKER END] */

	public String getCcyNoAndCurrNm() {
		String ccyNo = DataFormat.trim(super.getId());
		String currNm = DataFormat.trim(super.getCnname());

		if (StringUtils.isEmpty(ccyNo) && StringUtils.isEmpty(currNm)) {
			return "";
		}
		return ccyNo + "-" + currNm;
	}

}