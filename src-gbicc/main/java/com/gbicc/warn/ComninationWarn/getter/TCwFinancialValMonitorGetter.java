package com.gbicc.warn.ComninationWarn.getter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.util.DateUtils;
import com.gbicc.warn.ComninationWarn.entity.TCwFinancialValMonitor;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TCwFinancialValMonitorGetter extends BaseGetter {

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
		
		int pageSize = getResult().getPage().getEveryPage();// 分页大小
		int pageIndex = getResult().getPage().getCurrentPage();// 页码
		String endDate = (String) getCommQueryServletRequest().getParameterMap().get("endDate");
		String nowDate=DateUtils.getNowDateLastQ(new Date());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isNotBlank(endDate)){
			Date quDate=null;
			try{
				quDate=sdf.parse(endDate);
			}catch(Exception e){
				quDate=sdf2.parse(endDate);
			}
			nowDate=DateUtils.getNowDateLastQ(quDate);
		}
		
		StringBuffer sbf = new StringBuffer("");
		sbf.append("SELECT ROWNUMBER() OVER()  AS ROWNUM,T.* FROM T_CW_FINANCIAL_50_VAL_VIEWS T WHERE  TO_CHAR(TO_DATE(T.DATA_DATE,'YYYY-MM-DD')+ 1 DAYS,'YYYY-MM-DD')='"+nowDate+"' AND (T.NY_VAL>10 OR T.NY_VAL<-10)");
		String countSql=sbf.toString();
		sbf.append(" AND ROWNUM>="+((pageIndex-1)*pageSize+1)+" AND ROWNUM<="+(pageIndex*pageSize));
		
		String sql= sbf.toString();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(countSql);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		List<TCwFinancialValMonitor> listT=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TCwFinancialValMonitor.class));
		System.out.println("50分位列表查询------"+listT.size()+"------"+sql);
		PageQueryResult pageQueryResult=hqlDAO.pageQueryBySQL(queryCondition);
		pageQueryResult.setQueryResult(listT);
		return pageQueryResult;
	}
		
	
}
