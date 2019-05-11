package com.gbicc.person.customer.getter;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gbicc.person.customer.entity.GreatEvent;
import com.gbicc.person.customer.entity.TPlCustGreatEventDtl;
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
public class TPlCustGreatEventDtlGetter extends BaseGetter {

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

	@SuppressWarnings("rawtypes")
	protected PageQueryResult getData() throws Exception {
		String custId = (String) getCommQueryServletRequest().getParameterMap().get("custId");
		String eventId = (String) getCommQueryServletRequest().getParameterMap().get("eventId");
		PageQueryResult pageQueryResult = new PageQueryResult();
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer hql = new StringBuffer("from TPlCustGreatEventDtl t where 1=1 ");
		if(StringUtils.hasText("eventId")){
			hql.append(" and eventId='"+eventId+"' ");
		}else{
			if(StringUtils.hasText(custId)){
				hql.append(" and eventId=(select id from TPlCustGreatEvent where custId='"+custId+"' and TO_DATE(registerDate,'yyyy-mm-dd')='"+simple.format(new Date())+"') ");
			}else{
				hql.append(" and 1=2 ");
			}
		}
		pageQueryResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		List list=pageQueryResult.getQueryResult();
		GreatEvent ge=new GreatEvent();
		//目前只有10来个字段，pageSize设置100已足够
		for(int i=0;i<list.size();i++){
			TPlCustGreatEventDtl dtl=(TPlCustGreatEventDtl) list.get(i);
			String _t=dtl.getEventName();
			Method method=GreatEvent.class.getDeclaredMethod("set"+_t.substring(0,1).toUpperCase()+_t.substring(1), String.class);
			try {
				method.invoke(ge, dtl.getEventValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Method method2=GreatEvent.class.getDeclaredMethod("set"+_t.substring(0,1).toUpperCase()+_t.substring(1)+"Desc", String.class);
			try {
				method2.invoke(ge, dtl.getEventDesc());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<GreatEvent> l=new ArrayList<GreatEvent>();
		l.add(ge);
		pageQueryResult.setQueryResult(l);
		return pageQueryResult;
	}
}
