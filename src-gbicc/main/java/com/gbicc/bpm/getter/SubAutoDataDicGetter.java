package com.gbicc.bpm.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gbicc.common.CommonService;
import com.gbicc.person.monitor.entity.TPlTask;
import com.gbicc.personCommon.entity.TPlTaskRoutineMoni;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.entity.dao.mng.DataDicDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 重大事件下拉框
 * 2016年1月8日14:30:18
 *
 */
@SuppressWarnings("unchecked")
public class SubAutoDataDicGetter extends BaseGetter {
	
	public Result call() throws CommonException {
		List<DataDic> returnList = new ArrayList<DataDic>();		
		List<DataDic> list = new ArrayList<DataDic>();
		try {
			String businessId = this.getCommQueryServletRequest().getParameter("businessId");
			String dicCodeStr=this.getCommQueryServletRequest().getParameter("dicCode");
			Integer dicCode=Integer.parseInt(dicCodeStr);
			if(StringUtils.isNotEmpty(businessId)){
				list = this.getDicByWhere(businessId,dicCode);
			}else{
				list = this.getDic(dicCode);
			}
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
	public List getDicByWhere(String businessId,Integer dicCode) throws CommonException {
		DataDicDAO dataDicDao = ROOTDAOUtils.getDataDicDAO();
		CommonService service=CommonService.getInstance();
		List list = new ArrayList();
		String hql=" from TPlTask where id='"+businessId+"' ";
		TPlTask task=(TPlTask) service.queryOneHQL(hql);
		String rateHql=" from TPlTaskRoutineMoni where accId='"+task.getLoanAcct()+"' ";
		TPlTaskRoutineMoni routine=(TPlTaskRoutineMoni) service.queryOneHQL(rateHql);
		String sql ="";
		if(routine!=null && routine.getTrigRate()!=null&&routine.getTrigRate()!=0.00){
			 sql = " 1=1 and dataTypeNo="+dicCode+" and dataNo<"+routine.getTrigRate();
		}else{
			sql = " 1=1 and dataTypeNo="+dicCode;
		}
		
		list = dataDicDao.queryByCondition(sql);
		return list;
	}

	@SuppressWarnings("rawtypes")
	public List getDic(Integer dicCode) throws CommonException {
		DataDicDAO dataDicDao = ROOTDAOUtils.getDataDicDAO();
		List list = new ArrayList();
		String sql = " 1=1 and dataTypeNo="+dicCode;
		list = dataDicDao.queryByCondition(sql);
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
