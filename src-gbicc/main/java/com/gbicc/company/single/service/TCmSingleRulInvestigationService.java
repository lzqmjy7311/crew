package com.gbicc.company.single.service;

import com.gbicc.company.single.entity.TCmSingleRulInvestigation;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmSingleRulInvestigationService {
	protected TCmSingleRulInvestigationService() {
	}

	public synchronized static TCmSingleRulInvestigationService getInstance() {
		return (TCmSingleRulInvestigationService) ApplicationContextUtils
				.getBean(TCmSingleRulInvestigationService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCmSingleRulInvestigation get(String id) throws CommonException{
		return dao().query(TCmSingleRulInvestigation.class, id);
	}
	
	public void save(TCmSingleRulInvestigation tcmsinglerulinvestigation) throws CommonException{
		dao().save(tcmsinglerulinvestigation);
	}
	
	public void update(TCmSingleRulInvestigation tcmsinglerulinvestigation) throws CommonException{
		dao().update(tcmsinglerulinvestigation);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
