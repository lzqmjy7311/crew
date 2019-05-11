package com.gbicc.person.supervision.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.person.supervision.entity.QualitysuPar;
import com.gbicc.person.supervision.operation.QualitysuParOperation;
import com.gbicc.person.supervision.service.QualitysuParService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;


/**
 * 
 * @author kfc
 *
 * 版本：2015年10月21日 上午11:43:03
 * 类说明：客户修改
 */
public class QualitysuParModUpdate extends BaseUpdate {
	private static final String DATASET_ID = "TCustomerEntry";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			QualitysuPar dd = new QualitysuPar();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				
				String op = updateResultBean.getParameter("op");
				if("new".equals(op) || "copynew".equals(op)) {
					dd = new QualitysuPar();
					oc.setAttribute(QualitysuParOperation.CMD, QualitysuParOperation.CMD_INSERT);
				} else if ("mod".equals(op)) {
					dd = QualitysuParService.getInstance().get((String) map.get("id"));
					oc.setAttribute(QualitysuParOperation.CMD, QualitysuParOperation.CMD_UPDATE);
				}
				mapToObject(dd, map);
			}
			oc.setAttribute(QualitysuParOperation.IN_PARAM, dd);
			OPCaller.call(QualitysuParOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}

