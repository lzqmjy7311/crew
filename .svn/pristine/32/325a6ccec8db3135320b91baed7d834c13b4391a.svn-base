package com.huateng.ebank.business.management.getter;

import java.util.Map;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.management.operation.HolidayDetailQueryOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * holiday query
 * @author shen_antonio
 */
public class HolidayDetailGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		String year = this.getCommQueryServletRequest().getParameter("year");
		OperationContext oc = new OperationContext();
		oc.setAttribute(HolidayDetailQueryOperation.INPUT_YEAR,year);
		OPCaller.call(HolidayDetailQueryOperation.ID, oc);
		Map map = (Map)oc.getAttribute(HolidayDetailQueryOperation.OUTPUT_RESULT);
		ResultMng.fillResultByObject(this.getCommonQueryBean(), this.getCommQueryServletRequest(), map, result);
		result.init();
		return result;
	}

}
