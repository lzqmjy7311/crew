package com.huateng.ebank.entity.dao.mng;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class ROOTDAO extends com.huateng.ebank.framework.operation.orm.HQLDAO {

	private static final Logger log = Logger.getLogger(ROOTDAO.class);

	public ROOTDAO() {
		super();
	}

	/**
	 * @title 通过键值查询 
	 * @Description 通过键值查询，返回数据库实体对象 
	 * @param id
	 * @return Object
	 * @throws CommonException
	 */
	public <T> T query(Class<T> cls, Serializable id) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (log.isDebugEnabled()) {
			log.debug("query(Class,String) - start"); //$NON-NLS-1$
		}
		try {

			Object reObj = this.getHibernateTemplate().get(cls, id);
			if (log.isDebugEnabled()) {
				log.debug("query(Class,String) - end"); //$NON-NLS-1$
			}
			return (T)reObj;
		} catch (Exception e) {
			log.error("query(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("query(Class,String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * @title 保存数据实体
	 * @Description 保存数据实体，返回吃久态实体
	 * @param obj
	 * @return
	 * @throws CommonException
	 */
	public Object save(Object obj) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (log.isDebugEnabled()) {
			log.debug("save(Object) - start"); //$NON-NLS-1$
		}
		Object reObj = null;

		try {
			if (obj != null) {
				reObj = this.getHibernateTemplate().save(obj);
			}
		} catch (Exception e) {
			log.error("save(Object)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		if (log.isDebugEnabled()) {
			log.debug("save(Object) - end"); //$NON-NLS-1$
		}
		return reObj;
	}

	/**
	 * @title 更新数据库实体
	 * @Description 更新数据库实体
	 * @param po
	 * @throws CommonException
	 */
	public void update(Object obj) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (log.isDebugEnabled()) {
			log.debug("update(Object) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(obj);
		} catch (Exception e) {
			log.error("update(Object)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("update(Object) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * @title 插入或更新数据库实体
	 * @Description 插入或更新数据库实体，不推荐使用
	 * @deprecated
	 * @param obj
	 * @return
	 * @throws CommonException
	 */
	public Object saveOrUpdate(Object obj) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);

		if (log.isDebugEnabled()) {
			log.debug("saveOrUpdate(Object) - start"); //$NON-NLS-1$
		}
		Object reObj = null;
		try {
			reObj = this.getHibernateTemplate().merge(obj);
		} catch (Exception e) {
			log.error("saveOrUpdate(Object)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("saveOrUpdate(Object) - end"); //$NON-NLS-1$
		}

		return reObj;
	}

	/**
	 * @title 删除数据库实体
	 * @Description 删除数据库实体
	 * @param obj
	 * @throws CommonException
	 */
	public void delete(Object obj) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (log.isDebugEnabled()) {
			log.debug("delete(Object) - start"); //$NON-NLS-1$
		}
		try {
			if (obj != null) {
				this.getHibernateTemplate().delete(obj);
			}
		} catch (Exception e) {
			log.error("save(Object)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		if (log.isDebugEnabled()) {
			log.debug("save(Object) - end"); //$NON-NLS-1$
		}

	}

	/**
	 * @title 删除数据库实体，依据对象键值
	 * @Description 删除数据库实体，依据对象键值
	 * @param id
	 * @throws CommonException
	 */
	public void delete(Class cls, String id) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (log.isDebugEnabled()) {
			log.debug("delete(Class,String) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().delete(query(cls, id));
		} catch (Exception e) {
			log.error("delete(Class,String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("delete(Class,String) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * @title 依据HQL进行分页查询
	 * @Description 依据HQL进行分页查询，只返回数据LIST，不提供统计信息
	 * @param hql
	 * @param startPage
	 * @param maxRows
	 * @return
	 * @throws CommonException
	 */
	public List pageQueryByHql(String hql, int startPage, int maxRows)
			throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (log.isDebugEnabled()) {
			log.debug("pageQueryByHql(String, int, int) - start"); //$NON-NLS-1$
		}

		List returnValue = new ArrayList();
		startPage = startPage >= 1 ? startPage : 1;
		int firstResult = (startPage - 1)
				* (maxRows > 0 ? maxRows : SystemConstant.MAX_ROWS);
		int rows = maxRows;
		rows = (rows == 0 ? SystemConstant.MAX_ROWS : rows);

		try {
			Query query = this.getSession().createQuery(hql);
			query.setFirstResult(firstResult);
			query.setMaxResults(rows);
			returnValue = query.list();
		} catch (HibernateException e) {
			log.error("queryByCondition(String, int, int)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("queryByCondition(String, int, int) - end"); //$NON-NLS-1$
		}
		return returnValue;
	}

	/**
	 * 分页查询（每次获取行数）
	 * @param pageIndex 第几页
	 * @param pageSize 每页显示行数
	 * @param hql 
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize, String hql) throws CommonException {
		return page(hql,pageIndex,pageSize);
	}
	
	/**
	 * Hibernate 分页方式
	 * @param hql
	 * @param startPage
	 * @param maxRows
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult page(String hql, int startPage, int maxRows)throws CommonException {
		PageQueryResult pageQueryResult = new PageQueryResult();
		List list=pageQueryByHql(hql,startPage,maxRows);
		StringBuilder nsql=new StringBuilder();
		
		if(hql.contains("order by")){
			hql=hql.substring(0,hql.lastIndexOf("order by"));
		}
		if(hql.startsWith("select")){
			hql=hql.substring(hql.indexOf("from"));
		}
		if(hql.startsWith("from")){
			hql="select count(*) "+hql;
		}
		Object total=queryOneHQL(hql);
		pageQueryResult.setQueryResult(list);
		pageQueryResult.setTotalCount(Integer.valueOf(total.toString()));
		return pageQueryResult;
	}
	
	/**
	 * 分页查询
	 * @param pageIndex 第几页
	 * @param pageSize 每页显示行数
	 * @param hql
	 * @param cacheCount （前台传入是否缓存了总页数，ture表示不查询总页数，false表示查询，默认为false）
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize, String hql,boolean cacheCount) throws CommonException {
		return page(hql,pageIndex,pageSize);
	}

	/**
	 * ����hql��ѯ����
	 * @param hql
	 * @return
	 * @throws CommonException
	 */
	public Integer queryByHqlToCount(String hql) throws CommonException{
		return  Integer.parseInt(this.queryByQL(hql).next().toString());
	}

	public Object queryByHqlMax(String hql)  throws CommonException{
		final String tempHql = hql;
		Object max = null;
		try {
			max = (Object) getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {
					return session.createQuery(tempHql).uniqueResult();
				}
			});
		} catch (Exception e) {
			throw new CommonException(e.getMessage());
		}
		return max;
	}


	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
		}
		return null;
	}

	public int executeSql(String sql) throws CommonException{
		final String tempSql = sql;
		Integer row = null;
		try {
			row = getHibernateTemplate().execute(new HibernateCallback<Integer>() {
				public Integer doInHibernate(Session session) throws HibernateException {
					SQLQuery sqlQuery = session.createSQLQuery(tempSql);
					return sqlQuery.executeUpdate();
				}
			});
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
		}
		if (row==null) {
			row = 0;
		}
		return row;
	}
	
	public int executeHQL(final String hql){
		 int row = 0;
		 row=getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(hql).executeUpdate();
			}
		 });
		 return row;
	}
	
	public Object queryOneHQL(final String hql){
		Object obj=null;
		obj=getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(hql).uniqueResult();
			}
		});
		return obj;
	}
	
	@SuppressWarnings("rawtypes")
	public List queryListHQL(final String hql){
		List list=new ArrayList();
		list=getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(hql).list();
			}
		});
		return list;
	}
	
	public Object querySqlOne(String sql) throws CommonException{
		final String tempSql = sql;
		Object row = null;
		try {
			row = getHibernateTemplate().execute(new HibernateCallback<Object>() {
				public Object doInHibernate(Session session) throws HibernateException {
					SQLQuery sqlQuery = session.createSQLQuery(tempSql);
					return sqlQuery.uniqueResult();
				}
			});
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
		}
		return row;
	}
	
	public List executeSql(String sql, Class clazz) throws CommonException{
		final String tempSql = sql;
		final Class<?> tempclazz = clazz;
		List retList = null;
		try {
			retList = getHibernateTemplate().execute(new HibernateCallback<List>() {
				public List doInHibernate(Session session) throws HibernateException {
					SQLQuery sqlQuery = session.createSQLQuery(tempSql);
					if(tempclazz!=null){
						sqlQuery.addEntity(tempclazz);
					}
					return sqlQuery.list();
				}
			});
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
		}
		return retList;
	}
	
	/**
	 * 获取ConnectionProvider
	 * @return
	 */
	public ConnectionProvider getConnectionProvider(){
		SessionFactory sf = this.getSessionFactory();
		ConnectionProvider cp = ((SessionFactoryImplementor) sf).getConnectionProvider();
		return cp;
	}
	
	public Connection getConnection(ConnectionProvider connProvider) throws SQLException{
		return connProvider.getConnection();
	}
	
	public void closeConnection(ConnectionProvider connProvider,Connection conn) throws SQLException{
		connProvider.closeConnection(conn);
	}
	
}
