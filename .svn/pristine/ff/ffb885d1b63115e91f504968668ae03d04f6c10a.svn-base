package com.huateng.ebank.business.management.getter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.BiNationregionService;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.utils.ReportEnum;

public class BiNationregionEntryGetter extends BaseGetter {
	/*
	 * 获取国家/地区维护列表
	 * 
	 */
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "国家/地区代码维护查询");
			
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}
	/*
	 * 查询
	 */
	private PageQueryResult getData() {
		Map paramMap = this.getCommQueryServletRequest().getParameterMap();
		String qId = (String) paramMap.get("qid");
		String cnEnFullName = (String) paramMap.get("cnEnFullName");
		String cnEnShortName = (String) paramMap.get("cnEnShortName");
		String qnationregionNumber = (String) paramMap.get("qnationregionNumber");
		String qst = getCommQueryServletRequest().getParameter("st");
		String hql = "from BiNationregion biNationregion where  biNationregion.del='F'";
		if(StringUtils.isNotBlank(qId)) {
			hql += "and biNationregion.id like '%" + qId.trim() +"%'";
		}
		if(StringUtils.isNotBlank(cnEnFullName)) {
			hql += "and ( biNationregion.chinaName like '%" + cnEnFullName.trim() +"%' or biNationregion.engName like '%" + cnEnFullName.trim() +"%' )";
		}
		
		if(StringUtils.isNotBlank(cnEnShortName)) {
			hql += "and ( biNationregion.chinaShortName like '%" + cnEnShortName.trim() +"%' or biNationregion.engShortName like '%" + cnEnShortName.trim() +"%' )";
		}
		
		if(StringUtils.isNotBlank(qnationregionNumber)) {
			hql += "and biNationregion.nationregionNumber like '%" + qnationregionNumber.trim() +"%'";
		}
		if(qst!=null && qst.length()>0){
			   hql+=" and biNationregion.st ='"+qst+"'";
		 }else{
			   hql+=" and biNationregion.st<>'"+ReportEnum.REPORT_ST1.N.value+"'";
		 }
		   
		   
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		return BiNationregionService.getInstance().pageQueryByHql(pageIndex, pageSize,hql);
	}

}
