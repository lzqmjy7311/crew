<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="工作流参数配置">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="parammng_WorkFlowParam" init="true">
	<table align="left">
			<tr>

       			<td valign="top" rowspan="2"  valign="top"><#--id,processTemplateName,taskNameName,appTypeName,brclassName,bizSubclassName,roleType -->
          			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="id,processTemplateName,taskNameName,appTypeName,brclassName,bizSubclassName" readonly="true"/></br>
                    &nbsp;
                    &nbsp;

        		</td>

        		<td align="left" valign="top" width="160">
        			<table align="center">
        				<tr>
       					<td  ><#-- processTemplate,taskName,appType,brclass,bizClass,bizSubclass,brcodeType,actBrcode,brcodeList,assignType,amtType,tlrnoList,roleType,pass -->
        					<@CommonQueryMacro.Group id="group1" label="工作流参数配置" fieldStr="processTemplate,taskName,apptype,brclass,bizClass,bizSubclass,brcodeType,actBrcode,brcodeList,assignType,amtType,tlrnoList,workflowRole,pass" colNm=2/>

        				</td>
						<tr align="center">
       					<td >
       						<@CommonQueryMacro.Button id= "btNew"/>

							<@CommonQueryMacro.Button id= "btDelete"/>
						</td>
						</tr>
						<tr align="center">
       					<td >
							<@CommonQueryMacro.Button id= "btSave"/>
						</td>
						</tr>
					</table>
        		</td>

      		</tr>

   </table>
 <script language="javascript">
	var v_selectTemplate;
    var v_selectbizClass;
    var v_selecttaskName;

// add by wuzhiwei
function brcodeType_DropDown_onSelect(dropDown,record,editor){
  // var brcodeTypeValus = parammng_WorkFlowParam_dataset.getParameter("brcodeType");
   if(record.getValue("data").trim()==1)//指定机构
   {
   		parammng_WorkFlowParam_dataset.setFieldReadOnly("actBrcode",false);
		parammng_WorkFlowParam_dataset.setFieldReadOnly("brcodeList",false);
	    //brcodeList.readOnly=true;
   }
   else//不指定机构
   {
   		 parammng_WorkFlowParam_dataset.setValue2("brcodeList","");
   		 parammng_WorkFlowParam_dataset.setValue2("actBrcode","");
   		 parammng_WorkFlowParam_dataset.setFieldReadOnly("actBrcode",true);
		 parammng_WorkFlowParam_dataset.setFieldReadOnly("brcodeList",true);
   }
  return true;
}

// add by wuzhiwei
function editor_actBrcode_onSetValue(editor,value)
{
   if(value=="")
   {
   	  return true;
   }
   var actBrcode='' ; 	//记录所选brcode   外部5位
   var temp=''; 		//临时存储变量
   for(var i=0; i<value.length; i++)   //从"brcode-brname"  中获取brcode
   {
	temp = value.charAt(i);
	if(temp != '-')
		actBrcode +=temp;
	else
		break;
   }

	var oldBrcode = parammng_WorkFlowParam_dataset.getValue("brcodeList");//原多行文本框中的值
	var newBrcode ='';
	if(oldBrcode.length==0||oldBrcode==' ')
	{
	 newBrcode=actBrcode;
	}else
	{
	 newBrcode = oldBrcode+','+actBrcode //新加后的值
	}
	if(oldBrcode.indexOf(actBrcode)==-1)  //判断所选中的brcode是否存在，存在则跳过，不记录
	{
	     parammng_WorkFlowParam_dataset.setValue("brcodeList",newBrcode);
	}
	else //否则说明不存在，则记录 。 新增
	{
		return true ;
	}
	return true ;
}
// add by wuzhiwei
//function actBrcode_DropDown_onSelect(dropDown,record,editor){
   //var brcodeTypeValus = parammng_WorkFlowParam_dataset.getParameter("actBrcodeName");
  // alert(record.getValue("data"));
  // alert(brcodeTypeValus);
   //if(record.getValue("data").trim()==1)
   //{

   //		 parammng_WorkFlowParam_dataset.setFieldReadOnly("actBrcode",false);
   //}
 // return true;
