<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro> 
<@CommonQueryMacro.page title="d">

<@CommonQueryMacro.CommonQuery id="TEtlDetailLog" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="输入查询日期" showButton="false" colNm=4 />
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
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="etlDetailLogId,dataDate,procName,tableName,loadRowsCount,startTimestamp,endTimestamp" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function btnReset_onClick(button){
	TEtlDetailLog_interface_dataset.clearData();
}
function btQuery_onClick(button){
	//设置用户信息
	TEtlDetailLog_dataset.setParameter("roleId",user_info.roleId);
	TEtlDetailLog_dataset.setParameter("orgId",user_info.orgId);
	TEtlDetailLog_dataset.setParameter("userId",user_info.userId);
	//获取查询参数
	var dataDate=TEtlDetailLog_interface_dataset.getValue("dataDate");
	var procName=TEtlDetailLog_interface_dataset.getValue("procName");
	var tableName=TEtlDetailLog_interface_dataset.getValue("tableName");
	var loadRowsCount=TEtlDetailLog_interface_dataset.getValue("loadRowsCount");
	var startTimestamp=TEtlDetailLog_interface_dataset.getValue("startTimestamp");
	var endTimestamp=TEtlDetailLog_interface_dataset.getValue("endTimestamp");
	//判断开始日期是否小于结束日期
	if(startTimestamp>endTimestamp){
		alert("开始时间大于结束时间！");
	}
	//设置参数
	TEtlDetailLog_dataset.setParameter("dataDate",dataDate);
	TEtlDetailLog_dataset.setParameter("procName",procName);
	TEtlDetailLog_dataset.setParameter("tableName",tableName);
	TEtlDetailLog_dataset.setParameter("loadRowsCount",loadRowsCount);
	TEtlDetailLog_dataset.setParameter("startTimestamp",startTimestamp);
	TEtlDetailLog_dataset.setParameter("endTimestamp",endTimestamp);
	//
	TEtlDetailLog_dataset.flushData();
}
</script>
</@CommonQueryMacro.page>