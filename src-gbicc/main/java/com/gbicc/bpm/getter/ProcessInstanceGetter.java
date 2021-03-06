package com.gbicc.bpm.getter;

import java.util.List;
import java.util.Map;

import com.gbicc.bpm.pojo.ExtProcessDefinition;
import com.gbicc.bpm.service.ProcessManagerService;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class ProcessInstanceGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		int pageSize = getResult().getPage().getEveryPage();// 分页大小
		int pageIndex = getResult().getPage().getCurrentPage();// 页码
		int start=(pageIndex-1)*pageSize;
		String processName = this.getCommQueryServletRequest().getParameter("processName");
		String businessKey = this.getCommQueryServletRequest().getParameter("businessKey");
		String assignee = this.getCommQueryServletRequest().getParameter("assignee");
		String brName = this.getCommQueryServletRequest().getParameter("brName");
		String processDefinitionId = this.getCommQueryServletRequest().getParameter("processDefinitionId");
		
		 Map<String, Object> object=ProcessManagerService.getInstace()
				 .processInstanceList(processDefinitionId,processName,businessKey,assignee,brName,start,pageSize);
		 PageQueryResult pageQueryResult = new PageQueryResult();
		 int total=((Long) object.get("count")).intValue();
		 pageQueryResult.setQueryResult((List<ExtProcessDefinition>) object.get("data"));
		 pageQueryResult.setTotalCount(total);
		 ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(), pageQueryResult.getQueryResult(),getResult());
		 result.setContent(pageQueryResult.getQueryResult());
		 
		 int totalPage=0;
		 if(total%pageSize==0){
			 totalPage=total/pageSize;
		 }else{
			 totalPage=total/pageSize+1;
		 }
		 result.getPage().setTotalPage(totalPage);
		 result.init();
		 return result;
	}

}
