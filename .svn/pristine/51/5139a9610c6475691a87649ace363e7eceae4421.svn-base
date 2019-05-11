<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="岗位权限设置">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="parammng_RoleInfo" init="true">
	<table align="left">
			<tr>
       			<td valign="top" rowspan="2"  valign="top">
          			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="roleid,rolename,status"  readonly="true"/></br>
                    &nbsp;
                    &nbsp;

        		</td>
        		<td align="left" valign="top" width="200">
        			<table align="center">
        				<tr>
       					<td>
        					<@CommonQueryMacro.Group id="group1" label="岗位权限设置" fieldStr="roleid,rolename,roletype,status,effectDate,expireDate" colNm=2/>
        				</td>
						</tr>
						<tr align="center">
       					<td>
       						<@CommonQueryMacro.Button id= "RoleInfo1"/>
							<@CommonQueryMacro.Button id= "RoleInfo2"/>
							<!--
							<@CommonQueryMacro.Button id= "btSave"/>
							-->
						</td>

						</tr>
						<!--
						<tr align="center">

       					<td >
       						<@CommonQueryMacro.Button id= "btNew"/>

							<@CommonQueryMacro.Button id= "btDelete"/>

							<@CommonQueryMacro.Button id= "btSave"/>
						</td>
						</tr>
						-->
					</table>
        		</td>

      		</tr>
   </table>

      <script language="javascript">
      function parammng_RoleInfo_dataset_afterScroll(dataset){
		  v_id = parammng_RoleInfo_dataset.getValue("v_id");
		  //数据库中的记录。
		  if ( !isNaN(v_id ) ){
		    parammng_RoleInfo_dataset.setReadOnly(true);
		  }else{
		    parammng_RoleInfo_dataset.setReadOnly(false);
		  }
		  return true;
		}

		function btNew_onClick(button){
			  v_id = parammng_RoleInfo_dataset.getValue("v_id");
			  //数据库中的记录。
			  if (!isNaN(v_id ) ){
			    parammng_RoleInfo_dataset.setAllFieldsReadOnly(true);
			  }else{
			    parammng_RoleInfo_dataset.setAllFieldsReadOnly(false);
			  }
			  alert("输入新增岗位后,按保存确定");
	//		  btDelete.disabled=true;
			  RoleInfo1.disable(true);
			  RoleInfo2.disable(true);
			}

        function btSave_postSubmit(){
       //  	btDelete.disabled=false;
			  RoleInfo1.disable(false);
			  RoleInfo2.disable(false);
         alert('保存成功');
         }

			</script>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>



</table>
</@CommonQueryMacro.page>