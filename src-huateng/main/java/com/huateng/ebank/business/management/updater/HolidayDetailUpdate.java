package com.huateng.ebank.business.management.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.HolidayDetailUpdateOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class HolidayDetailUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		UpdateResultBean updateResultBeasn = arg0.getUpdateResultBeanByID("parammng_HolidayDetail");
		Map map = updateResultBeasn.next();
		String year = (String)map.get("year");
		String holidayDef = (String)map.get("holidayDef");
		OperationContext oc = new OperationContext();
		oc.setAttribute(HolidayDetailUpdateOperation.INPUT_YEAR,year);
		oc.setAttribute(HolidayDetailUpdateOperation.INPUT_HOLIDAYDEF,holidayDef);
		oc.setAttribute(HolidayDetailUpdateOperation.INPUT_CMD,HolidayDetailUpdateOperation.INPUT_CMD_UPDATE);
		OPCaller.call(HolidayDetailUpdateOperation.ID, oc);
		return updateReturnBean;
	}

}
