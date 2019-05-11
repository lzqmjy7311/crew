package com.huateng.ebank.business.approve.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.approve.bean.ApproveBean;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
/**
 * @author jianxue.zhang
 * 用于approve_common的getter类
 */
public class ApproveRecordGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		List list = getData();
		ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				list,
				getResult());
		result.setContent(list);
		result.getPage().setTotalPage(1);
		result.init();
		return result;
	}

	private List getData() {
		List<ApproveBean> rs = new ArrayList<ApproveBean>();
		rs.add(new ApproveBean());
		return rs;
	}
}
