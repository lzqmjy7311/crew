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
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TaskAfreshAssignGetter extends BaseGetter {

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
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String brcode=info.getBrno();
		String roleType=info.getExtensbean().getRoleSysType();
		String businessId = (String) getCommQueryServletRequest().getParameterMap().get("businessId");
		String procName = (String) getCommQueryServletRequest().getParameterMap().get("procName");
		String assignee = (String) getCommQueryServletRequest().getParameterMap().get("assignee");
		String createTimeStart = (String) getCommQueryServletRequest().getParameterMap().get("createTimeStart");
		String createTimeEnd = (String) getCommQueryServletRequest().getParameterMap().get("createTimeEnd");
		String bank = (String) getCommQueryServletRequest().getParameterMap().get("bank");
		String order = (String) getCommQueryServletRequest().getParameterMap().get("order");
		String sortField = (String) getCommQueryServletRequest().getParameterMap().get("sortField");
		int pageSize = getResult().getPage().getEveryPage();// 分页大小
		int pageIndex = getResult().getPage().getCurrentPage();// 页码
		String sql="select substr(task.task_def_key_,2,3) as roleId,task.PROC_INST_ID_ as procInstId,def.NAME_ as procName,task.NAME_ as taskName,task.DESCRIPTION_ as taskDesc,task.ID_ as taskId,u.tlrno||'_'||u.tlr_name as assigneeDesc,u.tlrno as assignee,b.brname as assigneeOrg,task.CREATE_TIME_ as createTime,task.SUSPENSION_STATE_ as suspensionState,def.key_ as procKey from act_ru_task task join ACT_RE_PROCDEF def "+
		" on task.PROC_DEF_ID_=def.id_ left join tlr_info u on task.ASSIGNEE_=u.tlrno "
		+" left join bctl b on u.brcode=b.brcode where 1=1 ";
		if(StringUtils.hasText(businessId)){
			sql+=" and task.DESCRIPTION_ like '%"+businessId+"%' ";
		}
		if(StringUtils.hasText(procName)){
			sql+=" and def.NAME_='"+procName+"' ";
		}
		if(StringUtils.hasText(assignee)){
			sql+=" and ( task.ASSIGNEE_ like '%"+assignee+"%' or u.tlr_name like '%"+assignee+"%' ) ";
		}
		if(StringUtils.hasText(createTimeStart)){
			sql+=" and to_char(task.create_time_,'yyyyMMdd')>='"+createTimeStart+"' ";
		}
		if(StringUtils.hasText(createTimeEnd)){
			sql+=" and to_char(task.create_time_,'yyyyMMdd')<='"+createTimeEnd+"' ";
		}
		if(!info.isHeadBrcode()){
			String orgs=BctlService.getInstance().findChildOrgs(brcode);
			sql+=" and b.brno in ("+orgs+") ";
		}
		if(StringUtils.hasText(bank)){
			String orgs=BctlService.getInstance().findChildOrgs(bank);
			sql+=" and b.brno in ("+orgs+") ";
		}
		if(StringUtils.hasText(roleType)){
			sql+=" and substr(task.proc_def_id_,1,2)='"+roleType+"' ";
		}else{
			sql+=" and 1=2 ";
		}
		String orderby=" order by procName asc,procInstId desc,createTime desc ";
		if(StringUtils.hasText(order) && StringUtils.hasText(sortField)){
			orderby=" order by "+sortField+" "+order;
		}
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
		
		PageQueryResult result = new PageQueryResult();
		result.setQueryResult(resultList);
		result.setTotalCount(totalCount);
		return result;
	}
}
