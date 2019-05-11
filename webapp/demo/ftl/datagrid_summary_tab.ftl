<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="合计表格">
	<@CommonQueryMacro.CommonQuery id="GridFields" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.DataTable id="demodatatabale" sumfieldstr="col8,col10" fieldStr="col1,col2,col3,col4,col5,col6,col7,col8,col9,col10" height="" />
	</@CommonQueryMacro.CommonQuery>
	<script>
		function demodatatabale_col10_onProgress(value,oldvalue,progressbar,progresstext){
			if(value<40){
				progressbar.style.backgroundColor="red";
			} else if(value>80){
				progressbar.style.backgroundColor="green";
			}
		}
	</script>
</@CommonQueryMacro.page>