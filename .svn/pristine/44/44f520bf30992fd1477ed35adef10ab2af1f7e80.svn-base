package com.gbicc.log.getter;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.log.entity.TEtlDetailLog;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TEtlDetailLogGetter extends BaseGetter{

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
	
	
	private PageQueryResult getData() throws CommonException{
		//获取页面的参数
		String dataDate=(String) getCommQueryServletRequest().getParameterMap().get("dataDate");
		String procName=(String) getCommQueryServletRequest().getParameterMap().get("procName");
		String tableName=(String) getCommQueryServletRequest().getParameterMap().get("tableName");
		String loadRowsCount=(String) getCommQueryServletRequest().getParameterMap().get("loadRowsCount");
		String startTimestamp=(String) getCommQueryServletRequest().getParameterMap().get("startTimestamp");
		String endTimestamp=(String) getCommQueryServletRequest().getParameterMap().get("endTimestamp");
		//
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		//select语句
		StringBuffer hql=new StringBuffer(
				"SELECT "
				+ "ETL_DETAIL_LOG_ID AS etlDetailLogId, "
				+ "DATA_DATE AS dataDate, "
				+ "PROC_NAME AS procName, "
				+ "TABLE_NAME AS tableName, "
				+ "LOAD_ROWS_COUNT AS loadRowsCount, "
				+ "START_TIMESTAMP AS startTimestamp, "
				+ "END_TIMESTAMP AS endTimestamp "
				+ "FROM T_ETL_DETAIL_LOG "
				+ "WHERE 1 = 1 "
				);
		//添加查询条件
		if(StringUtils.hasText(dataDate)){
			hql.append("AND DATA_DATE LIKE '"+dataDate+"' ");
		}
		if(StringUtils.hasText(procName)){
			hql.append("AND PROC_NAME LIKE '%"+procName+"%' ");
		}
		if(StringUtils.hasText(tableName)){
			hql.append("AND TABLE_NAME LIKE '%"+tableName+"%' ");
		}
		if(StringUtils.hasText(loadRowsCount)){
			hql.append("AND LOAD_ROWS_COUNT = "+loadRowsCount+" ");
		}
		if(StringUtils.hasText(startTimestamp)){
			hql.append("AND TO_DATE(SUBSTR(START_TIMESTAMP,1,10),'YYYY-MM-DD')>=TO_DATE(' "+startTimestamp+"','YYYY-MM-DD') ");
		}
		if(StringUtils.hasText(endTimestamp)){
			hql.append("AND TO_DATE(SUBSTR(END_TIMESTAMP,1,10),'YYYY-MM-DD')<=TO_DATE(' "+endTimestamp+"','YYYY-MM-DD') ");
		}
		//分页
		//每页粒度大小
		Integer pageSize = getResult().getPage().getEveryPage();
		//当前页数
		Integer pageIndex = getResult().getPage().getCurrentPage();
		//分页
		StringBuffer sqlp=new StringBuffer("SELECT T0.* FROM ( ");
		sqlp.append("SELECT T.*,ROW_NUMBER() OVER() AS RNUM FROM ( ");
		sqlp.append(hql);
		sqlp.append(") T ) T0 WHERE T0.RNUM>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("FETCH FIRSt "+pageSize+" ROWS ONLY ");
		//统计总数目
		StringBuffer sqll=new StringBuffer("SELECT COUNT(1) FROM ( ");
		sqll.append(hql);
		sqll.append(" )");
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		//
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		List<TEtlDetailLog> listT=jdbcTemplate.query(sqlp.toString(), BeanPropertyRowMapper.newInstance(TEtlDetailLog.class));
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult.setQueryResult(listT);
		pageQueryResult.setTotalCount(totalCount);
		return pageQueryResult;
	}
}
