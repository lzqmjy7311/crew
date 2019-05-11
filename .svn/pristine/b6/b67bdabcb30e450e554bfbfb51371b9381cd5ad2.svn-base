package com.gbicc.company.single.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.company.single.entity.TCmSingleRulCases;
import com.gbicc.company.single.operation.TCmSingleRulCasesDelOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCmSingleRulDelCasesUpdate extends BaseUpdate {
	private static final String DATASET_ID ="SingleRulCases";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCmSingleRulCases cases = new TCmSingleRulCases();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				map.remove("createOrg");
				map.remove("createUser");
				mapToObject(cases,map);
			}
			oc.setAttribute("cases",cases);
			OPCaller.call(TCmSingleRulCasesDelOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