//}

   function processTemplate_DropDown_onSelect(dropDown,record,editor){

    	v_selectTemplate= record.getValue("processTemplate");
    	//alert(v_selectTemplate);
    	parammng_WorkFlowParam_dataset.setValue2("taskName", " ");
		parammng_WorkFlowParam_dataset.setValue2("taskNameName", " ");
		parammng_WorkFlowParam_dataset.setValue2("bizClass", " ");
		parammng_WorkFlowParam_dataset.setValue2("bizClassName", " ");
		parammng_WorkFlowParam_dataset.setValue2("apptype", " ");
		parammng_WorkFlowParam_dataset.setValue2("appTypeName", " ");
		parammng_WorkFlowParam_dataset.setValue2("brclass", " ");
		parammng_WorkFlowParam_dataset.setValue2("bizSubclass", " ");
		parammng_WorkFlowParam_dataset.setValue2("bizSubclassName", " ");
		parammng_WorkFlowParam_dataset.setValue2("brcodeType", " ");
		parammng_WorkFlowParam_dataset.setValue2("brcodeList", " ");
		parammng_WorkFlowParam_dataset.setValue2("assignType", " ");
		parammng_WorkFlowParam_dataset.setValue2("amtType", " ");
		parammng_WorkFlowParam_dataset.setValue2("tlrnoList", " ");
		parammng_WorkFlowParam_dataset.setValue2("workflowRole", " ");
		parammng_WorkFlowParam_dataset.setValue2("assignMode", " ");
		parammng_WorkFlowParam_dataset.setValue2("pass", " ");

		parammng_WorkFlowParam_dataset.refreshControls();
     	WfpTaskSelect_DropDownDataset.clearData();
     	WfpappTypeSelect_DropDownDataset.clearData();
     	WfpbizClassNameSelect_DropDownDataset.clearData();

	//	parammng_WorkFlowParam_dataset.setFieldReadOnly("taskName",false);
	//	parammng_WorkFlowParam_dataset.setFieldReadOnly("bizClass",false);
	//	parammng_WorkFlowParam_dataset.setFieldReadOnly("apptype",false);

     	return true;
    }

    function taskName_DropDown_beforeOpen(dropDown){
    	var o_selectTemplate=WfpTaskSelect_DropDownDataset.getParameter("selectTemplate");
    	if(o_selectTemplate==""){
    		WfpTaskSelect_DropDownDataset.setParameter("selectTemplate",parammng_WorkFlowParam_dataset.getValue("processTemplate"));
    		taskName_DropDown.cached = false;
    	}else{
    		if(o_selectTemplate && v_selectTemplate==o_selectTemplate){
				taskName_DropDown.cached = true;
			}else{
				taskName_DropDown.cached = false;
				WfpTaskSelect_DropDownDataset.setParameter("selectTemplate", v_selectTemplate);
			}
		}
    }

     function taskName_DropDown_onSelect(dropDown,record,editor){
    	v_selecttaskName = record.getValue("taskName");
    	//alert(v_selectbizClass);
    	parammng_WorkFlowParam_dataset.setValue("brclass", " ");
		parammng_WorkFlowParam_dataset.setValue("brclassName", " ");
		parammng_WorkFlowParam_dataset.refreshControls();

     	WfpbrclassSelect_DropDownDataset.clearData();


     	return true;
    }

	function brclass_DropDown_beforeOpen(dropDown){
    	var o_selecttaskName=WfpbrclassSelect_DropDownDataset.getParameter("selecttaskName");
   		 if(o_selecttaskName==""){
  			 WfpbrclassSelect_DropDownDataset.setParameter("selecttaskName",parammng_WorkFlowParam_dataset.getValue("taskName"));
    		 apptype_DropDown.cached = false;
  		  }else{
    		if(o_selecttaskName && v_selecttaskName==o_selecttaskName){
				brclass_DropDown.cached = true;
			}else{
			brclass_DropDown.cached = false;
			WfpbrclassSelect_DropDownDataset.setParameter("selecttaskName", v_selecttaskName);
			}
		}
	}

	function apptype_DropDown_beforeOpen(dropDown){
    	var o_selectTemplate=WfpappTypeSelect_DropDownDataset.getParameter("selectTemplate");
   		 if(o_selectTemplate==""){
  			 WfpappTypeSelect_DropDownDataset.setParameter("selectTemplate",parammng_WorkFlowParam_dataset.getValue("processTemplate"));
    		 apptype_DropDown.cached = false;
  		  }else{
    		if(o_selectTemplate && v_selectTemplate==o_selectTemplate){
				apptype_DropDown.cached = true;
			}else{
			apptype_DropDown.cached = false;
			WfpappTypeSelect_DropDownDataset.setParameter("selectTemplate", v_selectTemplate);
			}
		}
	}


 	function bizClass_DropDown_beforeOpen(dropDown){//审批类型
    	var o_selectTemplate=WfpbizClassNameSelect_DropDownDataset.getParameter("selectTemplate");
 		if(o_selectTemplate==""){
  			 WfpbizClassNameSelect_DropDownDataset.setParameter("selectTemplate",parammng_WorkFlowParam_dataset.getValue("processTemplate"));
    		bizClass_DropDown.cached = false;
   		 }else{
    		if(o_selectTemplate && v_selectTemplate==o_selectTemplate){
				bizClass_DropDown.cached = true;
			}else{
				bizClass_DropDown.cached = false;
				WfpbizClassNameSelect_DropDownDataset.setParameter("selectTemplate", v_selectTemplate);
			}
		}
    }

      function bizClass_DropDown_onSelect(dropDown,record,editor){
    	v_selectbizClass= record.getValue("bizClass");
    	//alert(v_selectbizClass);
    	parammng_WorkFlowParam_dataset.setValue("bizSubclass", " ");
		parammng_WorkFlowParam_dataset.setValue("bizSubclassName", " ");
		parammng_WorkFlowParam_dataset.refreshControls();
		parammng_WorkFlowParam_dataset.setFieldReadOnly("bizSubclass",false);

     	WfpbizSubclassNameSelect_DropDownDataset.clearData();


     	return true;
    }

    function bizSubclass_DropDown_beforeOpen(dropDown){
    	var o_selectbizSubclass=WfpbizSubclassNameSelect_DropDownDataset.getParameter("selectbizSubclass");
    	if(o_selectbizSubclass && v_selectbizClass==o_selectbizSubclass){
			bizSubclass_DropDown.cached = true;
		}else{
			bizSubclass_DropDown.cached = false;
			WfpbizSubclassNameSelect_DropDownDataset.setParameter("selectbizSubclass", v_selectbizClass);

		}
    }


