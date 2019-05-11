package com.gbicc.person.creditMemo.operation;

import com.gbicc.person.creditMemo.entity.TPlCreditMemo;
import com.gbicc.person.creditMemo.service.TPlCreditMemoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TPlCreditMemoOperation extends BaseOperation {

	public static final String ID = "TPlCreditMemoOperation";
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
		TPlCreditMemo dd = (TPlCreditMemo) context.getAttribute(IN_PARAM);
		TPlCreditMemoService service = TPlCreditMemoService.getInstance();
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(dd);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(dd);
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(dd.getId());
		}
	}

}
