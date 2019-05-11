package com.huateng.ebank.business.management.operation;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.management.service.CurrrateMngService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class CurrrateMngOperation extends BaseOperation {
	private static Log log = LogFactory.getLog(CurrrateMngOperation.class);
	public final static String ID = "CurrrateMngOperation";
	public final static String IN_PARAM_NEW = "IN_PARAM_NEW";
	public final static String IN_PARAM_DEL = "IN_PARAM_DEL";
	public final static String IN_PARAM_UPD = "IN_PARAM_UPD";

	public final static String CMD = "CMD";
	//@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	//@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	//@Override
	@SuppressWarnings("unchecked")
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		if (log.isDebugEnabled()) {
            log.debug("enter into ExchangeRateManualInputOperation.execute");
        }

		String cmd = (String) context.getAttribute(CMD);
		List insertList = (List) context.getAttribute(IN_PARAM_NEW);
		List updateList = (List) context.getAttribute(IN_PARAM_UPD);
		List delList = (List) context.getAttribute("IN_PARAM_DEL");

		CurrrateMngService service = CurrrateMngService.getInstance();

		if("insert".equals(cmd)){
			service.addCurrrateMng(insertList);
		}else if ("delete".equals(cmd)) {
			service.delCurrrateMng(delList);
		} else if ("update".equals(cmd)) {
			service.updateCurrrateMng(updateList);
		}

        if (log.isDebugEnabled()) {
            log.debug("Exit ExchangeRateManualInputOperation.execute");
        }
	}

}
