<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="对公抵质押物出入库操作流水">
<table>
	<@CommonQueryMacro.CommonQuery id="C08" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="C08Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="contractNum[125],borrowNum[125],resOpNum[70],resNum[100],resOpUser[100],resAmount[100],resSum[100],resSummary[200],resOpDate[70],resOpOrg[70]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		C08_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>