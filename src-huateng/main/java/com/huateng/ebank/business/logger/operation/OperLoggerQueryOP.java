package com.huateng.ebank.business.logger.operation;

import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.logger.bean.OperLoggerBean;
import com.huateng.ebank.business.logger.service.OperLoggerService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * 操作日志查询
 * @author kevin_qin
 *
 */
public class OperLoggerQueryOP extends BaseOperation {
	public final static String ID = "logger.OperLoggerQueryOP";
	public final static String IN_PARAMER = "IN_PARAMER";
	public final static String OUTLIST = "OUTLIST";
	public final static String CMD = "CMD";
	public final static String IN_PAGESIZE = "IN_PAGESIZE";
	public final static String IN_PAGEINDEX = "IN_PAGEINDEX";

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
		try{
			int pageIndex = (Integer) context.getAttribute(IN_PAGEINDEX);
			int pageSize = (Integer) context.getAttribute(IN_PAGESIZE);

			OperLoggerBean operLoggerBean = (OperLoggerBean) context.getAttribute(IN_PARAMER);
			PageQueryResult pageQueryResult = OperLoggerService.getInstance().getOperLoggerList(pageIndex,pageSize, operLoggerBean);
			context.setAttribute(OUTLIST, pageQueryResult);

			}catch (Exception e) {
				e.printStackTrace();
				throw new CommonException("操作日志信息查询失败...");
			}
	}
}
