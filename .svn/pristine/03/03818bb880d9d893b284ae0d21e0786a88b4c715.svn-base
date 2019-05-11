package com.gbicc.company.single.service;

import java.util.List;

import com.gbicc.company.single.entity.TCmSingleRulInveRelWarning;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmSingleRulInveRelWarningService {
	public TCmSingleRulInveRelWarningService() {
	}

	public synchronized static TCmSingleRulInveRelWarningService getInstance() {
		return (TCmSingleRulInveRelWarningService) ApplicationContextUtils
				.getBean(TCmSingleRulInveRelWarningService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCmSingleRulInveRelWarning get(String id) throws CommonException{
		return dao().query(TCmSingleRulInveRelWarning.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public TCmSingleRulInveRelWarning getByWarnId(String inveId,String warnId) throws CommonException{
		List<TCmSingleRulInveRelWarning> list=dao().queryByCondition("from TCmSingleRulInveRelWarning where inveId='"+inveId+"' and warningId='"+warnId+"' ");
		if(null!=list && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public void save(TCmSingleRulInveRelWarning tcmsinglerulinverelwarning) throws CommonException{
		dao().save(tcmsinglerulinverelwarning);
	}
	
	public void update(TCmSingleRulInveRelWarning tcmsinglerulinverelwarning) throws CommonException{
		dao().update(tcmsinglerulinverelwarning);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
	
	/**
	 * 查找预警信号ID
	 * @param inveId 协查任务ID 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String[] dwrFindWarningIds(String inveId) throws Exception{
		try {
			ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
			List<Object> list=(List<Object>)rootDao.queryByCondition("select warningId from TCmSingleRulInveRelWarning where inveId='"+inveId+"' ");
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
	 * 查找关联的预警信号数量
	 * @param warningIds
	 * @return
	 * @throws Exception 
	 */
	public Integer dwrFindWarningCount(String warningIds) throws Exception{
		String ids="";
		if(warningIds.indexOf(",")>-1){
			String[] str=warningIds.split(",");
			for(String s:str){
				ids=ids+"'"+s+"'"+",";
			}
			ids=ids.substring(0,ids.length()-1);
		}else{
			ids="'"+warningIds+"'";
		}
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		Object obj=rootDao.queryByHqlToCount("select count(id) from TCmSingleRulInveRelWarning where warningId in ("+ids+") ");
		return Integer.valueOf(obj.toString());
	}
}