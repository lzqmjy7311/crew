package com.huateng.ebank.business.management.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

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

public class BiNationregionModOrAddUpdate extends BaseUpdate {
	/*
	 * 处理国家/地区代码维护的插入和更新,插入和更新给程序判定
	 */
	public final static  String DATASET_ID = "BiNationregionEntry";
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
				BaseUpdate.mapToObject(biNationregion, map);
				if(UpdateResultBean.MODIFY==updateResultBean.getRecodeState()) {
					context.setAttribute(BiNationregionOperation.CMD, BiNationregionOperation.CMD_MOD);
				}
				if(UpdateResultBean.INSERT==updateResultBean.getRecodeState()) {
					context.setAttribute(BiNationregionOperation.CMD, BiNationregionOperation.CMD_ADD);
				}
				//没有的属性,插入null 
				//(oracle 会把空字符串“”转换成null db2不会，db2就插入“”)
				unnvlBiNationregion(biNationregion);
				context.setAttribute(BiNationregionOperation.IN_PARAM, biNationregion);
				//call方式开启operation事务
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
	/*
	 * 处理空字符串,插到数据库中为null
	 * @param biNationregion
	 */
	private void unnvlBiNationregion(BiNationregion biNationregion) {
		if(StringUtils.isBlank(biNationregion.getChinaName())) {
			biNationregion.setChinaName(null);
		}
		if(StringUtils.isBlank(biNationregion.getNationregionNumber())) {
			biNationregion.setNationregionNumber(null);
		}
		if(StringUtils.isBlank(biNationregion.getChinaShortName())) {
			biNationregion.setChinaShortName(null);
		}
		if(StringUtils.isBlank(biNationregion.getEngName())) {
			biNationregion.setEngName(null);
		}
		if(StringUtils.isBlank(biNationregion.getEngShortName())) {
			biNationregion.setEngShortName(null);
		}
	}

}
