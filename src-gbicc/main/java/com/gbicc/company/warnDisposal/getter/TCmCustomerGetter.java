package com.gbicc.company.warnDisposal.getter;

import java.util.List;

import org.springframework.util.StringUtils;

import com.gbicc.company.warnDisposal.entity.TCmCustomer;
import com.gbicc.company.warnDisposal.entity.TCmWarnTask;
import com.gbicc.company.warnDisposal.service.TCmWarnTaskService;
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

@SuppressWarnings("unchecked")
public class TCmCustomerGetter extends BaseGetter {

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
		String taskId = (String) getCommQueryServletRequest().getParameterMap().get("taskId");
		String customerId = (String) getCommQueryServletRequest().getParameterMap().get("customerId");
		String custcode = (String) getCommQueryServletRequest().getParameterMap().get("custcode");
		String custname = (String) getCommQueryServletRequest().getParameterMap().get("custname");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TCmCustomer t where 1=1 ");
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}else if(StringUtils.hasText(customerId)){
			hql.append(" and id = '"+customerId+"'");
		}else{
			GlobalInfo info=GlobalInfo.getCurrentInstance();
			String userId=info.getTlrno();
			hql.append(" and operator ='"+userId+"'");
		}
		if(StringUtils.hasText(custname)){
			hql.append(" and custname like '%"+custname+"%'");
		}
		if(StringUtils.hasText(custcode)){
			hql.append(" and custcode like '%"+custcode+"%'");
		}
		
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		
		if(StringUtils.hasText(taskId)){
			TCmWarnTask task = TCmWarnTaskService.getInstance().get(taskId);
			List<TCmCustomer> list=pageQueryResult.getQueryResult();
			for (TCmCustomer objs : list) {
				objs.setTaskCode(task.getTaskCode());
			}
		}
		return pageQueryResult;
	}
}
