package com.gbicc.person.importtext;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbicc.person.importtext.entity.Importpersontext;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

@SuppressWarnings("deprecation")
public class ImportpersontextDao extends HibernateDaoSupport {

	private static final Logger logger = Logger.getLogger(ImportpersontextDao.class);

	public ImportpersontextDao() {
		super();
	}
	
	/**
	 * 根据客户编号查询客户
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public Importpersontext query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
			Importpersontext importpersontext = (Importpersontext) this.getHibernateTemplate().get(Importpersontext.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return importpersontext;
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
	public List<Importpersontext>  queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			@SuppressWarnings("unchecked")
			List<Importpersontext> list = this.getHibernateTemplate().find(
					"from Importpersontext po where " + whereString);

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
	public void update(Importpersontext importpersontext) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(Importpersontext) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(importpersontext);
		} catch (Exception e) {
			logger.error("update(Importpersontext)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(Importpersontext) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void insert(Importpersontext importpersontext) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(Importpersontext) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(importpersontext);
		} catch (Exception e) {
			logger.error("insert(Importpersontext)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Importpersontext) - end"); //$NON-NLS-1$
		}
	}
	
	/**
	 * 删除客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(Importpersontext) - start"); //$NON-NLS-1$
		}

		try {
			Importpersontext importpersontext=query(id);
			this.getHibernateTemplate().delete(importpersontext);
		} catch (Exception e) {
			logger.error("delete(Importpersontext)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(Importpersontext) - end"); //$NON-NLS-1$
		}
	}
}

