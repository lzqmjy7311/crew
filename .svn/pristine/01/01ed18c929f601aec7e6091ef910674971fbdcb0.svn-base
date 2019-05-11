<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="">
<#assign id = RequestParameters["tabsetId"]?default("")>
<#assign currentTab = RequestParameters["currentTab"]?default("")>
<#assign width = RequestParameters["width"]?default("auto")>
<#assign height = RequestParameters["height"]?default("auto")>
<#if width != "auto">
<#assign _w=width + "px">
</#if>
<#if height != "auto">
<#assign _h=height + "px">
</#if>
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean(id)>
<script language="javascript">
var v_currentTab = "${currentTab}";
var v_curretnTabId = "";
var v_curretnTabTitle = "";
</script>
${CommonQueryConfig.script?default('')}

<#assign tabsCtl="tabsCtl">
<#assign _tabsCtl = RequestParameters[tabsCtl]?default('')>
<#assign _show = true>
<#assign operationsMap = CommonQueryConfig.getOperations()>
<#assign operationsKeys = operationsMap.keySet()>

<@CommonQueryMacro.DynamicTabSet id=id width=_w height=_w selected=currentTab>
	<#list operationsKeys as key>
		<#assign button = operationsMap.get(key)>
		<#assign desc = button.attributes["desc"]?default("")>
		<#assign tid = button.attributes["id"]?default("")>
		<#assign url  = button.attributes["url"]?default("")>
	
	 	<#-- ÅÐ¶ÏÊÇ·ñÏÔÊ¾¸Ã tab  -->
	 	<#if _tabsCtl!="" && (_tabsCtl?length >= (key_index+1)) >
			<#if _tabsCtl?substring(key_index,key_index+1)=="1">
				<#assign _show = true>
			<#else>
				<#assign _show = false>
			</#if>
	 	</#if>
	 	<#if _show>
			<@CommonQueryMacro.DynamicTab id=tid title=desc url=url />
		</#if>
	</#list>
</@CommonQueryMacro.DynamicTabSet>
<script language="javascript">
</script>
</@CommonQueryMacro.page>