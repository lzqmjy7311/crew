package com.gbicc.company.view.riskoverview.getter;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.company.view.riskoverview.entity.TRiskoverView;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TRiskoverViewGetter extends BaseGetter {

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
		String customerNum = (String) getCommQueryServletRequest().getParameterMap().get("customerNum");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		StringBuffer hql = new StringBuffer("SELECT C.CUSTOMER_NUM,D.WARN_Y_LEVEL RISKLEVEL,D.WARN_Y_VALUE FIVECORE,CASE WHEN Y.SCORE='0' THEN '不通过' WHEN Y.SCORE='1' THEN '通过' ELSE '未知' END DATACHECK ,"
				+ "CASE WHEN B.BLACKLIST_ORGN_CD IS NULL THEN '否' ELSE '是' END IMPORTCHANGE ,B.BLACKLIST_ORGN_CD FROM T_CM_CUSTOMER_WARN_LEV_DTL D,(SELECT MIN(V.YZ_VAL) AS SCORE,V.CUSTOMER_NUM "
				+ "FROM T_CM_OUT_CHECK_V V GROUP BY V.CUSTOMER_NUM) Y,T_ODS_CMS_BLACKLIST_INFO B,T_ODS_CMS_CORPORATION C WHERE C.CUSTOMER_NUM=D.CUSTOMER_NUM(+) AND C.CUSTOMER_NUM=Y.CUSTOMER_NUM(+) "
				+ "AND C.ORGN_NUM=B.BLACKLIST_ORGN_CD(+) AND C.CUSTOMER_NUM='"+customerNum+"' ORDER BY D.WARN_DATE DESC FETCH FIRST 1 ROWS ONLY ");

//		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
//		sqlp.append("select t.*,row_number() over() as rnum from ( ");
//		sqlp.append(hql);
//		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
//		sqlp.append("fetch first "+pageSize+" rows only ");
//		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
//		sqll.append(hql);
//		sqll.append(" )");
//		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		List<TRiskoverView> listT=jdbcTemplate.query(hql.toString(), BeanPropertyRowMapper.newInstance(TRiskoverView.class));
		
		pageQueryResult.setQueryResult(listT);

		return pageQueryResult;
	}
}
