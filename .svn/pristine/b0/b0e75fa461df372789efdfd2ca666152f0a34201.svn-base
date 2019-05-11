<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="机构信息维护">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="Management_branchManage" init="true" >
	<table align="left">
			<tr>
       			<td valign="top" rowspan="2"  valign="top">
       				<@CommonQueryMacro.PagePilot id="PagePilot"/>
       			<#--
          			<@CommonQueryMacro.DataTable id ="datatable2" fieldStr="brno,brname,brclass" readonly="true"/></br>
-->
          			<@CommonQueryMacro.DataTable id ="datatable2" fieldStr="brno,brname,brclass"  readonly="true"/></br>

        		</td>
      		<td valign="top">
      		<table>
      		<tr>
      			 <td align="left" valign="top" width="200">
        			<@CommonQueryMacro.Group id="group1" label="机构信息维护"
        			<#--
        			 fieldStr="brno,brname,billMailAddr,address,postno,teleno,brclass,blnBranchBrcode,blnUpBrcode,blnManageBrcode,plBrcode,brattr,otherAreaFlag,brManageType" colNm=4/>
        		-->
        			  fieldStr="brno,brname,address,postno,teleno,brclass,blnUpBrcode,blnManageBrcode,brattr,otherAreaFlag" colNm=4/>
        		</tr>
        		<tr align="center">
        		<td align="center">
        		<table>
        		<tr align="center">
        		<td align="center">
      				<@CommonQueryMacro.Button id= "btnAdd"/>
      			</td>
      			<td align="center">
      				<@CommonQueryMacro.Button id= "btnDel"/>
      			</td>
      			<td align="center">
      				<@CommonQueryMacro.Button id= "btSave"/>
      			</td>
      			</tr>
      			</table>
      			</td>
      			</tr>
      			</table>
      			</td>
      		</tr>
   </table>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>
         <script language="javascript">
        function Management_branchManage_dataset_afterScroll(dataset){
		 var  v_brcode = Management_branchManage_dataset.getValue("brcode");
		 var  v_brclass = Management_branchManage_dataset.getValue("brclass");
		  //数据库中的记录。
		  if ( v_brcode!="" ){
		    Management_branchManage_dataset.setFieldReadOnly("brno",true);
		    Management_branchManage_dataset.setFieldReadOnly("brname",false);
		  }else{
		    Management_branchManage_dataset.setFieldReadOnly("brno",false);
		    Management_branchManage_dataset.setFieldReadOnly("brname",false);
		  }
		  if ( v_brclass =="1" ){
		  	Management_branchManage_dataset.setFieldReadOnly("blnUpBrcode",true);
		  }else{
		  	Management_branchManage_dataset.setFieldReadOnly("blnUpBrcode",false);
		  }
		  return true;
		}
		function Management_branchManage_dataset_afterChange(dataset,field){
			if(field.name=="postno"){
			v_postno=Management_branchManage_dataset.getValue("postno");
				if(isNaN(v_postno)){
					alert("字段【邮政编码】必须为数字");
					Management_branchManage_dataset.setValue2("postno","");
					return false;
				}else if( v_postno.indexOf('-') != -1){
					alert("字段【邮政编码】必须为数字");
					Management_branchManage_dataset.setValue2("postno","");
					return false;
				}else if(v_postno.length<6&&v_postno.length!=0){
					alert("字段【邮政编码】必须为6位");
					Management_branchManage_dataset.setValue2("postno","");
					return false;
				}
				return true;
			}
			if(field.name=="teleno"){
				var v_teleno = Management_branchManage_dataset.getValue("teleno");
	    		var validChar = "0123456789-";
 				for (var i = 0; i < v_teleno.length; i++){
  				var c = v_teleno.charAt(i);
  				if ( validChar.indexOf(c) == -1){
  				alert("字段【联系电话】只能包含-和数字");
  				Management_branchManage_dataset.setValue2("teleno","");
  				return false;
  			}
 		}
			}
		}

		function btnAdd_onClick(button){
			var  v_brcode = Management_branchManage_dataset.getValue("brcode");
			  //数据库中的记录。
			  if (v_brcode!=""  ){
			    Management_branchManage_dataset.setFieldReadOnly("brno",true);
			     Management_branchManage_dataset.setFieldReadOnly("brname",false);
			  }else{
			    Management_branchManage_dataset.setFieldReadOnly("brno",false);
			    Management_branchManage_dataset.setFieldReadOnly("brname",false);
			  }
			}

	  function btnAdd_onClickCheck(button)
      {
      	//btnDel.disabled=true;
  //      alert("录入新增记录完后，按保存确定！");
        return checkValue();
       }

      function btSave_postSubmit(button)
      {
      		//btnDel.disabled=false;
      		Management_branchManage_dataset.setFieldReadOnly("brno",true);
			Management_branchManage_dataset.setFieldReadOnly("brname",false);
        	alert("保存成功");
      }

      function btSave_onClickCheck(button)
      {
		    return checkValue();
      }

      function checkValue()
		{
			if(Management_branchManage_dataset.getValue("blnUpBrcode")==""&&Management_branchManage_dataset.getValue("brclass")!="1")
			{
				alert("字段[上级机构]不应为空。");
	 	 		return false;
			}

			if(Management_branchManage_dataset.getValue("brclass")=="")
			{
				alert("字段[机构级别]不应为空。");
	 	 		return false;
			}
			return true;
		}
      //  function btnDel_onClickCheck(button)
     //{
    //	 alert("请按保存确定！");
   //  }

	function brclass_DropDown_onSelect(dropDown,record,editor)
	{
	   var brclass  = record.getValue("data").trim();
	   var length  = Management_branchManage_dataset.length;
		var flag = true;
	   if(length>1&&brclass=="1"){
	   		alert("只能有一个总行!");
	   		flag = false;
	   }
		if(!flag){
			return false;
		}

	   return true;
	}
//去掉页面“归属分行”字段，但当选中“上级机构”字段时，自动给“归属分行”赋值
	function blnUpBrcode_DropDown_onSelect(dropDown,record,editor)
	{
	   var blnUpBrcode  = record.getValue("brcode").trim();
	   Management_branchManage_dataset.setValue2("blnBranchBrcode",blnUpBrcode);
	   return true;

	}

</script>
</@CommonQueryMacro.page>