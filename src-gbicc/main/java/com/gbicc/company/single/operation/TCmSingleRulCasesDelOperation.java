package com.gbicc.company.single.operation;

import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.CommonService;
import com.gbicc.company.single.entity.TCmSingleRulCases;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TCmSingleRulCasesDelOperation extends BaseOperation {

	public static final String ID = TCmSingleRulCasesDelOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		TCmSingleRulCases cases = (TCmSingleRulCases) context.getAttribute("cases");
		CommonService service=CommonService.getInstance();
		ProcessManagerService processService=ProcessManagerService.getInstace();
		try {
			GlobalInfo info=GlobalInfo.getCurrentInstance();
			String userId=info.getTlrno();
			//删除ACT流程数据
			String taskId=processService.findTaskId(cases.getId(),userId);
			if(StringUtils.isNotEmpty(taskId)){
				Task t=processService.getTaskService().createTaskQuery().taskId(taskId).singleResult();
				processService.deleteProcessInstanceAll(t.getProcessInstanceId());
			}
			//删除案例
			service.delete(cases);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}