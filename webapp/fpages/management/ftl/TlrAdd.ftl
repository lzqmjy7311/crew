<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="操作员增加">
<table align="left" >
	<tr>
		<td valign="top">
		<@CommonQueryMacro.CommonQuery id="Management_AllRole" init="true" navigate="false" >
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="selected,roleId,roleName" readonly="false" width="200" />
		</@CommonQueryMacro.CommonQuery>
		</td>
		<td valign="top">
			<@CommonQueryMacro.CommonQuery id="Management_TlrAdd" init="true" navigate="false">
				<table align="left" >
						<tr>
			       			<td valign="top">
			        		<@CommonQueryMacro.Group id="group1" label="操作员信息" fieldStr="brno,tlrno,tlrName,defRoleid" colNm=2/>
			        		</td>
			      		</tr>
			      		<tr>
			       			<td>
			         		<@CommonQueryMacro.Button id= "btSave"/>
			        		</td>
			      	  	</tr>
			   </table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="javascript">
	function Management_AllRole_dataset_afterChange(dataset,field){
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
					var v_defRoleid = Management_TlrAdd_dataset.getValue("defRoleid");
					if( v_defRoleid == v_roleId ){
						 Management_TlrAdd_dataset.setValue("defRoleid","");
						 Management_TlrAdd_dataset.setValue("defRoleidName","");
					}
				}
				record=record.nextUnit;
			}
		}
	}

</script>
</@CommonQueryMacro.page>
