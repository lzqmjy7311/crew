<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro> 
<@CommonQueryMacro.page title="d">

<@CommonQueryMacro.CommonQuery id="TEtlErrorLog" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="�����ѯ����" colNm=4 showButton="false" />
		</td>
	</tr>
     <tr>
			<td>
				<div align="center" style="margin-bottom:10px">
					<@CommonQueryMacro.SimpleButton id="btQuery" desc="��ѯ" icon="icon-search" />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="����" icon="icon-reload" />
				</div>
			</td>
		</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="etlErrorLogId,procName,errMsg,errSql,errTimestamp" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function btnReset_onClick(button){
	TEtlErrorLog_interface_dataset.clearData();
}
function btQuery_onClick(button){
	//�����û���Ϣ
	TEtlErrorLog_dataset.setParameter("roleId",user_info.roleId);
	TEtlErrorLog_dataset.setParameter("orgId",user_info.orgId);
	TEtlErrorLog_dataset.setParameter("userId",user_info.userId);
	//��ȡ��ѯ����
	var procName=TEtlErrorLog_interface_dataset.getValue("procName");
	var errMsg=TEtlErrorLog_interface_dataset.getValue("errMsg");
	var errSql=TEtlErrorLog_interface_dataset.getValue("errSql");
	var errTimestamp=TEtlErrorLog_interface_dataset.getValue("errTimestamp");
	//���ò���
	TEtlErrorLog_dataset.setParameter("procName",procName);
	TEtlErrorLog_dataset.setParameter("errMsg",errMsg);
	TEtlErrorLog_dataset.setParameter("errSql",errSql);
	TEtlErrorLog_dataset.setParameter("errTimestamp",errTimestamp);
	//
	TEtlErrorLog_dataset.flushData();
}
</script>
</@CommonQueryMacro.page>