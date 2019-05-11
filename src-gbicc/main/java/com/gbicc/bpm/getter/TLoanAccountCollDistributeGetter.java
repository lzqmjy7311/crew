package com.gbicc.bpm.getter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.entity.TLoanAccountDutyDistribute;
import com.gbicc.bpm.entity.TLoanAccountRelDistribute;
import com.gbicc.bpm.operation.TLoanAccountDutyDistributeOperation;
import com.gbicc.personCommon.entity.TEdwPlsAccount;
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
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TLoanAccountCollDistributeGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(), pageResult.getQueryResult(),getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	protected PageQueryResult getData() throws Exception {
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		//ProcessManagerService managerService=ProcessManagerService.getInstace();
		//String str=managerService.findBusinessKey(userId);
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TLoanAccountDutyDistribute t where 1=1 and distType='"+TLoanAccountDutyDistributeOperation.DIST_TYPE_COLL+"' ");
		if(StringUtils.isNotEmpty(userId)){
			hql.append(" and (aplUser='"+userId+"' or operUser.tlrno='"+userId+"') ");
		}else{
			hql.append(" and 1=2 ");
		}
		String orgs=BctlService.getInstance().findParentOrgIDsTree(info.getBrno());
		hql.append(" and operOrg.brno in ("+orgs+")");
		
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		List list=pageQueryResult.getQueryResult();
		for(int i=0;i<list.size();i++){
			TLoanAccountDutyDistribute distribute=(TLoanAccountDutyDistribute) list.get(i);
			TlrInfo tlr=TlrInfoService.getInstance().getTlrInfoByTlrno(distribute.getCheckUser());
			
			if(distribute.getDistFlag().equals(TLoanAccountDutyDistributeOperation.DIST_FLAG_MUCH)){
				//String names=ProcessManagerService.getInstace().findOrgInfoByUserIds(distribute.getCheckUser());
				//distribute.setCheckUserDesc(names);
				getLoanacnos(distribute);
			}else{
				distribute.setCheckUserDesc(tlr.getBrcode()+","+tlr.getTlrName()+","+tlr.getTlrno());
			}
		}
		return pageQueryResult;
	}
	
	@SuppressWarnings("rawtypes")
	public void getLoanacnos(TLoanAccountDutyDistribute distribute) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List relDistList=rootdao.queryByCondition("from TLoanAccountRelDistribute where distId='"+distribute.getId()+"' ");
		String loanacnos="";
		for(int j=0;j<relDistList.size();j++){
			TLoanAccountRelDistribute relDist= (TLoanAccountRelDistribute) relDistList.get(j);
			loanacnos=loanacnos+relDist.getLoanacno()+",";
		}
		if(StringUtils.isNotEmpty(loanacnos)){
			loanacnos=loanacnos.substring(0,loanacnos.length()-1);
		}
		if(null!=relDistList && relDistList.size()>0){
			TLoanAccountRelDistribute relDist= (TLoanAccountRelDistribute) relDistList.get(0);
			distribute.setLoanacnos(loanacnos);
			List list=rootdao.queryByCondition("from TEdwPlsAccount where loanacno='"+relDist.getLoanacno()+"' ");
			TEdwPlsAccount act=(TEdwPlsAccount) list.get(0);
			distribute.setOrgId(act.getBankid());
		}
	}
}
