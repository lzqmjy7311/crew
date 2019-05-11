package com.gbicc.company.single.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.company.single.entity.TCmSingleRulWarning;
import com.gbicc.company.single.service.TCmSingleRulWarningService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TCmSingleRulRemoveWarningOperation extends BaseOperation {

	public static final String ID = TCmSingleRulRemoveWarningOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	public static final String SINGLE_RULE_WARN_PROCESS="single_rule_warn_process";//单规则预警流程关键字
	public static final String SINGLE_RULE_WARN_PROCESS_BRANCH="single_rule_warn_process_branch";//单规则预警流程(分支行)关键字
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {
		List<String> list=(List<String>) context.getAttribute("list");
		TCmSingleRulWarningService warnService=TCmSingleRulWarningService.getInstance();
		for(String str:list){
			TCmSingleRulWarning warning=warnService.get(str);
			warning.setCasesId(null);
			warning.setWarningRelieve(null);
			warning.setWarnStatus(TCmSingleRulWarningOperation.WAIT_HANDLE_STATUS);
			startWarningProcess(warning);
			warnService.update(warning);
		}
	}
	
	public void startWarningProcess(TCmSingleRulWarning warning){
		String procKey=FileUpDownProperties.readValue(SINGLE_RULE_WARN_PROCESS_BRANCH);
		if(warning.getHandleOrgFlag().equals(TCmSingleRulWarningOperation.HEAD_FLAG)){
			procKey=FileUpDownProperties.readValue(SINGLE_RULE_WARN_PROCESS);
		}
		ProcessManagerService pms=ProcessManagerService.getInstace();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("assignee",warning.getHandler());
		map.put("desc","业务ID:"+warning.getId()+",预警编号:"+warning.getWarnCode()+",规则编号:"+warning.getRulCode());
		pms.startProcess(warning.getId(),procKey,warning.getHandler(),map);
	}
}
