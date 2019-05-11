package com.huateng.ebank.business.management.updater;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.TlrInfoExOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * 操作员增加EX
 *
 * @author hyurain_yang
 *
 */
public class SelectTlrAddUpdate extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			UpdateResultBean tlrRoleBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_SelectTlrAdd");
			Map map = tlrRoleBean.next();
			String brcode = (String)map.get("brcode");
			String departmentCode = "3000";
			String extTlrno = (String)map.get("extTlrno");

			setValue2DataBus("brcode", brcode);
			setValue2DataBus("departmentCode", departmentCode);
			setValue2DataBus("extTlrno", extTlrno);

			OperationContext oc = new OperationContext();
			oc.setAttribute(TlrInfoExOperation.CMD, "SELECT_TLR_ADD");
			oc.setAttribute("brcode", brcode);
			oc.setAttribute("extTlrno", extTlrno);
			oc.setAttribute("departmentCode", departmentCode);
			OPCaller.call(TlrInfoExOperation.ID, oc);
			List tlrInfoList = (List) oc.getAttribute(TlrInfoExOperation.OUT_TLR_JUDGE_LIST);
			return new UpdateReturnBean();
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}


}
