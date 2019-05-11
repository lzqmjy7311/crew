package com.gbicc.person.monitor.service;

import com.gbicc.person.monitor.dao.TPlZxrfMonitorDAO;
import com.gbicc.person.monitor.entity.TPlZxrfMonitor;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author liufei
 *
 * 版本：2015年11月18日 上午9.15
 * 类说明：中小融辅报告
 */
public class TPlZxrfMonitorService {
	protected TPlZxrfMonitorService() {
	}

	public synchronized static TPlZxrfMonitorService getInstance() {
		return (TPlZxrfMonitorService) ApplicationContextUtils
				.getBean(TPlZxrfMonitorService.class.getSimpleName());
	}
	
	private TPlZxrfMonitorDAO getDao(){
		return (TPlZxrfMonitorDAO) ApplicationContextUtils.getBean("TPlZxrfMonitorDAO");
	}
	
	public TPlZxrfMonitor get(String id) throws CommonException{
		TPlZxrfMonitorDAO dao=getDao();
		return dao.getHibernateTemplate().get(TPlZxrfMonitor.class,id);
	}
	
	public void save(TPlZxrfMonitor monitor) throws CommonException{
		TPlZxrfMonitorDAO dao=getDao();
		dao.getHibernateTemplate().save(monitor);
	}
	
	public void update(TPlZxrfMonitor monitor)throws CommonException{
		TPlZxrfMonitorDAO dao=getDao();
		dao.getHibernateTemplate().update(monitor);
	}
	
	public void delete(TPlZxrfMonitor monitor)throws CommonException{
		TPlZxrfMonitorDAO dao=getDao();
		dao.getHibernateTemplate().delete(monitor);
	}
}
