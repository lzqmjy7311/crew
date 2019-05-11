<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="对公贷款还款明细">
<table>
	<@CommonQueryMacro.CommonQuery id="C02" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="C02Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="borrowNum[130],accounts[130],exchangeDate[70],exchangeSum[70],accountsBalance[70],bocketI[120],bocketW[120],bocketA[120],bocketE[120],ctaAccState[90],adjustType[100],warnId[70],dataDt[70],infoId[230],exchangeCode[70],onLoanSign[70],exchangeOrgan[70],exchangeOp[70],accreditOp[90],opExchangeSign[70],conversionSign[70],organExchangeSign[100],summary[50],cbSign[70],recordState[70],lastMaintainDate[100],etlDate[70],detailCd[100]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		C02_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>