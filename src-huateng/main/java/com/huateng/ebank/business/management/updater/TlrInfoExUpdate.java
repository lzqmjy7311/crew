package com.huateng.ebank.business.management.updater;

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
import com.huateng.ebank.business.management.operation.TlrInfoExOperation;
import com.huateng.ebank.business.management.service.RoleInfoService;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.view.TlrRoleRelationView;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * 更新操作员信息EX
 *
 * @author hyurain_yang
 *
 */
public class TlrInfoExUpdate extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateResultBean tlrRoleBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_TlrRole");
			UpdateResultBean tlrInfoBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_TlrInfoEx");
			List insertRoleList = new ArrayList();
			List deleteRoleList = new ArrayList();
			TlrInfo tlrInfo = new TlrInfo();

			String brcode = this.getValueFromDataBus("brcode");
			while (tlrRoleBean.hasNext()) {
				TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
				mapToObject(tlrRoleView, tlrRoleBean.next());
				if (tlrRoleBean.getRecodeState() == UpdateResultBean.MODIFY) {
					if (tlrRoleView.isSelected()) {
//						if (CommonService.getInstance().isProBranchRoleAddCustManageAndSubBranch(brcode , tlrRoleView.getRoleId())){
							insertRoleList.add(tlrRoleView);
//						} else
//							ExceptionUtil.throwCommonException("只有支行级别的机构可以增加操作员为客户经理或支行行长", ErrorCode.ERROR_CODE_CANNOT_SUBMIT);

					} else {
						deleteRoleList.add(tlrRoleView);
					}
				}
			}
			if (tlrInfoBean.hasNext()) {
				tlrInfo = new TlrInfo();
				Map map = tlrInfoBean.next();
				tlrInfo.setTlrno((String) map.get("tlrno"));
				tlrInfo.setTlrName((String) map.get("tlrName"));
				RoleInfoService ris = RoleInfoService.getInstance();
				try {
					tlrInfo.setRoleid(new Integer(map.get("defRoleid").toString()));
				} catch (Exception e) {
					tlrInfo.setRoleid(ris.getRoleInfoByRoleName(map.get("defRoleid").toString()).getId());
				}
//				tlrInfo.setEffectDate(new SimpleDateFormat("yyyy-MM-dd")
//						.parse(map.get("effectDate").toString()));
//				tlrInfo.setExpireDate(new SimpleDateFormat("yyyy-MM-dd")
//						.parse(map.get("expireDate").toString()));
//				tlrInfo.setCurRoleid(tlrInfo.getDefRoleid());
				tlrInfo.setLoginIp((String) map.get("loginIp"));
			}

			OperationContext oc = new OperationContext();
			oc.setAttribute("insertRoleList", insertRoleList);
			oc.setAttribute("deleteRoleList", deleteRoleList);
			oc.setAttribute("tlrInfo", tlrInfo);
			oc.setAttribute(TlrInfoExOperation.CMD, "UPDATE_TLR_INFO");
			OPCaller.call(TlrInfoExOperation.ID, oc);
			return new UpdateReturnBean();
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
