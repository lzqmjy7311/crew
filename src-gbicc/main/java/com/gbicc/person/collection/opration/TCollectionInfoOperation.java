package com.gbicc.person.collection.opration;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gbicc.bpm.BpmDescUtil;
import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.company.warnDisposal.entity.TCmWarnControlmeasure;
import com.gbicc.company.warnDisposal.service.TCmWarnTaskService;
import com.gbicc.person.collection.entity.TCollectionInfo;
import com.gbicc.person.collection.service.TCollectionInfoService;
import com.gbicc.person.monitor.entity.TPlControlmeasure;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlTask;
import com.gbicc.person.monitor.service.TPlControlmeasureService;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.huateng.ebank.business.approve.service.TaskListService;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * 
 * @author liufei
 *
 * 版本：2015年11月07日 上午17:34:19
 * 类说明：催收操作类
 */
public class TCollectionInfoOperation extends BaseOperation {
	public static final String ID = "TCollectionInfoOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	private static final Logger log=LoggerFactory.getLogger(TCollectionInfoOperation.class);
	
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
		String opinion = (String) context.getAttribute("opinion");
		String taskAssignee=(String) context.getAttribute("taskAssignee");
		TCollectionInfoService service = TCollectionInfoService.getInstance();
		TCollectionInfo domain = (TCollectionInfo) context.getAttribute(IN_PARAM);
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(domain);
		} else if (CMD_UPDATE.equals(cmd)) {
			domain.setUpdated(new Date());
			if("0".equals(domain.getStatus())){
				domain.setStatus("1");
			}
			if(domain.getControlMeasure()!=null){
				this.contMeasureList(domain.getId(), domain.getControlMeasure(),domain.getOperBank());
			}
			service.update(domain);
		}
		if(StringUtils.isNotEmpty(op)){
			try {
				taskComplete(op, domain, opinion,taskAssignee);
			} catch (Exception e) {
				log.error("催收流程调用异常----------", e);
				throw new CommonException("系统异常",e.getMessage());
			}
		}
	}
	
	/**
	 * 
	 * @param op
	 * @param domain
	 * @param opinion
	 * @throws Exception
	 */
	public void taskComplete(String op,TCollectionInfo domain,String opinion,String taskAssignee) throws Exception{
		ProcessManagerService processManagerService=ProcessManagerService.getInstace();
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String taskId=processManagerService.findTaskId(domain.getId(), userId);
		Map<String,String> variables=processManagerService.findTaskVariable(domain.getId());
		Map<String, Object> processMap=new HashMap<String, Object>();
		if(op.equals("back")){
			processMap.put("path", "back");
			processMap.put("operation","退回");
			processMap.put("assignee", processManagerService.findTopUserId(domain.getId()));
		}else{
			processMap.put("operation","提交");
			if("ejzhhz".equals(variables.get("nowRoleName"))){//但前任务节点为行长时，提交后结束流程
				processMap.put("path", "end");
				processMap.put("opinion",opinion);
			}else{
				processMap.put("path", "next");
				processMap.put("opinion",domain.getRemark());
//				List<String> list=processManagerService.findUserIdByRoleidAndCurrOrgid(variables.get("nextRole"), info.getBrcode());
				if(StringUtils.isNoneBlank(taskAssignee)){
					processMap.put("assignee", taskAssignee);
				}else{
					throw new CommonException("未配置审核人","根据当前机构【"+info.getBrName()+"】查找流程下一节点未找到审核人");
				}
			}
		}
		processMap.put("desc", BpmDescUtil.getDesc(domain.getId(), domain.getCustCode(), domain.getCustName()));
		processManagerService.taskComplete(processMap, taskId);
		
		Map<String,String> newVar=processManagerService.findTaskVariable(domain.getId());
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if(null!=newVar && newVar.size()>0){
			String status=newVar.get("status");
			rootdao.flush();
			//更改业务状态
			rootdao.executeSql("UPDATE ECUSER.T_PL_COLLECTION_INFO SET FD_STATUS='"+status+"' WHERE FD_ID='"+domain.getId()+"' ");
		}
	}
	
	/**
	 * 控制措施保存
	 * @param businessId
	 * @param contMeasure
	 * @throws CommonException
	 */
	@SuppressWarnings("unused")
	private void contMeasureList(String businessId,String contMeasure,String orgCode) throws CommonException{
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		rootdao.executeSql("DELETE FROM ECUSER.T_PL_CONTROLMEASURE WHERE FD_TASK_ID='"+businessId+"' ");
		String[] arr=contMeasure.split(",");
		TPlControlmeasureService service = TPlControlmeasureService.getInstance();
		for (String string : arr) {
			if(StringUtils.isNotBlank(string)){
				TPlControlmeasure domain = new TPlControlmeasure();
				domain.setTaskId(businessId);
				domain.setConmeasCode(string);
				domain.setCredited(new Date());
				domain.setOrgCode(orgCode);
				domain.setTaskType("CS");
				service.save(domain);
			}
		}
	}

}
