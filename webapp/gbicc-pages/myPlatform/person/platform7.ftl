<!--��˽���д������-->
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="home">
<@CommonQueryMacro.PortalWin id="poralwin1" cookied="false" >
   <@CommonQueryMacro.PortalGroup width="800">
	   <@CommonQueryMacro.Portal id="1" draggable="false" refresh="false" collapsible="false" title="��½��Ϣ" height="60" url="/login/homepage/${'home_login'}.jsp" />
	   <@CommonQueryMacro.Portal id="3" title="�ҵĹ���̨" draggable="false" refresh="false" height="620" include="false" collapsible="false" url="/gbicc-pages/myPlatform/person/task_tab7.ftl" />
   </@CommonQueryMacro.PortalGroup> 
</@CommonQueryMacro.PortalWin>
</@CommonQueryMacro.page>