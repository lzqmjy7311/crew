package com.gbicc.person.monitor.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.BpmDescUtil;
import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.CommonService;
import com.gbicc.person.creditMemo.entity.TPlCreditMemo;
import com.gbicc.person.creditMemo.service.TPlCreditMemoService;
import com.gbicc.person.monitor.entity.TPlControlmeasure;
import com.gbicc.person.monitor.entity.TPlDqReportJy;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlTask;
import com.gbicc.person.monitor.service.TPlControlmeasureService;
import com.gbicc.person.monitor.service.TPlDqMonitorService;
import com.gbicc.person.monitor.service.TPlDqReportJyService;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * @author likm
 * @time   2015年11月6日09:59:58
 * @desc   经营类监控报告操作类
 */
public class TPlDqReportJyOperation extends BaseOperation {
	public static final String ID = "TPlDqReportJyOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String BUSINESS_ID = "BUSINESS_ID";
	public static final String JY = "JY";
	public static final String LOAN_PERSION_LIST = "LOAN_PERSION_LIST";
	public static final String GUAR_LIST = "GUAR_LIST";
	public static final String WAIT_HZ_APPROVE_STATUS="2";//待行长审核状态
	public static final String OPINION="OPINION";//意见
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		String op = (String) context.getAttribute("op");
		String opinion = (String) context.getAttribute(OPINION);
		String businessId = (String) context.getAttribute(BUSINESS_ID);
		String taskAssignee=(String) context.getAttribute("taskAssignee");
		try {
			TPlDqReportJy jyReport = (TPlDqReportJy) context.getAttribute(IN_PARAM);
			TPlDqReportJyService service = TPlDqReportJyService.getInstance();
			if (CMD_QUERY.equals(cmd)) {
			} else if (CMD_INSERT.equals(cmd)) {
				service.save(jyReport);
				
				TPlReportRelation relation=new TPlReportRelation();
				relation.setBusinessId(businessId);
				relation.setReportId(jyReport.getId());
				relation.setReportType(JY);
				
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				rootdao.getHibernateTemplate().save(relation);
				saveCtrl(jyReport,businessId);
			} else if (CMD_UPDATE.equals(cmd)) {
				service.update(jyReport);
				saveCtrl(jyReport,businessId);
			} else if (CMD_DELETE.equals(cmd)) {
				service.delete(jyReport);
			}
			if(StringUtils.isNotEmpty(op)){
				taskComplete(businessId,op,jyReport,opinion,taskAssignee);
				jyReport.setOpinion(null);
				service.update(jyReport);
			}
		} catch(CommonException e){
			e.printStackTrace();
			throw new CommonException(e.getErrCode(),e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("系统异常",e.getMessage());
		}
	}
	
	//保存控制措施
	public void saveCtrl(TPlDqReportJy jyReport,String businessId) throws CommonException{
		CommonService.getInstance().executeHQL("delete from TPlControlmeasure where taskId='"+businessId+"' ");
		if(StringUtils.isNotEmpty(jyReport.getLmtCtrl())){
			List<String> lmtList=new ArrayList<String>();
			if(jyReport.getLmtCtrl().indexOf(",")>-1){
				String[] str=jyReport.getLmtCtrl().split(",");
				lmtList=Arrays.asList(str);
			}else{
				lmtList.add(jyReport.getLmtCtrl());
			}
			for(String lmt:lmtList){
				setCtrl(jyReport,lmt,TPlDqReportXfOperation.CTRL_TYPE_LMT,businessId);
			}
		}
		if(StringUtils.isNotEmpty(jyReport.getRiskCtrl())){
			List<String> othList=new ArrayList<String>();
			if(jyReport.getRiskCtrl().indexOf(",")>-1){
				String[] str=jyReport.getRiskCtrl().split(",");
				othList=Arrays.asList(str);
			}else{
				othList.add(jyReport.getRiskCtrl());
			}
			for(String oth:othList){
				setCtrl(jyReport,oth,TPlDqReportXfOperation.CTRL_TYPE_OTH,businessId);
			}
		}
		if(StringUtils.isNotEmpty(jyReport.getAppendCtrl())){
			List<String> apdList=new ArrayList<String>();
			if(jyReport.getAppendCtrl().indexOf(",")>-1){
				String[] str=jyReport.getAppendCtrl().split(",");
				apdList=Arrays.asList(str);
			}else{
				apdList.add(jyReport.getAppendCtrl());
			}
			for(String apd:apdList){
				setCtrl(jyReport,apd,TPlDqReportXfOperation.CTRL_TYPE_APD,businessId);
			}
		}
	}
		
