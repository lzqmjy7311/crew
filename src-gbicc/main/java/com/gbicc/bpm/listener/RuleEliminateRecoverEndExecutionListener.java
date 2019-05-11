package com.gbicc.bpm.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.springframework.util.StringUtils;

import com.gbicc.person.eliminate.operation.EliminateProcessEndOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;

public class RuleEliminateRecoverEndExecutionListener implements ExecutionListener{

	private static final long serialVersionUID = 3220959718228595645L;

	@Override
	public void notify(DelegateExecution process) throws Exception {
		if(process instanceof ExecutionEntity){
			ExecutionEntity p=(ExecutionEntity)process;
			if(StringUtils.hasText(p.getDeleteReason())){
				return;
			}
		}
		if(ExecutionListener.EVENTNAME_END.equals(process.getEventName())){
			 OperationContext oc = new OperationContext();
			 oc.setAttribute(EliminateProcessEndOperation.BUSINESSID,process.getProcessBusinessKey());
			 OPCaller.call(EliminateProcessEndOperation.ID, oc);
		}
	}
}
