package com.gbicc.bpm.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.zip.ZipInputStream;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.ProcessEngineImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.SpringContextHolder;
import com.gbicc.bpm.entity.TLoanAccountRelDuty;
import com.gbicc.bpm.pojo.ExtHistoricProcessInstance;
import com.gbicc.bpm.pojo.ExtProcessDefinition;
import com.gbicc.bpm.pojo.ExtProcessOpinion;
import com.gbicc.bpm.pojo.ExtTask;
import com.gbicc.common.CommonService;
import com.gbicc.personCommon.entity.TEdwPlsAccount;
import com.gbicc.personCommon.entity.TPlTaskRuleTrigInfo;
import com.gbicc.util.DateUtils;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.business.management.service.UserMgrService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.dao.mng.RoleFuncRelDAO;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.RoleFuncRel;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class ProcessManagerService {

	ProcessEngine processEngine;
	RepositoryService repositoryService;
	RuntimeService runtimeService;
	TaskService taskService;
	HistoryService historyService;
	IdentityService identityService;
	FormService formService;

	public synchronized static ProcessManagerService getInstace() {
		return SpringContextHolder.getBean(ProcessManagerService.class
				.getSimpleName());
	}

	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	public void setIdentityService(IdentityService identityService) {
		this.identityService = identityService;
	}

	public FormService getFormService() {
		return formService;
	}

	public void setFormService(FormService formService) {
		this.formService = formService;
	}

	public ProcessEngine getProcessEngine() {
		return processEngine;
	}

	public RepositoryService getRepositoryService() {
		return repositoryService;
	}

	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public HistoryService getHistoryService() {
		return historyService;
	}

	public IdentityService getIdentityService() {
		return identityService;
	}

	public void deploy(String processName) throws IOException {
		File file = new File(processName);
		InputStream inputStream = FileUtils.openInputStream(file);
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		processEngine.getRepositoryService().createDeployment()
				.name(file.getName()).addZipInputStream(zipInputStream)
				.deploy();
	}

	public InputStream viewDefinitionDiagram(String key, String version) {
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery().processDefinitionKey(key)
				.processDefinitionVersion(Integer.valueOf(version))
				.singleResult();
		String diagramResourceName = processDefinition.getDiagramResourceName();
		return repositoryService.getResourceAsStream(
				processDefinition.getDeploymentId(), diagramResourceName);
	}

	public InputStream viewRunTimeDiagram(String executionId) {
		ProcessInstance processInstance = runtimeService
				.createProcessInstanceQuery().processInstanceId(executionId)
				.singleResult();
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance
				.getProcessDefinitionId());
		List<String> activeActivityIds = runtimeService
				.getActiveActivityIds(executionId);
		ProcessEngineImpl defaultProcessEngine = (ProcessEngineImpl) ProcessEngines
				.getDefaultProcessEngine();
		Context.setProcessEngineConfiguration(defaultProcessEngine
				.getProcessEngineConfiguration());
		return defaultProcessEngine
				.getProcessEngineConfiguration()
				.getProcessDiagramGenerator()
				.generateDiagram(bpmnModel, "png", activeActivityIds,
						Collections.<String> emptyList(), "黑体", "黑体",
						Thread.currentThread().getContextClassLoader(), 1.0d);
	}

	public void deleteDefinition(String deployId) {
		repositoryService.deleteDeployment(deployId);
	}

	public void deleteDefinitionAll(String deployId) {
		repositoryService.deleteDeployment(deployId, true);
	}

	/**
	 * 返回流程审批意见历史
	 * 
	 * @param businessId
	 * @return
	 * @throws Exception
	 */
	public List<ExtProcessOpinion> findProcessHistoryOpinions(String businessId)
			throws Exception {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		List<ExtProcessOpinion> lists = new ArrayList<ExtProcessOpinion>();
					String queryStr=("select id_,act_name_,u.tlr_name||'('||i.assignee_||')' as assignee_,start_time_,end_time_ from act_hi_actinst i left join tlr_info u on i.ASSIGNEE_=u.TLRNO "
						+ " where i.PROC_INST_ID_=(select max(PROC_INST_ID_) from act_hi_actinst where "
						+ " task_id_ in (select id_ from ACT_HI_TASKINST where proc_inst_id_ in ( select proc_inst_id_ from ACT_HI_PROCINST where "
						+ " business_key_='"
						+ businessId
						+ "'))) and i.END_TIME_ is not null "
						+ " and EXISTS (select t.id_ from ACT_HI_TASKINST t where t.TASK_DEF_KEY_=i.act_id_ and t.delete_reason_<>'deleted') order by end_time_ desc");
		Iterator it = rootDao.queryBySQL(queryStr);
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			Map<String, String> m = findApprovalOpinion(obj[0].toString(),
					rootDao);
			ExtProcessOpinion extProcessOpinion = new ExtProcessOpinion();
			extProcessOpinion.setTaskName(obj[1].toString());
			extProcessOpinion.setAssignee(obj[2] != null ? obj[2].toString()
					: "");
			extProcessOpinion.setOpinion(m.get("opinion"));
			extProcessOpinion.setStartTime(obj[3] != null ? simple
					.format(simple.parse(obj[3].toString())) : "");
			extProcessOpinion.setEndTime(obj[4] != null ? simple.format(simple
					.parse(obj[4].toString())) : "");
			extProcessOpinion.setOperation(m.get("operation"));
			lists.add(extProcessOpinion);
		}
		return lists;
	}

	@SuppressWarnings("rawtypes")
	public Map<String, String> findApprovalOpinion(String actInstId,
			ROOTDAO rootDao) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		Iterator it = rootDao
				.queryBySQL("select name_,text_ from act_hi_detail where act_inst_id_='"
						+ actInstId + "' ");
		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			map.put(obj[0].toString(), obj[1] != null ? obj[1].toString() : "");
		}
		return map;
	}

	public Map<String, Object> processDefinition(int start, int end) {
		List<ProcessDefinition> definitions = repositoryService
				.createProcessDefinitionQuery().latestVersion().list();
		Long count = repositoryService.createProcessDefinitionQuery()
				.latestVersion().count();
		Map<String, Object> result = new HashMap<String, Object>();
		List<ExtProcessDefinition> data = new ArrayList<ExtProcessDefinition>();

		for (ProcessDefinition p : definitions) {
			ExtProcessDefinition p1 = new ExtProcessDefinition();
			BeanUtils.copyProperties(p, p1);
			data.add(p1);
		}
		// definitions = null;
		result.put("count", count);
		result.put("data", data);
		return result;
	}

	/**
	 * 流程定义历史
	 * 
	 * @param processDefinitionKey
	 * @param start
	 * @param end
	 * @return
	 */
	public Map<String, Object> processDefinitionHistory(
			String processDefinitionKey, int start, int end) {
		List<ProcessDefinition> definitions = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionKey(processDefinitionKey)
				.orderByProcessDefinitionVersion().desc().listPage(start, end);
		Long count = repositoryService.createProcessDefinitionQuery()
				.processDefinitionKey(processDefinitionKey).count();
		Map<String, Object> result = new HashMap<String, Object>();
		List<ExtProcessDefinition> data = new ArrayList<ExtProcessDefinition>();
		BeanUtils.copyProperties(definitions, data);
		definitions = null;
		result.put("count", count);
		result.put("data", data);
		return result;
	}

	/**
	 * 启动流程
	 * 
	 * @param businessKey
	 * @param processDefinitionKey
	 * @param userId
	 * @param variables
	 */
	public void startProcess(String businessKey, String processDefinitionKey,
			String userId, Map<String, Object> variables) {
		if (!variables.containsKey("user")) {// 发送用户(默认)
			variables.put("user", userId);
		}
		processEngine.getIdentityService().setAuthenticatedUserId(userId);
		runtimeService.startProcessInstanceByKey(processDefinitionKey,
				businessKey, variables);
	}

	/**
	 * 领取任务
	 * 
	 * @param taskId
	 * @param userId
	 */
	public void claimTask(String taskId, String userId) {
		TaskService taskService = processEngine.getTaskService();
		taskService.claim(taskId, userId);
	}

	/**
	 * 分配代理人
	 * 
	 * @param taskId
	 * @param userId
	 */
	public void proxyTask(String taskId, String userId) {
		taskService.setAssignee(taskId, userId);
	}

	/**
	 * 所有流程实例
	 * 
	 * @param processDefinitionKey
	 * @param start
	 * @param end
	 * @return
	 */
	public Map<String, Object> processInstanceList(String processDefinitionKey,
			String processName, String businessKey, String assignee,
			String brName, int start, int pageSize) {
		StringBuilder sbf = new StringBuilder(
				"select "
						+ "t1.PROC_INST_ID_ as id, "
						+ "t1.PROC_DEF_ID_ as processDefinitionId, "
						+ "t2.NAME_ as processName, "
						+ "t1.BUSINESS_KEY_ as businessKey, "
						+ "t3.ASSIGNEE_ as assignee, "
						+ "t4.START_USER_ID_ as startUserId, "
						+ "t4.START_TIME_ as startTime, "
						+ "t4.END_TIME_ as endTime, "
						+ "t4.DURATION_ as durationInMillis, "
						+ "t1.SUSPENSION_STATE_ as status, "
						+ "t4.START_ACT_ID_ as startActivityId, "
						+ "t3.DUE_DATE_ as dueDate, "
						+ "t6.BRNAME as brName, "
						+ "case when t1.SUSPENSION_STATE_='1' then '正常' else  '挂起' end as statusDesc,"
						+ "row_number() over(order by t4.START_TIME_ desc,t2.name_ desc) as rnum "
						+ "from ACT_RU_EXECUTION t1 join ACT_RE_PROCDEF t2 on "
						+ "t1.PROC_DEF_ID_=t2.id_ "
						+ "join ACT_RU_TASK t3 on t3.PROC_INST_ID_=t1.PROC_INST_ID_ "
						+ "join ACT_HI_PROCINST t4 on t4.PROC_INST_ID_=t1.ID_ "
						+ "join TLR_INFO t5 on t5.TLRNO=t3.ASSIGNEE_ "
						+ "join BCTL t6 on t6.BRCODE=t5.BRCODE "
						+ "where t1.BUSINESS_KEY_ is not null");
		if (!StringUtils.isBlank(businessKey)) {
			sbf.append(" and t1.BUSINESS_KEY_='" + businessKey + "' ");
		}
		if (!StringUtils.isBlank(processDefinitionKey)) {
			sbf.append(" and t2.KEY_  like '%" + processDefinitionKey + "%' ");
		}
		if (!StringUtils.isBlank(processName)) {
			sbf.append(" and t2.NAME_ like '%" + processName + "%' ");
		}
		if (!StringUtils.isBlank(assignee)) {
			sbf.append(" and t3.ASSIGNEE_ like '%" + assignee + "%' ");
		}
		if (!StringUtils.isBlank(brName)) {
			sbf.append(" and t6.BRNAME like '%" + brName + "%' ");
		}
		StringBuilder cot = new StringBuilder(sbf);
		sbf.insert(0, " select t.* from (").append(") t ")
				.append("where t.rnum>" + start + " ")
				.append("fetch first " + pageSize + " rows only ");

		List<ExtHistoricProcessInstance> list = CommonService.getInstance()
				.findSqlListBySpringJdbc(sbf.toString(),
						ExtHistoricProcessInstance.class);
		Long count = (Long) CommonService.getInstance().findSqlOneBySpringJdbc(
				"select count(*) from (" + cot.toString() + " ) ", Long.class);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("count", count);
		result.put("data", list);

		return result;
	}

	public void deleteProcessInstance(String processInstanceId) throws CommonException {
		ProcessInstance pi=runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		if(pi.getProcessDefinitionKey().substring(0,2).equals("PL")){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			if(StringUtils.isNotEmpty(pi.getBusinessKey())){
				CommonService.getInstance().executeSQL("update t_pl_task set COMPLETE_DATE=to_date('"+sdf.format(new Date())+"','YYYY-MM-DD') where FD_ID='"+pi.getBusinessKey()+"' ");
			}
		}
		runtimeService.deleteProcessInstance(processInstanceId, "deleteAdmin");
	}

	public void deleteProcessInstance(String processInstanceId, String reason) {
		if (StringUtils.isNotBlank(reason)) {
			reason = "deleteAdmin";
		}
		runtimeService.deleteProcessInstance(processInstanceId, reason);
	}

	public void deleteProcessInstanceAll(String processInstanceId) {
		runtimeService.deleteProcessInstance(processInstanceId, "");
		historyService.createHistoricProcessInstanceQuery()
				.processInstanceId(processInstanceId).deleted();
	}

	/**
	 * 挂起或激活流程实例
	 * 
	 * @param procInstanceId
	 */
	public void supOrActProcInstance(String procInstanceId, String status) {
		if (status.equals("2")) {
			processEngine.getRuntimeService().activateProcessInstanceById(
					procInstanceId);
		} else {
			processEngine.getRuntimeService().suspendProcessInstanceById(
					procInstanceId);
		}
	}

	/**
	 * 用户的任务
	 * 
	 * @param userId
	 * @param start
	 * @param end
	 * @return
	 */
	public Map<String, Object> userTaskList(String userId, int start, int end) {
		List<Task> tasks = taskService.createTaskQuery()
				.taskCandidateUser(userId).desc().orderByTaskCreateTime()
				.listPage(start, end);
		Long count = taskService.createTaskQuery().taskCandidateUser(userId)
				.count();
		List<ExtTask> list = new ArrayList<ExtTask>();
		for (Task task : tasks) {
			ExtTask extTask = new ExtTask();
			BeanUtils.copyProperties(task, extTask);
			list.add(extTask);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("count", count);
		result.put("data", list);
		return result;
	}

	/**
	 * 用户组的任务
	 * 
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 */
	public Map<String, Object> groupTaskList(String groupId, int start, int end) {
		List<Task> tasks = taskService.createTaskQuery()
				.taskCandidateGroup(groupId).desc().orderByTaskCreateTime()
				.listPage(start, end);
		Long count = taskService.createTaskQuery().taskCandidateUser(groupId)
				.count();
		List<ExtTask> list = new ArrayList<ExtTask>();
		for (Task task : tasks) {
			ExtTask extTask = new ExtTask();
			BeanUtils.copyProperties(task, extTask);
			list.add(extTask);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("count", count);
		result.put("data", list);
		return result;
	}

	/**
	 * 我发起的流程,未完成
	 * 
	 * @param userId
	 * @param start
	 * @param end
	 * @return
	 */
	public Map<String, Object> myStartTaskList(String userId, int start, int end) {
		List<HistoricProcessInstance> processInstances = historyService
				.createHistoricProcessInstanceQuery().startedBy(userId)
				.unfinished().orderByProcessInstanceStartTime().desc()
				.listPage(start, end);
		Long count = historyService.createHistoricProcessInstanceQuery()
				.startedBy(userId).unfinished().count();
		List<ExtHistoricProcessInstance> list = new ArrayList<ExtHistoricProcessInstance>();
		for (HistoricProcessInstance pi : processInstances) {
			ExtHistoricProcessInstance h = new ExtHistoricProcessInstance();
			BeanUtils.copyProperties(pi, h);
			list.add(h);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("count", count);
		result.put("data", list);
		return result;
	}

	/**
	 * 完成任务
	 * 
	 * @param map
	 * @param taskId
	 */
	public void taskComplete(Map<String, Object> map, String taskId) {
		processEngine.getTaskService().complete(taskId, map);
	}

	/**
	 * 根据业务ID及用户查找任务ID
	 * 
	 * @param businessId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findTaskId(String businessId, String userId) throws Exception {
		String sql = "select id_ from act_ru_task where proc_inst_id_=(select proc_inst_id_ from ACT_RU_EXECUTION where BUSINESS_KEY_='"
				+ businessId + "') and assignee_='" + userId + "'";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		String taskId = "";
		while (it.hasNext()) {
			taskId = (String) it.next();
		}
		return taskId;
	}

	/**
	 * 根据角色ID查询所有用户(查出结果后随机取一个用户)
	 * 
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<String> findUserId(String roleId) throws Exception {
		String sql = "select tlrno from T_USER_ORGROLE_REL where F_ROLE_ID='" + roleId
				+ "'";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		List<String> list = new ArrayList<String>();
		while (it.hasNext()) {
			String tlrNo = (String) it.next();
			list.add(tlrNo);
		}
		// 随机取一个用户
		int i = (int) (Math.random() * (list.size()));
		List<String> returnList = new ArrayList<String>();
		if (list.size() > 0) {
			returnList.add(list.get(i));
		}
		return returnList;
	}

	/**
	 * 根据角色及机构ID查询所有用户ID(查出结果后随机取一个用户)
	 * 
	 * @param roleId
	 * @param orgId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<String> findUserIdByRoleidAndOrgid(String roleId, String orgId)
			throws Exception {
		String sql = "select F_USER_ID from T_USER_ORGROLE_REL where F_ROLE_ID='"+roleId+"' and F_ORG_ID='"+orgId+"'";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		List<String> list = new ArrayList<String>();
		while (it.hasNext()) {
			String tlrNo = (String) it.next();
			list.add(tlrNo);
		}
		// 随机取一个用户
		int i = (int) (Math.random() * (list.size()));
		List<String> returnList = new ArrayList<String>();
		if (list.size() > 0) {
			returnList.add(list.get(i));
		}
		return returnList;
	}

	/**
	 * 根据角色ID及机构ID查询当前机构和上级机构用户ID(查出结果后随机取一个用户)
	 * 
	 * @param roleId
	 * @param orgId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<String> findUserIdByRoleidAndCurrOrgid(String roleId,
			String orgId) throws Exception {
		Bctl bctl = BctlService.getInstance().getBctlByBrcode(orgId);
		if (bctl.getBrclass().equals("3")) {
			String sql = "select F_USER_ID from T_USER_ORGROLE_REL where F_ROLE_ID='"+roleId+"' and (F_ORG_ID='"+orgId+"' or F_ORG_ID='"+bctl.getBlnUpBrcode()+"')";
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			Iterator it = rootdao.queryBySQL(sql);
			List<String> list = new ArrayList<String>();
			while (it.hasNext()) {
				String tlrNo = (String) it.next();
				list.add(tlrNo);
			}
			// 随机取一个用户
			int i = (int) (Math.random() * (list.size()));
			List<String> returnList = new ArrayList<String>();
			if (list.size() > 0) {
				returnList.add(list.get(i));
			}
			return returnList;
		} else if (bctl.getBrclass().equals("2")) {
			String sql = "select F_USER_ID from T_USER_ORGROLE_REL where F_ROLE_ID='"+roleId+"' and (F_ORG_ID='"+orgId+"' or F_ORG_ID='"+bctl.getBlnUpBrcode()+"')";
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			Iterator it = rootdao.queryBySQL(sql);
			List<String> list = new ArrayList<String>();
			while (it.hasNext()) {
				String tlrNo = (String) it.next();
				list.add(tlrNo);
			}
			// 随机取一个用户
			int i = (int) (Math.random() * (list.size()));
			List<String> returnList = new ArrayList<String>();
			if (list.size() > 0) {
				returnList.add(list.get(i));
			}
			return returnList;
		} else {
			return findUserIdByRoleidAndOrgid(roleId, orgId);
		}
	}

	/**
	 * 根据用户ID查询所有业务ID
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findBusinessKey(String userId) throws Exception {
		String sql = "select business_key_ from act_ru_execution where PROC_INST_ID_ in( "
				+ " select proc_inst_id_ from act_ru_task where ASSIGNEE_='"
				+ userId + "') and business_key_ is not null";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		String busins = "";
		while (it.hasNext()) {
			String id = (String) it.next();
			busins = busins + "'" + id + "',";
		}
		if (StringUtils.isNotEmpty(busins)) {
			busins = busins.substring(0, busins.length() - 1);
		}
		return busins;
	}

	/**
	 * 根据用户参与过流程的所有业务ID
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findBusinessKeyByMySelf(String userId)throws Exception{
		String sql="SELECT t1.BUSINESS_KEY_  FROM ACT_HI_PROCINST t1  WHERE EXISTS (SELECT 1  FROM act_hi_taskinst t2 WHERE t2.ASSIGNEE_='"+userId+"' "
				+ "AND (t2.delete_reason_='completed' OR t2.delete_reason_ IS NULL) AND t1.PROC_INST_ID_=t2.PROC_INST_ID_ )";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it=rootdao.queryBySQL(sql);
		String busins="";
		while(it.hasNext()){
			String id=(String) it.next();
			busins=busins+"'"+id+"',";
		}
		if(StringUtils.isNotEmpty(busins)){
			busins=busins.substring(0,busins.length()-1);
		}
		return busins;
	}
	
	/**
	 * 根据用户ID查询所有业务ID (分页查询)
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findBusinessKey(String userId, int pageSize, int pageIndex)
			throws Exception {
		String start = "";
		String end = "";
		int start1 = (pageIndex - 1) * pageSize;
		int end1 = pageIndex * pageSize;
		start = String.valueOf(start1);
		end = String.valueOf(end1);
		String sql = " select business_key_ from (  select ROW_NUMBER() OVER(ORDER BY business_key_ DESC) AS ROW_NUM , business_key_ from act_ru_execution where PROC_INST_ID_ in( "
				+ " select proc_inst_id_ from act_ru_task where ASSIGNEE_='"
				+ userId
				+ "') and business_key_ is not null ) where ROW_NUM>"
				+ start + " AND ROW_NUM<=" + end;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		String busins = "";
		while (it.hasNext()) {
			String id = (String) it.next();
			busins = busins + "'" + id + "',";
		}
		if (StringUtils.isNotEmpty(busins)) {
			busins = busins.substring(0, busins.length() - 1);
		}
		return busins;
	}

	/**
	 * 根据用户ID查询所有业务ID 返回查询SQL
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public String findBusinessKeySql(String userId) throws Exception {
		String sql = "select business_key_ from act_ru_execution where PROC_INST_ID_ in( "
				+ " select proc_inst_id_ from act_ru_task where ASSIGNEE_='"
				+ userId + "') and business_key_ is not null";

		return sql;
	}

	/**
	 * 根据用户ID 集合（string字符串） 查询所有业务ID
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findBusinessKeyByUserIds(String userIds) throws Exception {
		String sql = "select business_key_ from act_ru_execution where PROC_INST_ID_ in( "
				+ " select proc_inst_id_ from act_ru_task where ASSIGNEE_ in ("
				+ userIds + ") ) and business_key_ is not null";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		String busins = "";
		while (it.hasNext()) {
			String id = (String) it.next();
			busins = busins + "'" + id + "',";
		}
		if (StringUtils.isNotEmpty(busins)) {
			busins = busins.substring(0, busins.length() - 1);
		}
		return busins;
	}

	/**
	 * 根据用户ID 集合（string字符串） 查询所有业务ID (分页查询)
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findBusinessKeyByUserIds(String userIds, int pageSize,
			int pageIndex) throws Exception {
		String start = "";
		String end = "";
		int start1 = (pageIndex - 1) * pageSize;
		int end1 = pageIndex * pageSize;
		start = String.valueOf(start1);
		end = String.valueOf(end1);
		String sql = "select business_key_ from (   select ROW_NUMBER() OVER(ORDER BY business_key_ DESC) AS ROW_NUM , business_key_ from act_ru_execution where PROC_INST_ID_ in( "
				+ " select proc_inst_id_ from act_ru_task where ASSIGNEE_ in ("
				+ userIds
				+ ") ) and business_key_ is not null ) where ROW_NUM>"
				+ start
				+ " AND ROW_NUM<=" + end;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		String busins = "";
		while (it.hasNext()) {
			String id = (String) it.next();
			busins = busins + "'" + id + "',";
		}
		if (StringUtils.isNotEmpty(busins)) {
			busins = busins.substring(0, busins.length() - 1);
		}
		return busins;
	}

	/**
	 * 根据用户ID 集合（string字符串） 查询所有业务ID 返回sql
	 * 
	 * @param userId
	 * @return Sql
	 * @throws Exception
	 */
	public String findBusinessKeyByUserIdsSql(String userIds) throws Exception {
		String sql = "select business_key_ from act_ru_execution where PROC_INST_ID_ in( "
				+ " select proc_inst_id_ from act_ru_task where ASSIGNEE_ in ("
				+ userIds + ") ) and business_key_ is not null";

		return sql;
	}

	/**
	 * 根据用户ID 集合（string字符串） 查询该用户已走完所在节点所有业务ID
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findPassBusinessKeyByUserIds(String userId) throws Exception {
		String sql = "select BUSINESS_KEY_ from ACT_HI_PROCINST  where ID_ in( "
				+ " select PROC_INST_ID_ from act_hi_taskinst "
				+ " where assignee_='"
				+ userId
				+ "' "
				+ " and delete_reason_='completed') "
				+ "   and business_key_ is not null";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		String busins = "";
		while (it.hasNext()) {
			String id = (String) it.next();
			busins = busins + "'" + id + "',";
		}
		if (StringUtils.isNotEmpty(busins)) {
			busins = busins.substring(0, busins.length() - 1);
		}
		return busins;
	}

	/**
	 * 根据用户ID 集合（string字符串） 查询该用户已走完所在节点所有业务ID （分页查询）
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findPassBusinessKeyByUserIds(String userId, int pageSize,
			int pageIndex) throws Exception {
		String start = "";
		String end = "";
		int start1 = (pageIndex - 1) * pageSize;
		int end1 = pageIndex * pageSize;
		start = String.valueOf(start1);
		end = String.valueOf(end1);
		String sql = "select business_key_ from (   select ROW_NUMBER() OVER(ORDER BY business_key_ DESC) AS ROW_NUM , BUSINESS_KEY_ from ACT_HI_PROCINST  where ID_ in( "
				+ " select PROC_INST_ID_ from act_hi_taskinst "
				+ " where assignee_='"
				+ userId
				+ "' "
				+ " and delete_reason_='completed') "
				+ "   and business_key_ is not null ) where ROW_NUM>"
				+ start
				+ " AND ROW_NUM<=" + end;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		String busins = "";
		while (it.hasNext()) {
			String id = (String) it.next();
			busins = busins + "'" + id + "',";
		}
		if (StringUtils.isNotEmpty(busins)) {
			busins = busins.substring(0, busins.length() - 1);
		}
		return busins;
	}

	/**
	 * 根据用户ID 集合（string字符串） 查询该用户已走完所在节点所有业务ID 返回sql
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public String findPassBusinessKeyByUserIdsSql(String userId)
			throws Exception {
		String sql = "select BUSINESS_KEY_ from ACT_HI_PROCINST  where ID_ in( "
				+ " select PROC_INST_ID_ from act_hi_taskinst "
				+ " where assignee_='"
				+ userId
				+ "' "
				+ " and delete_reason_='completed') "
				+ "   and business_key_ is not null";

		return sql;
	}

	/**
	 * 判断流程是否结束
	 * @param businessKey 业务编号
	 * @return
	 */
	public boolean taskIsCompile(String businessKey){
		Integer count=(Integer) CommonService.getInstance().findSqlOneBySpringJdbc("select count(1) from "
				+ "	ACT_RU_EXECUTION t where t.BUSINESS_KEY_='"+businessKey+"'", Integer.class);
		if(count==0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 根据业务ID查找任务变量
	 * 
	 * @param businessKey
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> findTaskVariable(String businessKey) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			List<Task> list = ProcessManagerService.getInstace()
					.getTaskService().createTaskQuery()
					.processInstanceBusinessKey(businessKey).list();
			String taskId = "";
			if (null != list && list.size() > 0) {
				taskId = list.get(0).getId();
			}
			if (StringUtils.isNotEmpty(taskId)) {
				TaskFormData formData = ProcessManagerService.getInstace().processEngine
						.getFormService().getTaskFormData(taskId);
				List<FormProperty> formPropertyList = formData
						.getFormProperties();
				for (FormProperty f : formPropertyList) {
					map.put(f.getId(), f.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 根据账号ID 查找任务变量
	 * 
	 * @param businessKey
	 * @return
	 * @throws Exception
	 */
	public Boolean isProcessingByAccid(String accId, String ruleCode,
			String trigId) {
		boolean isTrue=false;
		try {
			String businessKey ="";
			String sql="SELECT L.FD_ID AS businessKey FROM T_PL_TASK L ,T_PL_TASK_RULE_TRIG T  WHERE L.LOAN_ACCT=T.FD_ACC_ID AND L.RPT_STATUS<>'7' ";
			if(accId!=null&&StringUtils.isNoneBlank(accId)){
				sql=sql +" AND L.LOAN_ACCT='"+accId+"'  ";
			}
			if(trigId!=null&&StringUtils.isNoneBlank(trigId)){
				sql=sql+ " AND T.FD_ID='"+trigId+"' ";
			}
			JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
			List<Map<String, Object>>  listM= jdbcTemplate.queryForList(sql);
			if(listM.size()>0){
				Map<String, Object> map1=listM.get(0);
				businessKey=(String) map1.get("businessKey");
			}
			List<Task> list=ProcessManagerService.getInstace().getTaskService().createTaskQuery().processInstanceBusinessKey(businessKey).list();
			if(null!=list && list.size()>0){
				isTrue=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isTrue;
	}

	/**
	 * 根据业务ID获取上一节点人账号
	 * 
	 * @param businessId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findTopUserId(String businessId) throws Exception {
		String sql = "select t.assignee_ from ACT_HI_TASKINST  t where t.proc_inst_id_=(select max(proc_inst_id_) from ACT_HI_PROCINST where BUSINESS_KEY_='"
				+ businessId
				+ "')"
				+ "and t.end_time_ is not null and t.delete_reason_='completed' order by t.end_time_ desc fetch first 1 rows only";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		List<String> list = new ArrayList<String>();
		while (it.hasNext()) {
			String tlrNo = (String) it.next();
			list.add(tlrNo);
		}
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	/**
	 * 根据业务ID获取上一节点人账号
	 * 
	 * @param businessId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String findTopUserIdByBussinessIdAndRolId(String businessId,String nowRoleStr) throws Exception {
		
		String roleId="R601_1";
		if("khjlzg".equals(nowRoleStr)){
			roleId="R601_1";
		}else if("fhfxjc".equals(nowRoleStr)){
			roleId="R602_1";
		}else if("fhfxjczg".equals(nowRoleStr)){
			roleId="R603_1";
		}else if("zhfxjc".equals(nowRoleStr)){
			roleId="R561_1";
		}else if("zhfxjczg".equals(nowRoleStr)){
			roleId="R560_1";
		}
		String sql = "select t.assignee_ from ACT_HI_TASKINST  t where t.proc_inst_id_=(select max(proc_inst_id_) from ACT_HI_PROCINST where BUSINESS_KEY_='"
				+ businessId
				+ "')"
				+ "and t.end_time_ is not null and t.delete_reason_='completed' and t.task_def_key_='"+roleId+"' order by t.end_time_ desc fetch first 1 rows only";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		List<String> list = new ArrayList<String>();
		while (it.hasNext()) {
			String tlrNo = (String) it.next();
			list.add(tlrNo);
		}
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 根据业务ID查找运行中流程
	 * 
	 * @param businessKey
	 */
	public String findRuningTaskByBusinessKey(String businessKey) {
		List<ProcessInstance> list = ProcessManagerService.getInstace().runtimeService
				.createProcessInstanceQuery()
				.processInstanceBusinessKey(businessKey).list();
		if (null != list && list.size() > 0) {
			return "true";
		}
		return "false";
	}

	/**
	 * 根据业务ID查找运行中流程
	 * 
	 * @param businessKey
	 */
	public String findRuningTaskIdByBusinessKey(String businessKey) {
		List<Task> list = ProcessManagerService.getInstace().getTaskService()
				.createTaskQuery().processInstanceBusinessKey(businessKey)
				.list();
		String taskId = "";
		if (null != list && list.size() > 0) {
			taskId = list.get(0).getId();
		}
		return taskId;
	}

	/**
	 * 根据业务ID查询业务是否完成
	 * 
	 * @param businessId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public boolean findTaskIsOver(String businessId) throws Exception {
		String sql = "select id_ from ACT_RU_EXECUTION where BUSINESS_KEY_='"
				+ businessId + "'";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		String taskId = "";
		while (it.hasNext()) {
			taskId = (String) it.next();
		}
		if (taskId == "" || taskId == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据用户ID查找机构信息
	 * 
	 * @param userId
	 */
	public Map<String, String> findOrgInfoByUserId(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			TlrInfo tlr = TlrInfoService.getInstance()
					.getTlrInfoByTlrno(userId);
			Bctl bctl = BctlService.getInstance().getBctlByBrcode(
					tlr.getBrcode());
			map.put("orgId", bctl.getBrcode());
			map.put("orgName", bctl.getBrname());
			map.put("orgLevel", bctl.getBrclass());
			map.put("userName", tlr.getTlrName());
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 根据多个用户，查找用户姓名、机构等信息,并拼接成字符串返回。
	 * 
	 * @param userId
	 */
	public String findOrgInfoByUserIds(String userIds) {
		String str = "";
		try {
			if (userIds.indexOf(",") > -1) {
				String[] ids = userIds.split(",");
				for (String id : ids) {
					TlrInfo tlr = TlrInfoService.getInstance()
							.getTlrInfoByTlrno(id);
					Bctl bctl = BctlService.getInstance().getBctlByBrcode(
							tlr.getBrcode());
					str = str + bctl.getBrcode() + "," + tlr.getTlrName() + ","
							+ tlr.getTlrno() + ";";
				}
			} else {
				TlrInfo tlr = TlrInfoService.getInstance().getTlrInfoByTlrno(
						userIds);
				Bctl bctl = BctlService.getInstance().getBctlByBrcode(
						tlr.getBrcode());
				str = str + bctl.getBrcode() + "," + tlr.getTlrName() + ","
						+ tlr.getTlrno() + ";";
			}
			if (StringUtils.isNotEmpty(str)) {
				str = str.substring(0, str.length() - 1);
			}
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return
	 */
	public Date getSystemCurrentDate(Integer day) {
		if (null == day) {
			return new Date();
		} else {
			return DateUtils.addDay(new Date(), day);
		}
	}
	
	/**
	 * 根据用户查找当前登录的角色
	 * @param userId
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("rawtypes")
	public String dwrGetUserCurrentRoleId(String userId) throws CommonException{
		String sql = "select roleid from tlr_info where tlrno='"+userId+"'";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it = rootdao.queryBySQL(sql);
		Integer roleId=0;
		if (it.hasNext()) {
			roleId = (Integer) it.next();
		}
		return roleId.toString();
	}

	/**
	 * 更新岗位
	 * 
	 * @param rid
	 *            角色ID
	 * @param url
	 *            角色页面路径
	 * @param funcs
	 *            功能权限
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int updateRoleFunc(String rid, String url, String roleSysType,
			String funcs) {
		Hashtable oldfuncs = new Hashtable();
		Hashtable newfuncs = new Hashtable();
		RoleFuncRelDAO rfrd = DAOUtils.getRoleFuncRelDAO();
		RoleInfo roleInfo = DAOUtils.getRoleInfoDAO().findById(
				Integer.valueOf(rid));
		roleInfo.setFucUrl(url);
		roleInfo.setRoleSysType(roleSysType);
		try {
			DAOUtils.getRoleInfoDAO().update(roleInfo);
		} catch (CommonException e) {
			throw new RuntimeException(e);
		}
		List rfuncs = rfrd.findByRoleid(Integer.valueOf(Integer.parseInt(rid)));

		Iterator it = rfuncs.iterator();
		while (it.hasNext()) {
			RoleFuncRel rfr = (RoleFuncRel) it.next();
			oldfuncs.put(rfr.getFuncid().toString(), rfr);
		}

		StringTokenizer st = new StringTokenizer(funcs, ",");
		while (st.hasMoreTokens()) {
			String fid = st.nextToken();
			if (!newfuncs.containsKey(fid)) {
				newfuncs.put(fid, fid);
			}
		}
		Iterator itnew = newfuncs.keySet().iterator();
		while (itnew.hasNext()) {
			String newfid = (String) itnew.next();
			if (oldfuncs.containsKey(newfid)) {
				oldfuncs.remove(newfid);
			} else {
				RoleFuncRel newrfr = new RoleFuncRel();
				newrfr.setFuncid(newfid);
				newrfr.setRoleId(Integer.valueOf(Integer.parseInt(rid)));
				rfrd.save(newrfr);
			}
		}
		Enumeration en = oldfuncs.keys();
		while (en.hasMoreElements()) {
			Object key_num = en.nextElement();
			RoleFuncRel oldrfr = (RoleFuncRel) oldfuncs.get(key_num);
			rfrd.delete(oldrfr);
		}

		return 0;
	}

	/**
	 * 根据帐户ID查找检查责任人ID
	 * 
	 * @param accountId
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public String findCheckDutyUserId(String accountId) throws CommonException {
		TLoanAccountRelDuty relDuty = new TLoanAccountRelDuty();
		relDuty = TLoanAccountRelDutyService.getInstance().get(accountId);
		String dutyId = null;
		if (relDuty == null) {
			CommonService service = CommonService.getInstance();
			String actSql = "select * from t_edw_pls_account where loanacno='"
					+ accountId + "' ";
			List<TEdwPlsAccount> actList = service.queryListSql(actSql,
					TEdwPlsAccount.class);
			dutyId = actList.get(0).getDutyid();
		} else {
			dutyId = relDuty.getDutyid();
		}
		return dutyId;
	}

	/**
	 * 根据帐户ID查找 处罚预警的账号相关信息
	 * 
	 * @param accountId
	 * @return
	 * @throws CommonException
	 */
	public TPlTaskRuleTrigInfo findTPlTrigInfo(String accountId)
			throws CommonException {
		TPlTaskRuleTrigInfo trigInfo = new TPlTaskRuleTrigInfo();

		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");

		String actSql = "SELECT * FROM T_PL_TASK_RULE_TRIG_INFO_V WHERE FD_ACC_ID='"
				+ accountId + "' ";
		List<TPlTaskRuleTrigInfo> actList = jdbcTemplate.query(actSql,
				BeanPropertyRowMapper.newInstance(TPlTaskRuleTrigInfo.class));
		if (actList.size() > 0) {
			trigInfo = actList.get(0);
		}

		return trigInfo;
	}

	/**
	 * 查询当前用户机构下的岗位
	 * 
	 * @param userId
	 * @param orgId
	 * @return
	 */
	public List<RoleInfo> getUserRoleByOrgId(String userId, String orgId) {
		return UserMgrService.getInstance().getUserRoleByOrgId(userId, orgId);
	}

	public List<Map<String, String>> getUserRoleByOrgIdMap(String userId,
			String orgId) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		List<RoleInfo> rls = UserMgrService.getInstance().getUserRoleByOrgId(
				userId, orgId);
		if (rls != null && !rls.isEmpty()) {
			for (RoleInfo info : rls) {
				Map<String, String> m = new HashMap<String, String>();
				m.put("roleId", String.valueOf(info.getId()));
				m.put("roleName", info.getRoleName());
				list.add(m);
			}
		}
		return list;
	}

	public Map<String, List<String>> getUserAllOrg(String userId){
		List<Map<String,Object>>   rols= UserMgrService.getInstance().getUserAllOrg(userId);
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		for(Map<String,Object> rel:rols){
			String orgId=rel.get("BR_NO").toString();
			String roleId=rel.get("ROLE_ID").toString();
			if(!map.containsKey(orgId)){
				List<String> my=new ArrayList<String>();
				my.add(roleId);
				map.put(orgId, my);
			}else{
				map.get(orgId).add(roleId);
			}
		}
		return map;
	}
	public void printDig(int n){
		System.out.println(n);
	}
	public void printOut(int n){
		if(n<0){
			System.out.println("请输入非负整数");
			return;
		}
			printOut(n-100);
		printDig(n);
	}
	public static void main(String[] args){
		ProcessManagerService pms=new ProcessManagerService();
		pms.printOut(2802);
	}
}
