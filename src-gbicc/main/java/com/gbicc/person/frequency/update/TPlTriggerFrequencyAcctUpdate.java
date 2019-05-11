package com.gbicc.person.frequency.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.frequency.entity.TPlTriggerFrequencyAcct;
import com.gbicc.person.frequency.opration.TPlTriggerFrequencyAcctOperation;
import com.gbicc.person.frequency.service.TPlTriggerFrequencyAcctService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPlTriggerFrequencyAcctUpdate extends BaseUpdate {
	private static final String DATASET_ID =TPlTriggerFrequencyAcct.class.getSimpleName();
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TPlTriggerFrequencyAcct dd = new TPlTriggerFrequencyAcct();
			OperationContext oc = new OperationContext();
			String op = updateResultBean.getParameter("op");
			String businessId = updateResultBean.getParameter("businessId");
			String taskAssignee=updateResultBean.getParameter("taskAssignee");//接收人
		
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String id=(String) map.get("id");
				
			
				
				if(StringUtils.isEmpty(id)) {
					dd = new TPlTriggerFrequencyAcct();
					oc.setAttribute(TPlTriggerFrequencyAcctOperation.CMD,TPlTriggerFrequencyAcctOperation.CMD_INSERT);
				} else {
					dd = TPlTriggerFrequencyAcctService.getInstance().get(id);
					oc.setAttribute(TPlTriggerFrequencyAcctOperation.CMD,TPlTriggerFrequencyAcctOperation.CMD_UPDATE);
				}
				mapToObject(dd, map);
			}
			oc.setAttribute(TPlTriggerFrequencyAcctOperation.IN_PARAM, dd);
			if(null==taskAssignee){
				taskAssignee="";
			}
			oc.setAttribute("taskAssignee",taskAssignee);
			if(businessId!=null){
				oc.setAttribute(TPlTriggerFrequencyAcctOperation.BUSINESS_ID, businessId);
			}
			if(op!=null){
				oc.setAttribute(TPlTriggerFrequencyAcctOperation.OP, op);
			}
			
			OPCaller.call(TPlTriggerFrequencyAcctOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
