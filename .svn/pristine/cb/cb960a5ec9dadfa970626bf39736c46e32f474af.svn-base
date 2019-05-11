package com.gbicc.person.zxrf.getter;

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
public class TPlWarningRuleAcctGetter extends BaseGetter {

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
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String loanAcct = (String) getCommQueryServletRequest().getParameterMap().get("loanAcct");
		String custName = (String) getCommQueryServletRequest().getParameterMap().get("custName");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TPlTriggerRuleAcct t where 1=1 ");
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(loanAcct)){
			hql.append(" and loanAcct like '%"+loanAcct+"%' ");
		}
		if(StringUtils.hasText(custName)){
			hql.append(" and custName like '%"+custName+"%' ");
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex,pageSize,hql.toString());
		return pageQueryResult;
	}
}
