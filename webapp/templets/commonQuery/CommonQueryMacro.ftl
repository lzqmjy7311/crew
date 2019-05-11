<#import "/templets/commonQuery/CQElement.ftl" as htmlelement>
<#import "/templets/commonQuery/CQEditType.ftl" as htmlEditType>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#assign requestScope=1>

<#-- where element   对where里面的属性进行解析-->
<#macro showElement element>
<#switch element.type>
  	<#case "TextBox">
  		<@TextBox element/>
    	<#break>
   	<#case "DateTextBox">
  		<@DateTextBox element/>
    	<#break>
 	<#case "Option">
  		<@OptionELe element/>
    	<#break>
    <#case "Hidden">
  		<@Hidden element/>
    	<#break>
    <#case "Reserve">
  		<@Reserve element/>
    	<#break>

    <#case "DateTextBoxBefore">
  		<@DateTextBoxBefore element/>
    	<#break>
    <#case "HiddenOrder">
  		<@HiddenOrder element/>
    	<#break>
    <#case "OptionOrder">
  		<@OptionOrder element/>
    	<#break>
    <#case "CheckBoxGroup">
  		<@CheckBoxGroup element/>
    	<#break>
    <#case "HiddenGroup">
  		<@HiddenGroup element/>
    	<#break>
    <#default>
   	    <#break>
</#switch>
</#macro>

<#-- TextBox Element -->
<#macro TextBox element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign size   = attributes["size"]>
<#assign defaultValue  = element.getAnyValue("default")?default("")>
<#assign width  = element.getAnyValue("width")?default("")>
<#assign scale  = element.getAnyValue("scale")?default("")>
<#assign require  = element.getAnyValue("require")?default("false")>
<#assign type  = element.getAnyValue("datatype")?default("string")>
<#assign readOnly  = element.getAnyValue("readonly")?default("false")>
<#assign rules  = attributes["rules"]?default("")>
<#assign errMsg = attributes["errmsg"]?default("")>
		<#--
      <@htmlelement.textinput  textinputlabel=desc inputid=id name=id value=value size=size rules=rules errMsg=errMsg>
      </@htmlelement.textinput>
      -->
      <@htmlEditType.text lable=desc id=id targetDataset="${CommonQueryConfig.getId()}_dataset"
       defaultValue=defaultValue maxLength=size width=width textType=type scale=scale  require=require readOnly=readOnly mask=rules maskErrorMes=errMsg>
      </@htmlEditType.text>
</#macro>

<#-- DateTextBox Element -->
<#macro DateTextBox element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign size   = attributes["size"]>
<#assign width  = element.getAnyValue("width")?default("")>
<#assign require  = element.getAnyValue("require")?default("false")>
<#assign readOnly  = element.getAnyValue("readonly")?default("false")>
<#assign defaultValue  = element.getAnyValue("default")?default("")>

<#--
<@htmlelement.calendar calendarlabel=desc name=id rules=rules errMsg=errMsg value=value/>
-->
 <@htmlEditType.date lable=desc id=id targetDataset="${CommonQueryConfig.getId()}_dataset"
       defaultValue=defaultValue maxLength=size width=width require=require readOnly=readOnly >
      </@htmlEditType.date>
</#macro>

<#-- DateTextBoxBefore Element -->
<#macro DateTextBoxBefore element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign rules  = attributes["rules"]?default("")>
<#assign errMsg = attributes["errmsg"]?default("")>
<#assign value  = element.getViewValue(_request)>
<@htmlelement.calendarOnlyBefore calendarlabel=desc name=id rules=rules errMsg=errMsg value=value/>
</#macro>

<#-- Option Element -->
<#macro OptionELe element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign size   = attributes["size"]>
<#assign translated  = element.getAnyValue("translated")?default("")>
<#assign defaultValue= element.getAnyValue("default")?default("")>
<#assign readOnly= element.getAnyValue("readonly")?default("false")>
<#assign require= element.getAnyValue("require")?default("false")>
<#assign height= element.getAnyValue("height")?default("")>
<#assign width= element.getAnyValue("width")?default("")>
<#assign translated= element.getAnyValue("translated")?default("")>
<#assign fieldmap  = element.getAnyValue("fieldmap")?default("")>
<#assign viewField  = element.getAnyValue("viewfield")?default("")>
<#--
      <@htmlelement.select label=desc selectName=id elements=value size=size defaultValue=default onchstaticItemsange=onchange>
      </@htmlelement.select>
-->
	<#assign isCQ  = "false">
	<#assign CQid  = "">
	<#list translated?split(":")  as key>
	     <#if key =="CQ">
			<#assign isCQ  = "true">
			<#break>
		</#if>
	</#list>
	<#if isCQ ="true">
	    <#list translated?split(":")  as key>
			<#assign CQid  = key>
		</#list>
	</#if>
	 <#if isCQ=="false">
       <@htmlEditType.selectDataDic lable=desc id=id targetDataset="${CommonQueryConfig.getId()}_dataset"
        width=width height=height require=require readOnly=readOnly defaultValue=defaultValue  translated=translated>
       </@htmlEditType.selectDataDic>
     <#else>
     	<@CommonQueryMacro.CommonQueryForSelect id="${CQid}" init="true" />
     	<@htmlEditType.selectGetter lable=desc id=id targetDataset="${CommonQueryConfig.getId()}_dataset"
        width=width height=height require=require readOnly=readOnly defaultValue=defaultValue  CQid=CQid fieldmap=fieldmap filed=viewField >  
        </@htmlEditType.selectGetter>
     </#if>
</#macro>

