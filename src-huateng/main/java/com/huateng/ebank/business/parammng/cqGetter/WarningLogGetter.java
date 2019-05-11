package com.huateng.ebank.business.parammng.cqGetter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.Type;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author liu_yxun
 * @version
 */
public class WarningLogGetter extends BaseGetter {

/**
 * @return Result
 */
	public Result call() throws AppException {
		// TODO Auto-generated method stub
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
/**
 * 获取分页显示的信息
 * @return PageQueryResult
 * @throws Exception
 */
	protected PageQueryResult getData() throws Exception {

		PageQueryResult pageQueryResult = new PageQueryResult();

		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();

		PageQueryCondition condition = new PageQueryCondition();
		condition.setPageIndex(pageIndex);
		condition.setPageSize(pageSize);
		StringBuffer sql = new StringBuffer(
				"select po from BhWarningLog po where 1=1");
		List typeList = new ArrayList();
		List objList = new ArrayList();

        //获取查询条件的字段名和相应的数据类型
		Type[] types = (Type[]) typeList.toArray(new Type[0]);
		Object[] objs = objList.toArray();

		condition.setQueryString(sql.toString());
		condition.setObjArray(objs);
		condition.setTypeArray(types);
        //执行分页查询操作
		PageQueryResult result = DAOUtils.getHQLDAO().pageQueryByQL(condition);

		if (result.getQueryResult() == null
				|| result.getQueryResult().isEmpty()) {
			ExceptionUtil.throwCommonException("没有符合条件的信息",
					ErrorCode.ERROR_CODE_RECORD_NOTFOUND);
		}
		return result;
	}

}
