package com.gbicc.user.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbicc.user.entity.TModifiedRoleid;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;


/**
 * 
 * @author kfc
 *
 * 版本：2015年10月21日 上午11:06:55
 * 类说明：客户管理dao
 */
@SuppressWarnings("deprecation")
public class TModifiedRoleidDao extends HibernateDaoSupport {

	private static final Logger logger = Logger.getLogger(TModifiedRoleidDao.class);

	public TModifiedRoleidDao() {
		super();
	}
	
	/**
	 * 根据客户编号查询客户
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public TModifiedRoleid query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
			TModifiedRoleid TModifiedRoleid = (TModifiedRoleid) this.getHibernateTemplate().get(TModifiedRoleid.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return TModifiedRoleid;
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
	 * 根据where查询客户信息
	 * @param whereString
	 * @return
	 * @throws CommonException
	 */
	public List<TModifiedRoleid>  queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			@SuppressWarnings("unchecked")
			List<TModifiedRoleid> list = this.getHibernateTemplate().find(
					"from TModifiedRoleid po where " + whereString);

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
	 * 更新客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void update(TModifiedRoleid TModifiedRoleid) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(TModifiedRoleid) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(TModifiedRoleid);
		} catch (Exception e) {
			logger.error("update(TModifiedRoleid)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(TModifiedRoleid) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void insert(TModifiedRoleid TModifiedRoleid) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(TModifiedRoleid) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(TModifiedRoleid);
		} catch (Exception e) {
			logger.error("insert(TModifiedRoleid)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(TModifiedRoleid) - end"); //$NON-NLS-1$
		}
	}
	
	/**
	 * 删除客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(TModifiedRoleid) - start"); //$NON-NLS-1$
		}

		try {
			TModifiedRoleid TModifiedRoleid=query(id);
			this.getHibernateTemplate().delete(TModifiedRoleid);
		} catch (Exception e) {
			logger.error("delete(TModifiedRoleid)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(TModifiedRoleid) - end"); //$NON-NLS-1$
		}
	}
}
