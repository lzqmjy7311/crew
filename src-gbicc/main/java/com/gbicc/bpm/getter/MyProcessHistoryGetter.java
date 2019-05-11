package com.gbicc.bpm.getter;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.bpm.SpringContextHolder;
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

public class MyProcessHistoryGetter extends BaseGetter {

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
		String procName = (String) getCommQueryServletRequest().getParameterMap().get("procName");
		String taskName = (String) getCommQueryServletRequest().getParameterMap().get("taskName");
		String createTimeStart = (String) getCommQueryServletRequest().getParameterMap().get("createTimeStart");
		//String businessKey = this.getCommQueryServletRequest().getParameter("businessKey");
		String createTimeEnd = (String) getCommQueryServletRequest().getParameterMap().get("createTimeEnd");
		String businessDesc = this.getCommQueryServletRequest().getParameter("businessDesc");
		int pageSize = getResult().getPage().getEveryPage();// 分页大小
		int pageIndex = getResult().getPage().getCurrentPage();// 页码
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String sql="select t.PROC_INST_ID_ as procInstId,d.NAME_ as procName,t.id_ as taskId,t.NAME_ as taskName,t.DESCRIPTION_ as taskDesc,u.tlr_name||'('||t.assignee_||')' as assignee,to_char(t.create_time_,'YYYY-MM-DD HH24:SS:mm') as createTime,e.BUSINESS_KEY_ as businessId from act_ru_task t "+
		" join act_re_procdef d on t.PROC_DEF_ID_=d.ID_ left join tlr_info u on t.ASSIGNEE_=u.TLRNO left join act_ru_execution e "+
		" on t.PROC_INST_ID_=e.PROC_INST_ID_ and e.BUSINESS_KEY_ is not null left join bctl b on u.BRCODE=b.BRCODE where t.proc_inst_id_ in ( "+
		" select distinct proc_inst_id_ from act_hi_taskinst where ASSIGNEE_='"+userId+"' "+
		" and (delete_reason_='completed' or delete_reason_ is null)) and t.assignee_<>'"+userId+"' ";
		if(StringUtils.hasText(procName)){
			sql+=" and d.NAME_='"+procName+"' ";
		}
		if(StringUtils.hasText(businessDesc)){
			sql+=" and t.DESCRIPTION_ like '%"+businessDesc+"%' ";
		}
		if(StringUtils.hasText(taskName)){
			sql+=" and t.NAME_ like '%"+taskName+"%' ";
		}
		if(StringUtils.hasText(createTimeStart)){
			sql+=" and to_char(t.create_time_,'yyyyMMdd')>='"+createTimeStart+"' ";
		}
		if(StringUtils.hasText(createTimeEnd)){
			sql+=" and to_char(t.create_time_,'yyyyMMdd')<'"+createTimeEnd+"' ";
		}
		String orderby=" order by createTime desc ";
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over("+orderby+") as rnum from ( ");
		sqlp.append(sql);
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		System.out.println(sql);
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<Map<String,Object>> resultList=jdbcTemplate.queryForList(sqlp.toString());
		//构造数据量
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(sql);
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
