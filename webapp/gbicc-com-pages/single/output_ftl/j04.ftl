<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="��˽�ͻ���Ϣ">
<table>
	<@CommonQueryMacro.CommonQuery id="J04" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="J04Table" height="305" readonly="true" fitColumns="false"
		fieldStr="adminClientId,contactName,contactCode,genderTpCd,bonCountryTpCd,nativeplace,maritalTpCd,orgName,localInd,bankStockholderInd,hostOrg" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//ҳ���ʼ��
	function initCallGetter_post(){
		var warningId='${warningId}';
		J04_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>