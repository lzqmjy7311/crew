package com.huateng.ebank.business.dataquery.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.dataquery.bean.SupplyEnterVerifyStateQueryBean;
import com.huateng.ebank.business.dataquery.service.SupplyEntryVerifyStateQueryService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class SupplyEnterVerifyStateQueryEntryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();

			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "补录审核情况查询");

			return result;


//			ResultMng.fillResultByList(
//				getCommonQueryBean(),
//				getCommQueryServletRequest(),
//				list,
//				getResult());
//			result.setContent(list);
//			result.getPage().setTotalPage(list.size());
//			result.init();
//			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		String workDateStart = getCommQueryServletRequest().getParameter("qworkDateStart");
		String workDateEnd = getCommQueryServletRequest().getParameter("qworkDateEnd");
		String brno = getCommQueryServletRequest().getParameter("qbrNo");
		String busitype = getCommQueryServletRequest().getParameter("qbusiType");
		String apptype = getCommQueryServletRequest().getParameter("qappType");
		String filetype = getCommQueryServletRequest().getParameter("qfileType");

		List<SupplyEnterVerifyStateQueryBean> list = SupplyEntryVerifyStateQueryService.getInstance().pageQueryByHql(workDateStart, workDateEnd, brno, busitype, apptype, filetype);
		PageQueryResult queryResult = getPageQueryResult(pageSize, pageIndex, list);
		return queryResult;
	}

	private PageQueryResult getPageQueryResult(int pageSize, int pageIndex,
			List<SupplyEnterVerifyStateQueryBean> list) {
		pageIndex -=  1;
		int startRowNum = pageIndex * pageSize;
		int endRowNum = startRowNum + pageSize > list.size() ? list.size() : startRowNum + pageSize;

		PageQueryResult queryResult = new PageQueryResult();
		queryResult.setTotalCount(list.size());
		queryResult.setQueryResult(list.subList(startRowNum, endRowNum));
		return queryResult;
	}
}