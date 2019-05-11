package com.gbicc.rule.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.rule.operation.TPubRulIndustryValueDelOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPubRulIndustryValueDelUpdate extends BaseUpdate {
	
	private static final String DATASET_ID = "TPubRulIndustryValue";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			OperationContext oc = new OperationContext();
			String rulCode = updateResultBean.getParameter("rulCode");
			String industryCode = updateResultBean.getParameter("industryCode");
			if(StringUtils.isEmpty(rulCode)){
				rulCode="";
			}
			if(StringUtils.isEmpty(industryCode)){
				industryCode="";
			}
			oc.setAttribute("rulCode",rulCode);
			oc.setAttribute("industryCode",industryCode);
			OPCaller.call(TPubRulIndustryValueDelOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
