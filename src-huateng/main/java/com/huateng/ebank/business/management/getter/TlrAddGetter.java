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
 * 操作员增加时,查询判断操作员岗位,机构是否存在匹配
 *
 * @author hyurain_yang
 *
 */
public class TlrAddGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
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
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	protected PageQueryResult getData() throws Exception {
		String brcode = getValueFromDataBus("brcode");
		String extTlrno = getValueFromDataBus("extTlrno");;
		String departmentCode = getValueFromDataBus("departmentCode");;
		OperationContext oc = new OperationContext();
		oc.setAttribute(TlrInfoExOperation.CMD, "SELECT_TLR_ADD");
		oc.setAttribute("brcode", brcode);
		oc.setAttribute("extTlrno", extTlrno);
		oc.setAttribute("departmentCode", departmentCode);
		OPCaller.call(TlrInfoExOperation.ID, oc);
		List tlrInfoList = (List) oc.getAttribute(TlrInfoExOperation.OUT_TLR_JUDGE_LIST);
		PageQueryResult pageQueryResult = new PageQueryResult();
		if (tlrInfoList != null && tlrInfoList.size() > 0) {
			pageQueryResult.setTotalCount(tlrInfoList.size());
		} else {
			pageQueryResult.setTotalCount(0);
		}
		pageQueryResult.setQueryResult(tlrInfoList);
		return pageQueryResult;
	}
}
