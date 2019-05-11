package com.gbicc.person.creditMemo.service;

import com.gbicc.person.creditMemo.entity.TPlCreditMemo;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlCreditMemoService {
	protected TPlCreditMemoService() {
	}

	public synchronized static TPlCreditMemoService getInstance() {
		return (TPlCreditMemoService) ApplicationContextUtils
				.getBean(TPlCreditMemoService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlCreditMemo get(String id) throws CommonException{
		return dao().query(TPlCreditMemo.class, id);
	}
	
	public void save(TPlCreditMemo tplcreditmemo) throws CommonException{
		dao().save(tplcreditmemo);
	}
	
	public void update(TPlCreditMemo tplcreditmemo) throws CommonException{
		dao().update(tplcreditmemo);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
}
