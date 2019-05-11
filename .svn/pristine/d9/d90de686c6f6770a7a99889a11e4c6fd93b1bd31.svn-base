<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="操作日志查询">
<@CommonQueryMacro.CommonQuery id="operLoggerQuery" init="false" submitMode="selected">
	<table align="left">
		<tr align="left">
			<td valign="top" rowspan="1"  width="735">
				<@CommonQueryMacro.Interface id="Interface1" label="查询条件" colNm=4 />
			</td>
		</tr>
		<tr>
			<td valign="top">
				<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
				<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="select,txnDate[80],brcode,oprcode,ipAdr[110],oprtxncd,txnBizLog,txnStatus[50]" readonly="false" width="735" /></br>
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
</script>
</@CommonQueryMacro.page>