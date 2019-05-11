package com.gbicc.company.view.getter;


import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.bpm.SpringContextHolder;
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
public class TlrInfoGetter extends BaseGetter {

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
		String brcode = (String) getCommQueryServletRequest().getParameterMap()
				.get("brcode");
		String tlrno = (String) getCommQueryServletRequest().getParameterMap()
				.get("tlrno");
		String flag = (String) getCommQueryServletRequest().getParameterMap()
				.get("flag");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql=null;
		if(flag!=null){
			hql = new StringBuffer("select t.TLRNO as tlrno,t.TLR_NAME as tlrName from TLR_INFO t,TLR_ROLE_REL t1 where 1=1 and t.TLRNO=t1.TLRNO and t1.ROLE_ID='601' ");
		}else{
			hql = new StringBuffer("select t.TLRNO as tlrno,t.TLR_NAME as tlrName from TLR_INFO t,TLR_ROLE_REL t1 where 1=1 and t.TLRNO=t1.TLRNO and t1.ROLE_ID='222' ");
		}
		
		if(StringUtils.hasText(brcode)){
			hql.append(" and t.BRCODE = '"+brcode+"'");
		}
		if(StringUtils.hasText(tlrno)){
			hql.append(" and t.tlrno = '"+tlrno+"'");
		}
		
		JdbcTemplate jt=SpringContextHolder.getBean(JdbcTemplate.class);
		List<Map<String,Object>> list=jt.queryForList(hql.toString());
		pageQueryResult.setQueryResult(list);
		return pageQueryResult;
	}
}

