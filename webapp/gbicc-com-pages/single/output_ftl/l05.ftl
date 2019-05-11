<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="�о�������Ϣ">
<table>
	<@CommonQueryMacro.CommonQuery id="L05" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="L05Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="companyAnme,caseType,writNo,writTitle,judgCourt,judgDate,content" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//ҳ���ʼ��
	function initCallGetter_post(){
		var warningId='${warningId}';
		L05_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>