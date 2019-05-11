/**
 *
 */
package com.huateng.ebank.entity.dao.mng;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.data.mng.PfSysParam;
import com.huateng.ebank.entity.data.mng.PfSysParamPK;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: PfSysParamDAO
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-15
 */
public class PfSysParamDAO extends HibernateDaoSupport {

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return PfSysParamDef
	 * @throws CommonException
	 */
	public PfSysParam query(java.lang.String magicId, java.lang.String paramId) throws CommonException {
		try {
			PfSysParamPK pfSysParamPK = new PfSysParamPK(magicId,paramId);
			return (PfSysParam) this.getHibernateTemplate().get(PfSysParam.class,pfSysParamPK);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		return null;
	}

	/**
	 * @return
	 * @throws CommonException
	 */
	public List loadAll()throws CommonException{
		try {
			return (List)this.getHibernateTemplate().loadAll(PfSysParam.class);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		return null;
	}


	public String getPfSysParamNeedLog() {
		String needlog = "";
		try {
			PfSysParam param = this.query(SystemConstant.MAGIC_ID_NEEDLOG, SystemConstant.SYSPARAM_ID_BIZ_LOG);
			if(param!=null){
				needlog = param.getParamValueTx();
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//未配置参数表时，使用默认值 0-否
			needlog = SystemConstant.FLAG_ON;
		}
		return needlog;
	}

	public String getPfSysParamNeedQueryLog() throws CommonException{
		String needlog = "";
		try {
			PfSysParam param = this.query(SystemConstant.MAGIC_ID_NEEDQUERYLOG, SystemConstant.SYSPARAM_ID_BIZ_LOG);
			if(param!=null){
				needlog = param.getParamValueTx();
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//未配置参数表时，使用默认值 0-否
			needlog = SystemConstant.FLAG_ON;
		}
		return needlog;
	}

	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void saveOrUpdate(PfSysParam po) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(PfSysParam) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().saveOrUpdate(po);
		} catch (Exception e) {
			logger.error("insert(PfSysParam)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insert(PfSysParam) - end"); //$NON-NLS-1$
		}
	}

}
