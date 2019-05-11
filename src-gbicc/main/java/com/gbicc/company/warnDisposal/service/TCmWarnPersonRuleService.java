package com.gbicc.company.warnDisposal.service;

import com.gbicc.company.warnDisposal.entity.TCmWarnPersonRule;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmWarnPersonRuleService {
	protected TCmWarnPersonRuleService() {
	}

	public synchronized static TCmWarnPersonRuleService getInstance() {
		return (TCmWarnPersonRuleService) ApplicationContextUtils
				.getBean(TCmWarnPersonRuleService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCmWarnPersonRule get(String id) throws CommonException{
		return dao().query(TCmWarnPersonRule.class, id);
	}
	
	public void save(TCmWarnPersonRule tcmwarnpersonrule) throws CommonException{
		dao().save(tcmwarnpersonrule);
	}
	
	public void update(TCmWarnPersonRule tcmwarnpersonrule) throws CommonException{
		dao().update(tcmwarnpersonrule);
	}
	
	public void delete(String id) throws CommonException{
		dao().executeSql("DELETE FROM T_CM_WARN_PERSON_RULE WHERE FD_ID='"+id+"' ");
	}
}
