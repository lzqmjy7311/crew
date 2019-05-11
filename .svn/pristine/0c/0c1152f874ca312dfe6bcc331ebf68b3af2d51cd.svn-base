package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.operation.TlrInfoExOperation;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.view.TlrRoleRelationView;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 操作员管理中,查询后获得操作员对应岗位
 *
 * @author hyurain_yang
 *
 */
public class TlrRoleGetter extends BaseGetter {

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

	private PageQueryResult getData() throws Exception {
		//String tlrno = this.commQueryServletRequest.getParameter("tlrno");
		String tlrno = getValueFromDataBus("extTlrno");
		setValue2DataBus("extTlrno", tlrno);
		PageQueryResult pageQueryResult = new PageQueryResult();
		OperationContext oc = new OperationContext();
		oc.setAttribute(TlrInfoExOperation.CMD, "SELECT_TLR_ROLES");
		oc.setAttribute("tlrno", tlrno);
		OPCaller.call(TlrInfoExOperation.ID, oc);
		List allList = (List) oc.getAttribute(TlrInfoExOperation.ALL_ROLE_LIST);
		List tlrRoleList = (List) oc.getAttribute(TlrInfoExOperation.TLR_ROLE_LIST);
		List tlrRoleRelationViewList = new ArrayList();
		// 对以有的操作员岗位在岗位列表中显示
		for (int i = 0; i < allList.size(); i++) {
			RoleInfo roleInfo = (RoleInfo) allList.get(i);
			TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
			tlrRoleView.setTlrno(tlrno);
			tlrRoleView.setRoleId(String.valueOf(roleInfo.getId().intValue()));
			tlrRoleView.setRoleName(roleInfo.getRoleName());
			if (tlrRoleList.contains(roleInfo)) {
				tlrRoleView.setSelected(true);
			} else {
				tlrRoleView.setSelected(false);
			}
			tlrRoleRelationViewList.add(tlrRoleView);
		}

		if (tlrRoleRelationViewList != null
				&& tlrRoleRelationViewList.size() > 0) {
			pageQueryResult.setTotalCount(tlrRoleRelationViewList.size());
		} else {
			pageQueryResult.setTotalCount(0);
		}
		pageQueryResult.setQueryResult(tlrRoleRelationViewList);

		return pageQueryResult;
	}

}
