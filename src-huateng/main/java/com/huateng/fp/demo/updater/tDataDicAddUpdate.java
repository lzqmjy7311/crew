package com.huateng.fp.demo.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.datadic.operation.DataDicOperation;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class tDataDicAddUpdate extends BaseUpdate {
	private static final String TDATASET_ID = "tDataDicInfo";

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(TDATASET_ID);
			DataDic dd = new DataDic();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				String op = updateResultBean.getParameter("op");
				if("new".equals(op) || "copynew".equals(op)) {
					dd = new DataDic();
					oc.setAttribute(DataDicOperation.CMD, DataDicOperation.CMD_INSERT);
				} else if ("mod".equals(op)) {
					dd = BaseDAOUtils.getDataDicDAO().findById((String) map.get("id"));
					oc.setAttribute(DataDicOperation.CMD, DataDicOperation.CMD_UPDATE);
				}

				mapToObject(dd, map);
			}
			
			oc.setAttribute(DataDicOperation.IN_PARAM, dd);
			OPCaller.call(DataDicOperation.ID, oc);

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
