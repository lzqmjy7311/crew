package com.gbicc.person.monitor.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.common.filemng.FileUploadSevice;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlYtMonitor;
import com.gbicc.person.monitor.entity.TPlYtReport;
import com.gbicc.person.monitor.operation.GenerateDqMonitorTaskOperation;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.DataDicService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 用途监控服务类
 * 
 * @date 2015年11月10日
 * @author tangdu
 * @desc
 */
public class TPlYtReportService {
	protected TPlYtReportService() {
	}

	public synchronized static TPlYtReportService getInstance() {
		return (TPlYtReportService) ApplicationContextUtils
				.getBean(TPlYtReportService.class.getSimpleName());
	}

	public ROOTDAO dao() {
		return ROOTDAOUtils.getROOTDAO();
	}

	public TPlYtReport get(String id) throws CommonException {
		return dao().query(TPlYtReport.class, id);
	}

	public void save(TPlYtReport tplytreport) throws CommonException {
		dao().save(tplytreport);
	}

	public void update(TPlYtReport tplytreport) throws CommonException {
		dao().update(tplytreport);
	}

	public void delete(String id) throws CommonException {
		dao().delete(id);
	}
	
	public void clean(String businessId) throws CommonException{
		//查出reportId
		TPlReportRelation relation=(TPlReportRelation) dao()
				.queryOneHQL("from TPlReportRelation where businessId='"+businessId+"'");
		String reportId=relation.getReportId();
		//删除业务主表
		//dao().executeSql("DELETE FROM T_PL_REPORT_RELATION T WHERE T.BUSINESS_ID='"+businessId+"'");
		//控制措施
		dao().executeHQL("delete from TPlControlmeasure where taskId='"+businessId+"' ");
		dao().executeSql("DELETE FROM T_PL_YT_MONITOR T WHERE T.FD_ID='"+businessId+"'");
		dao().executeSql("DELETE FROM T_PL_YT_REPORT T WHERE T.FD_ID='"+reportId+"'");
		//删除附件信息
		FileUploadSevice.getInstance().deleteByRelaID(businessId);
	}

	public void startProcess(TPlYtMonitor monitor,TPlYtReport plYtReport)
			throws CommonException {
		Date d = new Date();
		monitor.setReportUrl("/gbicc-pages/yongtuminitor/ftl/yt_monitor_report.ftl");
		monitor.setTaskMatureDate(new Date(d.getTime() + 15 * 24 * 60 * 60* 1000));
		dao().save(monitor);
		plYtReport.setId(null);
		dao().save(plYtReport);
		monitor.setReportId(plYtReport.getId());
		
		TPlReportRelation relation=new TPlReportRelation();
		relation.setBusinessId(monitor.getId());
		relation.setReportId(plYtReport.getId());
		relation.setReportType("YT");
		dao().save(relation);
		
		String userId="";
		Map<String, Object> variables = new HashMap<String, Object>();
		if(monitor.getHandler()==null){
			Integer dicType=Integer.parseInt(FileUpDownProperties.readValue(GenerateDqMonitorTaskOperation.TASK_DISTRIBUTE_MNG_TYPE));
			String dicNo=FileUpDownProperties.readValue(GenerateDqMonitorTaskOperation.TASK_DISTRIBUTE_MNG_CODE);
			String dicName=DataDicService.getInstance().getNameByTypeNo(dicType,dicNo);
			TlrInfo tlr=TlrInfoService.getInstance().getTlrInfoByTlrno(dicName);
			variables.put("assignee",tlr.getTlrno());
			userId=tlr.getTlrno();
		}else{
			variables.put("assignee",monitor.getHandler().getTlrno());
			userId=monitor.getHandler().getTlrno();
		}
		variables.put("desc", "业务ID:"+monitor.getId()+","
				+ "贷款账号:"+plYtReport.getLoanNo()
				+ ",借据编号:"+plYtReport.getLendCode()
				+ ",客户名称:"+plYtReport.getCustName());
		ProcessManagerService.getInstace().startProcess(monitor.getId(),
				"PL_YongTuMonitor", userId, variables);
	}
	
}
