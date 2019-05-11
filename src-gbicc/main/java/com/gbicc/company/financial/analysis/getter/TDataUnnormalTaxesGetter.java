package com.gbicc.company.financial.analysis.getter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

public class TDataUnnormalTaxesGetter extends BaseGetter {
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
		String id = (String) getCommQueryServletRequest().getParameterMap()
				.get("id");
		String relaId = (String) getCommQueryServletRequest().getParameterMap()
				.get("relaId");
		String fdDate = (String) getCommQueryServletRequest().getParameterMap()
				.get("fdDate");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TOutTaxUnusualDetail where 1=1 ");
		if (StringUtils.hasText(id)) {
			hql.append(" and id = '" + id + "'");
		}
		if (StringUtils.hasText(relaId)) {
			hql.append(" and relaId = '" + relaId + "'");
		} else {
			hql.append(" and 1=0 ");
		}
		if (StringUtils.hasText(fdDate)) {
			Calendar cd = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date nowdat = new Date();
			String nowstr = df.format(nowdat);
			Date lastdat = new Date();

			if (fdDate.equals("time1")) {
				cd.add(Calendar.MONTH, -1);
				lastdat = cd.getTime();
			} else if (fdDate.equals("time3")) {
				cd.add(Calendar.MONTH, -3);
				lastdat = cd.getTime();
			} else if (fdDate.equals("timehalf")) {
				cd.add(Calendar.MONTH, -6);
				lastdat = cd.getTime();
			} else if (fdDate.equals("timeyear")) {
				cd.add(Calendar.YEAR, -1);
				lastdat = cd.getTime();
			} else if (fdDate.equals("timetwo")) {
				cd.add(Calendar.YEAR, -2);
				lastdat = cd.getTime();
			}
			String laststr = df.format(lastdat);
			hql.append(" and rowDate between to_date('" + laststr
					+ "','yyyy-mm-dd') and to_date('" + nowstr
					+ "','yyyy-mm-dd')");
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
