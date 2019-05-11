package com.huateng.ebank.business.remote.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.dao.mng.TlrInfoDAO;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DateUtil;

public class SessionListener implements HttpSessionListener {
	private static Log log = LogFactory.getLog(SessionListener.class);
	private  static Map<String,HttpSession> sessions=new HashMap<String,HttpSession>();
	
	public static Map<String,HttpSession> getSessions(){
		return SessionListener.sessions;
	}
	
	public static HttpSession getSession(String trlNo){
		return sessions.get(trlNo);
	}
	
	public void sessionCreated(HttpSessionEvent event) {
		sessions.put(event.getSession().getId(), event.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		if (session != null) {
			String sessionId = session.getId();
			log.info("destroyed session id is :" + sessionId);
			String tlrNo = null;
			GlobalInfo gi =(GlobalInfo)session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
			if(gi!=null){
				tlrNo = gi.getTlrno();
				synchronized (sessions) {
					sessions.remove(gi.getTlrno());
				}
			}
			try {
				if (tlrNo != null) {
					TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
					TlrInfo tlrInfo = tlrInfoDAO.queryById(tlrNo);
					if (tlrInfo != null) {
						if (tlrInfo.getStatus().equals(
								SystemConstant.TLR_NO_STATE_LOGIN)) {
							tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
							// 最近登出时间
							tlrInfo.setLastlogouttm(DateUtil
									.Time14ToString2(DateUtil.getTimestamp()));
							tlrInfoDAO.update(tlrInfo);
						}
					}
				}
			} catch (CommonException e) {
				log.error("",e);
				e.printStackTrace();
			}finally{
				if(gi!=null){
					gi.setAllFunctions(null);
					gi.setButtonMap(null);
					gi.setConfrimCodeList(null);
					gi.setRoleFuncMap(null);
					gi.setFuncMap(null);
					gi=null;
					GlobalInfo.removeCurrentInstance();
				}
				SessionFactory.getInstance().removeSession(sessionId);
			}
		}
	}

}
