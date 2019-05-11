package com.gbicc.person.QualitySup.getter;

import java.util.Iterator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;



import com.gbicc.bpm.SpringContextHolder;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class QualitySupGetter extends BaseGetter{

	private float flagnum=0;
	private int totalCount=0;
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
//			List list=pageResult.getQueryResult();
//			int subnum=(int)(list.size()*(flagnum/100));
//			List queryResult=list.subList(0, subnum);
//			pageResult.setQueryResult(queryResult);
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
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String queryflag="abc";
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String bankname = (String) getCommQueryServletRequest().getParameterMap().get("bankname");
		String productName = (String) getCommQueryServletRequest().getParameterMap().get("productName");
		String lounAcc = (String) getCommQueryServletRequest().getParameterMap().get("lounAcc");
		String custName = (String) getCommQueryServletRequest().getParameterMap().get("custName");
		String warnLevel = (String) getCommQueryServletRequest().getParameterMap().get("warningLevel");
		String loanAmt = (String) getCommQueryServletRequest().getParameterMap().get("loanAmt");
		String loanBalance = (String) getCommQueryServletRequest().getParameterMap().get("loanBalance");
		String loanTerm = (String) getCommQueryServletRequest().getParameterMap().get("loanTerm");
		String handler = (String) getCommQueryServletRequest().getParameterMap().get("handler");
		String taskType = (String) getCommQueryServletRequest().getParameterMap().get("taskType");
		String warnRule = (String) getCommQueryServletRequest().getParameterMap().get("warnRule");
		String warnDesc = (String) getCommQueryServletRequest().getParameterMap().get("warnDesc");
		String qualitysupperc = (String) getCommQueryServletRequest().getParameterMap().get("qualitysupperc");
		queryflag = (String) getCommQueryServletRequest().getParameterMap().get("queryflag");
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		if(queryflag==null){
			queryflag="abc";
		}
		if(qualitysupperc==null)
		{
			qualitysupperc="100";
		}
		String userId=info.getTlrno();
		PageQueryResult pageQueryResult = new PageQueryResult();
		if(queryflag.equals("queryflag")){
			StringBuffer deletesql=new StringBuffer("delete from T_PL_QUALITYSUP_QUERYTEMP WHERE 1=1 AND USERNAME= '"+userId+"'");
			StringBuffer querysql=new StringBuffer("INSERT INTO T_PL_QUALITYSUP_QUERYTEMP  (FD_ID,WARN_LEVEL,LOAN_ACCT,CUST_NAME,CUST_CODE,LOAN_VARIETY,LOAN_AMT,LOAN_BALANCE,LOAN_TERM,RPT_STATUS,TASK_MATURE_DATE,HANDLER,REPORT_ID,REPORT_URL,TASK_TYPE,WARN_RULE,WARN_DESC,PRODUCT_NAME,BANKNAME,COMPLETE_DATE,TASK_CREAT_DATE,USERNAME) SELECT UUID(),t1.WARN_LEVEL,t1.LOAN_ACCT,t1.CUST_NAME,t1.CUST_CODE,t1.LOAN_VARIETY,t1.LOAN_AMT,t1.LOAN_BALANCE,t1.LOAN_TERM,t1.RPT_STATUS,t1.TASK_MATURE_DATE,t1.OPERNAME,t1.REPORT_ID,t1.REPORT_URL,t1.TASK_TYPE,'','',t1.PRODNAME,t1.BANKNAME,t1.COMPLETE_DATE,t1.TASK_CREAT_DATE ,'"+userId+"' from (SELECT t.WARN_LEVEL,t.LOAN_ACCT,t.CUST_NAME,t.CUST_CODE,t.LOAN_VARIETY,t.LOAN_AMT,t.LOAN_BALANCE,t.LOAN_TERM,t.RPT_STATUS,t.TASK_MATURE_DATE,l.OPERNAME,t.REPORT_ID,t.REPORT_URL,t.TASK_TYPE,l.PRODNAME,l.BANKNAME,t.COMPLETE_DATE,t.TASK_CREAT_DATE  FROM   T_PL_TASK t left join T_EDW_PLS_ACCOUNT_V L on t.LOAN_ACCT=l.LOANACNO) t1 where 1=1 ");
			StringBuffer counterquery=new StringBuffer("select count(*) from (select t.*,l.BANKNAME,l.PRODNAME,l.OPERNAME from T_PL_TASK t left join T_EDW_PLS_ACCOUNT_V L on T.LOAN_ACCT=L.LOANACNO) t1 WHERE 1=1 ");
			if(StringUtils.hasText(id)){
				querysql.append(" and t1.FD_ID = '"+id+"'");
				counterquery.append(" and t1.FD_ID = '"+id+"'");
			}
			if(StringUtils.hasText(bankname)){
				querysql.append(" and t1.BANKNAME like '%"+bankname+"%'");
				counterquery.append(" and t1.BANKNAME like '%"+bankname+"%'");
			}
			if(StringUtils.hasText(productName)){
				querysql.append(" and t1.PRODNAME like '%"+productName+"%'");
				counterquery.append(" and t1.PRODNAME like '%"+productName+"%'");
			}
			if(StringUtils.hasText(lounAcc)){
				querysql.append(" and t1.LOAN_ACCT = '"+lounAcc+"'");
				counterquery.append(" and t1.LOAN_ACCT = '"+lounAcc+"'");
			}
			if(StringUtils.hasText(custName)){
				querysql.append(" and t1.CUST_NAME like '%"+custName+"%'");
				counterquery.append(" and t1.CUST_NAME like '%"+custName+"%'");
			}
			if(StringUtils.hasText(warnLevel)){
				querysql.append(" and t1.WARN_LEVEL like '"+warnLevel+"%'");
				counterquery.append(" and t1.WARN_LEVEL like '"+warnLevel+"%'");
			}
			if(StringUtils.hasText(loanAmt)){
				querysql.append(" and t1.LOAN_AMT like '"+loanAmt+"%'");
				counterquery.append(" and t1.LOAN_AMT like '"+loanAmt+"%'");
			}
			if(StringUtils.hasText(loanBalance)){
				querysql.append(" and t1.LOAN_BALANCE like '"+loanBalance+"%'");
				counterquery.append(" and t1.LOAN_BALANCE like '"+loanBalance+"%'");
			}
			if(StringUtils.hasText(loanTerm)){
				querysql.append(" and t1.LOAN_TERM like '"+loanTerm+"%'");
				counterquery.append(" and t1.LOAN_TERM like '"+loanTerm+"%'");
			}
			if(StringUtils.hasText(handler)){
				querysql.append(" and t1.OPERNAME = '"+handler+"'");		
				counterquery.append(" and t1.OPERNAME = '"+handler+"'");	
			}
			if(StringUtils.hasText(taskType)){
				querysql.append(" and t1.TASK_TYPE like '%"+taskType+"%'");	
				counterquery.append(" and t1.TASK_TYPE like '%"+taskType+"%'");	
			}
			if(StringUtils.hasText(warnRule)){
				querysql.append(" and t1.WARN_RULE like '"+warnRule+"%'");
				counterquery.append(" and t1.WARN_RULE like '"+warnRule+"%'");
			}
			if(StringUtils.hasText(warnDesc)){
				querysql.append(" and t1.WARN_DESC like '"+warnDesc+"%'");
				counterquery.append(" and t1.WARN_DESC like '"+warnDesc+"%'");
			}
			if(StringUtils.hasText(qualitysupperc)){
				Iterator<Integer> it=rootdao.queryBySQL(counterquery.toString());
				int total=0;
				if(it.hasNext()){
					total=it.next();
				}
				flagnum=Float.parseFloat(qualitysupperc);
				totalCount=(int)(total*(flagnum/100));
				if(totalCount<1){
					totalCount=1;						//fetch first num  rows only    num 必须>1，否则报错
				}
				querysql.append(" order by rand() fetch first "+totalCount+" rows only");
			}

			
			JdbcTemplate jt=SpringContextHolder.getBean(JdbcTemplate.class);
			jt.execute(deletesql.toString());
			jt.execute(querysql.toString());
			//分页大小
			int pageSize = getResult().getPage().getEveryPage();
			//页码
			int pageIndex = getResult().getPage().getCurrentPage();
					
			
			
			
//			List<TCustomer> list = rootdao.pageQueryByHql(hql.toString(), pageIndex, pageSize);
//			pageQueryResult.setTotalCount(list.size());
//			pageQueryResult.setQueryResult(list);
			StringBuffer hql = new StringBuffer("from TPlQualitysupQuerytemp t  where 1=1 and USERNAME='"+userId+"' order by custName ");
			pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
					hql.toString());
		}else{

		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		
		
		
//		List<TCustomer> list = rootdao.pageQueryByHql(hql.toString(), pageIndex, pageSize);
//		pageQueryResult.setTotalCount(list.size());
//		pageQueryResult.setQueryResult(list);
		StringBuffer hql = new StringBuffer("from TPlQualitysupQuerytemp t  where 1=1 and USERNAME='"+userId+"' order by custName");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());

		}
		return pageQueryResult;
	}
}

