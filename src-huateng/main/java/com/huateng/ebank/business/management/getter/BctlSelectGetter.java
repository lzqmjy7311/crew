/**
 *
 */
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
public class BctlSelectGetter extends BaseGetter {

	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			 // 从全局取出机构号
	        String brcode = GlobalInfo.getCurrentInstance().getBrcode();
	        List list = BctlService.getInstance().getAllSubBrcodeList(brcode);
	        ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list,
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

}
