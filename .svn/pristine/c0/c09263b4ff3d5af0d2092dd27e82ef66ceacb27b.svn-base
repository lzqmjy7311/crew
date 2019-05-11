package com.gbicc.person.customer.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.person.customer.entity.GreatEvent;
import com.gbicc.person.customer.opration.TPlCustGreatEventDtlOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPlCustGreatEventDtlUpdate extends BaseUpdate {
	private static final String DATASET_ID ="GreatEventDtl";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			OperationContext oc = new OperationContext();
			
			String custId=updateResultBean.getParameter("custId");
			oc.setAttribute("custId",custId);
			GreatEvent greatEvent=new GreatEvent();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				mapToObject(greatEvent, map);
			}
			oc.setAttribute(TPlCustGreatEventDtlOperation.IN_PARAM,greatEvent);
			OPCaller.call(TPlCustGreatEventDtlOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}