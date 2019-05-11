/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.entity.dao.mng;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.TblCsBizLog;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author valley
 * @date 2005-06-01
 * @desc
 */
public class TblBizLogDAO extends HibernateDaoSupport {

	public TblBizLogDAO() {
		super();
	}

	/**
	 *
	 * @param id
	 * @return BizLog
	 * @throws CommonException
	 */
	public TblCsBizLog query(long id) throws CommonException {
		try {
			return (TblCsBizLog) this.getHibernateTemplate().load(TblCsBizLog.class,
					new Long(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BIZ_LOG_SELECT, e);
		}
		return null;
	}

	/**
	 * �������������ѯ���з������ļ�¼
	 *
	 * @param whereString
	 * @param objArray
	 * @param typeArray
	 * @return ��BizLog�����List
	 * @throws CommonException
	 */
//	public List queryByCondition(String whereString, Object[] objArray,
//			Type[] typeArray) throws CommonException {
//		try {
//			List list = this.getHibernateTemplate().find(
//					"from TblBizLog po where " + whereString, objArray);
//			return list;
//		} catch (Exception e) {
//			ExceptionUtil.throwCommonException(e.getMessage(),
//					ErrorCode.ERROR_CODE_BIZ_LOG_SELECT, e);
//		}
//		return null;
//	}

	/**
	 *
	 * @param whereString
	 * @throws CommonException
	 */
//	public List queryByCondition(String whereString) throws CommonException {
//		try {
//			List list = this.getHibernateTemplate().find(
//					"from TblBizLog po where " + whereString);
//			return list;
//		} catch (Exception e) {
//			ExceptionUtil.throwCommonException(e.getMessage(),
//					ErrorCode.ERROR_CODE_BIZ_LOG_SELECT, e);
//		}
//		return null;
//	}

	/**
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(TblCsBizLog po) throws CommonException {
		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BIZ_LOG_UPDATE, e);
		}
	}

	/**
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(TblCsBizLog po) throws CommonException {
		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BIZ_LOG_INSERT, e);
		}
	}

	/**
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(TblCsBizLog po) throws CommonException {
		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BIZ_LOG_DELETE, e);
		}
	}

	/**
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(long id) throws CommonException {
		try {
			this.getHibernateTemplate().delete(query(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BIZ_LOG_DELETE, e);
		}
	}
}
