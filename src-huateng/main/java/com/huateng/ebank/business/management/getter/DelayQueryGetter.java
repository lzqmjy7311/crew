package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.management.bean.DelayDtlView;
import com.huateng.ebank.entity.data.mng.PfSysParam;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class DelayQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			DelayDtlView cbiv = new DelayDtlView();
			DelayDtlView cbiv1=new DelayDtlView();
			BeanUtilsEx(cbiv, getCommQueryServletRequest().getParameterMap());
			cbiv.setCheck1(false);
			cbiv.setCheck2(false);
			cbiv.setCheck3(false);
			PfSysParam param = DAOUtils.getPfSysParamDAO().query("DELAY", "100");
            cbiv1=getData(cbiv,param.getParamValueTx());
            List list=new ArrayList();
            list.add(cbiv1);
            ResultMng.fillResultByObject(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					cbiv1,
					getResult());
			result.setContent(list);
			result.getPage().setTotalPage(1);
			result.init();
         return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}



	public DelayDtlView getData(DelayDtlView cbiv,String value)
	{

		String[] strArray=value.split("\\|");
		if( "Y".equals(strArray[0]))
		{
			cbiv.setDelaytype("1");
			cbiv.setCheck1(true);
			if("0".equals(strArray[1]) )
			{
				cbiv.setCheck2(false);

			}
			else
			{
				cbiv.setCheck2(true);
				cbiv.setDelaydays(strArray[1]);

			}
			if("Y".equals(strArray[2]) )
			{
				cbiv.setCheck3(true);
			}
			if("N".equals(strArray[2]) )
			{
				cbiv.setCheck3(false);
			}
		}
		if( "N".equals(strArray[0]))
		{
			cbiv.setDelaytype("1");
			cbiv.setCheck1(false);

			if("0".equals(strArray[1]) )
			{
				cbiv.setCheck2(false);
			}
			else
			{
				cbiv.setCheck2(true);
				cbiv.setDelaydays(strArray[1]);
			}
			if("Y".equals(strArray[2]))
			{
				cbiv.setCheck3(true);
			}
			if("N".equals(strArray[2]) )
			{
				cbiv.setCheck3(false);
			}
		}
		if( "C".equals(strArray[0]))
		{
			cbiv.setDelaytype("2");
		}
		if( "A".equals(strArray[0]))
		{
			cbiv.setDelaytype("2");
		}


		return cbiv;
	}
}
