package com.gbicc.person.creditMemo.getter;

import org.apache.commons.lang3.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class OrderGetter extends BaseGetter {

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

	/**
	 * 获取分页结果集
	 * @return
	 * @throws CommonException 
	 */
	private PageQueryResult getData() throws Exception {
		// 获取搜索条件
		String orderId = (String) getCommQueryServletRequest().getParameterMap().get("orderId");
		String receiver = (String) getCommQueryServletRequest().getParameterMap().get("receiver");
		String userId = (String) getCommQueryServletRequest().getParameterMap().get("userId");
		String shippingName = (String) getCommQueryServletRequest().getParameterMap().get("shippingName");
		String shippingCode = (String) getCommQueryServletRequest().getParameterMap().get("shippingCode");
		String receiverMobile = (String) getCommQueryServletRequest().getParameterMap().get("receiverMobile");
		String startSdate =  (String) getCommQueryServletRequest().getParameterMap().get("startSdate");
		String startEdate =  (String) getCommQueryServletRequest().getParameterMap().get("startEdate");
		
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		
		StringBuffer hql = new StringBuffer("from order where 1=1 ");
		if (StringUtils.isNotBlank(orderId)) {
			hql.append(" and orderId = '"+orderId+"'");
		}
		if (StringUtils.isNotBlank(receiver)) {
			hql.append(" and receiver like '%"+receiver+"%'");
		}
		if (StringUtils.isNotBlank(userId)) {
			hql.append(" and userId = '"+userId+"'");
		}
		if (StringUtils.isNotBlank(shippingName)) {
			hql.append(" and shippingName like '%"+shippingName+"%'");
		}
		if (StringUtils.isNotBlank(shippingCode)) {
			hql.append(" and shippingCode = '"+shippingCode+"'");
		}
		if (StringUtils.isNotBlank(receiverMobile)) {
			hql.append(" and receiverMobile like '"+receiverMobile+"%'");
		}
		if(StringUtils.isNotBlank(startSdate)){
			hql.append(" and startDate >= to_date('"+startSdate+"','yyyy-mm-dd')");
		}
		if(StringUtils.isNotBlank(startEdate)){
			hql.append(" and startDate <= to_date('"+startEdate+"','yyyy-mm-dd')");
		}
		
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex,pageSize,hql.toString());
		
		return pageQueryResult;
	}

}




















