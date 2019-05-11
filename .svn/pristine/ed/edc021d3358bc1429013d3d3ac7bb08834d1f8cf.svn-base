package com.gbicc.company.view.relevance.getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gbicc.bpm.operation.TaskAfreshAssignOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
 
 @SuppressWarnings("unchecked")
 public class TpRelevanceGetter extends BaseGetter {

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
 			throw appEx;
 		} catch (Exception ex) {
 			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
 		}
 	}

 	public PageQueryResult getData() throws Exception {
 		String custId = (String) getCommQueryServletRequest().getParameterMap().get("custId");
 		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
 		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		String sql="select t.PROC_INST_ID_,def.NAME_,t.NAME_ as taskName,t.DESCRIPTION_,t.ID_,t.ASSIGNEE_,t.CREATE_TIME_,t.SUSPENSION_STATE_,def.key_ from act_ru_task t join ACT_RE_PROCDEF def "+
 		" on t.PROC_DEF_ID_=def.id_ where 1=1 ";
// 		sql+="and proc_inst_id_ not in (select proc_inst_id_ from act_ru_execution where business_key_ in (select dtl.FD_BUSINESS_KEY from T_TASK_DIVERT_dtl dtl join T_TASK_DIVERT d "+
// 		" on dtl.FD_TASK_DIVERT_ID=d.FD_ID where d.FD_STATUS='"+TaskAfreshAssignOperation.STATUS+"')) ";
 	
 		sql+=" order by def.NAME_ asc,t.proc_inst_id_ desc,t.CREATE_TIME_ desc ";
 		int pageSize = getResult().getPage().getEveryPage();// 分页大小
 		int pageIndex = getResult().getPage().getCurrentPage();// 页码
 		PageQueryCondition queryCondition = new PageQueryCondition();
 		queryCondition.setPageIndex(pageIndex);
 		queryCondition.setPageSize(pageSize);
 		queryCondition.setQueryString(sql.toString());
 		//queryCondition.setObjArray(param.toArray());
 		PageQueryResult result = (PageQueryResult) rootdao.pageQueryBySQL(queryCondition);
 		List<Object[]> list=result.getQueryResult();
 		List<Map<String,String>> resultList=new ArrayList<Map<String,String>>();
 		for(Object[] obj:list){
 			Map<String,String> map=new HashMap<String, String>();
 			map.put("relevanceType",obj[0].toString());
 			map.put("customerNum",obj[1].toString());
 			map.put("chineseName",obj[2].toString());
 			map.put("affiliatedCertficateNum",obj[3]!=null ? obj[3].toString() : "");
 			map.put("residence",obj[4].toString());
 			map.put("educationBackground",obj[0].toString());
 			map.put("outstandingloanNum",obj[1].toString());
 			map.put("loanBal",obj[2].toString());
 			map.put("creditLevel",obj[3]!=null ? obj[3].toString() : "");
 			map.put("warningLevel",obj[4].toString());
 		
 			resultList.add(map);
 		}
 		result.setQueryResult(resultList);
 		return result;
 	}
 }

