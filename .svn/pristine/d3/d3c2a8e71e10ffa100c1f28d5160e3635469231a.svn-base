package com.huateng.ebank.business.management.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.service.TlrLoginLogService;
import com.huateng.ebank.business.management.service.UserMgrService;
import com.huateng.ebank.business.remote.base.SessionFactory;
import com.huateng.ebank.framework.web.struts.BaseAction;

public class LogoutAction extends BaseAction {

	private static final Logger logger = Logger.getLogger(LogoutAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = null;
		try {
			if(request.getSession(false) != null){
				//记录登录日志
				GlobalInfo gi=(GlobalInfo)request.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
				TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
				tlrLoginLogService.saveTlrLoginLog("logout", false, "退出系统",gi);
				/*不是重新登陆才记录退出信息*/
//				if (StringUtils.isBlank(request.getParameter("relogin")))
				UserMgrService.getInstance().setLoginOutInfo(gi);
				//删除系统记录的session
				SessionFactory.getInstance().removeSession(request.getSession(false).getId());
			}
			destroySession(request);
			actionForward = mapping.findForward("success");
		} catch (Exception e) {
			logger.error(e.getMessage());
			actionForward = mapping.findForward("failure");
		}
		return (actionForward);
	}
}