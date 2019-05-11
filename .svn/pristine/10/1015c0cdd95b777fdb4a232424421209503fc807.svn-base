package com.gbicc.warn.ComninationWarn.operation;

import com.gbicc.warn.ComninationWarn.entity.TCwThresholdversion;
import com.gbicc.warn.ComninationWarn.service.TCwThresholdversionService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TCwThresholdversionOperation extends BaseOperation {

	public static final String ID = TCwThresholdversionOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String IN_PARAM_OLD = "IN_PARAM_OLD";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		TCwThresholdversion dd = (TCwThresholdversion) context.getAttribute(IN_PARAM);
		TCwThresholdversion olddd = (TCwThresholdversion) context.getAttribute(IN_PARAM_OLD);
		TCwThresholdversionService service = TCwThresholdversionService.getInstance();

		
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(dd);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(dd);
			
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(dd.getIndexCode());
		}
	}

}
