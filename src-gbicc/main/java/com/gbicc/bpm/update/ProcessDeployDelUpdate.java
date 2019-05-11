package com.gbicc.bpm.update;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.bpm.service.ProcessManagerService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class ProcessDeployDelUpdate extends BaseUpdate{
	
	private static final String DATASET_ID = "ProcessDeploy";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			List<Map<String, String>> list=updateResultBean.getTotalList();
			if(null!=list && list.size()>0){
				Map<String, String> map=list.get(0);
				String deploymentId=map.get("deploymentId");
				ProcessManagerService managerService=ProcessManagerService.getInstace();
				managerService.deleteDefinitionAll(deploymentId);
			}
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
