package com.huateng.fp.demo.updater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.exceptions.ValidateError;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.validate.ValidateUtils;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.fp.demo.bean.GroupFields;

public class ValidateUpdate extends BaseUpdate {

	
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("GroupValidateFields");
			
			List updateList = new ArrayList();
			List insertList = new ArrayList();
			List delList = new ArrayList();
			
			GroupFields bean = new GroupFields();
			while (updateResultBean.hasNext()) {
				bean = new GroupFields();
				mapToObject(bean, updateResultBean.next());
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(bean);
					break;
				case UpdateResultBean.DELETE:
					delList.add(bean);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(bean);
					break;
				default:
					break;
				}
			}	  
	     	OperationContext context = new OperationContext();
			//ExceptionUtil.throwCommonException("aaaa");

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	public ValidateError validate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, 
			HttpServletResponse response)throws AppException{
		
  //另外一种写法
/**
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("GroupValidateFields");
		Map map=updateResultBean.next();
		ValidateError errors = new ValidateError();
        if(!ValidateUtils.emailValidator(map,"burl")){
        	errors.add("burl","该选项邮箱地址格式！");
        }
        if(!ValidateUtils.requiredValidator(map,"bnumber")){
        	errors.add("bnumber","该选项为必输项！");
        }
*/
		//批量
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("GroupValidateFields");
		Map map=updateResultBean.next();
		ValidateUtils validateUtils=new ValidateUtils();
		validateUtils.add("burl", "该选项邮箱地址格式！", ValidateUtils.emailValidator(map,"burl"), true);
		validateUtils.add("bnumber", "该选项为必输项！", ValidateUtils.requiredValidator(map,"bnumber"), true);
		ValidateError errors=validateUtils.startAll();
		
		
		
		return errors;				
	}
	
}
