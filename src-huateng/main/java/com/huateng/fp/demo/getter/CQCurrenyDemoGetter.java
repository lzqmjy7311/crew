package com.huateng.fp.demo.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.SysCurrency;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class CQCurrenyDemoGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		String value = this.getCommQueryServletRequest().getParameter("value");

		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		if (StringUtils.isNotBlank(value)) {
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

			PageQueryCondition queryCondition = new PageQueryCondition();

			StringBuffer hql = new StringBuffer(
					" from SysCurrency sc where sc.id like '%" + value.toUpperCase()
							+ "%' or sc.cnname like '%" + value + "%'");

			hql.append(" order by sc.showSeq");

			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(pageSize);
			queryCondition.setQueryString(hql.toString());

			PageQueryResult queryResult = rootdao.pageQueryByQL(queryCondition);
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(
					queryResult.getPageCount(getResult().getPage()
							.getEveryPage()));
		} else {
			List<SysCurrency> list = new ArrayList<SysCurrency>();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list, getResult());
			result.setContent(list);
			result.getPage().setTotalPage(1);
		}
		result.init();
		return result;
	}
}
