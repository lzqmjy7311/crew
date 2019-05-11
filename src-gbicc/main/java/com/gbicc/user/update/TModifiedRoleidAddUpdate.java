package com.gbicc.user.update;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.person.supervision.entity.QualitysuPar;
import com.gbicc.person.supervision.operation.QualitysuParOperation;
import com.gbicc.person.supervision.service.QualitysuParService;
import com.gbicc.user.entity.TModifiedRoleid;
import com.gbicc.user.operation.TModifiedRoleidOperation;
import com.gbicc.user.service.TModifiedRoleidService;
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
 * 版本：2015年10月21日 上午11:39:08
 * 类说明：客户新增
 */
public class TModifiedRoleidAddUpdate extends BaseUpdate {
	
	private static final String DATASET_ID = "TModifiedRoleid";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			TModifiedRoleid dd = new TModifiedRoleid();
			OperationContext oc = new OperationContext();
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				String recordState = map.get("recordState").toString();
				if("insert".equals(recordState)) {
					dd = new TModifiedRoleid();
					oc.setAttribute(TModifiedRoleidOperation.CMD, TModifiedRoleidOperation.CMD_INSERT);
				} else if ("modify".equals(recordState)) {
					dd = TModifiedRoleidService.getInstance().get((String) map.get("id"));
					oc.setAttribute(TModifiedRoleidOperation.CMD, TModifiedRoleidOperation.CMD_UPDATE);
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

