<!--对私总行贷后监测岗-->
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="home">
<@CommonQueryMacro.PortalWin id="poralwin1" cookied="false" >
   <@CommonQueryMacro.PortalGroup width="800">
	   <@CommonQueryMacro.Portal id="1" draggable="false" refresh="false" collapsible="false" title="登陆信息" height="60" url="/login/homepage/${'home_login'}.jsp" />
	   <@CommonQueryMacro.Portal id="3" title="我的工作台" draggable="false" refresh="false" height="620" include="false" collapsible="false" url="/gbicc-pages/myPlatform/person/task_tab7.ftl" />
   </@CommonQueryMacro.PortalGroup> 
</@CommonQueryMacro.PortalWin>
</@CommonQueryMacro.page>
