package com.huateng.fp.demo.updater;

/*
 * ��  �ܣ���˵������Ĺ���
 * �ļ���FunctionInfoMngModifyUpdate.java
 * ��  ����
 * Version   �����         ����              ����           �������
 * -----------------------------------------------------------------------------
 * V1.00     2010-11-12    huateng        jimmy.peng          create
 * -----------------------------------------------------------------------------
 * Copyright (c) 2010 huateng  All Rights Reserved.
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.datadic.operation.DataDicOperation;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;


/**
 * Title: FunctionInfoMngModifyUpdate
 * Description: ������Դ��Ϣҳ��������Update
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author jimmy.peng
 * @date 2010-11-12
 */
public class DataDicModifyUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
			String nextUrl = "";
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("t2DataDicEntry");
			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();
			DataDic databean = null;
			while (updateResultBean.hasNext()) {
				databean = new DataDic();
				Map map = updateResultBean.next();
				mapToObject(databean, map);
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(databean);
					break;
				case UpdateResultBean.DELETE:
					delList.add(databean);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(databean);
					break;
				default:
					break;
				}	
			}

			OperationContext oc = new OperationContext();
			oc.setAttribute(DataDicOperation.CMD_DELETE, delList);
			oc.setAttribute(DataDicOperation.CMD_INSERT, insertList);
			oc.setAttribute(DataDicOperation.CMD_UPDATE, updateList);
			oc.setAttribute(DataDicOperation.CMD, "saveUpdateDelete");
			OPCaller.call(DataDicOperation.ID, oc);
			return updateReturnBean;


	}

}
