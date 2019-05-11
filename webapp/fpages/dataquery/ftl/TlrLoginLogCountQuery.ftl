<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="用户登录日志次数时间段查询">
<@CommonQueryMacro.CommonQueryTab id="tlrLoginLogQueryTabs" navigate="false" currentTab="TlrLoginLogCountQuery">
<@CommonQueryMacro.CommonQuery id="TlrLoginLogCountQuery" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>

	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="tlrno,brno,startDate,endDate,count" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">


</script>
</@CommonQueryMacro.page>