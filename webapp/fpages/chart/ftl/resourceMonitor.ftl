<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="系统资源监控">
	<@CommonQueryMacro.DynamicTabSet id="resourceMonitor_tabs" hasMenu="false" height="400px" selected="sysTab">
		<@CommonQueryMacro.DynamicTab id="sysTab" title="System" url="/fpages/chart/ftl/sysInfo.html">
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="jvmTab" title="JVM" url="/fpages/chart/ftl/jvm.html">
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="cpuTab" title="CPU" url="/fpages/chart/ftl/cpu.html">
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="memTab" title="Memory" url="/fpages/chart/ftl/memory.html">
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="ioTab" title="IO" url="/fpages/chart/ftl/io.html">
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="networkTab" title="Network" url="/fpages/chart/ftl/network.html">
		</@CommonQueryMacro.DynamicTab>
		<#--
		<@CommonQueryMacro.DynamicTab id="procTab" title="Process" url="/fpages/chart/ftl/process.html">
		</@CommonQueryMacro.DynamicTab>
		-->
	</@CommonQueryMacro.DynamicTabSet>
</@CommonQueryMacro.page>