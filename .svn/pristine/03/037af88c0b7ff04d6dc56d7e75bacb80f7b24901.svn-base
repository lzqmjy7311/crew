package com.gbicc.company.view.getter;

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
public class TbConBorrAcctSummaryNewGetter extends BaseGetter {

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
		String borrowNum = (String) getCommQueryServletRequest().getParameterMap().get("borrowNum");
		String expirationDate = (String) getCommQueryServletRequest().getParameterMap().get("expirationDate");
		String balanceAccounts = (String) getCommQueryServletRequest().getParameterMap().get("balanceAccounts");
		String advBal = (String) getCommQueryServletRequest().getParameterMap().get("advBal");
		String loanBal = (String) getCommQueryServletRequest().getParameterMap().get("loanBal");
		String bucketP = (String) getCommQueryServletRequest().getParameterMap().get("bucketP");
		String bocketI = (String) getCommQueryServletRequest().getParameterMap().get("bocketI");
		String bailSum = (String) getCommQueryServletRequest().getParameterMap().get("bailSum");
		String fiveLevel = (String) getCommQueryServletRequest().getParameterMap().get("fiveLevel");
		String status = (String) getCommQueryServletRequest().getParameterMap().get("status");
		String customerNum = (String) getCommQueryServletRequest().getParameterMap().get("customerNum");
		
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TbConBorrAcctSummaryNew t where 1=1 ");
		if(StringUtils.hasText(borrowNum)){
			hql.append(" and borrowNum = '"+borrowNum+"'");
		}
		if(StringUtils.hasText(expirationDate)){
			hql.append(" and expirationDate = '"+expirationDate+"'");
		}
		if(StringUtils.hasText(balanceAccounts)){
			hql.append(" and balanceAccounts = '"+balanceAccounts+"'");
		}
		if(StringUtils.hasText(advBal)){
			hql.append(" and advBal = '"+advBal+"'");
		}
		if(StringUtils.hasText(loanBal)){
			hql.append(" and loanBal = '"+loanBal+"'");
		}
		if(StringUtils.hasText(bucketP)){
			hql.append(" and bucketP = '"+bucketP+"'");
		}
		if(StringUtils.hasText(bocketI)){
			hql.append(" and bocketI = '"+bocketI+"'");
		}
		if(StringUtils.hasText(bailSum)){
			hql.append(" and bailSum = '"+bailSum+"'");
		}
		if(StringUtils.hasText(fiveLevel)){
			hql.append(" and fiveLevel = '"+fiveLevel+"'");
		}
		if(StringUtils.hasText(status)){
			hql.append(" and status = '"+status+"'");
		}
		if(StringUtils.hasText(customerNum)){
			hql.append(" and customerNum = '"+customerNum+"'");
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
