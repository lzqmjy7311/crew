package com.gbicc.warn.ComninationWarn.getter;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TCwIdnexQueryGetter extends BaseGetter {

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
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
//		StringBuffer sql=new StringBuffer("SELECT L.INDEX_CODE as indexcode FROM T_CW_CREDIT_INDEX_VAL L WHERE L.GATHER_TYPE='5' group by l.INDEX_CODE");
//		JdbcTemplate jt =(JdbcTemplate)ApplicationContextUtils.getBean("JdbcTemplate");
//		List<Map<String, Object>> list=jt.queryForList(sql.toString());
//		StringBuffer listStr=new StringBuffer();
//		for(Map<String, Object> map:list){
//			listStr.append("'"+(String)map.get("indexcode")+"',");
//		}
//		listStr=listStr.deleteCharAt(listStr.length()-1);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TCwIdnexManage t where 1=1 ");
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		hql.append(" and gatherTypeHave='0' AND indexType='T1' AND monitorRpe='M' ");
//		hql.append(" and indexCode in ( "+listStr.toString()+") ");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
