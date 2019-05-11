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

public class ProcessInstanceDelUpdate extends BaseUpdate{
	
	private static final String DATASET_ID = "ProcessInstance";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			String idList=updateResultBean.getParameter("idList");
			List<Map<String, String>> list=updateResultBean.getTotalList();
			if(null!=list && list.size()>0){
				Map<String, String> map=list.get(0);
				String id=map.get("id");
				ProcessManagerService managerService=ProcessManagerService.getInstace();
				String ids[]=idList.split(",");
				if(ids!=null){
					for(String d:ids){
						if(!d.equals("")){
							managerService.deleteProcessInstance(d);
						}
					}
				}
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
