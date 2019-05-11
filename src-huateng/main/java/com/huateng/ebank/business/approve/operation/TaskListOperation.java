package com.huateng.ebank.business.approve.operation;

import java.util.List;

import com.huateng.ebank.business.approve.service.TaskListService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TaskListOperation extends BaseOperation {
	/**
	 * @author jianxue.zhang
	 * op层for获取审批列表和审批操作
	 */

	public static final String ID = "TaskListOperation";
	public static final String CMD = "cmd";
	public static final String TYPE = "type";
	public static final String QUERYLIST = "querylist";
	public static final String TASKIDS = "taskids";
	public static final String INSERTLIST = "insert";
	public static final String UPDATELIST = "update";
	public static final String DELLIST = "del";
	public static final String SETLIST = "set";
	public static final String OTHERLIST = "other";
	public static final String APPRESULT = "approveResult";
	public static final String APPREMARK = "approveRemark";
	public static final String INTINSID = "intInsId";
	//public static final String CLASS = "class";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.
	 * ebank.framework.operation.OperationContext)
	 */
	@SuppressWarnings("unchecked")
	public void execute(OperationContext context) throws CommonException {
		TaskListService taskService=TaskListService.getInstance();
		if ("query".equals(context.getAttribute(CMD))) {
			context.setAttribute(QUERYLIST, taskService.getApproveListByTaskIds((String) context.getAttribute(TASKIDS), (String) context.getAttribute(TYPE)));
		} 
		else if("APPROVE".equals(context.getAttribute(CMD))){
			taskService.approveList((List) context.getAttribute(INSERTLIST), (List) context.getAttribute(UPDATELIST), (List) context.getAttribute(DELLIST), 
					(String) context.getAttribute(APPRESULT), 
					(String) context.getAttribute(APPREMARK), (String) context.getAttribute(INTINSID));
			
			
		}
		/*else if("APPROVE".equals(context.getAttribute(CMD))){
			taskService.approveListNew((Class) context.getAttribute(CLASS),(List) context.getAttribute(INSERTLIST), (List) context.getAttribute(UPDATELIST), (List) context.getAttribute(DELLIST) ,
					(String) context.getAttribute(APPRESULT), 
					(String) context.getAttribute(APPREMARK), (String) context.getAttribute(INTINSID));
			
			
		}*/
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng
	 * .ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}