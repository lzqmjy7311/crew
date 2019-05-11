package com.huateng.ebank.business.management.getter;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.operation.HolidayAllQueryOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * holiday query
 * @author shen_antonio
 */
public class HolidayGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();
		OperationContext oc = new OperationContext();
		oc.setAttribute(HolidayAllQueryOperation.INPUT_PAGEINDEX, new Integer(pageIndex));
		oc.setAttribute(HolidayAllQueryOperation.INPUT_PAGESIZE, new Integer(pageSize));
		OPCaller.call(HolidayAllQueryOperation.ID, oc);
		PageQueryResult pageQueryResult = (PageQueryResult)oc.getAttribute(HolidayAllQueryOperation.OUTPUT_PAGERESULT);
		ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageQueryResult.getQueryResult(),
				getResult());
		result.setContent(pageQueryResult.getQueryResult());
		result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
		result.init();
		return result;
	}

}
