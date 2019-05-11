<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="审批权限设置">

<@CommonQueryMacro.CommonQuery id="parammng_AuthoritySet2" init="false" mode="2">
	<table align="left">
			<tr>
       			<td valign="top" align="left">
       				<@CommonQueryMacro.Group id="intface" fieldStr="brcode,tlrno,bussType,bizTypeName" label="请输入查询条件" colNm=3/>
				</td>
			 </tr>
			 <tr>
       			<td valign="top" align="center">

       				<@CommonQueryMacro.Button id="btSave"/>

				</td>
			 </tr>
	 </table>


</@CommonQueryMacro.CommonQuery>
<script>
function bizTypeName_DropDown_beforeOpen(dropdown){
	bizTypeName_DropDown.cached=false;
	SelectTempCreditinfo_DropDownDataset.setParameter("typeNo","3");
	SelectTempCreditinfo_DropDownDataset.flushData(0);
	SelectTempCreditinfo_DropDownDataset.insertRecord("begin");
	SelectTempCreditinfo_DropDownDataset.firstUnit.setValue("code", "0000");
	SelectTempCreditinfo_DropDownDataset.firstUnit.setValue("name", "不限");
}
</script>
</@CommonQueryMacro.page>