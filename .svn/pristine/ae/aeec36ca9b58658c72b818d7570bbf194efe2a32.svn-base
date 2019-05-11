<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#--global value-->
<#global contextPath = contextPath>

<#--通用查询头模板-->
<#macro CommonQuery>
<#assign CommonQueryConfig = statics["com.huateng.commquery.config.CommonQueryUtil"].getCommonQueryBean(CQId)>
<@CommonQueryMacro.page title=CommonQueryConfig.getAnyValue("title")>
<@CommonQueryMacro.CommonQueryForRequest>
	<#nested>
</@CommonQueryMacro.CommonQueryForRequest>
</@CommonQueryMacro.page>
</#macro>

<#--建立PagePilot栏-->
<#macro PagePilot id maxpagelink="9" showArrow="true">
<@CommonQueryMacro.PagePilot id=id maxpagelink=maxpagelink showArrow=showArrow/>
</#macro>

<#--建立DataTable栏-->
<#macro DataTable id fieldStr=CommonQueryConfig.toFieldString() width="" readonly="true">
<@CommonQueryMacro.DataTable id=id fieldStr=fieldStr width=width readonly=readonly/>
</#macro>

<#--建立Group栏-->
<#macro Group id label fieldStr colNm=4>
<@CommonQueryMacro.Group id=id label=label fieldStr=fieldStr colNm=colNm/>
</#macro>

<#--建立Button栏-->
<#macro Button id>
<@CommonQueryMacro.Button id=id/>
</#macro>

<#macro ButtonGroup>
<@CommonQueryMacro.ButtonGroup/>
</#macro>



