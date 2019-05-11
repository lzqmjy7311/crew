package com.gbicc.bpm.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.operation.AccountDutyDistributeProcessEndOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;

public class AccountDutyDistributeEndExecutionListener implements ExecutionListener{

	private static final long serialVersionUID = 3220959718228595645L;

	@Override
	public void notify(DelegateExecution process) throws Exception {
		if(process instanceof ExecutionEntity){
			ExecutionEntity p=(ExecutionEntity)process;
			if(StringUtils.isNotBlank(p.getDeleteReason())){
				return;
			}
		}
		if(ExecutionListener.EVENTNAME_END.equals(process.getEventName())){
			 OperationContext oc = new OperationContext();
			 Object businKey=process.getProcessBusinessKey();
			 Object status=process.getVariable("businStatus");
			 if(status!=null && businKey!=null && StringUtils.isNotEmpty(status.toString()) && StringUtils.isNotEmpty(businKey.toString())){
				 oc.setAttribute("businStatus",status);
				 oc.setAttribute("businessid",businKey);
				 OPCaller.call(AccountDutyDistributeProcessEndOperation.ID, oc);
			 }
		}
	}
}
