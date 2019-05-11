package com.gbicc.person.frequency.getter;

import java.util.Iterator;




import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.service.ProcessManagerService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TPlTriggerFrequencyAcctTaskGetter extends BaseGetter {
	
	private static String WCL=" '0' ";//未处理状态
	private static String TH=" '3' ";//退回

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
		String loanAccount = (String) getCommQueryServletRequest().getParameterMap()
				.get("loanAccount");
		String custname = (String) getCommQueryServletRequest().getParameterMap()
				.get("custname");
		String rankFinal = (String) getCommQueryServletRequest().getParameterMap()
				.get("rankFinal");
		String operator = (String) getCommQueryServletRequest().getParameterMap()
				.get("operator");
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=null;
		userId=info.getTlrno();
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("select  t1  from TPlTriggerFrequencyAcct t1  ,ActiveTask t2  where t1.loanAcct=t2.businessKey ");
		if(StringUtils.isNotEmpty(loanAccount)){
			hql.append(" and t1.loanAcct like '%"+loanAccount+"%'");
		}
		if(StringUtils.isNotEmpty(custname)){
			hql.append(" and t1.custName like '%"+custname+"%'");
		}
		if(StringUtils.isNotEmpty(rankFinal)){
			hql.append(" and t1.warnLevel = '"+rankFinal+"'");
		}
		if(StringUtils.isNotEmpty(operator)){
			hql.append(" and t1.launchPer like '%"+operator+"%'");
		}
		if(StringUtils.isNotEmpty(userId)){
			hql.append(" and t2.assignee= '"+userId+"'");
		}		 
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
	
	public String getUserRoleId(String userId){
		String roleId="";
		String sql="SELECT ROLE_ID FROM TLR_ROLE_REL WHERE TLRNO ='"+userId+"'";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		try {
			Iterator<Integer> it= rootdao.queryBySQL(sql);
			while(it.hasNext()){
				roleId=it.next().toString();
			}
		} catch (CommonException e) {
			e.printStackTrace();
		}

		return roleId;
	}
}
