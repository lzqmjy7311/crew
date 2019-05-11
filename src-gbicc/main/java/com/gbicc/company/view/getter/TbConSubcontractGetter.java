package com.gbicc.company.view.getter;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.company.view.entity.TOdsCmsBorrSummary;
import com.gbicc.company.view.entity.TbConSubcontract;
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
public class TbConSubcontractGetter extends BaseGetter {

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
		StringBuffer sql = new StringBuffer("SELECT T.DEBT_PERSON_NAME debtPersonName,T.SUBCONTRACT_NUM contractNum,T.GUARANTEE_TYPE_CD guarantyNote,T.SUB_CONTRACT_AMT contractTotalAmt,T.IF_TOP_GUARANTY comprBizContractInd,T.SUBCONTRACT_STATUS_CD contractStatusCd,T.SUB_CONTRACT_SIGN_DATE contractSignDate,T.EXPIRATION_DATE expirationDate FROM T_ODS_CMS_SUBCONTRACT T WHERE 1=1 ");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		if(StringUtils.hasText(customerNum)){
			sql.append(" and T.CUSTOMER_NUM = '"+customerNum+"' ORDER BY T.SUBCONTRACT_STATUS_CD");
		}
		else{
			sql.append(" and 1 = 0");
		}
		
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
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
		List<TbConSubcontract> listT=jdbcTemplate.query(sqlp.toString(), BeanPropertyRowMapper.newInstance(TbConSubcontract.class));
		
		pageQueryResult.setQueryResult(listT);
		pageQueryResult.setTotalCount(totalCount);
		return pageQueryResult;
	}
}
