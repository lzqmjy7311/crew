package com.gbicc.company.single.getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.company.single.entity.TCmSingleRulCases;
import com.gbicc.company.single.operation.TCmSingleRulInvestigationOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TCmSingleRulCasesQueryGetter extends BaseGetter {

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
		String createDtStart = (String) getCommQueryServletRequest().getParameterMap().get("createDtStart");
		String createDtEnd = (String) getCommQueryServletRequest().getParameterMap().get("createDtEnd");
		String casesCode = (String) getCommQueryServletRequest().getParameterMap().get("casesCode");
		String casesName = (String) getCommQueryServletRequest().getParameterMap().get("casesName");
		String createUserId = (String) getCommQueryServletRequest().getParameterMap().get("createUserId");
		String createUserName = (String) getCommQueryServletRequest().getParameterMap().get("createUserName");
		String casesStatus = (String) getCommQueryServletRequest().getParameterMap().get("casesStatus");
		String casesNature=(String)getCommQueryServletRequest().getParameterMap().get("casesNature");
		String order = (String) getCommQueryServletRequest().getParameterMap().get("order");
		String sortField = (String) getCommQueryServletRequest().getParameterMap().get("sortField");

		/*start---2016年7月15日由于框架使用远程排序时，页面点击翻页按钮再次请求数据order与sortField会变成null，故存放到req的session中  */
		HttpSession session = httpReq.getSession();
		if(StringUtils.isNotEmpty(order) && StringUtils.isNotEmpty(sortField)){
			session.setAttribute(this.getClass().getName()+"order",order);
			session.setAttribute(this.getClass().getName()+"sortField",sortField);
		}else{
			order=(String) session.getAttribute(this.getClass().getName()+"order");
			sortField=(String) session.getAttribute(this.getClass().getName()+"sortField");
		}
		/*end---2016年7月15日由于框架使用远程排序时，页面点击翻页按钮再次请求数据order与sortField会变成null，故存放到req的session中  */
		
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String brcode=info.getBrcode();
		String brclass=info.getBrClass();
		StringBuffer hql = new StringBuffer("from TCmSingleRulCases t where 1=1 and casesStatus not in('1') ");
		if(brclass.equals("2")){//一级支行查看本行及辖属二级支行数据
			hql.append(" and (createOrg.brcode='"+brcode+"' or createOrg.brcode in (select brcode from Bctl where blnUpBrcode='"+brcode+"')) ");
		}else if(brclass.equals("3")){//二级支行只能查看本行数据
			hql.append(" and createOrg.brcode='"+brcode+"' ");
		}
		if(StringUtils.isNotEmpty(createDtStart)){
			hql.append(" and to_char(createDt,'yyyyMMdd')>='"+createDtStart+"' ");
		}
		if(StringUtils.isNotEmpty(createDtEnd)){
			hql.append(" and to_char(createDt,'yyyyMMdd')<'"+createDtEnd+"' ");
		}
		if(StringUtils.isNotEmpty(casesCode)){
			hql.append(" and casesCode like '%"+casesCode+"%' ");
		}
		if(StringUtils.isNotEmpty(casesName)){
			hql.append(" and casesName like '%"+casesName+"%' ");
		}
		if(StringUtils.isNotEmpty(casesNature)){
			hql.append(" and casesNature like '%"+casesNature+"%' ");
		}
		if(StringUtils.isNotEmpty(createUserId)){
			hql.append(" and createUser.tlrno = '"+createUserId+"' ");
		}
		if(StringUtils.isNotEmpty(createUserName)){
			hql.append(" and t.createUser.tlrName like '%"+createUserName+"%' ");
		}
		if(StringUtils.isNotEmpty(casesStatus)){
			hql.append(" and casesStatus='"+casesStatus+"' ");
		}
		
		String orderby=" order by createDt desc ";
		
		if(StringUtils.isNotEmpty(order) && StringUtils.isNotEmpty(sortField)){
			if(sortField.equals("casesCode")||sortField.equals("casesName")||sortField.equals("casesStatus")||sortField.equals("createUser")||sortField.equals("casesNature"))
				orderby=" order by "+sortField+" "+order;
			if(sortField.equals("createUserId"))
				orderby=" order by createUser.tlrno "+order;
		}
		hql.append(orderby);
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		
		//pageQueryResult.setQueryResult(rootdao.queryByCondition(hql.toString()));
		List list=pageQueryResult.getQueryResult();
		for(int i=0;i<list.size();i++){
			TCmSingleRulCases cases=(TCmSingleRulCases) list.get(i);
			Map<String, Integer> map=geNumb(cases.getId());
			cases.setWarnCount(map.get("warnCount"));
			cases.setInveCount(map.get("inveCount"));
			cases.setAlreInveCount(map.get("alreInveCount"));
		}
		return pageQueryResult;
	}
	
	public Map<String, Integer> geNumb(String casesId) throws Exception{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String warnNumSql="select count(id) from TCmSingleRulWarning where casesId='"+casesId+"' ";
		Object obj=rootdao.queryByHqlToCount(warnNumSql);
		String inveNumSql="select count(id) from TCmSingleRulInvestigation where casesId='"+casesId+"' ";
		Object obj2=rootdao.queryByHqlToCount(inveNumSql);
		String compInveNumSql="select count(id) from TCmSingleRulInvestigation where casesId='"+casesId+"' and status='"+TCmSingleRulInvestigationOperation.STATUS_ALREADY_INVE+"' ";
		Object obj3=rootdao.queryByHqlToCount(compInveNumSql);
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("warnCount",Integer.valueOf(obj.toString()));
		map.put("inveCount",Integer.valueOf(obj2.toString()));
		map.put("alreInveCount",Integer.valueOf(obj3.toString()));
		return map;
	}
}
