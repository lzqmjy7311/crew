package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.entity.dao.mng.RoleInfoDAO;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @Description:
 * @Package: com.huateng.ebank.business.management.getter
 * @author: fubo
 * @date: 2010-8-3 下午07:25:28
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class RoleFuncRelMngGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		
		String id=getCommQueryServletRequest().getParameter("id");
		String st=getCommQueryServletRequest().getParameter("st");
		String tskId=getCommQueryServletRequest().getParameter("tskId");
		String op=getCommQueryServletRequest().getParameter("op");
		
		List list = new ArrayList();
		
		if(id==null||id.equals("")){
			id="0";
		}
	
		
			
		Integer roleId = Integer.parseInt(id);
		RoleInfoDAO roleInfoDAO = DAOUtils.getRoleInfoDAO();
		RoleInfo roleInfo = roleInfoDAO.findById(roleId);
		
		
		
		ResultMng.fillResultByObject(this.commonQueryBean,getCommQueryServletRequest(), roleInfo, getResult());

		List content = new ArrayList();
		getResult().setContent(content);
		getResult().init();

		return getResult();
	}

}
