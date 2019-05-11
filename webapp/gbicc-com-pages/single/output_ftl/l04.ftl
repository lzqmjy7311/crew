<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="��ͥ����">
<table>
	<@CommonQueryMacro.CommonQuery id="L04" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="L04Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="courtName,court2Name,tryDate,caseNo,caseReason,mainDept,tryName,accuser,defendant" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//ҳ���ʼ��
	function initCallGetter_post(){
		var warningId='${warningId}';
		L04_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>