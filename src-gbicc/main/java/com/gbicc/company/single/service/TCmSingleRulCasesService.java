package com.gbicc.company.single.service;

import com.gbicc.company.single.entity.TCmSingleRulCases;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmSingleRulCasesService {
	protected TCmSingleRulCasesService() {
	}

	public synchronized static TCmSingleRulCasesService getInstance() {
		return (TCmSingleRulCasesService) ApplicationContextUtils
				.getBean(TCmSingleRulCasesService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCmSingleRulCases get(String id) throws CommonException{
		return dao().query(TCmSingleRulCases.class, id);
	}
	
	public void save(TCmSingleRulCases tcmsinglerulcases) throws CommonException{
		dao().save(tcmsinglerulcases);
	}
	
	public void update(TCmSingleRulCases tcmsinglerulcases) throws CommonException{
		dao().update(tcmsinglerulcases);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
