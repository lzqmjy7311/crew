package com.gbicc.company.view.getter;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.company.view.entity.TOdsCmsCorporation;
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
public class TOdsCsmCorporationGetter extends BaseGetter {

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
		
		StringBuffer sql = new StringBuffer("SELECT N.CHINESE_NAME chineseName,N.CUSTOMER_NUM customerNum,N.BUSINESS_LICENSE_NUM businessLicenseNum,N.ORGN_NUM orgnNum,N.REGISTERED_CAPITAL registeredCapital,N.CUSTOMER_SIZE_CD customerSizeCd,substr(N.INDUSTRY_LEVEL_TWO_CD,1,1) industryLevelOneCd,X.CORPORATIVE legalrepresentative,X.GROUP_NAME membershipgroup,N.NEW_EVAL_RESULT newEvalResult FROM T_ODS_CMS_CORP_INDEX X ,T_ODS_CMS_CORPORATION N WHERE X.CUSTOMER_NUM(+)=N.CUSTOMER_NUM ");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		if(StringUtils.hasText(customerNum)){
			sql.append(" and N.CUSTOMER_NUM = '"+customerNum+"'");
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
		List<TOdsCmsCorporation> listT=jdbcTemplate.query(sqlp.toString(), BeanPropertyRowMapper.newInstance(TOdsCmsCorporation.class));
		
		pageQueryResult.setQueryResult(listT);
		pageQueryResult.setTotalCount(totalCount);
		return pageQueryResult;
	}
}
