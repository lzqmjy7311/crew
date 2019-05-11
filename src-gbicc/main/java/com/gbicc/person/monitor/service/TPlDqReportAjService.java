package com.gbicc.person.monitor.service;

import com.gbicc.person.monitor.dao.TPlDqReportAjDAO;
import com.gbicc.person.monitor.entity.TPlDqReportAj;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author likm
 * @time   2015年11月6日09:56:40
 * @desc   按揭监控报告服务类
 */
public class TPlDqReportAjService {
	protected TPlDqReportAjService() {
	}

	public synchronized static TPlDqReportAjService getInstance() {
		return (TPlDqReportAjService) ApplicationContextUtils
				.getBean(TPlDqReportAjService.class.getName());
	}
	
	private TPlDqReportAjDAO getDao(){
		return (TPlDqReportAjDAO) ApplicationContextUtils.getBean("TPlDqReportAjDAO");
	}
	
	public TPlDqReportAj get(String id) throws CommonException{
		TPlDqReportAjDAO dao=getDao();
		return dao.getHibernateTemplate().get(TPlDqReportAj.class,id);
	}
	
	public void save(TPlDqReportAj ajReport) throws CommonException{
		TPlDqReportAjDAO dao=getDao();
		dao.getHibernateTemplate().save(ajReport);
	}
	
	public void update(TPlDqReportAj ajReport)throws CommonException{
		TPlDqReportAjDAO dao=getDao();
		dao.getHibernateTemplate().update(ajReport);
	}
	
	public void delete(TPlDqReportAj ajReport)throws CommonException{
		TPlDqReportAjDAO dao=getDao();
		dao.getHibernateTemplate().delete(ajReport);
	}
}
