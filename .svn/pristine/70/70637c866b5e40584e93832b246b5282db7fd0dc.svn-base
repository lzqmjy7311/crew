package com.gbicc.bpm.service;

import com.gbicc.bpm.entity.TLoanAccountRelDuty;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TLoanAccountRelDutyService {
	protected TLoanAccountRelDutyService() {
	}

	public synchronized static TLoanAccountRelDutyService getInstance() {
		return (TLoanAccountRelDutyService) ApplicationContextUtils
				.getBean(TLoanAccountRelDutyService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TLoanAccountRelDuty get(String loanacno) throws CommonException{
		return dao().query(TLoanAccountRelDuty.class,loanacno);
	}
	
	public void save(TLoanAccountRelDuty tloanaccountrelduty) throws CommonException{
		dao().save(tloanaccountrelduty);
	}
	
	public void update(TLoanAccountRelDuty tloanaccountrelduty) throws CommonException{
		dao().update(tloanaccountrelduty);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}