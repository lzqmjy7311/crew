<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="操作员管理">
<table align="left" width="100%">
	<tr>
		<td valign="top" rowspan="1"  valign="top">
		<@CommonQueryMacro.CommonQuery id="Management_TlrRole" init="true" navigate="false" parameters="action=query">
			<table align="left">
				<tr>
		       		<td valign="top"  valign="top">
		         		<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="selected,roleId,roleName" readonly="false" />
		       		</td>
		  		</tr>
		   </table>
		</@CommonQueryMacro.CommonQuery>
		</td>
		<td valign="top" rowspan="1"  valign="top">
		<@CommonQueryMacro.CommonQuery id="Management_TlrInfoEx" init="true" navigate="false" submitMode="current">
			<table align="left">
					<tr>
		       			<td rowspan="1"  valign="top"  width="500">
		        		<@CommonQueryMacro.Group id="group1" label="操作员信息" fieldStr="brno,tlrno,tlrName,defRoleid,status,creatDate,latelyLoginTime,latelyLogoutTime,loginIp,flag" colNm=4/>
		        		</td>
		      		</tr>
		      		<tr>
		       			<td align="center">
		         		<@CommonQueryMacro.Button id= "btSave"/>
		         		&nbsp;
		         		<@CommonQueryMacro.Button id= "btDel"/>
		         		&nbsp;
		         		<@CommonQueryMacro.Button id= "btActivation"/>
		         		&nbsp;
		         		<@CommonQueryMacro.Button id= "btBeForceExit"/>
		        		</td>
		      	  	</tr>
		   </table>

		</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="javascript">
	function Management_TlrRole_dataset_afterChange(dataset,field){
		if(field.fieldName == "selected"){
			var record = dataset.firstUnit;
			defRoleid_DropDownDataset.clearData();
			while(record){
				var v_selected = record.getValue("selected");
				var v_roleId,v_roleName;
				if( v_selected == true ){
					v_roleId = record.getValue("roleId");
					v_roleName = record.getValue("roleName");
					defRoleid_DropDownDataset.insertRecord();
					defRoleid_DropDownDataset.setValue("data",v_roleId);
					defRoleid_DropDownDataset.setValue("dataName",v_roleId + "-" + v_roleName);
				}else{
					v_roleId = record.getValue("roleId");
					v_roleName = record.getValue("roleName");
					var v_defRoleid = Management_TlrInfoEx_dataset.getValue("defRoleid");
					if( v_defRoleid == v_roleId || v_defRoleid == v_roleName){
						 Management_TlrInfoEx_dataset.setValue("defRoleid","");
						 Management_TlrInfoEx_dataset.setValue("defRoleidName","");
					}
				}
				record=record.nextUnit;
			}
		}
	}

	function btdel_onClickCheck(button) {
		var tlrno = Management_TlrInfoEx_dataset.getValue("tlrno");
		var tlrnoname = Management_TlrInfoEx_dataset.getValue("tlrnoName");
		var msg = "删除操作员：" + tlrno + "-" + tlrnoname + "及其所有岗位信息，请确认？";
		if(confirm(msg)) {
			return true;
		}else{
			return false;
		}
	}
	<!-- 初始化页面参数 -->
	function initCallGetter_post(){
		var record = Management_TlrRole_dataset.firstUnit;
		defRoleid_DropDownDataset.clearData();
		while(record){
			var v_selected = record.getValue("selected");
			var v_roleId,v_roleName;
			if( v_selected == true ){
				v_roleId = record.getValue("roleId");
				v_roleName = record.getValue("roleName");
				defRoleid_DropDownDataset.insertRecord();
				defRoleid_DropDownDataset.setValue("data",v_roleId);
				defRoleid_DropDownDataset.setValue("dataName",v_roleId + "-" + v_roleName);
			}else{
				v_roleId = record.getValue("roleId");
				v_roleName = record.getValue("roleName");
				var v_defRoleid = Management_TlrInfoEx_dataset.getValue("defRoleid");
				if( v_defRoleid == v_roleId || v_defRoleid == v_roleName){
					 Management_TlrInfoEx_dataset.setValue("defRoleid","");
					 Management_TlrInfoEx_dataset.setValue("defRoleidName","");
				}
			}
			record=record.nextUnit;
		}

		var v_flag = Management_TlrInfoEx_dataset.getValue("flag");
		if(v_flag == "0"){
			$(btDel).style.display = "none";
			$(btActivation).style.display = "";
		} else {
			$(btDel).style.display = "";
			$(btActivation).style.display = "none";
		}

		var v_status = Management_TlrInfoEx_dataset.getValue("status");
		if(v_status == "1"){
			$(btBeForceExit).style.display = "";
		} else {
			$(btBeForceExit).style.display = "none";
		}
	}
</script>
</@CommonQueryMacro.page>