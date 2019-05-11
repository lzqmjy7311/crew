<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="员工信息">
<table>
	<@CommonQueryMacro.CommonQuery id="J09" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="J09Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="usrCode[150],usrName[200],idCardNo[150],depName[200]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		J09_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>