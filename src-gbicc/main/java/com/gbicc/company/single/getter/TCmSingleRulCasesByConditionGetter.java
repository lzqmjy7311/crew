package com.gbicc.company.single.getter;

import org.apache.commons.lang.StringUtils;

import com.gbicc.company.single.operation.TCmSingleRulCasesOperation;
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
public class TCmSingleRulCasesByConditionGetter extends BaseGetter {

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
		String casesCode = (String) getCommQueryServletRequest().getParameterMap().get("casesCode");
		String casesName = (String) getCommQueryServletRequest().getParameterMap().get("casesName");
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TCmSingleRulCases t where 1=1 ");
		hql.append(" and createUser.tlrno='"+userId+"' and casesStatus not in('"+TCmSingleRulCasesOperation.STATUS_FILING_WAIT_APL+"','"+TCmSingleRulCasesOperation.STATUS_ALREADY_FILING+"') ");
		if(StringUtils.isNotEmpty(casesCode)){
			hql.append(" and casesCode like '%"+casesCode+"%' ");
		}
		if(StringUtils.isNotEmpty(casesName)){
			hql.append(" and casesName like '%"+casesName+"%' ");
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		return pageQueryResult;
	}
}
