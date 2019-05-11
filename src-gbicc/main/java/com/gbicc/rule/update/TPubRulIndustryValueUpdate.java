package com.gbicc.rule.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.rule.entity.TPubRulIndustryValue;
import com.gbicc.rule.operation.TPubRulIndustryValueOperation;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TPubRulIndustryValueUpdate extends BaseUpdate {
	
	private static final String DATASET_ID = "TPubRulIndustryValueDtl";
	
	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			String op = updateResultBean.getParameter("op");
			OperationContext oc = new OperationContext();
			List<TPubRulIndustryValue> list=new ArrayList<TPubRulIndustryValue>();
			while(updateResultBean.hasNext()){
				TPubRulIndustryValue value=new TPubRulIndustryValue();
				Map map = updateResultBean.next();
				mapToObject(value,map);
				list.add(value);
			}
			oc.setAttribute("list",list);
			oc.setAttribute("op",op);
			OPCaller.call(TPubRulIndustryValueOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
