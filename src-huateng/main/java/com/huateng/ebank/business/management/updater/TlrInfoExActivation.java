package com.huateng.ebank.business.management.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.TlrInfoExOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * 操作员被删除后的激活操作员
 *
 * @author hyurain_yang
 *
 */
public class TlrInfoExActivation extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		UpdateResultBean bean = multiUpdateResultBean.getUpdateResultBeanByID("Management_TlrInfoEx");
		Map map = bean.next();
		String tlrno = "";
		tlrno = (String) map.get("tlrno");
		OperationContext oc = new OperationContext();
		oc.setAttribute("tlrno", tlrno);
		oc.setAttribute(TlrInfoExOperation.CMD, "TLR_ACTIVATION");
		OPCaller.call(TlrInfoExOperation.ID, oc);
		return new UpdateReturnBean();
	}

}
