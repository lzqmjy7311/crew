package com.gbicc.person.collection.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbicc.person.collection.entity.TCollectionInfo;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;


/**
 * 
 * @author liufei
 *
 * 版本：2015年11月07日 上午11:06:55
 * 类说明：催收管理dao
 */
@SuppressWarnings("deprecation")
public class TCollectionInfoDAO extends HibernateDaoSupport {

	private static final Logger logger = Logger.getLogger(TCollectionInfoDAO.class);

	public TCollectionInfoDAO() {
		super();
	}
	
	/**
	 * 根据催收编号查询催收
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public TCollectionInfo query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
			TCollectionInfo collectionInfo = (TCollectionInfo) this.getHibernateTemplate().get(TCollectionInfo.class, id);
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
	 * 根据where查询催收信息
	 * @param whereString
	 * @return
	 * @throws CommonException
	 */
	public List<TCollectionInfo>  queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			@SuppressWarnings("unchecked")
			List<TCollectionInfo> list = this.getHibernateTemplate().find(
					"from TCollectionInfo po where " + whereString);

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
	 * 更新催收信息
	 * @param collectionInfo
	 * @throws CommonException
	 */
	public void update(TCollectionInfo collectionInfo) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(TCollectionInfo) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(collectionInfo);
		} catch (Exception e) {
			logger.error("update(TCollectionInfo)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(TCollectionInfo) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入催收信息
	 * @param collectionInfo
	 * @throws CommonException
	 */
	public void insert(TCollectionInfo collectionInfo) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(TCollectionInfo) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(collectionInfo);
		} catch (Exception e) {
			logger.error("insert(TCollectionInfo)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(TCollectionInfo) - end"); //$NON-NLS-1$
		}
	}
	
	/**
	 * 删除催收信息
	 * @param collectionInfo
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(TCollectionInfo) - start"); //$NON-NLS-1$
		}

		try {
			TCollectionInfo collectionInfo=query(id);
			this.getHibernateTemplate().delete(collectionInfo);
		} catch (Exception e) {
			logger.error("delete(TCollectionInfo)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(TCollectionInfo) - end"); //$NON-NLS-1$
		}
	}
}
