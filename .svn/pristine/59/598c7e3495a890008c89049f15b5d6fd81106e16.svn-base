package com.gbicc.company.warnDisposal.service;

import com.gbicc.company.warnDisposal.entity.TCmWarnControlmeasure;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmWarnControlmeasureService {
	protected TCmWarnControlmeasureService() {
	}

	public synchronized static TCmWarnControlmeasureService getInstance() {
		return (TCmWarnControlmeasureService) ApplicationContextUtils
				.getBean(TCmWarnControlmeasureService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCmWarnControlmeasure get(String id) throws CommonException{
		return dao().query(TCmWarnControlmeasure.class, id);
	}
	
	public void save(TCmWarnControlmeasure tcmwarncontrolmeasure) throws CommonException{
		dao().save(tcmwarncontrolmeasure);
	}
	
	public void update(TCmWarnControlmeasure tcmwarncontrolmeasure) throws CommonException{
		dao().update(tcmwarncontrolmeasure);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
