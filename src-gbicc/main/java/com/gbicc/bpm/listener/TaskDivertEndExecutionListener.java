package com.gbicc.bpm.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import com.gbicc.person.eliminate.operation.EliminateProcessEndOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;

public class TaskDivertEndExecutionListener implements ExecutionListener{

	private static final long serialVersionUID = 3220959718228595645L;

	@Override
	public void notify(DelegateExecution process) throws Exception {
		if(ExecutionListener.EVENTNAME_END.equals(process.getEventName())){
			 OperationContext oc = new OperationContext();
			 oc.setAttribute(EliminateProcessEndOperation.BUSINESSID,process.getProcessBusinessKey());
			 //OPCaller.call(EliminateProcessEndOperation.ID, oc);
		}
	}
}
