package com.gbicc.rule.getter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.SpringContextHolder;
import com.gbicc.rule.entity.TPubRulIndustryValue;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TPubRulIndustryValueGetter extends BaseGetter {

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
		String rulCode = (String) getCommQueryServletRequest().getParameterMap().get("rulCode");
		String rulName = (String) getCommQueryServletRequest().getParameterMap().get("rulName");
		String industryCode = (String) getCommQueryServletRequest().getParameterMap().get("industryCode");
		String industryName = (String) getCommQueryServletRequest().getParameterMap().get("industryName");
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String sql="SELECT FD_RUL_CODE AS RUL_CODE,FD_RUL_NAME AS RUL_NAME,V.FD_INDUSTRY_CODE AS INDUSTRY_CODE,I.TYPE_VALUE AS INDUSTRY_NAME, "+
		" CASE WHEN FD_INDUSTRY_CODE IS NULL THEN '系统默认阀值' ELSE '手工维护阀值' END AS VALUE_TYPE "+
		" FROM T_PUB_RUL_INDUSTRY_VALUE V LEFT JOIN T_ODS_CMS_CODE_INDUSTRY I ON V.FD_INDUSTRY_CODE=I.TYPE_CD WHERE 1=1 ";
		if(StringUtils.isNotEmpty(rulCode)){
			sql+=" AND FD_RUL_CODE='"+rulCode.toUpperCase()+"' ";
		}
		if(StringUtils.isNotEmpty(rulName)){
			sql+=" AND FD_RUL_NAME LIKE '%"+rulName+"%' ";
		}
		if(StringUtils.isNotEmpty(industryCode)){
			sql+=" AND FD_INDUSTRY_CODE LIKE '%"+industryCode.toUpperCase()+"%' ";
		}
		if(StringUtils.isNotEmpty(industryName)){
			sql+=" AND I.TYPE_VALUE LIKE '%"+industryName+"%' ";
		}
		sql+=" GROUP BY FD_RUL_CODE,FD_RUL_NAME,V.FD_INDUSTRY_CODE,I.TYPE_VALUE ORDER BY FD_INDUSTRY_CODE ASC,RUL_CODE ASC ";
		String orderby="";
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(sql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<TPubRulIndustryValue> rList=jdbcTemplate.query(sqlp.toString(),BeanPropertyRowMapper.newInstance(TPubRulIndustryValue.class));
		//构造数据量
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(sql);
		sqll.append(" )");
		//set
		PageQueryResult result = new PageQueryResult();
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		result.setQueryResult(rList);
		result.setTotalCount(totalCount);
		return result;
	}
}
