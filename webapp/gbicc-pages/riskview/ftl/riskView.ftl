<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="��ǩҳ">
<@CommonQueryMacro.DynamicTabSet id="demotab" hasMenu="true" height=""
selected="t2">
<@CommonQueryMacro.DynamicTab id="t1" title="����Ԥ��"
url="/gbicc-pages/riskoverview/ftl/riskoverview.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t21" title="������Ϣ"
url="/gbicc-pages/warning_baseinfo/ftl/warning_baseinfo.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t22" title="�˻���ҳ"
url="/gbicc-pages/accountpage/ftl/TAccountPage.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t22" title="������Ϣ"
url="/gbicc-com-pages/FinanciaAnalysis/ftl/FinanceAnalysis.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>

<@CommonQueryMacro.DynamicTab id="t24" title="������Ϣ"
url="/gbicc-pages/zxinfo/ftl/zxinfo.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t25" title="������Ϣ"
url="/gbicc-pages/relevance/ftl/relevance.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t26" title="�ⲿ��������"
url="/gbicc-pages/externaldata/ftl/externaldata.ftl">
</@CommonQueryMacro.DynamicTab>
</@CommonQueryMacro.DynamicTabSet>
<script>
</script>
</@CommonQueryMacro.page>