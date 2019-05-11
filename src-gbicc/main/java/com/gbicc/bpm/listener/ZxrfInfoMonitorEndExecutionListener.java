package com.gbicc.bpm.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.springframework.util.StringUtils;

import com.gbicc.person.monitor.operation.TPlZxrfInfoMonitorProcessEndOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;

public class ZxrfInfoMonitorEndExecutionListener implements ExecutionListener{

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
			 oc.setAttribute(TPlZxrfInfoMonitorProcessEndOperation.BUSINESSID,process.getProcessBusinessKey());
			 OPCaller.call(TPlZxrfInfoMonitorProcessEndOperation.ID, oc);
		}
	}
}
