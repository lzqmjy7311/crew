package com.huateng.ebank.entity.dao.mng;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.type.Type;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.data.mng.RoleFuncRel;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * RoleFuncRel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see com.huateng.ebank.entity.data.mng.RoleFuncRel
 * @author MyEclipse Persistence Tools
 */

public class RoleFuncRelDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(RoleFuncRelDAO.class);
	// property constants
	public static final String ROLEID = "roleId";
	public static final String FUNCID = "funcid";

	@Override
	protected void initDao() {
		// do nothing
	}

	public void save(RoleFuncRel transientInstance) {
		log.debug("saving RoleFuncRel instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleFuncRel persistentInstance) {
		log.debug("deleting RoleFuncRel instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoleFuncRel findById(java.lang.Integer id) {
		log.debug("getting RoleFuncRel instance with id: " + id);
		try {
			RoleFuncRel instance = (RoleFuncRel) getHibernateTemplate().get(
					RoleFuncRel.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RoleFuncRel instance) {
		log.debug("finding RoleFuncRel instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RoleFuncRel instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RoleFuncRel model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleid(Object roleid) {
		return findByProperty(ROLEID, roleid);
	}

	public List findByFuncid(Object funcid) {
		return findByProperty(FUNCID, funcid);
	}

	public List findAll() {
		log.debug("finding all RoleFuncRel instances");
		try {
			String queryString = "from RoleFuncRel";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleFuncRel merge(RoleFuncRel detachedInstance) {
		log.debug("merging RoleFuncRel instance");
		try {
			RoleFuncRel result = (RoleFuncRel) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoleFuncRel instance) {
		log.debug("attaching dirty RoleFuncRel instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoleFuncRel instance) {
		log.debug("attaching clean RoleFuncRel instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoleFuncRelDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (RoleFuncRelDAO) ctx.getBean("RoleFuncRelDAO");
	}
	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @param objArray
	 * @param typeArray
	 * @return 包含RoleFuncRelation对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString, Object[] objArray,
			Type[] typeArray) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from RoleFuncRel po where " + whereString, objArray );
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_ROLE_FUNC_RELATION_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含RoleFuncRelation对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from RoleFuncRel po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_ROLE_FUNC_RELATION_SELECT, e);
		}
		return null;
	}
	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(RoleFuncRel po) throws CommonException {
		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_ROLE_FUNC_RELATION_INSERT, e);
		}
	}


	/**
	 * 根据输入的条件字串查询对象集合
	 *
	 * @param String whereString 条件集合
	 * 例如 "po.name = 'user1' and po.level = '1' or ...."
	 * @param int startPage 展现层的开始页数
	 * @param int maxRows 展现层的每页记录数
		-1  :全部;
		0   :默认值;
		其他:实际值
	 * @return List 对象集合
	 * @throws DAOException
	 */
	public List queryByCondition(
		String whereString,
		int startPage,
		int maxRows)
		throws CommonException {
		List returnValue = new ArrayList();
		startPage = startPage >= 1 ? startPage : 1;
		int firstResult = (startPage - 1) * (maxRows > 0 ? maxRows : SystemConstant.MAX_ROWS);
		int rows = maxRows;
		rows = (rows == 0 ? SystemConstant.MAX_ROWS : rows);

		try {
			String hql = "from RoleFuncRel as po where ";
			hql = hql + whereString;

			Query query = this.getSession().createQuery(hql);
			query.setFirstResult(firstResult);
			if (rows != -1) {
				query.setMaxResults(rows + 1);
			}
			returnValue = query.list();

		} catch (HibernateException e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_ROLE_FUNC_RELATION_SELECT, e);
		}
		return returnValue;
	}
}