function parammng_WorkFlowParam_dataset_afterChange(dataset ,field)
{
  	v_assignType = parammng_WorkFlowParam_dataset.getValue("assignType");

  	if(field.name == "assigntype"){
		parammng_WorkFlowParam_dataset.setValue2("tlrnoList","");
	   if(v_assignType == "1"){
	   		parammng_WorkFlowParam_dataset.setFieldReadOnly("tlrnoList",true);
	   		parammng_WorkFlowParam_dataset.setFieldReadOnly("workflowRole",false);
	   	}else if(v_assignType == "0"){
	   		parammng_WorkFlowParam_dataset.setFieldReadOnly("tlrnoList",false);
	   		parammng_WorkFlowParam_dataset.setFieldReadOnly("workflowRole",true);
	   	}else if(v_assignType == "2"){
	   		parammng_WorkFlowParam_dataset.setFieldReadOnly("tlrnoList",true);
	   		parammng_WorkFlowParam_dataset.setFieldReadOnly("workflowRole",true);
	   	}
  	}
}

		function checkReadOnly(){
			parammng_WorkFlowParam_dataset.setFieldReadOnly("processTemplate",false);
  			parammng_WorkFlowParam_dataset.setFieldReadOnly("workflowRole",false);
}

function checkNeedValue(){
	v_brcodeType = parammng_WorkFlowParam_dataset.getValue("brcodeType");
  	v_assignType = parammng_WorkFlowParam_dataset.getValue("assignType");
	v_brcodeList = parammng_WorkFlowParam_dataset.getValue("brcodeList");
	v_tlrnoList = parammng_WorkFlowParam_dataset.getValue("tlrnoList");
	if(v_brcodeType == "1"){
		if(v_brcodeList == ""){
			v_errorMessage = "字段[指定机构号列表]不应为空。";
			alert(v_errorMessage);
			return false ;
		}
	}
	if(v_assignType == "0"){
		if(v_tlrnoList == ""){
			v_errorMessage = "字段[操作员列表]不应为空。";
			alert(v_errorMessage);
			return false ;
		}
	}
	return true;
}

