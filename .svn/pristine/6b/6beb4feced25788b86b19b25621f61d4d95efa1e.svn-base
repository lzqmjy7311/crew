<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="我的工作台">
 <#assign roleId = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getExtensbean().getRoleList().get(0).getId()>
 <@CommonQueryMacro.DynamicTabSet id="resourceMonitor_tabs" hasMenu="false" height="400px" selected="sysTab">
 
<#if (roleId==222||roleId==333||roleId==444||roleId==555)>	
		<@CommonQueryMacro.DynamicTab id="dbgzTab" title="代办工作" url="/gbicc-pages/regular/ftl/monitor_report_myDesk_list.ftl">
		</@CommonQueryMacro.DynamicTab>
</#if>		
<#if (roleId == 111||roleId==444||roleId==555||roleId==222||roleId==609)>		
		<@CommonQueryMacro.DynamicTab id="gzpcTab" title="规则排除/恢复" url="/gbicc-pages/rule_eliminate/ftl/trigger_rule_acct.ftl">
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="tzjkplTab" title="调整监控频率" url="/gbicc-pages/rule_frequency/ftl/trigger_frequency_acct_desk.ftl">
		</@CommonQueryMacro.DynamicTab>
</#if>			
<#if (roleId==222||roleId==333||roleId==444||roleId==555)>		
		<@CommonQueryMacro.DynamicTab id="yjxxTab" title="预警信息" url="/gbicc-pages/warn/ftl/warning_entry.ftl">
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="txxxTab" title="提醒信息" url="/gbicc-pages/warn/ftl/TPlTaskRuleTrig.ftl">
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="rjqdTab" title="预警清单" url="/gbicc-pages/warn/ftl/warning_entry.ftl">
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="yqqdTab" title="逾期清单" url="/gbicc-pages/collectionManage/ftl/TCollectionDeskInfo.ftl">
		</@CommonQueryMacro.DynamicTab>
</#if>		
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