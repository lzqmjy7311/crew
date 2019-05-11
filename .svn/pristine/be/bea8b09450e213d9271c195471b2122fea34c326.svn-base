package com.gbicc.person.monitor.getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.company.financial.analysis.entity.YjCustInfoV;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlYjMonitor;
import com.gbicc.person.monitor.entity.TPlYjReport;
import com.gbicc.person.monitor.operation.TPlYjMonitorOperation;
import com.gbicc.person.monitor.operation.TPlYjReportOperation;
import com.gbicc.person.monitor.service.TPlYjMonitorService;
import com.gbicc.warn.entity.TWarnSignal;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author likm
 * @time   2015年11月4日09:28:15
 * @desc   定期监控报告查询
 */
@SuppressWarnings("unchecked")
public class TPlYjReportByIdGetter extends BaseGetter {

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
		String businessId = (String) getCommQueryServletRequest().getParameterMap().get("businessId");
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult1 = new PageQueryResult();

		StringBuffer yzHql=new StringBuffer("select count(businessId) from TPlReportRelation where businessId='"+businessId+"'");
		
		String sql=null;
		String loanAcct="";

		int isFirst=rootdao.queryByHqlToCount(yzHql.toString());
		if(isFirst<1){
			
			 Date nowDate =new Date();
			 
			 //预警处置  任务service 
			 TPlYjMonitor yjMonitor=new TPlYjMonitor();
			 TPlYjMonitorService tPlYjMonitorService=TPlYjMonitorService.getInstance();
			 yjMonitor= tPlYjMonitorService.get(businessId);
			 loanAcct=yjMonitor.getLoanAcct();//客户账号
//			 sql=" SELECT                                             "
//						+" 	V.LOANACNO AS loanacno,                           "
//						+" 	V.CUSTID AS custid,                               "
//						+" 	 V.CUSTNAME AS custname,                          "
//						+" 	V.WAYKIND AS waykind,                             "
//						+" 	V.PRODNAME AS prodname,                           "
//						+" 	V.TCAPI AS tcapi,                                 "
//						+" 	V.UNPAID_COUNT AS unpaidCount,                    "
//						+" 	V.ASSUKIND AS assukind,                           "
//						+" 	V.FLOATINTERATE AS floatinterate,                 "
//						+" 	V.ACFLAG AS acflag,                               "
//						+" 	V.RISKFLAG AS riskflag                            "						+" from  YJ_CUST_INFO_V  V "
//						+ " WHERE V.LOANACNO='"+loanAcct+"'        ";
//			 
//			 JdbcTemplate  jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
//			 List<YjCustInfoV> listT=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(YjCustInfoV.class));
//			 YjCustInfoV custInfoV=new YjCustInfoV();
			 
			
				
			 TPlYjReport  tPlYjReport=new TPlYjReport();
			 if(yjMonitor!=null){
//				 custInfoV=listT.get(0);
				 tPlYjReport.setFdLoanAccount(yjMonitor.getLoanAcct());//账户号
				 tPlYjReport.setFdCustCode(yjMonitor.getCustCode());//客户编号
				 tPlYjReport.setFdCustName(yjMonitor.getCustName());//客户名称
				 tPlYjReport.setFdIndustry(yjMonitor.getWaykind());//所属行业
				 tPlYjReport.setFdProductCode(yjMonitor.getLoanVariety());//产品名称
				 tPlYjReport.setFdLoanAmt(yjMonitor.getLoanAmt());//贷款金额
				 tPlYjReport.setFdLoanBalance(yjMonitor.getLoanBalance());//贷款余额 
				 tPlYjReport.setFdGuarWay(yjMonitor.getAssukind());//担保方式
				 tPlYjReport.setFdSlidingScales(yjMonitor.getFloatinterate());//浮动比例
				 tPlYjReport.setFdAcctStatus(yjMonitor.getAcflag());//账户状态
				 tPlYjReport.setFdRiskClass(yjMonitor.getRiskflag());//风险分类
				 tPlYjReport.setFdOperator(yjMonitor.getHandler().getTlrno());//经办人
				 tPlYjReport.setFdOperBank(yjMonitor.getHandler().getBrcode());//经办行
			 }
			 
			 //20160823更改，将当前经办人赋给主调查人和福主调查人，如果当前经办人为空，则取当前登录用户（防止为null系统报错）
			 if(yjMonitor.getHandler()!=null){
				 tPlYjReport.setFdLeadInvestigator(yjMonitor.getHandler().getTlrName());//主调查人 
				 tPlYjReport.setFdAssInvestigator(yjMonitor.getHandler().getTlrName());//辅助调查人
			 }else{
				 GlobalInfo info=GlobalInfo.getCurrentInstance();
				 TlrInfo tlr= TlrInfoService.getInstance().getTlrInfoByTlrno(info.getTlrno());
				 tPlYjReport.setFdAssInvestigator(tlr.getTlrName());//辅助调查人
			 }			 
			 tPlYjReport.setFdSurveyDate(nowDate);//调查时间
			 
			 
			//设置预警信号 集合
			   List<TWarnSignal> warnSignals=new ArrayList<TWarnSignal>();
			  
			   TWarnSignal warnSignal=new TWarnSignal();
			   warnSignal.setWarnLEvel(yjMonitor.getWarnLevel());
			   warnSignal.setAffPerDesc(yjMonitor.getRuleDesc());//预警名称 -规则描述
			   warnSignal.setRuleId(yjMonitor.getRuleId());
			   warnSignal.setWarnCode(yjMonitor.getRuleName());//预警信号  -规则名称
			   warnSignal.setLoanAccount(yjMonitor.getLoanAcct());
			   warnSignals.add(warnSignal);
			  
			  
			 
			 OperationContext oc = new OperationContext();
			 oc.setAttribute(TPlYjReportOperation.CMD,TPlYjMonitorOperation.CMD_INSERT);
			 oc.setAttribute(TPlYjReportOperation.IN_PARAM,tPlYjReport);
			 oc.setAttribute(TPlYjReportOperation.BUSINESS_ID,businessId);
			 
			 oc.setAttribute(TPlYjReportOperation.WARNING_SIGNALS, warnSignals);
			 OPCaller.call(TPlYjReportOperation.ID, oc);
			 
			 
			
		}
		StringBuffer hql = new StringBuffer("from TPlYjReport t where 1=1 and id=(select reportId from TPlReportRelation where businessId='"+businessId+"') ");
		PageQueryResult pageQueryResult = new PageQueryResult();
		if(StringUtils.isNotEmpty(businessId)){
			pageQueryResult = rootdao.pageQueryByHql(pageIndex,pageSize,hql.toString());
		}
		return pageQueryResult;
	}
}
