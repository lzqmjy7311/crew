<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#--jianxue.zhang-->
<@CommonQueryMacro.page title="国家/地区代码信息审批">
<table width="800px" align="left">
 <tr>
 <td>
<@CommonQueryMacro.CommonQuery id="approve_biNation" init="true"  navigate="true" submitMode="all">
 <FIELDSET name='intface' style="padding: 8px;"><LEGEND>&nbsp;待审批国家/地区代码信息列表&nbsp;</LEGEND>
<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="id,chinaName,nationregionNumber,crtDt,updTransCd" width="100%" readonly="true" hasFrame="true" />	
 </FIELDSET>
</@CommonQueryMacro.CommonQuery>
 </td>
 </tr>
 
<tr>
 <td>
 <@CommonQueryMacro.CommonQuery id="approve_common" init="true"  navigate="false" submitMode="all">
 <table>
 <tr>
 <td>
  <@CommonQueryMacro.Group id ="group1" label="审批意见" fieldStr="approveResult,approveRemark" colNm=2/>
  </td>
  </tr>
  <tr>
  <td >
  
  	<@CommonQueryMacro.Button id= "btApprove"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<@CommonQueryMacro.Button id= "btBack"/>
  </td>
  </tr>
  </table>
  </@CommonQueryMacro.CommonQuery>
  </td>
  </tr>
</table>
<script language="javascript" src="${contextPath}/templets/ui/js/topTsk.js"></script>
<script language="javascript">
 function datatable1_id_onRefresh(cell, value, record){
	if(record){
		var type = record.getValue("intInsId");
		var sta = record.getValue("updTransCd");
	var rcdpk = record.getValue("adtRcdPk");
	cell.innerHTML = "<a href=\"Javascript:void(0);\" onClick=\"Javascript:detail.showUodoTaskDetail('"+type+"','"+sta+"','"+rcdpk+"')\">"+value+"</a>";
} else {
		cell.innerHTML = "";
	}
}

function btApprove_onClickCheck(button){
	approve_common_dataset.setValue("intInsId","110499");
	return true;
}
</script>

</@CommonQueryMacro.page>
