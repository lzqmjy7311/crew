package com.gbicc.person.monitor.operation;

import com.gbicc.person.monitor.entity.TPlDqMonitor;
import com.gbicc.person.monitor.service.TPlDqMonitorService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * @author likm
 * @time   2015年11月6日09:59:58
 * @desc   定期监控报告操作类
 */
public class TPlDqMonitorOperation extends BaseOperation {
	public static final String ID = "TPlDqMonitorOperation";
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
		String cmd = (String) context.getAttribute(CMD);
		TPlDqMonitor monitor = (TPlDqMonitor) context.getAttribute(IN_PARAM);
		TPlDqMonitorService service = TPlDqMonitorService.getInstance();
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(monitor);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(monitor);
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(monitor);
		}
	}
}
