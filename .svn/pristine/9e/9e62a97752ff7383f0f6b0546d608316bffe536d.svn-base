package com.huateng.ebank.business.datadic.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class DataDicTreeSelectGetter extends BaseGetter {
	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
//			result.getPage().setTotalPage(
//					pageResult.getPageCount(getResult().getPage()
//							.getEveryPage()));
			result.getPage().setTotalPage(0);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}
	
	private PageQueryResult getData() throws CommonException {

		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer("select dd from DataDic dd where 1=1");
		
		String headDataTypeNo = getCommQueryServletRequest().getParameter("headDataTypeNo");
//		String levelStr = getCommQueryServletRequest().getParameter("_level_");
		String pid = getCommQueryServletRequest().getParameter("_id");
		
		PageQueryResult queryresult = null;
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(StringUtils.isNotEmpty(headDataTypeNo) && StringUtils.isBlank(pid)) {
			hql.append(" and dd.dataTypeNo=").append(headDataTypeNo);
			List<DataDic> dataDics = rootdao.queryByQL2List(hql.toString());
			for(DataDic dd : dataDics){
				TreeNode dicTreeBean = new TreeNode();
				dicTreeBean.setAttributes(dd);
				dicTreeBean.setId(dd.getMiscflgs());
				dicTreeBean.setText(dd.getDataName());
//				dicTreeBean.setName(dd.getDataName());
//				dicTreeBean.setLevel(1);
				if (StringUtils.isNotEmpty(dd.getMiscflgs())) {
					dicTreeBean.setHasChild(true);
					dicTreeBean.setCanSelected(false);
//					dicTreeBean.setPid(dd.getMiscflgs());
				} else {
					dicTreeBean.setId(dd.getDataNo());
					dicTreeBean.setHasChild(false);
					dicTreeBean.setCanSelected(true);
				}
				list.add(dicTreeBean);
			}
		} else {
			hql.append(" and dd.dataTypeNo=").append(pid);
			List<DataDic> dataDics = rootdao.queryByQL2List(hql.toString());
			for(DataDic dd : dataDics){
				TreeNode dicTreeBean = new TreeNode();
				dicTreeBean.setAttributes(dd);
				dicTreeBean.setId(dd.getMiscflgs());
				dicTreeBean.setText(dd.getDataName());
//				dicTreeBean.setName(dd.getDataName());
//				dicTreeBean.setLevel(level);
				if (StringUtils.isNotEmpty(dd.getMiscflgs())) {
					dicTreeBean.setHasChild(true);
					dicTreeBean.setCanSelected(false);
//					dicTreeBean.setPid(dd.getMiscflgs());
				} else {
					dicTreeBean.setId(dd.getDataNo());
					dicTreeBean.setHasChild(false);
					dicTreeBean.setCanSelected(true);
				}
				list.add(dicTreeBean);
			}
		}
		queryresult = new PageQueryResult();
		queryresult.setQueryResult(list);
		queryresult.setTotalCount(list.size());
		
		return queryresult;
	}
}
