package com.gbicc.bpm.entity;

import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.TlrInfo;

/**
 * 账户责任人批量分派记录表
 */
public class TPlAccountDistRecord  implements java.io.Serializable {

	private static final long serialVersionUID = 4492962472813944423L;
	
	private String id;
    /*
    * 分派记录主表ID.
    */
    private String distId;
    /*
    * 机构.
    */
    private Bctl brcode;
    /*
    * 责任人.
    */
    private TlrInfo tlrno;

    public TPlAccountDistRecord() {
    }

	/**
    */	
    public String getId() {
        return this.id;
    }
	/**
    */	
    public void setId(String id) {
        this.id = id;
    }
	/**
    * Get the 分派记录主表ID
    */	
    public String getDistId() {
        return this.distId;
    }
	/**
    * Set the 分派记录主表ID
    */	
    public void setDistId(String distId) {
        this.distId = distId;
    }
	/**
    * Get the 机构
    */	
    public Bctl getBrcode() {
        return this.brcode;
    }
	/**
    * Set the 机构
    */	
    public void setBrcode(Bctl brcode) {
        this.brcode = brcode;
    }
	/**
    * Get the 责任人
    */	
    public TlrInfo getTlrno() {
        return this.tlrno;
    }
	/**
    * Set the 责任人
    */	
    public void setTlrno(TlrInfo tlrno) {
        this.tlrno = tlrno;
    }
}