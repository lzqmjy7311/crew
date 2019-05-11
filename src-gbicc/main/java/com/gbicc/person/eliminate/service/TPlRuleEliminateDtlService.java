package com.gbicc.person.eliminate.service;

import java.util.Iterator;
import java.util.List;

import com.gbicc.person.eliminate.entity.TPlRuleEliminateDtl;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TPlRuleEliminateDtlService {
	public TPlRuleEliminateDtlService() {
	}

	public synchronized static TPlRuleEliminateDtlService getInstance() {
		return (TPlRuleEliminateDtlService) ApplicationContextUtils
				.getBean(TPlRuleEliminateDtlService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TPlRuleEliminateDtl get(String id) throws CommonException{
		return dao().query(TPlRuleEliminateDtl.class, id);
	}
	
	public void save(TPlRuleEliminateDtl tplruleeliminatedtl) throws CommonException{
		dao().save(tplruleeliminatedtl);
	}
	
	public void update(TPlRuleEliminateDtl tplruleeliminatedtl) throws CommonException{
		dao().update(tplruleeliminatedtl);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
	
	/**
	 * 查找排除的记录
	 * @param triggerRuleAcctId 触发规则的账户ID 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String[] dwrFindEliminateList(String triggerRuleAcctId,String flag) throws Exception{
		try {
			ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
			List<Object> list=(List<Object>)rootDao.queryByCondition("select ruleId from TPlRuleEliminateDtl where ruleElimId in (select id from TPlRuleEliminate where triggerRuleAcct.loanacno='"+triggerRuleAcctId+"') and flag='"+flag+"' ");
			String[] str=new String[list.size()];
			for(int i=0;i<list.size();i++){
				str[i]=(String) list.get(i);
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String[] dwrFindEliminateHistoryList (String ruleElimId) throws Exception{
		try {
			ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
			//List<Object> list=(List<Object>)rootDao.queryByCondition("select ruleId from TPlRuleEliminateDtl where ruleElimId in (select id from TPlRuleEliminate where triggerRuleAcct.loanacno='"+triggerRuleAcctId+"')");
			List<Object> list=(List<Object>)rootDao.queryByCondition("select ruleId from TPlRuleEliminateDtl where ruleElimId='"+ ruleElimId+"'");
			String[] str=new String[list.size()];
			for(int i=0;i<list.size();i++){
				str[i]=(String) list.get(i);
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 根据主表ID返回所有纤细信息
	 * @param eliminateId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Iterator<TPlRuleEliminateDtl> findEliminateDtlByEliminateId(String eliminateId,String flag) throws Exception{
		Iterator<TPlRuleEliminateDtl> it=dao().queryByQL("from TPlRuleEliminateDtl where ruleElimId='"+eliminateId+"' and flag='"+flag+"' ");
		return it;
	}
}
