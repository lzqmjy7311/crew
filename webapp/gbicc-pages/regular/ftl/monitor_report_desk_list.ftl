<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign type=RequestParameters["type"]?default("")>

<@CommonQueryMacro.page title="流程管理  &gt;  部署管理">
	<@CommonQueryMacro.CommonQuery id="MonitorReportDestList" init="true" submitMode="current">
		<table>
		<tr><td>
		<@CommonQueryMacro.Interface id="qalityquery" label="查询" colNm=6  showButton="false"/>
		</td></tr>
		<tr>
			<td>
				<div align="center" style="margin-bottom:10px">
					<@CommonQueryMacro.InterfaceButton desc="查询" />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
				</div>
			</td>
		</tr>
		
		<tr>
		<td><@CommonQueryMacro.DataTable  id="monitorReportTable" paginationbar="btHandle" readonly="true" 
		fieldStr="warnLevel[80],loanAcct[180],custName,loanVariety[150],loanAmt,loanBalance,loanTerm,rptStatus,taskType,taskMatureDate,handler,ifTimeout" width="100%" hasFrame="true"/>
		</td></tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
<script type="text/javascript">
	var ajMonitorReportWin;
	//页面初始化
	function btnReset_onClick(button){
		MonitorReportDestList_interface_dataset.clearData();
	}
	
	function initCallGetter_post(){
		var type='${type}';
		MonitorReportDestList_dataset.setParameter("type",type);
	}
	function ajMonitorReportWin_close(){
		ajMonitorReportWin.close();
		MonitorReportDestList_dataset.flushData(MonitorReportDestList_dataset.pageIndex);
	}
	
	function monitorReportTable_onDbClick(){
		btHandle_onClick();
	}
	
	function btHandle_onClick(button) {
		var businessId=MonitorReportDestList_dataset.getValue("id");
		var rptStatus=MonitorReportDestList_dataset.getValue("rptStatus");
		var custName=MonitorReportDestList_dataset.getValue("custName");
		var loanAcct=MonitorReportDestList_dataset.getValue("loanAcct");
		var reportUrl=MonitorReportDestList_dataset.getValue("reportUrl");
		var taskType=MonitorReportDestList_dataset.getValue("taskType");
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
		var pageReadOnly=MonitorReportDestList_dataset.getValue("pageReadOnly");
		if(rptStatus==REPORT_STATUS.complete||pageReadOnly=='0'){
			path=path+"&pageReadOnly=1";
		}
		
		//parent.parent.parent.GTab.addTab('ajMonitorReportWin',title,reportUrl+"?businessId="+businessId+"&rptStatus="+rptStatus);
		 ajMonitorReportWin=openSubWin('ajMonitorReportWin',title,path,"1000","700");
	}
</script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/regular/comm/common.js"></script>
</@CommonQueryMacro.page>