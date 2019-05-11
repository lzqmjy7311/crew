package com.gbicc.bpm.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;

import com.gbicc.bpm.entity.TLoanAccountDutyDistribute;
import com.gbicc.bpm.entity.TLoanAccountRelDistribute;
import com.gbicc.bpm.entity.TPlAccountDistRecord;
import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.bpm.service.TLoanAccountDutyDistributeService;
import com.gbicc.bpm.service.TLoanAccountRelDistributeService;
import com.gbicc.common.CommonService;
import com.gbicc.common.FileUpDownProperties;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TLoanAccountDutyDistributeOperation extends BaseOperation {

	public static final String ID = TLoanAccountDutyDistributeOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	public static final String DIST_FLAG_SINGLE="1";//分派标识-单个
	public static final String DIST_FLAG_MUCH="2";//分派标识-批量
	
	public static final String STATUS_APL_ING="1";//状态-审核中
	public static final String STATUS_APL_REFUSE="2";//状态-审核拒绝
	public static final String STATUS_APL_PASS="3";//状态-审核通过
	
	public static final String DIST_TYPE_DUTY="1";//分派任务类型-责任人
	public static final String DIST_TYPE_COLL="2";//分派任务类型-催收人
	
	public static final String ACCOUNT_DUTY_PROCESS="account_duty_process";//帐户责任人分派流程关键字
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(OperationContext context) throws CommonException {
		String op = (String) context.getAttribute("op");
		String opinion = (String) context.getAttribute("opinion");
		String loanacnos=(String) context.getAttribute("loanacnos");
		String taskAssignee=(String) context.getAttribute("taskAssignee");
		TLoanAccountDutyDistribute distribute = (TLoanAccountDutyDistribute) context.getAttribute("TLoanAccountDutyDistribute");
		List<Map> recordList = (List<Map>) context.getAttribute("recordList");
		TLoanAccountDutyDistributeService service = TLoanAccountDutyDistributeService.getInstance();
		try {
			if(StringUtils.isNotEmpty(distribute.getDistPrinciple())){
				distribute.setDistFlag(DIST_FLAG_MUCH);
			}else{
				distribute.setDistFlag(DIST_FLAG_SINGLE);
			}
			
			if(StringUtils.isNotEmpty(distribute.getId())){
				service.update(distribute);
				taskComplete(distribute,op,opinion);
				service.update(distribute);//更改状态
			}else{
				service.save(distribute);
				startProcess(distribute,taskAssignee);
				service.update(distribute);//更改状态
			}
			
			if(StringUtils.isNotEmpty(distribute.getDistPrinciple())){
				CommonService commonService=CommonService.getInstance();
				commonService.executeHQL("delete from TLoanAccountRelDistribute where distId='"+distribute.getId()+"' ");
				
				String[] strs=loanacnos.split(",");
				for(String s:strs){
					TLoanAccountRelDistribute relDist=new TLoanAccountRelDistribute();
					relDist.setId(null);
					relDist.setLoanacno(s);
					relDist.setDistId(distribute.getId());
					TLoanAccountRelDistributeService.getInstance().save(relDist);
				}
				commonService.executeHQL("delete from TPlAccountDistRecord where distId='"+distribute.getId()+"' ");
				for(Map map:recordList){
					TPlAccountDistRecord record=new TPlAccountDistRecord();
					record.setId(null);
					record.setDistId(distribute.getId());
					commonService.save(record);
					//直接设置实体属性保存会报错，查询出来的对象是持久态的对象。
					if(map.get("brcode")!=null){
						record.setBrcode(BctlService.getInstance().getBctlByBrcode(map.get("brcode").toString()));
					}
					if(map.get("tlrno")!=null){
						record.setTlrno(TlrInfoService.getInstance().getTlrInfoByTlrno(map.get("tlrno").toString()));
					}
					commonService.update(record);
				}
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
	public void startProcess(TLoanAccountDutyDistribute distribute,String taskAssignee) throws Exception{
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String processKey = FileUpDownProperties.readValue(ACCOUNT_DUTY_PROCESS);
		ProcessManagerService procService=ProcessManagerService.getInstace();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("assignee",userId);
		map.put("desc","业务ID:"+distribute.getId()+"");
		procService.startProcess(distribute.getId(),processKey,userId,map);
		//流程往下走一步
		Task task=procService.getTaskService().createTaskQuery().processInstanceBusinessKey(distribute.getId()).singleResult();
		//Map<String,String> variables=procService.findTaskVariable(distribute.getId());
		Map<String,Object> nextMap=new HashMap<String, Object>();
		//List<String> assigneeList=procService.findUserIdByRoleidAndCurrOrgid(variables.get("nextRole"),distribute.getOperOrg().getBrcode());
		List<String> assigneeList=new ArrayList<String>();
		if(StringUtils.isNotEmpty(taskAssignee)){
			assigneeList.add(taskAssignee);
		}
		if(assigneeList==null || assigneeList.size()==0){
			throw new CommonException("未配置审核人","根据当前机构【"+distribute.getOperOrg().getBrname()+"】查找流程下一节点未找到审核人");
		}
		nextMap.put("operation","提交");
		nextMap.put("assigneeList",assigneeList);
		nextMap.put("desc","业务ID:"+distribute.getId()+"");
		procService.taskComplete(nextMap, task.getId());
		Map<String,String> variables2=procService.findTaskVariable(distribute.getId());
		distribute.setStatus(variables2.get("status"));
		distribute.setAplUser(assigneeList.get(0));
	}
	
	/**
	 * 任务完成
	 * @param distribute
	 * @throws Exception 
	 */
	public void taskComplete(TLoanAccountDutyDistribute distribute,String op,String opinion) throws Exception{
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		ProcessManagerService processManagerService=ProcessManagerService.getInstace();
		String taskId=processManagerService.findTaskId(distribute.getId(), userId);
		//Map<String,String> variables=processManagerService.findTaskVariable(distribute.getId());
		Map<String, Object> map=new HashMap<String, Object>();
		if(op.equals("submit")){
			map.put("operation","审核通过");
			//map.put("path", "next");
			//List<String> assigneeList=processManagerService.findUserIdByRoleidAndOrgid(variables.get("nextRole"),distribute.getOperUser().getBrcode());
			map.put("path","end");
			map.put("businStatus",STATUS_APL_PASS);
		}else {
			map.put("operation","审核拒绝");
			map.put("path","end");
			map.put("businStatus",STATUS_APL_REFUSE);
		}
		map.put("opinion",opinion);
		map.put("desc","业务ID:"+distribute.getId()+"");
		processManagerService.taskComplete(map, taskId);
		Map<String,String> newVar=processManagerService.findTaskVariable(distribute.getId());
		if(newVar!=null && newVar.get("status")!=null){
			distribute.setStatus(newVar.get("status"));
		}
	}
}