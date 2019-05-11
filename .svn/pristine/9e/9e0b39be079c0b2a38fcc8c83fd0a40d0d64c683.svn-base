package com.gbicc.person.frequency.opration;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.BpmDescUtil;
import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.person.frequency.entity.TPlTriggerFrequencyAcct;
import com.gbicc.person.frequency.service.TPlTriggerFrequencyAcctService;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TPlTriggerFrequencyAcctOperation extends BaseOperation {

	public static final String ID = TPlTriggerFrequencyAcctOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String BUSINESS_ID = "BUSINESS_ID";
	public static final String OPINION = "opinion";
	public static final String OP = "op";
	public static final String START_STATUS = "1";
	public static final String YJZH_ROLE = "557";


	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		String businessId = (String) context.getAttribute(BUSINESS_ID);
		String op = (String) context.getAttribute(OP);
		String opinion = (String) context.getAttribute(OPINION);
		String taskAssignee=(String) context.getAttribute("taskAssignee");//接收人
		TPlTriggerFrequencyAcctService service = TPlTriggerFrequencyAcctService.getInstance();
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String orgId=info.getBrcode();
		
		
		TPlTriggerFrequencyAcct dd = (TPlTriggerFrequencyAcct) context.getAttribute(IN_PARAM);
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			dd.setWarnDate(new Date());//人工主动发起调整日期
			service.save(dd);
			
		} else if (CMD_UPDATE.equals(cmd)) {
    	    service.update(dd);

			
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(dd.getId());
		}
		
		String status=null;
		if(op.equals("one_submit")){
			status=startProcess(dd,dd.getLoanAcct(),userId,orgId,info.getBrName(),taskAssignee);
		}else if(StringUtils.isNotEmpty(op)){
			try {
				status=taskComplete(op,dd,opinion,taskAssignee);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isNotEmpty(status)){
			dd.setStatus(status);
			service.update(dd);
		}
	}
	
	
	
	//启动流程
		public String startProcess(TPlTriggerFrequencyAcct triggerFrequencyAcct,String businessKey,String userId,String orgId,String brName ,String taskAssignee) throws CommonException{
			String processKey = FileUpDownProperties.readValue("triggerFrequencyProcess");
			ProcessManagerService procService=ProcessManagerService.getInstace();
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("assignee",userId);
			map.put("desc",BpmDescUtil.getDesc(businessKey,triggerFrequencyAcct.getLoanAcct(),triggerFrequencyAcct.getCustName()));
			procService.startProcess(businessKey,processKey,userId,map);
			//流程往下走一步
			Task task=procService.getTaskService().createTaskQuery().processInstanceBusinessKey(businessKey).singleResult();
			Map<String,String> variables=procService.findTaskVariable(businessKey);
			Map<String,Object> nextMap=new HashMap<String, Object>();
			try {
				//List<String> assigneeList=procService.findUserId(variables.get("nextRole"));
				List<String> assigneeList=new ArrayList<String>();
				if(StringUtils.isNotEmpty(taskAssignee)){
					assigneeList.add(taskAssignee);
				}
				  if(assigneeList==null || assigneeList.size()==0){
						throw new CommonException("未配置审核人","根据当前机构【"+brName+"】查找流程下一节点未找到审核人");
					}
				nextMap.put("assigneeList",assigneeList);
				nextMap.put("desc",BpmDescUtil.getDesc(businessKey,triggerFrequencyAcct.getLoanAcct(),triggerFrequencyAcct.getCustName()));
				nextMap.put("operation","提交");
				procService.taskComplete(nextMap, task.getId());
			} catch(CommonException e){
				e.printStackTrace();
				throw new CommonException(e.getErrCode(),e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new CommonException("系统异常",e.getMessage());
			}
			Map<String,String> newVar=procService.findTaskVariable(businessKey);
			return newVar.get("status");
		}
		
		//任务完成
		public String taskComplete(String op,TPlTriggerFrequencyAcct tPlTriggerFrequencyAcct,String opinion,String taskAssignee) throws Exception{
			GlobalInfo info=GlobalInfo.getCurrentInstance();
			String userId=info.getTlrno();
			String orgId=info.getBrcode();
			ProcessManagerService processManagerService=ProcessManagerService.getInstace();
			String taskId=processManagerService.findTaskId(tPlTriggerFrequencyAcct.getLoanAcct(),userId);
			Map<String,String> variables=processManagerService.findTaskVariable(tPlTriggerFrequencyAcct.getId());
			Map<String, Object> map=new HashMap<String, Object>();
			if(op.equals("back")){
				map.put("operation","退回");
				map.put("path","back");
				map.put("assignee",tPlTriggerFrequencyAcct.getLaunchPer());
			}else if(op.equals("submit")){
				map.put("operation","提交");
				map.put("path","next");
				if(StringUtils.isNotEmpty(variables.get("nextRole"))){
					//List<String> assigneeList=processManagerService.findUserIdByRoleidAndCurrOrgid(variables.get("nextRole"),orgId);
					List<String> assigneeList=new ArrayList<String>();
					if(StringUtils.isNotEmpty(taskAssignee)){
						assigneeList.add(taskAssignee);
					}
					map.put("assigneeList",assigneeList);
				}else if(StringUtils.isNotEmpty(variables.get("nextAssignee"))){
					map.put("assignee",tPlTriggerFrequencyAcct.getLaunchPer());
				}
			}
			map.put("desc",BpmDescUtil.getDesc(tPlTriggerFrequencyAcct.getLoanAcct(),tPlTriggerFrequencyAcct.getLoanAcct(),tPlTriggerFrequencyAcct.getCustName()));
			map.put("opinion",opinion);
			processManagerService.taskComplete(map, taskId);
			
			Map<String,String> newVar=processManagerService.findTaskVariable(tPlTriggerFrequencyAcct.getLoanAcct());
			if(null!=newVar && newVar.size()>0){
				String status=newVar.get("status");
				return status;
			}
			return null;
		}
	

}
