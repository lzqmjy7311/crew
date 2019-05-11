package com.gbicc.job.getter;

import org.springframework.util.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TEtlMonitorLogGetter extends BaseGetter {

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

	protected PageQueryResult getData() throws Exception {
		String monitorLogID = (String) getCommQueryServletRequest().getParameterMap()
				.get("monitorLogID");
		String hostName = (String) getCommQueryServletRequest().getParameterMap()
				.get("hostName");
		String etlID = (String) getCommQueryServletRequest().getParameterMap()
				.get("etlID");
		String etlName = (String) getCommQueryServletRequest().getParameterMap()
				.get("etlName");
		String result = (String) getCommQueryServletRequest().getParameterMap()
				.get("result");
		String startTime = (String) getCommQueryServletRequest().getParameterMap()
				.get("startTime");
		String endTime = (String) getCommQueryServletRequest().getParameterMap()
				.get("endTime");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TEtlMonitorLog t where 1=1 ");
		if(StringUtils.hasText(monitorLogID)){
			hql.append(" and monitorLogID = '"+monitorLogID+"'");
		}
		if(StringUtils.hasText(etlID)){
			hql.append(" and etlID = '"+etlID+"'");
		}
		if(StringUtils.hasText(hostName)){
			hql.append(" and hostName like '%"+hostName+"%'");
		}
		if(StringUtils.hasText(etlName)){
			hql.append(" and etlName like '%"+etlName+"%'");
		}
		if(StringUtils.hasText(result)){
			hql.append(" and result ='"+result+"'");
		}
		if(StringUtils.hasText(startTime)){
			hql.append(" and to_char(dateTime,'yyyyMMdd') >= '"+startTime+"'");
		}
		if(StringUtils.hasText(endTime)){
			hql.append(" and to_char(dateTime,'yyyyMMdd') <='"+endTime+"'");
		}
		
		hql.append(" order by dateTime desc ");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
