<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="新增操作员">
<@CommonQueryMacro.CommonQuery id="operMngAdd" init="true" mode="current" navigate="false">
	<table align="left">
		<tr align="center">
			<td >
				<@CommonQueryMacro.Group id ="table1" label="详细信息" fieldStr="tlrno,tlrName,brcode"colNm=4/>
			</td>
		</tr>
      	<tr align="left">
	  		 <td>
      			<@CommonQueryMacro.Button id= "btAddSave" />
      			&nbsp;&nbsp;
      			<@CommonQueryMacro.Button id= "btAddAuth"/>
  				&nbsp;&nbsp;
                <@CommonQueryMacro.Button id= "btCancel" />
      		</td>
      	</tr>
 </table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var isNew = operMngAdd_dataset.length == 0;
	
	function btAddSave_onClickCheck(button){
		if (operMngAdd_dataset.length == 0) {
			alert("请填写操作员信息");
			return false;
		}
		return true;
	}
	function btAddSave_postSubmit(button){
		alert("保存成功");
		isNew = false;
		btAddSave.disable(true);
	}
	function btAddAuth_onClick(button){
		if(isNew){
			alert("请先保存，才能进行角色设定");
			return;
		}
		unfireUserEvent("btSave_postSubmit");
		var paramMap = new Map();
		var tlrno = operMngAdd_dataset.getValue("tlrno");
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
