package com.gbicc.person.collection.update;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.person.collection.entity.TCollectionInfo;
import com.gbicc.person.collection.opration.TCollectionInfoOperation;
import com.gbicc.person.collection.opration.TCollectionInfoOperation;
import com.gbicc.person.collection.service.TCollectionInfoService;
import com.gbicc.person.zxrf.entity.TPlZxrfInfo;
import com.gbicc.person.zxrf.opration.TPlZxrfInfoOperation;
import com.gbicc.person.zxrf.service.TPlZxrfInfoService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;


/**
 * 
 * @author liufei
 *
 * 版本：2015年11月09日 上午19:55:08
 * 类说明：提交
 */
public class TCollectionInfoSubmitUpdate extends BaseUpdate {
	private static final String DATASET_ID = "TCollectionInfo";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCollectionInfo dd = null;
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				if(map.get("opinion")!=null){
					String taskRemark=map.get("opinion").toString();
					oc.setAttribute("opinion", taskRemark);
				}
				String  id=(String) map.get("id");
				if(StringUtils.isNotEmpty(id)) {
					dd = TCollectionInfoService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TCollectionInfoOperation.CMD,TCollectionInfoOperation.CMD_UPDATE);
				}
				mapToObject(dd, map);
			}
			
			oc.setAttribute(TCollectionInfoOperation.IN_PARAM, dd);
			
			String op = updateResultBean.getParameter("op");
			if(op==null){
				op="";
			}
			oc.setAttribute("op", op);
			String taskAssignee = updateResultBean.getParameter("taskAssignee");
			if(taskAssignee==null){
				taskAssignee="";
			}
			oc.setAttribute("taskAssignee", taskAssignee);
			OPCaller.call(TCollectionInfoOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	

}
