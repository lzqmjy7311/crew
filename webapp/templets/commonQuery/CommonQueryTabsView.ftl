<#--tabÒ³Ãæ²âÊÔ-->
<#import "/templets/common/commonTab.ftl" as commonTab>
<#import "/templets/common/common.ftl" as com>

<#assign tabs ="" >
<#assign tabsSize ="" >
<#assign divString = "">
<#assign navigate = CommonQueryConfig.getAnyValue("navigate")>
<#assign title = CommonQueryConfig.getAnyValue("title")>

<#assign operationsMap = CommonQueryConfig.operations>
<#assign operationsKeys = operationsMap?keys>
<#list operationsKeys as key>
	<#assign button = 	operationsMap[key]>
	<#if button.isShow(_request)>
		<#assign tabsSize = tabsSize + 1>
 	 	<#assign desc = button.attributes["desc"]?default("")>
 	 	<#assign name = button.attributes["name"]?default("")>
  	 	<#assign url  = button.attributes["url"]?default("")>
 	    <#assign tabs = tabs + "${desc},${name},${url};">
 	    <#assign divString = divString + "<div id=\"tabset_${name}\"></div>">
    </#if>
</#list>

<@com.newpage title="${title}">
<@commonTab.tabspage title="${navigate}" tabsSize="${tabsSize}"
tabs="${tabs}" divString="${divString}"
>

<#assign operationsMap = CommonQueryConfig.operations>
<#assign operationsKeys = operationsMap?keys>

</@commonTab.tabspage>
</@com.newpage>
