package com.huateng.ebank.business.management.updater;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.management.bean.DelayDtlView;
import com.huateng.ebank.business.management.operation.DelayOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class DelayUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// TODO Auto-generated method stub
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("delay");
			DelayDtlView cbiv = null ;
			while (updateResultBean.hasNext())
			 {
				cbiv = new DelayDtlView();
				Map map = new HashMap();
				map = updateResultBean.next();
				mapToObject(cbiv,map );
			  }
			String value=getData(cbiv);
			OperationContext oc = new OperationContext();
			oc.setAttribute(DelayOperation.IN_PARAM_VALUE,value);
			OPCaller.call("manager.DelayOperation", oc);

			Boolean  flag=(Boolean) oc.getAttribute(DelayOperation.OUT_PARAM);

			if(flag==true)
			{
			}
			else
			{
				throw new CommonException("存储错误！");
			}


			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}


	public String getData(DelayDtlView cbiv) throws CommonException
	{

		String value="";
		String dalayType=cbiv.getDelaytype();
		boolean check1=cbiv.isCheck1();
		boolean check2=cbiv.isCheck2();
		boolean check3=cbiv.isCheck3();
		String delaydays=cbiv.getDelaydays();

		if(SystemConstant.DELAYTYPE_2.equals(dalayType))
		{
			value="C|3|N";
		}
		if(SystemConstant.DELAYTYPE_1.equals(dalayType))
		{
			if(check1== true)
				value = value + "Y";
			else
				value = value + "N";
			if(check2== true)
			{
				if(delaydays.equals(""))
				{
					throw new CommonException("请输入顺延天数！");
				}
				else
					value = value + "|"+delaydays;
			}
			else
			{

				value = value + "|0";

			}
			if(check3 == true)
				value = value + "|Y";
			else
				value = value + "|N";

		}


		return value;
	}
}
