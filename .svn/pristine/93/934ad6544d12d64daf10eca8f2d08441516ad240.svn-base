<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="普通表格">
	<@CommonQueryMacro.CommonQuery id="GridFields" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.DataTable id="demodatatabale" fieldStr="col1,col2,col3,col4,col5,col6,col7,col8,col9,col10" height="" displayMsg="<label style='padding-right:15px'>共{total}条</label>"/>
	</@CommonQueryMacro.CommonQuery>
	<script>
		function demodatatabale_col10_onProgress(value,oldvalue,progressbar,progresstext){
			if(value<40){
				progressbar.style.backgroundColor="red";
			} else if(value>80){
				progressbar.style.backgroundColor="green";
			}
		}
		function dropDown_onGetRecord() {
			return GridFields_dataset.record;
		}
	</script>
</@CommonQueryMacro.page>