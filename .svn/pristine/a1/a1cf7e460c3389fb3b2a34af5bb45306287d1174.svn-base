package com.gbicc.company.financial.analysis.getter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.company.financial.analysis.entity.TOutTaxGraveBreak;
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

public class TOutDataTaxGetter extends BaseGetter {

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
		// 主函数
		StringBuffer mainSql=new StringBuffer(
				" SELECT G.ID AS ID, "
				+ " G.PAYTEX_USER AS PAYTEXUSER, "
				+ " G.PAYTEX_DISTCODE AS PAYTEXDISTCODE, "
				+ " G.ORGCODE AS ORGCODE, "
				+ " G.REGISTOR_ADDRESS AS REGISTORADDRESS, "
				+ " G.LEGAL_NAME AS LEGALNAME, "
				+ " G.MAIN_NAME AS MAINNAME, "
				+ " G.SECONDM_NAME AS SECONDMNAME, "
				+ " G.CASE_TYPE AS CASETYPE, "
				+ " G.ITEM_CONTENT AS ITEMCONTENT, "
				+ " G.RELA_ID AS RELAID, "
				+ " G.ROW_DATE AS ROWDATE "
				+ " FROM T_OUT_TAX_GRAVE_BREAK G ");
		// 查询函数
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT * FROM ( ");
		sql.append(mainSql);
		sql.append(" ) ");
		sql.append(" WHERE 1 = 1 ");
		//query condition
		if (StringUtils.hasText(id)) {
			sql.append(" AND ID LIKE '" + id + "'");
		}
		if (StringUtils.hasText(relaId)) {
			sql.append(" AND RELAID LIKE '" + relaId + "'");
		} else {
			sql.append(" AND 1=0 ");
		}
		if (StringUtils.hasText(fdDate)) {
			Calendar cd = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date nowdat = new Date();
			String nowstr = df.format(nowdat);
			Date lastdat = new Date();

			if (fdDate.equals("time1")) {
				cd.add(Calendar.MONTH, -1);
				lastdat = cd.getTime();
			} else if (fdDate.equals("time3")) {
				cd.add(Calendar.MONTH, -3);
				lastdat = cd.getTime();
			} else if (fdDate.equals("timehalf")) {
				cd.add(Calendar.MONTH, -6);
				lastdat = cd.getTime();
			} else if (fdDate.equals("timeyear")) {
				cd.add(Calendar.YEAR, -1);
				lastdat = cd.getTime();
			} else if (fdDate.equals("timetwo")) {
				cd.add(Calendar.YEAR, -2);
				lastdat = cd.getTime();
			}
			String laststr = df.format(lastdat);
			sql.append(" AND ROWDATE BETWEEN TO_DATE('" + laststr
					+ "','yyyy-mm-dd') AND TO_DATE('" + nowstr
					+ "','yyyy-mm-dd')");
		}
		// 分页
		StringBuffer sqlp = new StringBuffer("SELECT T0.* FROM ( ");
		sqlp.append("SELECT T.*,ROW_NUMBER() OVER() AS RNUM FROM ( ");
		sqlp.append(sql);
		sqlp.append(") T ) T0 WHERE T0.RNUM>" + (pageIndex - 1) * pageSize
				+ " ");
		sqlp.append("FETCH FIRSt " + pageSize + " ROWS ONLY ");
		// 统计总数目
		StringBuffer sqll = new StringBuffer("SELECT COUNT(1) FROM ( ");
		sqll.append(sql);
		sqll.append(" )");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Integer totalCount = (Integer) rootdao.querySqlOne(sqll.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<TOutTaxGraveBreak> listT = jdbcTemplate.query(sqlp.toString(),
				BeanPropertyRowMapper.newInstance(TOutTaxGraveBreak.class));
		//
		pageQueryResult.setQueryResult(listT);
		pageQueryResult.setTotalCount(totalCount);
		return pageQueryResult;
	}
}
