package com.gbicc.bpm.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.gbicc.bpm.entity.TTaskDivert;
import com.gbicc.bpm.entity.TTaskDivertDtl;
import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.bpm.service.TTaskDivertDtlService;
import com.gbicc.bpm.service.TTaskDivertService;
import com.gbicc.common.CommonService;
import com.gbicc.common.FileUpDownProperties;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * @author likm
 * @time   2015年11月20日09:44:16
 * @desc   任务重分配操作类
 */
public class CopyOfTaskAfreshAssignOperation extends BaseOperation {
	public static final String ID = "TaskAfreshAssignOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String BUSINESS_ID = "BUSINESS_ID";
	public static final String OPINION="OPINION";//意见
	public static final String STATUS="0";//审核中
	public static final String PASS_STATUS="1";//审批通过
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		TTaskDivertService divertService=TTaskDivertService.getInstance();
		TTaskDivertDtlService divertDtlService=TTaskDivertDtlService.getInstance();
		CommonService service=CommonService.getInstance();
		String assignee =null;
		List<TTaskDivertDtl> list=new ArrayList<TTaskDivertDtl>();
		TTaskDivert taskDivert=null;
		if(null!=context.getAttribute("assignee")){
			assignee=(String) context.getAttribute("assignee");
		}
		if(null!=context.getAttribute("list")){
			list=(List<TTaskDivertDtl>)context.getAttribute("list");
		}
		if(null!=context.getAttribute("taskDivert")){
			taskDivert=(TTaskDivert) context.getAttribute("taskDivert");
		}
		String op=(String) context.getAttribute("op");
		if(op.equals("oneSubmit")){
			TlrInfoService tlrService=TlrInfoService.getInstance();
			TlrInfo oldAssignee=tlrService.getTlrInfoByTlrno(list.get(0).getAssignee().getTlrno());
			ProcessManagerService procService=ProcessManagerService.getInstace();
			//保存主表
			TTaskDivert divert=new TTaskDivert();
			divert.setId(null);
			divert.setAplDate(new Date());
			divert.setAplPer(tlrService.getTlrInfoByTlrno(userId));
			divert.setAssignee(tlrService.getTlrInfoByTlrno(assignee));
			divert.setOldAssignee(oldAssignee);
			divert.setStatus(STATUS);
			divertService.save(divert);
			//保存详细信息表
			for(TTaskDivertDtl task:list){
				task.setId(null);
				task.setAssignee(null);
				List<ProcessInstance> l=procService.getRuntimeService().createProcessInstanceQuery().processInstanceId(task.getProcInstId()).list();
				task.setBusinessKey(l.get(0).getBusinessKey());
				task.setTaskDivertId(divert.getId());
				task.setAssignee(oldAssignee);
				divertDtlService.save(task);
			}
			if(op.equals("oneSubmit")){
				try {
					startProcess(divert.getId(),userId);
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}else if (op.equals("submit")){
			try {
				ProcessManagerService managerService=ProcessManagerService.getInstace();
				taskComplete(taskDivert.getId(),userId);
				taskDivert.setStatus(PASS_STATUS);
				//审核通过后更改activi流程表中的记录。
				List<Object> dtls=service.queryListHQL("from TTaskDivertDtl where taskDivertId='"+taskDivert.getId()+"' ");
				for(Object obj:dtls){
					TTaskDivertDtl dtl=(TTaskDivertDtl) obj;
					Task t=managerService.getTaskService().createTaskQuery().taskId(dtl.getTaskId()).singleResult();
					if(null!=t){
						t.setAssignee(taskDivert.getAssignee().getTlrno());
						managerService.getTaskService().saveTask(t);
					}
				}
				divertService.update(taskDivert);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}else if(op.equals("back")){
			try {
				taskComplete(taskDivert.getId(),userId);
				service.executeHQL("delete from TTaskDivertDtl where taskDivertId='"+taskDivert.getId()+"' ");
				divertService.dao().delete(taskDivert);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
	
	//启动流程
	public void startProcess(String businessKey,String userId) throws Exception{
		String processKey = FileUpDownProperties.readValue("task_divert_process");
		ProcessManagerService procService=ProcessManagerService.getInstace();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("assignee",userId);
		map.put("desc","业务ID:"+businessKey+"");
		procService.startProcess(businessKey,processKey,userId,map);
		//流程往下走一步
		Task task=procService.getTaskService().createTaskQuery().processInstanceBusinessKey(businessKey).singleResult();
		Map<String,String> variables=procService.findTaskVariable(businessKey);
		Map<String,Object> nextMap=new HashMap<String, Object>();
		List<String> assigneeList=procService.findUserId(variables.get("nextRole"));
		nextMap.put("assigneeList",assigneeList);
		nextMap.put("desc","业务ID:"+businessKey+"");
		procService.taskComplete(nextMap, task.getId());
	}
	
	//完成任务
	public void taskComplete(String businessKey,String userId) throws Exception{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("desc","业务ID:"+businessKey+"");
		ProcessManagerService processManagerService=ProcessManagerService.getInstace();
		String taskId=processManagerService.findTaskId(businessKey,userId);
		processManagerService.taskComplete(map, taskId);
	}
}
