<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<@CommonQueryMacro.page title="��λȨ�޹���">
    <@CommonQueryMacro.CommonQuery id="roleFuncTree" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.DynamicTree id="tree1" checkbox="true" />
	</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>
