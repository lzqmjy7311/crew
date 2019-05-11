<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro> 
<@CommonQueryMacro.page title="d">

<@CommonQueryMacro.CommonQuery id="TEtlErrorLog" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="输入查询日期" colNm=4 showButton="false" />
		</td>
	</tr>
     <tr>
			<td>
				<div align="center" style="margin-bottom:10px">
					<@CommonQueryMacro.SimpleButton id="btQuery" desc="查询" icon="icon-search" />
					<@CommonQueryMacro.SimpleButton id="btnReset" desc="重置" icon="icon-reload" />
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
	//设置用户信息
	TEtlErrorLog_dataset.setParameter("roleId",user_info.roleId);
	TEtlErrorLog_dataset.setParameter("orgId",user_info.orgId);
	TEtlErrorLog_dataset.setParameter("userId",user_info.userId);
	//获取查询参数
	var procName=TEtlErrorLog_interface_dataset.getValue("procName");
	var errMsg=TEtlErrorLog_interface_dataset.getValue("errMsg");
	var errSql=TEtlErrorLog_interface_dataset.getValue("errSql");
	var errTimestamp=TEtlErrorLog_interface_dataset.getValue("errTimestamp");
	//设置参数
	TEtlErrorLog_dataset.setParameter("procName",procName);
	TEtlErrorLog_dataset.setParameter("errMsg",errMsg);
	TEtlErrorLog_dataset.setParameter("errSql",errSql);
	TEtlErrorLog_dataset.setParameter("errTimestamp",errTimestamp);
	//
	TEtlErrorLog_dataset.flushData();
}
</script>
</@CommonQueryMacro.page>