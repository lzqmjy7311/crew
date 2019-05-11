<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="信贷支用申请明细">
<table>
	<@CommonQueryMacro.CommonQuery id="C06" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="C06Table" nowrap="true" height="305" readonly="false" fitColumns="false" remoteSort="true" sortable="true"
		fieldStr="payoutInfoDetailId[250],amt[100],extendDate[70],creditProductCd[150],currencyCd[70],handlingOrgCd[100],draftCd[200],issuerName[200],acceptorName[200],payeeName[200],acceptorBankName[150],collectorAccount[150],discountAmt[100],payeeBankName[170],discountStartDate[70],lcCd[90],lcAmt[90],guaranteeNum[120],beneficiary[100],suitInd[110],unassumePeople[200],bankGuaranteeTypeCd[70],baseConCd[100],consignPeople[120],invoiceAmt[100],invoiceCd[100],pickupNum[90],purchaseName[100],singleAmt[100],singleRate[155],postPonementInd[100],remitAcctNo[110],payAcctNo[100],discountAcctNo[100],importContractNum[100],remitTypeCd[100],payPersonName[120],outAcct[110],outBank[150],remitBankName[150],payPersonOpenBank[150]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		C06_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>