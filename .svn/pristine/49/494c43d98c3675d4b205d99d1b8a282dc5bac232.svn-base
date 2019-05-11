package com.gbicc.company.single.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.company.single.entity.TCmSingleRulCases;
import com.gbicc.company.single.operation.TCmSingleRulCasesOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCmSingleRulCasesUpdate extends BaseUpdate {
	private static final String DATASET_ID ="SingleRulCases";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			String op = updateResultBean.getParameter("op");
			String warnRecords=updateResultBean.getParameter("warnRecords");
			String userId=updateResultBean.getParameter("userId");
			if(null==op){
				op="";
			}
			if(null==userId){
				userId="";
			}
			if(StringUtils.isEmpty(warnRecords)){
				warnRecords="";
			}
			TCmSingleRulCases cases = new TCmSingleRulCases();
			OperationContext oc = new OperationContext();
			String opinion="";
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				map.remove("createOrg");
				map.remove("createUser");
				if(map.get("opinion")!=null){
					opinion=map.get("opinion").toString();
				}
				mapToObject(cases,map);
				cases.setCreateOrg(BctlService.getInstance().getBctlByBrcode(map.get("createOrgId").toString()));
				cases.setCreateUser(TlrInfoService.getInstance().getTlrInfoByTlrno(map.get("createUserId").toString()));
			}
			oc.setAttribute("cases",cases);
			oc.setAttribute("op",op);
			oc.setAttribute("opinion",opinion);
			oc.setAttribute("userId", userId);
			oc.setAttribute("warnRecords",warnRecords);
			OPCaller.call(TCmSingleRulCasesOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
