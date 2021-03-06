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
public class TbConContractGetter extends BaseGetter {

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
		String contractNum = (String) getCommQueryServletRequest().getParameterMap().get("contractNum");
		String creditProductCd = (String) getCommQueryServletRequest().getParameterMap().get("creditProductCd");
		String guarantyNote = (String) getCommQueryServletRequest().getParameterMap().get("guarantyNote");
		String contractTotalAmt = (String) getCommQueryServletRequest().getParameterMap().get("contractTotalAmt");
		String checkDesc = (String) getCommQueryServletRequest().getParameterMap().get("checkDesc");
		String comprBizContractInd = (String) getCommQueryServletRequest().getParameterMap().get("comprBizContractInd");
		String contractStatusCd = (String) getCommQueryServletRequest().getParameterMap().get("contractStatusCd");
		String contractSignDate = (String) getCommQueryServletRequest().getParameterMap().get("contractSignDate");
		String expirationDate = (String) getCommQueryServletRequest().getParameterMap().get("expirationDate");
		String loanTypeInstructionCd = (String) getCommQueryServletRequest().getParameterMap().get("loanTypeInstructionCd");
		String classificationResult = (String) getCommQueryServletRequest().getParameterMap().get("classificationResult");
		String customerNum = (String) getCommQueryServletRequest().getParameterMap().get("customerNum");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TbConContract t where 1=1 ");
		if(StringUtils.hasText(contractNum)){
			hql.append(" and contractNum = '"+contractNum+"'");
		}
		if(StringUtils.hasText(creditProductCd)){
			hql.append(" and creditProductCd = '"+creditProductCd+"'");
		}
		if(StringUtils.hasText(guarantyNote)){
			hql.append(" and guarantyNote = '"+guarantyNote+"'");
		}
		if(StringUtils.hasText(contractTotalAmt)){
			hql.append(" and contractTotalAmt = '"+contractTotalAmt+"'");
		}
		if(StringUtils.hasText(checkDesc)){
			hql.append(" and checkDesc = '"+checkDesc+"'");
		}
		if(StringUtils.hasText(comprBizContractInd)){
			hql.append(" and comprBizContractInd = '"+comprBizContractInd+"'");
		}
		if(StringUtils.hasText(contractStatusCd)){
			hql.append(" and contractStatusCd = '"+contractStatusCd+"'");
		}
		if(StringUtils.hasText(contractSignDate)){
			hql.append(" and contractSignDate = '"+contractSignDate+"'");
		}
		if(StringUtils.hasText(expirationDate)){
			hql.append(" and expirationDate = '"+expirationDate+"'");
		}
		if(StringUtils.hasText(loanTypeInstructionCd)){
			hql.append(" and loanTypeInstructionCd = '"+loanTypeInstructionCd+"'");
		}
		if(StringUtils.hasText(classificationResult)){
			hql.append(" and classificationResult = '"+classificationResult+"'");
		}
		if(StringUtils.hasText(customerNum)){
			hql.append(" and customerNum = '"+customerNum+"'");
		}else{
			hql.append(" and 1= 0");
		}
		hql.append(" order by contractStatusCd");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
