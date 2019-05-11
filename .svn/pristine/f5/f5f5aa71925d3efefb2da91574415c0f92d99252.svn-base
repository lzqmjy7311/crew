<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="承兑汇票信息">
<table>
	<@CommonQueryMacro.CommonQuery id="A38" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="A38Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="draftNo[120],draftType,bgdfCurrency,draftAmt,payeeName[200],paymentDate,draftStatus,contractNo[150],advanceAcctNo[150],advanceAmount,advanceDate,remAcctNo[150]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		A38_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>