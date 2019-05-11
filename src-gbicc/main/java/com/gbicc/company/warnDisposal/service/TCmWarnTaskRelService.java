package com.gbicc.company.warnDisposal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.company.warnDisposal.entity.TCmWarnPersonRule;
import com.gbicc.company.warnDisposal.entity.TCmWarnTaskRel;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class TCmWarnTaskRelService {
	public TCmWarnTaskRelService() {
	}

	public synchronized static TCmWarnTaskRelService getInstance() {
		return (TCmWarnTaskRelService) ApplicationContextUtils
				.getBean(TCmWarnTaskRelService.class.getSimpleName());
	}
	
	public ROOTDAO dao(){
		return  ROOTDAOUtils.getROOTDAO();
	}
	
	public TCmWarnTaskRel get(String id) throws CommonException{
		return dao().query(TCmWarnTaskRel.class, id);
	}
	
	public void save(TCmWarnTaskRel tcmwarntaskrel) throws CommonException{
		dao().save(tcmwarntaskrel);
	}
	
	public void update(TCmWarnTaskRel tcmwarntaskrel) throws CommonException{
		dao().update(tcmwarntaskrel);
	}
	
	public void delete(String id) throws CommonException{
		dao().delete(id);
	}
	
	/**
	 * 根据任务ID查询任务的预警
	 * @param businessId
	 * @return
	 * @throws CommonException 
	 */
	public List<TCmWarnTaskRel> findByBusinessId(String businessId) throws CommonException{
		List<Object> list=this.queryListHQL("from TCmWarnTaskRel where taskId='"+businessId+"'");
		List<TCmWarnTaskRel> newList=new ArrayList<TCmWarnTaskRel>();
		if(list!=null){
			for (Object object : list) {
				newList.add((TCmWarnTaskRel)object);
			}
			return newList;
		}else{
			return newList;
		}
	}
	
	/**
	 * 人工发起预警》添加预警
	 * @param ids
	 * @param businessId
	 * @return
	 */
	public Map<String, String> addTCmWarnTaskRel(String[] paramStr){
		Map<String, String> map = new HashMap<String, String>();
		TCmWarnPersonRuleService ruleService = TCmWarnPersonRuleService.getInstance();
		TCmWarnTaskService warnTaskService = TCmWarnTaskService.getInstance();
		try{
			String[] arrStr=paramStr[0].split(",");
			for (String ruleId : arrStr) {
				if(StringUtils.isNotBlank(ruleId)){
					TCmWarnPersonRule rule=ruleService.get(ruleId);
					List<String> list=this.findRelyTaskId(paramStr[1]);
					boolean isCon=this.findCF(rule.getWarnCode(), list);
					if(isCon){//true 代表重复  跳过
						continue;
					}
					TCmWarnTaskRel domain = new TCmWarnTaskRel();
					domain.setWarnCode(rule.getWarnCode());
					domain.setWarnName(rule.getWarnName());
					domain.setWarnElimIs("0");
					domain.setWarnSubject(rule.getWarnSubjectCode());
					domain.setProcessLevel(rule.getWarnProcessLevel());
					domain.setWarnLevel(rule.getWarnLevel());
					domain.setRiskDesc(rule.getDesc());
					domain.setWarnStatus("0");
					domain.setRelieveIs("0");
					domain.setCustomerId(warnTaskService.get(paramStr[1]).getCustomerId());
					domain.setTaskId(paramStr[1]);
					domain.setWarnDate(new Date());
					this.save(domain);
				}
			}
			map.put("success", "true");
			map.put("message", "保存成功");
		}catch(Exception e){
			map.put("success", "false");
			map.put("message", "系统出错，请联系管理员");
			e.printStackTrace();
		}
		
		return map;
	}
	/**
	 * 删除
	 * @param warnId
	 * @return
	 */
	public Map<String, String> removeTCmWarnTaskRel(String warnId){
		Map<String, String> map = new HashMap<String, String>();
		try{
			if(StringUtils.isNotBlank(warnId)){
				ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
				rootdao.executeSql("DELETE FROM ECUSER.T_CM_WARN_TASK_REL WHERE FD_ID='"+warnId+"' ");
			}
			
			map.put("success", "true");
			map.put("message", "删除成功");
		}catch(Exception e){
			map.put("success", "false");
			map.put("message", "系统出错，请联系管理员");
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	/**
	 * 根据规则编号查看是否重复
	 * @param warnCode
	 * @param List<String> list=this.findRelyTaskId(taskId);
	 * @return
	 * @throws CommonException
	 */
	public boolean findCF(String warnCode,List<String> list) throws CommonException{
		boolean flg_=false;
		for (String string : list) {
			if(StringUtils.isNoneBlank(string)){
				if(string.equals(warnCode)){
					flg_=true;
					break;
				}
			}
		}
		return flg_;
	}
	
	public List<String> findRelyTaskId(String taskId) throws CommonException{
		String sql="SELECT FD_WARN_CODE FROM T_CM_WARN_TASK_REL where FD_TASK_ID='"+taskId+"'";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it=rootdao.queryBySQL(sql);
		List<String> list=new ArrayList<String>();
		while(it.hasNext()){
			list.add((String) it.next());
		}
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List queryListHQL(String hql) throws CommonException{
		return dao().queryByCondition(hql);
	}
}
