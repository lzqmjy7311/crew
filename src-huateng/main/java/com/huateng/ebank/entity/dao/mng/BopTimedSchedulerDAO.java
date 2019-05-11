package com.huateng.ebank.entity.dao.mng;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.mng.TblCronTaskJob;
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

public class BopTimedSchedulerDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(BopTimedSchedulerDAO.class);

	@Override
	protected void initDao() {
		// do nothing
	}


	public void save(TblCronTaskJob transientInstance) {
		log.debug("saving TblCronTaskJob instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TblCronTaskJob persistentInstance) {
		log.debug("deleting TblCronTaskJob instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void update(TblCronTaskJob po) throws CommonException {
		log.debug("updating TblCronTaskJob instance");
		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DATA_DIC_UPDATE, e);
			log.error("update failed", e);
		}
	}
}