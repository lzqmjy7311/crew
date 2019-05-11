package com.gbicc.warn.ComninationWarn.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gbicc.warn.entity.TWarnDisposalRep;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;


/**
 * 
 * @author xudongdong
 *
 * 版本：2015年11月4日 下午5:25:49
 * 类说明：预警处置报告dao
 */
public class TWarnDisposalRepDAO extends HibernateDaoSupport {

	public TWarnDisposalRepDAO() {
		super();
	}
	


	private static final Logger logger = Logger.getLogger(TWarnDisposalRepDAO.class);

	
	
	/**
	 * 根据预警处置报告编号查询预警处置报告
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public TWarnDisposalRep query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
			TWarnDisposalRep warnDisposalRep = (TWarnDisposalRep) this.getHibernateTemplate().get(TWarnDisposalRep.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return warnDisposalRep;
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
	 * 根据where查询预警处置报告信息
	 * @param whereString
	 * @return
	 * @throws CommonException
	 */
	public List<TWarnDisposalRep>  queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			@SuppressWarnings("unchecked")
			List<TWarnDisposalRep> list = this.getHibernateTemplate().find(
					"from TWarnDisposalRep po where " + whereString);

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
	 * 更新预警处置报告信息
	 * @param warnDisposalRep
	 * @throws CommonException
	 */
	public void update(TWarnDisposalRep warnDisposalRep) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(TWarnDisposalRep) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(warnDisposalRep);
		} catch (Exception e) {
			logger.error("update(TWarnDisposalRep)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(TWarnDisposalRep) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入预警处置报告信息
	 * @param warnDisposalRep
	 * @throws CommonException
	 */
	public void insert(TWarnDisposalRep warnDisposalRep) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(TWarnDisposalRep) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(warnDisposalRep);
		} catch (Exception e) {
			logger.error("insert(TWarnDisposalRep)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(TWarnDisposalRep) - end"); //$NON-NLS-1$
		}
	}
	
	/**
	 * 删除预警处置报告信息
	 * @param warnDisposalRep
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(TWarnDisposalRep) - start"); //$NON-NLS-1$
		}

		try {
			TWarnDisposalRep warnDisposalRep=query(id);
			this.getHibernateTemplate().delete(warnDisposalRep);
		} catch (Exception e) {
			logger.error("delete(TWarnDisposalRep)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(TWarnDisposalRep) - end"); //$NON-NLS-1$
		}
	}

}
