package com.gbicc.company.warnDisposal.service;

import com.gbicc.company.warnDisposal.entity.TCmCustomer;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmCustomerService {
	protected TCmCustomerService() {
	}

	public synchronized static TCmCustomerService getInstance() {
		return (TCmCustomerService) ApplicationContextUtils
				.getBean(TCmCustomerService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCmCustomer get(String id) throws CommonException{
		return dao().query(TCmCustomer.class, id);
	}
	
	public void save(TCmCustomer tcmcustomer) throws CommonException{
		dao().save(tcmcustomer);
	}
	
	public void update(TCmCustomer tcmcustomer) throws CommonException{
		dao().update(tcmcustomer);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
