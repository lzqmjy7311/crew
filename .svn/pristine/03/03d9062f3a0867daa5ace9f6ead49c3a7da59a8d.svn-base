<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro> 
<@CommonQueryMacro.page title="d">

<@CommonQueryMacro.CommonQuery id="TPubRulExecuteLog" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="输入查询日期" colNm=4 showButton="false" />
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
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="ruleCode,startTime,endTime,execTime[140],isSuccess[140],rowDate[140],errorMsg[350]" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function btnReset_onClick(button){
	TPubRulExecuteLog_interface_dataset.clearData();
}

</script>
</@CommonQueryMacro.page>
