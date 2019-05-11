package com.gbicc.person.monitor.service;

import com.gbicc.person.monitor.entity.TPlDqReportXf;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author likm
 * @time   2015年11月6日09:56:40
 * @desc   消费类监控报告服务类
 */
public class TPlDqReportXfService {
	protected TPlDqReportXfService() {
	}

	public synchronized static TPlDqReportXfService getInstance() {
		return (TPlDqReportXfService) ApplicationContextUtils
				.getBean(TPlDqReportXfService.class.getName());
	}
	
	public TPlDqReportXf get(String id) throws CommonException{
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		return rootDao.query(TPlDqReportXf.class,id);
	}
	
	public void save(TPlDqReportXf xfReport) throws CommonException{
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		rootDao.getHibernateTemplate().save(xfReport);
	}
	
	public void update(TPlDqReportXf xfReport)throws CommonException{
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		rootDao.getHibernateTemplate().update(xfReport);
	}
	
	public void delete(TPlDqReportXf xfReport)throws CommonException{
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		rootDao.getHibernateTemplate().delete(xfReport);
	}
}
