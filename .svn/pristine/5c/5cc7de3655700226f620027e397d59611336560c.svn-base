<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<@CommonQueryMacro.page title="流程管理  &gt;  部署管理">
<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
	<@CommonQueryMacro.CommonQuery id="MonitorReportList" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable  id="monitorReportTable" readonly="true" paginationbar="btHandle" 
		fieldStr="warnLevel,loanAcct,custName,loanVariety,loanAmt,loanBalance,loanTerm,rptStatus,taskType,taskMatureDate,handler,ifTimeout" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
<script type="text/javascript">
	
	var ajMonitorReportWin;
	function ajMonitorReportWin_close(){
		ajMonitorReportWin.close();
		MonitorReportList_dataset.flushData(MonitorReportList_dataset.pageIndex);
	}
	function btHandle_onClick(button) {
		var businessId=MonitorReportList_dataset.getValue("id");
		var rptStatus=MonitorReportList_dataset.getValue("rptStatus");
		var custName=MonitorReportList_dataset.getValue("custName");
		var loanAcct=MonitorReportList_dataset.getValue("loanAcct");
		var reportUrl=MonitorReportList_dataset.getValue("reportUrl");
		var taskType=MonitorReportList_dataset.getValue("taskType");

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
			title="填写预警处置报告("+custName+"【"+loanAcct+"】)";
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
	    ajMonitorReportWin=openSubWin("ajMonitorReportWin",title,reportUrl+"?businessId="+businessId+"&rptStatus="+rptStatus,"1000","700");
	}
</script>
</@CommonQueryMacro.page>