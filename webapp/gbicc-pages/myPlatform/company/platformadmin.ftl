<!--对公客户经理岗-->
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="home">
<@CommonQueryMacro.PortalWin id="poralwin1" cookied="false" >
   <@CommonQueryMacro.PortalGroup width="800">
	   <@CommonQueryMacro.Portal id="1"  collapsible="false" title="登陆信息" height="60" url="/login/homepage/${'home_login'}.jsp" />
   </@CommonQueryMacro.PortalGroup> 
</@CommonQueryMacro.PortalWin>
<script> var doWork = parent.doWork;</script>
</@CommonQueryMacro.page>
