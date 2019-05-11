<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="工作流参数配置">

<@CommonQueryMacro.CommonQuery id="BrhWorkFlowMng1" init="false" mode="2">
	<table align="left">
			<tr>
       			<td valign="top" align="left">
       				<@CommonQueryMacro.Group id="intface" fieldStr="brcode" label="请输入查询条件" colNm=3/>
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
		parammng_WorkFlowParam1_dataset.setValue("appType", " ");
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

     function appType_DropDown_beforeOpen(dropDown){
    	var o_selectTemplate=WfpappTypeSelect_DropDownDataset.getParameter("selectTemplate");
    	if(o_selectTemplate && v_selectTemplate==o_selectTemplate){
			appType_DropDown.cached = true;
		}else{
			appType_DropDown.cached = false;
			WfpappTypeSelect_DropDownDataset.setParameter("selectTemplate", v_selectTemplate);

		}
    }
</script>

</@CommonQueryMacro.page>