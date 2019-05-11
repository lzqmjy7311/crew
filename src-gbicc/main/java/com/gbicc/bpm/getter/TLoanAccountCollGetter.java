package com.gbicc.bpm.getter;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.bpm.SpringContextHolder;
import com.gbicc.personCommon.entity.TEdwPlsAccount;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TLoanAccountCollGetter extends BaseGetter {

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
		//String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String loanacno = (String) getCommQueryServletRequest().getParameterMap().get("loanacno");
		String custname = (String) getCommQueryServletRequest().getParameterMap().get("custname");
		String prodname = (String) getCommQueryServletRequest().getParameterMap().get("prodname");
		String bank = (String) getCommQueryServletRequest().getParameterMap().get("bank");
		String acflag = (String) getCommQueryServletRequest().getParameterMap().get("acflag");
		String acflag2 = (String) getCommQueryServletRequest().getParameterMap().get("acflag2");
		String riskflag = (String) getCommQueryServletRequest().getParameterMap().get("riskflag");
		String dutyid = (String) getCommQueryServletRequest().getParameterMap().get("dutyid");
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String brcode=info.getBrcode();
		Bctl bctl=BctlService.getInstance().getBctlByBrcode(brcode);
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		
		StringBuffer hql=new StringBuffer("");
		hql.append("select a.*,"+
		" case when duty.FD_DUTYID is not null and tlr.TLR_NAME is not null then tlr.TLR_NAME||','||duty.fd_dutyid "+
		" when a.DUTYID is not null and tlr2.TLR_NAME is not null then tlr2.TLR_NAME||','||a.dutyid "+
		" else a.DUTYID end as dutyInfo, "+
		" case when duty.fd_collid is not null and tlr3.TLR_NAME is not null then tlr3.TLR_NAME||','||duty.fd_collid "+
		" when a.DUTYID2 is not null and tlr4.TLR_NAME is not null then tlr4.TLR_NAME||','||a.dutyid2 "+
		" else a.DUTYID2 end as collInfo "+
		" from t_edw_pls_account a left join T_PL_ACCOUNT_REL_DUTY duty on a.LOANACNO=duty.FD_LOANACNO "+
		" left join tlr_info tlr on duty.FD_DUTYID=tlr.TLRNO "+
		" left join tlr_info tlr2 on a.DUTYID=tlr2.tlrno "+
		" left join tlr_info tlr3 on duty.FD_COLLID=tlr3.tlrno "+
		" left join tlr_info tlr4 on a.DUTYID2=tlr4.tlrno "+
		" where a.payoffflag='00' and a.prodid not in ('93010200','96010200','96010100','93010100')");
		if(StringUtils.hasText(loanacno)){
			hql.append(" and a.loanacno = '"+loanacno+"'");
		}
		if(StringUtils.hasText(custname)){
			hql.append(" and a.custname like '%"+custname+"%'");
		}
		if(StringUtils.hasText(prodname)){
			hql.append(" and a.prodname like '%"+prodname+"%' ");
		}
		if(StringUtils.hasText(bank)){
			hql.append(" and a.bankid='"+bank+"' ");
		}else{
			if(!(bctl.getBrclass().equals("1"))){
				hql.append(" and (a.bankid='"+brcode+"' or a.bankid in (select brcode from bctl where bln_up_brcode='"+brcode+"')) ");
			}
		}
		if(StringUtils.hasText(acflag)){
			hql.append(" and a.acflag='"+acflag+"' ");
		}
		if(StringUtils.hasText(acflag2)){
			hql.append(" and a.acflag2='"+acflag2+"' ");
		}
		if(StringUtils.hasText(riskflag)){
			hql.append(" and a.riskflag='"+riskflag+"' ");
		}
		if(StringUtils.hasText(dutyid)){
			hql.append(" and (case when duty.FD_COLLID is not null then duty.FD_COLLID else a.DUTYID2 end )='"+dutyid+"' ");
		}
		
		String orderby="order by LOANACNO asc ";
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(hql.toString());
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		
		
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<TEdwPlsAccount> rList=jdbcTemplate.query(sqlp.toString(),BeanPropertyRowMapper.newInstance(TEdwPlsAccount.class));
		//构造数据量
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(hql.toString());
		sqll.append(" )");
		//set
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		PageQueryResult result = new PageQueryResult();
		result.setQueryResult(rList);
		result.setTotalCount(totalCount);
		return result;
	}
}
