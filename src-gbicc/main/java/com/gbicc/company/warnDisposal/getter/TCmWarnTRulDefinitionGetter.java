package com.gbicc.company.warnDisposal.getter;

import java.util.List;

import org.springframework.util.StringUtils;

import com.gbicc.company.warnDisposal.service.TCmWarnTaskService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TCmWarnTRulDefinitionGetter extends BaseGetter {

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
		TCmWarnTaskService taskService = TCmWarnTaskService.getInstance();
		PageQueryResult pageQueryResult = new PageQueryResult();
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		
		List<DataDic> dicList=taskService.getDateDicList("12595");
		String dateNo="9999";
		for (DataDic dataDic : dicList) {
			if(dataDic.getDataName().indexOf("定性")>-1){
				dateNo=dataDic.getDataNo();
			}
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TRulDefinition t where 1=1 ");
		
		String ruleCode = (String) getCommQueryServletRequest().getParameterMap().get("ruleCode");
		String ruleName = (String) getCommQueryServletRequest().getParameterMap().get("ruleName");
		if(StringUtils.hasText(ruleCode)){
			hql.append(" and ruleCode like '%"+ruleCode+"%'");
		}
		if(StringUtils.hasText(ruleName)){
			hql.append(" and ruleName like '%"+ruleName+"%'");
		}
		hql.append(" and exists (from TRulCategory tc,TRulCategory tn where tc.parentId=tn.id and tn.categoryCode='"+dateNo+"' and tc.id=t.categoryId )");
		hql.append(" order by ruleVersion desc ,ruleUpdateddate desc");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}

}
