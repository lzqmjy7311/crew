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
public class TEtlJobErrorLogGetter extends BaseGetter {

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
		String etlErrorLogID = (String) getCommQueryServletRequest().getParameterMap()
				.get("etlErrorLogID");
		String etlScheduleID = (String) getCommQueryServletRequest().getParameterMap()
				.get("etlScheduleID");
		String jobName = (String) getCommQueryServletRequest().getParameterMap()
				.get("jobName");
		String errMsg = (String) getCommQueryServletRequest().getParameterMap()
				.get("errMsg");
		String errSql = (String) getCommQueryServletRequest().getParameterMap()
				.get("errSql");
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
		StringBuffer hql = new StringBuffer("from TEtlJobErrorLog t where 1=1 ");
		if(StringUtils.hasText(etlErrorLogID)){
			hql.append(" and etlErrorLogID = '"+etlErrorLogID+"'");
		}
		if(StringUtils.hasText(etlScheduleID)){
			hql.append(" and etlScheduleID = '"+etlScheduleID+"'");
		}
		if(StringUtils.hasText(jobName)){
			hql.append(" and jobName like '%"+jobName+"%'");
		}
		if(StringUtils.hasText(errMsg)){
			hql.append(" and errMsg like '%"+errMsg+"%'");
		}
		if(StringUtils.hasText(errSql)){
			hql.append(" and errSql like '%"+errSql+"%'");
		}
		if(StringUtils.hasText(startTime)){
			hql.append(" and to_char(errTimestamp,'yyyyMMdd') >= '"+startTime+"'");
		}
		if(StringUtils.hasText(endTime)){
			hql.append(" and to_char(errTimestamp,'yyyyMMdd') <='"+endTime+"'");
		}
		
		/*if(StringUtils.isNotEmpty(warnDtStart)){
			sql+=" and FD_RUL_THEME_CD like '%"+rulTheme+"%' ";
			sql +=" and to_char(FD_WARN_DT,'yyyyMMdd')>='"+warnDtStart+"' ";
		}
		if(StringUtils.isNotEmpty(warnDtEnd)){
			sql +=" and to_char(FD_WARN_DT,'yyyyMMdd')<'"+warnDtEnd+"' ";
		}*/
		hql.append(" order by errTimestamp desc ");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
