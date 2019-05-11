package com.huateng.ebank.business.datadic.getter;

import java.util.ArrayList;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;

public class AppAndFileTypeSelectGetter extends BaseGetter {
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
		ReportCommonService service = ReportCommonService.getInstance();

		StringBuffer hql = new StringBuffer("select dd from DataDic dd where 1=1");
		String show = getCommQueryServletRequest().getParameter("show");
		String type = getCommQueryServletRequest().getParameter("type");
		String appType = getCommQueryServletRequest().getParameter("appType");

		PageQueryResult queryresult = null;
		if (type==null|| type.trim().length()==0) {
			type = TopReportConstants.REPORT_BUSITYPE_BOP;
		}
		DataDic dic = service.getDataDic(ReportConstant.DATA_DIC_BUSI_TYPE_NO, type.trim());
		if (dic!=null && dic.getMiscflgs()!=null && dic.getMiscflgs().trim().length()>0) {
			String dataTypeNo = dic.getMiscflgs().trim();
			if (show!=null && show.equalsIgnoreCase("file")) {
				if (appType!=null && appType.trim().length()>0) {
					DataDic appDic = service.getDataDic(Integer.parseInt(dataTypeNo), appType.trim());
					if (appDic!=null && appDic.getMiscflgs()!=null && appDic.getMiscflgs().trim().length()>0) {
						dataTypeNo = appDic.getMiscflgs();
					}else{
						dataTypeNo="-1";
					}
				}else{
					dataTypeNo="-1";
				}
			}

			hql.append(" and dd.dataTypeNo="+dataTypeNo +" order by dd.dataNo");
			queryresult = ROOTDAOUtils.getROOTDAO().pageQueryByHql(pageIndex, pageSize, hql.toString());
		}
		if (queryresult==null) {
			queryresult = new PageQueryResult();
			queryresult.setQueryResult(new ArrayList());
			queryresult.setTotalCount(0);
		}
		return queryresult;
	}
}
