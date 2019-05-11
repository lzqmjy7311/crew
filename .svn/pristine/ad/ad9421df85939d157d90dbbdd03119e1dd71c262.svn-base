package com.gbicc.person.customer.service;

import com.gbicc.person.customer.entity.TPlCustGreatEvent;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlCustGreatEventService {
	protected TPlCustGreatEventService() {
	}

	public synchronized static TPlCustGreatEventService getInstance() {
		return (TPlCustGreatEventService) ApplicationContextUtils
				.getBean(TPlCustGreatEventService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlCustGreatEvent get(String id) throws CommonException{
		return dao().query(TPlCustGreatEvent.class, id);
	}
	
	public void save(TPlCustGreatEvent tplcustgreatevent) throws CommonException{
		dao().save(tplcustgreatevent);
	}
	
	public void update(TPlCustGreatEvent tplcustgreatevent) throws CommonException{
		dao().update(tplcustgreatevent);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
