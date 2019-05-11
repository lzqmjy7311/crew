package com.gbicc.person.monitor.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.monitor.entity.TPlDqReportXf;
import com.gbicc.person.monitor.operation.TPlDqReportXfOperation;
import com.gbicc.person.monitor.service.TPlDqReportXfService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPlDqReportXfUpdate extends BaseUpdate{
	
	private static final String DATASET_ID = "XFMonitorReportWin";

	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			
			OperationContext oc = new OperationContext();
			String businessId = updateResultBean.getParameter("businessId");
			String op = updateResultBean.getParameter("op");
			String taskAssignee=updateResultBean.getParameter("taskAssignee");
			oc.setAttribute(TPlDqReportXfOperation.BUSINESS_ID,businessId);
			if(null==op){
				op="";
			}
			if(null==taskAssignee){
				taskAssignee="";
			}
			oc.setAttribute("op", op);
			oc.setAttribute("taskAssignee",taskAssignee);
			
			
			//处理报告基础信息
			TPlDqReportXf xfReport = new TPlDqReportXf();
			if (updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				String id=(String) map.get("id");
				String opinion="";
				if(map.get("opinion")!=null && !map.get("opinion").equals("")){
					opinion=map.get("opinion").toString();
				}
				oc.setAttribute(TPlDqReportXfOperation.OPINION,opinion);
				if(StringUtils.isNotEmpty(id)){
					xfReport = TPlDqReportXfService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TPlDqReportXfOperation.CMD,TPlDqReportXfOperation.CMD_UPDATE);
				}else{
					xfReport = new TPlDqReportXf();
					oc.setAttribute(TPlDqReportXfOperation.CMD, TPlDqReportXfOperation.CMD_INSERT);
				}
				mapToObject(xfReport,map);
			}
			oc.setAttribute(TPlDqReportXfOperation.IN_PARAM,xfReport);
			OPCaller.call(TPlDqReportXfOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
