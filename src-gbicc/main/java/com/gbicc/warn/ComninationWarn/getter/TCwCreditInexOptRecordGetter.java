package com.gbicc.warn.ComninationWarn.getter;

import org.springframework.util.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TCwCreditInexOptRecordGetter extends BaseGetter {

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
		String id = (String) getCommQueryServletRequest().getParameterMap()
				.get("id");
		String username = (String) getCommQueryServletRequest().getParameterMap()
				.get("username");
		String date = (String) getCommQueryServletRequest().getParameterMap()
				.get("date");
		PageQueryResult pageQueryResult = new PageQueryResult();
		

		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TCwCreditInexOptRecord t where 1=1 ");
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(username)){
			hql.append(" and username = '"+username+"'");
		}
		if(StringUtils.hasText(date)){
			hql.append(" and date = TO_DATE('"+date+"','yyyy-mm-dd')");
		}
		hql.append(" order by date desc");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
