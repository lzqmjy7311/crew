package com.gbicc.warn.ComninationWarn.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.warn.ComninationWarn.entity.TCwThresholdversion;
import com.gbicc.warn.ComninationWarn.operation.TCwThresholdversionOperation;
import com.gbicc.warn.ComninationWarn.service.TCwThresholdversionService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCwThresholdversionUpdate extends BaseUpdate {
	private static final String DATASET_ID ="subthresholdtable";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCwThresholdversion dd = new TCwThresholdversion();
			TCwThresholdversion newdd = new TCwThresholdversion();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				
				String op = updateResultBean.getParameter("op");
				if("new".equals(op) || "copynew".equals(op)) {
					dd = new TCwThresholdversion();
					oc.setAttribute(TCwThresholdversionOperation.CMD,TCwThresholdversionOperation.CMD_INSERT);
				} else if ("mod".equals(op)) {
					dd = TCwThresholdversionService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TCwThresholdversionOperation.CMD,TCwThresholdversionOperation.CMD_UPDATE);
				}
				mapToObject(newdd, map);
			}
			oc.setAttribute(TCwThresholdversionOperation.IN_PARAM, newdd);
			oc.setAttribute(TCwThresholdversionOperation.IN_PARAM_OLD, dd);
			OPCaller.call(TCwThresholdversionOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
