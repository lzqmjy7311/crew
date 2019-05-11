package com.huateng.ebank.business.datadic.service;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.data.mng.DataDic;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;

public class DataDicService {

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}

	public DataDic load(String id) {
		return DAOUtils.getDataDicDAO().findById(id);
	}

	public void delete(String id) {
		DAOUtils.getDataDicDAO().delete(load(id));
	}

	public void save(DataDic dd) {
		DAOUtils.getDataDicDAO().save(dd);
	}

	public void update(DataDic dd) throws CommonException {
		DAOUtils.getDataDicDAO().update(dd);
	}

}
