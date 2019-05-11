package com.gbicc.person.creditMemo.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.person.creditMemo.entity.TPlCreditMemo;
import com.gbicc.person.creditMemo.operation.TPlCreditMemoOperation;
import com.gbicc.person.creditMemo.service.TPlCreditMemoService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPlCreditMemoUpdate extends BaseUpdate {
	private static final String DATASET_ID ="TPlCreditMemo";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TPlCreditMemo dd = new TPlCreditMemo();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				
				String op = updateResultBean.getParameter("op");
				if("new".equals(op) || "copynew".equals(op)) {
					dd = new TPlCreditMemo();
					oc.setAttribute(TPlCreditMemoOperation.CMD,TPlCreditMemoOperation.CMD_INSERT);
				} else if ("mod".equals(op)) {
					dd = TPlCreditMemoService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TPlCreditMemoOperation.CMD,TPlCreditMemoOperation.CMD_UPDATE);
				}
				mapToObject(dd, map);
			}
			oc.setAttribute(TPlCreditMemoOperation.IN_PARAM, dd);
			OPCaller.call(TPlCreditMemoOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
