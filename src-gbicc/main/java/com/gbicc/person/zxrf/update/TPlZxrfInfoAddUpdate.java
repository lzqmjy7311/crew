package com.gbicc.person.zxrf.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.zxrf.entity.TPlZxrfInfo;
import com.gbicc.person.zxrf.opration.TPlZxrfInfoOperation;
import com.gbicc.person.zxrf.service.TPlZxrfInfoService;
import com.gbicc.warn.entity.TWarnSignal;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;


/**
 * 
 * @author liufei
 *
 * 版本：2015年11月12日 上午19:55:08
 * 类说明：中小融辅新增
 */
public class TPlZxrfInfoAddUpdate extends BaseUpdate {
	private static final String DATASET_ID = "TPlZxrfInfo";
	private static final String DATASET_ID2 = "TWarnSignal";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			UpdateResultBean updateResultBean2 = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID2);
			
			String businessId = updateResultBean.getParameter("businessId");
			String op=updateResultBean.getParameter("op");
			String taskAssignee=updateResultBean.getParameter("taskAssignee");
			String opinion=updateResultBean.getParameter("opinion");
			if(opinion==null){
				opinion="";
			}
			if(null==op){
				op="";
			}
			if(null==taskAssignee){
				taskAssignee="";
			}
			//处理报告基础信息
			TPlZxrfInfo ajReport = new TPlZxrfInfo();
			OperationContext oc = new OperationContext();
			oc.setAttribute(TPlZxrfInfoOperation.BUSINESS_ID,businessId);
			oc.setAttribute(TPlZxrfInfoOperation.OP,op);
			oc.setAttribute("taskAssignee",taskAssignee);
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String  id=(String) map.get("id");
				if(StringUtils.isNotEmpty(id)) {
					ajReport = TPlZxrfInfoService.getInstance().get(id);
					oc.setAttribute(TPlZxrfInfoOperation.CMD,TPlZxrfInfoOperation.CMD_UPDATE);
					
					} else  {
						ajReport = new TPlZxrfInfo();
						oc.setAttribute(TPlZxrfInfoOperation.CMD, TPlZxrfInfoOperation.CMD_INSERT);
				
				}
				mapToObject(ajReport,map);
			}
			oc.setAttribute(TPlZxrfInfoOperation.IN_PARAM,ajReport);
			

			//设置预警信号 集合
		   List<TWarnSignal> warnSignals=new ArrayList<TWarnSignal>();
		   while(updateResultBean2.hasNext()){
			   Map map=updateResultBean2.next();
			   TWarnSignal warnSignal=new TWarnSignal();
			   mapToObject(warnSignal, map);
			   warnSignals.add(warnSignal);
		   }
		   oc.setAttribute(TPlZxrfInfoOperation.WARNING_SIGNALS, warnSignals);
		   oc.setAttribute(TPlZxrfInfoOperation.OPINION, opinion);
		   
			OPCaller.call(TPlZxrfInfoOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
