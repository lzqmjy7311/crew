<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="日志查询">
<@CommonQueryMacro.CommonQuery id="tblCsBizLogQuery" init="false" submitMode="current" navigate="false">
	<table  width="100%">
     <tr>
       			<td>
					<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=6 labelwidth="100" showButton="false" />
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
      		<td >
      			<@CommonQueryMacro.DataTable id ="datatable1" height="400" fieldStr="tlrName[100],misc[140],txnStartTime[140],txnEndTime[140],ipAdr[100],txnBizLog1" readonly="true" width="100%"/></br>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<span style="display:none">
<@CommonQueryMacro.CommonQuery id="PosiNameCheck" init="false" navigate="false" >
</@CommonQueryMacro.CommonQuery>
</span>

<script language="JavaScript">
//重置查询条件
function btnReset_onClick(button){
	tblCsBizLogQuery_interface_dataset.clearData();
}

</script>
</@CommonQueryMacro.page>
