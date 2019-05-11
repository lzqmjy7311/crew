package com.gbicc.person.riskrulelist.getter;

import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;







import com.gbicc.company.financial.analysis.entity.FinanceIndexData;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.gbicc.person.riskrulelist.entity.RiskruleList;
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
public class RiskruleListGetter extends BaseGetter{
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
		String userId = (String) getCommQueryServletRequest().getParameterMap().get("userId");
		String roleId = (String) getCommQueryServletRequest().getParameterMap().get("roleId");
		String brcode = (String) getCommQueryServletRequest().getParameterMap().get("orgId");
		String flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
		String productName = (String) getCommQueryServletRequest().getParameterMap().get("productName");
		String lounAcc = (String) getCommQueryServletRequest().getParameterMap().get("lounAcc");
		String custName = (String) getCommQueryServletRequest().getParameterMap().get("custName");
		String loanAmt = (String) getCommQueryServletRequest().getParameterMap().get("loanAmt");
		String loanBalance = (String) getCommQueryServletRequest().getParameterMap().get("loanBalance");
		String warnDate = (String) getCommQueryServletRequest().getParameterMap().get("warnDate");
		String ruleDesc = (String) getCommQueryServletRequest().getParameterMap().get("ruleDesc");
		String changeDate = (String) getCommQueryServletRequest().getParameterMap().get("changeDate");
		String warnSignal = (String) getCommQueryServletRequest().getParameterMap().get("warnSignal");
		String ruleID = (String) getCommQueryServletRequest().getParameterMap().get("ruleID");
		String isNewcust = (String) getCommQueryServletRequest().getParameterMap().get("isNewcust");		String lastwarnDate = (String) getCommQueryServletRequest().getParameterMap().get("lastwarnDate");
		String customerNum = (String) getCommQueryServletRequest().getParameterMap().get("customerNum");
		String warningLevel = (String) getCommQueryServletRequest().getParameterMap().get("warningLevel");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//		GlobalInfo info=GlobalInfo.getCurrentInstance();
//		String userId=info.getTlrno();
//		String brcode= info.getBrcode();
//		StringBuffer hq2 = new StringBuffer("select  ROLE_ID from TLR_ROLE_REL  t where 1=1 ");
		StringBuffer hql = new StringBuffer("select "
					+ "T.FD_RULE_RANK as   warnSignal,"
					+ "T.FD_RULE_CODE as  ruleCode,"
					+ "T.FD_RULE_ID   as  ruleID,"
					+ "T.FD_RULE_NAME as  ruleDesc,"
					+ "K.FD_RANK_FINAL     as  warningLevel,"
					+ "L.OPERNAME  as operator,"
					+ "L.LOANACNO     as  lounAcc,"
					+ "L.CUSTNAME     as  custName,"
					+ "L.PRODNAME     as  productName,"
					+ "L.TCAPI        as  loanAmt,"
					+ "L.BAL          as  loanBalance,"
					+ "L.BANKNAME     as  BANKNAME,"
					+ "T.FD_PROCESS_DATE as changeDate, "
					+ "T.FD_PROCESS_DATE  as  warnDate,"
					+ "CASE WHEN x.COUN>1 THEN '否' ELSE '是' END AS isNewcust"
					+ " "
					+ " FROM T_PL_TASK_RULE_TRIG T,"
					+ "T_EDW_PLS_ACCOUNT_V L,T_PL_TASK_RISK_RANK k,"
					+ "(SELECT T1.FD_ACC_ID FD_ACC_ID,COUNT(T1.FD_ACC_ID) COUN FROM T_PL_TASK_RULE_TRIG T1 GROUP BY FD_ACC_ID ) x "
					+ "WHERE T.FD_ACC_ID=L.LOANACNO(+)  "
					+ "AND T.FD_ACC_ID=X.FD_ACC_ID(+) and T.FD_ACC_ID=k.FD_ACC_ID(+)");
		StringBuffer sql = new StringBuffer("SELECT * FROM(select "
				+ "T.FD_RULE_RANK as   warnSignal,"
				+ "T.FD_RULE_CODE   as  ruleCode,"
				+ "T.FD_RULE_ID   as  ruleID,"
				+ "T.FD_RULE_NAME as  ruleDesc,"
				+ "L.OPERNAME  as operator,"
				+ "K.FD_RANK_FINAL    as  warningLevel,"
				+ "L.LOANACNO     as  lounAcc,"
				+ "L.CUSTNAME     as  custName,"
				+ "L.PRODNAME     as  productName,"
				+ "L.TCAPI        as  loanAmt,"
				+ "L.BAL          as  loanBalance,"
				+ "L.BANKNAME     as  BANKNAME,"
				+ "T.FD_PROCESS_DATE as changeDate, "
				+ "T.FD_PROCESS_DATE  as  warnDate,"
				+ "rank() over(partition by L.LOANACNO ORDER BY T.FD_PROCESS_DATE DESC)  AS NU,"
				+ "CASE WHEN L.BEGINDATE=current date THEN '是' ELSE '否' END AS isNewcust"
				+ " FROM T_PL_TASK_RULE_TRIG T,"
				+ "T_EDW_PLS_ACCOUNT_V L,T_PL_TASK_RISK_RANK k"
				+ " "
				+ "WHERE T.FD_ACC_ID=L.LOANACNO(+)  "
				+ " and T.FD_ACC_ID=k.FD_ACC_ID(+)");
//		hq2.append(" and t.TLRNO = '"+userId+"'");
//		Integer roleId=0;
		if(StringUtils.hasText(flag)){
			if(flag.equals("list")){
				hql = new StringBuffer("select "
						+ "T.FD_RULE_RANK as   warnSignal,"
						+ "T.FD_RULE_CODE   as  ruleCode,"
						+ "T.FD_RULE_ID   as  ruleID,"
						+ "T.FD_RULE_NAME as  ruleDesc,"
						+ "L.OPERNAME  as operator,"
						+ "K.FD_RANK_FINAL    as  warningLevel,"
						+ "L.LOANACNO     as  lounAcc,"
						+ "L.CUSTNAME     as  custName,"
						+ "L.PRODNAME     as  productName,"
						+ "L.TCAPI        as  loanAmt,"
						+ "L.BAL          as  loanBalance,"
						+ "L.BANKNAME     as  BANKNAME,"
						+ "T.FD_PROCESS_DATE as changeDate, "
						+ "T.FD_PROCESS_DATE  as  warnDate,"
						+ "rank() over(partition by L.LOANACNO ORDER BY T.FD_PROCESS_DATE DESC)  AS NU,"
						+ "CASE WHEN L.BEGINDATE=current date THEN '是' ELSE '否' END AS isNewcust"
						+ " FROM T_PL_TASK_RULE_TRIG T,"
						+ "T_EDW_PLS_ACCOUNT_V L,T_PL_TASK_RISK_RANK k "
						+ " "
						+ "WHERE T.FD_ACC_ID=L.LOANACNO(+)  "
						+ " and T.FD_ACC_ID=k.FD_ACC_ID(+)");
			}
		}
		String operator=null;
		String bankName=null;
//		Iterator it =rootdao.queryBySQL(hq2.toString());
		
