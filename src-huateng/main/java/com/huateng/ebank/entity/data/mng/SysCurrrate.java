package com.huateng.ebank.entity.data.mng;

import com.huateng.ebank.entity.data.mng.base.BaseSysCurrrate;




public class SysCurrrate extends BaseSysCurrrate {

    /*[CONSTRUCTOR MARKER BEGIN]*/
	public SysCurrrate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SysCurrrate (java.lang.String id) {
		super(id);
	}

    /*[CONSTRUCTOR MARKER END]*/
    private String curName;

    private String deleteflag;
    /**
     * @return Returns the curName.
     */
    public String getCurName() {
        return curName;
    }

    /**
     * @param curName The curName to set.
     */
    public void setCurName(String curName) {
        this.curName = curName;
    }

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
}