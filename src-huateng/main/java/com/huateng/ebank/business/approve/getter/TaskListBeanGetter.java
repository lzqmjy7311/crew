package com.huateng.ebank.business.approve.getter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.approve.operation.TaskListOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TaskListBeanGetter extends BaseGetter {
	/**
	 * @author jianxue.zhang
	 * 用于获取选中的待审批列表
	 */
	@Override
	public Result call() throws AppException {
		try {
			List list = getData();
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				list,
				getResult());
			result.setContent(list);
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	private List getData() throws CommonException, IOException, ClassNotFoundException {
		//获取参数集合
		Map paramMap = this.getCommQueryServletRequest().getParameterMap();
		//获取参数
		OperationContext oc = new OperationContext();
		oc.setAttribute(TaskListOperation.CMD,"query" );
		oc.setAttribute(TaskListOperation.TYPE, (String)paramMap.get("type"));
		oc.setAttribute(TaskListOperation.TASKIDS,(String)paramMap.get("taskIds"));
		OPCaller.call(TaskListOperation.ID, oc);
		//TaskListService  tls= new TaskListService();
		return (List) oc.getAttribute(TaskListOperation.QUERYLIST);
	}
}
