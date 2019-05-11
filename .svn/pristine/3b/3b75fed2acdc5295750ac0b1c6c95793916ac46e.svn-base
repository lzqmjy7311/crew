package com.gbicc.person.importtext.getter;

import org.springframework.util.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class ImportpublicGetter extends BaseGetter{
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
		
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql=new StringBuffer("from Importpublictext t where 1=1");			
				
		String id = (String) getCommQueryServletRequest().getParameterMap().get("id"); 
		String bankCode = (String) getCommQueryServletRequest().getParameterMap().get("bankCode");
		String middleSigncode = (String) getCommQueryServletRequest().getParameterMap().get("middleSigncode");
		String organizationCode = (String) getCommQueryServletRequest().getParameterMap().get("organizationCode");
		String informationCode = (String) getCommQueryServletRequest().getParameterMap().get("informationCode");
		String creatTime = (String) getCommQueryServletRequest().getParameterMap().get("creatTime");


		
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
				
		

		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(bankCode)){
			hql.append(" and bankCode = '"+bankCode+"'");
		}
		if(StringUtils.hasText(middleSigncode)){
			hql.append(" and middleSigncode = '"+middleSigncode+"'");
		}
		if(StringUtils.hasText(organizationCode)){
			hql.append(" and organizationCode = '"+organizationCode+"'");
		}
		if(StringUtils.hasText(informationCode)){
			hql.append(" and informationCode = '"+informationCode+"'");
		}
		if(StringUtils.hasText(creatTime)){
			hql.append(" and creatTime = to_date('"+creatTime+"','yyyy-mm-dd')");
		}
		

		
//		List<TCustomer> list = rootdao.pageQueryByHql(hql.toString(), pageIndex, pageSize);
//		pageQueryResult.setTotalCount(list.size());
//		pageQueryResult.setQueryResult(list);
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString());
        

		return pageQueryResult;
	}

}

