/*
 * $Header: /home/plis/batch/cvs/cvsdvp/BocomplJAR/JavaSource/com/huateng/bocompl/common/ChangePwdOP.java,v 1.5 2005/07/13 04:41:03 wu_zhiqiang Exp $
 * $Revision: 1.5 $
 * $Date: 2005/07/13 04:41:03 $
 *
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.business.management.operation;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.service.UserMgrService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * 用户修改密码操作
 *
 * @author James wu
 * @version 1.0.0
 */

public class ChangePwdOP extends BaseOperation {

	// KEY值定义，包括输入IN 和输出OUT
	public static final String ID = "Management.ChangePwdOP";
	public static final String IN_OLD_PWD = "OLD_PWD";
	public static final String IN_NEW_PWD = "NEW_PWD";
	public static final String IN_AGAIN_NEW_PWD = "AGAIN_NEW_PWD";

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.BaseOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {

	}

	public void execute(OperationContext context) throws CommonException {
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String oldPwd = (String) context.getAttribute(ChangePwdOP.IN_OLD_PWD);
		String newPwd = (String) context.getAttribute(ChangePwdOP.IN_NEW_PWD);
		String againNewPwd = (String) context.getAttribute(ChangePwdOP.IN_AGAIN_NEW_PWD);
		// 用户密码校验
		UserMgrService userMgrService = new UserMgrService();
		userMgrService.checkPwdFields(oldPwd, newPwd, againNewPwd);
		userMgrService.checkUserPwd(globalInfo.getTlrno(), oldPwd, newPwd);
		// 修改用户密码
		userMgrService.updatePassword(globalInfo.getTlrno(), newPwd);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.BaseOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
