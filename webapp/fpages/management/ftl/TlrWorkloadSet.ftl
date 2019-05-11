<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="操作员审批阀值设置">
<table align="left" width="100%">
	<tr>
		<td valign="top" rowspan="1"  valign="top">
			<@CommonQueryMacro.CommonQuery id="Management_TlrWorkloadSet" init="true" navigate="true">
				<table align="left">
						<tr>
			       			<td rowspan="1"  valign="top"  width="500">
			       			<@CommonQueryMacro.PagePilot id="PagePilot"  maxpagelink="9" />
			        		<@CommonQueryMacro.DataTable id="datatable1" fieldStr="brcode,tlrno,tlrName,maxWl" width="500" readonly="false"/>
			        		</td>
			      		</tr>
			      		<tr>
			       			<td align="center">
			         		<@CommonQueryMacro.Button id= "btSave"/>
			        		</td>
			      	  	</tr>
			   </table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="javascript">
function btSave_postSubmit(button){
	Management_TlrWorkloadSet_dataset.flushData();
	alert("保存成功");
}
</script>
</@CommonQueryMacro.page>
