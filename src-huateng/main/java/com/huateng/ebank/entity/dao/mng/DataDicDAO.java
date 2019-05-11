package com.huateng.ebank.entity.dao.mng;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * DataDic entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 *
 * @see com.huateng.ebank.entity.data.mng.DataDic
 * @author MyEclipse Persistence Tools
 */

public class DataDicDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(DataDicDAO.class);
	// property constants
	public static final String DATA_TYPE_NO = "dataTypeNo";
	public static final String DATA_NO = "dataNo";
	public static final String DATA_TYPE_NAME = "dataTypeName";
	public static final String DATA_NO_LEN = "dataNoLen";
	public static final String DATA_NAME = "dataName";
	public static final String LIMIT_FLAG = "limitFlag";
	public static final String HIGH_LIMIT = "highLimit";
	public static final String LOW_LIMIT = "lowLimit";
	public static final String EFFECT_DATE = "effectDate";
	public static final String EXPIRE_DATE = "expireDate";
	public static final String TIMESTAMPS = "timestamps";
	public static final String MISCFLGS = "miscflgs";

	@Override
	protected void initDao() {
		// do nothing
	}

	public void save(DataDic transientInstance) {
		log.debug("saving DataDic instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DataDic persistentInstance) {
		log.debug("deleting DataDic instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataDic findById(java.lang.String id) {
		log.debug("getting DataDic instance with id: " + id);
		try {
			DataDic instance = (DataDic) getHibernateTemplate().get(
					DataDic.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(DataDic instance) {
		log.debug("finding DataDic instance by example");
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
		log.debug("finding DataDic instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DataDic model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDataTypeNo(Object dataTypeNo) {
		return findByProperty(DATA_TYPE_NO, dataTypeNo);
	}

	public List findByDataNo(Object dataNo) {
		return findByProperty(DATA_NO, dataNo);
	}

	public List findByDataTypeName(Object dataTypeName) {
		return findByProperty(DATA_TYPE_NAME, dataTypeName);
	}

	public List findByDataNoLen(Object dataNoLen) {
		return findByProperty(DATA_NO_LEN, dataNoLen);
	}

	public List findByDataName(Object dataName) {
		return findByProperty(DATA_NAME, dataName);
	}

	public List findByLimitFlag(Object limitFlag) {
		return findByProperty(LIMIT_FLAG, limitFlag);
	}

	public List findByHighLimit(Object highLimit) {
		return findByProperty(HIGH_LIMIT, highLimit);
	}

	public List findByLowLimit(Object lowLimit) {
		return findByProperty(LOW_LIMIT, lowLimit);
	}

	public List findByEffectDate(Object effectDate) {
		return findByProperty(EFFECT_DATE, effectDate);
	}

	public List findByExpireDate(Object expireDate) {
		return findByProperty(EXPIRE_DATE, expireDate);
	}

	public List findByTimestamps(Object timestamps) {
		return findByProperty(TIMESTAMPS, timestamps);
	}

	public List findByMiscflgs(Object miscflgs) {
		return findByProperty(MISCFLGS, miscflgs);
	}

	public List findAll() {
		log.debug("finding all DataDic instances");
		try {
			String queryString = "from DataDic";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DataDic merge(DataDic detachedInstance) {
		log.debug("merging DataDic instance");
		try {
			DataDic result = (DataDic) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DataDic instance) {
		log.debug("attaching dirty DataDic instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataDic instance) {
		log.debug("attaching clean DataDic instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含DataDic对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		try {
			List list = this.getHibernateTemplate().find(
					"from DataDic po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DATA_DIC_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return DataDic
	 * @throws CommonException
	 */
	public DataDic query(long id) throws CommonException {
		try {
			this.getHibernateTemplate().setCacheQueries(true);
			return (DataDic) this.getHibernateTemplate().load(DataDic.class,
					new Long(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DATA_DIC_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据数据字典类型返回字典列表
	 *
	 * @param dataTypeNo数据字典类型
	 * @return List
	 * @throws CommonException
	 */
	public List getDataByTypeNo(int dataTypeNo) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		try {
			List list = this.getHibernateTemplate().find(
					"from DataDic po where po.dataTypeNo = ? order by po.dataNo",
					new Integer(dataTypeNo));
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DATA_DIC_SELECT, e);
		}
		return null;
	}

	/**
	 * 导出　DataDic　数据表数据
	 * @return
	 * @throws CommonException
	 * @author shen_antonio
	 */
	public List loadAll()throws CommonException{
		try {
			//getHibernateTemplate().setEntityInterceptor(new HibernateInterceptor());
			return  this.getHibernateTemplate().loadAll(DataDic.class);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DATA_DIC_SELECT, e);
		}
		return null;
	}

	public List loadAllSort()throws CommonException{
		this.getHibernateTemplate().setCacheQueries(true);
		try {
			List list = this.getHibernateTemplate().find(
					"from DataDic po order by po.dataTypeNo,po.dataNo");
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DATA_DIC_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据业务主键查询，如果没有找到记录，则返回null
	 *
	 * @param dataTypeNo
	 * @param dataNo
	 * @return DataDic
	 * @throws CommonException
	 */
	public DataDic query(int dataTypeNo, String dataNo) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		List list = new ArrayList();
		try {
			StringBuffer whereString = new StringBuffer();
			String[] str = null;
			if(dataNo != null && !"".equals(dataNo)) {
				str = dataNo.split(",");
			} 
			if(str == null) {
				whereString.append("po.dataTypeNo = ").append(dataTypeNo);
			} else if(str.length == 0){
				whereString.append("po.dataTypeNo = ").append(dataTypeNo).append(
				" and po.dataNo = '").append(dataNo).append("'");
			} else {
				whereString.append("po.dataTypeNo = ").append(dataTypeNo).append(" and po.dataNo in (");
				for(int i = 0; i < str.length; i++) {
					whereString.append("'" + str[i] +"',");
				}
				whereString.deleteCharAt(whereString.toString().length() - 1);
				whereString.append(")");
			
			}
			list = queryByCondition(whereString.toString());
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DATA_DIC_SELECT, e);
		}

		if (list.size() != 1) {
			return null;
		} else {
			return (DataDic) list.get(0);
		}
	}

	public static DataDicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DataDicDAO) ctx.getBean("DataDicDAO");
	}

	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(DataDic po) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		try {
			this.getHibernateTemplate().getSessionFactory().evictQueries("DataDic");
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DATA_DIC_UPDATE, e);
		}
	}

	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(DataDic po) throws CommonException {
		try {
			this.getHibernateTemplate().setCacheQueries(false);
			this.getHibernateTemplate().getSessionFactory().evictQueries("DataDic");
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DATA_DIC_INSERT, e);
		}
	}
}