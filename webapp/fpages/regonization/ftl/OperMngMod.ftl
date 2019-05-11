<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="修改操作员">
<@CommonQueryMacro.CommonQuery id="operMngMod" init="true" mode="current" navigate="false">
	<table align="left">
		<tr align="center">
			<td >
				<@CommonQueryMacro.Group id ="table1" label="详细信息" fieldStr="tlrno,tlrName,branchName"colNm=4/>
			</td>
		</tr>
      	<tr align="left">
	  		 <td>
      			<@CommonQueryMacro.Button id= "btModSave" />
      			&nbsp;&nbsp;
      			<@CommonQueryMacro.Button id= "btModAuth"/>
  				&nbsp;&nbsp;
                <@CommonQueryMacro.Button id= "btCancel" />
      		</td>
      	</tr>
 </table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var isChanged = false;
	function btModSave_onClickCheck(button) {
		if (!isChanged) {
			alert("请修改");
		}
		return isChanged;
	}
	function btModSave_postSubmit(button) {
		alert("保存成功");
	}
	function operMngMod_dataset_afterChange(dataset) {
		isChanged = true;
	}
	function btModAuth_onClick(button){
		unfireUserEvent("btSave_postSubmit");
		var paramMap = new Map();
		var tlrno = operMngMod_dataset.getValue("tlrno");
	  	var op = "auth";
	  	paramMap.put("tlrno",tlrno);
	  	paramMap.put("op",op);
	  	win.close();
	  	loadPageWindows("userWin", "角色设定", "/fpages/regonization/ftl/OperMngRoleInfo.ftl", paramMap, "winZone");
	}
	function btCancel_onClickCheck(button) {
	     unloadPageWindows("userWin");
	     return false;
	}
		
</script>
</@CommonQueryMacro.page>
