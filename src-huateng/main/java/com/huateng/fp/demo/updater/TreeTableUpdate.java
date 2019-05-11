package com.huateng.fp.demo.updater;

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
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TreeTableUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request, HttpServletResponse response) throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("TreeNode");


			while (updateResultBean.hasNext()) {
				Map<String, String> map  = updateResultBean.next();
				if("true".equals(map.get("select"))) {
					//TODO
					System.out.println(map);
				}
			}
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
