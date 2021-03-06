package com.gbicc.bpm.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.springframework.util.StringUtils;

import com.gbicc.company.warnDisposal.operation.TCmWarnDisPosalProcessEndOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;

public class TCmWarnDisposalEndExecutionListener implements ExecutionListener{
	private static final long serialVersionUID = -8135309656103338912L;

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
			 oc.setAttribute(TCmWarnDisPosalProcessEndOperation.BUSINESSID,process.getProcessBusinessKey());
			 OPCaller.call(TCmWarnDisPosalProcessEndOperation.ID, oc);
		}
	}
}
