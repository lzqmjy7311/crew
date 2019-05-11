package com.gbicc.warn.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.warn.entity.TWarnDisposalRep;
import com.gbicc.warn.entity.TWarnSignal;
import com.gbicc.warn.operation.TWarnDisposalRepOperation;
import com.gbicc.warn.service.TWarnDisposalRepService;
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
 * @author likm
 * @time   2015年10月27日16:07:37
 * @desc   产品保存
 */
public class TWarnDisposalRepUpdate extends BaseUpdate {
	private static final String DATASET_ID = "plWarnDisposalRep";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TWarnDisposalRep TWarnDisposalRep = new TWarnDisposalRep();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String recordState = map.get("recordState").toString();
				if("insert".equals(recordState)) {
					TWarnDisposalRep = new TWarnDisposalRep();
					oc.setAttribute(TWarnDisposalRepOperation.CMD, TWarnDisposalRepOperation.CMD_INSERT);
				} else if ("modify".equals(recordState)) {
					TWarnDisposalRep = TWarnDisposalRepService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TWarnDisposalRepOperation.CMD,TWarnDisposalRepOperation.CMD_UPDATE);
				}
				
				String warnCode= map.get("warnCode").toString();
				String affPerDesc= map.get("affPerDesc").toString();
				String warnLEvel= map.get("warnLEvel").toString();
				String checkStatus= map.get("checkStatus").toString();
				String checkDesc= map.get("checkDesc").toString();
				TWarnSignal tWarnSignal=new TWarnSignal();
				tWarnSignal.setWarnCode(warnCode);
				tWarnSignal.setAffPerDesc(affPerDesc);
				tWarnSignal.setCheckStatus(checkStatus);
				tWarnSignal.setCheckDesc(checkDesc);
				mapToObject(TWarnDisposalRep,map);
				TWarnDisposalRep.setWarnSignalId(tWarnSignal);
		
			}
			oc.setAttribute(TWarnDisposalRepOperation.IN_PARAM,TWarnDisposalRep);
			OPCaller.call(TWarnDisposalRepOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
