package com.gbicc.company.view.getter;

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

@SuppressWarnings("unchecked")
public class TCmRiskViewRulWarningVGetter extends BaseGetter {

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
		String flag;
		String warningtype = (String) getCommQueryServletRequest().getParameterMap().get("warningtype");
		String warnCode = (String) getCommQueryServletRequest().getParameterMap().get("warnCode");
		String rulName = (String) getCommQueryServletRequest().getParameterMap().get("rulName");
		String rulThemeCd = (String) getCommQueryServletRequest().getParameterMap().get("rulTheme");
		String eliminateFlag = (String) getCommQueryServletRequest().getParameterMap().get("eliminateFlag");
		String removeFlag = (String) getCommQueryServletRequest().getParameterMap().get("removeFlag");
		String warnDt = (String) getCommQueryServletRequest().getParameterMap().get("warnDt");
		String endwarnDt = (String) getCommQueryServletRequest().getParameterMap().get("endwarnDt");
		String warnStatus = (String) getCommQueryServletRequest().getParameterMap().get("warnStatus");
		flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
		String customerNum = (String) getCommQueryServletRequest().getParameterMap().get("customerNum");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TCmRiskViewRulWarningV t where 1=1 ");
//		if(StringUtils.hasText(warningtype)){
//			hql.append(" and warningtype = '"+warningtype+"'");
//		}
		if(StringUtils.hasText(warnCode)){
			hql.append(" and warnCode = '"+warnCode+"'");
		}
		if(StringUtils.hasText(rulThemeCd)){
			hql.append(" and rulThemeCd like '%"+rulThemeCd+"%'");
		}
//		if(StringUtils.hasText(rulTheme)){
//			hql.append(" and rulTheme = '"+rulTheme+"'");
//		}
		if(StringUtils.hasText(eliminateFlag)){
			hql.append(" and eliminateFlag = '"+eliminateFlag+"'");
		}
//		if(StringUtils.hasText(removeFlag)){
//			hql.append(" and removeFlag = '"+removeFlag+"'");
//		}
		if(StringUtils.hasText(warnDt)){
			hql.append(" and  warnDt >= to_date('"+warnDt+"','yyyy-MM-dd')");
		}
		if(StringUtils.hasText(endwarnDt)){
			hql.append(" and  warnDt <= to_date('"+endwarnDt+"','yyyy-MM-dd')");
		}
		if(StringUtils.hasText(warnStatus)){
			hql.append(" and warnStatus = '"+warnStatus+"'");
		}
		if(StringUtils.hasText(customerNum)){
			hql.append(" and customerId = '"+customerNum+"'");
		}else{
			hql.append(" and 1=0 ");
		}
		if(flag!=null){
			if(flag.equals("true")){
				pageQueryResult = rootdao.pageQueryByHql(pageIndex, 3,
						hql.toString());
			}else if(flag.equals("false")){
				pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
						hql.toString());
			}
		}else{
			{hql.append("and 1=0");}
			pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		}

		return pageQueryResult;
	}
}
