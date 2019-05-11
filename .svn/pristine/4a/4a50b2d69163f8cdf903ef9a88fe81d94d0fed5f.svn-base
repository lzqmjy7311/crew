package com.gbicc.person.product.getter;


import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.person.monitor.service.TPlTaskService;
import com.gbicc.person.product.entity.Product;
import com.gbicc.warn.entity.TWarning;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class AllProductSelect extends BaseGetter {


	public Result call() throws AppException {
		try {
			
			PageQueryResult pageResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());
			result.setContent(pageResult.getQueryResult());
			if (pageResult.getQueryResult().size() == 0) {
				result.getPage().setTotalPage(0);
			} else {
				result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			}
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
		String value=getCommQueryServletRequest().getParameter("value1");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//20160620 为了防止前天查询出现重复产品名称，作出修改。
		StringBuffer sql=new StringBuffer("select distinct product0_.prod_name as prodName, '' as id,  product0_.prod_code as prodCode, '' as prodType  from T_PL_PARAM_PRODUCT product0_   where 1=1 and product0_.PROD_TYPE in ('01','02','03') ");
	
		if(value!=null&&!value.equals("")){
			sql.append(" AND product0_.prod_code  like '"+value+"'  ");
		}
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		

		

		sql.append(" order by product0_.prod_code ");
		
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over() as rnum from ( ");
		sqlp.append(sql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(sql);
		sqll.append(" )");
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		 JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		 List<Product> listT=jdbcTemplate.query(sqlp.toString(), BeanPropertyRowMapper.newInstance(Product.class));
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult.setQueryResult(listT);
		pageQueryResult.setTotalCount(totalCount);
        

		return pageQueryResult;
	}


}
