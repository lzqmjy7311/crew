<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="用户登录日志查询">
<@CommonQueryMacro.CommonQuery id="TRulCategory" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
    <tr>
		<td>
		</td>
	</tr>
    <tr>
		<td>
			<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="id,categoryName,categoryCode,categoryType,remark" readonly="true" width="100%"/></br>
		</td>
		
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">


</script>
</@CommonQueryMacro.page>
