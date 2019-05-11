<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro> <@CommonQueryMacro.page title="标签页">
<@CommonQueryMacro.CommonQuery id="TOdsCmsCreditGroupMember" init="false" submitMode="selected" navigate="false">
<table align="left" width="100%">
	<tr>
		<td>
		<@CommonQueryMacro.DataTable id ="datatablefincour"
			treeGrid="true" treeField="name"
			fieldStr=""
			readonly="true" height="280" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script>
	
</script>
</@CommonQueryMacro.page>
