package com.huateng.ebank.business.approve.getter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.approve.service.UndoConfirmService;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class ApproveLogGetter extends BaseGetter {
	/**
	 * @author jianxue.zhang
	 * 用于获取已办事项的数据
	 */
	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		GlobalInfo info = GlobalInfo.getCurrentInstance();
		//获取参数集合
		Map paramMap = this.getCommQueryServletRequest().getParameterMap();
		//也可以这样 getCommQueryServletRequest().getParameter("qDataTypeNo");
		//获取参数id,insCd,intInsId,updTransCd
		String id = (String)paramMap.get("id");
		String insCd = (String)paramMap.get("insCd");
		String intInsId = (String)paramMap.get("intInsId");
		String updTransCd = (String)paramMap.get("updTransCd");
		//审批时间
		String ctdate1 = (String)paramMap.get("ctdate1");
		String ctdate2 = (String)paramMap.get("ctdate2");
		//获取页面的pageSize
		int pageSize = this.getResult().getPage().getEveryPage();
		//获取页面的当前页
		int pageIndex = this.getResult().getPage().getCurrentPage();
		//组装hql语句
		StringBuffer hql=new StringBuffer(" from SysTaskLog dd where dd.approveOperId='"+info.getTlrno()+"'");
		if (StringUtils.isNotBlank(id)) {
			hql.append(" and dd.id=").append(id);
		}
		if (StringUtils.isNotBlank(insCd)) {
			hql.append(" and dd.insCd=").append(insCd);
		}
		if (StringUtils.isNotBlank(intInsId)) {
			hql.append(" and dd.intInsId=").append(intInsId);
		}
		if (StringUtils.isNotBlank(updTransCd)) {
			hql.append(" and dd.updTransCd=").append(updTransCd);
		}
		if (!DataFormat.isEmpty(ctdate1)) {
			hql.append(" and dd.crtDt>=").append(ctdate1);
		}
		if (!DataFormat.isEmpty(ctdate2)) {
			hql.append(" and dd.crtDt<=").append(ctdate2);
		}
		hql.append(" order by dd.id desc");
		System.out.println(hql.toString());
		return UndoConfirmService.getInstance().list(pageIndex, pageSize, hql.toString());
	}
}
