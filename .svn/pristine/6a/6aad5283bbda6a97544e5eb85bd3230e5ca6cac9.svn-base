<#import "/templets/commonQuery/BankCommonQueryEditType.ftl" as HtmlEditType>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#macro TabNavigation fpPageItem width="100%" height="100%">
   <#assign compId=fpPageItem.getId()>
   <#assign compName=fpPageItem.getName()>
   <#assign selected=fpPageItem.getDefaultno()>
   <#assign fpPageDetailList = getFpPageDetails(compId)>
   <#-- tab site -->
   <@CommonQueryMacro.DynamicTabSet id=compName width=width height=height hasMenu="false" selected=selected border="false" fit="true">
      <#list fpPageDetailList as fpPageDetail>
		<#assign dName = fpPageDetail.getName()>
		<#assign ddesc  = fpPageDetail.getDescInfo()>
		<#assign dParam  = fpPageDetail.getParamList()?default('')>
		<#assign dUrl  = fpPageDetail.getPagfeUrl()>
		<#assign dUrl = coverParamUrl(dUrl,dParam)>
		<@CommonQueryMacro.DynamicTab id=dName title=ddesc url=dUrl> 
        </@CommonQueryMacro.DynamicTab>
	  </#list>		       
   </@CommonQueryMacro.DynamicTabSet>
</#macro>

<#macro AccordionNavigation fpPageItem width="100%" height="100%" >
   <#assign compId=fpPageItem.getId()>
   <#assign compName=fpPageItem.getName()>
   <#assign selected=fpPageItem.getDefaultno()>
   <#assign fpPageDetailList = getFpPageDetails(compId)>
   <#-- Accordion site -->
   <@CommonQueryMacro.AccordionGroup id=compName selected=fpPageDetailList.get(0).getId()>
   <#list fpPageDetailList as fpPageDetail>
		<#assign ddesc = fpPageDetail.getDescInfo()>
		<#assign dName  = fpPageDetail.getName()>
		<#assign dParam  = fpPageDetail.getParamList()?default('')>
		<#assign dUrl  = fpPageDetail.getPagfeUrl()>
		<#assign dUrl = coverParamUrl(dUrl,dParam)>
		<p><@CommonQueryMacro.SimpleButton id=dName plain="true" onclick="openTab('${dUrl}')" desc=ddesc/></p>
	</#list>		     
   </@CommonQueryMacro.AccordionGroup>
</#macro>

<#macro TreeNavigation fpPageItem width="100%" height="100%" >
   <#assign fpPageDetailList = getFpPageDetails(componentId)>
</#macro>

<#macro ButtonCenter fpPageItem width="100%" height="100%" style="horizontal" position="left">
<#if fpPageItem.getOpItemId()?default('') != "">
	 <#assign compId=fpPageItem.getOpItemId()>
	 <#assign fpPageOptDetailList = getFpPageOptDetails(compId)>
 <@CommonQueryMacro.CommonQuery id='_'+compId submitMode="all">
	<div sytle="width:${width};height:${height}">
	<#list fpPageOptDetailList as fpPageOptDetail>
		<#assign dId = fpPageOptDetail.getId()>
		<#assign dOptScript  = fpPageOptDetail.getOptScript()?default('')>
		<#assign dName  = fpPageOptDetail.getName()?default('')>
		<@CommonQueryMacro.Button id=dName/>
		<script type="text/javascript">
			${dOptScript?replace('^p','')}
			function ${dName}_needCheck(button){
				return false;
			}
		</script>	
	</#list>		       
	</div>
 </@CommonQueryMacro.CommonQuery>
</#if>
</#macro> 

<#-- function definition -->
<#function getFpPageItem name>
<#assign fpPageItem = statics["com.huateng.ebank.business.pages.service.FPPagesRenderService"].getFpPageItem(name)>
<#return fpPageItem>
</#function>

<#function getFpPageDetails id>
<#assign fpPageDetailList = statics["com.huateng.ebank.business.pages.service.FPPagesRenderService"].getFpPageDetails(id)>
<#return fpPageDetailList>
</#function>

<#function getFpPageOptDetails id>
<#assign fpPageOptDetailList = statics["com.huateng.ebank.business.pages.service.FPPagesRenderService"].getFpPageOptDetails(id)>
<#return fpPageOptDetailList>
</#function>

<#function isContainOpt id>
<#assign isContain = statics["com.huateng.ebank.business.pages.service.FPPagesRenderService"].isContainOpt(id)>
<#return isContain>
</#function>

<#function coverParamUrl url param>
<#if param == "">
	<#return url>
<#else>
    <#assign newUrl = url>
	<#assign paramList = param?split(";")>
	<#list paramList  as paramString>
	    <#assign index =paramString?index_of("=")>
	    <#if index!=-1>
			<#assign paraName =paramString?substring(0,index)>
			<#assign paraValue =paramString?substring(index+1)>
			 <#-- $R{....} -->
			 <#if paraValue?matches("\\$R\\{.*\\}")>
			 	<#assign rparaName = paraValue?substring(3,paraValue?length-1)>
			 	<#assign rparaValue = RequestParameters[rparaName]?default('')>
			 	<#if rparaValue != "">
			 		<#if newUrl?index_of("?") != -1>
			 			<#assign newUrl = newUrl+'&'+ paraName + '=' + rparaValue>  
			 		<#else>
			 			<#assign newUrl = newUrl+'?'+ paraName + '=' + rparaValue>  
			 		</#if>
			 	</#if>
			 <#else>
			 	<#if newUrl?index_of("?") != -1>
			 		<#assign newUrl = newUrl+'&'+ paraName + '=' + paraValue>  
			 	<#else>
			 		<#assign newUrl = newUrl+'?'+ paraName + '=' + paraValue>  
			 	</#if>
			 </#if>
		<#else>
		   <#-- cotinue -->
		</#if>
	</#list>
	<#return newUrl>
</#if>
</#function>