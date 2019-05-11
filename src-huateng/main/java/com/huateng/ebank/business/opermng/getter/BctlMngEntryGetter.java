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

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import com.gbicc.user.entity.TModifiedRoleid;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.Bctl;
import com.huateng.ebank.entity.data.mng.TlrBctlRel;
import com.huateng.ebank.entity.data.mng.TlrBctlRelView;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author zhiguo.zhao
 *
 */
public class BctlMngEntryGetter extends BaseGetter {

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
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("tlrno");
		String brname = (String) getCommQueryServletRequest().getParameterMap().get("brname");
		String brno = (String) getCommQueryServletRequest().getParameterMap().get("brno");
		
		String op = (String) getCommQueryServletRequest().getParameterMap().get("op");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String roleId=globalInfo.getWorkflowRoleId();
		TModifiedRoleid tmr=new TModifiedRoleid();
		if(!roleId.equals("611")&&!roleId.equals("612")&&!roleId.equals("111")){
			pageSize=30;
		}
		
		PageQueryResult pageQueryResult = new PageQueryResult();
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				"from TlrBctlRel tlrBctl where tlrBctl.tlrNo = '" + tlrno + "'");
		List<TlrBctlRelView> bctlRelViews=new ArrayList<TlrBctlRelView>();
		List<TlrBctlRel> list=pageQueryResult.getQueryResult();
		for(TlrBctlRel t :list){
			TlrBctlRelView view=new TlrBctlRelView();
			BeanUtils.copyProperties(t, view);
			view.setBrNo(t.getBrNo());
			Bctl bt=DAOUtils.getBctlDAO().query(t.getBrNo());
			if(bt!=null){
				view.setBrname(bt.getBrname());
			}
			bctlRelViews.add(view);
		}
		pageQueryResult.setQueryResult(bctlRelViews);
		return pageQueryResult;
	}
}
