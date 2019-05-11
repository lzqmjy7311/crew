package com.gbicc.rule.service;

import com.gbicc.rule.entity.TPubRulIndustryValue;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPubRulIndustryValueService {
	public TPubRulIndustryValueService() {
	}

	public synchronized static TPubRulIndustryValueService getInstance() {
		return (TPubRulIndustryValueService) ApplicationContextUtils
				.getBean(TPubRulIndustryValueService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPubRulIndustryValue get(String id) throws CommonException{
		return dao().query(TPubRulIndustryValue.class, id);
	}
	
	public void save(TPubRulIndustryValue tpubrulindustryvalue) throws CommonException{
		dao().save(tpubrulindustryvalue);
	}
	
	public void update(TPubRulIndustryValue tpubrulindustryvalue) throws CommonException{
		dao().update(tpubrulindustryvalue);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
	
	public Integer dwrFindIndustryValue(String rulCode,String industry) throws CommonException{
		String hql="select count(id) from TPubRulIndustryValue where rulCode='"+rulCode+"' and industryCode='"+industry+"' ";
		Integer count=TPubRulIndustryValueService.getInstance().dao().queryByHqlToCount(hql);
		return count;
	}
}
