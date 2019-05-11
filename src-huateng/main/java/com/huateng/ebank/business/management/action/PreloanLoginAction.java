package com.huateng.ebank.business.management.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.ErrorCodeUtil;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.business.common.operator.LoginManagerOP;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.bean.LoginForm;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.struts.BaseAction;

/**
 * <strong>TemplateAction</strong> demonstrates how an action class is called
 * within the struts framework For the purposes of this sample, we simple
 * demonstrate how the perform is called, a sample action, and a return
 *
 * @author James Wu . Huateng Software Co., Ltd.
 */
public class PreloanLoginAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(ErrorCodeUtil.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - start"); //$NON-NLS-1$
		}
		ActionForward actionForward = null;
		LoginForm formLogin = (LoginForm) form;
		try {
			// Create the container for any errors that occur
			// 第一步：获取上下文对象
			OperationContext operContext = new OperationContext();
			GlobalInfo globalInfo = new GlobalInfo();
			globalInfo.setIp(request.getRemoteAddr());
			globalInfo.setTlrno("99999999");
			globalInfo.setTxtime(DateUtil.getCurrentTime());
			globalInfo.setSessionId(getSessionID(request));
			GlobalInfo.setCurrentInstance(globalInfo);
			// 第二步：把数据放到对象内
			operContext.setAttribute(LoginManagerOP.IN_TLR_NO, "99999999");
			String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD", SystemConstant.DEFAULT_PASSWORD);
			operContext.setAttribute(LoginManagerOP.IN_TLR_PWD, sysDefaultPwd);
			operContext.setAttribute(LoginManagerOP.IN_GLOBALINFO, globalInfo);
			operContext.setAttribute(LoginManagerOP.CONTEXT_PATH, request.getContextPath());
			operContext.setAttribute(GlobalInfo.KEY_GLOBAL_INFO, globalInfo);
			OPCaller.call(LoginManagerOP.ID, operContext);
			// 第四步：从返回对象中获取返回值
			UserSessionInfo userSessionInfo = new UserSessionInfo();
			userSessionInfo = (UserSessionInfo) operContext
					.getAttribute(LoginManagerOP.OUT_USER_SESSION_INFO);
			GlobalInfo gi = new GlobalInfo();
			gi = (GlobalInfo) operContext.getAttribute(LoginManagerOP.OUT_GLOBALINFO_INFO);

			// 第五步：从返回对象中获取返回值
			setSessionObject(request, LoginManagerOP.OUT_USER_SESSION_INFO,userSessionInfo);
			setSessionObject(request, GlobalInfo.KEY_GLOBAL_INFO, gi);
			setSessionObject(request, SystemConstant.WEB_SESSION_ID, this.getSessionID(request));
			//菜单
			StringBuffer tree = new StringBuffer();
			StringBuffer menu = new StringBuffer();
			tree = (StringBuffer)operContext.getAttribute(LoginManagerOP.OUT_TREE);
			menu = (StringBuffer)operContext.getAttribute(LoginManagerOP.OUT_MENU);

			setSessionObject(request, "tree", tree);
			setSessionObject(request, "menu", menu);

			setSessionObject(request, "tlrname", userSessionInfo.getTlrName());
			setSessionObject(request, "tlrno", userSessionInfo.getTlrNo());
			setSessionObject(request, "custNo", "");
			setSessionObject(request, "busidate", globalInfo.getTxdate());
			setSessionObject(request, "lastlogintime", userSessionInfo.getLastLoginTime());

			if ("1".equals(formLogin.getUserName())) {
				actionForward = mapping.findForward("search");
			} else {
				actionForward = mapping.findForward("success");
			}

		} catch (CommonException e) {

		} catch (Exception e) {

		}

		// Forward control to the appropriate URI as determined by the action.
		ActionForward returnActionForward = (actionForward);
		if (logger.isDebugEnabled()) {
			logger.debug("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - end"); //$NON-NLS-1$
		}
		return returnActionForward;
	}

}
