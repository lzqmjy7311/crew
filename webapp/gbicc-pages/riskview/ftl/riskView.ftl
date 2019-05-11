<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="标签页">
<@CommonQueryMacro.DynamicTabSet id="demotab" hasMenu="true" height=""
selected="t2">
<@CommonQueryMacro.DynamicTab id="t1" title="风险预览"
url="/gbicc-pages/riskoverview/ftl/riskoverview.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t21" title="基本信息"
url="/gbicc-pages/warning_baseinfo/ftl/warning_baseinfo.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t22" title="账户帐页"
url="/gbicc-pages/accountpage/ftl/TAccountPage.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t22" title="财务信息"
url="/gbicc-com-pages/FinanciaAnalysis/ftl/FinanceAnalysis.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>

<@CommonQueryMacro.DynamicTab id="t24" title="征信信息"
url="/gbicc-pages/zxinfo/ftl/zxinfo.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t25" title="关联信息"
url="/gbicc-pages/relevance/ftl/relevance.ftl?customerNum="+customerNum>
</@CommonQueryMacro.DynamicTab>
<@CommonQueryMacro.DynamicTab id="t26" title="外部风险数据"
url="/gbicc-pages/externaldata/ftl/externaldata.ftl">
</@CommonQueryMacro.DynamicTab>
</@CommonQueryMacro.DynamicTabSet>
<script>
</script>
</@CommonQueryMacro.page>