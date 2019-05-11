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

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.management.bean.PosiNameCheckBean;
import com.huateng.ebank.entity.dao.mng.RoleInfoDAO;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * Title:
 * Copyright (c) 2006 Company: Shanghai Huateng
 * Software Systems Co., Ltd.
 *
 * @author haizhou.li
 * @version v1.0,2010-11-20
 */
public class PosiNameCheckGetter extends BaseGetter {
	public Result call() throws AppException {
		try {
			//岗位名称
			String roleName = this.commQueryServletRequest.getParameter("roleName");

			RoleInfoDAO dao = BaseDAOUtils.getRoleInfoDAO();
			PosiNameCheckBean bean = new PosiNameCheckBean();
			if(!StringUtils.isEmpty(roleName))
			{
				/* 岗位名称是否存在 */
				List list = new ArrayList();
				list = dao.queryByCondition("po.roleName=?", new Object[] { roleName },null);
				if (list.size() > 0) {
					bean.setFlag("true"); // ture表示表中已有该岗位名称
				}else{
					bean.setFlag("false"); // false表示表中没有该岗位名称
				}
			}

			ResultMng.fillResultByObject(getCommonQueryBean(),
					getCommQueryServletRequest(), bean, getResult());
			result.init();
			return getResult();
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

}
