package com.huateng.ebank.entity.data.mng;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.entity.data.mng.base.BaseRelationCode;
import com.huateng.ebank.framework.util.DataFormat;

public class RelationCode extends BaseRelationCode {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public RelationCode () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public RelationCode (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public RelationCode (
		java.lang.String id,
		java.lang.String relationName,
		java.lang.String cusType,
		java.lang.String unique,
		java.lang.String needCustno,
		java.lang.String needMemorabilia) {

		super (
			id,
			relationName,
			cusType,
			unique,
			needCustno,
			needMemorabilia);
	}

	/* [CONSTRUCTOR MARKER END] */


	public String getIdTypeName() {
		String id = DataFormat.trim(super.getId());
		String Relationname = DataFormat.trim(super.getRelationName());

		if (StringUtils.isEmpty(id) && StringUtils.isEmpty(Relationname)) {
			return "";
		}
		return id + "-" + Relationname;
	}

	public void setIdTypeName(String name) {

	}

}