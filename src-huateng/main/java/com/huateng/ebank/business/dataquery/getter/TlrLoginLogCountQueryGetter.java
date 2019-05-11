package com.huateng.ebank.business.dataquery.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.DateUtil;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.dataquery.bean.TlrLoginLogCount;
import com.huateng.ebank.business.management.service.TlrLoginLogService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class TlrLoginLogCountQueryGetter  extends BaseGetter{



	@Override
	public Result call() throws AppException {
		try {
			CommonFunctions comm =CommonFunctions.getInstance();
			PageQueryResult pageResult = getData();
		    List<Object[]> list=pageResult.getQueryResult();
		    List  list1=new ArrayList();
		    TlrLoginLogCount  tllc=null;
		    Iterator it=list.iterator();
		   while(it.hasNext()){
			     tllc=new TlrLoginLogCount();
			     Object[] ject=(Object[]) it.next();
			     tllc.setTlrno((String) ject[0]);
			     tllc.setBrno((String)ject[1]);
			     tllc.setCount( Integer.parseInt(ject[2].toString()));
			     tllc.setEndDate(null!=ject[3]?ject[3].toString():"");
			     tllc.setStartDate(null!=ject[4]?ject[4].toString():"");


			 

			     list1.add(tllc);
		   }





			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list1,
					getResult());
			getResult().setContent(pageResult.getQueryResult());
			getResult().getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			getResult().init();
			return getResult();
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();

		String qtlrNo = (String) getCommQueryServletRequest().getParameterMap().get("qtlrNo");
		String qbrNo = (String) getCommQueryServletRequest().getParameterMap().get("qbrNo");
		String startDate = (String) getCommQueryServletRequest().getParameterMap().get("startDate");
		String endDate = (String) getCommQueryServletRequest().getParameterMap().get("endDate");
		if(startDate!=null&&endDate!=null){
			if(DateUtil.comparaDate(endDate,startDate)){
			ExceptionUtil.throwCommonException("开始日期大于结束日期！",
					ErrorCode.ERROR_CODE_OVER_HEAD);
			}

		}

		GlobalInfo info = GlobalInfo.getCurrentInstance();
		TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
		return tlrLoginLogService.queryTlrLogDetail(pageIndex, pageSize, qtlrNo, qbrNo, startDate, endDate);
	}


	
}
