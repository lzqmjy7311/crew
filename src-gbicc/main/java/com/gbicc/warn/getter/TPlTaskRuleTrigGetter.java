package com.gbicc.warn.getter;

import java.util.List;
import java.util.Map;

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
public class TPlTaskRuleTrigGetter extends BaseGetter {

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
		String accId = (String) getCommQueryServletRequest().getParameterMap()
				.get("accId");
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String brcode=info.getBrcode();
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
		String T_PL_TASK_RULE_TRIG_SQL = "select * from (select ptrt.*,ROW_NUMBER() over(partition by FD_ACC_ID,FD_RULE_CODE order by FD_PROCESS_DATE desc) rownumber from T_PL_TASK_RULE_TRIG ptrt) where rownumber = 1";
		StringBuffer sql = new StringBuffer(" select T.FD_ID id,L.CUSTNAME custname,  T.FD_ACC_ID accId  ,T.FD_RULE_ID ruleId ,T.FD_RULE_CODE ruleCode ,T.FD_RULE_NAME ruleName ,T.FD_RULE_DESC ruleDesc,T.FD_RULE_RANK ruleRank,T.FD_RULE_TYPE ruleType,T.FD_RULE_FOR ruleFor,T.FD_RULE_TRIG_TYPE ruleTrigType,T.FD_RULE_TRIG_PERIOD ruleTrigPeriod,");
        sql.append(" T.FD_RULE_TRIG_UNIT ruleTrigUnit,T.FD_TRIG_DATE trigDate ,T.FD_TRIG_TYPE trigType,T.FD_PROCESS_DATE processDate FROM  ("+T_PL_TASK_RULE_TRIG_SQL+") T,T_EDW_PLS_ACCOUNT_V L  WHERE T.FD_ACC_ID=L.LOANACNO AND T.FD_RULE_RANK  IN('0','1')  AND L.PAYOFFFLAG='00' AND L.PRODID NOT IN ('93010200','96010200','96010100','93010100') ");//只显示黄 绿
		if(StringUtils.hasText(accId)){
			sql.append(" AND T.FD_ACC_ID  ='"+accId+"'");
		}
		if(StringUtils.hasText(userId)){
			sql.append(" AND L.DUTYID ='"+userId+"'");
		}
		
		if(StringUtils.hasText(brcode)){
			sql.append(" and L.BANKID  = '"+brcode+"'");
			
		}
		
		String orderby="";
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(sql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<Map<String,Object>> resultList=jdbcTemplate.queryForList(sqlp.toString());
		//构造数据量
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(sql);
		sqll.append(" )");
		//set
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		
		PageQueryResult result = new PageQueryResult();
		result.setQueryResult(resultList);
		result.setTotalCount(totalCount);
		return result;
	}
}
