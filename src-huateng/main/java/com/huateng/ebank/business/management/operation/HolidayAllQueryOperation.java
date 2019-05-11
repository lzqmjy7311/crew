package com.huateng.ebank.business.management.operation;

import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.HolidayService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class HolidayAllQueryOperation extends BaseOperation {
	public static final String ID = "Management.HolidayAllQueryOperation";
	public static final String INPUT_PAGESIZE = "INPUT_PAGESIZE";
	public static final String INPUT_PAGEINDEX = "INPUT_PAGEINDEX";
	public static final String OUTPUT_PAGERESULT = "OUTPUT_PAGERESULT";
	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
	@Override
	public void execute(OperationContext context) throws CommonException {
		Integer pageIndex = (Integer)context.getAttribute(INPUT_PAGEINDEX);
		Integer pageSize = (Integer)context.getAttribute(INPUT_PAGESIZE);
		PageQueryResult result = HolidayService.getInstance().queryHolidayList(pageSize,pageIndex);
		context.setAttribute(OUTPUT_PAGERESULT, result);
	}

}
