package com.gbicc.person.monitor.service;

import com.gbicc.person.monitor.dao.TPlYjReportDAO;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlYjReport;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author xudongdong
 *
 * 版本：2015年11月7日 下午12:10:53
 * 类说明：预警处置service
 */
public class TPlYjReportService {
	protected TPlYjReportService() {
	}

	public synchronized static TPlYjReportService getInstance() {
		return (TPlYjReportService) ApplicationContextUtils
				.getBean(TPlYjReportService.class.getName());
	}
	
	private TPlYjReportDAO getDao(){
		return (TPlYjReportDAO) ApplicationContextUtils.getBean("TPlYjReportDAO");
	}
	
	public TPlYjReport get(String id) throws CommonException{
		TPlYjReportDAO dao=getDao();
		return dao.getHibernateTemplate().get(TPlYjReport.class,id);
	}
	
	public void save(TPlYjReport ajReport) throws CommonException{
		TPlYjReportDAO dao=getDao();
		dao.getHibernateTemplate().save(ajReport);
	}
	
	public void update(TPlYjReport ajReport)throws CommonException{
		TPlYjReportDAO dao=getDao();
		dao.getHibernateTemplate().update(ajReport);
	}
	
	public void delete(TPlYjReport ajReport)throws CommonException{
		TPlYjReportDAO dao=getDao();
		dao.getHibernateTemplate().delete(ajReport);
	}
	public void clean(String businessId) throws CommonException{
		//查出reportId
		ROOTDAO dao=ROOTDAOUtils.getROOTDAO();
		TPlReportRelation relation=(TPlReportRelation) dao
				.queryOneHQL("from TPlReportRelation where businessId='"+businessId+"'");
		String reportId=relation.getReportId();
		//删除业务主表
		//dao.executeHQL("delete from TPlReportRelation t where t.businessId='"+businessId+"'");
		//控制措施
		dao.executeHQL("delete from TPlControlmeasure where taskId='"+businessId+"' ");
		dao.executeSql("delete from T_PL_YJ_MONITOR t where t.FD_ID='"+businessId+"'");
		dao.executeSql("delete from T_PL_YJ_REPORT t where t.FD_ID='"+reportId+"'");
		dao.executeSql("DELETE FROM ECUSER.T_PL_WARN_SIGNAL WHERE FD_REPORT_ID='"+reportId+"' ");
		
	}

}