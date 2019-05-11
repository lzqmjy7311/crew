package com.huateng.ebank.business.remote;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.remote.base.SessionFactory;

public class TokenCheckUtil {
	private static Log log = LogFactory.getLog(TokenCheckUtil.class);  
	
	public String check(String sessionId,String tokenId){
		String result = "200";
		if(tokenId == null){
			log.info("tokenId is null!");
			result = "201";
			return result;
		}
		HttpSession session = SessionFactory.getInstance().getSession(sessionId);
		
		if(session == null){
			result = "202";
			return result;
		}
		log.info("");
		
		GlobalInfo ga = (GlobalInfo)session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		
		if(ga == null){
			log.info("Can't get GlobalInfo.session timeout.");
			result = "203";
			return result;
		}
		String ga_tokenId = ga.getTokenId();
		
		if(!ga_tokenId.equals(tokenId)){
			log.info("tokenId is error");
			result = "204";
			return result;
		}
		if(result.equals("200")){
			session.setAttribute("_Portal_check_flag", "0");
		}
		return result;
	}
}
