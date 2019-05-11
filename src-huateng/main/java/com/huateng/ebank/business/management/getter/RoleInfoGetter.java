/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.management.getter;


import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.management.operation.RoleInfoOperation;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.view.RoleInfoView;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author fanissac
 * @date 2007-12-14
 * @desc
 */
public class RoleInfoGetter extends BaseGetter {


	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try{

		PageQueryResult pageResult = getData();


			ResultMng.fillResultByList(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					pageResult.getQueryResult(),
					getResult());

			result.setContent(pageResult.getQueryResult());
			if(pageResult.getQueryResult().size() == 0){
				result.getPage().setTotalPage(0);
			}else{
				result.getPage().setTotalPage(1);
			}

			result.init();
		return result;



	}catch(AppException appEx){
		throw appEx;
	}catch(Exception ex){
		throw new AppException(Module.SYSTEM_MODULE,
				Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
	}


	}

    /*
     * (non-Javadoc)
     *
     * @see com.extra.common.ObjectDataGetter#getData()
     */
    protected PageQueryResult getData() throws Exception {

	    //TODO:0保证必须为总行
//	    String head = BctlService.getInstance().getHeadBranch();
//	    String brcode = GlobalInfo.getCurrentInstance().getBrcode();
//	    if(!brcode.equals(head))
//	    {
//	        String message = "只有总行才能进行[岗位权限设置]设置！";
//	        ExceptionUtil.throwCommonException(message);
//	    }
//
    	PageQueryResult pageQueryResult = new PageQueryResult();

		OperationContext oc = new OperationContext();
		oc.setAttribute(RoleInfoOperation.CMD,"SELECT");
		OPCaller.call("parammng.roleInfoOP", oc);
		List roleInfoList = (List)OperationContext.getValue(oc,RoleInfoOperation.OUT_ROLE_LIST);

		List roleInfoViewList = new ArrayList();
		for (int i = 0; i < roleInfoList.size(); i++) {
			RoleInfoView roleInfoView = new RoleInfoView();
			int roleID = ((RoleInfo)roleInfoList.get(i)).getId();
			roleInfoView.setRoleid(String.valueOf(roleID));
			roleInfoView.setRolename(((RoleInfo)roleInfoList.get(i)).getRoleName());
			roleInfoView.setRoletype(((RoleInfo)roleInfoList.get(i)).getRoleType());
			roleInfoView.setEffectDate(((RoleInfo)roleInfoList.get(i)).getEffectDate());
			roleInfoView.setExpireDate(((RoleInfo)roleInfoList.get(i)).getExpireDate());
			//虚拟字段，没有实际意义，给v_id赋值是为了区分该记录是从数据库中取出来的
			roleInfoView.setV_id("1");

//			DataDic dataDic = DAOUtils.getDataDicDAO().query(
//                    SystemConstant.DATADIC_TYPE_ROLE_TYPE,
//                    ((RoleInfo) roleInfoList.get(i)).getRoleType());
//			if(dataDic != null){
//			    roleInfoView.setRoletypename(dataDic.getDataName());
//			}else{
//			    roleInfoView.setRoletypename("");
//			}
////
//
			if(((RoleInfo)roleInfoList.get(i)).getStatus().equals(SystemConstant.VALID_FLAG_INVALID))
				roleInfoView.setStatus(SystemConstant.VALID_FLAG_INVALID);
			else
				roleInfoView.setStatus(SystemConstant.VALID_FLAG_VALID);
			//roleInfoView.setWorkflowrole(((RoleInfo)roleInfoList.get(i)).getWorkflowRole());
			roleInfoViewList.add(roleInfoView);

		}

        if(roleInfoViewList!=null&&roleInfoViewList.size()>0){
        	pageQueryResult.setTotalCount(roleInfoViewList.size());
        }else{
        	pageQueryResult.setTotalCount(0);
        }
        pageQueryResult.setQueryResult(roleInfoViewList);

        return pageQueryResult;
    }
}
