/**
 *
 */
package com.huateng.ebank.business.management.updater;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.bean.ChangePwdForm;
import com.huateng.ebank.business.management.operation.PasswordResetOP;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class PasswordResetUpdate extends BaseUpdate {

	
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// TODO Auto-generated method stub
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("passwordReset");
			ChangePwdForm cpf = new ChangePwdForm();
			while (updateResultBean.hasNext()) {
				mapToObject(cpf, updateResultBean.next());
			}
			String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
			cpf.setNewPassWord(sysDefaultPwd);
			OperationContext oc = new OperationContext();
			oc.setAttribute(PasswordResetOP.IN_TLRNO,cpf.getTlrno());
			oc.setAttribute(PasswordResetOP.IN_NEW_PWD,cpf.getNewPassWord());
			OPCaller.call(PasswordResetOP.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
