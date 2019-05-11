package com.gbicc.bpm.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.entity.TTaskDivertDtl;
import com.gbicc.bpm.operation.TaskAfreshAssignOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TaskAfreshAssignUpdate extends BaseUpdate{
	
	private static final String DATASET_ID = "TaskAfreshAssign";

	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			OperationContext oc = new OperationContext();
			String user=updateResultBean.getParameter("user");
			String organization=updateResultBean.getParameter("organization");
			String op=updateResultBean.getParameter("op");
			if(StringUtils.isEmpty(op)){
				op="";
			}
			List<TTaskDivertDtl> list=new ArrayList<TTaskDivertDtl>();
			while(updateResultBean.hasNext()){
				Map map=updateResultBean.next();
				TTaskDivertDtl task=new TTaskDivertDtl();
				if(map.get("assignee")!=null && StringUtils.isNotEmpty(map.get("assignee").toString())){
					String assignee=map.get("assignee").toString();
					task.setAssignee(TlrInfoService.getInstance().getTlrInfoByTlrno(assignee));
				}
				map.remove("assignee");
				mapToObject(task,map);
				list.add(task);
			}
			oc.setAttribute("assigneeOrg",organization);
			oc.setAttribute("assignee",user);
			oc.setAttribute("list",list);
			oc.setAttribute("op",op);
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
