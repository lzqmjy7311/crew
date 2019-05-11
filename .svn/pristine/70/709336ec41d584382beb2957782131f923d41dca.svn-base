package com.huateng.ebank.business.remote.base;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SessionFactory {

//	private static byte lock[] = new byte[0];
	private static SessionFactory instance = new SessionFactory();
	private static Hashtable<String,HttpSession> map = new Hashtable();

	private static Log log = LogFactory.getLog(SessionFactory.class);

	private SessionFactory() {
	}


	public  static SessionFactory getInstance(){
//		synchronized(lock){
//			if(instance == null)
//				instance = new SessionFactory();
			return instance;
//		}
	}

	public  void saveSession(String sessionId,HttpSession session){
		log.info("检查session是否在map中");
		if(!map.containsKey(sessionId)){
			log.info("save session to map,session id is:"+sessionId);
			map.put(sessionId, session);
		}
		else{
			log.info("session已经在map中，session id："+sessionId);
		}
	}
	public  HttpSession getSession(String sessionId){
		if(map.containsKey(sessionId))
			return (HttpSession)map.get(sessionId);
		else return null;
	}
	public void removeSession(String key){
		map.remove(key);
	}
}
