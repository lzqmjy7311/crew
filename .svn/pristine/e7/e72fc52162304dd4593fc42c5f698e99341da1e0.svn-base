<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="多表头表格">
	<@CommonQueryMacro.CommonQuery id="GridFields" init="true" submitMode="current" navigate="false">
		<#-- 多表头的配置: 组合列{data1;列2{textString3|dialog}}(最多支持三层,最低层字段之间用|分隔,第二层用;分隔) --> 
		<@CommonQueryMacro.DataTable id="demodatatabale" fieldStr="col1,组合列1{col2;组合列2{col3|col4}},col5,col6,col7,col8,col9" />
		
		
		<#--  组合域{col1[20]:年;col2[20]:月;col3[30]:日}[colspanvalue]  -->
		
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>