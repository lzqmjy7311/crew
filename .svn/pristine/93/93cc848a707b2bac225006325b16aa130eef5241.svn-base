/**
 *
 */
package com.huateng.ebank.business.management.updater;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.bean.ChangePwdForm;
import com.huateng.ebank.business.management.operation.ChangePwdOP;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author yjw
 *
 */
public class ChangePwdUpdate extends BaseUpdate {

	
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// TODO Auto-generated method stub
		try {
			System.out.println("=====start==========saveOrUpdate");
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("changePwd");
			ChangePwdForm cpf = new ChangePwdForm();
			while (updateResultBean.hasNext()) {
				mapToObject(cpf, updateResultBean.next());
			}
			if(!(cpf.getNewPassWord().equals(cpf.getAgainNewPassWord()))){
				ExceptionUtil.throwCommonException("新密码两次输入不一致",ErrorCode.ERROR_CODE_NEW_AGAIN_PWD_IS_NOT_SAME);
			}
			cpf.setTlrno(GlobalInfo.getCurrentInstance().getTlrno().toString());
			OperationContext oc = new OperationContext();
			oc.setAttribute(ChangePwdOP.IN_OLD_PWD,cpf.getOldPassWord());
			oc.setAttribute(ChangePwdOP.IN_NEW_PWD,cpf.getNewPassWord());
			oc.setAttribute(ChangePwdOP.IN_AGAIN_NEW_PWD,cpf.getAgainNewPassWord());
			OPCaller.call(ChangePwdOP.ID, oc);
			/** add by zhaozhiguo 2011-6-20 BMS-3153 begin */
			GlobalInfo.getCurrentInstance().setPswdForcedToChange(false);
			GlobalInfo.getCurrentInstance().setLastpwdchgtm(new Date());
			/** add by zhaozhiguo 2011-6-20 BMS-3153 begin */
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
