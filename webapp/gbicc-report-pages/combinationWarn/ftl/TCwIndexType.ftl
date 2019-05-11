<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign INDEX_CODE=RequestParameters["INDEX_CODE"]?default("")>
<#assign GATHER_TYPE=RequestParameters["GATHER_TYPE"]?default("")>
<@CommonQueryMacro.page title="信贷资产监测指标展示">
<table align="left" style="width: 100%"><tr><td>
<@CommonQueryMacro.DynamicTabSet id="demotab" hasMenu="true" height="700" fit="true" selected="t1">
			        <@CommonQueryMacro.DynamicTab id="t0" title="总体" url="/gbicc-report-pages/combinationWarn/ftl/TCwIndexTotalReport.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
			        <@CommonQueryMacro.DynamicTab id="t1" title="对公" url="/gbicc-report-pages/combinationWarn/ftl/TCwIndexCompanyReport.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
			        <@CommonQueryMacro.DynamicTab id="t2" title="零售" url="/gbicc-report-pages/combinationWarn/ftl/TCwIndexPersonReport.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
	</@CommonQueryMacro.DynamicTabSet>
</td></tr>
</table>
<script type='text/javascript' src='${contextPath}/dwr/interface/AComninationWarnDAjax.js'> </script>
<script language="JavaScript">
function initCallGetter_post(){
	var INDEX_CODE='${INDEX_CODE}';
	AComninationWarnDAjax.findIndexInfoAjx(INDEX_CODE,function(yyy){
		if(yyy.GATHER_TYPE_HAVE){
			if(yyy.GATHER_TYPE_HAVE.indexOf('0')<0){
				demotab_tabset.close('t0');
			}
			if(yyy.GATHER_TYPE_HAVE.indexOf('1')<0){
				demotab_tabset.close('t1');
			}
			if(yyy.GATHER_TYPE_HAVE.indexOf('2')<0){
				demotab_tabset.close('t2');
			}
			demotab_tabset.select('t'+'${GATHER_TYPE}');
		}
		
	});
}
</script>
</@CommonQueryMacro.page>