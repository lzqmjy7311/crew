package com.gbicc.company.view.accountpage.getter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.common.CQMethod;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.flowswitch.micro.model.channel.StringFormat;

@SuppressWarnings("unchecked")
public class ZtxMmfxyGetter extends BaseGetter {

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
		String txnDt = (String) getCommQueryServletRequest().getParameterMap().get("txnDt");
		String coreCustomerNum = (String) getCommQueryServletRequest().getParameterMap().get("coreCustomerNum");
		String acctId = (String) getCommQueryServletRequest().getParameterMap().get("acctId");
		String endbussdate = (String) getCommQueryServletRequest().getParameterMap().get("endbussdate");
		String roleId = (String) getCommQueryServletRequest().getParameterMap().get("roleId");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Date dateflag=new Date();
//		GlobalInfo info=GlobalInfo.getCurrentInstance();          //GlobalInfo  用户类
//		String userId=info.getTlrno();
//		
//		StringBuffer hq2 = new StringBuffer("select  ROLE_ID from TLR_ROLE_REL  t where 1=1 ");
//		hq2.append(" and t.TLRNO = '"+userId+"'");
//		Integer roleId=0;
//
//		Iterator it =rootdao.queryBySQL(hq2.toString());
//		
//		//获得岗位代码
//		while(it.hasNext()){
//			roleId=(Integer)it.next();
//		}
		boolean flag=false;										//是否空查询标记：未传入账户BankAccount，返回空集
		//根据岗位代码进行查询日期限制--start
		if(roleId==null){
			roleId="";
			flag=false;
		}
		if(roleId.equals("601"))
		{
			Calendar calendar=Calendar.getInstance();
			
			calendar.setTime(dateflag);
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-12);
			dateflag=calendar.getTime();
			
		}else{
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(dateflag);
			calendar.add(Calendar.MONTH, -12);
			dateflag=calendar.getTime();
		}	
		//根据岗位代码进行查询日期限制--end
		StringBuffer hql = new StringBuffer("from TOdsEdwDepositAcctTxnDtlInfo t where 1=1 ");
		
		if(StringUtils.hasText(endbussdate)){
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			endbussdate=CQMethod.getDateString(endbussdate);
			if(StringUtils.hasText(txnDt)){
				Date dat1=sf.parse(txnDt);
				if(dat1.getTime()<dateflag.getTime()){
					txnDt=sf.format(dateflag);
				}
				txnDt=CQMethod.getDateString(txnDt);
				hql.append(" and txnDt between '"+txnDt+"' and '"+endbussdate+"'");
				
			}else{
				String strtemp=sf.format(dateflag);
				strtemp=CQMethod.getDateString(strtemp);
				hql.append(" and txnDt between '"+strtemp+"' and '"+endbussdate+"'");
			}
		}

		if(StringUtils.hasText(acctId)){
			hql.append(" and acctId = '"+acctId+"' order by txnDt asc,txnTm asc");
			flag=true;
		}else{
			flag=false;
		}
		if(flag==false){
			if(StringUtils.hasText(coreCustomerNum)){	
				hql.append(" and exists (SELECT 1 FROM TEdwCorePayAcc C WHERE C.membCustAc=ACCT_ID AND C.customerNo='"+coreCustomerNum+"') order by txnDt asc,txnTm asc");
			}else{
				hql=new StringBuffer("from TOdsEdwDepositAcctTxnDtlInfo t where 0=1");
			}
			
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		return pageQueryResult;
	}
}
