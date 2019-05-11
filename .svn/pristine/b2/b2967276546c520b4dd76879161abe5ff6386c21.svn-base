package com.gbicc.rule.service;

import com.gbicc.rule.entity.TRulCategory;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TRulCategoryService {
	protected TRulCategoryService() {
	}

	public synchronized static TRulCategoryService getInstance() {
		return (TRulCategoryService) ApplicationContextUtils
				.getBean(TRulCategoryService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TRulCategory get(String id) throws CommonException{
		return dao().query(TRulCategory.class, id);
	}
	
	public void save(TRulCategory tRulCategory) throws CommonException{
		if(tRulCategory.getSno()==null||tRulCategory.getSno()<=0){
			tRulCategory.setSno(getMax());
		}
		dao().save(tRulCategory);
	}
	
	public void update(TRulCategory tRulCategory) throws CommonException{
		dao().update(tRulCategory);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(get(id));
	}
	
	public Integer getMax() throws CommonException{
		Object max=dao().queryByHqlMax("select max(sno) from TRulCategory");
		if(max==null){
			return 1;
		}else{
			return Integer.valueOf(max.toString())+1;
		}
	}
	
	public boolean isExistsCode(String code)throws CommonException{
		Object max=dao()
				.queryByHqlMax("select max(sno) from TRulCategory where categoryCode='"+code+"'");
		if(max!=null){
			return true;
		}
		return false;
	}
}
