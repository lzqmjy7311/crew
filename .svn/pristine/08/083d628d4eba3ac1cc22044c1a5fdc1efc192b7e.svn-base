package com.gbicc.company.financial.analysis.getter;

import org.springframework.util.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class TCmFinanceIndexCdGetter extends BaseGetter {
	private static String outindexType="39";
	private static String indexCd="('3100001','3100002','3100003','3100004','3100005','3100006','3100007','3100008','3100009',"
			+ "'3200001','3200002','3200003','3200004','3200005','3200007','3200010','3200012','3200013','3300009'"
			+",'3400001','3400002','3400003','3400004','3400006','3400009','3400015','3400016',"
			+ "'3400017','3400018','3400019','3400020','3400021','3400022','3400023','3400024','3600001','3600003'"
			+",'3600005','3600011','3600012','3700002','3700003','3700006','3700007','3800001','3800002',"
			+ "'3800003','3800005','3800009','3800010','3400025','3400026','3400027','3400028','3400029','3400030','3400031')";

	@Override
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
		String id = (String) getCommQueryServletRequest().getParameterMap()
				.get("id");
		String caliber = (String) getCommQueryServletRequest().getParameterMap()
				.get("caliber");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String indexTemp="''";
		if("0".equals(caliber)){
			indexTemp="'3400025','3400026','3400028','3400027','3400029','3400030','3400031'";
		}else{
			indexTemp="''";
		}
		//20160701更新，修改财务分析指标科目条件的展示
		StringBuffer hql = new StringBuffer("from TCmFinanceIndexCd t where 1=1  and t.indexType<>'"+outindexType+"' "
				+ "and t.indexCd in "+indexCd);
		if(StringUtils.hasText(id)){
			hql.append(" and id = '"+id+"'");
		}
		if(StringUtils.hasText(caliber)){
			hql.append(" and t.indexCd not in ("+indexTemp+")");
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,
				hql.toString());
		return pageQueryResult;
	}
}