	//设置控制措施并保存
	public void setCtrl(TPlDqReportJy jyReport,String code,String type,String businessId) throws CommonException{
		TPlControlmeasureService ctrlService=TPlControlmeasureService.getInstance();
		TPlControlmeasure ctrl=new TPlControlmeasure();
		ctrl.setConmeasCode(code);
		ctrl.setCtrlType(type);
		ctrl.setTaskId(businessId);
		ctrl.setTaskType("JYBG");
		if(type.equals(TPlDqReportXfOperation.CTRL_TYPE_OTH) && code.equals(TPlDqReportXfOperation.RISK_CTRL_OTHER)){
			ctrl.setOtherCtrlDesc(jyReport.getOtherCtrlDesc());
		}
		ctrlService.save(ctrl);
	}
	
	/**
	 * 客户经理填报完成
	 * @param businessId
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public void taskComplete(String businessId,String op,TPlDqReportJy jyReport,String opinion,String taskAssignee) throws Exception{
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		//String orgId=info.getBrcode();
		ProcessManagerService processManagerService=ProcessManagerService.getInstace();
		String taskId=processManagerService.findTaskId(businessId, userId);
		TPlTaskService taskService=TPlTaskService.getInstance();
		TPlTask task=taskService.get(businessId);
		Map<String, Object> map=new HashMap<String, Object>();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Map<String,String> variables=processManagerService.findTaskVariable(businessId);
		List<String> assigneeList=new ArrayList<String>();
		if(StringUtils.isNotEmpty(taskAssignee)){
			assigneeList.add(taskAssignee);
		}
		if(op.equals("submit") && variables.get("status").equals(WAIT_HZ_APPROVE_STATUS)){
			map.put("operation","提交");
			List<String> list=TPlDqMonitorService.getInstance().dwrFindCtrl(businessId);
			if(null!=list && list.size()>0){
				map.put("path", "next");
				if(StringUtils.isNotEmpty(variables.get("nextRole"))){
					if(assigneeList==null || assigneeList.size()==0){
						throw new CommonException("未配置审核人","根据当前机构【"+info.getBrName()+"】查找流程下一节点未找到审核人");
					}
					map.put("assigneeList",assigneeList);
				}else if(StringUtils.isNotEmpty(variables.get("nextAssignee"))){
					map.put("assignee",task.getHandler().getTlrno());
				}
				
				//根据 businessId删除历史  信贷备忘录
				rootdao.executeSql("DELETE FROM ECUSER.T_PL_CREDIT_MEMO WHERE FD_BUSINESS_ID='"+businessId+"' ");
				String warningSignalId=null;
				String sql="SELECT T.id FROM TWarnSignal T WHERE T.reportId='"+jyReport.getId()+"' ";
				List<Object> signalList=(List<Object>) rootdao.queryByCondition(sql);
				if(signalList.size()>0){
					warningSignalId=(String)signalList.get(0);
				}
				TPlCreditMemoService service = TPlCreditMemoService.getInstance();
				//插入信贷备忘录
				TPlCreditMemo tPlCreditMemo=new TPlCreditMemo();
				tPlCreditMemo.setBusinessId(businessId);
				tPlCreditMemo.setControlmeasure(jyReport.getId());
				tPlCreditMemo.setCustname(jyReport.getCustName());
				tPlCreditMemo.setCustcode(jyReport.getCustCode());
				tPlCreditMemo.setLoanAccount(task.getLoanAcct());
				tPlCreditMemo.setOperator(task.getHandler().getTlrno());
				tPlCreditMemo.setOperBank(task.getHandler().getBrcode());
				tPlCreditMemo.setReprotCode(warningSignalId);//预警信号id
				tPlCreditMemo.setStartDate(task.getTaskCreatDate());
				tPlCreditMemo.setStartType(task.getTaskType());
				service.save(tPlCreditMemo);
			}else{
				map.put("path","end");
			}
		}else if(op.equals("back")){
			map.put("operation","退回");
			map.put("path","back");
			map.put("assignee",task.getHandler().getTlrno());
		}else if(op.equals("submit")){
			map.put("operation","提交");
			map.put("path","next");
			if(StringUtils.isNotEmpty(variables.get("nextRole"))){
				if(assigneeList==null || assigneeList.size()==0){
					throw new CommonException("未配置审核人","根据当前机构【"+info.getBrName()+"】查找流程下一节点未找到审核人");
				}
				map.put("assigneeList",assigneeList);
			}else if(StringUtils.isNotEmpty(variables.get("nextAssignee"))){
				map.put("assignee",task.getHandler().getTlrno());
			}
		}
		map.put("desc",BpmDescUtil.getDesc(jyReport.getId(),jyReport.getLoanAcct(),jyReport.getCustName()));
		map.put("opinion",opinion);
		processManagerService.taskComplete(map, taskId);
		
		Map<String,String> newVar=processManagerService.findTaskVariable(businessId);
		if(null!=newVar && newVar.size()>0){
			String status=newVar.get("status");
			//更改业务状态
			rootdao.executeSql("UPDATE ECUSER.T_PL_TASK SET RPT_STATUS='"+status+"' WHERE FD_ID='"+businessId+"' ");
		}
	}
}
