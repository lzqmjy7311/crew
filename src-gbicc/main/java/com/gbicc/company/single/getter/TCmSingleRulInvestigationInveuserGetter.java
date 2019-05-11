package com.gbicc.company.single.getter;

import java.util.List;
import java.util.Map;

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
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author ligang
 *
 */
public class TCmSingleRulInvestigationInveuserGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "用户管理查询");
			
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "用户管理查询");
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	protected PageQueryResult getData() throws Exception {
		String brcode = (String) getCommQueryServletRequest().getParameterMap().get("brcode1");
		String qtlrnoName = (String) getCommQueryServletRequest().getParameterMap().get("qtlrnoName");
		String qtlrno = (String) getCommQueryServletRequest().getParameterMap().get("qtlrno");
		GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
		int pageSize = getResult().getPage().getEveryPage();// 分页大小
		int pageIndex = getResult().getPage().getCurrentPage();// 页码
		Bctl bctl=BctlService.getInstance().getBctlByBrcode(brcode);
		String brClass=bctl.getBrclass();
		String sql="select * from tlr_info po where tlrno in (select f_user_id from T_USER_ORGROLE_REL where 1=1 ";
		/*if(StringUtils.isNotBlank(brcode)&&brcode.equals(globalinfo.getBrcode())==false){
			sql+="and f_org_id='"+ brcode + "' ";
		}
		if(StringUtils.isNotBlank(brcode)&&brcode.equals(globalinfo.getBrcode())){
			sql+="and f_org_id='123456789' ";
		}*/
		if(brClass.equals("1")){
			sql+=" and f_org_id='"+brcode+"' and f_role_id='123456789' ";
		}
		if(brClass.equals("2")){
			sql+=" and f_org_id='"+brcode+"' and f_role_id='603' ";
		}
		if(brClass.equals("3")){
			sql+=" and f_org_id='"+brcode+"' and f_role_id='601' ";
		}
		sql +=" )";
		if(!DataFormat.isEmpty(qtlrnoName)){
			sql+=" and po.tlr_name like  '%" + qtlrnoName + "%' ";
		}
		if(!DataFormat.isEmpty(qtlrno)){
			sql+=" and po.tlrno like  '%" + qtlrno + "%' ";
		}
		String orderby= " order by tlrno";
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
