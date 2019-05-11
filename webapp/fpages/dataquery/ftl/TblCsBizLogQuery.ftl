<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="��־��ѯ">
<@CommonQueryMacro.CommonQuery id="tblCsBizLogQuery" init="false" submitMode="current" navigate="false">
	<table  width="100%">
     <tr>
       			<td>
					<@CommonQueryMacro.Interface id="intface" label="�������ѯ����" colNm=6 labelwidth="100" showButton="false" />
				</td>
     </tr>
     <tr>
		<td>
			<div align="center" style="margin-bottom:10px">
				<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
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
//���ò�ѯ����
function btnReset_onClick(button){
	tblCsBizLogQuery_interface_dataset.clearData();
}

</script>
</@CommonQueryMacro.page>
