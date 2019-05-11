<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="汇率查询">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="Management_IntrateQuery" init="false">
<table align="left">
			<tr>
       			<td valign="top" rowspan="2"  valign="top">
       				<@CommonQueryMacro.Interface id="intface" label="查询条件" colNm="6"  />
        		</td>
      	  	</tr>
   </table>
   		<tr>
        		<td align="left" valign="top" width="700">
        			<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9"/><#--fieldStr="curcd,intratecdName,intrate,yrIntrate,brcodeName,effectDate,expireDate"-->
          			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="curcd,intratecdName,yrIntrate,ratePerMonth,brcodeName,effectDate" readonly="true"/></br>
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
<#--
	function Management_IntrateQuery_interface_dataset_afterChange(dataset,field,value){
		if(field.fieldName == "effectDate" || field.fieldName == "expireDate"){
			var effectDate = Management_IntrateQuery_interface_dataset.getValue("effectDate");
			var expireDate = Management_IntrateQuery_interface_dataset.getValue("expireDate");
			if(effectDate!="" && expireDate!="") {
				if(effectDate>=expireDate) {
					alert("生效日期应该小于失效日期");
					Management_IntrateQuery_interface_dataset.setValue2("expireDate","effectDate");
					return false;
				}
			}
		}
	}
-->
</script>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>



</table>
</@CommonQueryMacro.page>
