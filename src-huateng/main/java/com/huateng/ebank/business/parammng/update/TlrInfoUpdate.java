/**
 *
 */
package com.huateng.ebank.business.parammng.update;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.parammng.bean.TlrRoleInfoView;
import com.huateng.ebank.business.parammng.operation.TlrInfoOperation;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author yjw
 *
 */
public class TlrInfoUpdate extends BaseUpdate {


	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("parammng_TlrInfo2");
			//UpdateReturnBean updateReturnBean1 = new UpdateReturnBean();
			UpdateResultBean updateResultBean1 = multiUpdateResultBean
					.getUpdateResultBeanByID("parammng_TlrInfo3");
			List<TlrRoleInfoView> updateList = new ArrayList<TlrRoleInfoView>();
			TlrInfo tlrInfo = new TlrInfo();
			while (updateResultBean.hasNext()) {
				TlrRoleInfoView tlrRoleInfoView = new TlrRoleInfoView();
				mapToObject(tlrRoleInfoView, updateResultBean.next());
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.MODIFY:
					updateList.add(tlrRoleInfoView);
					break;
				case UpdateResultBean.NONE:
					updateList.add(tlrRoleInfoView);
					break;
				default:
					break;
				}
			}
			if (updateResultBean1.hasNext()) {
				tlrInfo = new TlrInfo();
				mapToObject(tlrInfo, updateResultBean1.next());
			}
			OperationContext oc = new OperationContext();
			oc.setAttribute(TlrInfoOperation.IN_LIST, updateList);
			oc.setAttribute(TlrInfoOperation.IN_TLRINFO, tlrInfo);
			OPCaller.call("parammng.TlrInfoOperation", oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
