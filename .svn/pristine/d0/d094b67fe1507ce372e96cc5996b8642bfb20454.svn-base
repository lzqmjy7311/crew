/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.parammng.cqGetter;


import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.parammng.TellerService;
import com.huateng.ebank.business.parammng.bean.TlrRoleInfoView;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.entity.data.mng.TlrRoleRel;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author fanissac
 * @date 2007-12-14
 * @desc
 */
public class TlrInfo2Getter extends BaseGetter {


	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try{

			OperationContext oc = new OperationContext();
			TlrInfo	tlrInfo = new TlrInfo();
			String action = (String)getCommQueryServletRequest().getParameterMap().get("action");
			BeanUtilsEx(tlrInfo,getCommQueryServletRequest().getParameterMap());
			PageQueryResult pageResult = new PageQueryResult();
			if(action==null)action=null;
			//操作员查询的时候
			if(action!=null&&action.equals("query")){
				BeanUtilsEx(tlrInfo,getCommQueryServletRequest().getParameterMap());
				pageResult = getData(tlrInfo);
			//新增操作员的时候
			}else{
				String brcode = getValueFromDataBus("brcode");
				String tlrno = getValueFromDataBus("tlrno");
				tlrInfo.setBrcode(brcode);
				tlrInfo.setTlrno(tlrno);
				tlrInfo.setStatus(SystemConstant.VALID_FLAG_VALID);//有效
				pageResult = getData2(tlrInfo);
			}

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
     * 查询的时候调用
     * (non-Javadoc)
     *
     * @see com.extra.common.ObjectDataGetter#getData()
     */
    protected PageQueryResult getData(TlrInfo tlrInfo) throws Exception {

    	PageQueryResult pageQueryResult = new PageQueryResult();
		List tlrRoleInfoList = new ArrayList();
		List roleInfoList = DAOUtils.getRoleInfoDAO().queryByCondition("1=1");
		List tlrRoleList = TellerService.getInstance().getTellerRoleList(tlrInfo.getTlrno());
		for(int i = 0; i < roleInfoList.size(); i ++) {
			RoleInfo roleInfo = (RoleInfo) roleInfoList.get(i);
			TlrRoleInfoView view = new TlrRoleInfoView();
			view.setTlrno(tlrInfo.getTlrno());
			view.setRoleid(roleInfo.getId());
			view.setRolename(roleInfo.getRoleName());
			view.setSelect1(false);
			for(int j = 0; j < tlrRoleList.size(); j ++) {
				TlrRoleRel relation = (TlrRoleRel) tlrRoleList.get(j);
				if(view.getRoleid() == relation.getRoleId()) {
					view.setSelect1(true);
				}
			}
			tlrRoleInfoList.add(view);
		}
		this.getHttpReq().setAttribute("tlrInfo", tlrInfo);
        if(tlrRoleInfoList!=null&&tlrRoleInfoList.size()>0){
        	pageQueryResult.setTotalCount(tlrRoleInfoList.size());
        }else{
        	pageQueryResult.setTotalCount(0);
        }
        pageQueryResult.setQueryResult(tlrRoleInfoList);

        return pageQueryResult;
    }

    /*
     * 新增的时候调用
     * (non-Javadoc)
     *
     * @see com.extra.common.ObjectDataGetter#getData()
     */
    protected PageQueryResult getData2(TlrInfo tlrInfo) throws Exception {
    	PageQueryResult pageQueryResult = new PageQueryResult();
		List tlrRoleInfoList = new ArrayList();
		List roleInfoList = DAOUtils.getRoleInfoDAO().queryByCondition("1=1");
		for(int i = 0; i < roleInfoList.size(); i ++) {
			RoleInfo roleInfo = (RoleInfo) roleInfoList.get(i);
			TlrRoleInfoView view = new TlrRoleInfoView();
			view.setTlrno(tlrInfo.getTlrno());
			view.setRoleid(roleInfo.getId());
			view.setRolename(roleInfo.getRoleName());
			view.setSelect1(false);
			tlrRoleInfoList.add(view);
		}
        if(tlrRoleInfoList!=null&&tlrRoleInfoList.size()>0){
        	pageQueryResult.setTotalCount(tlrRoleInfoList.size());
        }else{
        	pageQueryResult.setTotalCount(0);
        }
        pageQueryResult.setQueryResult(tlrRoleInfoList);
        return pageQueryResult;
    }
}


