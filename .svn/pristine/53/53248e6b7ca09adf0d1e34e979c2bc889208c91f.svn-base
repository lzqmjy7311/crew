package com.huateng.ebank.business.management.operation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.entity.data.mng.PfSysParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


public class DelayOperation extends BaseOperation {
	private static Log log = LogFactory.getLog(DelayOperation .class);
	public final static String IN_PARAM_VALUE = "IN_PARAM_VALUE";
	public final static String OUT_PARAM = "OUT_PARAM ";
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
		// TODO Auto-generated method stub
		if (log.isDebugEnabled()) {
            log.debug("enter into DelayOperation.execute");
        }
		String value=(String) context.getAttribute(IN_PARAM_VALUE);
		PfSysParam param = DAOUtils.getPfSysParamDAO().query("DELAY", "100");
		param.setParamValueTx(value);
		DAOUtils.getPfSysParamDAO().saveOrUpdate(param);
		context.setAttribute("OUT_PARAM ", true);

        if (log.isDebugEnabled()) {
            log.debug("Exit DelayOperation.execute");
        }
	}
}
