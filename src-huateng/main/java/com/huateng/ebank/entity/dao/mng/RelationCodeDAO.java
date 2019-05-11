package com.huateng.ebank.entity.dao.mng;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.RelationCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class RelationCodeDAO extends HibernateDaoSupport {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RelationCodeDAO.class);

	public RelationCodeDAO() {
		super();
	}

	/**
	 * 根据hibernate主键查询
	 *
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public RelationCode query(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}

		try {
			RelationCode relationCode = (RelationCode) this
					.getHibernateTemplate().load(RelationCode.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return relationCode;
		} catch (Exception e) {
			logger.error("query(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RELATION_CODE_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 根据hibernate主键查询,查询不到时返回null
	 *
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	public RelationCode queryById(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}

		try {
			RelationCode relationCode = (RelationCode) this
					.getHibernateTemplate().get(RelationCode.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return relationCode;
		} catch (Exception e) {
			logger.error("query(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RELATION_CODE_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - end"); //$NON-NLS-1$
		}
		return null;
	}
	
	/**
	 * 查询所有RelationCode信息
	 *
	 * @return
	 * @throws CommonException
	 */
	public List queryAll() throws CommonException {
		List allList = null;
		try {
			allList = this.getHibernateTemplate().find("FROM RelationCode");
			return allList;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RELATION_CODE_SELECT, e);
		}
		return allList;
	}

	/**
	 * 插入RelationCode记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(RelationCode po) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(RelationCode) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(po);
			this.getHibernateTemplate().flush();
		} catch (Exception e) {
			logger.error("insert(RelationCode)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RELATION_CODE_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(RelationCode) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 更新RelationCode记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(RelationCode po) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("update(RelationCode) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			logger.error("update(RelationCode)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RELATION_CODE_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(RelationCode) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 根据业务主键删除对应RelationCode信息
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(String) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().delete(query(id));
		} catch (Exception e) {
			logger.error("delete(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RELATION_CODE_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(String) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 删除RelationCode
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(RelationCode po) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(RelationCode) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			logger.error("delete(RelationCode)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RELATION_CODE_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(RelationCode) - end"); //$NON-NLS-1$
		}
	}

	public List queryByCondition(String whereString) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			List list = this.getHibernateTemplate().find(
					"from RelationCode po where " + whereString);

			if (logger.isDebugEnabled()) {
				logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
			}
			return list;
		} catch (Exception e) {
			logger.error("queryByCondition(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RELATION_CODE_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
		}
		return null;
	}
}
