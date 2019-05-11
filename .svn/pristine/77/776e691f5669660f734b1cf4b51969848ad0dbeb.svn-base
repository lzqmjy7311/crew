<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="帐务交易流水">
<table>
	<@CommonQueryMacro.CommonQuery id="A01" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="A01Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="txnDt,txnTm[150],custName[150],acctId[120],debCrdInd,ccy,txnAmt,oppoCustNm[200],oppoAcctId[120],txnAftrBal,custId[100],txnCateg,txnOrg,itemId[80],txnSerialId,txnCd[80],prodId,chnSerialId[250]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		A01_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>