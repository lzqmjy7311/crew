/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.datadic.operation;

import com.huateng.ebank.business.datadic.service.DataDicService;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class DataDicOperation extends BaseOperation {
	public static final String ID = "DataDicOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	


	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		DataDic dd = (DataDic) context.getAttribute(IN_PARAM);
		DataDicService service = new DataDicService();
		if (CMD_QUERY.equals(cmd)) {
			
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(dd);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(dd);
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(dd.getId());
		}
	}

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
	 * @see com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}