package com.gbicc.company.single.getter;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.util.DateUtils;
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

public class TCmSingleRulWarningGetter extends BaseGetter {

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
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String taskType = (String) getCommQueryServletRequest().getParameterMap().get("taskType");
		String rulCode = (String) getCommQueryServletRequest().getParameterMap().get("rulCode");
		String rulName = (String) getCommQueryServletRequest().getParameterMap().get("rulName");
		String fcettypecode = (String) getCommQueryServletRequest().getParameterMap().get("fcettypecode");
		String fcetname = (String) getCommQueryServletRequest().getParameterMap().get("fcetname");
		String mainOrg = (String) getCommQueryServletRequest().getParameterMap().get("mainOrg");
		String warnDtStart = (String) getCommQueryServletRequest().getParameterMap().get("warnDtStart");
		String warnDtEnd = (String) getCommQueryServletRequest().getParameterMap().get("warnDtEnd");
		String taskCode = (String) getCommQueryServletRequest().getParameterMap().get("taskCode");
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
		
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("select t1 from TCmSingleRulWarning t1,ActiveTask t2  where t1.id=t2.businessKey ");
		if(StringUtils.isNotEmpty(info.getBrcode())){
			hql.append(" and t1.taskOrg='"+info.getBrcode()+"' ");
		}else{
			hql.append(" 1=2 ");
		}
		if(StringUtils.isNotEmpty(id)){
			hql.append(" and t1.id like '%"+id+"%' ");
		}
		if(StringUtils.isNotEmpty(rulCode)){
			hql.append(" and t1.rulCode like '%"+rulCode+"%' ");
		}
		if(StringUtils.isNotEmpty(rulName)){
			hql.append(" and t1.rulName like '%"+rulName+"%' ");
		}
		if(StringUtils.isNotEmpty(fcettypecode)){
			hql.append(" and t1.fcettypecode like '%"+fcettypecode+"%' ");
		}
		if(StringUtils.isNotEmpty(fcetname)){
			hql.append(" and t1.fcetname like '%"+fcetname+"%' ");
		}
		if(StringUtils.isNotEmpty(taskCode)){
			hql.append(" and t1.taskCode like '%"+taskCode+"%' ");
		}
		if(StringUtils.isNotEmpty(warnDtStart)){
			hql.append(" and to_char(t1.warnDt,'yyyyMMdd') >= '"+warnDtStart+"'");
		}
		if(StringUtils.isNotEmpty(warnDtEnd)){
			hql.append(" and to_char(t1.warnDt,'yyyyMMdd') <='"+warnDtEnd+"'");
		}
		
		if(StringUtils.isNotEmpty(mainOrg)){
			hql.append(" and t1.mainOrg.brcode in (select brcode from Bctl b where b.brcode='"+mainOrg+"' or b.blnUpBrcode='"+mainOrg+"') ");
			
		}
		hql.append(" and t2.assignee='").append(userId).append("'");
		
		if(StringUtils.isNotEmpty(taskType)){
			hql.append(" and '"+DateUtils.formatYmdDate(new Date())+"'>to_char(t1.taskMatureDt,'yyyymmdd') ");
		}
		
		String orderby=" order by t1.warnDt desc ";
		if(StringUtils.isNotEmpty(order) && StringUtils.isNotEmpty(sortField)){
			orderby=" order by t1."+sortField+" "+order;
		}
		hql.append(orderby);
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		return pageQueryResult;
	}
	
	public static void main(String[] args) {
		String str="|L01";
		String[] s=str.split("\\|");
		for(int i=0;i<s.length;i++){
			if(s[i]!=null && !s[i].equals("")){
				System.out.println(s[i]+"--");
			}
		}
	}
}
