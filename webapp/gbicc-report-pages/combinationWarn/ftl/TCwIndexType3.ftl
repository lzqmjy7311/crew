<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="�Ŵ��ʲ����ָ��չʾ">
<table align="left" style="width: 100%"><tr><td>
<@CommonQueryMacro.DynamicTabSet id="demotab" hasMenu="true" height="1000" fit="true" selected="t0">
				<@CommonQueryMacro.DynamicTab id="t0" title="ȫ��" url="/gbicc-report-pages/combinationWarn/ftl/TCwIndexType3_5Report.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
			        <@CommonQueryMacro.DynamicTab id="t1" title="�Ϻ�����" url="/gbicc-report-pages/combinationWarn/ftl/TCwIndexType3_6Report.ftl"> 
			        </@CommonQueryMacro.DynamicTab>
	</@CommonQueryMacro.DynamicTabSet>
</td></tr>
</table>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts.js"></script>
<script src="${contextPath}/templets/ui/js/chart/highcharts-more.js"></script>

<script language="JavaScript">

</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/AComninationWarnDAjax.js'> </script>
</@CommonQueryMacro.page>