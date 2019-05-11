package com.gbicc.person.eliminate.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.common.CommonService;
import com.gbicc.common.FileUpDownProperties;
import com.gbicc.person.eliminate.entity.TPlRuleEliminate;
import com.gbicc.person.eliminate.entity.TPlRuleEliminateDtl;
import com.gbicc.person.eliminate.service.TPlRuleEliminateDtlService;
import com.gbicc.person.eliminate.service.TPlRuleEliminateService;
import com.gbicc.person.eliminate.update.TPlRuleEliminateTaskUpdate;
import com.gbicc.personCommon.entity.TEdwPlsAccount;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TPlRuleEliminateOperation extends BaseOperation {

	public static final String ID = TPlRuleEliminateOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String TPL_TRIGGER_RULE_ACCT="TPL_TRIGGER_RULE_ACCT";
	public static final String RULE_ID_LIST="RULE_ID_LIST";
	public static final String RULE_ELIMINATE="RULE_ELIMINATE";
	
	public static final String TEMP_FLAG="2";//临时标识
	
	public static final String PASS_STATUS="5";//审核通过状态
	public static final String WAIT_SUBMIT_STATUS="1";//待提交状态
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {
		TEdwPlsAccount acct=(TEdwPlsAccount) context.getAttribute(TPL_TRIGGER_RULE_ACCT);
		List<String> ruleIdList=(List<String>) context.getAttribute(RULE_ID_LIST);
		TPlRuleEliminate re=(TPlRuleEliminate) context.getAttribute(RULE_ELIMINATE);
		String op=(String) context.getAttribute("op");
		String opinion=(String) context.getAttribute("opinion");
		String taskAssignee=(String) context.getAttribute("taskAssignee");
		String updateClassName=(String) context.getAttribute("updateClassName");
		TPlRuleEliminateService eliminateService=TPlRuleEliminateService.getInstance();
		TPlRuleEliminateDtlService dtlService=TPlRuleEliminateDtlService.getInstance();
		TlrInfoService infoService=TlrInfoService.getInstance();
		BctlService bctlService=BctlService.getInstance();
		CommonService service=CommonService.getInstance();
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String userOrg=info.getBrcode();

		try {
			TPlRuleEliminate ruleEliminate=null;
			if(updateClassName.equals(TPlRuleEliminateTaskUpdate.class.getName())){
				Object obj=service.queryOneHQL("from TPlRuleEliminate where triggerRuleAcct.loanacno='"+acct.getLoanacno()+"' and status<>'"+PASS_STATUS+"' ");
				
				ruleEliminate=(TPlRuleEliminate) obj;
				ruleEliminate.setUpdDate(new Date());
				ruleEliminate.setEliminateRuleDesc(re.getEliminateRuleDesc());
				eliminateService.update(ruleEliminate);
			}else{
				if(StringUtils.isEmpty(re.getId())){
					ruleEliminate=new TPlRuleEliminate();
					ruleEliminate.setId(null);
					ruleEliminate.setStatus(null);
					ruleEliminate.setTriggerRuleAcct(acct);
					ruleEliminate.setUpdDate(new Date());
					ruleEliminate.setLaunchPer(infoService.getTlrInfoByTlrno(userId));
					ruleEliminate.setLaunchOrg(bctlService.getBctlByBrcode(userOrg));
					ruleEliminate.setEliminateRuleDesc(re.getEliminateRuleDesc());
					eliminateService.save(ruleEliminate);
				}else{
					ruleEliminate=eliminateService.get(re.getId());
					ruleEliminate.setUpdDate(new Date());
					eliminateService.update(ruleEliminate);
				}
			}
			service.executeHQL("delete from TPlRuleEliminateDtl where ruleElimId='"+ruleEliminate.getId()+"' and flag='"+TEMP_FLAG+"' ");
			for(String ruleId:ruleIdList){
				TPlRuleEliminateDtl dtl=new TPlRuleEliminateDtl();
				dtl.setId(null);
				dtl.setRuleElimId(ruleEliminate.getId());
				dtl.setRuleId(ruleId);
				dtl.setFlag(TEMP_FLAG);
				dtlService.save(dtl);
			}
			
			String status=null;
			if(op.equals("one_save")){
				status=startProcess(ruleEliminate.getId(),userId);
			}else if(op.equals("one_submit")){
				status=submitProcess(ruleEliminate.getId(),userId,taskAssignee);
			}else if(StringUtils.isNotEmpty(op)){
				status=taskComplete(op,ruleEliminate,opinion,taskAssignee);
			}
			if(StringUtils.isNotEmpty(status)){
				ruleEliminate.setStatus(status);
				service.update(ruleEliminate);
			}
		} catch(CommonException e){
			e.printStackTrace();
			throw new CommonException(e.getErrCode(),e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("系统异常",e.getMessage());
		}
	}
	
	//启动流程
	public String startProcess(String businessKey,String userId) throws Exception{
		String processKey = FileUpDownProperties.readValue("rule_eliminate_recover_process");
		ProcessManagerService procService=ProcessManagerService.getInstace();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("assignee",userId);
		map.put("desc","业务ID:"+businessKey);
		procService.startProcess(businessKey,processKey,userId,map);
		return WAIT_SUBMIT_STATUS;
		//流程往下走一步
		//Task task=procService.getTaskService().createTaskQuery().processInstanceBusinessKey(businessKey).singleResult();
		//Map<String,String> variables=procService.findTaskVariable(businessKey);
		//Map<String,Object> nextMap=new HashMap<String, Object>();
		//List<String> assigneeList=procService.findUserId(variables.get("nextRole"));
		//nextMap.put("assigneeList",assigneeList);
		//nextMap.put("desc","业务ID:"+businessKey);
		//procService.taskComplete(nextMap, task.getId());
		//Map<String,String> newVar=procService.findTaskVariable(businessKey);
		//return newVar.get("status");
	}
	
	//第一次提交
	public String submitProcess(String businessKey,String userId,String taskAssignee) throws Exception{
		String processKey = FileUpDownProperties.readValue("rule_eliminate_recover_process");
		ProcessManagerService procService=ProcessManagerService.getInstace();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("assignee",userId);
		map.put("desc","业务ID:"+businessKey);
		procService.startProcess(businessKey,processKey,userId,map);
		//流程往下走一步
		Task task=procService.getTaskService().createTaskQuery().processInstanceBusinessKey(businessKey).singleResult();
		Map<String,Object> nextMap=new HashMap<String, Object>();
		List<String> assigneeList=new ArrayList<String>();//procService.findUserId(variables.get("nextRole"));
		if(StringUtils.isNotEmpty(taskAssignee)){
			assigneeList.add(taskAssignee);
		}
		if(assigneeList==null || assigneeList.size()==0){
			throw new CommonException("未配置审核人","流程下一节点总行未配置审核人");
		}
		nextMap.put("assigneeList",assigneeList);
		nextMap.put("desc","业务ID:"+businessKey);
		procService.taskComplete(nextMap, task.getId());
		Map<String,String> newVar=procService.findTaskVariable(businessKey);
		return newVar.get("status");
	}
	
	//任务完成
	public String taskComplete(String op,TPlRuleEliminate ruleEliminate,String opinion,String taskAssignee) throws Exception{
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		ProcessManagerService processManagerService=ProcessManagerService.getInstace();
		String taskId=processManagerService.findTaskId(ruleEliminate.getId(),userId);
		Map<String,String> variables=processManagerService.findTaskVariable(ruleEliminate.getId());
		Map<String, Object> map=new HashMap<String, Object>();
		if(op.equals("back")){
			map.put("operation","退回");
			map.put("path","back");
			map.put("assignee",ruleEliminate.getLaunchPer().getTlrno());
		}else if(op.equals("submit")){
			map.put("operation","提交");
			map.put("path","next");
			List<String> assigneeList=new ArrayList<String>();
			if(StringUtils.isNotEmpty(variables.get("nextRole"))){
				//=processManagerService.findUserId(variables.get("nextRole"));
				if(StringUtils.isNotEmpty(taskAssignee)){
					assigneeList.add(taskAssignee);
				}
				if(assigneeList==null || assigneeList.size()==0){
					throw new CommonException("未配置审核人","流程下一节点总行未配置审核人");
				}
				map.put("assigneeList",assigneeList);
			}else if(StringUtils.isNotEmpty(variables.get("nextAssignee"))){
				map.put("assignee",ruleEliminate.getLaunchPer().getTlrno());
			}
		}
		map.put("desc","业务ID:"+ruleEliminate.getId());
		map.put("opinion",opinion);
		processManagerService.taskComplete(map, taskId);
		
		Map<String,String> newVar=processManagerService.findTaskVariable(ruleEliminate.getId());
		if(null!=newVar && newVar.size()>0){
			String status=newVar.get("status");
			return status;
		}
		return null;
	}
}
