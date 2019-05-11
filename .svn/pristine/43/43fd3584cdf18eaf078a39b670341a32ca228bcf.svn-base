package com.huateng.ebank.entity.data.mng;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.entity.data.mng.base.BaseBctl;
import com.huateng.ebank.framework.util.DataFormat;

public class Bctl extends BaseBctl {
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Bctl() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Bctl(java.lang.String brcode) {
		super(brcode);
	}

	/**
	 * Constructor for required fields
	 */
	public Bctl(java.lang.String brcode, java.lang.String brno) {

		super(brcode, brno);
	}

	/* [CONSTRUCTOR MARKER END] */
	private String blnBranchBrcode;
	private String blnUpBrcode;
	private String blnManageBrcode;

	private String billMailAddrName;
	private String brclassName;
	
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getBrcodeTypeName() {
		String brno = DataFormat.trim(super.getBrno());
		String brname = DataFormat.trim(super.getBrname());

		if (StringUtils.isEmpty(brno) && StringUtils.isEmpty(brname)) {
			return "";
		}
		return brno + "-" + brname;
	}

	public void setBrcodeTypeName(String name) {

	}

	public String getBrclassName() {
		return brclassName;
	}

	public void setBrclassName(String brclassName) {
		this.brclassName = brclassName;
	}

	/**
	 * @return Returns the billMailAddrName.
	 */
	public String getBillMailAddrName() {
		return billMailAddrName;
	}

	/**
	 * @param billMailAddrName
	 *            The billMailAddrName to set.
	 */
	public void setBillMailAddrName(String billMailAddrName) {
		this.billMailAddrName = billMailAddrName;
	}

	public String getBlnBranchBrcode() {
		return blnBranchBrcode;
	}

	public void setBlnBranchBrcode(String blnBranchBrcode) {
		this.blnBranchBrcode = blnBranchBrcode;
	}

	public String getBlnUpBrcode() {
		return blnUpBrcode;
	}

	public void setBlnUpBrcode(String blnUpBrcode) {
		this.blnUpBrcode = blnUpBrcode;
	}

	public String getBlnManageBrcode() {
		return blnManageBrcode;
	}

	public void setBlnManageBrcode(String blnManageBrcode) {
		this.blnManageBrcode = blnManageBrcode;
	}

}