package com.gbicc.person.eliminate.service;

import com.gbicc.person.eliminate.entity.TPlRuleEliminate;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlRuleEliminateService {
	protected TPlRuleEliminateService() {
	}

	public synchronized static TPlRuleEliminateService getInstance() {
		return (TPlRuleEliminateService) ApplicationContextUtils
				.getBean(TPlRuleEliminateService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlRuleEliminate get(String id) throws CommonException{
		return dao().query(TPlRuleEliminate.class, id);
	}
	
	public void save(TPlRuleEliminate tplruleeliminate) throws CommonException{
		dao().save(tplruleeliminate);
	}
	
	public void update(TPlRuleEliminate tplruleeliminate) throws CommonException{
		dao().update(tplruleeliminate);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
