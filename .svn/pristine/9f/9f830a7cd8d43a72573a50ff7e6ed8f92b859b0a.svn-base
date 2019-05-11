package com.gbicc.person.monitor.operation;

import org.apache.commons.lang3.StringUtils;

import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * @author likm
 * @time   2015年11月11日17:25:46
 * @desc   定期监控流程结束操作类
 */
public class TPlZxrfInfoMonitorProcessEndOperation extends BaseOperation {
	public static final String ID = "TPlZxrfInfoMonitorProcessEndOperation";
	public static final String HANDLE_COMPLETE_STATUS="7";//处理完成状态
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
		String businessId = (String) context.getAttribute(BUSINESSID);
		if(StringUtils.isNotBlank(businessId)){
			//更改业务状态
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			rootdao.executeSql("UPDATE ECUSER.T_PL_TASK SET RPT_STATUS='"+HANDLE_COMPLETE_STATUS+"' WHERE FD_ID='"+businessId+"' ");
		}
	}
}
