package com.huateng.ebank.business.management.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * 更新操作员信息EX
 *
 * @author hyurain_yang
 *
 */
public class TlrInfoExtoUpdate extends BaseUpdate {

	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateResultBean tlrInfoBean = multiUpdateResultBean.getUpdateResultBeanByID("Management_TlrInfoEx");
			TlrInfo tlrInfo = new TlrInfo();
			Map map = tlrInfoBean.next();

			setValue2DataBus("extTlrno", (String)map.get("tlrno"));
			setValue2DataBus("departmentCode", (String)map.get("departmentCode"));
			setValue2DataBus("brcode", (String)map.get("brcode"));

			return new UpdateReturnBean();
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
