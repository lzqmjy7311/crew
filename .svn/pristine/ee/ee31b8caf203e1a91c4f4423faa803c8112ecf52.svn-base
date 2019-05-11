<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="用户登录日志查询">

<@CommonQueryMacro.CommonQueryTab id="tlrLoginLogQueryTabs" navigate="false" currentTab="TlrLoginLogQuery">
<@CommonQueryMacro.CommonQuery id="TlrLoginLogQuery" init="true" submitMode="selected" navigate="false">



<table align="left" width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 fieldStr="qtlrNo,qbrNo" moreFieldStr="startDate,endDate,qloginAddr" showButton="false"/>
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
			<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="tlrNo[100],brNo[120],loginAddr[120],loginSucTm[140],loginOutTm[140],loginFailTm[140],loginRemark" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">

//重置查询条件
function btnReset_onClick(button){
	TlrLoginLogQuery_interface_dataset.clearData();
}
</script>
</@CommonQueryMacro.page>
