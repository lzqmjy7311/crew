package com.huateng.ebank.business.rolemng.operation;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.entity.dao.mng.RoleInfoDAO;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class RoleMngOperation extends BaseOperation {

	public static final String ID = "management.RoleMngOperation";
	public static final String CMD = "cmd";
	public static final String IN_ROLEID = "IN_ROLEID";
	public static final String IN_PARAM = "IN_PARAM";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.
	 * ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {
		RoleInfoDAO roleDao = DAOUtils.getRoleInfoDAO();

		if ("status".equals(context.getAttribute(CMD))) {
			String roleid = (String) context.getAttribute(IN_ROLEID);
			String status = (String) context.getAttribute(IN_PARAM);
			
			RoleInfo role = roleDao.query(Integer.valueOf(roleid));
			role.setStatus(status);
			
			roleDao.getHibernateTemplate().saveOrUpdate(role);
		} 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}