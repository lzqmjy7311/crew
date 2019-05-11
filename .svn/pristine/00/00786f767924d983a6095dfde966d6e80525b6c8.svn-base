/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.management.operation;

import java.util.ArrayList;
import java.util.List;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.view.TlrInfoView;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * Title: com.huateng.ebank.business.management.operation.RoleInfoOperation.java
 * Description: TODO Copyright (c) 2006 Company: Shanghai Huateng Software
 * Systems Co., Ltd. 交行sems中已经废弃
 *
 * @author shen_antonio
 * @version v1.0,2008-6-22
 */

public class TlrInfoOperation extends BaseOperation {
	public static final String ID = "Management.TlrInfoOperation";
	public static final String CMD = "CMD";
	public static final String IN_TLR_LIST = "IN_TLR_LIST";
	public static final String OUT_TLR_LIST = "OUT_TLR_LIST";
	public static final String OUT_ROLE_LIST = "OUT_ROLE_LIST";
	public static final String ALL_ROLE_LIST = "ALL_ROLE_LIST";
	public static final String OUT_TLRROLECHANGE_LIST = "OUT_TLRROLECHANGE_LIST";
	public static final String OUT_TLRPLURALISMROLE_LIST = "OUT_TLRPLURALISMROLE_LIST";

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {
		TlrInfoService service = TlrInfoService.getInstance();
		String brcode = (String) context.getAttribute("brcode");
		String innerbrcode = (String) context.getAttribute("innerbrcode");
		String tlrno = (String) context.getAttribute("tlrno");
		String cmd = (String) context.getAttribute(TlrInfoOperation.CMD);
		if (cmd.equals("SELECT_INFO")) {
			List tlrList = service.selectTlrInfo(brcode, tlrno);
			List tlrInfoViewList = new ArrayList();
			for (int i = 0; i < tlrList.size(); i++) {
				TlrInfoView tlrInfoView = new TlrInfoView();
				TlrInfo tlrInfo = (TlrInfo) tlrList.get(i);
				tlrInfoView.setTlrno(String.valueOf(tlrInfo.getTlrno()));
				tlrInfoView.setTlrnoName(tlrInfo.getTlrName());
				tlrInfoView.setInnerbrcode(tlrInfo.getBrcode());
				tlrInfoView.setBrcode(BaseDAOUtils.getBctlDAO().query(
						tlrInfo.getBrcode()).getBrno());
				tlrInfoView.setPasswd(tlrInfo.getPassword());
				tlrInfoView.setStatus(tlrInfo.getStatus());
//				tlrInfoView.setCreatDate(tlrInfo.getCreatDate());
//				tlrInfoView.setEffectDate(tlrInfo.getEffectDate());
//				tlrInfoView.setExpireDate(tlrInfo.getExpireDate());
				tlrInfoView.setLatelyLoginTime(tlrInfo.getLastaccesstm());
				tlrInfoView.setLatelyLogoutTime( tlrInfo.getLastlogouttm());
				
				
				tlrInfoView.setIp(tlrInfo.getLoginIp());
				tlrInfoViewList.add(tlrInfoView);
			}
			context.setAttribute(OUT_TLR_LIST, tlrInfoViewList);
		} else if (cmd.equals("SELECT_ROLES")) {
			context
					.setAttribute(OUT_ROLE_LIST, service
							.selectRolesByTlr(tlrno));
			context.setAttribute(ALL_ROLE_LIST, service
					.selectRolesWithoutNullification());
		} else if (cmd.equals("SELECT_TLRROLEINFO")) {
			if (!brcode.equals(innerbrcode))
				brcode = innerbrcode;
			context.setAttribute(OUT_TLR_LIST, service.selectTlrRolesInfo(
					brcode, tlrno));
		} else if (cmd.equals("SELECT_ADD")) {
			context.setAttribute(OUT_TLR_LIST, service.selectTlrInfoAdd(brcode,
					tlrno));
		} else if (cmd.equals("UPDATE")) {
			context.setAttribute("resultList", service.updateTlrInfo(
					(List) context.getAttribute("insertRoleList"),
					(List) context.getAttribute("deleteRoleList"),
					(TlrInfo) context.getAttribute("tlrInfo")));
		} else if (cmd.equals("DELETE")) {
			service.deleteTlr((TlrInfo) context.getAttribute("tlrInfo"));
		} else if (cmd.equals("ACTIVATION")) {
			service.TlrActivation((TlrInfo) context.getAttribute("tlrInfo"));
		} else if (cmd.equals("TLR_ROLE_CHANGE")) {
			context.setAttribute(this.OUT_TLRROLECHANGE_LIST, service
					.getTlrRoleChange());
		} else if (cmd.equals("TLR_PLURALISM_ROLE")) {
			context.setAttribute(this.OUT_TLRPLURALISMROLE_LIST, service
					.getPluRole());
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}