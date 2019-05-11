<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="岗位管理">
<@CommonQueryMacro.CommonQuery id="ebankCustRoleMng" init="true" submitMode="all">
	<table align="left">
      <tr>
      		<td valign="top">
      			<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9999"/>
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="id,roleName,status" readonly="true" /></br>
      		</td>

      </tr>

      <tr>
      		<td valign="top">
      			<@CommonQueryMacro.Group id ="Qgroup1" label="详细信息" fieldStr="id,roleName,status,effectDate,expireDate"/>
      		</td>
      </tr>

      <tr>
      		<td valign="top">
      			<table width="500">
        			<tr align="center">
        				<td align="center">
         					<@CommonQueryMacro.Button id= "btAddRole"/>
      					</td>
      					<td>
         					<@CommonQueryMacro.Button id= "btDeleteRole"/>
      					</td>
      					<td>
         					<@CommonQueryMacro.Button id= "btSave"/>
      					</td>
						<td>
         					<@CommonQueryMacro.Button id= "btRoleAuthorityManagement"/>
      					</td>
      					<td>
         					<@CommonQueryMacro.Button id= "btSelectRole"/>
      					</td>
      				</tr>
      			</table>
      		</td>
      </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<@CommonQueryMacro.CommonQuery id="PosiNameCheck" init="false" navigate="false" >
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
	var isSave=true;
	function btAddRole_onClickCheck(button){
		ebankCustRoleMng_dataset.setFieldReadOnly("id",false);
		ebankCustRoleMng_dataset.setFieldReadOnly("roleName",false);
		ebankCustRoleMng_dataset.setFieldReadOnly("status",false);
		ebankCustRoleMng_dataset.setFieldReadOnly("brclass",false);
		ebankCustRoleMng_dataset.setFieldReadOnly("effectDate",false);
		ebankCustRoleMng_dataset.setFieldReadOnly("expireDate",false);
		isSave=false;
	}

	function btSave_postSubmit(){
       alert('保存成功！');
       isSave=true;
       ebankCustRoleMng_dataset.flushData(ebankCustRoleMng.pageIndex);
    }

	function ebankCustRoleMng_dataset_afterScroll(dataset){
		var v_id = ebankCustRoleMng_dataset.getValue("id");
		if(isNaN(v_id)) {
    		ebankCustRoleMng_dataset.setFieldReadOnly("id",false);
			ebankCustRoleMng_dataset.setFieldReadOnly("roleName",false);
			ebankCustRoleMng_dataset.setFieldReadOnly("status",false);
			ebankCustRoleMng_dataset.setFieldReadOnly("brclass",false);
			ebankCustRoleMng_dataset.setFieldReadOnly("effectDate",false);
			ebankCustRoleMng_dataset.setFieldReadOnly("expireDate",false);
   	   	}else{
   	   		ebankCustRoleMng_dataset.setFieldReadOnly("id",true);
		ebankCustRoleMng_dataset.setFieldReadOnly("roleName",true);
		ebankCustRoleMng_dataset.setFieldReadOnly("status",true);
		ebankCustRoleMng_dataset.setFieldReadOnly("brclass",true);
		ebankCustRoleMng_dataset.setFieldReadOnly("effectDate",true);
		ebankCustRoleMng_dataset.setFieldReadOnly("expireDate",true);
   	   	}
		var v_status = ebankCustRoleMng_dataset.getValue("status");
		if (v_id.length!=0){
		    if ("0" == v_status) {
				btRoleAuthorityManagement.disable(true);
				btSelectRole.disable(true);
			} else {
				btRoleAuthorityManagement.disable(false);
				btSelectRole.disable(false);
			}
		}else{
		   	btRoleAuthorityManagement.disable(true);
		   	btSelectRole.disable(true);
		}
		return true;
	}

	function btSelectRole_onClickCheck(button){
	   var paramMap = new Map();
	   var id = ebankCustRoleMng_dataset.getValue("id");
       if(isNaN(id) || isSave == false) {
    	alert("请先进行保存！");
   	 	return false;
   	   }
	   paramMap.put("roleId", id);
	   loadPageWindows("userWin", "查看人员信息", "/fpages/management/ftl/ebankCustRoleMngUser.ftl", paramMap, "winZone");
	   return false;
	}

	function btRoleAuthorityManagement_onClickCheck(button){

		var id = ebankCustRoleMng_dataset.getValue("id");
	    if(isNaN(id) || isSave == false) {
    		alert("请先进行保存！");
   	 		return false;
   	   }
	}

	function winZone_onCloseCheck() {
		ebankCustRoleMng_dataset.flushData(ebankCustRoleMng_dataset.pageIndex);
		return true;
	}

	function ebankCustRoleMng_dataset_afterChange(dataset,field,value){
		if(field.fieldName == "effectDate" || field.fieldName == "expireDate"){
			var effect = ebankCustRoleMng_dataset.getValue("effectDate");
			var expire = ebankCustRoleMng_dataset.getValue("expireDate");
			if(effect!="" && expire!="") {
				if(effect>=expire) {
					alert("生效日期应该小于失效日期");
					//ebankCustRoleMng_dataset.setValue2("effectDate","");
					ebankCustRoleMng_dataset.setValue2("expireDate","");
					return false;
				}
			}
		}
/*add by haizhou.li 20101120 对岗位名称进行实时“唯一性校验” begin*/
		if(field.fieldName == "roleName"){
			PosiNameCheck_dataset.setParameter("roleName",ebankCustRoleMng_dataset.getValue("roleName"));
			PosiNameCheck_dataset.flushData(0);
			var v_flag = PosiNameCheck_dataset.getValue("flag");
			if(v_flag == "true"){
				alert("该岗位名称已存在，请重新输入");
				ebankCustRoleMng_dataset.setValue("roleName","");
				return false;
			}
		}
/*add by haizhou.li 20101120 对组织机构代码证进行实时“唯一性校验” end*/

	}

</script>
</@CommonQueryMacro.page>
