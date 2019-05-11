package com.gbicc.person.great.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.great.entity.TPlGreatEvent;
import com.gbicc.person.great.operation.TPlGreatEventOperation;
import com.gbicc.person.great.service.TPlGreatEventService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPlGreatEventUpdate extends BaseUpdate {
	private static final String DATASET_ID ="GreatEvent";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TPlGreatEvent ge = new TPlGreatEvent();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				if(map.get("id")!=null && StringUtils.isNotEmpty(map.get("id").toString())) {
					ge = TPlGreatEventService.getInstance().get((String) map.get("id"));
				} else {
					ge = new TPlGreatEvent();
				}
				mapToObject(ge, map);
				if(map.get("regiUserId")!=null && StringUtils.isNotEmpty(map.get("regiUserId").toString())){
					ge.setRegiUser(TlrInfoService.getInstance().getTlrInfoByTlrno(map.get("regiUserId").toString()));
				}
			}
			oc.setAttribute(TPlGreatEventOperation.IN_PARAM,ge);
			OPCaller.call(TPlGreatEventOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}