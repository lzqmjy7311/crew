<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="��Ϸ���Ԥ�� ">
<table align="left" style="width: 100%"><tr><td>
<@CommonQueryMacro.DynamicTabSet id="demotab" hasMenu="true" height="720" fit="true" selected="t1">
			        <@CommonQueryMacro.DynamicTab id="t1" title="�Ŵ��ʲ����ָ��" url="/gbicc-report-pages/combinationWarn/ftl/TCwCreditAssetsMonitor.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
			        <@CommonQueryMacro.DynamicTab id="t2" title="��ҵ���ָ��" url="/gbicc-report-pages/combinationWarn/ftl/TCwFinancialValMonitor.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
			        <@CommonQueryMacro.DynamicTab id="t3" title="һ����ҵ���жȷ���" url="/gbicc-report-pages/combinationWarn/ftl/TCwIndexType3.ftl?flag=desk"> 
			        </@CommonQueryMacro.DynamicTab>
</@CommonQueryMacro.DynamicTabSet>

</td></tr>
</table>
<script language="JavaScript">
</script>
</@CommonQueryMacro.page>