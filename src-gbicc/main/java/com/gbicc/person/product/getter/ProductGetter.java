package com.gbicc.person.product.getter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.product.entity.Product;
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
 * @author likm
 * @time   2015年10月27日15:02:50
 * @desc   产品查询
 */
@SuppressWarnings("unchecked")
public class ProductGetter extends BaseGetter {

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
		String prodCode = (String) getCommQueryServletRequest().getParameterMap().get("prodCode");
		String prodName = (String) getCommQueryServletRequest().getParameterMap().get("prodName");
		String prodType = (String) getCommQueryServletRequest().getParameterMap().get("prodType");
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from Product t where 1=1 ");
		if(StringUtils.isNotEmpty(prodCode)){
			hql.append(" and prodCode like '"+prodCode+"%'");
		}
		if(StringUtils.isNotEmpty(prodName)){
			hql.append(" and prodName like '"+prodName+"%'");
		}
		if(StringUtils.isNotEmpty(prodType)){
			hql.append(" and prodType='"+prodType+"'");
		}
//		List<Product> list = rootdao.pageQueryByHql(hql.toString(), pageIndex, pageSize);
//		PageQueryResult pageQueryResult = new PageQueryResult();
//		pageQueryResult.setTotalCount(list.size());
//		pageQueryResult.setQueryResult(list);
		
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString());
		
		return pageQueryResult;
	}
}
