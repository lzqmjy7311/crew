package com.huateng.ebank.business.datadic.getter;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.datadic.service.DataDicService;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class DataDicEntryGetter extends BaseGetter {
	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
//			GlobalInfo.getCurrentInstance().addBizLog("查询数据字典日志输入测试");
//			if(pageResult.getQueryResult().isEmpty()){
//				ExceptionUtil.throwCommonException("TEST01", new Object[]{ getCommQueryServletRequest().getParameter("qDataTypeNo")});
//			}
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

	private PageQueryResult getData() throws AppException {
		
		this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "数据字典信息查询");
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();

		DataDicService service = new DataDicService();
		StringBuffer hql = new StringBuffer("select dd from DataDic dd where 1=1");

		String qDataTypeNo = getCommQueryServletRequest().getParameter("qDataTypeNo");
		String qDataTypeName = getCommQueryServletRequest().getParameter("qDataTypeName");
		String qDataNo = getCommQueryServletRequest().getParameter("qDataNo");
		String qDataName = getCommQueryServletRequest().getParameter("qDataName");
		

		String orderby = getCommQueryServletRequest().getParameter("orderby");
		String ascend = getCommQueryServletRequest().getParameter("ascend");
		
		if (StringUtils.isNotBlank(qDataTypeNo)) {
			hql.append(" and dd.dataTypeNo=").append(qDataTypeNo);
		}
		if (StringUtils.isNotBlank(qDataTypeName)) {
			hql.append(" and dd.dataTypeName like '%").append(qDataTypeName).append("%'");
		}
		if (StringUtils.isNotBlank(qDataNo)) {
			hql.append(" and dd.dataNo ='").append(qDataNo+"'");
		}
		if (StringUtils.isNotBlank(qDataName)) {
			hql.append(" and dd.dataName like '%").append(qDataName).append("%'");
		}
	
		if (StringUtils.isNotBlank(orderby)) {
			hql.append(" order by " + orderby);
			if (StringUtils.isNotBlank(ascend)) {
				hql.append(" " + ascend);
			}
		} else {
			hql.append(" order by dd.dataTypeNo, dataNo");
		}
		return service.list(pageIndex, pageSize, hql.toString());

	}
}
