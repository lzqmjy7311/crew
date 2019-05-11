<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="¶¯Ì¬Ê÷">
	<@CommonQueryMacro.DynamicTabSet id="demo_tree_tabs" hasMenu="true" height="600px" selected="tab1">
		<@CommonQueryMacro.DynamicTab id="tab1" title="Ô¤ÀÀ" url="/demo/ftl/dynamictree.ftl"> 
		</@CommonQueryMacro.DynamicTab>
		<@CommonQueryMacro.DynamicTab id="tab2" title="´úÂë" url="/demo/code/code.jsp?ftl=dynamictree&commquery=TreeNode"> 
		</@CommonQueryMacro.DynamicTab>
	</@CommonQueryMacro.DynamicTabSet>
	<script>
	</script>
</@CommonQueryMacro.page>