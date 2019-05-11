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

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class TlrInfoDAO extends HibernateDaoSupport {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TlrInfoDAO.class);

	public TlrInfoDAO() {
		super();
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return TlrInfo
	 * @throws CommonException
	 */
	public TlrInfo query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}

		try {
			TlrInfo returnTlrInfo = (TlrInfo) this.getHibernateTemplate().get(TlrInfo.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return returnTlrInfo;
		} catch (Exception e) {
			logger.error("query(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，返回null,不抛出异常
	 *
	 * @param id
	 * @return TlrInfo
	 * @throws CommonException
	 * @author yjw add
	 */
	public TlrInfo queryById(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}

		try {
			TlrInfo returnTlrInfo = (TlrInfo) this.getHibernateTemplate().get(
					TlrInfo.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return returnTlrInfo;
		} catch (Exception e) {
			logger.error("query(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 *根据业务主键查询，如果没有找到记录，则返回null
	 *
	 * @param key1
	 * @param key2
	 * @return TlrInfo
	 * @throws CommonException
	 *             public TlrInfo query(String key1, String key2) throws
	 *             CommonException { List list = new ArrayList(); try {
	 *             StringBuffer whereString = new StringBuffer();
	 *             whereString.append("po.key1 = '").append(key1).append( "' and
	 *             po.key2 = '").append(key2).append("'"); list =
	 *             queryByCondition(whereString.toString()); } catch (Exception
	 *             e) { ExceptionUtil.throwCommonException(e.getMessage(),
	 *             ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e); }
	 *
	 * if (list.size() != 1) { return null; } else { return (TlrInfo)
	 * list.get(0); } }
	 */

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @param objArray
	 * @param typeArray
	 * @return ??TlrInfo?????List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString, Object[] objArray,
			Type[] typeArray) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String, Object[], Type[]) - start"); //$NON-NLS-1$
		}

		try {
			List list = this.getHibernateTemplate().find(
					"from TlrInfo po where " + whereString, objArray);

			if (logger.isDebugEnabled()) {
				logger
						.debug("queryByCondition(String, Object[], Type[]) - end"); //$NON-NLS-1$
			}
			return list;
		} catch (Exception e) {
			logger.error("queryByCondition(String, Object[], Type[])", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String, Object[], Type[]) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return ??TlrInfo?????List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			List list = this.getHibernateTemplate().find(
					"from TlrInfo po where " + whereString);

			if (logger.isDebugEnabled()) {
				logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
			}
			return list;
		} catch (Exception e) {
			logger.error("queryByCondition(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(TlrInfo po) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(TlrInfo) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			logger.error("update(TlrInfo)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(TlrInfo) - end"); //$NON-NLS-1$
		}
	}

	public int update(String queryString,Object[] values)throws CommonException{
		if (logger.isDebugEnabled()) {
			logger.debug("update(TlrInfo) - start"); //$NON-NLS-1$
		}
		int updateRow = 0;
		try {

			if(values == null){
				updateRow = this.getHibernateTemplate().bulkUpdate(queryString);
			}else{
				updateRow = this.getHibernateTemplate().bulkUpdate(queryString, values);
			}
		} catch (Exception e) {
			logger.error("update(String,Object[])", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("update(TlrInfo) - end"); //$NON-NLS-1$
		}
		return updateRow;
	}

	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(TlrInfo po) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(TlrInfo) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			logger.error("insert(TlrInfo)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(TlrInfo) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入或更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void saveOrUpdate(TlrInfo po) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(TlrInfo) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().saveOrUpdate(po);
		} catch (Exception e) {
			logger.error("update(TlrInfo)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(TlrInfo) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 删除记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(TlrInfo po) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(TlrInfo) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			logger.error("delete(TlrInfo)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(TlrInfo) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 根据Hibernate ID删除记录
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(String) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().delete(query(id));
		} catch (Exception e) {
			logger.error("delete(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(String) - end"); //$NON-NLS-1$
		}
	}

	/**
	 *add by NT 2007-09-29 根据ID查询对象
	 *
	 * @param int
	 *            id ????????
	 * @throws DAOException
	 */
	public TlrInfo queryByName(String name) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByName(String) - start"); //$NON-NLS-1$
		}

		TlrInfo pojo = null;
		try {
			List list = this.queryByCondition("po.id ='" + name + "'", -1, 0);
			if (list.size() > 0) {
				pojo = (TlrInfo) list.get(0);
			}

		} catch (Exception e) {
			logger.error("queryByName(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
		}

		return pojo;
	}

	/**
	 * add by NT 2008-09-29 根据输入的条件字串查询对象集合
	 *
	 * @param String
	 *            whereString 条件集合 例如 "po.name = 'user1' and po.level = '1' or
	 *            ...."
	 * @param int
	 *            startPage 展现层的开始页数
	 * @param int
	 *            maxRows 展现层的每页记录数 -1 :全部; 0 :默认值; 其他:实际值
	 * @return List 对象集合
	 * @throws DAOException
	 */
	public List queryByCondition(String whereString, int startPage, int maxRows)
			throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String, int, int) - start"); //$NON-NLS-1$
		}

		List returnValue = new ArrayList();
		startPage = startPage >= 1 ? startPage : 1;
		int firstResult = (startPage - 1)
				* (maxRows > 0 ? maxRows : SystemConstant.MAX_ROWS);
		int rows = maxRows;
		rows = (rows == 0 ? SystemConstant.MAX_ROWS : rows);

		try {
			String hql = "from TlrInfo as po where ";
			hql = hql + whereString;

			Query query = this.getSession().createQuery(hql);
			query.setFirstResult(firstResult);
			if (rows != -1) {
				query.setMaxResults(rows + 1);
			}
			returnValue = query.list();
		} catch (HibernateException e) {
			logger.error("queryByCondition(String, int, int)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String, int, int) - end"); //$NON-NLS-1$
		}
		return returnValue;
	}

	/**
	 *
	 * 根据外部操作员号获得操作员信息
	 *
	 * @param tlrno
	 * @return
	 * @throws CommonException
	 */
	public TlrInfo getTlrByExtno(String extno) throws CommonException {
		try {
			List list = this.queryByCondition("po.extTlrno = '" + extno
					+ "'");
			if (list == null || list.size() != 1) {
				ExceptionUtil.throwCommonException("没有找到符合条件的操作员",
						ErrorCode.ERROR_CODE_TLR_INFO_SELECT);
			} else {
				return ((TlrInfo) list.get(0));
			}
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
		}
		return null;
	}

	/**
	 *
	 * 获得外部操作员号
	 *
	 * @param tlrno
	 * @return
	 * @throws CommonException
	 */
	public String getExtnoByTlrno(String tlrno) throws CommonException {
		try {
			if (DataFormat.trim(tlrno).equals(""))
				return "";
			return this.query(tlrno).getExtTlrno();
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据外部操作员号获取Tlrno
	 *
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public String getTlrnoByExtno(String extTlrno) throws CommonException {

		try {
			List list = this.queryByCondition("po.extTlrno = '" + extTlrno
					+ "'");
			if (list == null || list.size() != 1) {
				ExceptionUtil.throwCommonException("没有找到符合条件的操作员",
						ErrorCode.ERROR_CODE_RECORD_NOTFOUND);
			} else {
				return ((TlrInfo) list.get(0)).getTlrno();
			}
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
		}
		return null;
	}

	
}
