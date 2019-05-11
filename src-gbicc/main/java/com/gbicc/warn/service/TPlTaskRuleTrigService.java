package com.gbicc.warn.service;

import com.gbicc.personCommon.entity.TPlTaskRuleTrig;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlTaskRuleTrigService {
	protected TPlTaskRuleTrigService() {
	}

	public synchronized static TPlTaskRuleTrigService getInstance() {
		return (TPlTaskRuleTrigService) ApplicationContextUtils
				.getBean(TPlTaskRuleTrigService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlTaskRuleTrig get(String id) throws CommonException{
		return dao().query(TPlTaskRuleTrig.class, id);
	}
	
	public void save(TPlTaskRuleTrig tpltaskruletrig) throws CommonException{
		dao().save(tpltaskruletrig);
	}
	
	public void update(TPlTaskRuleTrig tpltaskruletrig) throws CommonException{
		dao().update(tpltaskruletrig);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
