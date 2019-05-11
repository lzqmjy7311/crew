package com.gbicc.company.single.update;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.company.single.entity.TCmSingleRulWarning;
import com.gbicc.company.single.operation.TCmSingleRulWarningOperation;
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

public class TCmSingleRulWarningBatchUpdate extends BaseUpdate {
	private static final String DATASET_ID ="SingleRulWarningElimDesc";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCmSingleRulWarning dd = new TCmSingleRulWarning();
			String warningIds = updateResultBean.getParameter("warningIds");
			String eliminateDesc = updateResultBean.getParameter("eliminateDesc");
			String opinion = updateResultBean.getParameter("opinion");
			String op = updateResultBean.getParameter("op");
			String userId = updateResultBean.getParameter("taskAssignee");
			if(null==op){
				op="";
			}
			if(null==userId){
				userId="";
			}
			OperationContext oc = new OperationContext();
			oc.setAttribute("op",op);
			oc.setAttribute("userId", userId);
			if(StringUtils.isNotBlank(eliminateDesc)){
				oc.setAttribute("eliminateDesc",eliminateDesc);
			}
			if(StringUtils.isNotBlank(opinion)){
				oc.setAttribute("opinion", opinion);
			}
			String[] warningIDs=warningIds.split(",");
			if(warningIDs!=null){
				for(int i=0;i<warningIDs.length;i++){
					dd=TCmSingleRulWarningService.getInstance().get(warningIDs[i]);
					if(eliminateDesc!=null){
						dd.setEliminateDesc(eliminateDesc);
					}
					oc.setAttribute(TCmSingleRulWarningOperation.IN_PARAM,dd);
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