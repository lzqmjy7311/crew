package com.gbicc.company.single.getter;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

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

public class TCmSingleRulInvestigationQueryGetter extends BaseGetter {

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
		String inveFeedDtStart = (String) getCommQueryServletRequest().getParameterMap().get("inveFeedDtStart");
		String inveFeedDtEnd = (String) getCommQueryServletRequest().getParameterMap().get("inveFeedDtEnd");
		String inveCode = (String) getCommQueryServletRequest().getParameterMap().get("inveCode");
		String inveName = (String) getCommQueryServletRequest().getParameterMap().get("inveName");
		String inveOrg = (String) getCommQueryServletRequest().getParameterMap().get("inveOrg");
		String inveUserId = (String) getCommQueryServletRequest().getParameterMap().get("inveUserId");
		String inveUserName = (String) getCommQueryServletRequest().getParameterMap().get("inveUserName");
		String status = (String) getCommQueryServletRequest().getParameterMap().get("status");
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
		StringBuffer hql = new StringBuffer("from TCmSingleRulInvestigation t where 1=1 and status not in ('1') ");
		if(brclass.equals("2")){//一级支行查看本行及辖属二级支行数据
			hql.append(" and (inveOrg.brcode='"+brcode+"' or inveOrg.brcode in (select brcode from Bctl where blnUpBrcode='"+brcode+"')) ");
		}else if(brclass.equals("3")){//二级支行只能查看本行数据
			hql.append(" and inveOrg.brcode='"+brcode+"' ");
		}
		if(StringUtils.isNotEmpty(inveFeedDtStart)){
			hql.append(" and to_char(inveFeedDt,'yyyyMMdd')>='"+inveFeedDtStart+"' ");
		}
		if(StringUtils.isNotEmpty(inveFeedDtEnd)){
			hql.append(" and to_char(inveFeedDt,'yyyyMMdd')<'"+inveFeedDtEnd+"' ");
		}
		if(StringUtils.isNotEmpty(inveCode)){
			hql.append(" and inveCode like '%"+inveCode+"%' ");
		}
		if(StringUtils.isNotEmpty(inveName)){
			hql.append(" and inveName like '%"+inveName+"%' ");
		}
		if(StringUtils.isNotEmpty(inveOrg)){
			hql.append(" and inveOrg.brcode = '"+inveOrg+"' ");
		}
		if(StringUtils.isNotEmpty(inveUserId)){
			hql.append(" and t.inveUser.tlrno = '"+inveUserId+"' ");
		}
		if(StringUtils.isNotEmpty(inveUserName)){
			hql.append(" and t.inveUser.tlrName like '%"+inveUserName+"%' ");
		}
		if(StringUtils.isNotEmpty(status)){
			hql.append(" and status='"+status+"' ");
		}
		String orderby=" order by t.createDt desc ";
		if(StringUtils.isNotEmpty(order) && StringUtils.isNotEmpty(sortField)){
			if(sortField.equals("inveOrgName"))
				orderby=" order by  inveOrg.brname "+order;
			else if(sortField.equals("inveUserId"))
				orderby=" order by  inveUser.tlrno "+order;
			else
				orderby=" order by t."+sortField+" "+order;
		}
		hql.append(orderby);
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		//pageQueryResult.setQueryResult(rootdao.queryByCondition(hql.toString()));
		return pageQueryResult;
	}
}
