package com.gbicc.person.eliminate.operation;

import java.util.Date;
import java.util.Iterator;

import com.gbicc.common.CommonService;
import com.gbicc.person.eliminate.entity.TPlRuleEliminate;
import com.gbicc.person.eliminate.entity.TPlRuleEliminateDtl;
import com.gbicc.person.eliminate.service.TPlRuleEliminateDtlService;
import com.gbicc.person.eliminate.service.TPlRuleEliminateService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * @author likm
 * @time   2015年11月17日16:32:49
 * @desc   规则排除/恢复流程结束操作类
 */
public class EliminateProcessEndOperation extends BaseOperation {
	public static final String ID = "EliminateProcessEndOperation";
	public static final String HANDLE_COMPLETE_STATUS="5";//处理完成状态
	public static final String OPINION="OPINION";//意见
	public static final String BUSINESSID="BUSINESSID";//业务主键
	public static final String FLAG="1";//生效标识
	public static final String TEMP_FLAG="2";//临时标识
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String businessId = (String) context.getAttribute(BUSINESSID);
		TPlRuleEliminate re=TPlRuleEliminateService.getInstance().get(businessId);
		re.setStatus(HANDLE_COMPLETE_STATUS);
		re.setEliminateRuleDesc(null);
		re.setDate(new Date());
		re.setFlag(FLAG);
		TPlRuleEliminateService.getInstance().update(re);
		
		//删除该账户以前排除且生效的记录
		CommonService service=CommonService.getInstance();
		service.executeSQL("update T_PL_RULE_ELIMINATE set fd_flag='"+TEMP_FLAG+"' where FD_TRIGGER_RULE_ACCT='"+re.getTriggerRuleAcct().getLoanacno()+"' and fd_flag='"+FLAG+"'");
		service.executeSQL("update T_PL_RULE_ELIMINATE_DTL set fd_flag='"+TEMP_FLAG+"' where FD_RULE_ELIM_ID in (select fd_id from T_PL_RULE_ELIMINATE where fd_trigger_rule_acct='"+re.getTriggerRuleAcct().getLoanacno()+"' and fd_flag='"+TEMP_FLAG+"') and fd_flag='"+FLAG+"'");
		
		//将排除记录表中的记录更改为生效
		try {
			Iterator<TPlRuleEliminateDtl> it=TPlRuleEliminateDtlService.getInstance().findEliminateDtlByEliminateId(re.getId(),TEMP_FLAG);
			while(it.hasNext()){
				TPlRuleEliminateDtl dtl=it.next();
				dtl.setFlag(FLAG);
				TPlRuleEliminateDtlService.getInstance().update(dtl);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
