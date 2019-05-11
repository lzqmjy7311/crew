<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="客户信息">
<@CommonQueryMacro.CommonQuery id="CustomerReaInfo" init="true" insertOnEmpty="true">
<table>
	<tr><#--MOD  BY HUANGCHENG   2012-8-22 BEGIN-->
		<td><@CommonQueryMacro.GroupBox id="CustomerReaInfo" label="客户信息增加" expand="true">
			<table frame=void class="grouptable" width="900px">
               <tr>
                   <td colspan="2" align="center" nowrap class="labeltd" >客户号 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="id"/> </td>
  
	                	
                   <td rowspan="3" align="right" nowrap class="labeltd" > 证<br>件<br>信<br>息 </td>
                   <td colspan="1" align="center" nowrap class="labeltd" >证件号码 </td>
                   <td class="datatd"><@CommonQueryMacro.SingleField fId="paperCode"/>  </td>
 
               </tr>
               <tr>
                   <td colspan="2" align="center" nowrap class="labeltd" >客户类型 </td> 
                   <td class="datatd"><@CommonQueryMacro.SingleField fId="customerType"/> </td>
    
	               <td colspan="1"  align="center" nowrap class="labeltd" >证件类型 </td>
		           <td class="datatd"><@CommonQueryMacro.SingleField fId="paperType"/></td>
   
               </tr>
               <tr>
                   <td colspan="2" align="center" nowrap class="labeltd" >客户名称 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="customerName"/> </td>
    
		           <td colspan="1"  align="center" nowrap class="labeltd" >证件类型备注 </td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="paperTypeMemo"/> </td>
    
               </tr>
               <tr>
                   <td colspan="2" align="center" nowrap class="labeltd" >英文名称</td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="customerEnname"/> </td>
    
		           <td rowspan="3" align="center" nowrap class="labeltd" >对公<br>客户<br>法人<br>信息 </td>
		           <td align="center" nowrap class="labeltd" >对公客户法定代表人姓名 </td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="corporationRepname"/>  </td>
    
               </tr>
               <tr>
                   <td colspan="2" align="center" nowrap class="labeltd" >联系电话 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="telephone"/> </td>

		           <td align="center" nowrap class="labeltd" >对公客户法定代表人身份证件号码 </td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="corporationPaperId"/>  </td>
    
              </tr>
               <tr>
                   <td colspan="2" align="center" nowrap class="labeltd" >其他联系方式 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="customerOthers"/> </td>
    
		           <td align="center" nowrap class="labeltd" >对公客户法定代表人身份证件类型</td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="corporationPaperType"/>   </td>
   
              </tr>
               <tr>
                   <td colspan="2" align="center" nowrap class="labeltd" > 客户国籍 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="customerNationality"/> </td>
    
		           <td colspan="2" align="center" nowrap class="labeltd" >对公客户注册资金</td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="registrationMoney"/> </td>
    
              </tr>
               <tr>
                   <td colspan="2" align="center" nowrap class="labeltd" >客户地址 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="customerAddress"/> </td>
   
		           <td colspan="2" align="center" nowrap class="labeltd" >对私职业对公行业类型 </td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="vocationType"/>   </td>
   
              </tr>
               <tr>
                   <td colspan="2"  align="center" nowrap class="labeltd" >机构 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="orgId"/> </td>
   
		           <td colspan="2"  align="center" nowrap class="labeltd" >证券、保险机构标志 </td>
		           <td class="datatd" ><@CommonQueryMacro.SingleField fId="stockFlag"/>  </td>
    
              </tr>
               <tr>
                   <td colspan="2"  align="center" nowrap class="labeltd" >法人证件类型备注 </td>
                   <td class="datatd" ><@CommonQueryMacro.SingleField fId="farenPaperTypeMemo"/></td>
              </tr>
           </table>
           </@CommonQueryMacro.GroupBox>
           <#--END-->
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;<@CommonQueryMacro.Button id= "btBack"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript"> 
var op = "${RequestParameters["op"]?default('')}";
//当页面初始化完之后可以调用该方法执行需要处理的操
function initCallGetter_post(dataset) {
	if ("new" == op) {
	} else {
		CustomerReaInfo_dataset.setFieldReadOnly("id",true);
	}
}
function  CustomerReaInfo_dataset_afterChange(data,field){
	if(field.fieldName =="customerType"){
		var customerType = parseInt(CustomerReaInfo_dataset.getValue("customerType"));
		if(customerType ==2){
			CustomerReaInfo_dataset.setValue("corporationRepname","");
			CustomerReaInfo_dataset.setFieldReadOnly("corporationRepname",true);
			CustomerReaInfo_dataset.setValue2("corporationPaperType","");
			CustomerReaInfo_dataset.setFieldReadOnly("corporationPaperType",true);
			CustomerReaInfo_dataset.setValue("registrationMoney","");
			CustomerReaInfo_dataset.setFieldReadOnly("registrationMoney",true);
			CustomerReaInfo_dataset.setValue("corporationPaperId","");
			CustomerReaInfo_dataset.setFieldReadOnly("corporationPaperId",true);
			
			
		}else{
			CustomerReaInfo_dataset.setFieldReadOnly("corporationRepname",false);
			CustomerReaInfo_dataset.setFieldReadOnly("corporationPaperType",false);
			CustomerReaInfo_dataset.setFieldReadOnly("registrationMoney",false);
			CustomerReaInfo_dataset.setFieldReadOnly("corporationPaperId",false);
		}
	}
	
	if(field.fieldName =="corporationPaperType"){
		var corporationPaperType = CustomerReaInfo_dataset.getValue("corporationPaperType");
		if(corporationPaperType =="22"){
			CustomerReaInfo_dataset.setFieldReadOnly("farenPaperTypeMemo",false);
			CustomerReaInfo_dataset.getField("farenPaperTypeMemo").required = true;
		}else{
			CustomerReaInfo_dataset.setFieldReadOnly("farenPaperTypeMemo",true);
			CustomerReaInfo_dataset.getField("farenPaperTypeMemo").required = false;
		}
	}
	
	if(field.fieldName =="paperType"){
		var paperType = CustomerReaInfo_dataset.getValue("paperType");
		if(paperType == "22"){
			CustomerReaInfo_dataset.setFieldReadOnly("paperTypeMemo",false);
			CustomerReaInfo_dataset.getField("paperTypeMemo").required = true;
		}else{
			CustomerReaInfo_dataset.setFieldReadOnly("paperTypeMemo",true);
			CustomerReaInfo_dataset.getField("paperTypeMemo").required = false;
		}
	}
}

function btSave_onClickCheck(button) {
	var customerType = CustomerReaInfo_dataset.getValue("customerType");
	var customerTypeToInt = parseInt(customerType);
	var paperTypeToInt  = parseInt(CustomerReaInfo_dataset.getValue("paperType").substring(0,1));
	var vocationTypeToInt = parseInt(CustomerReaInfo_dataset.getValue("vocationType").substring(0,1));
	if(customerTypeToInt ==2){
		if(paperTypeToInt+1 != customerTypeToInt ){
			alert("对私类型的客户不能匹配对公客户证件类型");
			return false;
		}else if(vocationTypeToInt+1 !=customerTypeToInt ){
			alert("对私职业对公行业类型与客户类型["+customerType+"]不匹配");
			return false;
		}
	}else{
		if(paperTypeToInt ==1){
			alert("对公类型的客户不能匹配对私客户证件类型");
			return false;
		}else if(vocationTypeToInt ==1){
			alert("对私职业对公行业类型与客户类型["+customerType+"]不匹配");
			return false;
		} 
	}
	
	return true;
}
	

</script>
</@CommonQueryMacro.page>
