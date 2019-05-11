package com.gbicc.company.single.getter;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.util.DateUtils;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TCmSingleRulInvestigationGetter extends BaseGetter {

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
		String taskType = (String) getCommQueryServletRequest().getParameterMap().get("taskType");
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("select t1 from TCmSingleRulInvestigation t1,ActiveTask t2  where t1.id=t2.businessKey ");
		hql.append(" and t2.assignee='").append(userId).append("'");
		if(StringUtils.isNotEmpty(info.getBrcode())){
			hql.append(" and t1.inveOrg.brcode='"+info.getBrcode()+"' ");
		}else{
			hql.append(" and 1=2 ");
		}
		if(StringUtils.isNotEmpty(taskType)){
			hql.append(" and '"+DateUtils.formatYmdDate(new Date())+"'>to_char(t1.matureDt,'yyyymmdd') ");
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		return pageQueryResult;
	}
}
