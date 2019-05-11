package com.gbicc.company.view.getter;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.company.view.entity.TCmFinanceIndexHyFw;
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

@SuppressWarnings("unchecked")
public class TCmFinanceIndexHyFwGetter extends BaseGetter {

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
		String id = (String) getCommQueryServletRequest().getParameterMap()
				.get("id");
		String industryCd = (String) getCommQueryServletRequest().getParameterMap()
				.get("industryCd");
		String financeStatementTypeCd = (String) getCommQueryServletRequest().getParameterMap()
				.get("financeStatementTypeCd");
		String odsDate = (String) getCommQueryServletRequest().getParameterMap()
				.get("odsDate");
		String repno = (String) getCommQueryServletRequest().getParameterMap()
				.get("repno");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer sql = new StringBuffer("SELECT W.*, ROW_NUMBER () OVER(partition BY INDEX_CD order by FINANCE_STATEMENT_DEADLINE DESC ) AS NU  FROM T_CM_FINANCE_INDEX_HY_FW W WHERE 1=1  ");
		if(StringUtils.hasText(id)){
			sql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(financeStatementTypeCd)){
			if(financeStatementTypeCd.equals("707")){
				financeStatementTypeCd="1";
				odsDate=odsDate+"1231";
			}
			if(financeStatementTypeCd.equals("709")){
				financeStatementTypeCd="3";
				if(StringUtils.hasText(repno)){
					if(repno.equals("1")){
						odsDate=odsDate+"0331";
					}
					if(repno.equals("2")){
						odsDate=odsDate+"0630";
					}
					if(repno.equals("3")){
						odsDate=odsDate+"0930";
					}
					if(repno.equals("4")){
						odsDate=odsDate+"1231";
					}
				}
			}
			sql.append(" and FINANCE_STATEMENT_TYPE_CD = '"+financeStatementTypeCd+"'");
		}
		if(StringUtils.hasText(odsDate)){
			sql.append(" and to_date(FINANCE_STATEMENT_DEADLINE,'yyyy-MM-dd') <= to_date('"+odsDate+"','yyyy-MM-dd')");
		}else{
			sql.append(" and FINANCE_STATEMENT_TYPE_CD='1' ");
		}
		if(StringUtils.hasText(industryCd)){
			sql.append(" and INDUSTRY_LEVEL = '"+industryCd+"'");
		}
		StringBuffer sqll=new StringBuffer("SELECT * FROM ( "+sql+" ) X WHERE NU=1");
		JdbcTemplate jt=(JdbcTemplate)ApplicationContextUtils.getBean("JdbcTemplate");
		List<TCmFinanceIndexHyFw> listT=jt.query(sqll.toString(), BeanPropertyRowMapper.newInstance(TCmFinanceIndexHyFw.class));
		pageQueryResult.setQueryResult(listT);
		return pageQueryResult;
	}
}
