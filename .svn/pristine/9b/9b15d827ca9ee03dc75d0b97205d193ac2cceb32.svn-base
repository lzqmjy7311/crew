package com.gbicc.company.single.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.company.single.operation.TCmSingleRulWarningOperation;
import com.gbicc.company.single.service.TCmSingleRulCasesService;
import com.gbicc.company.single.service.TCmSingleRulWarningService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCmSingleRulBatchJoinCasesUpdate extends BaseUpdate {
	
	private static final String DATASET_ID ="SingleRulBatchCasesSelect";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			String warningIds = updateResultBean.getParameter("warningIds");
			String casesId = updateResultBean.getParameter("casesId");
			String op = updateResultBean.getParameter("op");
			if(null==op){
				op="";
			}
			OperationContext oc = new OperationContext();
			oc.setAttribute("op",op);
			oc.setAttribute("opinion","");
			oc.setAttribute("cases",TCmSingleRulCasesService.getInstance().get(casesId));
			String[] warningIDs=warningIds.split(",");
			if(warningIDs!=null){
				for(int i=0;i<warningIDs.length;i++){
					System.out.println("warningID:"+warningIDs[i]);
					oc.setAttribute(TCmSingleRulWarningOperation.IN_PARAM,TCmSingleRulWarningService.getInstance().get(warningIDs[i]));
					OPCaller.call(TCmSingleRulWarningOperation.ID, oc);
				}
			}
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