<#-- Hidden Element -->
<#macro Hidden element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign value  = element.getAnyValue("default")?default("")>
	<#--
	<@htmlelement.hiddenelement id=id value=value>
	</@htmlelement.hiddenelement>
	-->
	<@htmlEditType.hiddenelement  id=id value=value targetDataset="${CommonQueryConfig.getId()}_dataset">
    </@htmlEditType.hiddenelement>
</#macro>

<#-- Reserve Element -->
<#macro Reserve element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign value  = attributes["value"]>
	<#--
	<@htmlelement.hiddenelement id=id value=value>
	</@htmlelement.hiddenelement>
	-->
	<@htmlEditType.hiddenelement  id=id value=value targetDataset="${CommonQueryConfig.getId()}_dataset">
    </@htmlEditType.hiddenelement>
</#macro>

<#-- HiddenOrder Element -->
<#macro HiddenOrder element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign value  = attributes["value"]>
	<input type="hidden" name="${id}" value="${value}"/>
</#macro>

<#-- OptionOrder Element -->
<#macro OptionOrder element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign size   = attributes["size"]?default(10)>
<#assign default= attributes["default"]?default("")>
<#assign onchange = attributes["onchange"]?default("")>
<#assign value  = element.getViewValue(_request)>
      <@htmlelement.select label=desc selectName=id elements=value defaultValue=default size=size onchange=onchange>
      </@htmlelement.select>
</#macro>

<#-- CheckBoxGroup Element -->
<#macro CheckBoxGroup element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign desc   = attributes["desc"]>
<#assign value  = element.getViewValue(_request)>
      <@htmlelement.checkbox label=desc id=id checked=value name=id>
      </@htmlelement.checkbox>
</#macro>

<#-- HiddenGroup Element -->
<#macro HiddenGroup element>
<#assign attributes = element.attributes>
<#assign id     = attributes["id"]>
<#assign value  = attributes["value"]>
	<input type="hidden" name="${id}" value="${value}"/>
</#macro>

<#macro isShow element info>
<#switch element.type>
  	<#case "TextBox">
  		${info}
    	<#break>
   	<#case "DateTextBox">
  		${info}
    	<#break>
   	<#case "DateTextBoxBefore">
  		${info}
    	<#break>
 	<#case "Option">
  		${info}
    	<#break>
    <#case "Hidden">
    	<#break>
    <#case "Reserve">
    	<#break>
    <#case "HiddenOrder">
    	<#break>
    <#case "OptionOrder">
    	<#break>
    <#case "CheckBoxGroup">
  		${info}
    	<#break>
    <#case "HiddenGroup">
    	<#break>
    <#default>
   	    <#break>
</#switch>
</#macro>


<#-- field -->
<#macro isShowField field info>
<#switch field.getAnyValue("edittype")?default('text')>
  	<#case "text">
  		${info}
    	<#break>
   	<#case "textarea">
  		${info}
    	<#break>
   	<#case "checkbox">
  		${info}
    	<#break>
 	<#case "select">
  		${info}
    	<#break>
    <#case "data">
    	<#break>
    <#default>
   	    <#break>
</#switch>
</#macro>


<#macro showField field>
<#switch field.getAnyValue("edittype")?default('text')>
  	<#case "text">
  		<@FieldTextBox field/>
    	<#break>
   	<#case "textarea">
  		<@DateTextBox field/>
    	<#break>
   	<#case "checkbox">
  		<@DateTextBoxBefore field/>
    	<#break>
 	<#case "select">
  		<@Option field/>
    	<#break>
    <#case "data">
  		<@Hidden field/>
    	<#break>
    <#case "hidden">
  		<@Reserve field/>
    	<#break>
    <#default>
  		<@Reserve field/>
   	    <#break>
</#switch>
</#macro>

<#-- FieldTextBox field -->
<#macro FieldTextBox field>
<#assign id   = field.getAnyValue("id")>
<#assign desc   = field.getAnyValue("desc")>
<#assign size   = field.getAnyValue("size")>
<#assign defaultValue  = field.getAnyValue("default")?default("")>
<#assign width  = field.getAnyValue("width")?default("")>
<#assign scale  = field.getAnyValue("scale")?default("")>
<#assign require  = field.getAnyValue("require")?default("false")>
<#assign type  = field.getAnyValue("datatype")?default("string")>
<#assign readOnly  = field.getAnyValue("readonly")?default("false")>
<#assign rules  = field.getAnyValue("rules")?default("")>
<#assign errMsg = field.getAnyValue("errmsg")?default("")>

<@htmlEditType.text lable=desc id=id targetDataset="${CommonQueryConfig.getId()}_dataset"
       defaultValue=defaultValue maxLength=size width=width textType=type scale=scale  require=require readOnly=readOnly mask=rules maskErrorMes=errMsg>
      </@htmlEditType.text>
</#macro>

<#-- Option field -->
<#macro Option field>
<#assign id   = field.getAnyValue("id")>
<#assign desc   = field.getAnyValue("desc")>
<#assign size   = field.getAnyValue("size")>
<#assign translated  = field.getAnyValue("translated")?default("")>
<#assign defaultValue= field.getAnyValue("default")?default("")>
<#assign readOnly= field.getAnyValue("readonly")?default("false")>
<#assign require= field.getAnyValue("require")?default("false")>
<#assign height= field.getAnyValue("height")?default("")>
<#assign width= field.getAnyValue("width")?default("")>
<#assign translated  = field.getAnyValue("translated")?default("")>
<#--
      <@htmlelement.select label=desc selectName=id elements=value size=size defaultValue=default onchstaticItemsange=onchange>
      </@htmlelement.select>
-->
       <@htmlEditType.selectDataDic2 lable=desc id=id translated=translated targetDataset="${CommonQueryConfig.getId()}_dataset"
        width=width height=height require=require readOnly=readOnly defaultValue=defaultValue >
       </@htmlEditType.selectDataDic2>
</#macro>





