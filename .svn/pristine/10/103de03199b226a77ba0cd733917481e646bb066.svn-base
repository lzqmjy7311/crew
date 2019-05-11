package com.gbicc.warn.ComninationWarn.service;

import com.gbicc.warn.ComninationWarn.entity.TCwIdnexManage;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCwIdnexManageService {
	protected TCwIdnexManageService() {
	}

	public synchronized static TCwIdnexManageService getInstance() {
		return (TCwIdnexManageService) ApplicationContextUtils
				.getBean(TCwIdnexManageService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCwIdnexManage get(String id) throws CommonException{
		return dao().query(TCwIdnexManage.class, id);
	}
	
	public void save(TCwIdnexManage tcwidnexmanage) throws CommonException{
		dao().save(tcwidnexmanage);
	}
	
	public void update(TCwIdnexManage tcwidnexmanage) throws CommonException{
		dao().update(tcwidnexmanage);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
