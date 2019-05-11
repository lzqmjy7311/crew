package com.huateng.ebank.business.management.updater;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.RelationCodeOperation;
import com.huateng.ebank.entity.data.mng.RelationCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class RelationCodeUpdate extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_RelationCode");
			List updateList = new ArrayList();
			List insertList = new ArrayList();
			List delList = new ArrayList();
			RelationCode bean = null;
			while (updateResultBean.hasNext()) {
				bean = new RelationCode();
				mapToObject(bean, updateResultBean.next());
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(bean);
					break;
				case UpdateResultBean.DELETE:
					delList.add(bean);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(bean);
					break;
				default:
					break;
				}
			}
			OperationContext context = new OperationContext();
			context.setAttribute(RelationCodeOperation.INSERT_LIST, insertList);
			context.setAttribute(RelationCodeOperation.UPDATE_LIST, updateList);
			context.setAttribute(RelationCodeOperation.DELETE_LIST, delList);
			OPCaller.call(RelationCodeOperation.ID, context);
			return updateReturnBean;
		}catch (CommonException ex){
			throw ex;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
