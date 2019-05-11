package com.gbicc.person.monitor.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.monitor.entity.TPlDqReportJy;
import com.gbicc.person.monitor.operation.TPlDqReportJyOperation;
import com.gbicc.person.monitor.service.TPlDqReportJyService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPlDqReportJyUpdate extends BaseUpdate{
	
	private static final String DATASET_ID = "JYMonitorReportWin";

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
			oc.setAttribute(TPlDqReportJyOperation.BUSINESS_ID,businessId);
			if(null==op){
				op="";
			}
			if(null==taskAssignee){
				taskAssignee="";
			}
			oc.setAttribute("op", op);
			oc.setAttribute("taskAssignee",taskAssignee);
			
			//处理报告基础信息
			TPlDqReportJy jyReport = new TPlDqReportJy();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String id=(String) map.get("id");
				String opinion="";
				if(map.get("opinion")!=null && !map.get("opinion").equals("")){
					opinion=map.get("opinion").toString();
				}
				oc.setAttribute(TPlDqReportJyOperation.OPINION,opinion);
				if(StringUtils.isNotEmpty(id)){
					jyReport = TPlDqReportJyService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TPlDqReportJyOperation.CMD,TPlDqReportJyOperation.CMD_UPDATE);
				}else{
					jyReport = new TPlDqReportJy();
					oc.setAttribute(TPlDqReportJyOperation.CMD, TPlDqReportJyOperation.CMD_INSERT);
				}
				mapToObject(jyReport,map);
			}
			oc.setAttribute(TPlDqReportJyOperation.IN_PARAM,jyReport);
			
			OPCaller.call(TPlDqReportJyOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
