<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="流程管理  &gt;  任务调查">
	<@CommonQueryMacro.CommonQuery id="TaskEntry" init="false" submitMode="current">
		<@CommonQueryMacro.Interface id="qalityquery" label="查询" colNm="6"  showButton="false" />
				<center>
					<@CommonQueryMacro.InterfaceButton desc="查询" />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
				</center>
		<@CommonQueryMacro.DataTable id="monitorReportTable" paginationbar="btHandle" readonly="true" 
		fieldStr="warnLevel[80],loanAcct[150],custName[100],loanVariety[180],loanAmt[100],loanBalance[100],loanTerm[80],rptStatus[130],taskType[100],taskMatureDate[90],handler[80],currentUserName[80],ifTimeout[70]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
	<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
	<script>
	function initCallGetter_post(){
		TaskEntry_dataset.setParameter("type","todoTask");
		TaskEntry_dataset.flushData(TaskEntry_dataset.pageIndex);
	}
	function btnReset_onClick(button){
		TaskEntry_interface_dataset.clearData();
	}
	function monitorReportTable_onDbClick(){
		btHandle_onClick();
	}
	
	function btHandle_onClick(){
		var businessId=TaskEntry_dataset.getValue("id");
		var rptStatus=TaskEntry_dataset.getValue("rptStatus");
		var custName=TaskEntry_dataset.getValue("custName");
		var loanAcct=TaskEntry_dataset.getValue("loanAcct");
		var reportUrl=TaskEntry_dataset.getValue("reportUrl");
		var taskType=TaskEntry_dataset.getValue("taskType");
		//20160801添加
		if(!reportUrl||reportUrl==''){
			return;
		}
		var title="任务处理";
		
		if(taskType==TASK_TYPE.DQ&&rptStatus==REPORT_STATUS.wait_fill_report){
			title="填写定期监控报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.DQ&&(rptStatus==REPORT_STATUS.wait_hz_approve || rptStatus==REPORT_STATUS.wait_dhzg_approve)){
			title="审核定期监控报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.DQ&&rptStatus==REPORT_STATUS.back){
			title="定期监控报告被退回("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.DQ&&rptStatus==REPORT_STATUS.wait_examine){
			title="审查定期监控报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.DQ&&rptStatus==REPORT_STATUS.approve_pass){
			title="定期监控报告审核通过，待填写措施完成时间("+custName+"【"+loanAcct+"】)";
		}
		else if(taskType==TASK_TYPE.YJ&&rptStatus==REPORT_STATUS.wait_fill_report){
			title="填写预警处置报告("+custName+ "【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.YJ&&(rptStatus==REPORT_STATUS.wait_hz_approve || rptStatus==REPORT_STATUS.wait_dhzg_approve)){
			title="审核预警处置报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.YJ&&rptStatus==REPORT_STATUS.back){
			title="预警处置报告被退回("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.YJ&&rptStatus==REPORT_STATUS.wait_examine){
			title="审查预警处置报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.YJ&&rptStatus==REPORT_STATUS.approve_pass){
			title="预警处置报告审核通过，待填写措施完成时间("+custName+"【"+loanAcct+"】)";
		}
		else if(taskType==TASK_TYPE.RF&&rptStatus==REPORT_STATUS.wait_fill_report){
			title="填写中小融辅报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.RF&&(rptStatus==REPORT_STATUS.wait_hz_approve || rptStatus==REPORT_STATUS.wait_dhzg_approve)){
			title="审核中小融辅报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.RF&&rptStatus==REPORT_STATUS.back){
			title="中小融辅报告被退回("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.RF&&rptStatus==REPORT_STATUS.wait_examine){
			title="审查中小融辅报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.RF&&rptStatus==REPORT_STATUS.approve_pass){
			title="中小融辅报告审核通过，待填写措施完成时间("+custName+"【"+loanAcct+"】)";
		}
		else if(taskType==TASK_TYPE.YT&&rptStatus==REPORT_STATUS.wait_fill_report){
			title="填写用途监控报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.YT&&(rptStatus==REPORT_STATUS.wait_hz_approve || rptStatus==REPORT_STATUS.wait_dhzg_approve)){
			title="审核用途监控报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.YT&&rptStatus==REPORT_STATUS.back){
			title="用途监控报告被退回("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.YT&&rptStatus==REPORT_STATUS.wait_examine){
			title="审查中用途监控报告("+custName+"【"+loanAcct+"】)";
		}else if(taskType==TASK_TYPE.YT&&rptStatus==REPORT_STATUS.approve_pass){
			title="用途监控报告审核通过，待填写措施完成时间("+custName+"【"+loanAcct+"】)";
		}
		
		var path=reportUrl+"?businessId="+businessId+"&rptStatus="+rptStatus;
		//var pageReadOnly=TaskEntry_dataset.getValue("pageReadOnly");
		//if(rptStatus==REPORT_STATUS.complete||pageReadOnly=='0'){
		//	path=path+"&pageReadOnly=1";
		//}
		path=path+"&pageReadOnly=1";
	    ajMonitorReportWin=openSubWin("ajMonitorReportWixn",title,path,"1000","700");
	}
	</script>
</@CommonQueryMacro.page>