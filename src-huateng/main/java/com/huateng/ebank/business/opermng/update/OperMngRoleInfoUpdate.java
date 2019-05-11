/**
 *
 */
package com.huateng.ebank.business.opermng.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.opermng.operation.OperMngOperation;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.view.TlrRoleRelationView;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngRoleInfoUpdate extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean tlrRoleBean = multiUpdateResultBean
					.getUpdateResultBeanByID("operMngRoleInfo");
			UpdateResultBean tlrInfoBean = multiUpdateResultBean
					.getUpdateResultBeanByID("operMngMod");
			TlrInfo tlrInfo = null;
			while (tlrInfoBean.hasNext()) {
				tlrInfo = new TlrInfo();
				Map map = tlrInfoBean.next();
				mapToObject(tlrInfo, map);
			}
			
			List roleList = new ArrayList();
			while (tlrRoleBean.hasNext()) {
				TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
				mapToObject(tlrRoleView, tlrRoleBean.next());
				tlrRoleView.setTlrno(tlrInfo.getTlrno());

				//if (tlrRoleView.isSelected()) {
					roleList.add(tlrRoleView);
				//}
			}
			OperationContext oc = new OperationContext();
			oc.setAttribute(OperMngOperation.CMD, "auth");
			oc.setAttribute(OperMngOperation.IN_ROLELIST, roleList);
			OPCaller.call(OperMngOperation.ID, oc);

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
