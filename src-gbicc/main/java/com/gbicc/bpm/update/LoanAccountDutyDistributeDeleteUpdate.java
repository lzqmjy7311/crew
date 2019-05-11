package com.gbicc.bpm.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.bpm.entity.TLoanAccountDutyDistribute;
import com.gbicc.bpm.operation.TLoanAccountDutyDistributeDelOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class LoanAccountDutyDistributeDeleteUpdate extends BaseUpdate{
	
	private static final String DATASET_ID = "LoanAccountDutyDistribute";

	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			OperationContext oc = new OperationContext();
			TLoanAccountDutyDistribute distribute=new TLoanAccountDutyDistribute();
			if(updateResultBean.hasNext()){
				Map map=updateResultBean.next();
				mapToObject(distribute,map);
			}
			oc.setAttribute("TLoanAccountDutyDistribute",distribute);
			OPCaller.call(TLoanAccountDutyDistributeDelOperation.ID,oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
