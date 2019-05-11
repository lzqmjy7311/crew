<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="我的工作台">
<@CommonQueryMacro.DynamicTabSet id="resourceMonitor_tabs" hasMenu="false" height="400px" selected="sysTab">
	<@CommonQueryMacro.DynamicTab id="dbgzTab" title="待办调查任务" url="/gbicc-pages/regular/ftl/monitor_report_myDesk_list.ftl">
	</@CommonQueryMacro.DynamicTab>
	<@CommonQueryMacro.DynamicTab id="yjxxTab" title="预警清单" url="/gbicc-pages/warn/ftl/warning_entry_desk.ftl">
	</@CommonQueryMacro.DynamicTab>
	<@CommonQueryMacro.DynamicTab id="txxxTab" title="提醒信息" url="/gbicc-pages/warn/ftl/TPlTaskRuleTrig.ftl">
	</@CommonQueryMacro.DynamicTab>
	<@CommonQueryMacro.DynamicTab id="rjqdTab" title="风险清单" url="/gbicc-pages/riskrulelist/ftl/RiskruleList_desk.ftl?flag=desk">
	</@CommonQueryMacro.DynamicTab>
	<@CommonQueryMacro.DynamicTab id="yqqdTab" title="逾期清单" url="/gbicc-pages/collectionManage/ftl/TCollectionDeskInfo.ftl">
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
