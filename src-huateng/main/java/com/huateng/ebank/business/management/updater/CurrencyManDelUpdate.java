package com.huateng.ebank.business.management.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.CurrencyManOperation;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.SysCurrency;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * this is do for get the webpage event action(delete)
 * @author cwenao
 * 2012-8-13
 */


public class CurrencyManDelUpdate extends BaseUpdate {

	private static final String DATASET_ID="CurrencyManEntry";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		//���ض���
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		//������
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

		//������Ϣ��

		SysCurrency scurrency = new SysCurrency();

		OperationContext oc = new OperationContext();

		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();

		if(updateResultBean.hasNext())
		{
			Map map = updateResultBean.next();
			mapToObject(scurrency,map);
			oc.setAttribute(CurrencyManOperation.CMD, CurrencyManOperation.CMD_DELETE);
		}

		oc.setAttribute(CurrencyManOperation.IN_PARAM, scurrency);
		OPCaller.call(CurrencyManOperation.ID, oc);

		return updateReturnBean;
	}

}
