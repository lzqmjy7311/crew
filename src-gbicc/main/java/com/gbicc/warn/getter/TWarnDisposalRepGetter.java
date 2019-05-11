package com.gbicc.warn.getter;

import java.util.List;

import org.springframework.util.StringUtils;

import com.gbicc.task.entity.TTask;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 
 * @author xudongdong
 *
 * 版本：2015年10月30日 下午1:41:33
 * 类说明：任务查询类
 */
@SuppressWarnings("unchecked")
public class TWarnDisposalRepGetter extends BaseGetter {

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
		String customerId = (String) getCommQueryServletRequest().getParameterMap().get("customerId");
		String taskId = (String) getCommQueryServletRequest().getParameterMap().get("taskId");
		String ruleLevel = (String) getCommQueryServletRequest().getParameterMap().get("ruleLevel");
		String createDate = (String) getCommQueryServletRequest().getParameterMap().get("createDate");
		String custName = (String) getCommQueryServletRequest().getParameterMap().get("custName");
		String operator = (String) getCommQueryServletRequest().getParameterMap().get("operator");
		String loanAccount = (String) getCommQueryServletRequest().getParameterMap().get("loanAccount");
		String productCode = (String) getCommQueryServletRequest().getParameterMap().get("productCode");
		String operBank = (String) getCommQueryServletRequest().getParameterMap().get("operBank");
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TWarnDisposalRep t where 1=1 ");
		if(StringUtils.hasText(id)){
			hql.append(" and t.id = '"+id+"'");
		}
		if(StringUtils.hasText(customerId)){
			hql.append(" and t.customerId = '"+customerId+"'");
		}
		if(StringUtils.hasText(taskId)){
			hql.append(" and t.taskId = '"+taskId+"'");
		}
		if(StringUtils.hasText(ruleLevel)){
			hql.append(" and t.ruleLevel ='"+ruleLevel+"'");
		}
		if(StringUtils.hasText(createDate)){
			hql.append(" and t.createDate = '"+createDate+"'");
		}
		if(StringUtils.hasText(custName)){
			hql.append(" and t.custName = '"+custName+"'");
		}
		if(StringUtils.hasText(operator)){
			hql.append(" and t.operator='"+operator+"'");
		}
		if(StringUtils.hasText(loanAccount)){
			hql.append(" and t.loanAccount ='"+loanAccount+"'");
		}
		if(StringUtils.hasText(productCode)){
			hql.append(" and t.productCode ='"+productCode+"'");
		}
		if(StringUtils.hasText(operBank)){
			hql.append(" and t.operBank like '"+operBank+"'");
		}
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString());

		return pageQueryResult;
	}
}
