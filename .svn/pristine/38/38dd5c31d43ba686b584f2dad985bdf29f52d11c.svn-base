package com.gbicc.user.service;

import com.gbicc.user.dao.TModifiedRoleidDao;
import com.gbicc.user.entity.TModifiedRoleid;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * 
 * @author kfc
 *
 * 版本：2015年10月21日 上午11:17:41
 * 类说明：客户管理 service
 */
public class TModifiedRoleidService {
	protected TModifiedRoleidService() {
	}

	public synchronized static TModifiedRoleidService getInstance() {
		return (TModifiedRoleidService) ApplicationContextUtils
				.getBean(TModifiedRoleidService.class.getSimpleName());
	}
	
	private TModifiedRoleidDao getDao(){
		return (TModifiedRoleidDao) ApplicationContextUtils.getBean("TModifiedRoleidDao");
	}
	
	public TModifiedRoleid get(String id) throws CommonException{
		TModifiedRoleidDao dao=getDao();
		return dao.query(id);
	}
	
	public void save(TModifiedRoleid tQuality) throws CommonException{
		TModifiedRoleidDao dao=getDao();
		dao.insert(tQuality);
	}
	
	public void update(TModifiedRoleid tQuality) throws CommonException{
		TModifiedRoleidDao dao=getDao();
		dao.update(tQuality);
	}
	
	public void delete(String id) throws CommonException{
		TModifiedRoleidDao dao=getDao();
		dao.delete(id);
	}
}

