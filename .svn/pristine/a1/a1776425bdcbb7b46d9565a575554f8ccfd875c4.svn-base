package com.gbicc.person.monitor.service;

import com.gbicc.person.monitor.entity.TPlControlmeasure;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlControlmeasureService {
	protected TPlControlmeasureService() {
	}

	public synchronized static TPlControlmeasureService getInstance() {
		return (TPlControlmeasureService) ApplicationContextUtils
				.getBean(TPlControlmeasureService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlControlmeasure get(String id) throws CommonException{
		return dao().query(TPlControlmeasure.class, id);
	}
	
	public void save(TPlControlmeasure tplcontrolmeasure) throws CommonException{
		dao().save(tplcontrolmeasure);
	}
	
	public void update(TPlControlmeasure tplcontrolmeasure) throws CommonException{
		dao().update(tplcontrolmeasure);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
