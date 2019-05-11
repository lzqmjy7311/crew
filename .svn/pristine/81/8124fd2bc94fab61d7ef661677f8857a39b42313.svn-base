package com.gbicc.company.warnDisposal.operation;

import com.gbicc.company.warnDisposal.service.TCmWarnTaskService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class StartWarnTaskDcOperation extends BaseOperation {

	public static final String ID = StartWarnTaskDcOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		try {
			
			//事务处理
			String taskId=(String) context.getAttribute("taskId");
			TCmWarnTaskService service=TCmWarnTaskService.getInstance();
			service.startProcessDC(taskId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
