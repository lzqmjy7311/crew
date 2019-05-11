package com.gbicc.person.supervision.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbicc.person.supervision.entity.QualitysuPar;
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
public class QualitysuParDao extends HibernateDaoSupport {

	private static final Logger logger = Logger.getLogger(QualitysuParDao.class);

	public QualitysuParDao() {
		super();
	}
	
	/**
	 * 根据客户编号查询客户
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public QualitysuPar query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
			QualitysuPar qualitysuPar = (QualitysuPar) this.getHibernateTemplate().get(QualitysuPar.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return qualitysuPar;
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
	public List<QualitysuPar>  queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			@SuppressWarnings("unchecked")
			List<QualitysuPar> list = this.getHibernateTemplate().find(
					"from QualitysuPar po where " + whereString);

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
	public void update(QualitysuPar qualitysuPar) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(QualitysuPar) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(qualitysuPar);
		} catch (Exception e) {
			logger.error("update(QualitysuPar)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(QualitysuPar) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void insert(QualitysuPar qualitysuPar) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(QualitysuPar) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(qualitysuPar);
		} catch (Exception e) {
			logger.error("insert(QualitysuPar)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(QualitysuPar) - end"); //$NON-NLS-1$
		}
	}
	
	/**
	 * 删除客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(QualitysuPar) - start"); //$NON-NLS-1$
		}

		try {
			QualitysuPar qualitysuPar=query(id);
			this.getHibernateTemplate().delete(qualitysuPar);
		} catch (Exception e) {
			logger.error("delete(QualitysuPar)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(QualitysuPar) - end"); //$NON-NLS-1$
		}
	}
}
