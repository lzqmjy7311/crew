package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * 获取有效机构列表
 * @author liyi
 *
 */
public class BranchInfoGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List list = new ArrayList();
		String value = DataFormat.trim(getCommQueryServletRequest().getParameter("value"));
		if(StringUtils.isEmpty(value)){
			value = "";
		}
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();

		PageQueryCondition condition = new PageQueryCondition();
		condition.setPageIndex(pageIndex);
		condition.setPageSize(pageSize);

		StringBuffer hql = new StringBuffer();
		hql.append(" from Bctl po where 1=1");
		//and (po.brhNo like '"+value+"' or po.brhName like '"+value+"' )
		hql.append(" and (po.brno like '%"+value+"%' or po.brname like '%"+value+"%' )");
		hql.append(" and po.status = '" + SystemConstant.FLAG_ON + "'");
		hql.append(" order by po.brcode ");
		condition.setQueryString(hql.toString());

		PageQueryResult result = DAOUtils.getHQLDAO().pageQueryByQL(condition);

		Iterator it = result.getQueryResult().iterator();

		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			list.add(obj[0]);
		}

		ResultMng.fillResultByList(getCommonQueryBean(),
				getCommQueryServletRequest(), list, getResult());
		getResult().setContent(list);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

}
