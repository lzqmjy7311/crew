package com.gbicc.company.single.getter;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.util.StringUtils;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.company.single.entity.TCmSingleRulInvestigation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TCmSingleRulInvestigationByIdGetter extends BaseGetter {

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

	@SuppressWarnings("unchecked")
	protected PageQueryResult getData() throws Exception {
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String casesId=(String) getCommQueryServletRequest().getParameterMap().get("casesId");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TCmSingleRulInvestigation t where 1=1 ");
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(casesId)){
			hql.append(" and casesId = '"+casesId+"'");
		}
		if(org.apache.commons.lang.StringUtils.isEmpty(id) && org.apache.commons.lang.StringUtils.isEmpty(casesId)){
			hql.append(" and 1=2 ");
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		List<TCmSingleRulInvestigation> list=pageQueryResult.getQueryResult();
		for(TCmSingleRulInvestigation inve:list){
			TlrInfo assignee=findTaskAssignee(inve.getId());
			if(null!=assignee){
				inve.setInveUser(assignee);
			}else{
				if(inve.getInveUser()!=null){
					inve.getInveUser().setTlrName(inve.getInveUser().getTlrName()+"("+inve.getInveUser().getTlrno()+")");
				}
			}
		}
		return pageQueryResult;
	}
	
	public TlrInfo findTaskAssignee(String businessId){
		List<Task> list=ProcessManagerService.getInstace().getTaskService().createTaskQuery().processInstanceBusinessKey(businessId).list();
		if(list!=null && list.size()>0){
			if(StringUtils.hasText(list.get(0).getAssignee())){
				try {
					TlrInfo tlrinfo = TlrInfoService.getInstance().getTlrInfoByTlrno(list.get(0).getAssignee());
					if(null!=tlrinfo){
						tlrinfo.setTlrName(tlrinfo.getTlrName()+"("+tlrinfo.getTlrno()+")");
						return tlrinfo;
					}else{
						return null;
					}
				} catch (CommonException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
