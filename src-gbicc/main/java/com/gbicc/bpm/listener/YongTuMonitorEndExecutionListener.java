package com.gbicc.bpm.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.springframework.util.StringUtils;

import com.gbicc.person.monitor.operation.MonitorProcessEndOperation;
import com.gbicc.person.monitor.operation.TPlYtReportOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;

public class YongTuMonitorEndExecutionListener implements ExecutionListener{

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
			 oc.setAttribute(MonitorProcessEndOperation.BUSINESSID,process.getProcessBusinessKey());
			 OPCaller.call(MonitorProcessEndOperation.ID, oc);
			 
			 OperationContext oc2 = new OperationContext();
			 oc2.setAttribute(TPlYtReportOperation.BUSINESS_ID,process.getProcessBusinessKey());
			 oc2.setAttribute(TPlYtReportOperation.CMD,TPlYtReportOperation.CMD_UPDATE_STATUS);
			 OPCaller.call(TPlYtReportOperation.ID, oc2);
		}
	}
}
