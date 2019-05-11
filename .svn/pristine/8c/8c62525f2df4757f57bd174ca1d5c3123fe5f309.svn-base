package com.gbicc.company.single.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.company.single.entity.TCmSingleRulCasesDutyinfo;
import com.gbicc.company.single.operation.TCmSingleRulCasesDutyinfoOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCmSingleRulCasesDutyinfoUpdate extends BaseUpdate {
	
	private static final String DATASET_ID ="SingleRulCasesDutyinfo";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			OperationContext oc = new OperationContext();
			List<TCmSingleRulCasesDutyinfo> list=new ArrayList<TCmSingleRulCasesDutyinfo>();
			while (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				TCmSingleRulCasesDutyinfo dutyinfo = new TCmSingleRulCasesDutyinfo();
				mapToObject(dutyinfo, map);
				list.add(dutyinfo);
			}
			oc.setAttribute("list",list);
			oc.setAttribute("casesId",updateResultBean.getParameter("casesId"));
			OPCaller.call(TCmSingleRulCasesDutyinfoOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
