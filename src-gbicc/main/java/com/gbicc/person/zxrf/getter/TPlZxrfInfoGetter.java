package com.gbicc.person.zxrf.getter;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gbicc.person.zxrf.entity.TPlZxrfInfo;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.service.TlrInfoService;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 
 * @author liufei
 *
 * 版本：2015年11月12日 上午17:41:00
 * 类说明：中小融辅 查询类
 */
@SuppressWarnings("unchecked")
public class TPlZxrfInfoGetter extends BaseGetter {

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
		
		String businessId = (String) getCommQueryServletRequest().getParameterMap().get("businessId");
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo info=GlobalInfo.getCurrentInstance();
		StringBuffer hql = new StringBuffer("from TPlZxrfInfo t where 1=1 and t.id=(select reportId from TPlReportRelation where businessId='"+businessId+"') ");
		PageQueryResult pageQueryResult = new PageQueryResult();
		if(StringUtils.isNotEmpty(businessId)){
			pageQueryResult = rootdao.pageQueryByHql(pageIndex,pageSize,hql.toString());
			
			List list=pageQueryResult.getQueryResult();
			for (int i = 0; i < list.size(); i++) {
				TPlZxrfInfo tci=(TPlZxrfInfo)list.get(i);
				if(tci.getLeadInvestigator()==null){
					tci.setLeadInvestigator(info.getTlrno());
					tci.setSurveydate(new Date());
				}
				if(tci.getOperator()!=null){
					TlrInfo tlrInfo = TlrInfoService.getInstance().getTlrInfoByTlrno(tci.getOperator());
					if(tlrInfo!=null){
						tci.setOperatorNam(tlrInfo.getTlrName());
					}
				}
				if(tci.getOperBank()!=null){
					tci.setOperBankNam(BctlService.getInstance().getBranchName(tci.getOperBank()));
				}
			}
		}
		return pageQueryResult;
	}
	
}
