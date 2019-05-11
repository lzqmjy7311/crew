package com.huateng.ebank.business.branchmng.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.branchmng.operation.BranchMngOperation;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class BranchStatusChgUpdate extends BaseUpdate {

	private final static String PARAM_ACTION = "statu";
	private final static String DATASET_ID = "Management_branchManage";
	private final static String BRH_ID = "brcode";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest arg1, HttpServletResponse arg2)
	        throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			if(updateResultBean.hasNext()) {
				String brcode = updateResultBean.next().get(BRH_ID);
				String status = updateResultBean.getParameter(PARAM_ACTION);
			
				OperationContext oc = new OperationContext();
				oc.setAttribute(BranchMngOperation.CMD, "status");
				oc.setAttribute(BranchMngOperation.IN_BRHID, brcode);
				oc.setAttribute(BranchMngOperation.IN_PARAM, status);
				OPCaller.call(BranchMngOperation.ID, oc);
			} else {
				ExceptionUtil.throwAppException("请选择一条记录", ErrorCode.ERROR_CODE_NORMAL);
			}
			
			return updateReturnBean;
		} catch (CommonException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
