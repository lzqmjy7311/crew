/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.entity.dao.mng;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class BctlDAO extends HibernateDaoSupport {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BctlDAO.class);

	public BctlDAO() {
		super();
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return Bctl
	 * @throws CommonException
	 */
	public Bctl query(String id) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
//			Bctl returnBctl = (Bctl) this.getHibernateTemplate().load(
//					Bctl.class, id);
			 Bctl returnBctl = (Bctl)this.getHibernateTemplate().get(Bctl.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return returnBctl;
		} catch (Exception e) {
			logger.error("query(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则返回null
	 *
	 * @param id
	 * @return Bctl
	 * @throws CommonException
	 */
	public Bctl queryById(String id) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("queryById(String) - start"); //$NON-NLS-1$
		}
		try {
			Bctl returnBctl = (Bctl) this.getHibernateTemplate().get(Bctl.class, id);
			if (logger.isDebugEnabled()) {
				logger.debug("queryById(String) - end"); //$NON-NLS-1$
			}
			return returnBctl;
		} catch (Exception e) {
			logger.error("queryById(String)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryById(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @param objArray
	 * @param typeArray
	 * @return 包含Bctl对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString, Object[] objArray,
			Type[] typeArray) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String, Object[], Type[]) - start"); //$NON-NLS-1$
		}

		try {
			List list = this.getHibernateTemplate().find(
					"from Bctl po where " + whereString, objArray);

			if (logger.isDebugEnabled()) {
				logger.debug("queryByCondition(String, Object[], Type[]) - end"); //$NON-NLS-1$
			}
			return list;
		} catch (Exception e) {
			logger.error("queryByCondition(String, Object[], Type[])", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String, Object[], Type[]) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含Bctl对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}

		try {
			List list = this.getHibernateTemplate().find(
					"from Bctl po where " + whereString);

			if (logger.isDebugEnabled()) {
				logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
			}
			return list;
		} catch (Exception e) {
			logger.error("queryByCondition(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
		}
		return null;
	}


	/**
	 * 根据内部机构好取到外部机构号
	 *
	 * @param whereString
	 * @return 包含Bctl对象的List
	 * @throws CommonException
	 */
	public List queryByConditionForBranchBrode(String whereString)
			throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("queryByConditionForBranchBrode(String) - start"); //$NON-NLS-1$
		}

		try {
			List list = this.getHibernateTemplate().find(
					"select brcode from Bctl po where " + whereString);

			if (logger.isDebugEnabled()) {
				logger.debug("queryByConditionForBranchBrode(String) - end"); //$NON-NLS-1$
			}
			return list;
		} catch (Exception e) {
			logger.error("queryByConditionForBranchBrode(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByConditionForBranchBrode(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 得到总行记录
	 *
	 * @return Bctl
	 * @throws CommonException
	 */
	public Bctl getHeadBranch() throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("getHeadBranch() - start"); //$NON-NLS-1$
		}
		List list = queryByCondition("po.brclass = ?",
				new Object[] { SystemConstant.BRCODE_CLASS_HEAD },
				new Type[] { Hibernate.STRING });

		if (null == list || list.size() <= 0) {
			ExceptionUtil.throwCommonException("没有找到总行机构号",
					ErrorCode.ERROR_CODE_NO_BRCODE);
		}
		Bctl returnBctl = (Bctl) list.get(0);
		if (logger.isDebugEnabled()) {
			logger.debug("getHeadBranch() - end"); //$NON-NLS-1$
		}
		return returnBctl;
	}

	/**
	 * 得到所属分行记录(直属行、省分行、辖属行)
	 * 总行返回为空
	 * @param brcode
	 * @return Bctl
	 * @throws CommonException
	 */
	public Bctl getBranchBrcode(String brcode) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("getBranchBrcode(String) - start"); //$NON-NLS-1$
		}
		Bctl po = query(brcode);
		if (po.getBrclass().equals(SystemConstant.BRCODE_CLASS_HEAD)) {
			if (logger.isDebugEnabled()) {
				logger.debug("getBranchBrcode(String) - end"); //$NON-NLS-1$
			}
			return null;
		}else{
			String blnBranchBrcode = po.getBlnBranchBrcode();
			Bctl bbbPo = query(blnBranchBrcode);
			if (logger.isDebugEnabled()) {
				logger.debug("getBranchBrcode(String) - end"); //$NON-NLS-1$
			}
			return bbbPo;
		}
	}

	/**
	 * Description: 得到管辖分行记录（直属行、省分行)
	 * @param 总行返回为空
	 * @return Bctl
	 * @exception
	 * @author shen_antonio
	 * @version v1.0,2008-9-3
	 */
	public Bctl getManageBrcode(String brcode)throws CommonException{
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("getManageBrcode(String) - start"); //$NON-NLS-1$
		}
		Bctl po = query(brcode);
		if (po.getBrclass().equals(SystemConstant.BRCODE_CLASS_HEAD)) {
			if (logger.isDebugEnabled()) {
				logger.debug("getManageBrcode(String) - end"); //$NON-NLS-1$
			}
			return null;
		}else{
			String blnManageBrcode = po.getBlnManageBrcode();
			Bctl bbbPo = query(blnManageBrcode);
			if (logger.isDebugEnabled()) {
				logger.debug("getManageBrcode(String) - end"); //$NON-NLS-1$
			}
			return bbbPo;
		}
	}

	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(Bctl po) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (logger.isDebugEnabled()) {
			logger.debug("update(Bctl) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			logger.error("update(Bctl)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_UPDATE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("update(Bctl) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(Bctl po) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (logger.isDebugEnabled()) {
			logger.debug("insert(Bctl) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			logger.error("insert(Bctl)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(Bctl) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 删除记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(Bctl po) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (logger.isDebugEnabled()) {
			logger.debug("delete(Bctl) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			logger.error("delete(Bctl)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(Bctl) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 根据Hibernate ID删除记录
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(String id) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (logger.isDebugEnabled()) {
			logger.debug("delete(String) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().delete(query(id));
		} catch (Exception e) {
			logger.error("delete(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_DELETE, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("delete(String) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * add by NT 2007-09-29 根据输入的条件字串查询 对象集合
	 *
	 * @param String
	 *            whereString 条件集合 例如 "po.name = 'user1' and po.level = '1' or
	 *            ...."
	 * @param int
	 *            startPage 展现层的开始页数
	 * @param int
	 *            maxRows 展现层的每页记录数 -1 :全部; 0 :默认值; 其他:实际值
	 * @return List 对象集合
	 * @throws DAOException
	 */
	public List queryByCondition(String whereString, int startPage, int maxRows)
			throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String, int, int) - start"); //$NON-NLS-1$
		}

		List returnValue = new ArrayList();
		startPage = startPage >= 1 ? startPage : 1;
		int firstResult = (startPage - 1)
				* (maxRows > 0 ? maxRows : SystemConstant.MAX_ROWS);
		int rows = maxRows;
		rows = (rows == 0 ? SystemConstant.MAX_ROWS : rows);

		try {
			String hql = "from Bctl as po where ";
			hql = hql + whereString;

			Query query = this.getSession().createQuery(hql);
			query.setFirstResult(firstResult);
			if (rows != -1) {
				query.setMaxResults(rows + 1);
			}
			returnValue = query.list();

		} catch (HibernateException e) {
			logger.error("queryByCondition(String, int, int)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BCTL_SELECT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String, int, int) - end"); //$NON-NLS-1$
		}
		return returnValue;
	}
}