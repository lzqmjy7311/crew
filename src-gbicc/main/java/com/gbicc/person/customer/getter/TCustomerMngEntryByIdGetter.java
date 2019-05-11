package com.gbicc.person.customer.getter;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.person.customer.entity.TCustomer;
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

/**
 * 
 * @author xudongdong
 *
 * 版本：2015年10月21日 上午11:22:00
 * 类说明：客户 查询类
 */
@SuppressWarnings("unchecked")
public class TCustomerMngEntryByIdGetter extends BaseGetter {

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
		String loanAccount = (String) getCommQueryServletRequest().getParameterMap().get("loanAccount");
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TCustomer t where 1=1 ");
		if(StringUtils.hasText(loanAccount)){
			hql.append(" and loanAccount = '"+loanAccount+"'");
		}else{
			hql.append(" and 1=2");
		}
	//创建 财务指标视图 宽表  
//		String finType1="03";//'01'--企业资产负债表（02企业现金流量，03企业损益表）
//		this.creatFinView("21");
//		this.creatFinView("22");
		

		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString());


		return pageQueryResult;
		
		
//		PageQueryResult pageQueryResult = new PageQueryResult();
	}
	public String creatFinView(String finType){
		
		String sqlStart="CREATE TABLE  T_CM_FINANCE_STATEMENT_DATA_"+finType+"  AS  ( SELECT  DA.FINANCE_STATEMENT_ID ";
		String sql1="";
		String sqlEnd=" FROM T_CM_FINANCE_STATEMENT_DATA DA   WHERE  EXISTS ( SELECT 1 FROM T_CM_FINANCE_STATEMENT_CODE CD    "
				+ "   WHERE  DA.PROJECT_CD=CD.PROJECT_CD   AND CD.FINANCE_REPORT_SORT_CD='"+finType+"'                             "
				+ " 	 )   GROUP BY DA.FINANCE_STATEMENT_ID   ) DEFINITION ONLY                                                             ";
        String sql="SELECT T.PROJECT_CD   FROM T_CM_FINANCE_STATEMENT_CODE  T WHERE T.FINANCE_REPORT_SORT_CD='"+finType+"'";
		String sql2="";

		 JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		 List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		 for(Map<String,Object> en:list){
			 for(java.util.Map.Entry<String,Object> item:en.entrySet()){
				 sql1=sql1+",MAX( DECODE(DA.PROJECT_CD,'"+item.getValue()+"',DA.PROJECT_VALUE,0)) AS IND"+item.getValue()+" ";
			 }
			 sql2=sqlStart + sql1+sqlEnd;
			 System.out.println(sql2);
		 }
		 return sql2;
		
	}
}
