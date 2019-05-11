package com.gbicc.warn.ComninationWarn.service;

import com.gbicc.warn.ComninationWarn.entity.TCwThresholdversion;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCwThresholdversionService {
	protected TCwThresholdversionService() {
	}

	public synchronized static TCwThresholdversionService getInstance() {
		return (TCwThresholdversionService) ApplicationContextUtils
				.getBean(TCwThresholdversionService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCwThresholdversion get(String id) throws CommonException{
		return dao().query(TCwThresholdversion.class, id);
	}
	
	public void save(TCwThresholdversion tcwthresholdversion) throws CommonException{
		dao().save(tcwthresholdversion);
	}
	
	public void update(TCwThresholdversion tcwthresholdversion) throws CommonException{
		dao().update(tcwthresholdversion);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
