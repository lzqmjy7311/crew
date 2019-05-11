package com.gbicc.user.getter;

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
public class TModifiedRoleidGetter extends BaseGetter{
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
		String fdOperid = (String) getCommQueryServletRequest().getParameterMap().get("fdOperid");
		String fdUsername = (String) getCommQueryServletRequest().getParameterMap().get("fdUsername");
		String fdOpername = (String) getCommQueryServletRequest().getParameterMap().get("fdOpername");
		String fdUserid = (String) getCommQueryServletRequest().getParameterMap().get("fdUserid");
		String fdOrgid = (String) getCommQueryServletRequest().getParameterMap().get("fdOrgid");
		String startTime = (String) getCommQueryServletRequest().getParameterMap().get("fdstartdate");
		String endTime = (String) getCommQueryServletRequest().getParameterMap().get("fdenddate");
		
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TModifiedRoleid t where 1=1 ");
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(fdUsername)){
			hql.append(" and fdUsername like '%"+fdUsername+"%'");
		}
		if(StringUtils.hasText(fdOpername)){
			hql.append(" and fdOpername like '%"+fdOpername+"%'");
		}
		if(StringUtils.hasText(fdUserid)){
			hql.append(" and fdUserid like '"+fdUserid+"%'");
		}
		if(StringUtils.hasText(fdOrgid)){
			hql.append(" and riskSignal like '"+fdOrgid+"%'");
		}
		if(StringUtils.hasText(startTime)){
			if(StringUtils.hasText(endTime)){
				hql.append(" and fdChangedate between to_DATE('"+startTime+"','yyyy-mm-dd') and to_DATE('"+endTime+"','yyyy-mm-dd')");			
			}
		}

		
//		List<TCustomer> list = rootdao.pageQueryByHql(hql.toString(), pageIndex, pageSize);
//		pageQueryResult.setTotalCount(list.size());
//		pageQueryResult.setQueryResult(list);
		hql.append(" order by fdChangedate desc");
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString());
        

		return pageQueryResult;
	}

}
