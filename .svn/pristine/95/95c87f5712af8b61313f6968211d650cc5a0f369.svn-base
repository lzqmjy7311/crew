package com.gbicc.person.customer.service;

import com.gbicc.person.customer.entity.TPlCustGreatEventDtl;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlCustGreatEventDtlService {
	protected TPlCustGreatEventDtlService() {
	}

	public synchronized static TPlCustGreatEventDtlService getInstance() {
		return (TPlCustGreatEventDtlService) ApplicationContextUtils
				.getBean(TPlCustGreatEventDtlService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlCustGreatEventDtl get(String id) throws CommonException{
		return dao().query(TPlCustGreatEventDtl.class, id);
	}
	
	public void save(TPlCustGreatEventDtl tplcustgreateventdtl) throws CommonException{
		dao().save(tplcustgreateventdtl);
	}
	
	public void update(TPlCustGreatEventDtl tplcustgreateventdtl) throws CommonException{
		dao().update(tplcustgreateventdtl);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
