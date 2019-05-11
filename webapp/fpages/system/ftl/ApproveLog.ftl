<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#--jianxue.zhang-->
<@CommonQueryMacro.page title="主管确认">
<table width="100%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="approve_log" init="true" submitMode="current">
	<table width="100%">
		<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" colNm=4 showButton="true" />
        	</td>
        </tr>
		<tr>
   			<td colspan="2">
   				<@CommonQueryMacro.PagePilot id="PagePilot"/>
   			</td>

  		</tr>
  		<tr>
      		<td colspan="2">
          		<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="id[100],intInsId[100],updTransCd,intOperId,insCd,crtDt,approveResult[80],approveRemark" width="100%"  readonly="true"/></br>
        	</td>
        </tr>

  		<tr>
  			<td>
  				<@CommonQueryMacro.Button id= "btSee"/>
  			</td>

  		</tr>
   </table>
</@CommonQueryMacro.CommonQuery>

</td>
</tr>
</table>

<script language="javascript" src="${contextPath}/templets/ui/js/topTsk.js"></script>
 <script language="javascript">

//定位一条记录
function locate(id) {
	var record = UndoConfirm_dataset.find(["id"],[id]);
	if (record) {
		UndoConfirm_dataset.setRecord(record);
	}
}
//给id加链接
function datatable1_id_onRefresh(cell, value, record){
	if(record){
		var type = record.getValue("intInsId");
		var sta = record.getValue("updTransCd");
		var rcdpk = record.getValue("adtRcdPk");
		cell.innerHTML = "<a href=\"Javascript:void(0);\" onClick=\"Javascript:Compdetail.showCompTaskDetail('"+type+"','"+sta+"','"+rcdpk+"','"+value+"')\">"+value+"</a>";
 	}else {
		cell.innerHTML = "";
	}
}

</script>

</@CommonQueryMacro.page>