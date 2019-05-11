package com.gbicc.warn.service;

import com.gbicc.warn.dao.TWarnDisposalRepDAO;
import com.gbicc.warn.entity.TWarnDisposalRep;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author likm
 * @time   2015年10月27日16:11:28
 * @desc   产品管理服务类
 */
public class TWarnDisposalRepService {
	protected TWarnDisposalRepService() {
	}

	public synchronized static TWarnDisposalRepService getInstance() {
		return (TWarnDisposalRepService) ApplicationContextUtils
				.getBean(TWarnDisposalRepService.class.getSimpleName());
	}
	
	private TWarnDisposalRepDAO getDao(){
		return (TWarnDisposalRepDAO) ApplicationContextUtils.getBean("TWarnDisposalRepDAO");
	}
	
	public TWarnDisposalRep get(String id) throws CommonException{
		TWarnDisposalRepDAO dao=getDao();
		return dao.getHibernateTemplate().get(TWarnDisposalRep.class, id);
	}
	
	public void save(TWarnDisposalRep TWarnDisposalRep) throws CommonException{
		TWarnDisposalRepDAO dao=getDao();
		dao.getHibernateTemplate().save(TWarnDisposalRep);
	}
	
	public void update(TWarnDisposalRep TWarnDisposalRep)throws CommonException{
		TWarnDisposalRepDAO dao=getDao();
		dao.getHibernateTemplate().update(TWarnDisposalRep);
	}
	
	public void delete(TWarnDisposalRep TWarnDisposalRep)throws CommonException{
		TWarnDisposalRepDAO dao=getDao();
		dao.getHibernateTemplate().delete(TWarnDisposalRep);
	}
}
