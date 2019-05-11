package com.huateng.ebank.business.approve.bean;

import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.BiNationregion;
import com.huateng.ebank.entity.data.mng.PfSysParam;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.SysCurrency;
import com.huateng.ebank.entity.data.mng.SysTaskInfo;



/**
 *
 * @author zjx
 * 这个是用来存储待审批的中间页面的对象的bean
 * 包含taskinfobean和相应任务类型对应的bean;
 *
 */
public class TaskListBean {


	// primary key
	
	private String id;
	private SysTaskInfo sysTaskInfo;


	//审批时显示使用,目前共有6种
	private Bctl bctl;
	private RoleInfo roleInfo;
	private TlrInfoAuditBean tlrInfo;
	private SysCurrency currency;
	private BiNationregion biNationregion;
	//系统安全参数
	private PfSysParam pfSysparam;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SysTaskInfo getSysTaskInfo() {
		return sysTaskInfo;
	}
	public void setSysTaskInfo(SysTaskInfo sysTaskInfo) {
		this.sysTaskInfo = sysTaskInfo;
	}
	
	public Bctl getBctl() {
		return bctl;
	}
	public void setBctl(Bctl bctl) {
		this.bctl = bctl;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo ob) {
		this.roleInfo = ob;
	}
	public TlrInfoAuditBean getTlrInfo() {
		return tlrInfo;
	}
	public void setTlrInfo(TlrInfoAuditBean tlrInfo) {
		this.tlrInfo = tlrInfo;
	}

	public SysCurrency getCurrency() {
		return currency;
	}
	public void setCurrency(SysCurrency currency) {
		this.currency = currency;
	}
	public BiNationregion getBiNationregion() {
		return biNationregion;
	}
	public void setBiNationregion(BiNationregion biNationregion) {
		this.biNationregion = biNationregion;
	}
	public PfSysParam getPfSysparam() {
		return pfSysparam;
	}
	public void setPfSysparam(PfSysParam pfSysparam) {
		this.pfSysparam = pfSysparam;
	}
	
	
	




}
