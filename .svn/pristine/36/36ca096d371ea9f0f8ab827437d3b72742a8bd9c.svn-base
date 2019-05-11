<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="¿É±à¼­±í¸ñ">
	<@CommonQueryMacro.CommonQuery id="GridFields" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.DataTable id="demodatatabale" paginationbar="btn1,btn2" readonly="false" fieldStr="col1,col2,col3,col4,col5,staticComboboxDic,dynamicComboboxCQ,dateSelect" />
	</@CommonQueryMacro.CommonQuery>
	<script>
       function  demodatatabale_beforeEdit(rowIndex,record){
    	   if(rowIndex==0) return false;
    	   else return true;
       }	
	</script>
</@CommonQueryMacro.page>