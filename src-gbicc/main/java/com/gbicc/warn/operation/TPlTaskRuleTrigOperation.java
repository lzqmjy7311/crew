package com.gbicc.warn.operation;

import com.gbicc.personCommon.entity.TPlTaskRuleTrig;
import com.gbicc.warn.service.TPlTaskRuleTrigService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TPlTaskRuleTrigOperation extends BaseOperation {

	public static final String ID = TPlTaskRuleTrigOperation.class.getSimpleName();
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
		TPlTaskRuleTrig dd = (TPlTaskRuleTrig) context.getAttribute(IN_PARAM);
		TPlTaskRuleTrigService service = TPlTaskRuleTrigService.getInstance();
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(dd);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(dd);
		} else if (CMD_DELETE.equals(cmd)) {
//			service.delete(dd.getId());
		}
	}

}
