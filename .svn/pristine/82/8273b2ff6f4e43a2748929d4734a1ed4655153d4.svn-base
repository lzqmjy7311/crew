package com.huateng.ebank.business.management.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.RoleInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @Description:
 * @Package: com.huateng.ebank.business.custadmin.getter
 * @author: fubo
 * @date: 2010-8-3 涓婂崃10:31:30
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class EbankCustRoleMngUserGetter extends BaseGetter {

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
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		String roleId = (String) getCommQueryServletRequest().getParameterMap()
				.get("roleId");
		StringBuffer hql = new StringBuffer("select count(1) from TLR_ROLE_REL tlrRole where tlrRole.ROLE_ID =  '"
				+ roleId + "'");
		Object countTotal=rootdao.querySqlOne(hql.toString());
		RoleInfoService roleInfoService = RoleInfoService.getInstance();
		List list  = (List) roleInfoService.queryRoleInfo(roleId, pageIndex, pageSize);
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult.setQueryResult(list);
		pageQueryResult.setTotalCount(Integer.parseInt(countTotal.toString()));
		return pageQueryResult;
	}

}
