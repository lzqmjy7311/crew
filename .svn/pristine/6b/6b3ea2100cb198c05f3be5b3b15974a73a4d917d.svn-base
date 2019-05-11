package com.gbicc.task.getter;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gbicc.bpm.SpringContextHolder;
import com.gbicc.person.monitor.entity.TPlTask;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.gbicc.person.monitor.service.TaskType;
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

/**
 * 
 * @author xudongdong
 *
 * 版本：2015年10月30日 下午1:41:33
 * 类说明：任务查询类
 */
public class TTaskEntryGetter extends BaseGetter {

	private static final String OUT="out";
	private static final String NEW="new";
	private static final String CHECK="checkTask";
	private static final String PASS="passTask";
	private static final String DBTASK="dbtask";
	private static final String BACKTASK="backtask";
	private static final String ZHANGROLES = "557,558";// 总行角色
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
		String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
		TaskType taskType=TaskType.getTaskType(type);
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		String userId=info.getTlrno();
		String roleId=info.getWorkflowRoleId();
		TPlTaskService tPlTaskService=TPlTaskService.getInstance();
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		String brcode= info.getBrcode();//TODO 机构
		
		StringBuffer sql=tPlTaskService.getQueryStr(userId, roleId);
		PageQueryResult pageQueryResult = new PageQueryResult();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//构造分页
		StringBuffer sqlp=new StringBuffer("select t0.* from ( ");
		sqlp.append("select t.*,row_number() over(order by CREATE_TIME_ desc,TASK_TYPE desc) as rnum from ( ");
		sqlp.append(sql);
		sqlp.append(tPlTaskService.getQueryStr(taskType));
		sqlp.append(") t ) t0 where t0.rnum>"+(pageIndex-1)*pageSize+" ");
		sqlp.append("fetch first "+pageSize+" rows only ");
		JdbcTemplate jdbcTemplate=SpringContextHolder.getBean(JdbcTemplate.class);
		List<TPlTask> tasks=jdbcTemplate.query(sqlp.toString(), 
				BeanPropertyRowMapper.newInstance(TPlTask.class));
		//构造数据量
		StringBuffer sqll=new StringBuffer("select count(1) from ( ");
		sqll.append(sql);
		sqll.append(tPlTaskService.getQueryStr(taskType));
		sqll.append(" )");
		//set
		Integer totalCount=(Integer)rootdao.querySqlOne(sqll.toString());
		pageQueryResult.setQueryResult(tasks);
		pageQueryResult.setTotalCount(totalCount);
		return pageQueryResult;
	}
}
