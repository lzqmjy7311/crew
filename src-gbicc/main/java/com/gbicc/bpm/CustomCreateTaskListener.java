package com.gbicc.bpm;

import java.util.Iterator;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;

import com.gbicc.bpm.service.ProcessManagerService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;

/**
 * 创建任务监听器
 * @date    2016年1月18日
 * @author  tangdu
 * @desc
 */
public class CustomCreateTaskListener implements TaskListener {
	private static final long serialVersionUID = 778346114733476743L;
	public static final String CUSTMNG_TASK_DEF_KEY = "R222_1";// 客户经理第一个节点定义KEY。
	public static final String CUSTMNG_TASK_DEF_KEY2 = "R222_2";// 客户经理第二个节点定义KEY。

	public static final String SINGCUST_TASK_DEF_KEY = "R601_1";// 单客户客户经理第一个节点定义KEY。
	public static final String SINGCUST_TASK_DEF_KEY2 = "R601_2";// 单客户客户经理第一个节点定义KEY。
	public static final String SINGLERULE_WARNING_KEY = "R560_1";// 单规则客户经理第一个节点定义KEY
	public static final String SINGLERULE_WARNING_BRANCH_KEY = "R603_1";// 单规则客户经理第一个节点定义KEY

	@Override
	@SuppressWarnings("rawtypes")
	public void notify(DelegateTask task) {
		try {
			ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
			//2016-07-05，对私流程退回客户经理操作，由于对私贷后检查人转移功能需退回给任务表中的任务处理人
			if(task.getProcessDefinitionId().substring(0,2).equals("PL") && (task.getTaskDefinitionKey().equals(CUSTMNG_TASK_DEF_KEY) || task.getTaskDefinitionKey().equals(CUSTMNG_TASK_DEF_KEY2))){
				ProcessInstance pi=ProcessManagerService.getInstace().getRuntimeService().createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
				if(pi!=null){
					String sql="select handler from t_pl_task where fd_id='"+pi.getBusinessKey()+"' ";
					Iterator it=rootDao.queryBySQL(sql);
					if(it.hasNext()){
						String assignee=(String) it.next();
						if(assignee!=null){
							task.setAssignee(assignee);
						}
					}
				}
			}
			/*
			 * 任务退回后再次提交系统中的代码会随机发送给角色中的一个用户，
			 * 该监听器会先查找历史表中是否已经存在审批人，存在则更改。
			 * 2016-03-08【对私】及【单客户流程】已修改成任务发送时需要选择人，所有需要过滤。
			 */
			if(!(task.getProcessDefinitionId().substring(0,2).equals("PL")) && !(task.getProcessDefinitionId().indexOf("CM_CustWranDisposalProcess")>-1) && !(task.getProcessDefinitionId().indexOf("CM_SingleRuleWarning")>-1) && !(task.getProcessDefinitionId().indexOf("CM_SingleRuleCases")>-1)){
				String sql="select assignee_ from ACT_HI_TASKINST where proc_inst_id_='"+task.getProcessInstanceId()+"' "+ 
						" and task_def_key_='"+task.getTaskDefinitionKey()+"' order by end_time_ desc";
				Iterator it=rootDao.queryBySQL(sql);
				if(it.hasNext()){
					String assignee=(String) it.next();
					task.setAssignee(assignee);
				}
			}
			//2016年7月12日，对公任务转移后退回的任务需退回到转移后的用户手上。
			if(task.getProcessDefinitionId().indexOf("CM_CustWranDisposalProcess")>-1 && (task.getTaskDefinitionKey().equals(SINGCUST_TASK_DEF_KEY) || task.getTaskDefinitionKey().equals(SINGCUST_TASK_DEF_KEY2))){
				//查出来真正需要接收任务的人
				StringBuffer sql=new StringBuffer(
						"select assignee_ from ACT_HI_TASKINST where proc_inst_id_='"+task.getProcessInstanceId()+"' "+ 
						" and task_def_key_ in ('R601_1','R601_2') order by end_time_ desc ");
				Iterator it=rootDao.queryBySQL(sql.toString());
				if(it.hasNext()){
					String assignee=(String) it.next();
					task.setAssignee(assignee);
				}
			}else if(task.getProcessDefinitionId().indexOf("CM_SingleRuleWarning")>-1 &&(task.getTaskDefinitionKey().equals(SINGLERULE_WARNING_KEY)) ){
				//查出来真正需要接收任务的人
				StringBuffer sql=new StringBuffer(
						"select assignee_ from ACT_HI_TASKINST where proc_inst_id_='"+task.getProcessInstanceId()+"' "+ 
						" and task_def_key_ = 'R560_1' order by end_time_ desc ");
				Iterator it=rootDao.queryBySQL(sql.toString());
				if(it.hasNext()){
					String assignee=(String) it.next();
					task.setAssignee(assignee);
				}
			}else if(task.getProcessDefinitionId().indexOf("CM_SingleRuleWarningBranch")>-1 &&(task.getTaskDefinitionKey().equals(SINGLERULE_WARNING_BRANCH_KEY))){
				//查出来真正需要接收任务的人
				StringBuffer sql=new StringBuffer(
						"select assignee_ from ACT_HI_TASKINST where proc_inst_id_='"+task.getProcessInstanceId()+"' "+ 
						" and task_def_key_ = 'R603_1' order by end_time_ desc ");
				Iterator it=rootDao.queryBySQL(sql.toString());
				if(it.hasNext()){
					String assignee=(String) it.next();
					task.setAssignee(assignee);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
