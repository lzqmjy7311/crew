package com.gbicc.person.zxrf.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbicc.person.zxrf.entity.TPlZxrfInfo;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;


/**
 * 
 * @author liufei
 *
 * 版本：2015年11月12日 上午11:06:55
 * 类说明：中小融辅管理dao
 */
@SuppressWarnings("deprecation")
public class TPlZxrfInfoDAO extends HibernateDaoSupport {

	private static final Logger logger = Logger.getLogger(TPlZxrfInfoDAO.class);

	public TPlZxrfInfoDAO() {
		super();
	}
	
	/**
	 * 根据中小融辅编号查询中小融辅
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public TPlZxrfInfo query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
			TPlZxrfInfo collectionInfo = (TPlZxrfInfo) this.getHibernateTemplate().get(TPlZxrfInfo.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return collectionInfo;
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
	 * 根据where查询中小融辅信息
	 * @param whereString
	 * @return
	 * @throws CommonException
	 */
	public List<TPlZxrfInfo>  queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			@SuppressWarnings("unchecked")
			List<TPlZxrfInfo> list = this.getHibernateTemplate().find(
					"from TPlZxrfInfo po where " + whereString);

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
	 * 更新中小融辅信息
	 * @param collectionInfo
	 * @throws CommonException
	 */
	public void update(TPlZxrfInfo collectionInfo) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(TPlZxrfInfo) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(collectionInfo);
		} catch (Exception e) {
			logger.error("update(TPlZxrfInfo)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(TPlZxrfInfo) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入中小融辅信息
	 * @param collectionInfo
	 * @throws CommonException
	 */
	public void insert(TPlZxrfInfo collectionInfo) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(TPlZxrfInfo) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(collectionInfo);
		} catch (Exception e) {
			logger.error("insert(TPlZxrfInfo)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(TPlZxrfInfo) - end"); //$NON-NLS-1$
		}
	}
	
	/**
	 * 删除中小融辅信息
	 * @param collectionInfo
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(TPlZxrfInfo) - start"); //$NON-NLS-1$
		}

		try {
			TPlZxrfInfo collectionInfo=query(id);
			this.getHibernateTemplate().delete(collectionInfo);
		} catch (Exception e) {
			logger.error("delete(TPlZxrfInfo)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(TPlZxrfInfo) - end"); //$NON-NLS-1$
		}
	}
}
