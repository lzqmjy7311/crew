<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="�Ŵ�����¼">
<@CommonQueryMacro.CommonQuery id="TPlCreditMemo" init="true" submitMode="current">

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="interface" label="�������ѯ����" colNm="6" showButton="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<center>
				<@CommonQueryMacro.InterfaceButton desc="��ѯ" />
				<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
			</center>
		</td>
	</tr>
    <tr>
		<td>
			<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="15" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="startDate,custcode,custname,loanAccount,reprotCode,operator,operBank,startType" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
//���ò�ѯ����
function btnReset_onClick(button){
	TPlCreditMemo_interface_dataset.clearData();
}

</script>
</@CommonQueryMacro.page>
