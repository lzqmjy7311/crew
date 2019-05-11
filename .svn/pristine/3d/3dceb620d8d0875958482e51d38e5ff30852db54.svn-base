package com.gbicc.person.monitor.operation;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.monitor.entity.TPlDqReportJy;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlTask;
import com.gbicc.person.monitor.entity.TPlYjReport;
import com.gbicc.person.monitor.service.TPlDqReportJyService;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.gbicc.person.monitor.service.TPlYjReportService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * 
 * @author xudongdong
 *
 * 版本：2015年11月12日 下午1:55:49
 * 类说明：预警处置流程 结束监控器
 */
public class WarningMonitorProcessEndOperation extends BaseOperation {
	public static final String ID = "WarningMonitorProcessEndOperation";
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
		String frequency="";
		//更改业务状态
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Date completeDate=new Date();
		rootdao.executeSql("UPDATE ECUSER.T_PL_TASK SET RPT_STATUS='"+HANDLE_COMPLETE_STATUS+"' , COMPLETE_DATE=current date  WHERE FD_ID='"+businessId+"' ");
		
		TPlTask task=TPlTaskService.getInstance().get(businessId);
		List<TPlReportRelation> list=rootdao.queryByCondition(" from TPlReportRelation where businessId='"+businessId+"'");
		
		if(list.get(0).getReportType().equals("Yj")){
			TPlYjReport report=TPlYjReportService.getInstance().get(list.get(0).getReportId());
			frequency=report.getFrequency();
		}
		if(StringUtils.isNotEmpty(frequency)){
			rootdao.executeSql("UPDATE T_PL_TASK_ROUTINE_MONI SET FD_TRIG_RATE_ADJUST="+frequency+" WHERE FD_ACC_ID='"+task.getLoanAcct()+"' ");
		}
	}
}
