<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="汇率手工录入">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="exchangeRateManualInput" init="true">
<table align="left">
			<tr>
       			<td valign="top" rowspan="2"  valign="top">
       				<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9"/>
          			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="curcd,currrate,currrateDate" readonly="true"/></br>

        		</td>
      		<td valign="top">
      		<table>
      		<tr>
      		<td align="left" valign="top" width="800">
        			<@CommonQueryMacro.Group id="group2" label="汇率手工录入" fieldStr="curcd,currrate" />
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
		var v_currrate;

        function exchangeRateManualInput_dataset_afterScroll(dataset){
		  v_deleteflag = exchangeRateManualInput_dataset.getValue("deleteflag");
		  if (v_deleteflag=="true"){
	//	    exchangeRateManualInput_dataset.setReadOnly(true);
			exchangeRateManualInput_dataset.setFieldReadOnly("curcd",true);
		    exchangeRateManualInput_dataset.setFieldReadOnly("currrate",false);
		  }else{
	//	    exchangeRateManualInput_dataset.setReadOnly(false);
			exchangeRateManualInput_dataset.setFieldReadOnly("curcd",false);
		    exchangeRateManualInput_dataset.setFieldReadOnly("currrate",false);
		  }
		  return true;
		}

		function btDel_onClickCheck(button)
		{
			if(exchangeRateManualInput_dataset.getValue("deleteflag")=="true"){
				alert("现有的汇率不能删除。");
				return false;
			}
		}

		function curcd_DropDown_onSelect(dropDown, record, editor){
		    var v_curcd = record.getValue("data");
		    if(v_curcd == "CNY"){
		       	alert("币种不能选择人民币，请重新输入");
			    exchangeRateManualInput_dataset.setValue2("curcd","");
			    return false;
		    }
		    return true;
        }
		//利率值输入两遍正确性校验
		function exchangeRateManualInput_dataset_afterChange(dataset, field){
			if(field.name == "currrate"){
				if(v_flag==0){
					v_currrate = exchangeRateManualInput_dataset.getValue("currrate");
					if(v_currrate<=0){
						alert("汇率不能为零或负数，请重新输入");
						return false;
					}
					v_flag = 1;
					exchangeRateManualInput_dataset.setValue2("currrate","");
					alert("请再次输入新利率值。");
					v_flag = 2;
				}
				else if(v_flag==2){
					if(exchangeRateManualInput_dataset.getValue("currrate")<=0){
						alert("汇率不能为零或负数，请重新输入");
						return false;
					}
					if(v_currrate!=exchangeRateManualInput_dataset.getValue("currrate")){
						v_flag = 1;
						exchangeRateManualInput_dataset.setValue2("currrate","");
						alert("两次输入利率值不一致，请重新输入。");
					}
					v_flag = 0;
				}
			}
		}

</script>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>
