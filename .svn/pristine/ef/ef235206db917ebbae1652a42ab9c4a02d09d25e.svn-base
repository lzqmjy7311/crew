<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="工作流参数配置">
<@CommonQueryMacro.CommonQuery id="workflowParamEntry" init="false" submitMode="all" >
	<table align="left">
			<tr valign="center">
       			<td valign="top">
					<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4  width="200"/>
				</td>
      		</tr>
      	<tr>
      		<td valign="top">
					<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="20"/>
					<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="procName,nodeName,nodeType1"  width="100%" hasFrame="true" height="150"  readonly="true"/>
			</td>
			<td>&nbsp</td></tr><tr>
      		<td valign="top">

					<@CommonQueryMacro.Group id ="group1" label="详细信息" fieldStr="procName,nodeName,brclass,nodeType1,bizClass,assignType,roleId" colNm=4/>

	  		<table>
        		<tr align="left">
        		<#--
	  				 <td align="center">
      					<@CommonQueryMacro.Button id= "btNew" />
      					&nbsp;&nbsp;&nbsp;&nbsp;
      				</td>

      				<td>
      					<@CommonQueryMacro.Button id= "btDelete"/>
      					&nbsp;&nbsp;&nbsp;&nbsp;
      				</td>
      				-->

      				<td width="600">
      					<@CommonQueryMacro.Button id= "btSave"/>
      					&nbsp;&nbsp;&nbsp;&nbsp;
      				</td>


      			</tr>
      		</table>
      		</td>
		 </tr>

	 </table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
var v_procName = "";
//流程名下拉框
function procName_DropDown_onSelect(dropDown,record,editor)
{
	v_procName = record.getValue("name");
	if( workflowParamEntry_dataset.length != 0){
		workflowParamEntry_dataset.setValue2("nodeName","");
		WorkflowTaskNameSelect_DropDownDataset.clearData();
	}
	return true;
}
//节点名下拉框打开前
function nodeName_DropDown_beforeOpen(dropDown)
{
	v_procName = workflowParamEntry_dataset.getValue("procName");
    var selectProc=WorkflowTaskNameSelect_DropDownDataset.getParameter("procNameQuery");
    if(selectProc && v_procName==selectProc){
		nodeName_DropDown.cached = true;

	}else{
		nodeName_DropDown.cached = false;
		var dataset = getDatasetByID("WorkflowTaskNameSelect_DropDownDataset");
	    dataset.setParameter("procNameQuery",v_procName);
    }
}

function btSave_postSubmit(button){
	alert("保存成功");
	workflowParamEntry_dataset.flushData(0);
}
//ADDED BY　HENRY 20110621 BEGIN
function workflowParamEntry_dataset_afterScroll(dataset){
	var _nodeType1 = dataset.getValue("nodeType1");
	if("3"==_nodeType1){
		dataset.setFieldReadOnly("brclass",true);
		dataset.setFieldReadOnly("bizClass",true);
		dataset.setFieldReadOnly("assignType",true);
		dataset.setFieldReadOnly("roleId",true);
	}
	else
	{
		dataset.setFieldReadOnly("brclass",false);
		dataset.setFieldReadOnly("bizClass",false);
		dataset.setFieldReadOnly("assignType",false);
		dataset.setFieldReadOnly("roleId",false);
	}

}
//ADDED BY　HENRY 20110621 END
</script>
</@CommonQueryMacro.page>
