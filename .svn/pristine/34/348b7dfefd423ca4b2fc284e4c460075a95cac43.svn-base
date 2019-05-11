package com.gbicc.person.frequency.opration;

import org.apache.commons.lang.StringUtils;

import com.gbicc.person.frequency.entity.TPlTriggerFrequencyAcct;
import com.gbicc.person.frequency.service.TPlTriggerFrequencyAcctService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * 
 * @author xudongdong
 *
 * 版本：2015年11月17日 上午9:21:00
 * 类说明：监控频率调整 操作类
 */
public class TriggerFrequencyProcessEndOperation extends BaseOperation {
	public static final String ID = "TriggerFrequencyProcessEndOperation";
	public static final String HANDLE_COMPLETE_STATUS="2";//审核通过
	public static final String OPINION="OPINION";//意见
	public static final String BUSINESSID="BUSINESSID";//业务主键
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String businessId = (String) context.getAttribute(BUSINESSID);
		TPlTriggerFrequencyAcctService service=TPlTriggerFrequencyAcctService.getInstance();
		String id =service.getByAcc(businessId);
//		String id=tPlTriggerFrequencyAcct1.getId();
		TPlTriggerFrequencyAcct tPlTriggerFrequencyAcct =service.get(id);
		tPlTriggerFrequencyAcct.setStatus(HANDLE_COMPLETE_STATUS);
		String frequency=tPlTriggerFrequencyAcct.getFrequency();
		//更改业务状态
		service.update(tPlTriggerFrequencyAcct);
		//rootdao.executeSql("UPDATE T_PL_TRIGGER_FREQUENCY_ACCT T SET T.FD_STATUS='"+HANDLE_COMPLETE_STATUS+"'  WHERE T.FD_ID='"+tPlTriggerFrequencyAcct.getId()+"' ");
		if(!StringUtils.isEmpty(frequency)){
			//执行 update
			rootdao.executeSql("UPDATE T_PL_TASK_ROUTINE_MONI T SET T.FD_TRIG_RATE_ADJUST="+tPlTriggerFrequencyAcct.getFrequency()+" WHERE T.FD_ACC_ID='"+businessId+"' ");
			
		}
		
			}
}
