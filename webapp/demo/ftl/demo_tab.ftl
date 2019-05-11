<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="����1(CRUD���)">
<@CommonQueryMacro.CommonQuery id="DemoFields" init="true" submitMode="allchange" navigate="false">
<table width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="interface1" label="����1(CRUD���,˫���ɱ༭)" colNm=4  />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id="demotable" floatwindow="detailFW" paginationbar="btnNew,-,btnDel,-,btnSave" readonly="true"
			 	fieldStr="id,pid,managerId,name,sex,age,birthday,salary,workStartTime,workEndTime,yyyymm" height="400" />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.FloatWindow id="detailFW" label="��ϸ����" show="false" defaultZoom="normal">
				<@CommonQueryMacro.Group id="group1" label="" colNm="4"
					fieldStr="id,pid,managerId,name,sex,age,birthday,salary,workStartTime,workEndTime,yyyymm" />
				<@CommonQueryMacro.Button id="btnSave" />
			</@CommonQueryMacro.FloatWindow>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script>
	function demotable_onDbClick(){
		subwindow_detailFW.show();
	}
</script>
</@CommonQueryMacro.page>