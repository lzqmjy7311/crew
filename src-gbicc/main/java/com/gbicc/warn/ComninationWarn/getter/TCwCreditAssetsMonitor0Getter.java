package com.gbicc.warn.ComninationWarn.getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
public class TCwCreditAssetsMonitor0Getter extends BaseGetter {

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
		String indexType = (String) getCommQueryServletRequest().getParameterMap()
				.get("indexType");
		String gatherType = (String) getCommQueryServletRequest().getParameterMap()
				.get("gatherType");
		                                                                                  
		int pageSize = getResult().getPage().getEveryPage();// 分页大小
		int pageIndex = getResult().getPage().getCurrentPage();// 页码
		
		Date nowDate=new Date();
		Calendar cd=Calendar.getInstance();
		cd.add(Calendar.DAY_OF_MONTH, -1);
		nowDate=cd.getTime();
		StringBuffer sbf = new StringBuffer("");
		sbf.append("SELECT X.*,ROWNUMBER() OVER() AS ROWNUM ,RANK() OVER(PARTITION BY X.INDEX_TYPE,X.DATA_DATE,substr(X.INDEX_NAME,1,2)  ORDER BY X.INDEX_CODE) FROM (");
		sbf.append(" SELECT T.ORG_CODE,T.INDEX_CODE,T.INDEX_NAME,T.INDEX_TYPE,T.MONITOR_FRE,T.INDUSTRY_CODE,T.NOW_VAL,T.COLO,T.THRESHOLD1,T.THRESHOLD2,T.TOP_VAL,T.YC_VAL,T.DATA_DATE FROM (");
		sbf.append(" 	SELECT * FROM T_CW_CREDIT_INDEX_VAL T WHERE T.DATA_DATE='"+DateUtils.formatDate(nowDate)+"' AND T.MONITOR_FRE='D'");
		sbf.append(" 	UNION ALL");
		sbf.append(" 	SELECT * FROM T_CW_CREDIT_INDEX_VAL T WHERE T.MONITOR_FRE='M'");
		//测试时  注释 有数据
		sbf.append(" 	AND T.DATA_DATE=TO_CHAR(LAST_DAY(DATE('"+DateUtils.formatDate(nowDate)+"')-1 MONTHS),'YYYY-MM-DD')  ");
		sbf.append(" 	UNION ALL");
		sbf.append(" 	SELECT * FROM T_CW_CREDIT_INDEX_VAL T WHERE  T.MONITOR_FRE='Q' ");
		
		sbf.append(" 	AND T.DATA_DATE=TO_CHAR(DATE('"+DateUtils.getNowDateLastQ(new Date())+"')-1 DAYS,'YYYY-MM-DD') ");
		sbf.append(" 	) T INNER JOIN T_CW_IDNEX_MANAGE TI ON T.INDEX_CODE=TI.INDEX_CODE and T.INDEX_TYPE='T3' AND T.GATHER_TYPE=TI.GATHER_TYPE ");
		sbf.append(" 	WHERE 1=1 ");
		//测试时  注释 有数据
		sbf.append(" 	AND T.ORG_CODE='"+info.getBrcode()+"' ");
		
		sbf.append(" 	AND T.PRODUCT_CODE='-' ");
		sbf.append(" 	AND T.INDUSTRY_CODE='-' ");
		sbf.append(" union all ");
		sbf.append("SELECT T1.ORG_CODE,T1.INDEX_CODE,T1.INDEX_NAME,T1.INDEX_TYPE,T1.MONITOR_FRE,T1.INDUSTRY_CODE,T1.NOW_VAL,T1.COLO,T1.THRESHOLD1,T1.THRESHOLD2,T2.NOW_VAL TOP_VAL,T3.NOW_VAL YC_VAL ,T1.DATA_DATE "
				+"FROM T_CW_CREDIT_INDEX_VAL T1 LEFT JOIN T_CW_CREDIT_INDEX_VAL T2 ON T1.INDEX_CODE=T2.INDEX_CODE AND T1.GATHER_TYPE=T2.GATHER_TYPE AND LAST_DAY(DATE(T1.DATA_DATE) - 3 MONTHS)=DATE(T2.DATA_DATE) LEFT JOIN T_CW_CREDIT_INDEX_VAL T3 ON T1.INDEX_CODE=T3.INDEX_CODE AND T1.GATHER_TYPE=T3.GATHER_TYPE AND TO_CHAR(TRUNC(DATE(T1.DATA_DATE),'YYYY')-1 DAYS,'YYYY-MM-DD')=T3.DATA_DATE "
				+" WHERE T1.DATA_DATE=TO_CHAR(DATE('"+DateUtils.getNowDateLastQ(new Date())+"')-1 DAYS,'YYYY-MM-DD') AND T1.GATHER_TYPE='3' AND T1.INDEX_TYPE='xyyy' ) X ");
		String countSql=sbf.toString();
		sbf.append(" WHERE ROWNUM>="+((pageIndex-1)*pageSize+1)+" AND ROWNUM<="+(pageIndex*pageSize));


		String sql= sbf.toString();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(countSql);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		System.out.println("总列表查询------------"+sql);
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		List<TCwCreditAssetsMonitor> listT=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TCwCreditAssetsMonitor.class));
		List<TCwCreditAssetsMonitor> list1=new ArrayList<TCwCreditAssetsMonitor>();
		Iterator<TCwCreditAssetsMonitor> itT=listT.iterator();
		while(itT.hasNext()){
			TCwCreditAssetsMonitor tc=itT.next();
			
			if(tc.getINDEX_CODE().equals("zcgm04")||tc.getINDEX_CODE().equals("zcgm05")||tc.getINDEX_CODE().equals("zcgm06")||tc.getINDEX_CODE().equals("zcgm07")||tc.getINDEX_CODE().equals("zcgm09")||tc.getINDEX_CODE().equals("txgm03")){
				String nowValue="";
				String tpValue="";
				String ycValue="";
				Double nowdb=tc.getNOW_VAL();
				Double tpdb=tc.getTOP_VAL();
				Double ycdb=tc.getYC_VAL();
				if(nowdb!=null){
					nowdb=nowdb/10000;
					nowValue=String.format("%.2f", nowdb);
					nowdb=Double.valueOf(nowValue);
					tc.setNOW_VAL(nowdb);
				}
				if(tpdb!=null){
					tpdb=tpdb/10000;
					tpValue=String.format("%.2f", tpdb);
					tpdb=Double.valueOf(tpValue);
					tc.setTOP_VAL(tpdb);
				}
				if(ycdb!=null){
					ycdb=ycdb/10000;
					ycValue=String.format("%.2f", ycdb);
					ycdb=Double.valueOf(ycValue);
					tc.setYC_VAL(ycdb);
				}
			}
			list1.add(tc);
		}
		listT=list1;
		PageQueryResult pageQueryResult=hqlDAO.pageQueryBySQL(queryCondition);
		pageQueryResult.setQueryResult(listT);
		return pageQueryResult;
	}

 
}
