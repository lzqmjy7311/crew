<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign customerNum=RequestParameters["customerNum"]?default("")>
<#assign chineseName="${RequestParameters['chineseName']?default('')}" />
<@CommonQueryMacro.page title="用户登录日志查询">

<@CommonQueryMacro.PortalWin id="poralwin1" cookied="true">


<@CommonQueryMacro.PortalGroup width="100%">
<@CommonQueryMacro.Portal id="a1" title="财务比较分析" height="400" url="/gbicc-com-pages/FinanciaAnalysis/ftl/FinCourse.ftl?customerNum="+customerNum+"&chineseName="+chineseName refresh="false" draggable="false">
</@CommonQueryMacro.Portal>
<@CommonQueryMacro.Portal id="a2" title="财务科目趋势分析" height="500" url="/gbicc-com-pages/FinanciaAnalysis/ftl/FinCourseTendency.ftl?customerNum="+customerNum+"&chineseName="+chineseName refresh="false" draggable="false">
</@CommonQueryMacro.Portal>
<@CommonQueryMacro.Portal id="a3" title="财务指标趋势分析" height="500" url="/gbicc-com-pages/FinanciaAnalysis/ftl/FinIndexTendency.ftl?customerNum="+customerNum+"&chineseName="+chineseName refresh="false" draggable="false">
</@CommonQueryMacro.Portal>
<@CommonQueryMacro.Portal id="a4" title="财务诊断分析" height="400" url="/gbicc-com-pages/FinanciaAnalysis/ftl/FinIndex.ftl?customerNum="+customerNum+"&chineseName="+chineseName refresh="false" draggable="false">
</@CommonQueryMacro.Portal>
</@CommonQueryMacro.PortalGroup>



</@CommonQueryMacro.PortalWin>

</@CommonQueryMacro.page>