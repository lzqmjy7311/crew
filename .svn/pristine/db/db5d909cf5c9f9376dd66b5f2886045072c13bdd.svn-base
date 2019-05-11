package com.gbicc.bpm.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.entity.TTaskDivert;
import com.gbicc.bpm.operation.TaskAfreshAssignOperation;
import com.gbicc.bpm.service.TTaskDivertService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TaskAfreshAssignAplUpdate extends BaseUpdate{
	
	private static final String DATASET_ID = "TaskDivertApl";

	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			OperationContext oc = new OperationContext();
			String op=updateResultBean.getParameter("op");
			if(StringUtils.isEmpty(op)){
				op="";
			}
			TTaskDivert task=new TTaskDivert();
			if(updateResultBean.hasNext()){
				Map map=updateResultBean.next();
				if(map.get("id")!=null){
					task=TTaskDivertService.getInstance().get(map.get("id").toString());
				}
			}
			oc.setAttribute("op",op);
			oc.setAttribute("taskDivert",task);
			OPCaller.call(TaskAfreshAssignOperation.ID,oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
