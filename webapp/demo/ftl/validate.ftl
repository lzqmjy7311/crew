<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="demo_field">
	<@CommonQueryMacro.DynamicTabSet id="demo_field_tabs" hasMenu="true" height="600px" selected="tab1">
		<@CommonQueryMacro.DynamicTab id="tab1" title="Ô¤ÀÀ" url="/demo/ftl/validate_tab.ftl"> 
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="tab2" title="´úÂë" url="/demo/code/code.jsp?ftl=validate_tab&commquery=GroupValidateFields"> 
		</@CommonQueryMacro.DynamicTab>
	</@CommonQueryMacro.DynamicTabSet>
	<script>
	</script>
</@CommonQueryMacro.page>