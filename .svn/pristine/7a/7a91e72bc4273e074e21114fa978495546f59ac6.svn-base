/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.management.operation;

import java.util.List;

import com.huateng.ebank.business.management.service.RoleInfoService;
import com.huateng.ebank.entity.view.RoleInfoView;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * Title: com.huateng.ebank.business.management.operation.RoleInfoOperation.java
 * Description: TODO Copyright (c) 2006 Company: Shanghai Huateng Software
 * Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version v1.0,2008-6-22
 */

public class RoleInfoOperation extends BaseOperation {
	public static final String ID = "Management.RoleInfoOperation";
	public static final String CMD = "CMD";
	public static final String IN_ROLE_LIST = "IN_ROLE_LIST";
	public static final String OUT_ROLE_LIST = "OUT_ROLE_LIST";
	public static final String IN_FUNC_LIST = "IN_FUNC_LIST";
	public static final String IN_REPORT_LIST = "IN_REPORT_LIST";
	public static final String OUT_FUNC_LIST = "OUT_FUNC_LIST";
	public static final String OUT_REPORT_LIST = "OUT_REPORT_LIST";

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
	public void execute(OperationContext context) {
		// TODO Auto-generated method stub
		// RoleInfoDAO roleInfoDao = DAOUtils.getRoleInfoDAO();
		String cmd = (String) context.getAttribute(RoleInfoOperation.CMD);
		RoleInfoService ris = RoleInfoService.getInstance();
		// 查询所有岗位信息
		if (cmd.equals("SELECT")) {
			List list;
			try {
				list = ris.selectAllRoleInfoService();
				context.setAttribute(RoleInfoOperation.OUT_ROLE_LIST, list);
			} catch (CommonException e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("SELECT_FUNC")) {
			RoleInfoView riv = (RoleInfoView) context.getAttribute("riv");
			List list = null;
			try {
				list = ris.getRoleInfoFuncData(riv);
				context.setAttribute(RoleInfoOperation.OUT_FUNC_LIST, list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("SELECT_REPORT")) {
			RoleInfoView riv = (RoleInfoView) context.getAttribute("riv");
			List list = null;
			try {
				list = ris.getRoleInfoReportData(riv);
				context.setAttribute(RoleInfoOperation.OUT_REPORT_LIST, list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("UPDATE_FUNC")) {
			List mylist = (List) context
					.getAttribute(RoleInfoOperation.IN_FUNC_LIST);
			try {
				ris.updateRoleInfoFuncService(mylist);
			} catch (CommonException e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("UPDATE_REPORT")) {
			List mylist = (List) context
					.getAttribute(RoleInfoOperation.IN_REPORT_LIST);
			try {
				ris.updateRoleInfoReportService(mylist);
			} catch (CommonException e) {
				e.printStackTrace();
			}
		}

	}

	public void afterProc(OperationContext context) throws CommonException {

	}

}