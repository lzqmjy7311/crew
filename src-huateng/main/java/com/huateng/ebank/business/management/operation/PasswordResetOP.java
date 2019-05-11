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

public class PasswordResetOP extends BaseOperation {

	// KEY值定义，包括输入IN 和输出OUT
	public static final String ID = "Management.PasswordResetOP";
	public static final String IN_TLRNO = "IN_TLRNO";
	public static final String IN_NEW_PWD = "NEW_PWD";

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.BaseOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {

	}

	public void execute(OperationContext context) throws CommonException {
		String tlrno = (String) context.getAttribute(PasswordResetOP.IN_TLRNO);
		String newPwd = (String) context.getAttribute(PasswordResetOP.IN_NEW_PWD);
		// 修改用户密码
		UserMgrService userMgrService = new UserMgrService();
		userMgrService.updatePassword(tlrno, newPwd);
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
