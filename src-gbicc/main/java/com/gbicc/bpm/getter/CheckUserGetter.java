package com.gbicc.bpm.getter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 查找分派后检查人
 * @author likm
 *
 */
public class CheckUserGetter extends BaseGetter {

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

	@SuppressWarnings("rawtypes")
	protected PageQueryResult getData() throws Exception {
		String distId = (String) getCommQueryServletRequest().getParameterMap().get("distId");
		PageQueryResult result = new PageQueryResult();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if(StringUtils.isNotEmpty(distId)){
			String hql="from TPlAccountDistRecord where distId='"+distId+"' ";
			List list=rootdao.queryByCondition(hql);
			result.setQueryResult(list);
			result.setTotalCount(list.size());
		}
		return result;
	}
}
