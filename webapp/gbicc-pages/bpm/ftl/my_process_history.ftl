<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="�Ҳ��������  &gt;  �Ҳ��������">
	<@CommonQueryMacro.DynamicTabSet id="demotab" hasMenu="true" height="" selected="t1">
        <@CommonQueryMacro.DynamicTab id="t1" title="�Ҳ��������" url="/gbicc-pages/bpm/ftl/my_history.ftl"/>
    </@CommonQueryMacro.DynamicTabSet>
<script>
	function initCallGetter_post(){
		//demotab_tabset.add({id:"t1",title:"�Ҳ��������",url:"/gbicc-pages/bpm/ftl/my_history.ftl"});
		//demotab_tabset.add({id:"t2",title:"�ҷ��������",url:"/gbicc-pages/bpm/ftl/my_launch.ftl"});
		//demotab_tabset.select("t1");
	}
</script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>