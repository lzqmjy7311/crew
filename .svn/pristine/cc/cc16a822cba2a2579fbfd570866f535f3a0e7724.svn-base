package com.gbicc.common.filemng;

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

/**
 * 查询业务上传文件列表
 * @date    2015年11月26日
 * @author  tangdu
 * @desc
 */
public class FileGetter extends BaseGetter {

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
		String relaID = (String) getCommQueryServletRequest().getParameterMap()
				.get("relaID");
		String relaType = (String) getCommQueryServletRequest().getParameterMap()
				.get("relaType");
		PageQueryResult pageQueryResult = new PageQueryResult();
		if(!StringUtils.hasText(relaID)){
			return pageQueryResult;
		}
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("from FileUpload t where 1=1 ");
		if(StringUtils.hasText(relaID)){
			hql.append(" and t.relaID = '"+relaID+"'");
		}
		if(StringUtils.hasText(relaType)){
			hql.append(" and t.relaType = '"+relaType+"'");
		}
		hql.append(" order by uploadTime desc");
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
