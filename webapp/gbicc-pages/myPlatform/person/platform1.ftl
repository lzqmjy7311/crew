<!--对私总行贷后管理岗-->
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="home">
<@CommonQueryMacro.PortalWin id="poralwin1" cookied="false" >
   <@CommonQueryMacro.PortalGroup width="800">
	   <@CommonQueryMacro.Portal id="1" draggable="false" refresh="false" collapsible="false" title="登陆信息" height="60" url="/login/homepage/${'home_login'}.jsp" />
	   <@CommonQueryMacro.Portal id="2" draggable="false" refresh="false" collapsible="false" title="任务总览" height="60" url="/gbicc-pages/myPlatform/person/task_total_1.jsp" />
	   <@CommonQueryMacro.Portal id="3" draggable="false" refresh="false" title="我的工作台" height="620" include="false" collapsible="false" url="/gbicc-pages/myPlatform/person/task_tab1.ftl" />
   </@CommonQueryMacro.PortalGroup> 
</@CommonQueryMacro.PortalWin>
</@CommonQueryMacro.page>
