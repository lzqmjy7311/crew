package com.gbicc.company.warnDisposal.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.company.warnDisposal.entity.TCmWarnControlmeasure;
import com.gbicc.company.warnDisposal.operation.TCmWarnControlmeasureOperation;
import com.gbicc.company.warnDisposal.service.TCmWarnControlmeasureService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCmWarnControlmeasureUpdate extends BaseUpdate {
	private static final String DATASET_ID ="TCmWarnControlmeasure";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCmWarnControlmeasure dd = new TCmWarnControlmeasure();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				
				String op = updateResultBean.getParameter("op");
				if("new".equals(op) || "copynew".equals(op)) {
					dd = new TCmWarnControlmeasure();
					oc.setAttribute(TCmWarnControlmeasureOperation.CMD,TCmWarnControlmeasureOperation.CMD_INSERT);
				} else if ("mod".equals(op)) {
					dd = TCmWarnControlmeasureService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TCmWarnControlmeasureOperation.CMD,TCmWarnControlmeasureOperation.CMD_UPDATE);
				}
				mapToObject(dd, map);
			}
			oc.setAttribute(TCmWarnControlmeasureOperation.IN_PARAM, dd);
			OPCaller.call(TCmWarnControlmeasureOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
