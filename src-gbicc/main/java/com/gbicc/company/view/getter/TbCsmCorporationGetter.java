package com.gbicc.company.view.getter;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.company.view.entity.TCmCustomer_v;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TbCsmCorporationGetter extends BaseGetter {

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
		String chineseName = (String) getCommQueryServletRequest()
				.getParameterMap().get("chineseName");
		String customerNum = (String) getCommQueryServletRequest()
				.getParameterMap().get("customerNum");
		String operBank = (String) getCommQueryServletRequest()
				.getParameterMap().get("deptCd");
		String operator = (String) getCommQueryServletRequest()
				.getParameterMap().get("operator");
		String isBlackName = (String) getCommQueryServletRequest()
				.getParameterMap().get("isBlackName");
		String warnYlevel = (String) getCommQueryServletRequest()
				.getParameterMap().get("warnYlevel");
		String roleId = (String) getCommQueryServletRequest().getParameterMap()
				.get("roleId");
		String brcode = (String) getCommQueryServletRequest().getParameterMap()
				.get("orgId");
		String userId = (String) getCommQueryServletRequest().getParameterMap()
				.get("userId");
		PageQueryResult pageQueryResult = new PageQueryResult();
		String partyId = (String) getCommQueryServletRequest()
				.getParameterMap().get("partyId");
		String redirectFlag = "";
		redirectFlag = (String) getCommQueryServletRequest().getParameterMap()
				.get("redirectFlag");

		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		// GlobalInfo info=GlobalInfo.getCurrentInstance();
		// String userId=info.getTlrno();
		// String brcode= info.getBrcode();

		StringBuffer hql = new StringBuffer(
				"select CASE WHEN T.BLACKLIST_CUSTOMER_NAME IS NULL THEN '否' ELSE  '是' END  isBlackName ,"
						+ "T.ORGN_NUM AS orgnNum,T.WARN_Y_LEVEL warnYlevel, "
						+ "T.CUSTOMER_NUM AS customerNum,"
						+ "T.CHINESE_NAME AS chineseName,"
						+ "T.CUST_MANAGER_ID AS customerManager,"
						+ "T.ADVANCE_BALANCE AS loanBalance,"
						+ "T.CORE_HANDLING_ORG_CD AS deptCd ,"
						+ "T.LOAN_CARD_NUM AS loanCardNum, T.INDUSTRY_LEVEL_TWO_CD AS industryCd "
						+ "from (SELECT  o.BLACKLIST_CUSTOMER_NAME,"
						+ "N.ORGN_NUM ,"
						+ "N.CUSTOMER_NUM ,L1.WARN_Y_LEVEL,"
						+ "N.LOAN_CARD_NUM,substr(N.INDUSTRY_LEVEL_TWO_CD,1,1)  INDUSTRY_LEVEL_TWO_CD,"
						+ "N.CHINESE_NAME ,"
						+ "X.CUST_MANAGER_ID ,"
						+ "X.ADVANCE_BALANCE,"
						+ "x.CORE_HANDLING_ORG_CD "
						+ "from (select * from (SELECT p.*,ROW_NUMBER () over(partition by p.BLACKLIST_ORGN_CD) as nb FROM ECUSER.T_ODS_CMS_BLACKLIST_INFO p where p.BLACKLIST_ORGN_CD is not null and p.BLACKLIST_ORGN_CD <>'') t where t.nb=1) o ,"
						+ "T_ODS_CMS_CORPORATION n,"
						+ "T_ODS_CMS_CORP_INDEX X,(SELECT * FROM (SELECT L.*,RANK() OVER(PARTITION BY L.CUSTOMER_NUM ORDER BY L.WARN_DATE DESC) RM FROM T_CM_CUSTOMER_WARN_LEV_DTL L) X WHERE X.RM='1') L1 "
						+ "where o.BLACKLIST_ORGN_CD(+)=n.ORGN_NUM "
						+ " AND X.CUSTOMER_NUM(+)=n.CUSTOMER_NUM AND L1.CUSTOMER_NUM(+)=n.CUSTOMER_NUM "
						+ "and n.ORGN_NUM !=''  )T WHERE 1=1 ");
		if ("true".equals(redirectFlag)) {
			if (StringUtils.hasText(partyId)) {
				hql.append(" and CUSTOMER_NUM IN " + "( select G.CUSTOMER_NUM "
						+ " FROM T_ODS_CMS_CREDIT_GROUP_MEMBER G  "
						+ "WHERE G.PARTY_ID LIKE '" + partyId + "' )");
			}

		} else {
			if (roleId.equals("601")) {
				operator = userId;
				if (StringUtils.hasText(operator)) {
					hql.append(" and T.CUST_MANAGER_ID  = '" + operator + "'");
				}    
			} else if (roleId.equals("605") || roleId.equals("559")
					|| roleId.equals("560") || roleId.equals("111")
					|| roleId.equals("617")|| roleId.equals("618")
					|| roleId.equals("619")) {
				operBank = (String) getCommQueryServletRequest()
						.getParameterMap().get("bankName");
			} else if (StringUtils.hasText(brcode)) {
				BctlService bctlService = BctlService.getInstance();
				String brcodes = bctlService.getAllSubListStr(brcode);
				hql = new StringBuffer(
						"select CASE WHEN T.BLACKLIST_CUSTOMER_NAME IS NULL THEN '否' ELSE  '是' END  isBlackName ,"
								+ "T.ORGN_NUM AS orgnNum,"
								+ "T.CUSTOMER_NUM AS customerNum,T.WARN_Y_LEVEL warnYlevel, "
								+ "T.CHINESE_NAME AS chineseName,"
								+ "T.CUST_MANAGER_ID AS customerManager,"
								+ "T.ADVANCE_BALANCE AS loanBalance,"
								+ "T.CORE_HANDLING_ORG_CD AS deptCd,"
								+ "T.LOAN_CARD_NUM AS loanCardNum, T.INDUSTRY_LEVEL_TWO_CD AS industryCd "
								+ "from (SELECT o.BLACKLIST_CUSTOMER_NAME,"
								+ "N.ORGN_NUM ,"
								+ "N.CUSTOMER_NUM ,"
								+ "N.CHINESE_NAME ,"
								+ "X.CUST_MANAGER_ID ,L1.WARN_Y_LEVEL, "
								+ "N.LOAN_CARD_NUM,"
								+ "X.ADVANCE_BALANCE ,substr(N.INDUSTRY_LEVEL_TWO_CD,1,1)  INDUSTRY_LEVEL_TWO_CD,"
								+ "x.CORE_HANDLING_ORG_CD "
								+ " FROM ECUSER.T_ODS_CMS_BLACKLIST_INFO o ,"
								+ "T_ODS_CMS_CORPORATION n,"
								+ "T_ODS_CMS_CORP_INDEX X ,(SELECT * FROM (SELECT L.*,RANK() OVER(PARTITION BY L.CUSTOMER_NUM ORDER BY L.WARN_DATE DESC) RM FROM T_CM_CUSTOMER_WARN_LEV_DTL L) X WHERE X.RM='1') L1 "
								+ "where o.BLACKLIST_ORGN_CD(+)=n.ORGN_NUM "
								+ " AND X.CUSTOMER_NUM(+)=n.CUSTOMER_NUM  AND L1.CUSTOMER_NUM(+)=n.CUSTOMER_NUM "
								+ "and n.ORGN_NUM !='')T WHERE 1=1 AND T.CUST_MANAGER_ID IN");
				TPlTaskService tts = TPlTaskService.getInstance();
				String userIds = tts.getUserIdsByBrcodes(brcodes);
				hql.append("(" + userIds + ") AND T.CORE_HANDLING_ORG_CD IN ("+brcodes+")");
			} else if (roleId.equals("613")) {
				hql = new StringBuffer(
						"select * from T_ODS_CMS_CORP_INDEX where 1=0");
			} else {
				hql = new StringBuffer(
						"select * from T_ODS_CMS_CORP_INDEX where 1=0");

			}
			if (StringUtils.hasText(chineseName)) {
				// chineseName=new
				// String(chineseName.getBytes("iso-8859-1"),"utf-8");
				// chineseName=URLDecoder.decode(chineseName,"UTF-8");
				hql.append(" and T.CHINESE_NAME like '%" + chineseName + "%'");
			}
			if (StringUtils.hasText(customerNum)) {
				hql.append(" and T.CUSTOMER_NUM LIKE '%" + customerNum + "%'");
			}
			if (StringUtils.hasText(operBank)) {
				hql.append(" and T.CORE_HANDLING_ORG_CD LIKE '%" + operBank
						+ "%'");
			}
			if (StringUtils.hasText(operator)) {
				hql.append(" and T.CUST_MANAGER_ID LIKE '%" + operator + "%'");
			}
			if (StringUtils.hasText(warnYlevel)) {
				hql.append(" and T.WARN_Y_LEVEL ='" + warnYlevel
						+ "'");
			}
			if (StringUtils.hasText(isBlackName)) {
				if (isBlackName.equals("0")) {
					hql.append(" and T.BLACKLIST_CUSTOMER_NAME is  null");
				} else {
					hql.append(" and T.BLACKLIST_CUSTOMER_NAME is not null");

				}
			}
		}
		StringBuffer sqlp = new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over() as rnum from ( ");
		sqlp.append(hql);
		sqlp.append(") t ) t0 where t0.rnum>" + (pageIndex - 1) * pageSize
				+ " ");
		sqlp.append("fetch first " + pageSize + " rows only ");
		StringBuffer sqll = new StringBuffer("select count(1) from ( ");
		sqll.append(hql);
		sqll.append(" )");
		Integer totalCount = (Integer) rootdao.querySqlOne(sqll.toString());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ApplicationContextUtils
				.getBean("JdbcTemplate");
		List<TCmCustomer_v> listT = jdbcTemplate.query(sqlp.toString(),
				BeanPropertyRowMapper.newInstance(TCmCustomer_v.class));

		pageQueryResult.setQueryResult(listT);
		pageQueryResult.setTotalCount(totalCount);
		// pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
		// hql.toString());
		return pageQueryResult;
	}
}
