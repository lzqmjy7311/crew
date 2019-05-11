package com.gbicc.rule.getter;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.SpringContextHolder;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TOdsCmsCodeIndustryGetter extends BaseGetter {

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
		String typeCd = (String) getCommQueryServletRequest().getParameterMap().get("TYPE_CD");
		String typeValue = (String) getCommQueryServletRequest().getParameterMap().get("TYPE_VALUE");
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String sql="SELECT * FROM T_ODS_CMS_CODE_INDUSTRY WHERE 1=1 AND LEVEL_CD='0' ";
		if(StringUtils.isNotEmpty(typeCd)){
			sql+=" AND TYPE_CD LIKE '%"+typeCd.toUpperCase()+"%' ";
		}
		if(StringUtils.isNotEmpty(typeValue)){
			sql+=" AND TYPE_VALUE LIKE '%"+typeValue+"%' ";
		}
		String orderby=" ORDER BY TYPE_CD ASC ";
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(sql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<Map<String,Object>> rList=jdbcTemplate.queryForList(sqlp.toString());
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
