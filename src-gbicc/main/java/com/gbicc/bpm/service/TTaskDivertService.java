package com.gbicc.bpm.service;

import com.gbicc.bpm.entity.TTaskDivert;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TTaskDivertService {
	protected TTaskDivertService() {
	}

	public synchronized static TTaskDivertService getInstance() {
		return (TTaskDivertService) ApplicationContextUtils
				.getBean(TTaskDivertService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TTaskDivert get(String id) throws CommonException{
		return dao().query(TTaskDivert.class, id);
	}
	
	public void save(TTaskDivert ttaskdivert) throws CommonException{
		dao().save(ttaskdivert);
	}
	
	public void update(TTaskDivert ttaskdivert) throws CommonException{
		dao().update(ttaskdivert);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
