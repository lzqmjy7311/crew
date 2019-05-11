<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign id="${RequestParameters['id']?default('')}" />
<@CommonQueryMacro.page title="">
<@CommonQueryMacro.CommonQuery id="TDataGsxtJudicialEquityFreezon" init="false" submitMode="selected" navigate="false">
	<@CommonQueryMacro.Group id="content" label="" colNm="2"fieldStr="busscope2"  
		 />
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var id='${id}';
	TDataGsxtJudicialEquityFreezon_dataset.setParameter("id",id);
	TDataGsxtJudicialEquityFreezon_dataset.flushData();
}

</script>
</@CommonQueryMacro.page>
