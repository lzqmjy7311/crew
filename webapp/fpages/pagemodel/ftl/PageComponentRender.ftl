<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/commonQuery/FPPageComponent.ftl" as FPPageComponent>
<#import "/fpages/pagemodel/ftl/PageComponentTab.ftl" as PageComponentTab>
<#import "/fpages/pagemodel/ftl/PageComponentAcc.ftl" as PageComponentAcc>
<#assign componentId= RequestParameters["pcid"]>
<#assign fpPageItem = FPPageComponent.getFpPageItem(componentId)>
<#assign viewType = fpPageItem.getViewtype()>
<@CommonQueryMacro.page title=fpPageItem.getDescInfo()>
<#if viewType=="0"> 
	<@PageComponentTab.PageComponentTab fpPageItem=fpPageItem width="100%" height="100%"/>
<#elseif viewType == "1">
	<@PageComponentAcc.PageComponentAcc fpPageItem=fpPageItem width="100%" height="100%"/>
<#elseif viewType == "2">
    <#-- no support -->
<#else>
	<@PageComponentTab.PageComponentTab fpPageItem=fpPageItem width="100%" height="100%"/>
</#if>
</@CommonQueryMacro.page>