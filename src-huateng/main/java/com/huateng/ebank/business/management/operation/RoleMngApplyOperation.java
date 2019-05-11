package com.huateng.ebank.business.management.operation;

import java.util.List;

import com.huateng.ebank.business.approve.service.RoleInfoTSKService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * @Description:
 * @Package: com.huateng.ebank.business.custadmin.operation
 * @author: fubo
 * @date: 2010-7-30 涓婂崃11:13:56
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class RoleMngApplyOperation extends BaseOperation {

	public static final String ID = "management.RoleMngApplyOperation";
	public static final String IN_INSERT = "IN_INSERT";
	public static final String IN_UPDATE = "IN_UPDATE";
	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		List insertList = (List) context.getAttribute(IN_INSERT);
		List updateList = (List) context.getAttribute(IN_UPDATE);
		RoleInfoTSKService roleInfoService = RoleInfoTSKService.getInstance();
		roleInfoService.saveCustRole(insertList, updateList);
	}

}
