/**
 *
 */
package com.huateng.ebank.business.opermng.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.service.PasswordService;
import com.huateng.ebank.business.opermng.operation.OperMngOperation;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngAddUpdate extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("operMngAdd");
			TlrInfo operator = null;
			while (updateResultBean.hasNext()) {
				operator = new TlrInfo();
				Map map = updateResultBean.next();
				mapToObject(operator, map);

				operator.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
				// 设置有效标志
				operator.setFlag(SystemConstant.FLAG_ON);
				String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);

				String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");

				String pwd = PasswordService.getInstance().EncryptPassword(sysDefaultPwd, encMethod);

				operator.setPassword(pwd);// 设置默认操作员密码
				// 为操作员密码错误次数付初始值
				operator.setTotpswderrcnt(new Integer(0));
				operator.setPswderrcnt(new Integer(0));
				operator.setPasswdenc(encMethod);
				operator.setCreateDate(DateUtil.dateToNumber(GlobalInfo.getCurrentInstance().getTxdate()));
				operator.setIsLock(SystemConstant.FLAG_OFF);
			}

			OperationContext oc = new OperationContext();
			oc.setAttribute(OperMngOperation.CMD, "add");
			oc.setAttribute(OperMngOperation.IN_TLRINFO, operator);
			OPCaller.call(OperMngOperation.ID, oc);

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
