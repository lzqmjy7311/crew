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
public class TOdsCmsCorpIndexGetter extends BaseGetter {

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
		String advanceAmount = (String) getCommQueryServletRequest().getParameterMap().get("advanceAmount");
		String creditAmount = (String) getCommQueryServletRequest().getParameterMap().get("creditAmount");
		String creditBalance = (String) getCommQueryServletRequest().getParameterMap().get("creditBalance");
		String usedBalance = (String) getCommQueryServletRequest().getParameterMap().get("usedBalance");
		String advanceBalance = (String) getCommQueryServletRequest().getParameterMap().get("advanceBalance");
		String overdueAdvanceBal = (String) getCommQueryServletRequest().getParameterMap().get("overdueAdvanceBal");
		String normalAdvanceBal = (String) getCommQueryServletRequest().getParameterMap().get("normalAdvanceBal");
		String mentionAdvanceBal = (String) getCommQueryServletRequest().getParameterMap().get("mentionAdvanceBal");
		String substdAdvanceBalance = (String) getCommQueryServletRequest().getParameterMap().get("substdAdvanceBalance");
		String doutfulAdvanceBal = (String) getCommQueryServletRequest().getParameterMap().get("doutfulAdvanceBal");
		String lossAdvanceBal = (String) getCommQueryServletRequest().getParameterMap().get("lossAdvanceBal");
		String outsideGuaranteeAmount = (String) getCommQueryServletRequest().getParameterMap().get("outsideGuaranteeAmount");
		String customerNum = (String) getCommQueryServletRequest().getParameterMap().get("customerNum");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TOdsCmsCorpIndex t where 1=1 ");

		if(StringUtils.hasText(advanceAmount)){
			hql.append(" and advanceAmount = '"+advanceAmount+"'");
		}
		if(StringUtils.hasText(creditAmount)){
			hql.append(" and creditAmount = '"+creditAmount+"'");
		}
		if(StringUtils.hasText(creditBalance)){
			hql.append(" and creditBalance = '"+creditBalance+"'");
		}
		if(StringUtils.hasText(usedBalance)){
			hql.append(" and usedBalance = '"+usedBalance+"'");
		}
		if(StringUtils.hasText(advanceBalance)){
			hql.append(" and advanceBalance = '"+advanceBalance+"'");
		}
		if(StringUtils.hasText(overdueAdvanceBal)){
			hql.append(" and overdueAdvanceBal = '"+overdueAdvanceBal+"'");
		}
		if(StringUtils.hasText(normalAdvanceBal)){
			hql.append(" and normalAdvanceBal = '"+normalAdvanceBal+"'");
		}
		if(StringUtils.hasText(mentionAdvanceBal)){
			hql.append(" and mentionAdvanceBal = '"+mentionAdvanceBal+"'");
		}
		if(StringUtils.hasText(substdAdvanceBalance)){
			hql.append(" and substdAdvanceBalance = '"+substdAdvanceBalance+"'");
		}
		if(StringUtils.hasText(doutfulAdvanceBal)){
			hql.append(" and doutfulAdvanceBal = '"+doutfulAdvanceBal+"'");
		}
		if(StringUtils.hasText(lossAdvanceBal)){
			hql.append(" and lossAdvanceBal = '"+lossAdvanceBal+"'");
		}
		if(StringUtils.hasText(outsideGuaranteeAmount)){
			hql.append(" and outsideGuaranteeAmount = '"+outsideGuaranteeAmount+"'");
		}
		if(StringUtils.hasText(customerNum)){
			hql.append(" and customerNum = '"+customerNum+"'");
		}else{
			hql.append(" and 1= 0");
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
