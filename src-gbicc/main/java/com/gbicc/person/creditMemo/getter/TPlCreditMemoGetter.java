package com.gbicc.person.creditMemo.getter;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.gbicc.person.creditMemo.entity.TPlCreditMemo;
import com.gbicc.person.monitor.entity.TPlControlmeasure;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TPlCreditMemoGetter extends BaseGetter {

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
		
		String oneBrcode = (String) getCommQueryServletRequest().getParameterMap().get("oneBrcode");
		String isAll = (String) getCommQueryServletRequest().getParameterMap().get("isAll");
		String twoBrcode = (String) getCommQueryServletRequest().getParameterMap().get("twoBrcode");
		
		String operator = (String) getCommQueryServletRequest().getParameterMap().get("operator");
		String custname = (String) getCommQueryServletRequest().getParameterMap().get("custname");
		String loanAccount = (String) getCommQueryServletRequest().getParameterMap().get("loanAccount");
		
		String startSdate =  (String) getCommQueryServletRequest().getParameterMap().get("startSdate");
		String startEdate =  (String) getCommQueryServletRequest().getParameterMap().get("startEdate");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from TPlCreditMemo t where 1=1 ");
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(custname)){
			hql.append(" and custname like '%"+custname+"%'");
		}
		if(StringUtils.hasText(loanAccount)){
			hql.append(" and loanAccount like '%"+loanAccount+"%'");
		}
		if(StringUtils.hasText(operator)){
			hql.append(" and operator like '%"+operator+"%'");
		}
		
		if(StringUtils.hasText(startSdate)){
			hql.append(" and startDate >= to_date('"+startSdate+"','yyyy-mm-dd')");
		}
		if(StringUtils.hasText(startEdate)){
			hql.append(" and startDate <= to_date('"+startEdate+"','yyyy-mm-dd')");
		}
		
		//select t1.BRCODE from BCTL t1 where 
		//exists (select t2.BRCODE from BCTL t2 where t1.BRCODE=t2.BRCODE and t2.BLN_UP_BRCODE='0007')
		if(StringUtils.hasText(twoBrcode)){//二级支行选项不为空时，先执行二级支行筛选
			hql.append(" and operBank = '"+twoBrcode+"'");
		}else{
			if(StringUtils.hasText(oneBrcode)){//一级支行不为空时
				if("1".equals(isAll)){//包含所有辖属行
					hql.append(" and (t.operBank ='"+oneBrcode+"' or exists (from Bctl t1 where t.operBank=t1.brcode and t1.blnUpBrcode='"+oneBrcode+"'))");
				}else{//不包含
					hql.append(" and operBank = '"+oneBrcode+"'");
				}
			}
		}
		
		
		JdbcTemplate jdbcTemplate=(JdbcTemplate) ApplicationContextUtils.getBean("JdbcTemplate");
		
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		
		List<TPlCreditMemo> list=pageQueryResult.getQueryResult();
		for (TPlCreditMemo tPlCreditMemo : list) {
			if(StringUtils.hasText(tPlCreditMemo.getBusinessId())){
				String csql="select T.FD_CONMEAS_CODE AS conmeasCode,D.DATA_NAME AS conmeasDesc from T_PL_CONTROLMEASURE T "
						+ "INNER join DATA_DIC D ON T.FD_CONMEAS_CODE=D.DATA_NO AND D.DATA_TYPE_NO='12596'"
						+ " where t.FD_TASK_ID='"+tPlCreditMemo.getBusinessId()+"'";
				List<TPlControlmeasure> listTT=jdbcTemplate.query(csql, BeanPropertyRowMapper.newInstance(TPlControlmeasure.class));
				String controlmeasur="";
				for (TPlControlmeasure tPlControlmeasure : listTT) {
					controlmeasur+=tPlControlmeasure.getConmeasDesc()+",";
				}
				tPlCreditMemo.setControlmeasure(controlmeasur);
			}
		}
		pageQueryResult.setQueryResult(list);
		return pageQueryResult;
	}
}
