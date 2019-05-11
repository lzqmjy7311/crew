<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="����ȽϷ���">
<style>
div.form1{
    width:30px;height:10px;
	text-align:left;
	color:blue;
	background-color:gray;
	font-size:100%;
	}

span.style1{
	color:blue;
	background-color:gray;
	font-size:150%;
}
</style>

	<@CommonQueryMacro.CommonQuery id="TbCsmFinanceStatementData" init="false" submitMode="selected" navigate="false">
			<#assign jzyear=''>
			<#assign caliber=''>
			<#assign repno=''>
			<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
			<#assign chineseName="${RequestParameters['chineseName']?default('')}" />
			
			<table align="left" width="100%">
			    <tr>
					<td>
						<@CommonQueryMacro.Group id="group22" label="" colNm=8  
						fieldStr="jzyear,caliber,repno,project"/>
						<center>
						<@CommonQueryMacro.Button id="btModOrAdd" />
						</center>
					</td>
				</tr>
			
			    
			</table>
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.DynamicTabSet id="demotab" hasMenu="true" height="350" selected="t1">
			        <@CommonQueryMacro.DynamicTab id="t1" title="�ʲ���ծ��" url="/gbicc-com-pages/FinanciaAnalysis/ftl/TbCsmFinanceStatementData.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
			        <@CommonQueryMacro.DynamicTab id="t2" title="�����" url="/gbicc-com-pages/FinanciaAnalysis/ftl/TbCsmFinanceStatementData03.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
			        <@CommonQueryMacro.DynamicTab id="t3" title="�ʽ�������" url="/gbicc-com-pages/FinanciaAnalysis/ftl/TbCsmFinanceStatementData.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
	</@CommonQueryMacro.DynamicTabSet>






<script language="JavaScript">

function btModOrAdd_onClickCheck(button){
 var jzyear =TbCsmFinanceStatementData_dataset.getValue('jzyear');
 var caliber =TbCsmFinanceStatementData_dataset.getValue('caliber');
 var repno  =TbCsmFinanceStatementData_dataset.getValue('repno');
 var project  =TbCsmFinanceStatementData_dataset.getValue('project');
 var customerNum='${customerNum}';
 var chineseName='${chineseName}';
 
  //��֤�ж�
		 if(!!!jzyear){
		   easyMsg.info('��Ȳ���Ϊ�գ�');
		   return false;
		 }else if(!!!caliber){
		   easyMsg.info('�ھ�����Ϊ�գ�');
		   return false;
		 }else if(!!!repno){
		   easyMsg.info('��������Ϊ�գ�');
		   return false;
		 }
   var caliberName =TbCsmFinanceStatementData_dataset.getValue('caliberName');
   var repnoName  =TbCsmFinanceStatementData_dataset.getValue('repnoName');		 		 
  demotab_tabset.refresh("t1", "/gbicc-com-pages/FinanciaAnalysis/ftl/TbCsmFinanceStatementData.ftl?jzyear="+jzyear+'&caliber='+ caliber+"&repno="+repno+"&finType=01&customerNum="+customerNum+"&project="+project);
  demotab_tabset.refresh("t2", "/gbicc-com-pages/FinanciaAnalysis/ftl/TbCsmFinanceStatementData03.ftl?jzyear="+jzyear+'&caliber='+ caliber+"&repno="+repno+"&finType=03&customerNum="+customerNum+"&project="+project);
  demotab_tabset.refresh("t3", "/gbicc-com-pages/FinanciaAnalysis/ftl/TbCsmFinanceStatementData.ftl?jzyear="+jzyear+'&caliber='+ caliber+"&repno="+repno+"&finType=02&customerNum="+customerNum+"&project="+project);
}

	
function repno_DropDown_beforeOpen(dropDown){

			var caliber = TbCsmFinanceStatementData_dataset.getValue('caliber');//���ݵ�һ��selectId��õ�һ��selectֵ
			if(!caliber) return "��ѡ��ھ�!";//�жϵ�һ��select��ֵ�Ƿ�Ϊ�գ����Ϊ��ֱ�ӷ���һ���ַ���
			repnoSelect_DropDownDataset.setParameter("dataTypeNo",caliber); 
			repno_DropDown.cached=false;//��qGroupId�����뻺��
		}
function caliber_DropDown_onSelect(dropDown,record,editor){
			var oldVal = TbCsmFinanceStatementData_dataset.getValue("caliber");//��һ�ε�ֵ
		    
            var newVal = record ? record.getValue('data') : '';//���ڵ�ֵ
			if(oldVal!=newVal){		
			//�ж����ε�ֵ�Ƿ���ȣ��������Ȱ�ֵ����
				TbCsmFinanceStatementData_dataset.setValue('repno','');
				TbCsmFinanceStatementData_dataset.setValue('repnoName','');
			}
			return true;
		}


//����ͳ����
function project_DropDown_onKeyup(val){
	if(val.length>=0){
		return true;
	}
	return false;
}

</script>
</@CommonQueryMacro.page>