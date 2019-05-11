package com.gbicc.company.single.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.company.single.entity.TCmSingleRulWarning;
import com.gbicc.company.single.operation.TCmSingleRulWarningOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCmSingleRulWarningUpdate extends BaseUpdate {
	private static final String DATASET_ID ="SingleRulWarning";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCmSingleRulWarning dd = new TCmSingleRulWarning();
			OperationContext oc = new OperationContext();
			String op = updateResultBean.getParameter("op");
			String userId = updateResultBean.getParameter("userId");
			if(null==op){
				op="";
			}
			if(null==userId){
				userId="";
			}
			String opinion="";
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String mainOrgId="";
				if(map.get("mainOrgId")!=null){
					mainOrgId=(String) map.get("mainOrgId");
				}
				map.remove("mainOrg");
				dd.setMainOrg(BctlService.getInstance().getBctlByBrcode(mainOrgId));
				if(map.get("opinion")!=null){
					opinion=map.get("opinion").toString();
				}
				mapToObject(dd,map);
			}
			oc.setAttribute("op",op);
			oc.setAttribute("opinion",opinion);
			oc.setAttribute("userId", userId);
			oc.setAttribute(TCmSingleRulWarningOperation.IN_PARAM,dd);
			OPCaller.call(TCmSingleRulWarningOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
