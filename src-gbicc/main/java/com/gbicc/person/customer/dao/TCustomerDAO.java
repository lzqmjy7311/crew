package com.gbicc.person.customer.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbicc.person.customer.entity.TCustomer;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;


/**
 * 
 * @author xudongdong
 *
 * 版本：2015年10月21日 上午11:06:55
 * 类说明：客户管理dao
 */
@SuppressWarnings("deprecation")
public class TCustomerDAO extends HibernateDaoSupport {

	private static final Logger logger = Logger.getLogger(TCustomerDAO.class);

	public TCustomerDAO() {
		super();
	}
	
	/**
	 * 根据客户编号查询客户
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public TCustomer query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
			TCustomer customer = (TCustomer) this.getHibernateTemplate().get(TCustomer.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return customer;
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
	public List<TCustomer>  queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			@SuppressWarnings("unchecked")
			List<TCustomer> list = this.getHibernateTemplate().find(
					"from TCustomer po where " + whereString);

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
	public void update(TCustomer customer) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(TCustomer) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(customer);
		} catch (Exception e) {
			logger.error("update(TCustomer)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(TCustomer) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void insert(TCustomer customer) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(TCustomer) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(customer);
		} catch (Exception e) {
			logger.error("insert(TCustomer)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(TCustomer) - end"); //$NON-NLS-1$
		}
	}
	
	/**
	 * 删除客户信息
	 * @param customer
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(TCustomer) - start"); //$NON-NLS-1$
		}

		try {
			TCustomer customer=query(id);
			this.getHibernateTemplate().delete(customer);
		} catch (Exception e) {
			logger.error("delete(TCustomer)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(TCustomer) - end"); //$NON-NLS-1$
		}
	}
}
