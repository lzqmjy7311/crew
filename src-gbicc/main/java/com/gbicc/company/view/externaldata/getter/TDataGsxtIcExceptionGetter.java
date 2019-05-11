package com.gbicc.company.view.externaldata.getter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.company.financial.analysis.entity.TOutCouJudgmentDetail;
import com.gbicc.company.view.externaldata.entity.TDataGsxtIcException;
import com.gbicc.person.riskrulelist.entity.RiskruleList;
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
public class TDataGsxtIcExceptionGetter extends BaseGetter {

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
		String relaId = (String) getCommQueryServletRequest().getParameterMap()
				.get("relaId");
		String fdDate = (String) getCommQueryServletRequest().getParameterMap()
				.get("fdDate");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		
		JdbcTemplate jt=(JdbcTemplate)ApplicationContextUtils.getBean("JdbcTemplate");
		StringBuffer querySql=new StringBuffer("SELECT N.ID id,N.ADD_REASON fdInExceptionReson, N.ADD_DATE fdInExceptionDate, N.REM_REASON fdOutExceptionReson, N.REM_DATE fdOutExceptionDate, N.DECIDE_ORG fdDecisionOrg, N.ROW_DATE rowDate, N.BASE_ID fdJbkId FROM ECUSER.T_OUT_IND_BUSERROR N LEFT JOIN T_WB_GSINFO_V V ON N.BASE_ID=V.RELA_ID WHERE 1=1");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//		if(StringUtils.hasText(id)){
//			hql.append(" and id = '"+id+"'");
//		}
		if(StringUtils.hasText(id)){
//			hql.append(" and relaId = '"+relaId+"'");
			querySql.append(" AND N.ID='"+id+"'");
		}
		if(StringUtils.hasText(relaId)){
//			hql.append(" and relaId = '"+relaId+"'");
			querySql.append(" AND N.BASE_ID='"+relaId+"'");
		}else if(!StringUtils.hasText(id)){
			querySql.append(" AND 1=0");
		}
		if(StringUtils.hasText(fdDate)){
//			Calendar cd= Calendar.getInstance();
//			SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
//			Date nowdat=new Date();
//			String nowstr=df.format(nowdat);
//			Date lastdat=new Date();
			
			if(fdDate.equals("time1")){
//				cd.add(Calendar.MONTH, -1);
//				lastdat=cd.getTime();
				querySql.append(" and N.ADD_DATE between CURRENT DATE - 1 MONTH AND CURRENT DATE");
			}else if(fdDate.equals("time3")){
//				cd.add(Calendar.MONTH, -3);
//				lastdat=cd.getTime();
				querySql.append(" and N.ADD_DATE between CURRENT DATE - 3 MONTH AND CURRENT DATE");
			}else if(fdDate.equals("timehalf")){
//				cd.add(Calendar.MONTH, -6);
//				lastdat=cd.getTime();
				querySql.append(" and N.ADD_DATE between CURRENT DATE - 6 MONTH AND CURRENT DATE");
			}else if(fdDate.equals("timeyear")){
//				cd.add(Calendar.YEAR, -1);
//				lastdat=cd.getTime();
				querySql.append(" and N.ADD_DATE between CURRENT DATE - 1 YEAR AND CURRENT DATE");
			}else if(fdDate.equals("timetwo")){
//				cd.add(Calendar.YEAR, -2);
//				lastdat=cd.getTime();
				querySql.append(" and N.ADD_DATE between CURRENT DATE - 2 YEAR AND CURRENT DATE");
			}
			
//			String laststr=df.format(lastdat);
//			hql.append(" and judgDate between to_date('"+laststr+"','yyyy-mm-dd') and to_date('"+nowstr+"','yyyy-mm-dd')");
		}
//		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
//				hql.toString());
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over() as rnum from ( ");
		sqlp.append(querySql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(querySql);
		sqll.append(" )");
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		List<TDataGsxtIcException> listT=jt.query(sqlp.toString(), BeanPropertyRowMapper.newInstance(TDataGsxtIcException.class));
		pageQueryResult.setQueryResult(listT);
		pageQueryResult.setTotalCount(totalCount);
		return pageQueryResult;
	}
}
