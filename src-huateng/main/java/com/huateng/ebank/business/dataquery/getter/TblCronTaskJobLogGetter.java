package com.huateng.ebank.business.dataquery.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.type.DateType;
import org.hibernate.type.Type;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TblCronTaskJobLogGetter extends BaseGetter {
	/*
	 * 定时任务日志查询
	 *
	 * @author huangcheng
	 */
	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "对外担保签约信息数据查询页面查询");
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {

		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();

		StringBuffer hql = new StringBuffer("select model from TblCronTaskJobLog model where 1=1");

		String qstartDate = getCommQueryServletRequest().getParameter("qstartDate");
		String qendDate = getCommQueryServletRequest().getParameter("qendDate");
		String qQuartzResult = getCommQueryServletRequest().getParameter("qQuartzResult");
		List<Object> objlist = new ArrayList<Object>();
		if (!DataFormat.isEmpty(qstartDate)) {
			hql.append(" and model.excuteTime>=? ");
			objlist.add(qstartDate.replaceAll(":| ", ""));
		}
		if (!DataFormat.isEmpty(qendDate)) {
			hql.append(" and model.excuteTime<=? ");
			objlist.add(qendDate.replaceAll(":| ", ""));
		}
		if (StringUtils.isNotBlank(qQuartzResult)) {
			hql.append(" and model.excuteResult =?");
			objlist.add(qQuartzResult);
		}

		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setObjArray(objlist.toArray());
		pageQueryResult = rootdao.pageQueryByQL(queryCondition);

		return pageQueryResult;
	}
}