function checkValue(){

	v_processTemplate1 = parammng_WorkFlowParam_dataset.getValue("processTemplate");
	v_taskName = parammng_WorkFlowParam_dataset.getValue("taskName");
	v_apptype = parammng_WorkFlowParam_dataset.getValue("apptype");
	v_brclass = parammng_WorkFlowParam_dataset.getValue("brclass");
	v_bizClass = parammng_WorkFlowParam_dataset.getValue("bizClass");
	v_bizSubclass = parammng_WorkFlowParam_dataset.getValue("bizSubclass");

		if(v_processTemplate1 == " " || v_taskName == " "
			|| v_apptype == " " || v_brclass == " "
			|| v_bizClass == " " || v_bizSubclass == " "	)
		{
			v_errorMessage = "带【*】字段不应为空。";
				alert(v_errorMessage);
				return false ;
		}

	return true;
}

function btNew_onClick(button){

		checkReadOnly();
		checkNeedValue();

		parammng_WorkFlowParam_dataset.setValue2("pass",'0');
   		return true;
}

function parammng_WorkFlowParam_dataset_afterScroll(dataset){
	//变更所选记录时重新赋值，使下拉框可以正确重载
	v_selectTemplate = parammng_WorkFlowParam_dataset.getValue("processTemplate");
	v_selectbizClass = parammng_WorkFlowParam_dataset.getValue("bizClass");
	v_selecttaskName = parammng_WorkFlowParam_dataset.getValue("taskName");
	parammng_WorkFlowParam_dataset.refreshControls();
 	WfpTaskSelect_DropDownDataset.clearData();
 	WfpappTypeSelect_DropDownDataset.clearData();
 	WfpbizClassNameSelect_DropDownDataset.clearData();

	if( dataset.length == 0){
		btDelete.disable(true);
	}else{
		btDelete.disable(false);
	}

	//变更所选记录时禁止修改不可变更项

	var v_id = parammng_WorkFlowParam_dataset.getValue("id");
	if (!isNaN(v_id)&& v_id > 0){
		parammng_WorkFlowParam_dataset.setFieldReadOnly("processTemplate",true);
	}
	else{
		parammng_WorkFlowParam_dataset.setFieldReadOnly("processTemplate",false);
	}

	var v_brcodeType = parammng_WorkFlowParam_dataset.getValue("brcodeType");
   if(v_brcodeType==1)//指定机构
   {
   		parammng_WorkFlowParam_dataset.setFieldReadOnly("actBrcode",false);
		parammng_WorkFlowParam_dataset.setFieldReadOnly("brcodeList",false);
   }else //不指定机构
   {
   		 parammng_WorkFlowParam_dataset.setFieldReadOnly("actBrcode",true);
		 parammng_WorkFlowParam_dataset.setFieldReadOnly("brcodeList",true);
   }

   v_assignType = parammng_WorkFlowParam_dataset.getValue("assignType");
   if(v_assignType == "1"){
   		parammng_WorkFlowParam_dataset.setFieldReadOnly("tlrnoList",true);
   		parammng_WorkFlowParam_dataset.setFieldReadOnly("workflowRole",false);
   	}else if(v_assignType == "0"){
   		parammng_WorkFlowParam_dataset.setFieldReadOnly("tlrnoList",false);
   		parammng_WorkFlowParam_dataset.setFieldReadOnly("workflowRole",true);
   	}else if(v_assignType == "2"){
   		parammng_WorkFlowParam_dataset.setFieldReadOnly("tlrnoList",true);
   		parammng_WorkFlowParam_dataset.setFieldReadOnly("workflowRole",true);
   	}

   	parammng_WorkFlowParam_dataset.setFieldReadOnly("bizSubclass",true);
}

function btSave_onClickCheck(button){
	if(checkValue()){
		v_checkNeedValue = checkNeedValue();
		if(!v_checkNeedValue){
			return false;
		}else {
			btDelete.disable(false);

			return true;
		}
	}
	return false;
}

  function btSave_postSubmit(button)
      {

        	alert("保存成功");
        	parammng_WorkFlowParam_dataset.flushData(0);
      }
 </script>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>



</table>
</@CommonQueryMacro.page>