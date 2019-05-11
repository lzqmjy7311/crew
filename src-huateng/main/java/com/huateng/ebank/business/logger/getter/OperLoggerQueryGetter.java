package com.huateng.ebank.business.logger.getter;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.logger.bean.OperLoggerBean;
import com.huateng.ebank.business.logger.operation.OperLoggerQueryOP;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class OperLoggerQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {

		OperationContext context = new OperationContext();
		String brcode = this.getCommQueryServletRequest().getParameter("brcode");//机构号
		String oprcode = this.getCommQueryServletRequest().getParameter("oprcode");//操作员号
		String txnDate = this.getCommQueryServletRequest().getParameter("txnDate");//交易日期

		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		//起始记录
		String stdstartnm="0";
		//查询记录
		String stdquerynm="999";
		OperLoggerBean logBean  = new OperLoggerBean();
		logBean.setBrcode(brcode);
		logBean.setOprcode(oprcode);
		logBean.setTxnDate(txnDate);
		logBean.setStdstartnm(stdstartnm);
		logBean.setStdquerynm(stdquerynm);

		context.setAttribute(OperLoggerQueryOP.IN_PARAMER,logBean);
		context.setAttribute(OperLoggerQueryOP.IN_PAGESIZE, pageSize);
		context.setAttribute(OperLoggerQueryOP.IN_PAGEINDEX, pageIndex);

		OPCaller.call(OperLoggerQueryOP.ID, context);
		PageQueryResult pageQueryResult =  (PageQueryResult)context.getAttribute(OperLoggerQueryOP.OUTLIST);
		ResultMng.fillResultByList(getCommonQueryBean(),
				getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
				getResult());
		result.setContent(pageQueryResult.getQueryResult());
		result.getPage().setTotalPage(
				pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));

		result.init();
		return result;
	}

}
