<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="demo_field">
	<@CommonQueryMacro.DynamicTabSet id="demo_field_tabs" hasMenu="true" height="600px" selected="tab1">
		<@CommonQueryMacro.DynamicTab id="tab1" title="Ô¤ÀÀ" url="/demo/ftl/datagrid_frozen_tab.ftl"> 
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="tab2" title="´úÂë" url="/demo/code/code.jsp?ftl=datagrid_frozen_tab&commquery=GridFields"> 
		</@CommonQueryMacro.DynamicTab>
	</@CommonQueryMacro.DynamicTabSet>
	<script>
	</script>
</@CommonQueryMacro.page>