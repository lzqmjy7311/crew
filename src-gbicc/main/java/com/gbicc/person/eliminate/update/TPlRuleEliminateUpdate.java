package com.gbicc.person.eliminate.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.eliminate.entity.TPlRuleEliminate;
import com.gbicc.person.eliminate.operation.TPlRuleEliminateOperation;
import com.gbicc.personCommon.entity.TEdwPlsAccount;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPlRuleEliminateUpdate extends BaseUpdate {
	
	private static final String DATASET_ID ="TriggerRuleAcct";
	private static final String DATASET_ID2 ="TriggerWarningRule";
	private static final String DATASET_ID3 ="RuleEliminate";
	
	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			UpdateResultBean updateResultBean2 = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID2);
			UpdateResultBean updateResultBean3 = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID3);
			
			TEdwPlsAccount acct=new TEdwPlsAccount();
			OperationContext oc = new OperationContext();
			String op = updateResultBean.getParameter("op");
			String taskAssignee = updateResultBean.getParameter("taskAssignee");
			String flag=updateResultBean3.getParameter("flag");
			if(null==op){
				op="";
			}
			if(StringUtils.isEmpty(taskAssignee)){
				taskAssignee="";
			}
			oc.setAttribute("op", op);
			oc.setAttribute("taskAssignee", taskAssignee);
			if (updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				String opinion="";
				oc.setAttribute("opinion",opinion);
				mapToObject(acct, map);
			}
			oc.setAttribute(TPlRuleEliminateOperation.TPL_TRIGGER_RULE_ACCT,acct);
			
			List<String> ruleIdList=new ArrayList<String>();
			while(updateResultBean2.hasNext()){
				Map map=updateResultBean2.next();
				ruleIdList.add(map.get("ruleCode").toString());
			}
			oc.setAttribute(TPlRuleEliminateOperation.RULE_ID_LIST,ruleIdList);
			
			TPlRuleEliminate ruleEliminate=new TPlRuleEliminate();
			if(updateResultBean3.hasNext()){
				Map map=updateResultBean3.next();
				mapToObject(ruleEliminate,map);
			}
			if(null!=flag){
				ruleEliminate.setId(null);
			}
			oc.setAttribute(TPlRuleEliminateOperation.RULE_ELIMINATE,ruleEliminate);
			oc.setAttribute("updateClassName",TPlRuleEliminateUpdate.class.getName());
			OPCaller.call(TPlRuleEliminateOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}