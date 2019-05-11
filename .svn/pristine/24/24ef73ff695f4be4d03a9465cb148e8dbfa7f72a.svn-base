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
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.management.operation.TlrInfoExOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * 操作员增加EX
 *
 * @author hyurain_yang
 *
 */
public class QryTlrUpdate extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		try {
			UpdateResultBean tlrRoleBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_QryTlrAdd");
			Map map = tlrRoleBean.next();
			String brcode = (String)map.get("brcode");
			String departmentCode = (String)map.get("departmentCode");
			String extTlrno = (String)map.get("extTlrno");

			if(brcode !=null && brcode !="")
				setValue2DataBus("brcode", brcode);
			if(departmentCode !=null && departmentCode !="")
				setValue2DataBus("departmentCode", departmentCode);
			if(departmentCode !=null && departmentCode !="")
				setValue2DataBus("extTlrno", extTlrno);

			OperationContext oc = new OperationContext();
			oc.setAttribute(TlrInfoExOperation.CMD, "SELECT_TLR_INFO");
			oc.setAttribute("brcode", brcode);
			oc.setAttribute("departmentCode", departmentCode);
			oc.setAttribute("tlrno", extTlrno);
			OPCaller.call(TlrInfoExOperation.ID, oc);
			List tlrViewList = (List) oc.getAttribute(TlrInfoExOperation.OUT_TLR_INFO_LIST);
			if(tlrViewList.size() == 0 ){
				ExceptionUtil.throwCommonException("没有找到符合条件的记录",ErrorCode.ERROR_CODE_TLR_INFO_SELECT);
			}

			return new UpdateReturnBean();
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}


}
