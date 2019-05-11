package com.gbicc.bpm.service;

import com.gbicc.bpm.entity.TLoanAccount;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TLoanAccountService {
	protected TLoanAccountService() {
	}

	public synchronized static TLoanAccountService getInstance() {
		return (TLoanAccountService) ApplicationContextUtils
				.getBean(TLoanAccountService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TLoanAccount get(String loanacno) throws CommonException{
		return dao().query(TLoanAccount.class, loanacno);
	}
	
	public void save(TLoanAccount tloanaccount) throws CommonException{
		dao().save(tloanaccount);
	}
	
	public void update(TLoanAccount tloanaccount) throws CommonException{
		dao().update(tloanaccount);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
