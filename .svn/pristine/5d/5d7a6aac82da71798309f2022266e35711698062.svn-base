package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.management.bean.ChangePwdForm;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author yjw
 * 
 */
public class ChangePwdGetter extends BaseGetter {

	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {

			ChangePwdForm changePwdForm = new ChangePwdForm();
			ResultMng.fillResultByObject(getCommonQueryBean(),
					getCommQueryServletRequest(), changePwdForm, getResult());
			List content = new ArrayList();
			content.add(changePwdForm);
			result.setContent(content);
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
