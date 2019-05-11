package com.gbicc.company.single.getter;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.service.ProcessManagerService;
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

public class TCmSingleRulWarningInfoGetter extends BaseGetter {

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
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id");

		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("select t1  from TCmSingleRulWarning t1 where 1=1");
		if(StringUtils.isNotEmpty(id)){
			hql.append(" and t1.id='"+id+"' ");
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		return pageQueryResult;
	}
	
	public static void main(String[] args) {
		String str="|L01";
		String[] s=str.split("\\|");
		for(int i=0;i<s.length;i++){
			if(s[i]!=null && !s[i].equals("")){
				System.out.println(s[i]+"--");
			}
		}
	}
}
