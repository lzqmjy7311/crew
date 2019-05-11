package com.huateng.ebank.business.management.getter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.utils.ReportEnum;


/**
 * Get the dropdown's data from DB with HQL and full the dataset to dropdown
 * @author cwenao
 * 2012-8-13
 */


@SuppressWarnings("unchecked")
public class BiAreacodeSelectGetter extends BaseGetter {

	/*
	 * 获取区域维护列表
	 *
	 */
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();

			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}
	/*
	 * 查询
	 */
	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException {
		Map paramMap = getCommQueryServletRequest().getParameterMap();
		String areacode = (String) paramMap.get("value1");
		String areaname = (String) paramMap.get("value2");
		StringBuffer hql = new StringBuffer(" FROM BiAreaOfChina WHERE lock = '"+ReportEnum.REPORT_REC_LOCK_DEL.F.value+"' AND del = '"+ReportEnum.REPORT_REC_LOCK_DEL.F.value+"' ");
		if(StringUtils.isNotBlank(areacode)) {
			areacode = StringUtils.upperCase(areacode);
			hql.append(" AND areacode LIKE '%" + StringUtils.trim(areacode) +"%'");
		}
		if(StringUtils.isNotBlank(areaname)) {
			hql.append(" AND areaname LIKE '%" + StringUtils.trim(areaname) +"%' ");
		}
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		return rootdao.pageQueryByQL(queryCondition);
	}

}