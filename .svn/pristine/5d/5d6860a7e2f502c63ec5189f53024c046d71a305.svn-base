package com.gbicc.person.great.getter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.common.CommonService;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.gbicc.personCommon.entity.TEdwPlsCust;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TEdwPlsCustGetter extends BaseGetter {

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

	@SuppressWarnings("unchecked")
	protected PageQueryResult getData() throws Exception {
		String custid = (String) getCommQueryServletRequest().getParameterMap().get("custid");
		String custname = (String) getCommQueryServletRequest().getParameterMap().get("custname");
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		String legSql="select distinct c.* from t_edw_pls_cust c left join T_EDW_PLS_ACCOUNT a "+
		" on c.CUSTID=a.CUSTID left join T_PL_ACCOUNT_REL_DUTY d on a.LOANACNO=d.FD_LOANACNO "+
		" where ";
//		" where '"+userId+"'=case when d.FD_DUTYID is null then a.DUTYID else d.FD_DUTYID end ";
		
		//一级支行管理岗手动发起预警信号所需查询的客户
		if(!"222".equals(info.getWorkflowRoleId())){
			BctlService bctlService = BctlService.getInstance();
			String brcodes=bctlService.getAllSubListStr(info.getBrcode());
			
			if(org.springframework.util.StringUtils.hasText(brcodes)){
				legSql+=" a.BANKID in ("+brcodes+") ";
			}
		}else{
			legSql+=" '"+userId+"'=case when d.FD_DUTYID is null then a.DUTYID else d.FD_DUTYID end ";
		}
		
		if(StringUtils.isNotEmpty(custid)){
			legSql+=" and c.custid='"+custid+"' ";
		}
		if(StringUtils.isNotEmpty(custname)){
			legSql+=" and c.custname like '%"+custname+"%' ";
		}
		String orderby=" order by custname asc ";
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(legSql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		
		List<TEdwPlsCust> resultList=CommonService.getInstance()
					.findSqlListBySpringJdbc(sqlp.toString(),TEdwPlsCust.class);
		//构造数据量
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(legSql);
		sqll.append(" )");
		//set
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		
		PageQueryResult result = new PageQueryResult();
		result.setQueryResult(resultList);
		result.setTotalCount(totalCount);
		return result;
	}
}
