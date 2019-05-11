package com.gbicc.rule.getter;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.rule.entity.TPubRulIndustryValue;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TPubRulIndustryValueDtlGetter extends BaseGetter {

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
		String rulCode = (String) getCommQueryServletRequest().getParameterMap().get("rulCode");
		String industryCode = (String) getCommQueryServletRequest().getParameterMap().get("industryCode");
		String flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
		if(StringUtils.isEmpty(flag)){
			flag="";
		}
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TPubRulIndustryValue where 1=1 ");
		if(StringUtils.isNotEmpty(rulCode) && StringUtils.isNotEmpty(industryCode) && StringUtils.isNotEmpty(flag) && flag.equals("add")){
			hql.append(" and rulCode='"+rulCode+"' and industryCode is null ");
		}else if(StringUtils.isNotEmpty(rulCode) && StringUtils.isNotEmpty(industryCode)){
			hql.append(" and rulCode='"+rulCode+"' and industryCode='"+industryCode+"' ");
		}else if(StringUtils.isNotEmpty(rulCode) && StringUtils.isEmpty(industryCode)){
			hql.append(" and rulCode='"+rulCode+"' and industryCode is null ");
		}
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		List list=pageQueryResult.getQueryResult();
		for(int i=0;i<list.size();i++){
			TPubRulIndustryValue value=(TPubRulIndustryValue) list.get(i);
			if(StringUtils.isNotEmpty(value.getIndustryCode())){
				value.setIndustryName(getIndustryName(value.getIndustryCode()));
			}
			//新增的查询，设置ID为空，设置页面传过来的行业代码
			if(flag.equals("add")){
				value.setId(null);
				value.setIndustryCode(industryCode);
				value.setIndustryName(getIndustryName(industryCode));
				value.setDesc(null);
				value.setValue(null);
			}
		}
		return pageQueryResult;
	}
	
	@SuppressWarnings("rawtypes")
	public String getIndustryName(String industryCode) throws CommonException{
		String sql="SELECT TYPE_VALUE FROM T_ODS_CMS_CODE_INDUSTRY WHERE TYPE_CD='"+industryCode+"' ";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Iterator it=rootdao.queryBySQL(sql);
		String industryName="";
		while(it.hasNext()){
			industryName=(String) it.next();
		}
		return industryName;
	}
}
