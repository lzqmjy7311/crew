package com.gbicc.bpm.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gbicc.bpm.entity.ProcessName;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 流程名称下拉框
 * 2016年1月8日14:30:18
 *
 */
@SuppressWarnings("unchecked")
public class SubAutoProcessNameGetter extends BaseGetter {
	
	public Result call() throws CommonException {
		List<ProcessName> returnList = new ArrayList<ProcessName>();		
		List<ProcessName> list = new ArrayList<ProcessName>();
		try {
			String roleType = this.getCommQueryServletRequest().getParameter("roleType");
			list = this.getProcessNames(roleType);
			returnList = getList(list);
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(),returnList,getResult());
		} catch (AppException e) {
			e.printStackTrace();
		}
		result.setContent(returnList);
		int pageSize = result.getPage().getEveryPage();
		int pageCount = (list.size() - 1) / pageSize + 1;
		result.getPage().setTotalPage(pageCount);
		result.init();
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public List getProcessNames(String roleType) throws CommonException {
		List<ProcessName> list=new ArrayList<ProcessName>();
		String sql="select distinct name_ from act_re_procdef where substr(key_,1,2)='"+roleType+"' ";
		Iterator it=ROOTDAOUtils.getROOTDAO().queryBySQL(sql);
		while(it.hasNext()){
			String str=(String) it.next();
			ProcessName pn=new ProcessName();
			pn.setId(str);
			pn.setProcId(str);
			pn.setProcName(str);
			list.add(pn);
		}
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List getList(List list) {
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		int startRow = (pageIndex - 1) * pageSize;
		int endRow = startRow + pageSize;
		List tlrs = new ArrayList();
		if (list != null && !list.isEmpty()) {
			for (; startRow < endRow; startRow++) {
				tlrs.add(list.get(startRow));
				if (startRow == list.size() - 1) {
					break;
				}
			}
		}
		return tlrs;
	}
}
