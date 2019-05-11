package com.gbicc.company.single.service;

import com.gbicc.company.single.entity.TCmSingleRulCasesDutyinfo;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmSingleRulCasesDutyinfoService {
	protected TCmSingleRulCasesDutyinfoService() {
	}

	public synchronized static TCmSingleRulCasesDutyinfoService getInstance() {
		return (TCmSingleRulCasesDutyinfoService) ApplicationContextUtils
				.getBean(TCmSingleRulCasesDutyinfoService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCmSingleRulCasesDutyinfo get(String id) throws CommonException{
		return dao().query(TCmSingleRulCasesDutyinfo.class, id);
	}
	
	public void save(TCmSingleRulCasesDutyinfo tcmsinglerulcasesdutyinfo) throws CommonException{
		dao().save(tcmsinglerulcasesdutyinfo);
	}
	
	public void update(TCmSingleRulCasesDutyinfo tcmsinglerulcasesdutyinfo) throws CommonException{
		dao().update(tcmsinglerulcasesdutyinfo);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
