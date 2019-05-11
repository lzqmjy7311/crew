<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign typeId="${RequestParameters['typeId']?default('')}" />
<#assign fdDate="${RequestParameters['fdDate']?default('')}" />
<@CommonQueryMacro.page title="abc">
<@CommonQueryMacro.CommonQuery id="TWbdataTest" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="type,desc,data,typeid" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function initCallGetter_post(){
	var typeId='${typeId}';
	var fdDate='${fdDate}';
	TWbdataTest_dataset.setParameter("typeid",typeId);
	TWbdataTest_dataset.setParameter("data",fdDate);
	TWbdataTest_dataset.flushData();
	
}

</script>
</@CommonQueryMacro.page>
