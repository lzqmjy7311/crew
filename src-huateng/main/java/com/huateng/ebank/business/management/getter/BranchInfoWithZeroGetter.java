package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.DataDicUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @Title: BranchInfoWithZeroGetter.java
 * @Package com.huateng.ebank.business.common.getter
 * @Description: 获取机构列表（增加0为不限）
 * @author shen_antonio
 * @date 2009-12-14 上午06:27:25 Copyright: Copyright (c) 2009 Company: Shanghai
 *       Huateng Software Systems Co., Ltd.
 * @version V1.0
 */
public class BranchInfoWithZeroGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List list = new ArrayList();
		String value = DataFormat.trim(getCommQueryServletRequest()
				.getParameter("value"));
		if (StringUtils.isEmpty(value)) {
			value = "";
		}
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();

		PageQueryCondition condition = new PageQueryCondition();
		condition.setPageIndex(1);
		condition.setPageSize(99999);

		StringBuffer hql = new StringBuffer();
		// Modified by UU_Wu 2010-3-23 BMS-2547 end
		if(!StringUtils.isEmpty(value)){
			hql.append("from Bctl po where  po.brno like '" + value
				+ "' or po.brname like '" + value + "'");
		}else{
			hql.append("from Bctl");
		}

		condition.setQueryString(hql.toString());

		PageQueryResult result = DAOUtils.getHQLDAO().pageQueryByQL(condition);

		Iterator it = result.getQueryResult().iterator();

		while (it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			list.add(obj[0]);
		}
		LinkedHashMap brhTypeMap = DataDicUtils.getAllDicType("28");
		if (brhTypeMap != null && brhTypeMap.size() > 0) {
			Iterator iterator = brhTypeMap.keySet().iterator();
			int i = -1;
			while (iterator.hasNext()) {
				i++;
				String brhId = (String) iterator.next();
				String brhName = (String) brhTypeMap.get(brhId);
				Bctl branchInfo = new Bctl();
				branchInfo.setBrcode(String.valueOf(-1 * Integer.parseInt(brhId)));
				if (brhName.indexOf("-") != -1) {
					branchInfo
							.setBrname(brhName.substring(brhName.indexOf("-") + 1)
									+ "级别");
				} else {
					branchInfo.setBrname(brhName + "级别");
				}
				list.add(i, branchInfo);
			}
		}

		ResultMng.fillResultByList(getCommonQueryBean(),
				getCommQueryServletRequest(), list, getResult());
		getResult().setContent(list);
		getResult().getPage().setTotalPage(1);
		getResult().init();
		return getResult();
	}

}
