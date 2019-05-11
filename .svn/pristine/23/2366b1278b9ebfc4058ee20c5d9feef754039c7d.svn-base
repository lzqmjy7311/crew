package com.huateng.ebank.business.management.action;

import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.impl.util.json.HTTP;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gbicc.company.group.GroupDAOUtils;
import com.gbicc.override.MyLoginForm;
import com.gbicc.override.MyLoginManagerOP;
import com.huateng.ebank.business.authority.UserAuthority;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCodeUtil;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.business.common.operator.LoginManagerOP;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.service.TlrLoginLogService;
import com.huateng.ebank.business.management.service.UserMgrService;
import com.huateng.ebank.business.parammng.operation.TlrInfoUpdaterOperation;
import com.huateng.ebank.business.remote.base.SessionFactory;
import com.huateng.ebank.business.remote.base.SessionListener;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.data.mng.TlrRoleRel;
import com.huateng.ebank.entity.view.ExtensBean;
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
public class LoginAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(LoginAction.class);
	 

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - start"); //$NON-NLS-1$
		}
		// super.init(request);
		ActionForward actionForward = null;
		MyLoginForm formLogin = (MyLoginForm) form;
		String sessionId = null;
		try {
			
			HttpSession session=request.getSession();
			session.setAttribute("customerNum","");
			session.setAttribute("loanCardNum","");
			session.setAttribute("partyId", "");
			session.setAttribute("redirectFlag", "");
			
			
			if("changeRole".equals(request.getParameter("changeRole"))){//如果是切换角色
				GlobalInfo globalInfo=(GlobalInfo)request.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
				String trno=globalInfo.getTlrno();
				String roleId=request.getParameter("roleId");
				String orgId=request.getParameter("orgId");
				if(StringUtils.isNotBlank(trno) && StringUtils.isNotBlank(roleId)){
					actionForward = mapping.findForward("success");
					//设置角色为默认角色，重新刷新页面
					OperationContext context=new OperationContext();
					context.setAttribute(TlrInfoUpdaterOperation.CMD, "CHANGESEFAULT");
					context.setAttribute(TlrInfoUpdaterOperation.TLRNO, trno);
					context.setAttribute(TlrInfoUpdaterOperation.ROLEID, roleId);
					context.setAttribute(TlrInfoUpdaterOperation.ORGID, orgId);
					OPCaller.call("parammng.TlrInfoUpdaterOperation", context);
					
					//重新set,从用户 获取用户默认机构_默认岗位
					TlrInfo tlrInfo=DAOUtils.getTlrInfoDAO().query(trno);
					Bctl org=DAOUtils.getBctlDAO().query(tlrInfo.getBrcode());
					globalInfo.setBrName(org.getBrname());
					globalInfo.setBrcode(org.getBrcode());
					globalInfo.setBrno(org.getBrcode());
					
					globalInfo.setWorkflowRoleId(String.valueOf(tlrInfo.getRoleid()));
					ExtensBean ext=globalInfo.getExtensbean();
					if(ext==null){
						ext=new ExtensBean();
					}
					RoleInfo info=DAOUtils.getRoleInfoDAO().findById(tlrInfo.getRoleid());
					ext.setRoleSysType(info.getRoleSysType());
					if("1".equals(org.getBrclass())){
						globalInfo.setHeadBrcode(true);
					}
					UserMgrService userMgrService = UserMgrService.getInstance();
					List userRoleFunclist = UserAuthority.create(userMgrService, globalInfo, trno);
					List confrimList = userMgrService.getApproveUserFunc(userRoleFunclist);
					globalInfo.setConfrimCodeList(confrimList);
					GlobalInfo.setCurrentInstance(globalInfo);
					//更新session
					setSessionObject(request, GlobalInfo.KEY_GLOBAL_INFO, globalInfo);
					setSessionObject(request, SystemConstant.WEB_SESSION_ID, this.getSessionID(request));
					return actionForward;
				}
			}else{
				/////////////////////清空原session/////////////////////
				if("risk".equals(request.getParameter("type"))){
					session.removeAttribute(GlobalInfo.KEY_GLOBAL_INFO);
				}
				GlobalInfo globalInfo=(GlobalInfo)request.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
				if(globalInfo!=null){
					actionForward = mapping.findForward("success");
					return actionForward;
				}
			}
			if(formLogin==null || StringUtils.isEmpty(formLogin.getUserName()) || StringUtils.isEmpty(formLogin.getPassWord())){
				actionForward = mapping.findForward("login");
				logger.warn("Request information is not complete!");
				return actionForward;
			}
			// Create the container for any errors that occur
			// 第一步：获取上下文对象
			OperationContext operContext = new OperationContext();
			GlobalInfo globalInfo = new GlobalInfo();
			/* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 begin .*/
			Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);
			if (locale != null) {
				globalInfo.setLocale(locale);
			}
			globalInfo.setIp(getIpAddr(request));
			globalInfo.setTlrno(formLogin.getUserName());
			globalInfo.setTxtime(DateUtil.getCurrentTime());
			globalInfo.setSessionId(getSessionID(request));
			globalInfo.setBrno(formLogin.getBrCode());
			
			// 第二步：把数据放到对象内
			operContext.setAttribute(MyLoginManagerOP.IN_TLR_NO, formLogin.getUserName());
			operContext.setAttribute(MyLoginManagerOP.IN_TLR_PWD, formLogin.getPassWord());
			//TODO 判断外联时，是对公用户核心机构还是对私用户核心机构
			if("c".equals(formLogin.getSource())){//查找关联表 找出该用户对应的机构
			}else{
			}
			operContext.setAttribute(MyLoginManagerOP.IN_TLR_BRNO, 
				formLogin.getBrCode()==null ?"":formLogin.getBrCode());
			operContext.setAttribute(MyLoginManagerOP.IN_TLR_SECRET, 
				formLogin.getSecret()==null ?"":formLogin.getSecret());
			operContext.setAttribute(MyLoginManagerOP.IN_GLOBALINFO, globalInfo);
			operContext.setAttribute(MyLoginManagerOP.CONTEXT_PATH, request.getContextPath());
			operContext.setAttribute(GlobalInfo.KEY_GLOBAL_INFO, globalInfo);
			OPCaller.call(MyLoginManagerOP.ID, operContext);
			
			//查询默认岗位
			TlrInfo tlrInfo=DAOUtils.getTlrInfoDAO().query(globalInfo.getTlrno());
			globalInfo.setWorkflowRoleId(String.valueOf(tlrInfo.getRoleid()));
			ExtensBean ext=globalInfo.getExtensbean();
			if(ext==null){
				ext=new ExtensBean();
			}
			RoleInfo info=DAOUtils.getRoleInfoDAO().findById(tlrInfo.getRoleid());
			ext.setRoleSysType(info.getRoleSysType());
			Bctl org=DAOUtils.getBctlDAO().query(tlrInfo.getBrcode());
			
			if("1".equals(org.getBrclass())){
				globalInfo.setHeadBrcode(true);
			}
			///////////设置总行//////////////
			GlobalInfo.setCurrentInstance(globalInfo);
			
			// 第四步：从返回对象中获取返回值
			UserSessionInfo userSessionInfo = new UserSessionInfo();
			userSessionInfo = (UserSessionInfo) operContext
					.getAttribute(LoginManagerOP.OUT_USER_SESSION_INFO);

			String cuDateParam = CommonService.getInstance().getSysParamDef("SYS", "CURRENT_DATE", "0");
			if(cuDateParam.equals("1")){
				globalInfo.setTxdate(new Date());
				userSessionInfo.setTxDate(new Date());
			}
			// 第五步：从返回对象中获取返回值
			setSessionObject(request, LoginManagerOP.OUT_USER_SESSION_INFO,userSessionInfo);
			setSessionObject(request, GlobalInfo.KEY_GLOBAL_INFO, globalInfo);
			setSessionObject(request, SystemConstant.WEB_SESSION_ID, this.getSessionID(request));
			//菜单
			
			//add by zhaozhiguo 2011-6-20 BMS-3153
			if (GlobalInfo.getCurrentInstance().isPswdForcedToChange()) {
				return mapping.findForward("chgpwd");
			}else if("risk".equals(request.getParameter("type"))){
				session=request.getSession();
				GroupDAOUtils utils=new GroupDAOUtils();
				String partyId=utils.getPartyId(request.getParameter("customerNum"));
				if(null!=partyId){
					session.setAttribute("partyId", partyId);
					session.setAttribute("redirectFlag", "true");
					return mapping.findForward("warning_info");
				}
				session.setAttribute("customerNum", request.getParameter("customerNum"));
				session.setAttribute("loanCardNum", request.getParameter("loanCardNum"));
				//request.setAttribute("customerNum", request.getParameter("customerNum"));
				//request.setAttribute("loanCardNum", request.getParameter("loanCardNum"));
				return mapping.findForward("riskView");
			}
			actionForward = mapping.findForward("success");
			if (logger.isDebugEnabled()) {
				logger.debug("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - actionForward.getPath()" + actionForward.getPath()); //$NON-NLS-1$
			}

			//记录登录日志
			TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
			tlrLoginLogService.saveTlrLoginLog("login", true, "登录成功",globalInfo);
			
			///////////////////////////////////////////////////单用户session限制
			sessionId=this.getSessionID(request);
			//step1:找出账号对就的session信息
			Map<String,HttpSession> sessions=SessionListener.getSessions();
			session=sessions.get(userSessionInfo.getTlrNo());
			//step2:如果存在当前账号的session
			if(session!=null){
				request.getSession().setAttribute("singleLogin", "singleLogin");
				try {
					sessions.remove(session);
					session.invalidate();
					SessionFactory.getInstance().removeSession(session.getId());
				} catch (Exception e) {
				}
			}
			//step3:移除最新的session文件
			sessions.remove(sessionId);
			sessions.put(userSessionInfo.getTlrNo(),request.getSession());
			///////////////////////////////////////////////////单用户session限制
		} catch (CommonException e) {
			request.getSession().removeAttribute("singleLogin");
			logger.error("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)", e); //$NON-NLS-1$
			request.setAttribute("REQ_CODE",e.getKey());
			String reqMsg = ErrorCodeUtil.convertErrorMessage(logger, e);
			request.setAttribute("REQ_MSG", reqMsg);
			request.setAttribute("UserName", formLogin.getUserName());
			//记录登录日志
			GlobalInfo gi=(GlobalInfo)request.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
			TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
			tlrLoginLogService.saveTlrLoginLog("login", false, reqMsg.trim(),gi);

			actionForward = mapping.findForward("login");
		} catch (Exception e) {
			request.getSession().removeAttribute("singleLogin");
			logger.error("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)", e); //$NON-NLS-1$
			//记录登录日志
			TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
			tlrLoginLogService.saveTlrLoginExceptionLog(formLogin.getUserName(), formLogin.getBrCode(), request.getRemoteAddr(), sessionId);
			actionForward = mapping.findForward("error");
		}
		ActionForward returnActionForward = (actionForward);
		if (logger.isDebugEnabled()) {
			logger.debug("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - end"); //$NON-NLS-1$
		}
		return returnActionForward;
	}
	
	public static String getIpAddr(HttpServletRequest request) {
        if (request == null) {
            return "unknown";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
