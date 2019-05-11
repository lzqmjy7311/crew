package com.gbicc.bpm.service;

import com.gbicc.bpm.entity.TTaskDivertDtl;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TTaskDivertDtlService {
	protected TTaskDivertDtlService() {
	}

	public synchronized static TTaskDivertDtlService getInstance() {
		return (TTaskDivertDtlService) ApplicationContextUtils
				.getBean(TTaskDivertDtlService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TTaskDivertDtl get(String id) throws CommonException{
		return dao().query(TTaskDivertDtl.class, id);
	}
	
	public void save(TTaskDivertDtl ttaskdivertdtl) throws CommonException{
		dao().save(ttaskdivertdtl);
	}
	
	public void update(TTaskDivertDtl ttaskdivertdtl) throws CommonException{
		dao().update(ttaskdivertdtl);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
