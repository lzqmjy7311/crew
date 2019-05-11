package com.gbicc.person.customer.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.person.customer.entity.TCustomer;
import com.gbicc.person.customer.opration.TCustomerMngOperation;
import com.gbicc.person.customer.service.TCustomerService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;


/**
 * 
 * @author xudongdong
 *
 * 版本：2015年10月21日 上午11:43:03
 * 类说明：客户修改
 */
public class TCustomerMngModUpdate extends BaseUpdate {
	private static final String DATASET_ID = "TCustomerEntry";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCustomer dd = new TCustomer();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				
				String op = updateResultBean.getParameter("op");
				if("new".equals(op) || "copynew".equals(op)) {
					dd = new TCustomer();
					oc.setAttribute(TCustomerMngOperation.CMD, TCustomerMngOperation.CMD_INSERT);
				} else if ("mod".equals(op)) {
					dd = TCustomerService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TCustomerMngOperation.CMD, TCustomerMngOperation.CMD_UPDATE);
				}
				mapToObject(dd, map);
			}
			oc.setAttribute(TCustomerMngOperation.IN_PARAM, dd);
			OPCaller.call(TCustomerMngOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
