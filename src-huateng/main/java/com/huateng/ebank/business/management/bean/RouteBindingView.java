/*
 * Created on 2005-7-14
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.management.bean;

import java.math.BigDecimal;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RouteBindingView {
	/** modify by shen_antonio 20091214 jira:BMS-2334 begin .*/
	private boolean select   = false;
	/** modify by shen_antonio 20091214 jira:BMS-2334 end .*/
	private String bussType;
	private String bizType;
	private String draftType;
	private BigDecimal maxAmt;
	private String startBrhno;
	private String brhClass;
	private Integer routeId;
	private String startBrhid;
	private String startBrhidName;
	private String isBand;
	private String routeDesc;
	private Integer id;
	private String routeName;

	private String bussProc;
	//虚拟字段，该字段用于区页面的分该记录是从数据库读出来的，还是用户在页面新增的，如果该字段不为空则是页面上用户新增的字段
	//在查询的getter方法中给该字段赋值
	// ***************  yjw add beging **********************
    private String v_id;

	public String getV_id() {
		return v_id;
	}
	public void setV_id(String v_id) {
		this.v_id = v_id;
	}
	// ***************  yjw add end  **********************

	public String getBussType() {
		return bussType;
	}
	public void setBussType(String bussType) {
		this.bussType = bussType;
	}
	public String getDraftType() {
		return draftType;
	}
	public void setDraftType(String draftType) {
		this.draftType = draftType;
	}
	public BigDecimal getMaxAmt() {
		return maxAmt;
	}
	public void setMaxAmt(BigDecimal maxAmt) {
		this.maxAmt = maxAmt;
	}
	public String getStartBrhno() {
		return startBrhno;
	}
	public void setStartBrhno(String startBrhno) {
		this.startBrhno = startBrhno;
	}
	public String getBrhClass() {
		return brhClass;
	}
	public void setBrhClass(String brhClass) {
		this.brhClass = brhClass;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public String getIsBand() {
		return isBand;
	}
	public void setIsBand(String isBand) {
		this.isBand = isBand;
	}
	public String getRouteDesc() {
		return routeDesc;
	}
	public void setRouteDesc(String routeDesc) {
		this.routeDesc = routeDesc;
	}
	/** modify by shen_antonio 20091214 jira:BMS-2334 begin .*/
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	/** modify by shen_antonio 20091214 jira:BMS-2334 end .*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStartBrhid() {
		return startBrhid;
	}
	public void setStartBrhid(String startBrhid) {
		this.startBrhid = startBrhid;
	}
	public String getStartBrhidName() {
		return startBrhidName;
	}
	public void setStartBrhidName(String startBrhidName) {
		this.startBrhidName = startBrhidName;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getBussProc() {
		return bussProc;
	}
	public void setBussProc(String bussProc) {
		this.bussProc = bussProc;
	}

}
