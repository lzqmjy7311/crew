package com.gbicc.bpm.getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gbicc.bpm.pojo.ExtProcessOpinion;
import com.gbicc.bpm.service.ProcessManagerService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TaskApprovalHistoryGetter extends BaseGetter {

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
		String businessId = (String) getCommQueryServletRequest().getParameterMap().get("businessId");
		List<ExtProcessOpinion> list=
				ProcessManagerService.getInstace().findProcessHistoryOpinions(businessId);
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
