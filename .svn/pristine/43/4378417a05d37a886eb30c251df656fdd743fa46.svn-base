package com.huateng.ebank.entity.data.mng;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.entity.data.mng.base.BaseSysCurrency;
import com.huateng.ebank.framework.util.DataFormat;



public class SysCurrency extends BaseSysCurrency {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SysCurrency () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SysCurrency (java.lang.String id) {
		super(id);
	}




/*[CONSTRUCTOR MARKER END]*/


	public String getCurrencyName()
	{
		String id = DataFormat.trim(super.getId());
		String cnname = DataFormat.trim(super.getCnname());

		if(StringUtils.isEmpty(id) && StringUtils.isEmpty(cnname))
		{
			return "";
		}
		return cnname;
	}

	public void setCurrencyNoName(String name)
	{

	}

}