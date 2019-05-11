<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="操作员查询">
<table align="left" width="100%">
	<@CommonQueryMacro.CommonQuery id="Management_QryTlrAdd" init="false" navigate="true">
	<tr>
		<td valign="top" rowspan="1"  valign="top">
				<@CommonQueryMacro.Group id="group1" label="操作员查询" fieldStr="brcode,extTlrno" colNm=6/>
		</td>
	</tr>
	<tr>
		<td align="center">
			<@CommonQueryMacro.Button id= "btSave"/>
		</td>
	</tr>
	</@CommonQueryMacro.CommonQuery>
</table>
<script language="javascript">

var v_selectTemplate ="";

//function brcode_DropDown_onSelect(dropDown,record,editor) {
//	v_selectTemplate = record.getValue("brcode");
//	AllDownDepartmentSelect_DropDownDataset.clearData();
//	AllDownDepartmentSelect_DropDownDataset.setParameter("brcode", v_selectTemplate);
//	AllDownDepartmentSelect_DropDownDataset.flushData(0);
//	departmentCode_DropDown.cached = false;
//	return true;
//}

</script>
</@CommonQueryMacro.page>
