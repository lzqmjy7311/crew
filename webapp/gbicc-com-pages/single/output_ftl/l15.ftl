<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="高能耗信息">
<table>
	<@CommonQueryMacro.CommonQuery id="L15" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="L15Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="custName,lawType,dealResult,dealOrg,dealDate,custOrgCode,custAddress,lawContent,fdDate" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		L15_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>