package com.huateng.ebank.business.opermng.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.opermng.operation.OperMngOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngResetPwdUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("operMngEntry");
			if(updateResultBean.hasNext()) {
				String tlrno = updateResultBean.next().get("tlrno");
				OperationContext oc = new OperationContext();
				oc.setAttribute(OperMngOperation.CMD, "resetPwd");
				oc.setAttribute(OperMngOperation.IN_TLRNO, tlrno);
				OPCaller.call(OperMngOperation.ID, oc);
			} else {
				ExceptionUtil.throwAppException("请选择一条记录", ErrorCode.ERROR_CODE_NORMAL);
			}
			String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
			updateReturnBean.setParameter("DefaultPWD", sysDefaultPwd);

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
