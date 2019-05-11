<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="工作流参数配置">

<@CommonQueryMacro.CommonQuery id="parammng_WorkFlowParam1" init="false">
	<table align="left">
			<tr>
       			<td valign="top" align="left">
       				<@CommonQueryMacro.Group id="intface" fieldStr="processTemplate,taskName,apptype" label="请输入查询条件" colNm=3/>
				</td>
			 </tr>
			 <tr>
       			<td valign="top" align="center">

       				<@CommonQueryMacro.Button id="btSave"/>

				</td>
			 </tr>
	 </table>


</@CommonQueryMacro.CommonQuery>

<script language="javascript">
	var v_selectTemplate;

 function processTemplate_DropDown_onSelect(dropDown,record,editor){

    	v_selectTemplate= record.getValue("processTemplate");
    	//alert(v_selectTemplate);
    	parammng_WorkFlowParam1_dataset.setValue("taskName", " ");
		parammng_WorkFlowParam1_dataset.setValue("taskNameName", " ");
		parammng_WorkFlowParam1_dataset.setValue("apptype", " ");
		parammng_WorkFlowParam1_dataset.setValue("appTypeName", " ");
		parammng_WorkFlowParam1_dataset.refreshControls();

     	WfpTaskSelect_DropDownDataset.clearData();
		WfpappTypeSelect_DropDownDataset.clearData();

     	return true;
    }

    function taskName_DropDown_beforeOpen(dropDown){
    	var o_selectTemplate=WfpTaskSelect_DropDownDataset.getParameter("selectTemplate");
    	if(o_selectTemplate && v_selectTemplate==o_selectTemplate){
			taskName_DropDown.cached = true;
		}else{
			taskName_DropDown.cached = false;
			WfpTaskSelect_DropDownDataset.setParameter("selectTemplate", v_selectTemplate);

		}
    }

     function apptype_DropDown_beforeOpen(dropDown){
    	var o_selectTemplate=WfpappTypeSelect_DropDownDataset.getParameter("selectTemplate");
    	if(o_selectTemplate && v_selectTemplate==o_selectTemplate){
			apptype_DropDown.cached = true;
		}else{
			apptype_DropDown.cached = false;
			WfpappTypeSelect_DropDownDataset.setParameter("selectTemplate", v_selectTemplate);

		}
    }

    function btSave_onClickCheck(button){
    	if(parammng_WorkFlowParam1_dataset.getValue("processTemplate")==""){
    		alert("【工作流模板名】不能为空");
    		return false;
    	}
    }
</script>

</@CommonQueryMacro.page>