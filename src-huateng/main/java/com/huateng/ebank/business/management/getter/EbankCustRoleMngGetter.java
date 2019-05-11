package com.huateng.ebank.business.management.getter;

import java.lang.reflect.InvocationTargetException;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.RoleInfoService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @Description: 企业岗位查询
 * @Package: com.huateng.ebank.business.custadmin.getter
 * @author: fubo
 * @date: 2010-7-29 下午04:09:49
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class EbankCustRoleMngGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "角色管理查询");
			
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "角色管理查询");

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
		RoleInfoService roleInfoService = RoleInfoService.getInstance();
		PageQueryResult list = new PageQueryResult();
		try {
			list = roleInfoService.queryRole(pageIndex, pageSize);
		} catch (IllegalAccessException e) {
			ExceptionUtil.throwCommonException("岗位查询失败!");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			ExceptionUtil.throwCommonException("岗位查询失败!");
			e.printStackTrace();
		}

		return list;
	}

}
