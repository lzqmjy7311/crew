package com.huateng.ebank.entity.dao.mng;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.type.Type;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * A data access object (DAO) providing persistence and search support for RoleInfo
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 *
 * @see com.resource.bean.pub.entity.data.mng.RoleInfo
 * @author MyEclipse Persistence Tools
 */

public class RoleInfoDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(RoleInfoDAO.class);
	// property constants
	public static final String ROLENAME = "rolename";
	public static final String BRANCHID = "branchid";
	public static final String STATUS = "status";

	@Override
	protected void initDao() {
		// do nothing
	}

	public void save(RoleInfo transientInstance) {
		log.debug("saving RoleInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RoleInfo persistentInstance) {
		log.debug("deleting RoleInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void update(RoleInfo po) throws CommonException {
		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_ROLE_INFO_UPDATE, e);
		}
	}
	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(RoleInfo po) throws CommonException {
		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_ROLE_INFO_INSERT, e);
		}
	}
	public RoleInfo findById(java.lang.Integer id) {
		log.debug("getting RoleInfo instance with id: " + id);
		try {
			RoleInfo instance = (RoleInfo) getHibernateTemplate().get(
					RoleInfo.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RoleInfo instance) {
		log.debug("finding RoleInfo instance by example");
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
		log.debug("finding RoleInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RoleInfo model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRolename(Object rolename) {
		return findByProperty(ROLENAME, rolename);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all RoleInfo instances");
		try {
			String queryString = "from RoleInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RoleInfo merge(RoleInfo detachedInstance) {
		log.debug("merging RoleInfo instance");
		try {
			RoleInfo result = (RoleInfo) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RoleInfo instance) {
		log.debug("attaching dirty RoleInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoleInfo instance) {
		log.debug("attaching clean RoleInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoleInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RoleInfoDAO) ctx.getBean("RoleInfoDAO");
	}


    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @param objArray
     * @param typeArray
     * @return 包含LimitParam对象的List
     * @throws CommonException
     */
    public List queryByCondition(String whereString, Object[] objArray,
            Type[] typeArray) throws CommonException {
        try {
            List list = this.getHibernateTemplate().find(
                    "from RoleInfo po where " + whereString, objArray);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_ROLE_INFO_SELECT, e);
        }
        return null;
    }

    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @return 包含LimitParam对象的List
     * @throws CommonException
     */
    public List queryByCondition(String whereString) throws CommonException {
        try {
            List list = this.getHibernateTemplate().find(
                    "from RoleInfo po where " + whereString);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_ROLE_INFO_SELECT, e);
        }
        return null;
    }
	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return RoleInfo
	 * @throws CommonException
	 */
	public RoleInfo query(int id) throws CommonException {
		try {
			return (RoleInfo) this.getHibernateTemplate().load(RoleInfo.class,
					new Integer(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_ROLE_INFO_SELECT, e);
		}
		return null;
	}

	public List queryAll() throws CommonException {
		List list = null;
		try {
			String hql = "from RoleInfo po order by po.id ";
			list = this.getSession().createQuery(hql).list();

		} catch (HibernateException e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_ROLE_INFO_SELECT, e);
		}
		return list;
	}

	/**
	 * 根据Hibernate ID删除记录
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(int id) throws CommonException {
		try {
			this.getHibernateTemplate().delete(query(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_ROLE_INFO_DELETE, e);
		}
	}


	/**
	 * 根据岗位类型获得相应的岗位id
	 * @Author zhushijie
	 * @param roleType
	 * @return
	 * @throws CommonException
	 */
	public int getRoleIdByRoleType(String roleType) throws CommonException {
		List list = this.queryByCondition("po.roleType= '" + roleType + "'");
		if (list == null || list.size() == 0) {
			ExceptionUtil.throwCommonException("没有找到岗位类型为[" + roleType
					+ "]的岗位信息", ErrorCode.ERROR_CODE_ROLE_LIST_BY_ROLETYPE);
		}
		return ((RoleInfo) (list.get(0))).getId();
	}
}