package com.gbicc.rule.operation;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.common.CommonService;
import com.gbicc.rule.servlet.RuleExecuteLog;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TRulExecuteLogOperation extends BaseOperation{
	public static final String ID = TRulExecuteLogOperation.class.getSimpleName();
	public static final String CMD="CMD";
	public static final String CMD_INT="CMD_INT";
	public static final String CMD_UPT="CMD_UPT";
	public static final String IN_PARAM="IN_PARAM";
	
	
	
	@Override
	public void afterProc(OperationContext arg0) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext arg0) throws CommonException {
	}

	@Override
	public void execute(OperationContext arg0) throws CommonException {
		JdbcTemplate jdbcTemplate= CommonService.getInstance().getJdbcTempldate();
		String cmd=(String)arg0.getAttribute(CMD);
		if(cmd.equals(CMD_INT)){
			RuleExecuteLog executeLog=(RuleExecuteLog) arg0.getAttribute(IN_PARAM);
			jdbcTemplate.update("INSERT INTO T_PUB_RUL_EXECUTE_LOG"
				+ "(RULE_ID,RULE_CODE,START_TIME,IS_SUCCESS,ROW_DATE,EXEC_ID) VALUES(?,?,?,?,?,?)", 
				executeLog.getRuleId(),executeLog.getRuleCode(),executeLog.getStartTime(),
				executeLog.getSuccess(),executeLog.getRowDate(),executeLog.getExecId());
		}else if(cmd.equals(CMD_UPT)){
			RuleExecuteLog executeLog=(RuleExecuteLog) arg0.getAttribute(IN_PARAM);
			jdbcTemplate.update("UPDATE  T_PUB_RUL_EXECUTE_LOG "
				+ "SET END_TIME=? ,IS_SUCCESS=?,EXEC_TIME=?,ERROR_MSG=? WHERE EXEC_ID=?", 
				executeLog.getEndTime(),executeLog.getSuccess(),executeLog.getExecTime()
				,executeLog.getErrorMsg(),executeLog.getExecId());
		}
	}

}
