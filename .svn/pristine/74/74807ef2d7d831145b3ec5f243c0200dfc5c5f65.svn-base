package com.huateng.ebank.business.management.getter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.BiNationregionService;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.utils.ReportEnum;

/**
 *
 * @author shishu.zhang
 *
 * 2012-8-22下午1:54:46
 */
@SuppressWarnings("unchecked")
public class BiNationregionSelectGetter extends BaseGetter {
	/*
	 * 获取国家/地区维护列表
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
	private PageQueryResult getData() {
		Map paramMap = this.getCommQueryServletRequest().getParameterMap();
		String qId = (String) paramMap.get("value1");
		String qnationregionName = (String) paramMap.get("value2");
		StringBuffer hql = new StringBuffer(" FROM BiNationregion biNationregion WHERE lock = '"+ReportEnum.REPORT_REC_LOCK_DEL.F.value+"' AND del = '"+ReportEnum.REPORT_REC_LOCK_DEL.F.value+"' ");
		if(StringUtils.isNotBlank(qId)) {
			qId = StringUtils.upperCase(qId);
			hql.append(" AND biNationregion.id LIKE '%" + qId.trim() +"%'");
		}
		if(StringUtils.isNotBlank(qnationregionName)) {
			hql.append(" AND (biNationregion.chinaShortName LIKE '%" + qnationregionName.trim() +"%' OR biNationregion.engShortName LIKE '%"+qnationregionName.trim()+"%' ) ");
		}
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		return BiNationregionService.getInstance().pageQueryByHql(pageIndex, pageSize,hql.toString());
	}

}
