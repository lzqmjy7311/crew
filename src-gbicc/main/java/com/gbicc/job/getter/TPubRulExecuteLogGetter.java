package com.gbicc.job.getter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
public class TPubRulExecuteLogGetter extends BaseGetter {

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
		String rowDate = (String) getCommQueryServletRequest().getParameterMap()
				.get("rowDate");
		String isSuccess = (String) getCommQueryServletRequest().getParameterMap()
				.get("isSuccess");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TPubRulExecuteLog t where 1=1 ");
		
		if(StringUtils.hasText(isSuccess)){
			hql.append(" and isSuccess = '"+isSuccess+"'");
		}
		
		if(StringUtils.hasText(rowDate)){
			hql.append(" and rowDate = '"+rowDate+"'");
		}
		//没有参数，默认查询T-1日期 
		if(!StringUtils.hasText(isSuccess) && !StringUtils.hasText(rowDate)){
			SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
			Calendar cd=Calendar.getInstance();
			cd.add(Calendar.DAY_OF_MONTH, -1);
			String fmt=format.format(cd.getTime());
			hql.append(" and rowDate = '"+fmt+"'");
		}
		hql.append(" order by execTime desc ");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
