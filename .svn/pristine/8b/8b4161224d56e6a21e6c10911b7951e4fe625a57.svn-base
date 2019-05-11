package com.gbicc.person.collection.getter;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.person.collection.entity.TCollectionInfo;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 
 * @author liufei
 *
 * 版本：2015年11月07日 上午17:41:00
 * 类说明：催收 查询类
 */
@SuppressWarnings("unchecked")
public class TCollectionInfoGetter extends BaseGetter {

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
		String userId=info.getTlrno();
		String queryType = (String) getCommQueryServletRequest().getParameterMap().get("queryType");
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String custCode = (String) getCommQueryServletRequest().getParameterMap().get("custCode");
		String custName = (String) getCommQueryServletRequest().getParameterMap().get("custName");
		String collectionType = (String) getCommQueryServletRequest().getParameterMap().get("collectionType");
		String operator = (String) getCommQueryServletRequest().getParameterMap().get("operator");
		String loanAccount = (String) getCommQueryServletRequest().getParameterMap().get("loanAccount");
		String productCode = (String) getCommQueryServletRequest().getParameterMap().get("productCode");
		String operBank = (String) getCommQueryServletRequest().getParameterMap().get("operBank");
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("select t1 from TCollectionInfo t1,ActiveTask t2  where t1.id=t2.businessKey ");
		hql.append(" and t2.assignee='").append(userId).append("'");
		if(!"admin".equals(userId)){
			hql.append(" and t1.operBank='"+info.getBrcode()+"' ");
		}
		if(StringUtils.hasText(id)){
			hql.append(" and t1.id = '"+id+"'");
		}
		if(StringUtils.hasText(custCode)){
			hql.append(" and t1.custCode like '%"+custCode+"%'");
		}
		if(StringUtils.hasText(custName)){
			hql.append(" and t1.custName like '%"+custName+"%'");
		}
		if(StringUtils.hasText(operator)){
			hql.append(" and t1.operator like '%"+operator+"%'");
		}
		if(StringUtils.hasText(loanAccount)){
			hql.append(" and t1.loanAccount like '%"+loanAccount+"%'");
		}
		if(StringUtils.hasText(collectionType)){
			hql.append(" and t1.collectionType = '"+collectionType+"'");
		}
		if(StringUtils.hasText(productCode)){
			hql.append(" and t1.productCode like '%"+productCode+"%'");
		}
		if(StringUtils.hasText(operBank)){
			hql.append(" and t1.operBank like '%"+operBank+"%'");
		}
//		List<TCollectionInfo> list = rootdao.pageQueryByHql(hql.toString(), pageIndex, pageSize);
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString());
		
		List list=pageQueryResult.getQueryResult();
		for (int i = 0; i < list.size(); i++) {
			TCollectionInfo tci=(TCollectionInfo)list.get(i);
			if(tci.getRegistDate()==null){
				tci.setRegistDate(new Date());
			}
			if(tci.getCollePersonCode()==null){
				tci.setCollePersonCode(userId);
			}
		}
		
//		pageQueryResult.setTotalCount(list.size());
//		pageQueryResult.setQueryResult(list);


		return pageQueryResult;
	}
	
}