		//获得岗位代码
//		boolean flag=false;
//		while(it.hasNext()){
//			roleId=(Integer)it.next();
		if(StringUtils.hasText(roleId)){
			if(roleId.equals("222")){
				operator=userId;
				if(StringUtils.hasText(operator)){
					if(StringUtils.hasText(flag)){
						if(flag.equals("desk")){
							sql.append(" AND L.DUTYID  = '"+operator+"'");
							sql.append(" AND L.bankid  = '"+brcode+"'");
							sql.append(" )A WHERE NU=1");
						}
					}else{
						hql.append(" AND L.DUTYID  = '"+operator+"'");
						hql.append(" AND L.bankid  = '"+brcode+"'");
					}
				}
			}else if(roleId.equals("557")||roleId.equals("558")||roleId.equals("111")||roleId.equals("615")||roleId.equals("614"))
			{
				bankName = (String) getCommQueryServletRequest().getParameterMap().get("bankName");
//				flag=true;
				if(StringUtils.hasText(flag)){
					if(flag.equals("desk")){
						sql.append(" )A WHERE NU=1");
					}
				}
			}else if(StringUtils.hasText(brcode)){
				BctlService bctlService = BctlService.getInstance();
				String brcodes=bctlService.getAllSubListStr(brcode);
				TPlTaskService tts=TPlTaskService.getInstance();
				String userIds=tts.getUserIdsByBrcodes(brcodes)	;
				if(StringUtils.hasText(flag)){
					if(flag.equals("desk")){
						sql.append(" AND L.DUTYID IN ("+userIds+")");
						sql.append(" AND l.BANKID IN ("+brcodes+")");
						sql.append(" )A WHERE NU=1");
					}
				}else{
					hql.append(" AND L.DUTYID IN ("+userIds+")");
					hql.append(" AND l.BANKID IN ("+brcodes+")");
				}
			}else{
				hql=new StringBuffer("select * from T_PL_TASK_RISK_RANK where 1=0");
			}
		}else{
			hql.append(" and 1=0 ");
			sql.append(" and 1=0 )");
		}

		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		

