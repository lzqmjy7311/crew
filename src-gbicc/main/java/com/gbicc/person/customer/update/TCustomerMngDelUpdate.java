package com.gbicc.person.customer.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gbicc.person.customer.entity.TCustomer;
import com.gbicc.person.customer.opration.TCustomerMngOperation;
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
 * @author xudongdong
 *
 * 版本：2015年10月21日 上午11:40:52
 * 类说明：客户删除
 */
public class TCustomerMngDelUpdate extends BaseUpdate {
	private static final String DATASET_ID = "TCustomerEntry";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			//返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			//结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			//数据字典类
			TCustomer dd = new TCustomer();
			//Operation的参数
			OperationContext oc = new OperationContext();
			//结果集中是否有数据
			if (updateResultBean.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map map = updateResultBean.next();
				oc.setAttribute(TCustomerMngOperation.CMD, TCustomerMngOperation.CMD_DELETE);
				//属性拷贝 map -> bean
				mapToObject(dd, map);
			}
			oc.setAttribute(TCustomerMngOperation.IN_PARAM, dd);
			//必须以OPCaller.call的方式调用Operation类,是因为事务是封装在OP层
			OPCaller.call(TCustomerMngOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
