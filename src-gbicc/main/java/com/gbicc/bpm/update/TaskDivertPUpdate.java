package com.gbicc.bpm.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.bpm.operation.TaskDivertPOperation;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TaskDivertPUpdate extends BaseUpdate{
	private static final String DATASET_ID="TlrInfoForZGRWZYGetter";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AppException {
		//
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		//parameters
		String currBrCode=updateResultBean.getParameter("currBrCode");
		String ids=updateResultBean.getParameter("ids");
		String taskType=updateResultBean.getParameter("taskType");
		String selectTlrNo=updateResultBean.getParameter("selectTlrNo");
		String selectBrCode=updateResultBean.getParameter("selectBrCode");
		String[] list=ids.split(";");
		//判断任务类型
		//根据任务类型("taskType")修改相关表内容的相关字段
		//1.如果是"单客户预警",那么修改基于"FD_ID"为查询条件的相关内容
		//其中包括"T_CM_WARN_TASK"表中"FD_TASK_ORG",和"ACT_RU_TASK"表中"ASSIGNEE_"
		//注：参数中"ids"是多个"FD_ID"的连接的字符串，分割符号为：";"。
		//注："T_CM_WARN_TASK"表中"FD_ID"对应"ACT_RU_EXECUTION"表中"BUSINESS_KEY_";
		//	 "ACT_RU_EXECUTION"表中"PROC_INST_ID_"对应"ACT_RU_TASK"表中"PROC_INST_ID_"
		//2.如果是"单规则预警",那么修改基于"FD_ID"为查询条件的相关内容
		//其中包括"T_CM_SINGLE_RUL_WARNING"表中"FD_TASK_ORG",和"ACT_RU_TASK"表中"ASSIGNEE_"
		//注：参数中"ids"是多个"FD_ID"的连接的字符串，分割符号为：";"。
		//注："T_CM_SINGLE_RUL_WARNING"表中"FD_ID"对应"ACT_RU_EXECUTION"表中"BUSINESS_KEY_";
		//	 "ACT_RU_EXECUTION"表中"PROC_INST_ID_"对应"ACT_RU_TASK"表中"PROC_INST_ID_"
		//logic
		for (int i = 0; i < list.length; i++) {
			OperationContext context = new OperationContext();
			if ("DGZ".equals(taskType)) {
				context.setAttribute("taskType", TaskDivertPOperation.DGZ);
			} else if ("DKH".equals(taskType)) {
				context.setAttribute("taskType", TaskDivertPOperation.DKH);
			}
			context.setAttribute("id", list[i]);
			context.setAttribute("selectTlrNo", selectTlrNo);
			context.setAttribute("selectBrCode", selectBrCode);
			context.setAttribute("type", TaskDivertPOperation.UPDATE);
			OPCaller.call(TaskDivertPOperation.ID, context);
		}
		return updateReturnBean;
	}

}
