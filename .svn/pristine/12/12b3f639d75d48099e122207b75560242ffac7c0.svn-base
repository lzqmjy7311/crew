package com.huateng.ebank.business.management.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author yjw
 *
 */
public class AllDownBrcodeSelectGetter extends BaseGetter {


	public Result call() throws AppException {
		try {
			/* mod by kangbyron  方法实现和方法名对不上 begin*/
			String currentCode = GlobalInfo.getCurrentInstance().getBrcode();
			//List list = BctlService.getInstance().getAllDownBrcodeList(currentCode);
			List list = BctlService.getInstance().getAllEnableBctl();
			/* mod by kangbyron  方法实现和方法名对不上 end*/
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list, getResult());
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

}
