<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="汇率查询">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="exchangeRateManualQuery" init="false">
<table align="left">
			<tr>
       			<td valign="top" rowspan="2"  valign="top">
       				<@CommonQueryMacro.Interface id="intface" label="查询条件" colNm=4  />
        		</td>
      	  	</tr>
   </table>
   		<tr>
        		<td align="left" valign="top" width="700">
        			<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9"/>
          			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="curcd,currrate,date" readonly="true"/></br>
        		</td>
        		</tr>
        		<tr align="center">
        		<td align="center">
        		<table>
        		<tr align="center">
				<td align="center">

      			</td>

      			</tr>
      			</table>
      			</td>
      			</tr>
      			</table>
      			</td>

      		 </tr>

<script language="javascript">
	function exchangeRateManualQuery_interface_dataset_afterChange(dataset,field,value){
		if(field.fieldName == "bgDate" || field.fieldName == "edDate"){
			var bgDate = exchangeRateManualQuery_interface_dataset.getValue("bgDate");
			var edDate = exchangeRateManualQuery_interface_dataset.getValue("edDate");
			if(bgDate!="" && edDate!="") {
				if(bgDate>edDate) {
					alert("起始日期应该小于等于结束日期");
					exchangeRateManualQuery_interface_dataset.setValue2("edDate","bgDate");
					return false;
				}
			}
		}
	}

</script>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>



</table>
</@CommonQueryMacro.page>
