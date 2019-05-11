<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="定时任务日志查询">
<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="BiQuartzJobLog" init="false" submitMode="current">
			<table width="100%">
				<tr>
					<td colspan="2" valign="top">
						<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" colNm="6"/>
					</td>
				</tr>
				<tr>
					<td>
						<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.DataTable id="datatable1" fieldStr="quartzName,execTm,endTm,quartzResult,remark,opr"  width="100%"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.FloatWindow id="logdetail" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
							<div align="center">
								<@CommonQueryMacro.Group id="group1" label="详细" fieldStr="quartzName,execTm,endTm,quartzResult,remark" colNm=4/>
								<br/>
							</div>
						</@CommonQueryMacro.FloatWindow>
					</td>
				</tr>
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="JavaScript">
	//工作时间默认当天时间

	function datatable1_opr_onRefresh(cell,value,record) {
		if(null != record) {
			var id = record.getValue("id");
			cell.innerHTML="<center><a href=\"javascript:onLogDetail('"+id+"')\">详细</a></center>";
		} else {
			cell.innerHTML = "";
		}
	}

	//定位一行记录
	function locate(id) {
		var record = BiQuartzJobLog_dataset.find(["id"],[id]);
		if(record) {
			BiQuartzJobLog_dataset.setRecord(record);
		}
	}

	function onLogDetail(id){
		locate(id);

		BiQuartzJobLog_dataset.setFieldReadOnly("quartzName", true);
		BiQuartzJobLog_dataset.setFieldReadOnly("execTm", true);
		BiQuartzJobLog_dataset.setFieldReadOnly("endTm", true);
		BiQuartzJobLog_dataset.setFieldReadOnly("quartzResult", true);
		BiQuartzJobLog_dataset.setFieldReadOnly("remark", true);


		subwindow_logdetail.show();
	}

</script>
</@CommonQueryMacro.page>