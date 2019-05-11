package com.gbicc.rule.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.person.customer.opration.TCustomerMngOperation;
import com.gbicc.rule.entity.TRulCategory;
import com.gbicc.rule.operation.TRulCategoryOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TRuleCategoryDel extends BaseUpdate {
	private static final String DATASET_ID =TRulCategory.class.getSimpleName();
	private static final String DATASET_TREE_ID ="TRulCategoryTree";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID( DATASET_TREE_ID);
			TRulCategory dd = new TRulCategory();
			OperationContext oc = new OperationContext();
			
			if (updateResultBean.hasNext()) {
				String id=updateResultBean.getParameter("id");
				oc.setAttribute(TRulCategoryOperation.CMD, TCustomerMngOperation.CMD_DELETE);
				dd.setId(id);
			}
			oc.setAttribute(TRulCategoryOperation.IN_PARAM, dd);
			OPCaller.call(TRulCategoryOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
