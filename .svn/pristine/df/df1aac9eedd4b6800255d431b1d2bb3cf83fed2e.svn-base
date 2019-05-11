package com.huateng.ebank.entity.dao.mng;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.BhProcStatus;
import com.huateng.ebank.entity.data.mng.BhProcStep;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * BatchProcessStep entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see com.huateng.ebank.BhProcStep.data.mng.BatchProcessStep
 * @author MyEclipse Persistence Tools
 */

public class BhProcStepDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(BhProcStepDAO.class);
	// property constants
	@Override
	protected void initDao() {
		// do nothing
	}

	public BhProcStep findById(java.lang.Integer id) {
		log.debug("getting BhProcStep instance with id: " + id);
		try {
			BhProcStep instance = (BhProcStep) getHibernateTemplate()
					.get(BhProcStep.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BhProcStep instance) {
		log.debug("finding BhProcStep instance by example");
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
		log.debug("finding BhProcStep instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BhProcStep model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all BhProcStep instances");
		try {
			String queryString = "from BhProcStep";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/**join step with status*/
	public List findByProperties(HashMap parameters){
		log.debug("finding all BhProcStep instances with properties");
		try {
			StringBuffer queryStringBuilder =new StringBuffer("select step,status from BhProcStep step,BhProcStatus status ");
			queryStringBuilder.append(" where step.jobno=status.jobno and step.step=status.step and step.subStep=status.subStep ");
			//批量日期加入
			String bhDate=(String)parameters.get("bhdate");
			if(bhDate!=null){
				queryStringBuilder.append(" and status.bhdate = '");
				queryStringBuilder.append(bhDate);
				queryStringBuilder.append("' ");
			}

			//runtime参数
			List<String> runtimes=(List)parameters.get("runtimes");
			if(runtimes!=null&&runtimes.size()>0){
				queryStringBuilder.append(" and step.runtime in ('999'");
				for(String runtime:runtimes){
					queryStringBuilder.append(","+runtime);
				}
				queryStringBuilder.append(")");
			}

			//status参数
			String status=(String)parameters.get("status");
			if(status!=null){
				queryStringBuilder.append(" and status.status='"+status+"'");
			}
			return getHibernateTemplate().find(queryStringBuilder.toString());
		} catch (RuntimeException re) {
			log.error("finding all BhProcStep instances with properties", re);
			throw re;
		}
	}

	/**step only*/
	public List findStepsByRuntimes(List<String> runtimes){
		log.debug("finding all BhProcStep instances with properties");
		try {
			StringBuffer queryStringBuilder =new StringBuffer("from BhProcStep step ");
			queryStringBuilder.append(" where 1=1 ");

			//runtime参数
			if(runtimes!=null&&runtimes.size()>0){
				queryStringBuilder.append(" and step.runtime in ('99'");
				for(String runtime:runtimes){
					queryStringBuilder.append(",'"+runtime+"'");
				}
				queryStringBuilder.append(")");
			}
			queryStringBuilder.append(" order by step.jobno,step.step,step.subStep ");
			return getHibernateTemplate().find(queryStringBuilder.toString());
		} catch (RuntimeException re) {
			log.error("finding all BhProcStep instances with properties", re);
			throw re;
		}
	}

	public BhProcStatus findStatusByStep(BhProcStep step,String bhDate){
		log.debug("finding all BhProcStep instances with properties");
		try {
			StringBuffer queryStringBuilder =new StringBuffer("from BhProcStatus status ");
			queryStringBuilder.append(" where ");
			queryStringBuilder.append(" status.jobno="+step.getJobno());
			queryStringBuilder.append(" and status.step="+step.getStep());
			queryStringBuilder.append(" and status.subStep="+step.getSubStep());
			queryStringBuilder.append(" and status.bhdate ='"+bhDate+"'");

			List result= getHibernateTemplate().find(queryStringBuilder.toString());
			if(result.size()==0){
				return null;
			}
			return (BhProcStatus)result.get(0);
		} catch (RuntimeException re) {
			log.error("finding all BhProcStep instances with properties", re);
			throw re;
		}
	}
	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(BhProcStep po) throws CommonException {
		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_INSERT, e);
		}
	}
	/**
	 * 删除记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(BhProcStep po) throws CommonException {
		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_DELETE, e);
		}
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
					ErrorCode.ERROR_CODE_BHPROC_STEP_DELETE, e);
		}
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return BhProcStep
	 * @throws CommonException
	 */
	public BhProcStep query(int id) throws CommonException {
		try {
			return (BhProcStep) this.getHibernateTemplate().load(BhProcStep.class,
					new Integer(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_SELECT, e);
		}
		return null;
	}
	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(BhProcStep po) throws CommonException {
		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_UPDATE, e);
		}
	}
	
	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含RoleInfo对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from BhProcStep po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_SELECT, e);
		}
		return null;
	}
}