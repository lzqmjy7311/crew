package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.bean.SysCurrencyBean;
import com.huateng.ebank.entity.data.mng.Currency;
import com.huateng.ebank.entity.data.mng.SysCurrency;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.utils.ReportEnum;


/**
 * Get the dropdown's data from DB with HQL and full the dataset to dropdown
 * @author cwenao
 * 2012-8-13
 */


@SuppressWarnings("unchecked")
public class CurrencySelectGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			StringBuffer hql = new StringBuffer(" FROM SysCurrency sc WHERE lock = '"+ReportEnum.REPORT_REC_LOCK_DEL.F.value+"' AND del = '"+ReportEnum.REPORT_REC_LOCK_DEL.F.value+"' ");
			PageQueryCondition queryCondition = new PageQueryCondition();
			Page page = result.getPage();
			String value=getCommQueryServletRequest().getParameter("value1");
			if(value!=null&&!value.equals("")){
				value = StringUtils.upperCase(value);
				hql.append(" AND sc.id like '%"+value+"%'");
			}
			hql.append(" ORDER BY sc.showSeq");
			queryCondition.setQueryString(hql.toString());
			queryCondition.setPageSize(page.getEveryPage());
			queryCondition.setPageIndex(page.getCurrentPage());
			PageQueryResult pageResult = DAOUtils.getHQLDAO().pageQueryByQL(queryCondition);
			Iterator it = pageResult.getQueryResult().iterator();
			List list = new ArrayList();
			SysCurrencyBean vo=null;
			for (; it.hasNext();) {
				vo=new SysCurrencyBean();
				Object[] resultsObj = (Object[]) it.next();
				SysCurrency bean = (SysCurrency) resultsObj[0];
				BeanUtils.copyProperties(vo,bean);
				vo.setCurcdName(getCcyNoAndCurrNm(bean));
				list.add(vo);
			}
			pageResult.setQueryResult(list);

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());
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

	protected String getCcyNoAndCurrNm(SysCurrency vo) {
		String ccyNo = DataFormat.trim(vo.getId());
		String currNm = DataFormat.trim(vo.getCnname());

		if (StringUtils.isEmpty(ccyNo) && StringUtils.isEmpty(currNm)) {
			return "";
		}
		return ccyNo + "-" + currNm;
	}
}