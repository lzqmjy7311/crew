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

public class TCmSingleRulWarningQueryGetter extends BaseGetter {

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
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String brcode=info.getBrcode();
		String brclass=info.getBrClass();
		String warnDtStart = (String) getCommQueryServletRequest().getParameterMap().get("warnDtStart");
		String warnDtEnd = (String) getCommQueryServletRequest().getParameterMap().get("warnDtEnd");
		String fcettypecode = (String) getCommQueryServletRequest().getParameterMap().get("fcettypecode");
		String fcetname = (String) getCommQueryServletRequest().getParameterMap().get("fcetname");
		String warnStatus = (String) getCommQueryServletRequest().getParameterMap().get("warnStatus");
		String rulCode = (String) getCommQueryServletRequest().getParameterMap().get("rulCode");
		String rulName = (String) getCommQueryServletRequest().getParameterMap().get("rulName");
		String mainOrg = (String) getCommQueryServletRequest().getParameterMap().get("mainOrg");
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String taskCode=(String) getCommQueryServletRequest().getParameterMap().get("taskCode");
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
		StringBuffer hql = new StringBuffer("from TCmSingleRulWarning t where 1=1 ");
		if(brclass.equals("2")){//一级支行查看本行及辖属二级支行数据           20160914更新，增加总行处理标识判断，总行处理的预警信号不再显示
			hql.append(" and (mainOrg.brcode='"+brcode+"' or mainOrg.brcode in (select brcode from Bctl where blnUpBrcode='"+brcode+"')) and t.handleOrgFlag<>'head'");
		}else if(brclass.equals("3")){//二级支行只能查看本行数据         20160914更新，增加总行处理标识判断，总行处理的预警信号不再显示
			hql.append(" and mainOrg.brcode='"+brcode+"' and t.handleOrgFlag<>'head' ");
		}
		if(StringUtils.isNotEmpty(warnDtStart)){
			hql.append(" and to_char(warnDt,'yyyyMMdd')>='"+warnDtStart+"' ");
		}
		if(StringUtils.isNotEmpty(warnDtEnd)){
			hql.append(" and to_char(warnDt,'yyyyMMdd')<'"+warnDtEnd+"' ");
		}
		if(StringUtils.isNotEmpty(fcettypecode)){
			hql.append(" and fcettypecode like '%"+fcettypecode+"%' ");
		}
		if(StringUtils.isNotEmpty(fcetname)){
			hql.append(" and fcetname like '%"+fcetname+"%' ");
		}
		if(StringUtils.isNotEmpty(taskCode)){
			hql.append(" and taskCode like '%"+taskCode+"%' ");
		}
		if(StringUtils.isNotEmpty(warnStatus)){
			hql.append(" and warnStatus='"+warnStatus+"' ");
		}
		if(StringUtils.isNotEmpty(rulCode)){
			hql.append(" and rulCode='"+rulCode+"' ");
		}
		if(StringUtils.isNotEmpty(rulName)){
			hql.append(" and rulName like '%"+rulName+"%' ");
		}
		if(StringUtils.isNotEmpty(mainOrg)){
			hql.append(" and mainOrg.brcode='"+mainOrg+"' ");
		}
		if(StringUtils.isNotEmpty(id)){
			hql.append(" and id='"+id+"' ");
		}
		String orderby=" ";
		if(StringUtils.isNotBlank(sortField)&&StringUtils.isNotBlank(order)){
			if(sortField.equals("mainOrg")){
				orderby=" order by t.mainOrg.brname "+order;
			}else{
				orderby=" order by "+sortField+" "+order;
			}
		}
		hql.append(orderby);
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
