<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="ExecuteStateQueryEntry.title">
<table align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="ExecuteStateQueryEntry" init="false" submitMode="current">
			<table width="1000px">
				<tr>
					<td colspan="2" valign="top">
						<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" />
					</td>
				</tr>
				<tr>
					<td>
						<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.DataTable id="datatable1" fieldStr="brNo,brName,busiType,appType,executeId,executeType,workDate,operType,executeTm,ip,operation"  width="100%"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.FloatWindow id="logdetail" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
							<div align="center">
								<@CommonQueryMacro.Group id="group1" label="详细" fieldStr="brNo,brName,busiType,appType,workDate,operType,executeType,executeTm,executeId,startTm,endTm,ip" colNm=4/>
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
	function initCallGetter_post(){
		//工作时间默认当天时间
		ExecuteStateQueryEntry_interface_dataset.setValue("qworkDateStart",_today_date);
		ExecuteStateQueryEntry_interface_dataset.setValue("qworkDateEnd",_today_date);
		ExecuteStateQueryEntry_interface_dataset.setValue("qbusiType",defaultType);
	}

	function datatable1_operation_onRefresh(cell,value,record) {
		if(null != record) {
			var id = record.getValue("id");
			cell.innerHTML="<center><a href=\"javascript:onLogDetail('"+id+"')\">详细</a></center>";
		} else {
			cell.innerHTML = "";
		}
	}

	//定位一行记录
	function locate(id) {
		var record = ExecuteStateQueryEntry_dataset.find(["id"],[id]);
		if(record) {
			ExecuteStateQueryEntry_dataset.setRecord(record);
		}
	}

	function onLogDetail(id){
		locate(id);

		ExecuteStateQueryEntry_dataset.setFieldReadOnly("brNo", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("brName", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("workDate", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("operType", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("busiType", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("appType", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("executeType", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("executeTm", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("executeId", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("startTm", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("endTm", true);
		ExecuteStateQueryEntry_dataset.setFieldReadOnly("ip", true);

		subwindow_logdetail.show();
	}

</script>
</@CommonQueryMacro.page>