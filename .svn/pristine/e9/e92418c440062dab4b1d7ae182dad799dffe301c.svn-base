package com.gbicc.person.eliminate.service;

import com.gbicc.person.eliminate.entity.TPlTriggerRuleAcct;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlTriggerRuleAcctService {
	protected TPlTriggerRuleAcctService() {
	}

	public synchronized static TPlTriggerRuleAcctService getInstance() {
		return (TPlTriggerRuleAcctService) ApplicationContextUtils
				.getBean(TPlTriggerRuleAcctService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlTriggerRuleAcct get(String id) throws CommonException{
		return dao().query(TPlTriggerRuleAcct.class, id);
	}
	
	public void save(TPlTriggerRuleAcct tpltriggerruleacct) throws CommonException{
		dao().save(tpltriggerruleacct);
	}
	
	public void update(TPlTriggerRuleAcct tpltriggerruleacct) throws CommonException{
		dao().update(tpltriggerruleacct);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
