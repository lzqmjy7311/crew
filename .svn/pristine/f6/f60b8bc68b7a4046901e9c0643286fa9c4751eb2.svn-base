/**
 *
 */
package com.huateng.ebank.business.parammng.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.parammng.operation.TlrInfoUpdaterOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author yjw
 *
 */
public class TlrInfoUpdater extends BaseUpdate {


	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("parammng_TlrInfo3");
			String tlrno = null;
			if (updateResultBean.hasNext()) {
				tlrno = updateResultBean.next().get("tlrno");
			}
			OperationContext oc = new OperationContext();
			oc.setAttribute(TlrInfoUpdaterOperation.TLRNO, tlrno);
			oc.setAttribute(TlrInfoUpdaterOperation.CMD, updateResultBean.getParameter("cmd"));
			
			OPCaller.call("parammng.TlrInfoUpdaterOperation", oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
