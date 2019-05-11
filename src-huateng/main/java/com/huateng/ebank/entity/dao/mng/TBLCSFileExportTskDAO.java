package com.huateng.ebank.entity.dao.mng;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.data.mng.TblCSFileExportTskInf;

/**
 * A data access object (DAO) providing persistence and search support for
 * BranchFuncRel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.huateng.ebank.entity.data.mng.BranchFuncRel
 * @author MyEclipse Persistence Tools
 * @author jonay
 */

public class TBLCSFileExportTskDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TBLCSFileExportTskDAO.class);

	public static final String SPRING_BEAN_ANME = "TBLCSFileExportTskDAO";
	
	@Override
	protected void initDao() {
		// do nothing
	}
	/**
	 * 插入数据库
	 * @param expTsk
	 */
	public void save(TblCSFileExportTskInf expTsk) {
		log.debug("saving TblFileExportTskInf instance");
		try {
			getHibernateTemplate().save(expTsk);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * 分页查询
	 * @param detachedCriteria
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public List findByCriteria(final DetachedCriteria detachedCriteria,final int pageSize,final int currentPage) {
		 return (List) getHibernateTemplate().execute(new HibernateCallback() {
			    public Object doInHibernate(Session session) throws HibernateException {
			    Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				 criteria.setFirstResult((currentPage-1)*pageSize);
				 criteria.setMaxResults(pageSize);
				 criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			    return criteria.list();}
			    });
	 }
	/**
	 * 条件查询
	 * @param detachedCriteria
	 * @return
	 */
	public List findByCriteria(final DetachedCriteria detachedCriteria) {
		 return (List) getHibernateTemplate().execute(new HibernateCallback() {
		    public Object doInHibernate(Session session) throws HibernateException {
		    Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		    criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		    return criteria.list();}
		    });
	 }
	/**
	 * 删除批量任务记录
	 * @param expTsk
	 */
	public void delete(TblCSFileExportTskInf expTsk) {
		log.debug("deleting TblFileExportTskInf instance");
		try {
			getHibernateTemplate().delete(expTsk);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * 更新批量任务表
	 * @param expTsk
	 */
	public void update(TblCSFileExportTskInf expTsk) {
		log.debug("update TblFileExportTskInf instance");
		try {
			getHibernateTemplate().update(expTsk);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	/**
	 * 
	 * @param tskId
	 * @return
	 */
	public TblCSFileExportTskInf findById(String tskId) {
		log.debug("getting TblFileExportTskInf instance with id: " + tskId);
		try {
			TblCSFileExportTskInf instance = (TblCSFileExportTskInf) getHibernateTemplate()
					.get(TblCSFileExportTskInf.class.getName(), tskId);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * 根据字段名和值，获取数据记录集
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TblCSFileExportTskInf instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TblCSFileExportTskInf model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/**
	 * 获取所有的任务信息
	 * @return
	 */
	public List findAll() {
		log.debug("finding all TblFileExportTskInf instances");
		try {
			String queryString = "from TblCSFileExportTskInf";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public static TBLCSFileExportTskDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TBLCSFileExportTskDAO) ctx.getBean("TBLCSFileExportTskDAO");
	}
	
	/**
	 * 取出update后的记录
	 * @param num 记录数
	 * @param whereString 过滤条件
	 * @return
	 */
	public void getForUpdate(int num,String owner){
				
		Session session = null;
		try{
			PageQueryResult resultFirst = null;
			String hqlStr = "from TblCSFileExportTskInf po where tskStat = '0' order by tskStartTms ";
			PageQueryCondition pqc = new PageQueryCondition();
			pqc.setPageIndex(1);
			pqc.setPageSize(num);
			pqc.setQueryString(hqlStr);
			resultFirst = DAOUtils.getHQLDAO().pageQueryByQLWithCount(pqc);
			
//			mod by zhaozhiguo begin
			for (Iterator it = resultFirst.getQueryResult().iterator(); it.hasNext();) {
				Object[] obj = (Object[]) it.next();
				TblCSFileExportTskInf tblCSFileExportTskInf = (TblCSFileExportTskInf) obj[0];
				tblCSFileExportTskInf.setTskStat("1");
				tblCSFileExportTskInf.setTskOwner(owner);
				DAOUtils.getExportTskDAO().update(tblCSFileExportTskInf);
				
//				Object[] obj = (Object[]) it.next();
//				String id = (String) obj[0];
//				
//				TblCSFileExportTskInf tskInf = new TblCSFileExportTskInf();
//				tskInf.setId(id);
//				tskInf.setTskStat("0");
//				List list = DAOUtils.getExportTskDAO().getHibernateTemplate().findByExample(tskInf);
//				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//					TblCSFileExportTskInf tblCSFileExportTskInf = (TblCSFileExportTskInf) iterator.next();
//					
//					tblCSFileExportTskInf.setTskStat("1");
//					DAOUtils.getExportTskDAO().update(tblCSFileExportTskInf);
//				}
			}
//			session = this.getHibernateTemplate().getSessionFactory().openSession();
//			String dbType = "DB2";
//
//			Query query = null;
//			List<TblCSFileExportTskInf> sqlReusltList = null;
//			String whereStr = "WHERE 1=1 ";
//			String queryStr = null;
//			String orderStr = null;
//			StringBuffer tskIdArr = new StringBuffer();
//			if(resultFirst.getQueryResult().size() == 0) return;
//			tskIdArr.append("(");
//			for(int index =0 ;index < resultFirst.getQueryResult().size() ; index++){
//				tskIdArr.append("'");
//				tskIdArr.append(((Object[])resultFirst.getQueryResult().get(index))[0]);
//				tskIdArr.append("'");
//				if(index != resultFirst.getQueryResult().size()-1) tskIdArr.append(",");
//			}
//			tskIdArr.append(")");
//			//锁表查询
//			if("SQLSERVER".equals(dbType)){
//				/* 目前使用查询两次的方式进行锁表操作.*/
//				 whereStr += "and TSK_STAT = '0' ";
//				 whereStr += "and TSK_ID in " + tskIdArr.toString();
//				 orderStr = "ORDER BY TSK_START_TMS";
//				 queryStr = "SELECT * FROM TBL_CS_FILE_EXPORT_TSK_INF WITH (XLOCK, ROWLOCK) SET LOCK_TIMEOUT -1 " + whereStr;
//				 SQLQuery sqlQuery = session.createSQLQuery(queryStr + orderStr);
//				 sqlQuery.addEntity(TblCSFileExportTskInf.class);
//				 sqlReusltList = (List<TblCSFileExportTskInf>)sqlQuery.list();
//			}else{
//				 whereStr += " and tskStat = '0'";
//				 whereStr += " and id in " + tskIdArr.toString();
//				 orderStr = " ORDER BY tskStartTms";
//				 queryStr = "from TblCSFileExportTskInf as tblCSFileExportTskInf " + whereStr;
//				 query = session.createQuery(queryStr + orderStr);
//				 //query.setLockMode("tblCSFileExportTskInf", LockMode.UPGRADE);
//				 sqlReusltList =  (List<TblCSFileExportTskInf>)query.list();
//			}
//			
//			TBLCSFileExportTskDAO dao = DAOUtils.getExportTskDAO();
//			for(int index = 0;index < num && index < sqlReusltList.size();index++){
//				TblCSFileExportTskInf tskInf = sqlReusltList.get(index);
//				tskInf.setTskOwner(owner);
//				tskInf.setTskStat("1");
//				dao.update(tskInf);
//			}
//			mod by zhaozhiguo end

		}catch(Exception ex){
			throw new RuntimeException("forupdate 查询表记录出错",ex);
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
}