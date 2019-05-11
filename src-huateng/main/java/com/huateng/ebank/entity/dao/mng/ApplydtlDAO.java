package com.huateng.ebank.entity.dao.mng;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.Applydtl;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class ApplydtlDAO extends HibernateDaoSupport {

	/**
	 * 插入记录
	 *
	 * @param Applydtl
	 * @throws CommonException
	 */
	public void insert(Applydtl applydtl) throws CommonException {

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Applydtl) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(applydtl);
		} catch (Exception e) {
			logger.error("insert(Applydtl)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_APPLYDT_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Applydtl) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 更新记录
	 *
	 * @param Applydtl
	 * @throws CommonException
	 */
	public void update(Applydtl applydtl) throws CommonException {

		if (logger.isDebugEnabled()) {
			logger.debug("update(Applydtl) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(applydtl);
		} catch (Exception e) {
			logger.error("update(Applydtl)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_APPLYDT_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(Applydtl) - end"); //$NON-NLS-1$
		}
	}


	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含ProductCreditInfo对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			List list = this.getHibernateTemplate().find(
					"from Applydtl tpci where " + whereString);

			if (logger.isDebugEnabled()) {
				logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
			}
			return list;
		} catch (Exception e) {
			logger.error("queryByCondition(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_APPLYDT_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 删除记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(Applydtl po) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(Applydtl) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			logger.error("delete(Applydtl)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_CORPCUSTINFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(Applydtl) - end"); //$NON-NLS-1$
		}
	}

}