		if(StringUtils.hasText(customerNum)){
			hql.append(" and L.CUSTID like '%"+customerNum+"%'");
		}
		if(StringUtils.hasText(bankName)){
			hql.append(" and L.BANKNAME like '%"+bankName+"%'");
		}
		if(StringUtils.hasText(productName)){
			hql.append(" and L.PRODNAME  like '%"+productName+"%'");
		}
		if(StringUtils.hasText(lounAcc)){
			hql.append(" and L.LOANACNO like '%"+lounAcc+"%'");
		}
		if(StringUtils.hasText(custName)){
			hql.append(" and  L.CUSTNAME like '%"+custName+"%'");
		}
		if(StringUtils.hasText(loanAmt)){
			hql.append(" and L.TCAPI = '"+loanAmt+"'");
		}
		if(StringUtils.hasText(loanBalance)){
			hql.append(" and  L.BAL = '"+loanBalance+"'");
		}
		if(StringUtils.hasText(warnDate)){
			hql.append(" and T.FD_PROCESS_DATE >= to_date('"+warnDate+"','yyyy-mm-dd')");
		}
		if(StringUtils.hasText(lastwarnDate)){
			hql.append(" and T.FD_PROCESS_DATE <= to_date('"+lastwarnDate+"','yyyy-mm-dd')");
		}
		if(StringUtils.hasText(ruleDesc)){
			hql.append(" and T.FD_RULE_CODE like  '%"+ruleDesc+"'");
		}
		if(StringUtils.hasText(changeDate)){
			
			hql.append(" and T.FD_PROCESS_DATE = to_date('"+changeDate+"','yyyy-mm-dd')");
		}
		if(StringUtils.hasText(warnSignal)){
			hql.append(" and T.FD_RULE_RANK = '"+warnSignal+"'");
		}
		if(StringUtils.hasText(ruleID)){
			hql.append(" and T.FD_RULE_ID like '%"+ruleID+"%'");
		}
		if(StringUtils.hasText(isNewcust)){
			hql.append(" and isNewcust = '"+isNewcust+"'");
		}
		if(StringUtils.hasText(ruleID)){
			hql.append(" and l.BANKID like '%"+ruleID+"%'");
		}
		if(StringUtils.hasText(warningLevel)){
			hql.append(" and K.FD_RANK_FINAL like '"+warningLevel+"'");
		}
		hql.append(" order by T.FD_PROCESS_DATE desc");
		sql.append(" order by changeDate desc");
//		List<TCustomer> list = rootdao.pageQueryByHql(hql.toString(), pageIndex, pageSize);
//		pageQueryResult.setTotalCount(list.size());
//		pageQueryResult.setQueryResult(list);
		
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over() as rnum from ( ");
		if(StringUtils.hasText(flag)){
			if(flag.equals("desk")){
				sqlp.append(sql);
			}else{
				sqlp.append(hql);
			}
		}else{
			sqlp.append(hql);
		}
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		if(StringUtils.hasText(flag)){
			if(flag.equals("desk")){
				sqll.append(sql);
			}else{
				sqll.append(hql);
			}
		}else{
			sqll.append(hql);
		}
		sqll.append(" )");
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		List<RiskruleList> listT=jdbcTemplate.query(sqlp.toString(), BeanPropertyRowMapper.newInstance(RiskruleList.class));
		
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult.setQueryResult(listT);
		pageQueryResult.setTotalCount(totalCount);
//		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString());
        

		return pageQueryResult;
	}

}
