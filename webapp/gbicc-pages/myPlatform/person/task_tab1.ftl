<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="我的工作台">
<@CommonQueryMacro.DynamicTabSet id="resourceMonitor_tabs" hasMenu="false" height="400px" selected="sysTab">
	<!--
	<@CommonQueryMacro.DynamicTab id="dbgzTab" title="待办调查任务" url="/gbicc-pages/regular/ftl/monitor_report_myDesk_list.ftl">
	</@CommonQueryMacro.DynamicTab>-->
	<@CommonQueryMacro.DynamicTab id="gzpcTab" title="规则排除/恢复" url="/gbicc-pages/rule_eliminate/ftl/rule_eliminate_task_desk.ftl">
	</@CommonQueryMacro.DynamicTab>
	<@CommonQueryMacro.DynamicTab id="tzjkplTab" title="调整监控频率" url="/gbicc-pages/rule_frequency/ftl/trigger_frequency_acct_desk.ftl">
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
