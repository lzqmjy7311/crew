package com.gbicc.company.warnDisposal.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.company.warnDisposal.entity.TCmCustomer;
import com.gbicc.company.warnDisposal.operation.TCmCustomerOperation;
import com.gbicc.company.warnDisposal.service.TCmCustomerService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCmCustomerUpdate extends BaseUpdate {
	private static final String DATASET_ID ="TCmCustomer";
	private static final String DATASET_ID1 ="TCmWarnControlmeasure";
	private static final String DATASET_ID2 ="TCmWarnTask";
	private static final String DATASET_ID3 ="TCmWarnTaskRel";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCmCustomer dd = new TCmCustomer();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				
				String op = updateResultBean.getParameter("op");
				if("new".equals(op) || "copynew".equals(op)) {
					dd = new TCmCustomer();
					oc.setAttribute(TCmCustomerOperation.CMD,TCmCustomerOperation.CMD_INSERT);
				} else if ("mod".equals(op)) {
					dd = TCmCustomerService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TCmCustomerOperation.CMD,TCmCustomerOperation.CMD_UPDATE);
				}
				mapToObject(dd, map);
			}
			oc.setAttribute(TCmCustomerOperation.IN_PARAM, dd);
			OPCaller.call(TCmCustomerOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
