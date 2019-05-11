<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/commonQuery/FPPageComponent.ftl" as FPPageComponent>
<#macro PageComponentTab fpPageItem width="100%" height="100%">
<#assign id = fpPageItem.getOpItemId()?default('')>
<#assign isCoainOpt=FPPageComponent.isContainOpt(id)>
<#if isCoainOpt>
<@CommonQueryMacro.LayoutPanel id="cc1" inbody="false">
	<@CommonQueryMacro.LayoutNorth  height="26" >
		<@FPPageComponent.ButtonCenter fpPageItem=fpPageItem width=width height=height style="horizontal" position="left"/>
	</@CommonQueryMacro.LayoutNorth>
	<@CommonQueryMacro.LayoutCenter>
		 <@FPPageComponent.TabNavigation fpPageItem=fpPageItem width=width height=height />
	</@CommonQueryMacro.LayoutCenter>
	<@CommonQueryMacro.LayoutSouth  height="26" >
		<@FPPageComponent.ButtonCenter fpPageItem=fpPageItem width=width height=height style="horizontal" position="left"/>
	</@CommonQueryMacro.LayoutSouth>
</@CommonQueryMacro.LayoutPanel>	
<#else>
	<@FPPageComponent.TabNavigation fpPageItem=fpPageItem width=width height=height />
</#if>
</#macro>