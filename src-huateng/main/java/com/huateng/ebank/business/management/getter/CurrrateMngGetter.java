package com.huateng.ebank.business.management.getter;

import java.util.HashMap;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.CurrrateMngService;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class CurrrateMngGetter extends BaseGetter {


	@SuppressWarnings("unchecked")
	public Result call() throws AppException {
		try{

			Map param = this.getCommQueryServletRequest().getParameterMap();
			String op = DataFormat.trim(getCommQueryServletRequest().getParameter("op"));
			String id = DataFormat.trim(getCommQueryServletRequest().getParameter("id"));
			String currrateS = DataFormat.trim(getCommQueryServletRequest().getParameter("currrate"));
			String curcd=(String)param.get("curcd");
			String tocurcd = (String) param.get("tocurcd");
			String currrateDate = DataFormat.trim(getCommQueryServletRequest().getParameter("currrateDate"));
			HashMap params=new HashMap();
			PageQueryResult pageresult = new PageQueryResult();
			int index=result.getPage().getCurrentPage();
			int pagesize=result.getPage().getEveryPage();
			if(!"add".equals(op)){
				params.put("id", id);
				params.put("curcd", curcd==null?"":curcd.trim());
				params.put("currrate", currrateS);
				params.put("currrateDate", currrateDate);
				params.put("tocurcd", tocurcd);
				pageresult=CurrrateMngService.getInstance().findCurrrateByParams(index, pagesize, params);
			}
			ResultMng.fillResultByList(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					pageresult.getQueryResult(),
					getResult());
			result.setContent(pageresult.getQueryResult());
			result.getPage().setTotalPage(pageresult.getPageCount(pagesize));
			result.init();

			return result;

		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}


}
