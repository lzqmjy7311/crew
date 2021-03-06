package com.gbicc.person.monitor.operation;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.monitor.entity.TPlDqReportAj;
import com.gbicc.person.monitor.entity.TPlDqReportJy;
import com.gbicc.person.monitor.entity.TPlDqReportXf;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlTask;
import com.gbicc.person.monitor.service.TPlDqReportAjService;
import com.gbicc.person.monitor.service.TPlDqReportJyService;
import com.gbicc.person.monitor.service.TPlDqReportXfService;
import com.gbicc.person.monitor.service.TPlTaskService;
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
public class MonitorProcessEndOperation extends BaseOperation {
	public static final String ID = "MonitorProcessEndOperation";
	public static final String HANDLE_COMPLETE_STATUS="7";//处理完成状态
	public static final String OPINION="OPINION";//意见
	public static final String BUSINESSID="BUSINESSID";//业务主键
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {
		String businessId = (String) context.getAttribute(BUSINESSID);
		//更改业务状态
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		rootdao.executeSql("UPDATE T_PL_TASK SET RPT_STATUS='"+HANDLE_COMPLETE_STATUS+"' WHERE FD_ID='"+businessId+"' ");
		//更改监控频率
		TPlTask task=TPlTaskService.getInstance().get(businessId);
		List<TPlReportRelation> list=rootdao.queryByCondition(" from TPlReportRelation where businessId='"+businessId+"'");
		if(list != null && list.size()>0){
			String frequency="";
			if(list.get(0).getReportType().equals("AJ")){
				TPlDqReportAj report=TPlDqReportAjService.getInstance().get(list.get(0).getReportId());
				frequency=report.getFrequency();
			}else if(list.get(0).getReportType().equals("XF")){
				TPlDqReportXf report=TPlDqReportXfService.getInstance().get(list.get(0).getReportId());
				frequency=report.getFrequency();
			}else if(list.get(0).getReportType().equals("JY")){
				TPlDqReportJy report=TPlDqReportJyService.getInstance().get(list.get(0).getReportId());
				frequency=report.getFrequency();
			}
			if(StringUtils.isNotEmpty(frequency)){
				rootdao.executeSql("UPDATE T_PL_TASK_ROUTINE_MONI SET FD_TRIG_RATE_ADJUST="+frequency+" WHERE FD_ACC_ID='"+task.getLoanAcct()+"' ");
			}
		}
	}
}
