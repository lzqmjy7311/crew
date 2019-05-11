<#import "/templets/commonQuery/CQElement.ftl" as htmlelement>

<#macro showElement element requestParam>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign requestValue = "" >
<#if RequestParam[id]?exists>
<#assign requestValue = RequestParam[id][0] >
<#else>
<#assign requestValue = "" >
</#if>
<#switch element.type>
  	<#case "TextBox">
  		<@TextBox element=element requestValue=requestValue/>
    	<#break>
   <#case "DateTextBox">
  		<@DateTextBox element=element requestValue=requestValue/>
        <#break>
   <#case "DateTextBoxBefore">
  		<@DateTextBoxBefore element=element requestValue=requestValue/>
        <#break>
 	<#case "Option">
  		<@Option element=element requestValue=requestValue/>
    	<#break>
    <#case "Hidden">
  		<@Hidden element=element requestValue=requestValue/>
    	<#break>
    <#case "Reserve">
    	<@Reserve element=element requestValue=requestValue/>
    	<#break>
    <#case "HiddenOrder">
  		<@HiddenOrder element=element requestValue=requestValue/>
    	<#break>
    <#case "OptionOrder">
  		<@OptionOrder element=element requestValue=requestValue/>
    	<#break>
    <#case "CheckBoxGroup">
  		<@CheckBoxGroup element=element requestValue=requestValue/>
    	<#break>
    <#case "HiddenGroup">
  		<@HiddenGroup element=element requestValue=requestValue/>
    	<#break>
    <#default>
   	    <#break>
</#switch>
</#macro>

<#-- TextBox Element -->
<#macro TextBox element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign size   = attributes["size"]>
<#if requestValue?length == 0>
<#assign value  = element.getViewValue(request)>
<#else>
<#assign value  = requestValue>
</#if>
<#assign rules  = attributes["rules"]?default("")>
<#assign errMsg = attributes["errmsg"]?default("")>
      <@htmlelement.textinput  textinputlabel=desc size=size inputid=id name=id value=value rules=rules errMsg=errMsg>
      </@htmlelement.textinput>
</#macro>

<#-- DateTextBox Element -->
<#macro DateTextBox element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign rules  = attributes["rules"]?default("")>
<#assign errMsg = attributes["errmsg"]?default("")>
<#if requestValue?length == 0>
<#assign value  = element.getViewValue(request)>
<#else>
<#assign value  = requestValue>
</#if>
	<@htmlelement.calendar calendarlabel=desc name=id rules=rules errMsg=errMsg value=value/>
</#macro>

<#-- DateTextBoxBefore Element -->
<#macro DateTextBoxBefore element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign rules  = attributes["rules"]?default("")>
<#assign errMsg = attributes["errmsg"]?default("")>
<#if requestValue?length == 0>
<#assign value  = element.getViewValue(request)>
<#else>
<#assign value  = requestValue>
</#if>
<@htmlelement.calendarOnlyBefore calendarlabel=desc name=id rules=rules errMsg=errMsg value=value/>
</#macro>

<#-- Option Element -->
<#macro Option element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign size   = attributes["size"]>
<#assign onchange = attributes["onchange"]?default("")>
<#if requestValue?length == 0>
<#assign default= attributes["default"]?default("")>
<#else>
<#assign default=requestValue>
</#if>
<#assign value  =element.getViewValue(request)>
      <@htmlelement.select label=desc selectName=id elements=value size=size defaultValue=default onchange=onchange>
      </@htmlelement.select>
</#macro>

<#-- Hidden Element -->
<#macro Hidden element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#if requestValue?length == 0>
<#assign value  = element.getViewValue(request)>
<#else>
<#assign value  = requestValue>
</#if>
	<input type="hidden" name="${id}" id="${id}" value="${value}"/>
</#macro>

<#-- Reserve Element -->
<#macro Reserve element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign value  = attributes["value"]>
	<input type="hidden" name="${id}" value="${value}"/>
</#macro>

<#-- HiddenOrder Element -->
<#macro HiddenOrder element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#if requestValue?length == 0>
<#assign value  = attributes["value"]>
<#else>
<#assign value  = requestValue>
</#if>
	<input type="hidden" name="${id}" value="${value}"/>
</#macro>

<#-- OptionOrder Element -->
<#macro OptionOrder element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign size   = attributes["size"]>
<#assign onchange = attributes["onchange"]?default("")>
<#if requestValue?length == 0>
<#assign default= attributes["default"]?default("")>
<#else>
<#assign default=requestValue>
</#if>
<#assign value  = element.getViewValue(request)>
      <@htmlelement.select label=desc selectName=id elements=value defaultValue=default size=size  onchange=onchange>
      </@htmlelement.select>
</#macro>

<#-- CheckBoxGroup Element -->
<#macro CheckBoxGroup element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#if requestValue?length == 0>
<#assign value  = element.getViewValue(request)>
<#else>
<#assign value=requestValue>
</#if>
      <@htmlelement.checkbox label=desc id=id checked=value name=id>
      </@htmlelement.checkbox>
</#macro>

<#-- HiddenGroup Element -->
<#macro HiddenGroup element requestValue>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#if requestValue?length == 0>
<#assign value  = attributes["value"]>
<#else>
<#assign value  = requestValue>
</#if>
	<input type="hidden" name="${id}" value="${value}"/>
</#macro>


