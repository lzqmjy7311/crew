<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign id="${RequestParameters['id']?default('')}" />
<@CommonQueryMacro.page title="">
<@CommonQueryMacro.CommonQuery id="TDataGsxtIcIllegal" init="false" submitMode="selected" navigate="false">
	<@CommonQueryMacro.Group id="fdOutExceptionReson" label="" colNm="2"fieldStr="fdOutIllegalReson2"  
		 />
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var id='${id}';
	TDataGsxtIcIllegal_dataset.setParameter("id",id);
	TDataGsxtIcIllegal_dataset.flushData();
}
</script>
</@CommonQueryMacro.page>
