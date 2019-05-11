package com.gbicc.person.importtext;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbicc.person.importtext.entity.Importpublictext;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

@SuppressWarnings("deprecation")
public class ImporttextDao extends HibernateDaoSupport {

	private static final Logger logger = Logger.getLogger(ImporttextDao.class);

	public ImporttextDao() {
		super();
	}
	
	/**
	 * 根据客户编号查询客户
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public Importpublictext query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
			Importpublictext Importpublictext = (Importpublictext) this.getHibernateTemplate().get(Importpublictext.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return Importpublictext;
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
	public List<Importpublictext>  queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			@SuppressWarnings("unchecked")
			List<Importpublictext> list = this.getHibernateTemplate().find(
					"from Importpublictext po where " + whereString);

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
	public void update(Importpublictext importpublictext) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(Importpublictext) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(importpublictext);
		} catch (Exception e) {
			logger.error("update(Importpublictext)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(Importpublictext) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void insert(Importpublictext importpublictext) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(Importpublictext) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(importpublictext);
		} catch (Exception e) {
			logger.error("insert(Importpublictext)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Importpublictext) - end"); //$NON-NLS-1$
		}
	}
	
	/**
	 * 删除客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(Importpublictext) - start"); //$NON-NLS-1$
		}

		try {
			Importpublictext Importpublictext=query(id);
			this.getHibernateTemplate().delete(Importpublictext);
		} catch (Exception e) {
			logger.error("delete(Importpublictext)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(Importpublictext) - end"); //$NON-NLS-1$
		}
	}
}

