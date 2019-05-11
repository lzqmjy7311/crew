package com.huateng.ebank.business.parammng.cqGetter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.data.mng.RoleInfo;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 操作员增加时 为操作员查询当前所有有效岗位
 *
 * @author hyurain_yang
 *
 */
public class AllRoleSelectGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			Page page = result.getPage();
			PageQueryCondition pqc = new PageQueryCondition();
			pqc.setPageIndex(page.getCurrentPage());
			pqc.setPageSize(page.getEveryPage());
			pqc.setQueryString(" from RoleInfo po where po.status = '"+SystemConstant.FLAG_ON+"' order by po.id");
			PageQueryResult pageResult = DAOUtils.getHQLDAO().pageQueryByQL(pqc);
			
			List list = new ArrayList();
			Iterator it = pageResult.getQueryResult().iterator();
			
			for (; it.hasNext();) {
				Object[] resultsObj = (Object[]) it.next();
				RoleInfo bean = (RoleInfo)resultsObj[0];
				bean.setRoleName(bean.getId()+"-"+bean.getRoleName());
				list.add(bean);
			}
			
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(),pageResult.getQueryResult(), getResult());
			result.setContent(pageResult.getQueryResult());
			if (pageResult.getQueryResult().size() == 0) {
					result.getPage().setTotalPage(0);
			} else {
				result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			}
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}
}
