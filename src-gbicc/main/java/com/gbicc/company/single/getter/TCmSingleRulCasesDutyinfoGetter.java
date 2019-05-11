package com.gbicc.company.single.getter;

import java.util.List;

import com.gbicc.company.single.entity.TCmSingleRulCasesDutyinfo;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TCmSingleRulCasesDutyinfoGetter extends BaseGetter {

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

	@SuppressWarnings("rawtypes")
	protected PageQueryResult getData() throws Exception {
		String casesId = (String) getCommQueryServletRequest().getParameterMap().get("casesId");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TCmSingleRulCasesDutyinfo t where 1=1 and casesId='"+casesId+"' ");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		List list=pageQueryResult.getQueryResult();
		for(int i=0;i<list.size();i++){
			TCmSingleRulCasesDutyinfo dutyinfo=(TCmSingleRulCasesDutyinfo) list.get(i);
			TlrInfo tlr=TlrInfoService.getInstance().getTlrInfoByTlrno(dutyinfo.getDuty());
			dutyinfo.setTempDutyName(tlr.getTlrName());
			Bctl bctl=BctlService.getInstance().getBctlByBrcode(dutyinfo.getDutyOrg());
			dutyinfo.setTempDutyOrgName(bctl.getBrname());
		}
		return pageQueryResult;
	}
}
