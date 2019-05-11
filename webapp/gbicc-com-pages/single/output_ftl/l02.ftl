<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="工商变更明细">
<table>
	<@CommonQueryMacro.CommonQuery id="L02" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="L02Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="itemName,itemChBefore,itemChAfter,itemChDate,baseId" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		L02_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>