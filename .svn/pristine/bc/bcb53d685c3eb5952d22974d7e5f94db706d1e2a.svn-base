package com.gbicc.company.financial.analysis.getter;


import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class AllRepnoSelect extends BaseGetter {


	public Result call() throws AppException {
		try {
			PageQueryCondition queryCondition = new PageQueryCondition();
			Page page = result.getPage();
			String value=getCommQueryServletRequest().getParameter("dataTypeNo");
			if(value!=null&&!value.equals("")){
				queryCondition.setQueryString(" from DataDic po where   po.dataTypeNo ='"+value+"' ");
			}else{
				queryCondition.setQueryString(" from DataDic po  order by po.dataNo");
			}
			queryCondition.setPageSize(page.getEveryPage());
			queryCondition.setPageIndex(page.getCurrentPage());
			PageQueryResult pageResult = DAOUtils.getHQLDAO().pageQueryByQL(queryCondition);

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());
			result.setContent(pageResult.getQueryResult());
			if (pageResult.getQueryResult().size() == 0) {
				result.getPage().setTotalPage(0);
			} else {
				result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			}
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}


}
