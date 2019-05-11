package com.gbicc.company.single.outputgetter;

import java.util.List;

import com.gbicc.common.CommonService;
import com.gbicc.company.single.outputentity.A30;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class A30Getter extends BaseGetter {

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
		String warningId = (String) getCommQueryServletRequest().getParameterMap().get("warningId");
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		String sql="select * from T_REW_A30_FRIM where 1=1 and fd_warn_id='"+warningId+"' ";
		String orderby=" order by fd_data_dt desc ";
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(sql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		
		List<A30> resultList=CommonService.getInstance().findSqlListBySpringJdbc(sqlp.toString(),A30.class);
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
