<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="我的工作台">
<@CommonQueryMacro.DynamicTabSet id="resourceMonitor_tabs" hasMenu="false" height="400px" selected="sysTab">
	<@CommonQueryMacro.DynamicTab id="dbgzTab" title="待办预警任务" url="/gbicc-com-pages/single/ftl/single_rul_warning_task_desk.ftl">
		</@CommonQueryMacro.DynamicTab>
	<@CommonQueryMacro.DynamicTab id="gzpcTab" title="待办协查任务" url="/gbicc-com-pages/single/ftl/single_rul_investigation_task_desk.ftl">
	</@CommonQueryMacro.DynamicTab>
	<@CommonQueryMacro.DynamicTab id="gzpcTab" title="案例管理" url="/gbicc-com-pages/single/ftl/single_rul_cases_task_desk.ftl">
	</@CommonQueryMacro.DynamicTab>
</@CommonQueryMacro.DynamicTabSet>
 <script>
 var ajMonitorReportWin;
 function p_openSubWin(id,title,reportUrl,businessId,rptStatus){
    ajMonitorReportWin = openSubWin(id,title,reportUrl+"?businessId="+businessId+"&rptStatus="+rptStatus,"1000","700");
 }
 function p_closeSubWin(){
    ajMonitorReportWin.close();
 }
 </script>
</@CommonQueryMacro.page>
