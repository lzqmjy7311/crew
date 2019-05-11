package com.huateng.ebank.business.remote;

import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.MapUtil;
import com.huateng.ebank.business.common.TransferConstant;
import com.huateng.ebank.business.common.remote.RequestProcess;
import com.huateng.ebank.business.remote.base.RemoteSysMap;
import com.huateng.ebank.business.remote.base.SessionFactory;
import com.huateng.ebank.framework.util.encrypt.Base64URLEncode;
import com.huateng.ebank.framework.web.struts.BaseAction;

public class SendAction extends BaseAction{
	
	private static Log log = LogFactory.getLog(SendAction.class);
	
	/**
	 * 传递的所以参数放在request的attribute的SystemConstant.SEND_VALUE_MAP中
	 * URL和SYSTYPE 为必加项
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		Object url = RequestProcess.getValueFromRequest(request,"URL");
		Object systype = RequestProcess.getValueFromRequest(request,"SYSTYPE");//1.是信贷 2是个贷
		if(url == null || systype== null){
			log.info("Error :url or systype is null!");
			return mapping.findForward("error");
		}
		Object value_map = request.getAttribute(TransferConstant.SEND_VALUE_MAP);
		String str=null;
		String result="";
		//处理业务参数
		if(value_map !=null)
		{
			str= MapUtil.map2String((HashMap)value_map);
			//出错返回null
			if(str == null)
				return mapping.findForward("error");
			
			//没有出错则加密
			try {
				result =Base64URLEncode.byBase64Encode(str);
			} catch (Exception e) {
				log.error("Base64Encode转换出错："+e.getMessage());
				return mapping.findForward("error");
			}
		}
		String sendUrl = "";
		if(systype.toString().equals("1")){
			sendUrl = RemoteSysMap.getValue("HTSEMSWeb");
		}
		else //if(systype.equals("2"))默认往个贷发
			sendUrl = RemoteSysMap.getValue("PLoanSysWeb");

		
//		sendUrl ="http://localhost:8888/RemoteTest/CreditServlet";//测试用
		request.setAttribute("_sendUrl", sendUrl);
		request.setAttribute("_URL", url);
		request.setAttribute("_"+TransferConstant.SEND_VALUE_MAP, result);
		GlobalInfo g = GlobalInfo.getCurrentInstanceWithoutException();
		g.setTokenId(UUID.randomUUID().toString());
		
		HttpSession session=request.getSession(false);
		g.setSessionId(session.getId());
		
		SessionFactory.getInstance().saveSession(session.getId(), session);
		return mapping.findForward("success");
	}
	
	
}
