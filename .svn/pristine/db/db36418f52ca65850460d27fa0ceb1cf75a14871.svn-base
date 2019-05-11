package com.huateng.fp.demo.getter;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.datadic.service.DataDicService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class SelectData extends BaseGetter {
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
	
	private PageQueryResult getData() throws CommonException {

		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
		
		DataDicService service = new DataDicService();
		StringBuffer hql = new StringBuffer("select dd from DataDic dd where 1=1");
		
		String dataNo = getCommQueryServletRequest().getParameter("value1");
		String dataTypeName = getCommQueryServletRequest().getParameter("value2");
		if (StringUtils.isNotBlank(dataTypeName)) {
			hql.append(" and dd.dataTypeName like '%").append(dataTypeName).append("%'");
		}
		if (StringUtils.isNotBlank(dataNo)) {
			hql.append(" and dd.dataNo ='").append(dataNo+"'");
		}
		hql.append(" order by dd.dataTypeNo, dataNo");
		return service.list(pageIndex, pageSize, hql.toString());
	}
}
