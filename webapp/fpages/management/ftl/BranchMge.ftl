<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="������Ϣά��">
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
        			<@CommonQueryMacro.Group id="group1" label="������Ϣά��"
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
		  //���ݿ��еļ�¼��
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
					alert("�ֶΡ��������롿����Ϊ����");
					Management_branchManage_dataset.setValue2("postno","");
					return false;
				}else if( v_postno.indexOf('-') != -1){
					alert("�ֶΡ��������롿����Ϊ����");
					Management_branchManage_dataset.setValue2("postno","");
					return false;
				}else if(v_postno.length<6&&v_postno.length!=0){
					alert("�ֶΡ��������롿����Ϊ6λ");
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
  				alert("�ֶΡ���ϵ�绰��ֻ�ܰ���-������");
  				Management_branchManage_dataset.setValue2("teleno","");
  				return false;
  			}
 		}
			}
		}

		function btnAdd_onClick(button){
			var  v_brcode = Management_branchManage_dataset.getValue("brcode");
			  //���ݿ��еļ�¼��
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
  //      alert("¼��������¼��󣬰�����ȷ����");
        return checkValue();
       }

      function btSave_postSubmit(button)
      {
      		//btnDel.disabled=false;
      		Management_branchManage_dataset.setFieldReadOnly("brno",true);
			Management_branchManage_dataset.setFieldReadOnly("brname",false);
        	alert("����ɹ�");
      }

      function btSave_onClickCheck(button)
      {
		    return checkValue();
      }

      function checkValue()
		{
			if(Management_branchManage_dataset.getValue("blnUpBrcode")==""&&Management_branchManage_dataset.getValue("brclass")!="1")
			{
				alert("�ֶ�[�ϼ�����]��ӦΪ�ա�");
	 	 		return false;
			}

			if(Management_branchManage_dataset.getValue("brclass")=="")
			{
				alert("�ֶ�[��������]��ӦΪ�ա�");
	 	 		return false;
			}
			return true;
		}
      //  function btnDel_onClickCheck(button)
     //{
    //	 alert("�밴����ȷ����");
   //  }

	function brclass_DropDown_onSelect(dropDown,record,editor)
	{
	   var brclass  = record.getValue("data").trim();
	   var length  = Management_branchManage_dataset.length;
		var flag = true;
	   if(length>1&&brclass=="1"){
	   		alert("ֻ����һ������!");
	   		flag = false;
	   }
		if(!flag){
			return false;
		}

	   return true;
	}
//ȥ��ҳ�桰�������С��ֶΣ�����ѡ�С��ϼ��������ֶ�ʱ���Զ������������С���ֵ
	function blnUpBrcode_DropDown_onSelect(dropDown,record,editor)
	{
	   var blnUpBrcode  = record.getValue("brcode").trim();
	   Management_branchManage_dataset.setValue2("blnBranchBrcode",blnUpBrcode);
	   return true;

	}

</script>
</@CommonQueryMacro.page>