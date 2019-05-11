package com.huateng.ebank.business.dataquery.getter;

import com.huateng.common.DateUtil;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.TlrLoginLogService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * @Description: 日志查询
 * @Package: com.huateng.ebank.business.custadmin.getter
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class TlrLoginLogQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "用户登录日志查询");
			
			CommonFunctions comm =CommonFunctions.getInstance();
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
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();


		String qtlrNo = (String) getCommQueryServletRequest().getParameterMap().get("qtlrNo");
		String qbrNo = (String) getCommQueryServletRequest().getParameterMap().get("qbrNo");
		String qloginAddr = (String) getCommQueryServletRequest().getParameterMap().get("qloginAddr");
		String startDate = (String) getCommQueryServletRequest().getParameterMap().get("startDate");
		String endDate = (String) getCommQueryServletRequest().getParameterMap().get("endDate");
		if(startDate!=null&&endDate!=null){
			if(DateUtil.comparaDate(endDate,startDate)){
			ExceptionUtil.throwCommonException("开始日期大于结束日期！",
					ErrorCode.ERROR_CODE_OVER_HEAD);
			}

		}
		GlobalInfo info = GlobalInfo.getCurrentInstance();
		TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
		return tlrLoginLogService.queryTlrLoginLOg(pageIndex, pageSize, qtlrNo, qbrNo, qloginAddr, startDate, endDate);
	}

}
