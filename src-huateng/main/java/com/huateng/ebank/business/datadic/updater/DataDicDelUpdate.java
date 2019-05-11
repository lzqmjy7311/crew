package com.huateng.ebank.business.datadic.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.datadic.operation.DataDicOperation;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class DataDicDelUpdate extends BaseUpdate {
	/*ftl页面中通用查询ID,即CommonQuery的ID*/
	private static final String DATASET_ID = "DataDicEntry";

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			//返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			//结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			//数据字典类
			DataDic dd = new DataDic();
			//Operation的参数
			OperationContext oc = new OperationContext();
			//结果集中是否有数据
			if (updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				oc.setAttribute(DataDicOperation.CMD, DataDicOperation.CMD_DELETE);
				//属性拷贝 map -> bean
				mapToObject(dd, map);
			}
			oc.setAttribute(DataDicOperation.IN_PARAM, dd);
			//必须以OPCaller.call的方式调用Operation类,是因为事务是封装在OP层
			OPCaller.call(DataDicOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
