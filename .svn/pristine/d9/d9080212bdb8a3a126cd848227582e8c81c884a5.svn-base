<#--提交页面测试-->
<#import "/page/ftl/macro/common.ftl" as com>
<#import "/page/ftl/templates/commonQuery/CQInterfaceFormSubmit.ftl" as formSubmit>
<#import "/page/ftl/templates/commonQuery/CommonQueryMacro.ftl" as CQMaco>

<@com.page title="${CommonQueryConfig.title}">
<script language="javascript" src="${contextPath}/page/resources/script/taconite/taconite-client.js"></script>
<script language="javascript" src="${contextPath}/page/resources/script/taconite/taconite-parser.js"></script>
<#escape x as x?html>
<@formSubmit.formSubmit title="${CommonQueryConfig.title}" name="form1" action="${contextPath}/trans/CommonQueryResult.do" onsubmit="checkSubmit">
<#assign elementList = CommonQueryConfig.elementList>
<#list elementList as element>
	<@CQMaco.showElement element/>
</#list>
<#-- 页码信息 -->
<input type="hidden" name="CQId" value="${CommonQueryConfig.id}"/>
<input type="hidden" name="nextPage" value="1"/>
<input type="hidden" name="everyPage" value="10"/>
</@formSubmit.formSubmit>
</#escape>
${CommonQueryConfig.script?default('')}
</@com.page>