package com.gbicc.person.collection.getter;



import java.net.URLEncoder;

import org.springframework.util.StringUtils;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.person.collection.service.TCollectionInfoService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 
 * @author liufei
 *
 * 版本：2015年11月07日 上午17:41:00
 * 类说明：催收 查询类
 */
@SuppressWarnings("unchecked")
public class TCollectionInfoHisGetter extends BaseGetter {

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
		String loanAccount=TCollectionInfoService.getInstance().get(id).getLoanAccount();
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TCollectionInfo t where 1=1 ");
		hql.append(" and not exists (from TCollectionInfo wm where wm.id=t.id and wm.id='"+id+"' ) ");
		if(StringUtils.hasText(loanAccount)){
			hql.append(" and t.loanAccount = '"+loanAccount+"'");
		}
		hql.append(" order by taskCount ");
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString());

		return pageQueryResult;
	}
	
}
