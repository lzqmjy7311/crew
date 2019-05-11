package com.huateng.ebank.business.management.updater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.CurrrateMngOperation;
import com.huateng.ebank.entity.data.mng.SysCurrrate;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class CurrrateMngUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("CurrrateMng");
			SysCurrrate cr = null ;
			List insertList = new ArrayList();
			while (updateResultBean.hasNext()) {
				cr = new SysCurrrate();
				Map map = new HashMap();
				map = updateResultBean.next();
				mapToObject(cr,map );
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(cr);
					break;
				default:
					break;
				}
			}

			OperationContext oc = new OperationContext();
			oc.setAttribute(CurrrateMngOperation.CMD, "insert");
			oc.setAttribute(CurrrateMngOperation.IN_PARAM_NEW, insertList);
			OPCaller.call(CurrrateMngOperation.ID, oc);

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
