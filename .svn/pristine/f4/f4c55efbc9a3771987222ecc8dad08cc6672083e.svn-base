<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro> 
<@CommonQueryMacro.page title="d">

<@CommonQueryMacro.CommonQuery id="TOdsCmsCustomerRelation" init="true" submitMode="current" >

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 showButton="false" />
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
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="customerNum[100],chineseName[200],custNo[120],custName[150]" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

function btnReset_onClick(button){
	TOdsCmsCustomerRelation_interface_dataset.clearData();
}
</script>
</@CommonQueryMacro.page>
