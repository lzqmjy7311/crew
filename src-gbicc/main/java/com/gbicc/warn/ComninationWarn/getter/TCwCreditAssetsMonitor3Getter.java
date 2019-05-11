package com.gbicc.warn.ComninationWarn.getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.util.DateUtils;
import com.gbicc.warn.ComninationWarn.entity.TCwCreditAssetsMonitor;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TCwCreditAssetsMonitor3Getter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(), pageResult.getQueryResult(),getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	public PageQueryResult getData() throws Exception {
		
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		
		                                                                                  
		int pageSize = getResult().getPage().getEveryPage();// 分页大小
		int pageIndex = getResult().getPage().getCurrentPage();// 页码
		Map<String,Object> map =  getCommQueryServletRequest().getParameterMap();
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" SELECT ROWNUMBER() OVER()  AS ROWNUM,T1.INDEX_CODE,T1.INDEX_NAME,T1.MONITOR_FRE,T1.NOW_VAL,T1.COLO,T1.THRESHOLD1,T1.THRESHOLD2,T2.NOW_VAL \"TOP_VAL\",T3.NOW_VAL \"YC_VAL\" FROM T_CW_CREDIT_INDEX_VAL T1"); 
		sbf.append(" LEFT JOIN T_CW_CREDIT_INDEX_VAL T2 ON T1.INDEX_CODE=T2.INDEX_CODE ");
		sbf.append(" AND T1.GATHER_TYPE=T2.GATHER_TYPE");
		sbf.append(" AND LAST_DAY(DATE(T1.DATA_DATE) - 3 MONTHS)=DATE(T2.DATA_DATE)");
		sbf.append(" LEFT JOIN  T_CW_CREDIT_INDEX_VAL T3  ON T1.INDEX_CODE=T3.INDEX_CODE");
		sbf.append(" AND T1.GATHER_TYPE=T3.GATHER_TYPE");
		sbf.append(" AND TO_CHAR(TRUNC(DATE(T1.DATA_DATE),'YYYY')-1 DAYS,'YYYY-MM-DD')=T3.DATA_DATE");
		sbf.append("   WHERE T1.DATA_DATE=TO_CHAR(LAST_DAY(DATE('"+DateUtils.formatDate(new Date())+"')-1 MONTHS),'YYYY-MM-DD') ");
		
		
		if(map.get("GATHER_TYPE")!=null && StringUtils.isNotBlank((String)map.get("GATHER_TYPE"))){
			sbf.append(" 	AND T1.GATHER_TYPE='"+(String)map.get("GATHER_TYPE")+"' ");
		}else{
			//不查询数据
			sbf.append("  AND T1.GATHER_TYPE='9'");
		}
		
		String countSql=sbf.toString();
		sbf.append(" AND ROWNUM>="+((pageIndex-1)*pageSize+1)+" AND ROWNUM<="+(pageIndex*pageSize));
		
		String sql= sbf.toString();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(countSql);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		System.out.println("一般行业集中度_列表查询-----GATHER_TYPE="+(String)map.get("GATHER_TYPE")+"-------"+sql);
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		List<TCwCreditAssetsMonitor> listT=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TCwCreditAssetsMonitor.class));
		PageQueryResult pageQueryResult=hqlDAO.pageQueryBySQL(queryCondition);
		pageQueryResult.setQueryResult(listT);
		return pageQueryResult;
	}
	
	
	public static void main(String[] args) throws ParseException {
		System.out.println(DateUtils.getNowDateLastQ(new Date()));
		
	}
	
	
	private static String ssString(double 阀值1,double 阀值2,String index_Type,double 数据){
		if(index_Type=="0"){//递减
				if(数据>阀值2){
					return "绿色";
				}else if(数据<=阀值1){
					return "红色";
				}else{
					return "黄色";
				}
		}else{//递增
				if(数据>=阀值2){
					return "红色";
				}else if(数据<阀值1){
					return "绿色";
				}else{
					return "黄色";
				}
		}
		
		
		
	}
	
}
