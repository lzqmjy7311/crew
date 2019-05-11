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
 * 操作员删除EX
 *
 * @author hyurain_yang
 *
 */
public class TlrInfoExDelete extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean updateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		UpdateResultBean bean = updateResultBean.getUpdateResultBeanByID("Management_TlrInfoEx");
		Map map = bean.next();
		String tlrno = (String) map.get("tlrno");
		OperationContext oc = new OperationContext();
		oc.setAttribute("tlrno", tlrno);
		oc.setAttribute(TlrInfoExOperation.CMD, "DELETE_TLR");
		OPCaller.call(TlrInfoExOperation.ID, oc);
		return new UpdateReturnBean();
	}

}
