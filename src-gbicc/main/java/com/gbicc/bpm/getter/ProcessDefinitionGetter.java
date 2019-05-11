package com.gbicc.bpm.getter;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.pojo.ExtProcessDefinition;
import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.CommonService;
import com.gbicc.person.monitor.operation.TPlYtReportOperation;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.ibm.disthub2.impl.formats.ReleaseTable.Entry;

public class ProcessDefinitionGetter extends BaseGetter {
	
	@Override
	public Result call() throws AppException {
		 Map<String, Object> object=ProcessManagerService.getInstace().processDefinition(0, 10);
		 PageQueryResult pageQueryResult = new PageQueryResult();
		 pageQueryResult.setQueryResult((List<ExtProcessDefinition>) object.get("data"));
		 pageQueryResult.setTotalCount(((Long) object.get("count")).intValue());
		 
		 ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
		 result.setParameter("user", "唐杜");
		 result.setContent(pageQueryResult.getQueryResult());
		 result.getPage().setTotalPage(1);
		 result.init();
		 
		 OperationContext oc = new OperationContext();
		 oc.setAttribute(TPlYtReportOperation.CMD,TPlYtReportOperation.CMD_STARTPROCESS);
		 //OPCaller.call(TPlYtReportOperation.ID, oc);
		 
		 //部署流程
//		 ProcessManagerService pms=ProcessManagerService.getInstace();
//		 try {
//			 pms.deploy("D:\\likm\\soft\\srcb_process\\RegularMonitor.zip");
//		 } catch (IOException e) {
//			 e.printStackTrace();
//		 }
		 
		 //启动流程
//		 MonitorReportAJ ajReport=new MonitorReportAJ();
//		 ajReport.setId(null);
//		 ajReport.setCertType("FBI");
//		 ajReport.setCertCode("110001");
//		 ajReport.setCoopObj("0000000");
//		 ajReport.setCoopObjName("阿里巴巴与四十大盗");
//		 ajReport.setIssueDate(new Date());
//		 ajReport.setCompleteDate(new Date());
//		 ajReport.setIssueAmt(10000000.00);
//		 ajReport.setLendCode("J20010215");
//		 ajReport.setGuarWay("信用担保");
//		 ajReport.setGageCode("D3215258");
//		 ajReport.setArrearAmt(2000000.00);
//		 ajReport.setRiskStatus("正常");
//		 ajReport.setAcctStatus("冻结");
//		 ajReport.setCheckPerCode("C85465255");
//		 OperationContext oc1 = new OperationContext();
//		 oc1.setAttribute(MonitorReportAJOperation.CMD,MonitorReportAJOperation.CMD_INSERT);
//		 oc1.setAttribute(MonitorReportAJOperation.IN_PARAM,ajReport);
//		 OPCaller.call(MonitorReportAJOperation.ID,oc1);
//		 
//		 MonitorReport report=new MonitorReport();
//		 report.setId(null);
//		 report.setAjReport(ajReport);
//		 report.setRptType(RegularCommon.MONITOR_RPT_TYPE_AJ);
//		 report.setLoanVariety("幸福易贷");
//		 report.setCustName("李昆明");
//		 report.setCustCode("110");
//		 report.setLoanAmt(10000000.00);
//		 report.setLoanBalance(0.00);
//		 report.setRptStatus("1");
//		 report.setWarnLevel("5级");
//		 report.setLoanAcct("622202020011144");
//		 report.setLoanTerm("36个月");
//		 TlrInfoService tlrService=TlrInfoService.getInstance();
//		 report.setHandler(tlrService.getTlrInfoByTlrno("00000001"));
//		 Date d=new Date();
//		 report.setTaskMatureDate(new Date(d.getTime()+15*24*60*60*1000));
//		 OperationContext oc = new OperationContext();
//		 oc.setAttribute(MonitorReportOperation.CMD,MonitorReportOperation.CMD_INSERT);
//		 oc.setAttribute(MonitorReportOperation.IN_PARAM,report);
//		 OPCaller.call(MonitorReportOperation.ID, oc);
		 
//		 TPlDqMonitor dqMonitor=new TPlDqMonitor();

//		 /**预警处置 start*/
//		 TPlYjMonitor dqMonitor=new TPlYjMonitor();
//		 dqMonitor.setRptStatus("1");
//		 dqMonitor.setTaskType("YJ");
//		 dqMonitor.setLoanVariety("幸福易贷11");
//		 dqMonitor.setCustName("徐冬冬13");
//		 dqMonitor.setCustCode("110");
//		 dqMonitor.setLoanAmt(10000000.00);
//		 dqMonitor.setLoanBalance(0.00);
//		 dqMonitor.setWarnLevel("3级");
//		 dqMonitor.setLoanAcct("6222020200111999");
//		 dqMonitor.setLoanTerm("36个月");
//		 TlrInfoService tlrService=TlrInfoService.getInstance();
//		 dqMonitor.setHandler(tlrService.getTlrInfoByTlrno("00000001"));
//		 Date d=new Date();
//		 dqMonitor.setTaskMatureDate(new Date(d.getTime()+15*24*60*60*1000));
//		 dqMonitor.setReportUrl("/gbicc-pages/warn/ftl/YjMonitorReportWin.ftl");
//		 OperationContext oc = new OperationContext();
//		 oc.setAttribute(TPlYjMonitorOperation.CMD,TPlYjMonitorOperation.CMD_INSERT);
//		 oc.setAttribute(TPlYjMonitorOperation.IN_PARAM,dqMonitor);
//		 OPCaller.call(TPlYjMonitorOperation.ID, oc);
//
//
//
//		 
//
//		 ProcessManagerService pms=ProcessManagerService.getInstace();
//		 Map<String, Object> map=new HashMap<String, Object>();
//		 map.put("assignee", "00000001");
//		 map.put("desc","{}");
//		 pms.startProcess(dqMonitor.getId(),"warningMonitorProcess","00000001",map);
//		 /**预警处置 start*/

////		 
//		 TPlZxrfMonitor dqMonitor=new TPlZxrfMonitor();
//		 dqMonitor.setRptStatus("1");
//		 dqMonitor.setTaskType("RF");
//		 dqMonitor.setLoanVariety("xxxx");
//		 dqMonitor.setCustName("刘2");
//		 dqMonitor.setCustCode("110");
//		 dqMonitor.setLoanAmt(10000000.00);
//		 dqMonitor.setLoanBalance(0.00);
//		 dqMonitor.setWarnLevel("5级");
//		 dqMonitor.setLoanAcct("123423424");
//		 dqMonitor.setLoanTerm("12个月");
//		 TlrInfoService tlrService=TlrInfoService.getInstance();
//		 dqMonitor.setHandler(tlrService.getTlrInfoByTlrno("00000001"));
//		 Date d=new Date();
//		 dqMonitor.setTaskMatureDate(new Date(d.getTime()+15*24*60*60*1000));
//		 dqMonitor.setReportUrl("/gbicc-pages/zxrfProcess/ftl/TPlZxrfInfoWin.ftl");
//		 OperationContext oc = new OperationContext();
//		 oc.setAttribute(TPlZxrfMonitorOperation.CMD,TPlZxrfMonitorOperation.CMD_INSERT);
//		 oc.setAttribute(TPlZxrfMonitorOperation.IN_PARAM,dqMonitor);
//		 OPCaller.call(TPlZxrfMonitorOperation.ID, oc);
//		 
//		 ProcessManagerService pms=ProcessManagerService.getInstace();
//		 Map<String, Object> map=new HashMap<String, Object>();
//		 map.put("assignee", "00000001");
//		 map.put("desc","{}");
//		 pms.startProcess(dqMonitor.getId(),"PL_ZxrfReportProcess","00000001",map);
//		 
//		 TCollectionInfo info = new TCollectionInfo();
//		 info.setCustName("刘2");
//		 info.setCustCode("110");
//		 info.setLoanBalance(1110.00);
//		 info.setStatus("0");
//		 TCollectionInfoService collService = TCollectionInfoService.getInstance();
//		 collService.save(info);;
//		 Map<String, Object> map2=new HashMap<String, Object>();
////		 map2.put("assignee", "00000001");
//		 map2.put("desc","{}");
//		 map2.put("assignee", "00000001");
//		 pms.startProcess(info.getId(),"PL_CollectionMngProcess","00000001",map2);
		 
		 

		 return result;
	}

}
