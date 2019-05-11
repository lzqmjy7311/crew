package com.gbicc.job.getter;

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
public class TOdsCmsCustomerRelationGetter extends BaseGetter {

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
		String customerNum = (String) getCommQueryServletRequest().getParameterMap()
				.get("customerNum");
		String chineseName = (String) getCommQueryServletRequest().getParameterMap()
				.get("chineseName");
		String custNo = (String) getCommQueryServletRequest().getParameterMap()
				.get("custNo");
		String custName = (String) getCommQueryServletRequest().getParameterMap()
				.get("custName");
		
		
		
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		
		
		StringBuffer sql = new StringBuffer("select * from ("
				+" select b.CUSTOMER_NUM,b.CHINESE_NAME,c.CUSTNO,c.CUSTNAME FROM  T_ODS_CMS_CUSTOMER_RELATION as a"
				+" left join T_ODS_CMS_CORPORATION as b on a.CUSTOMER_NUM=b.CUSTOMER_NUM"
				+" left join T_ODS_ECF_CUSTOMER_C as c on a.CORE_CUSTOMER_NUM=c.CUSTNO"
				+" ) where 1=1 ");
		if(StringUtils.hasText(customerNum)){
			sql.append(" and CUSTOMER_NUM like '%"+customerNum+"%'");
		}
		if(StringUtils.hasText(chineseName)){
			sql.append(" and CHINESE_NAME like '%"+chineseName+"%'");
		}
		if(StringUtils.hasText(custNo)){
			sql.append(" and CUSTNO like '%"+custNo+"%'");
		}
		if(StringUtils.hasText(custName)){
			sql.append(" and CUSTNAME like '%"+custName+"%'");
		}
		
		
		String orderby="";
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(sql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<Map<String,Object>> resultList=jdbcTemplate.queryForList(sqlp.toString());
		//构造数据量
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(sql);
		sqll.append(" )");
		//set
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		
		PageQueryResult result = new PageQueryResult();
		result.setQueryResult(resultList);
		result.setTotalCount(totalCount);
		return result;
	}
}
