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
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPlRuleEliminateTaskUpdate extends BaseUpdate {
	
	private static final String DATASET_ID ="RuleEliminateTask";
	private static final String DATASET_ID2 ="TriggerWarningRule";
	
	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			UpdateResultBean updateResultBean2 = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID2);
			
			TEdwPlsAccount acct=new TEdwPlsAccount();
			OperationContext oc = new OperationContext();
			String op = updateResultBean.getParameter("op");
			String taskAssignee=updateResultBean.getParameter("taskAssignee");
			if(null==op){
				op="";
			}
			if(StringUtils.isEmpty(taskAssignee)){
				taskAssignee="";
			}
			oc.setAttribute("op", op);
			oc.setAttribute("taskAssignee",taskAssignee);
			String eliminateRuleDesc="";
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			if (updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				String opinion="";
				if(map.get("opinion")!=null && !map.get("opinion").toString().equals("")){
					opinion=map.get("opinion").toString();
				}
				oc.setAttribute("opinion",opinion);
				if(map.get("eliminateRuleDesc")!=null && !map.get("eliminateRuleDesc").toString().equals("")){
					eliminateRuleDesc=map.get("eliminateRuleDesc").toString();
				}
				mapToObject(acct, map);
				if(map.get("loanacno")!=null && StringUtils.isNotEmpty(map.get("loanacno").toString())){
					StringBuffer hql = new StringBuffer("from TEdwPlsAccount t where loanacno='"+map.get("loanacno").toString()+"' ");
					List list=rootdao.queryByCondition(hql.toString());
					acct=(TEdwPlsAccount) list.get(0);
				}
			}
			oc.setAttribute(TPlRuleEliminateOperation.TPL_TRIGGER_RULE_ACCT,acct);
			
			List<String> ruleIdList=new ArrayList<String>();
			while(updateResultBean2.hasNext()){
				Map map=updateResultBean2.next();
				ruleIdList.add(map.get("ruleCode").toString());
			}
			oc.setAttribute(TPlRuleEliminateOperation.RULE_ID_LIST,ruleIdList);
			
			TPlRuleEliminate ruleEliminate=new TPlRuleEliminate();
			ruleEliminate.setEliminateRuleDesc(eliminateRuleDesc);
			oc.setAttribute(TPlRuleEliminateOperation.RULE_ELIMINATE,ruleEliminate);
			oc.setAttribute("updateClassName",TPlRuleEliminateTaskUpdate.class.getName());
			OPCaller.call(TPlRuleEliminateOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}