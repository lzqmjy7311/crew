package com.gbicc.person.great.getter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.common.CommonService;
import com.gbicc.personCommon.entity.TEdwPlsLegalPerson;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TEdwPlsLegalPersonGetter extends BaseGetter {

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

	@SuppressWarnings("unchecked")
	protected PageQueryResult getData() throws Exception {
		String custid = (String) getCommQueryServletRequest().getParameterMap().get("custid");
		String custname = (String) getCommQueryServletRequest().getParameterMap().get("custname");
		String liceid = (String) getCommQueryServletRequest().getParameterMap().get("liceid");
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		String legSql="select * from t_edw_pls_legal_person where 1=1 ";
		if(StringUtils.isNotEmpty(custid)){
			legSql+=" and custid='"+custid+"' ";
		}
		if(StringUtils.isNotEmpty(custname)){
			legSql+=" and custname like '%"+custname+"%' ";
		}
		if(StringUtils.isNotEmpty(liceid)){
			legSql+=" and liceid='"+liceid+"' ";
		}
		String orderby=" order by custname asc ";
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(legSql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		
		List<TEdwPlsLegalPerson> resultList=CommonService.getInstance()
					.findSqlListBySpringJdbc(sqlp.toString(), TEdwPlsLegalPerson.class);
		//构造数据量
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(legSql);
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
