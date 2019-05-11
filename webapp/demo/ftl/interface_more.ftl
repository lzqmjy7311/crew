<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="普通表格">
	<@CommonQueryMacro.CommonQuery id="GridFields" init="true" submitMode="current" navigate="false">
 		<@CommonQueryMacro.Interface id="interface2" label="查询条件" fieldStr="qCol1,qCol2" moreFieldStr="qCol3,qCol4,qCol5,qCol6" />
 		
 		<@CommonQueryMacro.DataTable id="demodatatabale" fieldStr="col1,col2,col3,col4,col5,col6,col7,col8,col9" height="" />
	</@CommonQueryMacro.CommonQuery>
	<script>
	</script>
</@CommonQueryMacro.page>