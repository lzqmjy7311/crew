package com.gbicc.person.monitor.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.person.monitor.entity.TPlYtReport;
import com.gbicc.person.monitor.operation.TPlYtReportOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPlYtReportAdd extends BaseUpdate {
	private static final String DATASET_ID ="YtMonitorAcctView";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean yBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TPlYtReport dd = new TPlYtReport();
			OperationContext oc = new OperationContext();
			String duebillno = yBean.getParameter("duebillno");
			if (duebillno!=null) {
				oc.setAttribute(TPlYtReportOperation.IN_PARAM_DUEBILLNO, duebillno);
				oc.setAttribute(TPlYtReportOperation.IN_TASK_SOURCE_TYPE, "USER");
				oc.setAttribute(TPlYtReportOperation.CMD, TPlYtReportOperation.CMD_STARTPROCESS);
				mapToObject(dd,  yBean.next());
			}
			OPCaller.call(TPlYtReportOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
