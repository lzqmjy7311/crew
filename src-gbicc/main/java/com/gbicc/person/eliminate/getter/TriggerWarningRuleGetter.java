package com.gbicc.person.eliminate.getter;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.SpringContextHolder;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TriggerWarningRuleGetter extends BaseGetter {

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
		PageQueryResult pageQueryResult = new PageQueryResult();
		String accId = (String) getCommQueryServletRequest().getParameterMap().get("accId");
		String sql=" SELECT DISTINCT FD_RULE_CODE AS ruleCode,FD_RULE_NAME AS ruleName FROM T_PL_TASK_RULE_TRIG WHERE FD_ACC_ID='"+accId+"' ORDER BY FD_RULE_CODE ASC ";
		
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<Map<String,Object>> resultList=jdbcTemplate.queryForList(sql);
		
		pageQueryResult.setQueryResult(resultList);
		pageQueryResult.setTotalCount(resultList.size());
		return pageQueryResult;
	}
}
