package com.gbicc.person.eliminate.getter;

import java.util.List;

import org.springframework.util.StringUtils;

import com.gbicc.bpm.entity.TLoanAccountRelDuty;
import com.gbicc.bpm.service.TLoanAccountRelDutyService;
import com.gbicc.personCommon.entity.TEdwPlsAccount;
import com.gbicc.personCommon.entity.TEdwPlsCust;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TPlTriggerRuleAcctGetter extends BaseGetter {

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

	@SuppressWarnings("rawtypes")
	protected PageQueryResult getData() throws Exception {
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String loanacno = (String) getCommQueryServletRequest().getParameterMap().get("loanacno");
		String custname = (String) getCommQueryServletRequest().getParameterMap().get("custname");
		String prodname = (String) getCommQueryServletRequest().getParameterMap().get("prodname");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TEdwPlsAccount t where 1=1 and loanacno in (select distinct accId from TPlTaskRuleTrig) ");
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(loanacno)){
			hql.append(" and loanacno = '"+loanacno+"'");
		}
		if(StringUtils.hasText(custname)){
			hql.append(" and custname like '%"+custname+"%'");
		}
		if(StringUtils.hasText(prodname)){
			hql.append(" and prodname like '%"+prodname+"%' ");
		}
		String userBorno=BctlService.getInstance().findChildOrgs(GlobalInfo.getCurrentInstance().getBrno());
		hql.append(" and bankid in ("+userBorno+") ");
		
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		List list=pageQueryResult.getQueryResult();
		for(int i=0;i<list.size();i++){
			TEdwPlsAccount account=(TEdwPlsAccount) list.get(i);
			TLoanAccountRelDuty duty=TLoanAccountRelDutyService.getInstance().get(account.getLoanacno());
			if(null!=duty){
				if(StringUtils.hasText(duty.getDutyid())){
					TlrInfo tlr=TlrInfoService.getInstance().getTlrInfoByTlrno(duty.getDutyid());
					account.setDutyInfo(tlr.getBrcode()+","+tlr.getTlrName()+","+tlr.getTlrno());
				}else{
					TlrInfo tlr=TlrInfoService.getInstance().getTlrInfoByTlrno(account.getDutyid());
					account.setDutyInfo(tlr.getBrcode()+","+tlr.getTlrName()+","+tlr.getTlrno());
				}
				if(StringUtils.hasText(duty.getCollid())){
					TlrInfo collTlr=TlrInfoService.getInstance().getTlrInfoByTlrno(duty.getCollid());
					account.setCollInfo(collTlr.getBrcode()+","+collTlr.getTlrName()+","+collTlr.getTlrno());
				}else{
					TlrInfo collTlr=TlrInfoService.getInstance().getTlrInfoByTlrno(account.getDutyid2());
					account.setCollInfo(collTlr.getBrcode()+","+collTlr.getTlrName()+","+collTlr.getTlrno());
				}
			}else{
				TlrInfo tlr=TlrInfoService.getInstance().getTlrInfoByTlrno(account.getDutyid());
				if(tlr!=null){
					account.setDutyInfo(tlr.getBrcode()+","+tlr.getTlrName()+","+tlr.getTlrno());
				}
				TlrInfo collTlr=TlrInfoService.getInstance().getTlrInfoByTlrno(account.getDutyid2());
				if(collTlr!=null){
					account.setCollInfo(collTlr.getBrcode()+","+collTlr.getTlrName()+","+collTlr.getTlrno());
				}
			}
			TEdwPlsCust cust=rootdao.query(TEdwPlsCust.class,account.getCustid());
			if(null!=cust){
				account.setCustname(cust.getCustname());
			}
		}
		return pageQueryResult;
	}
}
