<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="审批权限设置">
<@CommonQueryMacro.CommonQuery id="parammng_AuthoritySet3" init="true" navigate="true" parameters="action=query">
<table align="left">
<tr>
<td valign="top" rowspan="1"  valign="top">
	<table align="left">
			<tr>
       		<td valign="top"  valign="top">
       			<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9999"/>
         		<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="tlrno,bussType,bizTypeName1,limitMaxamount" />
       		</td>
      		</tr>
   </table>
</td>
<td valign="top" rowspan="1"  valign="top">
	<table align="left">
			<tr>
       			<td rowspan="1"  valign="top"  width="500">
        		<@CommonQueryMacro.Group id="group1" label="操作员信息" fieldStr="tlrno,bussType,bizTypeName,limitMaxamount" colNm=4/>
        		</td>
      		</tr>
      		<tr>
       			<td align="center">
         		<@CommonQueryMacro.Button id= "btNew"/>
         		&nbsp;&nbsp;&nbsp;&nbsp;
         		<@CommonQueryMacro.Button id= "btDelete"/>
         		&nbsp;&nbsp;&nbsp;&nbsp;
         		<@CommonQueryMacro.Button id= "btSave"/>
        		</td>
      	  	</tr>
   </table>

</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
<#assign v_startdate = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTxdate()>
<#assign enddate = statics["com.huateng.ebank.framework.util.DataFormat"].stringToDate("2099-12-31")>
<#assign v_enddate = "2099-12-31">

var  v_count=0;
var  v_startdate = "${v_startdate}";
var  v_enddate = "${v_enddate}";
v_init = 0;
v_errorMessage ="";
v_delete = 0 ;
var tlrno = "";

function parammng_AuthoritySet3_dataset_afterChange(dataset ,field)
{
  	v_limitamount = parammng_AuthoritySet3_dataset.getValue("limitMaxamount");
  	v_tlrno = parammng_AuthoritySet3_dataset.getString("tlrno");

}

function checkReadOnly(){
	v_id = parammng_AuthoritySet3_dataset.getValue("id");
	if(v_id!="")
	{

	}
	else
	{
			parammng_AuthoritySet3_dataset.setFieldReadOnly("tlrno",false);
  			parammng_AuthoritySet3_dataset.setFieldReadOnly("bussType",false);
  			parammng_AuthoritySet3_dataset.setFieldReadOnly("bizTypeName",false);
  			parammng_AuthoritySet3_dataset.setFieldReadOnly("limitMaxamount",false);
		}
}

function btNew_onClick(button){

		//checkReadOnly();
   		return true;
}

function parammng_AuthoritySet3_dataset_afterScroll(dataset){

	if( dataset.length == 0){
		btDelete.disable(true);
	}else{
		btDelete.disable(false);
	}
}
function btDelete_onClickcheck(button){
	 	alert("请注意保存数据");
}

function btSave_postSubmit(button){
		parammng_AuthoritySet3_dataset.flushData(parammng_AuthoritySet3_dataset.pageIndex);
	 	alert("保存成功");
}

function bizTypeName_DropDown_beforeOpen(dropdown){
	bizTypeName_DropDown.cached=false;
	SelectTempCreditinfo_DropDownDataset.setParameter("typeNo","3");
	SelectTempCreditinfo_DropDownDataset.flushData(0);
	SelectTempCreditinfo_DropDownDataset.insertRecord("begin");
	SelectTempCreditinfo_DropDownDataset.firstUnit.setValue("code", "0000");
	SelectTempCreditinfo_DropDownDataset.firstUnit.setValue("name", "不限");
}
</script>

</script>


</@CommonQueryMacro.page>