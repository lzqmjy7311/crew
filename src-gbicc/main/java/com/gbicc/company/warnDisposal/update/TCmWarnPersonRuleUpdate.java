package com.gbicc.company.warnDisposal.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.gbicc.company.warnDisposal.entity.TCmWarnPersonRule;
import com.gbicc.company.warnDisposal.operation.TCmWarnPersonRuleOperation;
import com.gbicc.company.warnDisposal.service.TCmWarnPersonRuleService;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class TCmWarnPersonRuleUpdate extends BaseUpdate {
	private static final String DATASET_ID ="TCmWarnPersonRule";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TCmWarnPersonRule dd = new TCmWarnPersonRule();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String id=null;
				String op=updateResultBean.getParameter("op");
				if(map.get("id")!=null){
					id=(String)map.get("id");
				}
				
				if(StringUtils.isNotBlank(id)) {
					if("del".equals(op)){
						dd = TCmWarnPersonRuleService.getInstance().get((String) map.get("id"));
						oc.setAttribute(TCmWarnPersonRuleOperation.CMD,TCmWarnPersonRuleOperation.CMD_DELETE);
					}else{
						dd = TCmWarnPersonRuleService.getInstance().get((String) map.get("id"));
						oc.setAttribute(TCmWarnPersonRuleOperation.CMD,TCmWarnPersonRuleOperation.CMD_UPDATE);
					}
				} else{
					dd = new TCmWarnPersonRule();
					oc.setAttribute(TCmWarnPersonRuleOperation.CMD,TCmWarnPersonRuleOperation.CMD_INSERT);
				}
				mapToObject(dd, map);
				
			}
			oc.setAttribute(TCmWarnPersonRuleOperation.IN_PARAM, dd);
			OPCaller.call(TCmWarnPersonRuleOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
