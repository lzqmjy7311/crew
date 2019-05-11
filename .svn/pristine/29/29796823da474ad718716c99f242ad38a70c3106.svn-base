<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="理财账户信息">
<table>
	<@CommonQueryMacro.CommonQuery id="J16" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="J16Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="clientNo[110],custName[200],clientType[90],bankAcc[120],assetAcc[120],prdType[70],status[70],branchNo[130],clientManager[70],openDate[70]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		J16_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>