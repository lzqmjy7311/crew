package com.huateng.ebank.business.rolemng.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.bean.FunctionInfoBean;
import com.huateng.ebank.business.management.operation.FunctionInfoMngOperation;
import com.huateng.ebank.business.rolemng.getter.RoleFuncTreeNode;
import com.huateng.ebank.entity.data.mng.FunctionInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class RoleFuncUpdate extends BaseUpdate {

	private static final String BEAN_ID = "roleFuncTreeAsync";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(BEAN_ID);
		List<FunctionInfoBean> insertList = new ArrayList<FunctionInfoBean>();

		while (updateResultBean.hasNext()) {
			Map<String, String> m = updateResultBean.next();
			if (!StringUtils.equalsIgnoreCase(m.get("recordState"), "delete")) {
				RoleFuncTreeNode node = new RoleFuncTreeNode();
				mapToObject(node, m);
				node.setText(m.get("name"));
				FunctionInfo fi = node.toFunctionInfo();
				FunctionInfoBean fbean = new FunctionInfoBean();
				BeanUtils.copyProperties(fi, fbean);
				insertList.add(fbean);
			}
		}
		OperationContext oc = new OperationContext();
		oc.setAttribute(FunctionInfoMngOperation.CMD, FunctionInfoMngOperation.REBUILD_ALL);
		oc.setAttribute(FunctionInfoMngOperation.IN_INSERT, insertList);
		oc.setAttribute("location", updateResultBean.getParameter("mode"));
		OPCaller.call(FunctionInfoMngOperation.ID, oc);
		return updateReturnBean;
	}

}
