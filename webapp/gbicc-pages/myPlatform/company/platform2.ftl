<!--�Թ��ͻ��������ܸ�-->
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="home">
<@CommonQueryMacro.PortalWin id="poralwin1" cookied="false" >
   <@CommonQueryMacro.PortalGroup width="800">
	   <@CommonQueryMacro.Portal id="1"   collapsible="false" title="��½��Ϣ" height="60" url="/login/homepage/${'home_login'}.jsp" />
	   <@CommonQueryMacro.Portal id="2"   collapsible="false" title="��������" height="60" url="/gbicc-pages/myPlatform/company/task_total_2.jsp" />
	   <@CommonQueryMacro.Portal id="3" title="�ҵĹ���̨" height="620" include="false" collapsible="false" url="/gbicc-pages/myPlatform/company/task_tab2.ftl" />
   </@CommonQueryMacro.PortalGroup> 
</@CommonQueryMacro.PortalWin>
<script> var doWork = parent.doWork;</script>
</@CommonQueryMacro.page>
