package com.gbicc.company.single.getter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.SpringContextHolder;
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

public class TCmWarningQueryGetter extends BaseGetter {

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

	public PageQueryResult getData() throws Exception {
		String warnType = (String) getCommQueryServletRequest().getParameterMap().get("warnType");
		String warnCode = (String) getCommQueryServletRequest().getParameterMap().get("warnCode");
		String warnLevel = (String) getCommQueryServletRequest().getParameterMap().get("warnLevel");
		String rulName = (String) getCommQueryServletRequest().getParameterMap().get("rulName");
		String rulTheme = (String) getCommQueryServletRequest().getParameterMap().get("rulTheme");
		String warnElim = (String) getCommQueryServletRequest().getParameterMap().get("warnElim");
		String warnReli = (String) getCommQueryServletRequest().getParameterMap().get("warnReli");
		String warnDtStart = (String) getCommQueryServletRequest().getParameterMap().get("warnDtStart");
		String warnDtEnd = (String) getCommQueryServletRequest().getParameterMap().get("warnDtEnd");
		String customerNum = (String) getCommQueryServletRequest().getParameterMap().get("customerNum");
		String customerName = (String) getCommQueryServletRequest().getParameterMap().get("customerName");
		String taskCode = (String) getCommQueryServletRequest().getParameterMap().get("taskCode");
		String assignee = (String) getCommQueryServletRequest().getParameterMap().get("assignee");
		String handlingOrgCd = (String) getCommQueryServletRequest().getParameterMap().get("handlingOrgCd");
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
		
		int pageSize = getResult().getPage().getEveryPage();// 分页大小
		int pageIndex = getResult().getPage().getCurrentPage();// 页码
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String sql="SELECT DISTINCT t.*,b.BRNAME,g.FD_HANDLE_ORG_FLAG,S.FD_CASES_NAME FROM VIEW_CM_WARNING t left join T_CM_SINGLE_RUL_WARNING g on t.fd_id=g.fd_id left join T_ACT_ACTIVETASK_HIS_V t2 on t.FD_ID=t2.BUSINESS_KEY left join bctl b on t.HANDLING_ORG_CD=b.BRCODE  left join T_CM_SINGLE_RUL_CASES S ON G.FD_CASES_ID=S.FD_ID where 1=1 ";
		if("601".equals(info.getWorkflowRoleId())||"602".equals(info.getWorkflowRoleId())){
			sql +=" and TASK_TYPE='CUST' ";
		}
		Bctl bctl=BctlService.getInstance().getBctlByBrno(info.getBrcode());
		if(!"1".equals(bctl.getBrclass())){//总行层级查询所有的
			if("2".equals(bctl.getBrclass())){//支行  查询 自己的  或者 参与过流程的  或者 子机构的
				sql +=" and (t.CUST_MANAGER_ID = '"+info.getTlrno()+"' or t2.ASSIGNEE='"+userId+"' or t.HANDLING_ORG_CD in (SELECT BRNO FROM BCTL WHERE BLN_UP_BRCODE='"+info.getBrcode()+"' ) ) AND (G.FD_HANDLE_ORG_FLAG <>'head' OR G.FD_HANDLE_ORG_FLAG IS NULL) ";
			}else{
				sql +=" and t2.ASSIGNEE='"+userId+"'  ";
			}
		}
		if(StringUtils.isNotEmpty(handlingOrgCd)){
			sql+=" and (t.HANDLING_ORG_CD='"+handlingOrgCd+"' or t.HANDLING_ORG_CD in (SELECT BRNO FROM BCTL WHERE BLN_UP_BRCODE='"+handlingOrgCd+"' )) ";
		}
		if(StringUtils.isNotEmpty(warnCode)){
			sql+=" and t.FD_WARN_CODE like '%"+warnCode+"%' ";
		}
		if(StringUtils.isNotEmpty(warnLevel)){
			sql+=" and t.fd_warn_level like '%"+warnLevel+"%' ";
		}
		if(StringUtils.isNotEmpty(rulName)){
			sql+=" and t.FD_RUL_NAME like '%"+rulName+"%' ";
		}
		if(StringUtils.isNotEmpty(rulTheme)){
			sql+=" and t.FD_RUL_THEME_CD like '%"+rulTheme+"%' ";
		}
		if("1".equals(warnElim)){
			sql+=" and t.FD_WARN_STATUS ='4' ";
		}
		if(StringUtils.isNotEmpty(warnReli)){
			if("1".equals(warnReli)){
				sql+=" and t.FD_WARN_STATUS ='5' ";
			}else{
				sql+=" and t.FD_WARN_STATUS ='6' ";
			}
		}
		if(StringUtils.isNotEmpty(warnType)){
			sql +=" and t.TASK_TYPE='"+warnType+"' ";
		}
		if(StringUtils.isNotEmpty(warnDtStart)){
			sql +=" and to_char(t.FD_WARN_DT,'yyyyMMdd')>='"+warnDtStart+"' ";
		}
		if(StringUtils.isNotEmpty(warnDtEnd)){
			sql +=" and to_char(t.FD_WARN_DT,'yyyyMMdd')<'"+warnDtEnd+"' ";
		}
		if(StringUtils.isNotEmpty(customerNum)){
			sql +=" and t.CUSTOMER_NUM like '%"+customerNum+"%' ";
		}
		if(StringUtils.isNotEmpty(customerName)){
			sql +=" and t.CUSTOMER_NAME like '%"+customerName+"%' ";
		}
		if(StringUtils.isNotEmpty(assignee)){
			sql +=" and t.assignee_ like '%"+assignee+"%' ";
		}
		if(StringUtils.isNotEmpty(taskCode)){
			sql +=" and t.FD_TASK_CODE like '%"+taskCode+"%' ";
		}
		String orderby=" order by t.FD_WARN_DT desc ";
		if(StringUtils.isNotEmpty(order) && StringUtils.isNotEmpty(sortField)){
			orderby=" order by "+sortField+" "+order;
		}
		sql += orderby;
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(sql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<Map<String,Object>> resultList=jdbcTemplate.queryForList(sqlp.toString());
		//构造数据量
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(sql);
		sqll.append(" )");
		//set
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		
		//JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		//List<Map<String,Object>> resultList=jdbcTemplate.queryForList(sql.toString());
		
		PageQueryResult result = new PageQueryResult();
		result.setQueryResult(resultList);
		result.setTotalCount(totalCount);
		return result;
	}
}
