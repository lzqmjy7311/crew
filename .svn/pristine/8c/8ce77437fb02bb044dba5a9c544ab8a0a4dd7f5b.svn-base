<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="操作员角色管理">
	<table align="left">
		<tr align="center">
			<td>
<@CommonQueryMacro.CommonQuery id="operMngMod" init="true" navigate="false" submitMode="all" >
	<table align="left">
		 <tr align="center"  width="100%">
			<td>
				<@CommonQueryMacro.Group id ="group1" label="操作员信息" fieldStr="tlrno,tlrName,branchName,flag,isLock"colNm=4/>
        	</td>
        </tr>
   </table>
</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr align="center">
			<td>
<@CommonQueryMacro.CommonQuery id="operMngRoleInfo" init="true" submitMode="all" navigate="false">
	<table align="left">
	      	<tr>
	      		<td valign="top">
						<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="selected,roleId,roleName" width="400"   height="200"  readonly="true"/>
				</td>
		 	</tr>
		 	<tr align="left">
	  				 <td>
                        <@CommonQueryMacro.Button id= "btCancel" />
      				</td>
    		</tr>
	 </table>
</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
</table>
<script language="javascript">
	var currentTlrno = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}";
	function initCallGetter_post(dataset) {
		var tlrno = operMngMod_dataset.getValue("tlrno");
		if(tlrno == null||tlrno == ""){
			operMngMod_dataset.setFieldReadOnly("tlrno",false);
			operMngMod_dataset.setFieldReadOnly("tlrName",false);
			operMngMod_dataset.setFieldReadOnly("branchName",false);
			operMngMod_dataset.setValue("newFlg","0");
			document.getElementById("unLock").style.disabled="none";
			document.getElementById("btResetPwd").style.disabled="none";
		}else{
			operMngMod_dataset.setFieldReadOnly("tlrno",true);
			operMngMod_dataset.setFieldReadOnly("tlrName",true);
			operMngMod_dataset.setFieldReadOnly("branchName",true);
		}
	}

	function btStatus_onClickCheck(button){
		var flag = operMngMod_dataset.getValue("flag");
	    if ( flag == "0" ) {
	    	operMngMod_dataset.setValue("flag","1");
	    } else if ( flag == "1" || flag =="" ){
	      	operMngMod_dataset.setValue("flag","0");
	    }
	    operMngMod_dataset.refreshControls();
		return false;
	}
	function unLock_onClick(button){
   		var isLock = operMngMod_dataset.getValue("isLock");
	    if ( isLock == "0" ) {
	    	operMngMod_dataset.setValue("isLock","0");
	    } else if ( isLock == "1" ){
	      	operMngMod_dataset.setValue("isLock","0");
	    }
	    operMngMod_dataset.refreshControls();
		return false;
	}
	function btRoleSave_needCheck(button){
		return false;
	}

	<#--function btRoleSave_postSubmit(button){
		alert("保存成功");
		win.close();
	}

	function btCancel_onClickCheck(button)
	{
	     unloadPageWindows("userWin");
	     return false;
	}
	-->
	function btResetPwd_onClick(button){
		var tlrno = operMngMod_dataset.getValue("tlrno");
		if (tlrno == currentTlrno) {
				alert("不能重置自己的密码");
			} else {
				if(!confirm("确认要重置该操作员吗?")){
					return;
				}
				operMngMod_dataset.setValue("restFlg","1");
			}
	}
</script>
</@CommonQueryMacro.page>
