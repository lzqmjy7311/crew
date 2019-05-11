package com.huateng.ebank.business.management.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.BiNationregionOperation;
import com.huateng.ebank.entity.data.mng.BiNationregion;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/*
 * 处理删除国家/地区代码维护的
 * 
 */
public class BiNationregionDelUpdate extends BaseUpdate {

	private static final String DATASET_ID = "BiNationregionEntry";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			//返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			//结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			//更新对象
			BiNationregion biNationregion = new BiNationregion();
			//Operation参数
			OperationContext context = new OperationContext();
			if(updateResultBean.hasNext()) {
				//属性拷贝
				Map map = updateResultBean.next();
				context.setAttribute(BiNationregionOperation.CMD,BiNationregionOperation.CMD_DEL);
				BaseUpdate.mapToObject(biNationregion, map);
				//call方式开启operation事务
				context.setAttribute(BiNationregionOperation.IN_PARAM, biNationregion);
				OPCaller.call(BiNationregionOperation.ID, context);
				return updateReturnBean;
			}
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE,e.getMessage(),e);
		}
		return null;
	}
	
}
