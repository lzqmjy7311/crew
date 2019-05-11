package com.gbicc.bpm.getter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.entity.TTaskDivert;
import com.gbicc.bpm.service.ProcessManagerService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TTaskDivertGetter extends BaseGetter {

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
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("select t1 from TTaskDivert t1,ActiveTask t2  where t1.id=t2.businessKey ");
		hql.append(" and t2.assignee='").append(userId).append("'");
		
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		BctlService bctlService=BctlService.getInstance();
		List list=pageQueryResult.getQueryResult();
		for(int i=0;i<list.size();i++){
			TTaskDivert task=(TTaskDivert) list.get(i);
			Bctl bctl=bctlService.getBctlByBrcode(task.getAssignee().getBrcode());
			task.setAssigneeOrg(bctl);
			
			Bctl bctl2=bctlService.getBctlByBrcode(task.getOldAssignee().getBrcode());
			task.setOldAssigneeOrg(bctl2);
		}
		return pageQueryResult;
	}
}
