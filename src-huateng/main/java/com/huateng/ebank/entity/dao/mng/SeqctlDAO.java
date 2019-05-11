/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.entity.dao.mng;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.Seqctl;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class SeqctlDAO extends HibernateDaoSupport {

	public SeqctlDAO() {
		super();
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return Seqctl
	 * @throws CommonException
	 */
	public Seqctl query(long id) throws CommonException {
		try {
			return (Seqctl) this.getHibernateTemplate().load(Seqctl.class,new Long(id),LockMode.UPGRADE);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_SEQCTL_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据业务主键查询，如果没有找到记录，则返回null
	 * 增加锁数据方式
	 * modify by shen_antonio 20081107
	 * @param valueNo
	 * @param valueIndex
	 * @return Seqctl
	 * @throws CommonException
	 */
	public Seqctl query(final int valueNo, final String valueIndex)
			throws CommonException {
		List list = new ArrayList();
		try {
			list = (List)this.getHibernateTemplate().execute(new HibernateCallback()
			{
			   public Object doInHibernate(Session session)
			     throws HibernateException
			   {
				 StringBuffer whereString = new StringBuffer("from Seqctl po where ");
				 whereString.append("po.valueNo = ").append(valueNo).append(
							" and po.valueIndex = '").append(valueIndex).append("'");
				 if (logger.isDebugEnabled()) {
					   logger.debug("queryBySQL(String) - sql sql=" + whereString.toString()); //$NON-NLS-1$
				 }
				 Query qry = session.createQuery(whereString.toString());
				 qry.setLockMode("po", LockMode.UPGRADE);
			     return qry.list();
			    }
			   });
			//list = queryByCondition(whereString.toString());
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_SEQCTL_SELECT, e);
		}

		if (list.size() != 1) {
			return null;
		} else {
			return (Seqctl) list.get(0);
		}
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @param objArray
	 * @param typeArray
	 * @return 包含Seqctl对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString, Object[] objArray,
			Type[] typeArray) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from Seqctl po where " + whereString, objArray);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_SEQCTL_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含Seqctl对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from Seqctl po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_SEQCTL_SELECT, e);
		}
		return null;
	}

	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(Seqctl po) throws CommonException {
		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_SEQCTL_UPDATE, e);
		}
	}

	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(Seqctl po) throws CommonException {
		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_SEQCTL_INSERT, e);
		}
	}

	/**
	 * 删除记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(Seqctl po) throws CommonException {
		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_SEQCTL_DELETE, e);
		}
	}

	/**
	 * 根据Hibernate ID删除记录
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(long id) throws CommonException {
		try {
			this.getHibernateTemplate().delete(query(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_SEQCTL_DELETE, e);
		}
	}
}