package com.huateng.ebank.entity.dao.mng;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.entity.data.mng.Holiday;


/**
 * A data access object (DAO) providing persistence and search support for
 * Holiday entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huateng.ebank.entity.data.mng.Holiday
 * @author MyEclipse Persistence Tools
 */

public class HolidayDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(HolidayDAO.class);
	// property constants
	public static final String YEAR = "year";
	public static final String HOLIDAY_DEF = "holidayDef";
	public static final String LAST_UPD_OPER_ID = "lastUpdOperId";
	public static final String LAST_UPD_TIME = "lastUpdTime";

	@Override
	protected void initDao() {
		// do nothing
	}

	public void save(Holiday holiday) {
		log.debug("saving Holiday instance");
		try {
			getHibernateTemplate().save(holiday);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Holiday persistentInstance) {
		log.debug("deleting Holiday instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Holiday findById(java.lang.Integer id) {
		log.debug("getting Holiday instance with id: " + id);
		try {
			Holiday instance = (Holiday) getHibernateTemplate().get(
					"com.huateng.ebank.entity.data.mng.Holiday", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Holiday instance) {
		log.debug("finding Holiday instance by example");
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
		log.debug("finding Holiday instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Holiday model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List findByHolidayDef(Object holidayDef) {
		return findByProperty(HOLIDAY_DEF, holidayDef);
	}

	public List findByLastUpdOperId(Object lastUpdOperId) {
		return findByProperty(LAST_UPD_OPER_ID, lastUpdOperId);
	}

	public List findByLastUpdTime(Object lastUpdTime) {
		return findByProperty(LAST_UPD_TIME, lastUpdTime);
	}

	public List findAll() {
		log.debug("finding all Holiday instances");
		try {
			String queryString = "from Holiday";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Holiday merge(Holiday detachedInstance) {
		log.debug("merging Holiday instance");
		try {
			Holiday result = (Holiday) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Holiday instance) {
		log.debug("attaching dirty Holiday instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Holiday instance) {
		log.debug("attaching clean Holiday instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HolidayDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HolidayDAO) ctx.getBean("HolidayDAO");
	}
}