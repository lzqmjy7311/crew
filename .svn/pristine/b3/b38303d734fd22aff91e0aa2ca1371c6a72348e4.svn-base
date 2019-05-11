package com.gbicc.bpm.getter;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.bpm.entity.TlrInfoForExcel;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TlrInfoForZGRWZYGetter extends BaseGetter{

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
	
	protected PageQueryResult getData() throws CommonException {
		//
		BctlService bctlService = BctlService.getInstance();
		// 参数
		String brCode = (String) getCommQueryServletRequest().getParameterMap()
				.get("brCode");
		String tlrNo = (String) getCommQueryServletRequest().getParameterMap()
				.get("tlrNo");
		String tlrName = (String) getCommQueryServletRequest()
				.getParameterMap().get("tlrName");
		// 查询的主体语句
		StringBuffer mainSql = new StringBuffer(
				" SELECT distinct TLR.TLRNO AS TLRNO, "
				+ " TLR.TLR_NAME AS TLRNAME, "
				+ " REL.F_ORG_ID AS BRCODE "
				+ " FROM T_USER_ORGROLE_REL REL "
				+ " JOIN TLR_INFO TLR "
				+ " ON REL.F_USER_ID = TLR.TLRNO ");
		//query sql
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT * FROM ( ");
		sql.append(mainSql);
		sql.append(" ) X ");
		sql.append(" WHERE 1 = 1 ");
		// 查询条件
		if (StringUtils.hasText(brCode)) {
			sql.append(" AND X.BRCODE LIKE '" + brCode + "' ");
		}
		if(StringUtils.hasText(tlrNo)){
			sql.append(" AND X.TLRNO LIKE '%" + tlrNo + "%' ");
		}
		if(StringUtils.hasText(tlrName)){
			sql.append(" AND X.TLRNAME LIKE '%" + tlrName + "%' ");
		}
		// 排序
		sql.append(" ORDER BY X.TLRNO ASC ");
		// 每页粒度大小
		Integer pageSize = getResult().getPage().getEveryPage();
		// 当前页数
		Integer pageIndex = getResult().getPage().getCurrentPage();
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
		// 获取数据集
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<TlrInfoForExcel> listT = jdbcTemplate.query(sqlp.toString(),
				BeanPropertyRowMapper.newInstance(TlrInfoForExcel.class));
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult.setQueryResult(listT);
		pageQueryResult.setTotalCount(totalCount);
		return pageQueryResult;
	}

}
