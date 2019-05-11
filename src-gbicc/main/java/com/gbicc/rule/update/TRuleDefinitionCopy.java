package com.gbicc.rule.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.rule.entity.TRulDefinition;
import com.gbicc.rule.operation.TRulDefinitionOperation;
import com.gbicc.rule.service.TRulDefinitionService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TRuleDefinitionCopy extends BaseUpdate {
	private static final String DATASET_ID =TRulDefinition.class.getSimpleName();
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TRulDefinition dd = new TRulDefinition();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				
				String op = updateResultBean.getParameter("op");
				if("new".equals(op) || "copynew".equals(op)) {
					dd = new TRulDefinition();
					oc.setAttribute(TRulDefinitionOperation.CMD, TRulDefinitionOperation.CMD_INSERT);
				} else if ("mod".equals(op)) {
					dd = TRulDefinitionService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TRulDefinitionOperation.CMD, TRulDefinitionOperation.CMD_UPDATE);
				}
				mapToObject(dd, map);
			}
			oc.setAttribute(TRulDefinitionOperation.IN_PARAM, dd);
			OPCaller.call(TRulDefinitionOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
