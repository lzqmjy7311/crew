package com.gbicc.person.supervision.getter;

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
public class QualitysuParGetter extends BaseGetter{
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
		String bankName = (String) getCommQueryServletRequest().getParameterMap().get("bankName");
		String productName = (String) getCommQueryServletRequest().getParameterMap().get("productName");
		String riskSignal = (String) getCommQueryServletRequest().getParameterMap().get("riskSignal");
		String assureType = (String) getCommQueryServletRequest().getParameterMap().get("assureType");
		String warningLevel = (String) getCommQueryServletRequest().getParameterMap().get("warningLevel");
		String qualitysupPerc = (String) getCommQueryServletRequest().getParameterMap().get("qualitysupPerc");
		String status = (String) getCommQueryServletRequest().getParameterMap().get("status");
		String startTime = (String) getCommQueryServletRequest().getParameterMap().get("startTime");
		String endTime = (String) getCommQueryServletRequest().getParameterMap().get("endTime");
		
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from QualitysuPar t where 1=1 ");
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(bankName)){
			hql.append(" and bankName like '"+bankName+"%'");
		}
		if(StringUtils.hasText(productName)){
			hql.append(" and productName like '"+productName+"%'");
		}
		if(StringUtils.hasText(riskSignal)){
			hql.append(" and riskSignal like '"+riskSignal+"%'");
		}
		if(StringUtils.hasText(assureType)){
			hql.append(" and assureType like '"+assureType+"%'");
		}
		if(StringUtils.hasText(warningLevel)){
			hql.append(" and warningLevel like '"+warningLevel+"%'");
		}
		if(StringUtils.hasText(qualitysupPerc)){
			hql.append(" and qualitysupPerc like '"+qualitysupPerc+"%'");			
		}
		if(StringUtils.hasText(status)){
			hql.append(" and status like '"+status+"%'");
		}
		if(StringUtils.hasText(startTime)){
			hql.append(" and startTime like '"+startTime+"%'");
		}
		if(StringUtils.hasText(endTime)){
			hql.append(" and endTime like '"+endTime+"%'");			
		}
		
//		List<TCustomer> list = rootdao.pageQueryByHql(hql.toString(), pageIndex, pageSize);
//		pageQueryResult.setTotalCount(list.size());
//		pageQueryResult.setQueryResult(list);
		
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString());
        

		return pageQueryResult;
	}

}
