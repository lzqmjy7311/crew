<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="操作员增加">
<table align="left" width="100%">
	<@CommonQueryMacro.CommonQuery id="Management_SelectTlrAdd" init="false" navigate="true">
	<tr>
		<td align="center" rowspan="1"  valign="top" width="450">
				<@CommonQueryMacro.Group id="group1" label="操作员增加" fieldStr="brcode,extTlrno" colNm=6/>
			<@CommonQueryMacro.Button id= "btSave"/>
		</td>
	</tr>
	</@CommonQueryMacro.CommonQuery>
</table>
<script language="javascript">

//var v_selectTemplate ="";

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
