package com.gbicc.person.great.service;

import com.gbicc.person.great.entity.TPlGreatEvent;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlGreatEventService {
	protected TPlGreatEventService() {
	}

	public synchronized static TPlGreatEventService getInstance() {
		return (TPlGreatEventService) ApplicationContextUtils
				.getBean(TPlGreatEventService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlGreatEvent get(String id) throws CommonException{
		return dao().query(TPlGreatEvent.class, id);
	}
	
	public void save(TPlGreatEvent tplgreatevent) throws CommonException{
		dao().save(tplgreatevent);
	}
	
	public void update(TPlGreatEvent tplgreatevent) throws CommonException{
		dao().update(tplgreatevent);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
