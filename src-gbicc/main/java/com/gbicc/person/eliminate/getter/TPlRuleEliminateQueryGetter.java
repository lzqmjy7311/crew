package com.gbicc.person.eliminate.getter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TPlRuleEliminateQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	protected PageQueryResult getData() throws Exception {
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String bankname = (String) getCommQueryServletRequest().getParameterMap().get("bankname");
		String bankid = (String) getCommQueryServletRequest().getParameterMap().get("bankid");
		String custName = (String) getCommQueryServletRequest().getParameterMap().get("custName");
		String loanAcct = (String) getCommQueryServletRequest().getParameterMap().get("loanAcct");
		String startDate = (String) getCommQueryServletRequest().getParameterMap().get("startDate");
		String endDate = (String) getCommQueryServletRequest().getParameterMap().get("endDate");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer Sql = new StringBuffer("SELECT DISTINCT K.FD_RANK_FINAL AS warningLevel,T.LOANACNO AS loanAcct,T.CUSTNAME AS custName,E.FD_UPD_DATE AS updDate,"
				+ "T.PRODNAME AS productName,T.TCAPI AS loanAmt,T.BAL AS loanBalance,T.TTERM AS loanTerm,T.BANKID AS bankid,T.BANKNAME AS bankname,"
				+ "E.FD_ID AS FDID FROM T_PL_RULE_ELIMINATE E LEFT JOIN T_PL_RULE_ELIMINATE_DTL L ON E.FD_ID=L.FD_RULE_ELIM_ID LEFT JOIN T_EDW_PLS_ACCOUNT_V T ON E.FD_TRIGGER_RULE_ACCT=T.LOANACNO LEFT JOIN T_PL_TASK_RISK_RANK K "
				+ "ON E.FD_TRIGGER_RULE_ACCT=K.FD_ACC_ID WHERE 1=1 AND L.FD_FLAG='1' ");
		if(StringUtils.hasText(id)){
			Sql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(bankname)){
			Sql.append(" and T.BANKNAME like '%"+bankname+"%' ");
		}
		if(StringUtils.hasText(bankid)){
			Sql.append(" and T.BANKID='"+bankid+"' ");
		}
		if(StringUtils.hasText(custName)){
			Sql.append(" and T.CUSTNAME like '%"+custName+"%' ");
		}
		if(StringUtils.hasText(loanAcct)){
			Sql.append(" and T.LOANACNO='"+loanAcct+"' ");
		}
		
		if(StringUtils.hasText(startDate)){
			if(StringUtils.hasText(endDate)){
				Sql.append(" and E.FD_UPD_DATE BETWEEN TO_DATE('"+startDate+"','YYYY-MM-DD') AND TO_DATE('"+endDate+"','YYYY-MM-DD')");
			}
		}
		
		String countSql="SELECT COUNT(1) FROM ("+Sql+")";
		String querySql="select t.* from (select a.*, row_number() over() as r from ("+Sql+") a) t "
				+ "where t.r>("+pageIndex+"-1)*"+pageSize+" fetch first "+pageSize+" rows only";
		StringBuffer inerSql=new StringBuffer("");
		JdbcTemplate jt= (JdbcTemplate)ApplicationContextUtils.getBean("JdbcTemplate");
		List<Map<String,Object>> Querylist=jt.queryForList(querySql);
		Iterator<Map<String,Object>> it=Querylist.iterator();
		
		int i=0;
		while(it.hasNext()){
//			StringBuffer fdid=new StringBuffer();
			Map<String,Object> map=it.next();
			String LoanAcct=(String) map.get("loanAcct");
			String fdid=(String) map.get("FDID");
//			Iterator<Map<String,Object>> it1=Querylist.iterator();
//			while(it1.hasNext()){
//				Map<String,Object> map=it1.next();
//				String LoanAcct1=(String) map.get("loanAcct");
//				if(LoanAcct1.equals(LoanAcct)){
//					fdid.append(map.get("FDID")+"','");
//				}
//			}
			StringBuffer nameSql=new StringBuffer("SELECT g.FD_RULE_NAME as ruleName,G.FD_ACC_ID  FROM T_PL_TASK_RULE_TRIG G WHERE G.FD_RULE_CODE NOT IN "
					+ "(SELECT L.FD_RULE_ID FROM T_PL_RULE_ELIMINATE_DTL L WHERE L.FD_RULE_ELIM_ID IN ('"+fdid+"') AND L.FD_FLAG='1' ) "
					+ "and G.FD_ACC_ID='"+LoanAcct+"'");
			inerSql=new StringBuffer("SELECT DISTINCT G.FD_RULE_NAME as ruleName FROM T_PL_TASK_RULE_TRIG G WHERE G.FD_ACC_ID='"+LoanAcct+"'");
			List<Map<String, Object>> eliminatenameList=jt.queryForList(nameSql.toString());
			List<Map<String, Object>> nameList=jt.queryForList(inerSql.toString());
			StringBuffer eliminatenameListStr=new StringBuffer();
			StringBuffer nameListStr=new StringBuffer();
			for(int j=0;j<eliminatenameList.size();j++){
				eliminatenameListStr.append(String.valueOf(j)+"、"+eliminatenameList.get(j).get("ruleName")+"<br>");
			}
			Querylist.get(i).put("rulenameEliminate", eliminatenameListStr.toString());
			for(int j=0;j<nameList.size();j++){
				nameListStr.append(String.valueOf(j)+"、"+nameList.get(j).get("ruleName")+"<br>");
			}
			Querylist.get(i).put("ruleName", nameListStr.toString());
			i++;
		}
		int totalCount=jt.queryForInt(countSql);
		pageQueryResult.setQueryResult(Querylist);
		pageQueryResult.setTotalCount(totalCount);
		return pageQueryResult;
	}
}
