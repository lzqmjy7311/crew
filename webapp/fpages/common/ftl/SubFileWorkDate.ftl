<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="选择工作日期">
<@CommonQueryMacro.CommonQuery id="subfileworkdate" init="true" submitMode="allchange">
	<table align="left">
      <tr valign="top">
  			<td valign="center">
  			<@CommonQueryMacro.Group id ="group1" label="选择日期" fieldStr="newFileDate" colNm=2/>
  			</td>
  		</tr>
  		<tr valign="top">
  		   <td align="left"  style="padding-top: 10px;padding-left: 3px;">
				<@CommonQueryMacro.Button id= "btSave"/>
					&nbsp;&nbsp;
 				<@CommonQueryMacro.Button id= "btCancel"/>
  		   </td>
  		</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	function btCancel_onClick(button){
		closeWin();
	}

	function btSave_postSubmit(button){
		var retParam = button.returnParam;
		var newdt = retParam.newdt;
		window.parent.document.getElementById("fileDate").value = newdt;
		closeWin(true);
	}

</script>
</@CommonQueryMacro.page>
