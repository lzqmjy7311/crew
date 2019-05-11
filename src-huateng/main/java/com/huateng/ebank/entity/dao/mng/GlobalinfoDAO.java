/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.entity.dao.mng;

import java.util.List;

import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.Globalinfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class GlobalinfoDAO extends HibernateDaoSupport {

	public GlobalinfoDAO() {
		super();
	}

	/**
	 * 据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return Globalinfo
	 * @throws CommonException
	 */
	public Globalinfo query(java.lang.Integer id) throws CommonException {
		try {
			return (Globalinfo) this.getHibernateTemplate().load(Globalinfo.class,id);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据业务主键查询，如果没有找到记录，则返回null
	 *
	 * @param key1
	 * @param key2
	 * @return Globalinfo
	 * @throws CommonException
	public Globalinfo query(String key1, String key2) throws CommonException {
		List list = new ArrayList();
		try {
			StringBuffer whereString = new StringBuffer();
			whereString.append("po.key1 = '").append(key1).append(
					"' and po.key2 = '").append(key2).append("'");
			list = queryByCondition(whereString.toString());
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
		}

		if (list.size() != 1) {
			return null;
		} else {
			return (Globalinfo) list.get(0);
		}
	}
	 */

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @param objArray
	 * @param typeArray
	 * @return ??Globalinfo?????List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString, Object[] objArray,
			Type[] typeArray) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from Globalinfo po where " + whereString, objArray);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return ??Globalinfo?????List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from Globalinfo po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
		}
		return null;
	}

	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(Globalinfo po) throws CommonException {
		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_UPDATE, e);
		}
	}

	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(Globalinfo po) throws CommonException {
		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_INSERT, e);
		}
	}

	/**
	 * 删除记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(Globalinfo po) throws CommonException {
		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_DELETE, e);
		}
	}

	/**
	 * 根据Hibernate ID删除记录
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(java.lang.Integer id) throws CommonException {
		try {
			this.getHibernateTemplate().delete(query(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_DELETE, e);
		}
	}
	public Globalinfo findById(java.lang.Integer id) {
		try {
			Globalinfo instance = (Globalinfo) getHibernateTemplate().get(
					Globalinfo.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from GlobalInfo model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
