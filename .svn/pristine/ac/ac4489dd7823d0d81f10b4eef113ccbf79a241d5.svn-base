package com.gbicc.bpm.getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TaskApprovalHistoryAllSelectGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(), pageResult.getQueryResult(),getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			appEx.printStackTrace();
			throw appEx;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult getData() throws Exception {
		String businessId = (String) getCommQueryServletRequest().getParameterMap().get("businessId");
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		Iterator it=rootDao.queryBySQL("select id_,act_name_,u.tlr_name||'('||i.assignee_||')' as assignee_,start_time_,end_time_ from act_hi_actinst i left join tlr_info u on i.ASSIGNEE_=u.TLRNO  "+
		" where i.PROC_INST_ID_ in (select PROC_INST_ID_ from act_hi_actinst where "+ 
		" task_id_ in (select id_ from ACT_HI_TASKINST where proc_inst_id_ in ( select proc_inst_id_ from ACT_HI_PROCINST where "+ 
		" business_key_='"+businessId+"'))) and i.END_TIME_ is not null "+
		" and EXISTS (select t.id_ from ACT_HI_TASKINST t where t.TASK_DEF_KEY_=i.act_id_ and t.delete_reason_<>'deleted') order by end_time_ desc");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		StringBuffer con=new StringBuffer(
				"select id_,act_name_,u.tlr_name||'('||i.assignee_||')' as assignee_,start_time_,end_time_ from act_hi_actinst i left join tlr_info u on i.ASSIGNEE_=u.TLRNO  "+
						" where i.PROC_INST_ID_ in (select PROC_INST_ID_ from act_hi_actinst where "+ 
						" task_id_ in (select id_ from ACT_HI_TASKINST where proc_inst_id_ in ( select proc_inst_id_ from ACT_HI_PROCINST where "+ 
						" business_key_='"+businessId+"'))) and i.END_TIME_ is not null "+
						" and EXISTS (select t.id_ from ACT_HI_TASKINST t where t.TASK_DEF_KEY_=i.act_id_ and t.delete_reason_<>'deleted') order by end_time_ desc");
		System.out.println(con.toString());
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(it.hasNext()){
			Object[] obj=(Object[]) it.next();
			Map<String,String> map=new HashMap<String, String>();
			Map<String, String> m=findApprovalOpinion(obj[0].toString(),rootDao);
			map.put("taskName",obj[1].toString());
			map.put("assignee",obj[2]!=null ? obj[2].toString() : "");
			map.put("startTime",obj[3]!=null ? simple.format(simple.parse(obj[3].toString())) : "");
			map.put("endTime",obj[4]!=null ? simple.format(simple.parse(obj[4].toString())) : "");
			map.put("opinion",m.get("opinion"));
			map.put("operation",m.get("operation"));
			list.add(map);
		}
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult.setQueryResult(list);
		pageQueryResult.setTotalCount(list.size());
		return pageQueryResult;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, String> findApprovalOpinion(String actInstId,ROOTDAO rootDao) throws Exception{
		Map<String,String> map=new HashMap<String, String>(); 
		Iterator it=rootDao.queryBySQL("select name_,text_ from act_hi_detail where act_inst_id_='"+actInstId+"' ");
		while(it.hasNext()){
			Object[] obj=(Object[]) it.next();
			map.put(obj[0].toString(),obj[1]!=null ? obj[1].toString() : "");
		}
		return map;
	}
}
