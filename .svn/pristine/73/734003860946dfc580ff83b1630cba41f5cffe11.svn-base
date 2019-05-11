/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.opermng.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.approve.bean.TlrInfoAuditBean;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.TlrInfoDAO;
import com.huateng.ebank.entity.data.mng.SysTaskLog;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;

/**
 * @author zhiguo.zhao
 * 
 */
public class OperMngModComGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());

			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	protected PageQueryResult getData() throws Exception {
		PageQueryResult result = new PageQueryResult();
		String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("id");
		String st = (String) getCommQueryServletRequest().getParameterMap().get("st");
		String flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
		String tskId = (String) getCommQueryServletRequest().getParameter("tskId");
		List list = new ArrayList();
		if(flag.equals("0")){
			TlrInfoDAO tlrInfoDao = DAOUtils.getTlrInfoDAO();
			TlrInfo tlrInfo = tlrInfoDao.query(tlrno);
			list.add(tlrInfo);
			result.setQueryResult(list);
			result.setTotalCount(1);
			return result;
		}
		if(flag.equals("1")){
			ReportTaskUtil rt=new ReportTaskUtil();
			SysTaskLog  systasklog=ReportShowDetailService.getInstance().selectTaskLog(tskId);
			TlrInfoAuditBean oldValue = null;
			if(systasklog.getOldVal1()!=null){
				oldValue=(TlrInfoAuditBean)rt.getOldObjectByTaskLog(systasklog);	  
			}
			if(oldValue != null){
				TlrInfo tlrInfo = oldValue.getTlrInfo();
				list.add(tlrInfo);
				result.setQueryResult(list);
				result.setTotalCount(1);
				return result;
			}
		}
		return result;
	}
}
