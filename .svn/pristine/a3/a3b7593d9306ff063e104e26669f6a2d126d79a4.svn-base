<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro> 
<@CommonQueryMacro.page title="d">

<@CommonQueryMacro.CommonQuery id="TEtlJobErrorLog" init="true" submitMode="current" >

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=8 showButton="false" />
		</td>
	</tr>
    <tr>
		<td>
			<div align="center" style="margin-bottom:10px">
				<@CommonQueryMacro.InterfaceButton desc="查询" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="etlErrorLogID[100],etlScheduleID[100],jobName[180],errMsg[180],errSql[180],errTimestamp[100]" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

function btnReset_onClick(button){
	TEtlJobErrorLog_interface_dataset.clearData();
}
</script>
</@CommonQueryMacro.page>
