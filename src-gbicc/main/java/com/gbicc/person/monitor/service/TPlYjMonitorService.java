package com.gbicc.person.monitor.service;

import com.gbicc.person.monitor.dao.TPlYjMonitorDAO;
import com.gbicc.person.monitor.entity.TPlYjMonitor;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author xudongdong
 *
 * 版本：2015年11月6日 下午2:47:56
 * 类说明：定期监控报告服务类
 */
public class TPlYjMonitorService {
	protected TPlYjMonitorService() {
	}

	public synchronized static TPlYjMonitorService getInstance() {
		return (TPlYjMonitorService) ApplicationContextUtils
				.getBean(TPlYjMonitorService.class.getSimpleName());
	}
	
	private TPlYjMonitorDAO getDao(){
		return (TPlYjMonitorDAO) ApplicationContextUtils.getBean("TPlYjMonitorDAO");
	}
	
	public TPlYjMonitor get(String id) throws CommonException{
		TPlYjMonitorDAO dao=getDao();
		return dao.getHibernateTemplate().get(TPlYjMonitor.class,id);
	}
	
	public void save(TPlYjMonitor monitor) throws CommonException{
		TPlYjMonitorDAO dao=getDao();
		dao.getHibernateTemplate().save(monitor);
	}
	
	public void update(TPlYjMonitor monitor)throws CommonException{
		TPlYjMonitorDAO dao=getDao();
		dao.getHibernateTemplate().update(monitor);
	}
	
	public void delete(TPlYjMonitor monitor)throws CommonException{
		TPlYjMonitorDAO dao=getDao();
		dao.getHibernateTemplate().delete(monitor);
	}
}
