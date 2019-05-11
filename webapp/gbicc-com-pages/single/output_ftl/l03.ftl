<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="���̴�����ϸ">
<table>
	<@CommonQueryMacro.CommonQuery id="L03" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="L03Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="decideWrit,breakType,punishContent,decideOrg,baseId" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//ҳ���ʼ��
	function initCallGetter_post(){
		var warningId='${warningId}';
		L03_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>