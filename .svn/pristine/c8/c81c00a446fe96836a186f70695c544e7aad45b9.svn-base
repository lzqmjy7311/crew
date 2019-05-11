package com.huateng.ebank.entity.dao.mng;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.data.mng.TblCronTaskJob;
import com.huateng.exception.AppException;



public class TblCronTaskJobDAO extends BaseTblCronTaskJobDAO implements ITblCronTaskJobDAO {

	private static final Log log = LogFactory.getLog(TblCronTaskJobDAO.class);
	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public TblCronTaskJobDAO () {}

	/**得到所有的未被锁定的任务**/
	public List<TblCronTaskJob> getAllJobForUpdate()throws AppException{
		try{
			Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
//			String dbType = SysParamUnit.getSysInfoDBType();
//
			Query query = null;
//			/** 基于Hibernate 对于SQL Server 的 bug 进行修正.*/
//			if(SysParamUnit.PARAM_ID_SYSINFO_DBTYPE_SQLSERVER.equals(dbType)){
//				/* 目前使用查询两次的方式进行锁表操作.*/
//				 SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM TBL_SWT_BMS_TASK_JOB WITH (XLOCK, ROWLOCK) SET LOCK_TIMEOUT -1");
//				 sqlQuery.addEntity(TblCronTaskJob.class);
//				 List sqlReusltList = (List<TblCronTaskJob>)sqlQuery.list();
//				 return sqlReusltList;
//			}else{
				 query = session.createQuery("from TblCronTaskJob as tblCronTaskJob ");
				 query.setLockMode("tblCronTaskJob", LockMode.UPGRADE);
				 return (List<TblCronTaskJob>)query.list();
//			}

		}catch(Exception ex){
			throw new AppException(SystemConstant.BS_MODULE, SystemConstant.BS_RECORD_NOT_FOUND, "查询任务出错",ex);
		}
	}
	
	/**获得并锁定任务**/
	public TblCronTaskJob getJobForUpdate(int jobno)throws AppException{
		try{
			Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			//session.connection().setAutoCommit(false);
//			String dbType = SysParamUnit.getSysInfoDBType();
			TblCronTaskJob resultObj=null;
			Query query = null;
//			/** 基于Hibernate 对于SQL Server 的 bug 进行修正.*/
//			if(SysParamUnit.PARAM_ID_SYSINFO_DBTYPE_SQLSERVER.equals(dbType)){
//				/* 目前使用查询两次的方式进行锁表操作.*/
//				 SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM TBL_SWT_BMS_TASK_JOB WITH (XLOCK, ROWLOCK) WHERE JOBNO="+jobno+" SET LOCK_TIMEOUT -1");
//				 sqlQuery.addEntity(TblCronTaskJob.class);
//				 List<TblCronTaskJob> sqlReusltList = (List<TblCronTaskJob>)sqlQuery.list();
//				 if(sqlReusltList.size()>0){
//				   resultObj=sqlReusltList.get(0);
//				 }
//			}else{
				 query = session.createQuery("from TblCronTaskJob as tblCronTaskJob WHERE JOBNO="+jobno);
				 query.setLockMode("tblCronTaskJob", LockMode.UPGRADE);
				 List<TblCronTaskJob> resultList =(List<TblCronTaskJob>)query.list();
				 if(resultList.size()>0){
					   resultObj=resultList.get(0);
					 }
		//	}
			
			return resultObj;

		}catch(Exception ex){
			throw new AppException(SystemConstant.BS_MODULE, SystemConstant.BS_RECORD_NOT_FOUND, "查询任务出错",ex);
		}
	}


	
}