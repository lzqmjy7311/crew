package com.gbicc.person.monitor.service;

import com.gbicc.person.monitor.entity.TPlDqReportJy;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author likm
 * @time   2015年11月10日17:07:24
 * @desc   经营类监控报告服务类
 */
public class TPlDqReportJyService {
	protected TPlDqReportJyService() {
	}

	public synchronized static TPlDqReportJyService getInstance() {
		return (TPlDqReportJyService) ApplicationContextUtils
				.getBean(TPlDqReportJyService.class.getName());
	}
	
	public TPlDqReportJy get(String id) throws CommonException{
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		return rootDao.query(TPlDqReportJy.class,id);
	}
	
	public void save(TPlDqReportJy jyReport) throws CommonException{
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		rootDao.getHibernateTemplate().save(jyReport);
	}
	
	public void update(TPlDqReportJy jyReport)throws CommonException{
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		rootDao.getHibernateTemplate().update(jyReport);
	}
	
	public void delete(TPlDqReportJy jyReport)throws CommonException{
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		rootDao.getHibernateTemplate().delete(jyReport);
	}
}
