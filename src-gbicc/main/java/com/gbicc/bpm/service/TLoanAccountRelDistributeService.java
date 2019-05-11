package com.gbicc.bpm.service;

import com.gbicc.bpm.entity.TLoanAccountRelDistribute;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TLoanAccountRelDistributeService {
	protected TLoanAccountRelDistributeService() {
	}

	public synchronized static TLoanAccountRelDistributeService getInstance() {
		return (TLoanAccountRelDistributeService) ApplicationContextUtils
				.getBean(TLoanAccountRelDistributeService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TLoanAccountRelDistribute get(String id) throws CommonException{
		return dao().query(TLoanAccountRelDistribute.class, id);
	}
	
	public void save(TLoanAccountRelDistribute tloanaccountreldistribute) throws CommonException{
		dao().save(tloanaccountreldistribute);
	}
	
	public void update(TLoanAccountRelDistribute tloanaccountreldistribute) throws CommonException{
		dao().update(tloanaccountreldistribute);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
