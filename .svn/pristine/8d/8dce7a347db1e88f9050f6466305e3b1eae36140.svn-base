package com.gbicc.person.monitor.getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.monitor.service.TPlDqMonitorService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TPlDqReportWarnRulInfoGetter extends BaseGetter {

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

	@SuppressWarnings("rawtypes")
	public PageQueryResult getData() throws Exception {
		String accountId = (String) getCommQueryServletRequest().getParameterMap().get("accountId");
		String color = (String) getCommQueryServletRequest().getParameterMap().get("color");
		String rank="";
		String whStr2="";
		if(color.equals("red")){
			rank=TPlDqMonitorService.RED_WARN_LEVEL;
		}else if(color.equals("orange")){
			rank=TPlDqMonitorService.ORANGE_WARN_LEVEL;
		}else if(color.equals("yellow")){
			rank=TPlDqMonitorService.YELLOW_WARN_LEVEL;
			whStr2=" and FD_RULE_RANK='"+TPlDqMonitorService.YELLOW_WARN_LEVEL+"' ";
		}
		ROOTDAO rootDao=ROOTDAOUtils.getROOTDAO();
		String[] dates=TPlDqMonitorService.getInstance().getWarnDate(accountId);
		String startDate=dates[0];
		String endDate=dates[1];
		String whStr="";
		if(StringUtils.isNotEmpty(startDate)){
			whStr=" and FD_PROCESS_DATE>='"+startDate+"' and FD_PROCESS_DATE<'"+endDate+"' ";
		}else{
			whStr=" and FD_PROCESS_DATE='"+endDate+"' ";
		}
		Iterator it=rootDao.queryBySQL("SELECT T1.FD_ACC_ID,T1.FD_ID,T1.FD_RULE_ID,T1.FD_RULE_CODE,T1.FD_RULE_NAME,T1.FD_RULE_DESC,T1.FD_RULE_RANK,T1.FD_TRIG_DATE FROM T_PL_TASK_RULE_TRIG T1,T_PL_TASK T2 "+
		" WHERE T1.FD_ACC_ID=T2.LOAN_ACCT  AND T2.TASK_TYPE='YJ' and loan_acct='"+accountId+"' and FD_RULE_RANK='"+rank+"' "+
		whStr+
		" union all "+
		" select FD_ACC_ID,FD_ID,FD_RULE_ID,FD_RULE_CODE,FD_RULE_NAME,FD_RULE_DESC,FD_RULE_RANK,FD_TRIG_DATE from T_PL_TASK_RULE_TRIG where fd_acc_id='"+accountId+"'	"+
		whStr+whStr2);
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		while(it.hasNext()){
			Object[] obj=(Object[]) it.next();
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("accId",obj[0]);
			map.put("id",obj[1]);
			map.put("ruleId",obj[2]);
			map.put("ruleCode",obj[3]);
			map.put("ruleName",obj[4]);
			map.put("ruleDesc",obj[5]);
			map.put("ruleRank",obj[6]);
			map.put("trigDate",obj[7]!=null ? simple.format(simple.parse(obj[7].toString())) : "");
			list.add(map);
		}
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult.setQueryResult(list);
		pageQueryResult.setTotalCount(list.size());
		return pageQueryResult;
	}
}