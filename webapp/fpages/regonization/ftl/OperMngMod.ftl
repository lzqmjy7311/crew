<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="�޸Ĳ���Ա">
<@CommonQueryMacro.CommonQuery id="operMngMod" init="true" mode="current" navigate="false">
	<table align="left">
		<tr align="center">
			<td >
				<@CommonQueryMacro.Group id ="table1" label="��ϸ��Ϣ" fieldStr="tlrno,tlrName,branchName"colNm=4/>
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
			alert("���޸�");
		}
		return isChanged;
	}
	function btModSave_postSubmit(button) {
		alert("����ɹ�");
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
	  	loadPageWindows("userWin", "��ɫ�趨", "/fpages/regonization/ftl/OperMngRoleInfo.ftl", paramMap, "winZone");
	}
	function btCancel_onClickCheck(button) {
	     unloadPageWindows("userWin");
	     return false;
	}
		
</script>
</@CommonQueryMacro.page>
