<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="贷款品种流程设置">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="Management_BrhWorkFlowMng" >
	<table align="left">
			<tr>
       			<td valign="top" rowspan="2"  valign="top">
          			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="brcodeName,processTemplateName,bizclassName,apptypeName" readonly="true"/>
        		</td>
        		<td align="left" valign="top" width="200">
        			<table align="center">
        				<tr>
       					<td>
       					<#-- fieldStr="brcode,processTemplate,lnid,apptype" -->
        					<@CommonQueryMacro.Group id="group1" label="贷款品种流程设置" fieldStr="brcode,processTemplate,bizClass,apptype" colNm=2/>

        					<table id="tableNature" style="display: none">
									<tr>
										<td align="left" width = "100">
										<#--<@CommonQueryMacro.Group id="group1" label="" fieldStr="nature" colNm=4/>-->
										</td>
									</tr>
							</table>
        				</td>
						</tr>

						<tr align="center">
       					<td >
       						<@CommonQueryMacro.Button id= "btNew"/>

							<@CommonQueryMacro.Button id= "btDelete"/>

							<@CommonQueryMacro.Button id= "btSave"/>
						</td>
						</tr>
					</table>
        		</td>

      		</tr>
   </table>
 <script language="javascript" src="${contextPath}/js/check.js"></script>
 <script language="JavaScript">

 	var v_selectTemplate;
 	var isEnable = false;

   function Management_BrhWorkFlowMng_dataset_afterScroll(dataset){
  		v_selectTemplate = Management_BrhWorkFlowMng_dataset.getValue("processTemplate");
		Management_BrhWorkFlowMng_dataset.refreshControls();
     	WfpappTypeSelect_DropDownDataset.clearData();

		v_id = Management_BrhWorkFlowMng_dataset.getValue("id");

		//数据库中的记录。
		if ( v_id.trim()!="" && v_id.trim()!="0"){
			Management_BrhWorkFlowMng_dataset.setFieldReadOnly("brcode", true);
			Management_BrhWorkFlowMng_dataset.setFieldReadOnly("bizclass", true);
			Management_BrhWorkFlowMng_dataset.setFieldReadOnly("apptype", true);
			Management_BrhWorkFlowMng_dataset.setFieldReadOnly("processTemplate", true);
		}
		else{
			Management_BrhWorkFlowMng_dataset.setFieldReadOnly("brcode", false);
			Management_BrhWorkFlowMng_dataset.setFieldReadOnly("bizclass", false);
			Management_BrhWorkFlowMng_dataset.setFieldReadOnly("apptype", false);
			Management_BrhWorkFlowMng_dataset.setFieldReadOnly("processTemplate", false);
		}
//		if(v_id.trim()=="1"){
//			document.all.tableNature.style.display="";
//		}else{
//			document.all.tableNature.style.display="none";
//		}
	}



	function processTemplate_DropDown_onSelect(dropDown,record,editor){
		v_selectTemplate= record.getValue("processTemplate");
    	//alert(v_selectTemplate);
		Management_BrhWorkFlowMng_dataset.setValue2("apptype", "");
		Management_BrhWorkFlowMng_dataset.setValue2("apptypeName", "");

		Management_BrhWorkFlowMng_dataset.refreshControls();
     	WfpappTypeSelect_DropDownDataset.clearData();

     	isEnable = false;

     	return true;
    }


    function apptype_DropDown_beforeOpen(dropDown){
    	var o_selectTemplate=WfpappTypeSelect_DropDownDataset.getParameter("selectTemplate");
    	//alert("o_selectTemplate=["+o_selectTemplate+"]");
    	//alert("selectTemplate=["+v_selectTemplate+"]");
    	//alert("curr Template=["+Management_BrhWorkFlowMng_dataset.getValue("processTemplate")+"]");
   		 if(o_selectTemplate==""){
   		 	//alert("new");
 			 WfpappTypeSelect_DropDownDataset.setParameter("selectTemplate",Management_BrhWorkFlowMng_dataset.getValue("processTemplate"));
    		 apptype_DropDown.cached = false;
  		  }else{
    		if(o_selectTemplate && v_selectTemplate==o_selectTemplate){
  		  	//alert("cach");
				apptype_DropDown.cached = true;
			}else{
			//alert("reload");
			apptype_DropDown.cached = false;
			WfpappTypeSelect_DropDownDataset.setParameter("selectTemplate", v_selectTemplate);
			}
		}
	}

//	function btDelete_onClickCheck(button){
//		var _record = Management_BrhWorkFlowMng_dataset.record;
//		var _recordState = _record.recordState;
//		var id = Management_BrhWorkFlowMng_dataset.getValue("id");
//		if(id != "" && (_recordState == "none" || _recordState == "modify")){
//			if(confirm("确定删除条记录？")){
//				Management_BrhWorkFlowMng_dataset.submitData="current";
//				Management_BrhWorkFlowMng_dataset.flushData(0);
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			Management_BrhWorkFlowMng_dataset.deleteRecord();
//			return false;
//		}
//	}

	function btSave_postSubmit()
	{
		alert("保存成功");
// 		Management_BrhWorkFlowMng_dataset.submitData="allchange";
		Management_BrhWorkFlowMng_dataset.flushData(0);
	}
			</script>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>



</table>
</@CommonQueryMacro.page>