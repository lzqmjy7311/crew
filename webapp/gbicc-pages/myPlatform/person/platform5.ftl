<!--��˽����֧�пͻ������-->
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="home">
<@CommonQueryMacro.PortalWin id="poralwin1" cookied="false" >
   <@CommonQueryMacro.PortalGroup width="800">
	   <@CommonQueryMacro.Portal id="1" draggable="false" refresh="false" title="��½��Ϣ" collapsible="false"  height="50" url="/login/homepage/${'home_login'}.jsp" />
	   <@CommonQueryMacro.Portal id="2" draggable="false" refresh="false" title="��������"  collapsible="false" height="50" url="/gbicc-pages/myPlatform/person/task_total_5.jsp" />
	   <@CommonQueryMacro.Portal id="3" draggable="false" refresh="false" title="�ҵĹ���̨" height="620" url="/gbicc-pages/myPlatform/person/task_tab5.ftl" />
   </@CommonQueryMacro.PortalGroup> 
</@CommonQueryMacro.PortalWin>
</@CommonQueryMacro.page>
