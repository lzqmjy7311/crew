<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="利率手工录入">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="intrateManualInput" init="true">
<table align="left">
			<tr>
       			<td valign="top" rowspan="2"  valign="top">
       				<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9"/>
          			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="curcd,intratecd,eftdt,ratetype,ratename,rateunit,ratevalue" readonly="true"/></br>

        		</td>
      		<td valign="top">
      		<table>
      		<tr>
      		<td align="left" valign="top" width="800">
        			<@CommonQueryMacro.Group id="group2" label="利率手工录入" fieldStr="curcd,intratecd,ratetype,ratename,rateunit,ratevalue" />
        	</td>
      		</tr>
      		<tr>
      		<table>
       			<td align="center">
         			<@CommonQueryMacro.Button id= "btNew"/>
         			<@CommonQueryMacro.Button id= "btDel"/>
         			<@CommonQueryMacro.Button id= "btSave"/>

        		</td>
        	</table>
      	  	</tr>
      	  	</table>
      		</td>
      		</tr>
   </table>
<script language="javascript">


		var v_flag = 0;
		var v_ratevalue;

        function intrateManualInput_dataset_afterScroll(dataset){
		  v_id = intrateManualInput_dataset.getValue("id");
		  if (!isNaN(v_id)){
	//	    intrateManualInput_dataset.setReadOnly(true);
			intrateManualInput_dataset.setFieldReadOnly("curcd",true);
			intrateManualInput_dataset.setFieldReadOnly("intratecd",true);

			intrateManualInput_dataset.setFieldReadOnly("ratetype",true);
			intrateManualInput_dataset.setFieldReadOnly("ratename",true);
			intrateManualInput_dataset.setFieldReadOnly("rateunit",true);
		    intrateManualInput_dataset.setFieldReadOnly("ratevalue",false);
//		    intrateManualInput_dataset.setValue2("deleteflag","true");
		  }else{
	//	    intrateManualInput_dataset.setReadOnly(false);
			intrateManualInput_dataset.setFieldReadOnly("curcd",false);
			intrateManualInput_dataset.setFieldReadOnly("intratecd",false);

			intrateManualInput_dataset.setFieldReadOnly("ratetype",false);
			intrateManualInput_dataset.setFieldReadOnly("ratename",false);
			intrateManualInput_dataset.setFieldReadOnly("rateunit",false);
		    intrateManualInput_dataset.setFieldReadOnly("ratevalue",false);
		  }
		  return true;
		}

		function btDel_onClickCheck(button)
		{
			if(intrateManualInput_dataset.getValue("deleteflag")=="true"){
				alert("现有的利率不能删除。");
				return false;
			}
		}

		//利率值输入两遍正确性校验
		function intrateManualInput_dataset_afterChange(dataset, field){
			if(field.name == "ratevalue"){
				if(v_flag==0){
					v_ratevalue = intrateManualInput_dataset.getValue("ratevalue");
					v_flag = 1;
					intrateManualInput_dataset.setValue2("ratevalue","");
					alert("请再次输入新利率值。");
					v_flag = 2;
				}
				else if(v_flag==2){
					if(v_ratevalue!=intrateManualInput_dataset.getValue("ratevalue")){
						v_flag = 1;
						intrateManualInput_dataset.setValue2("ratevalue","");
						alert("两次输入利率值不一致，请重新输入。");
					}
					v_flag = 0;
				}
			}
		}
</script>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>
