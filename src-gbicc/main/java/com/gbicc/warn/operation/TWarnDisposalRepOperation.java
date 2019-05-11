package com.gbicc.warn.operation;


import com.gbicc.warn.entity.TWarnDisposalRep;
import com.gbicc.warn.service.TWarnDisposalRepService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * @author likm
 * @time   2015年10月27日16:08:51
 * @desc   产品管理操作类
 */
public class TWarnDisposalRepOperation extends BaseOperation {
	public static final String ID = "TWarnDisposalRepOperation";
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
		TWarnDisposalRep TWarnDisposalRep = (TWarnDisposalRep) context.getAttribute(IN_PARAM);
		TWarnDisposalRepService service = TWarnDisposalRepService.getInstance();
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(TWarnDisposalRep);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(TWarnDisposalRep);
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(TWarnDisposalRep);
		}
	}

}
