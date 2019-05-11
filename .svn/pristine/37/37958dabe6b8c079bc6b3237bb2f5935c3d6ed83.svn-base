package com.huateng.ebank.business.management.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.operation.TlrInfoExOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 操作员管理时,根据查询条件,查找操作员信息
 *
 * @author hyurain_yang
 *
 */
public class TlrInfoExGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());
			result.setContent(pageResult.getQueryResult());
			if (pageResult.getQueryResult().size() == 0) {
				result.getPage().setTotalPage(0);
			} else {
				result.getPage().setTotalPage(1);
			}
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	protected PageQueryResult getData() throws Exception {
//		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		/*String brcode = this.commQueryServletRequest.getParameter("sqlBrcode");// 获取brcode
		if (brcode == null){
			brcode = this.commQueryServletRequest.getParameter("brcode");// 获取brcode
		}*/
		String brcode = getValueFromDataBus("brcode");// 获取brcode
		String departmentCode = getValueFromDataBus("departmentCode");// 获取部门号departmentCode
		String tlrno = getValueFromDataBus("extTlrno");// 获取操作员号tlrno
		/**
		 * 判断操作员是否属于管理操作员所属分行
		 */
		/** 当前机构为分行级别,只能操作本行或者下属行的操作员.*/
		/*
		/** modify by shen_antonio 20081117.*/
//		if(StringUtils.isNotEmpty(tlrno)){
//			boolean flag = TlrInfoExService.getInstance().judgeTlrAttachBranch(tlrno);
//			if (!flag) {
//				ExceptionUtil.throwCommonException("输入的操作员不在本行管辖范围内",
//						ErrorCode.ERROR_CODE_CHECK_AUTH_FAIL);
//			}
//		}
		PageQueryResult pageQueryResult = new PageQueryResult();
		OperationContext oc = new OperationContext();
		oc.setAttribute(TlrInfoExOperation.CMD, "SELECT_TLR_INFO");
		oc.setAttribute("brcode", brcode);
		oc.setAttribute("departmentCode", departmentCode);
		oc.setAttribute("tlrno", tlrno);
		OPCaller.call(TlrInfoExOperation.ID, oc);
		List tlrViewList = (List) oc.getAttribute(TlrInfoExOperation.OUT_TLR_INFO_LIST);
		pageQueryResult.setQueryResult(tlrViewList);

		setValue2DataBus("brcode", brcode);
		return pageQueryResult;
	}
}
