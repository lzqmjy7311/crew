package com.huateng.ebank.entity.dao.mng;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.Currency;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class CurrencyDAO extends HibernateDaoSupport {
	private static final Logger logger = Logger.getLogger(CurrencyDAO.class);

	public CurrencyDAO() {
		super();
	}

	/**
	 * 查询所有币种信息
	 *
	 * @return 所有币种list
	 * @throws CommonException
	 */
	public List queryAll() throws CommonException {
		List list = null;
		try {
			String hql = "from Currency po order by po.id ";
			list = this.getSession().createQuery(hql).list();
		} catch (HibernateException e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_CURRENCY_SELECT, e);
		}
		return list;
	}

	/**
	 * 根据ID查询相应币种信息
	 *
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public Currency query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}

		try {
			Currency returnCurrency = (Currency) this.getHibernateTemplate()
					.load(Currency.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return returnCurrency;
		} catch (Exception e) {
			logger.error("query(String)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_CURRENCY_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - end"); //$NON-NLS-1$
		}
		return null;
	}
}
