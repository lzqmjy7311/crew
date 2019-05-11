package com.huateng.ebank.business.parammng.operation;

import java.util.List;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.entity.dao.mng.BhProcStepDAO;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * @author weikun wang
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class BhProcStepOperation extends BaseOperation{
    public static final String CMD = "CMD";
    public static final String IN_BHPROC_LIST = "IN_BHPROC_LIST";
    public static final String OUT_BHPROC_LIST = "OUT_BHPROC_LIST";
    public static final String IN_FUNC_LIST="IN_FUNC_LIST";
    public static final String IN_REPORT_LIST="IN_REPORT_LIST";
	/* (non-Javadoc)
	 * @see com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {

	}
	public void execute(OperationContext context) throws CommonException {
		BhProcStepDAO bhProcStepDAO = DAOUtils.getBatchProcessStepDAO();
		String cmd = (String) context.getAttribute(BhProcStepOperation.CMD);
		//查询批量步骤表信息
		if (cmd.equals("SELECT")) {
			List info = bhProcStepDAO.queryByCondition("1=1 order by id");
			context.setAttribute(BhProcStepOperation.OUT_BHPROC_LIST, info);}
		}

	/* (non-Javadoc)
	 * @see com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {

	}

}
