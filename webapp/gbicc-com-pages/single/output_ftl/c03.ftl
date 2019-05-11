<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="信贷合同">
<table>
	<@CommonQueryMacro.CommonQuery id="C03" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="C03Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="customerNum[100],contractNum[125],superContractNum[160],bizNum[130],creditProductCd[200],currencyCd[100],contractTotalAmt[100],contractProvidePurpose[250],loanTypeInstructionCd[200],industryLevelTwoCd[120],restrictIndustryInd[120],realtyLoanType[120],realtyLoanTypeInd[130],peasantLoanType[100],contractSignDate[70],startDate[70],expirationDate[70],classificationResult[100],lowRiskInd[90],lowRiskBizTypeCd[120],contractCycleInd[70],reformLoanInd[120],debtReformTypeCd[100],postponementInd[90],postPonementTypeCd[100],mainSuretyMode[100],mainSuertySubchild[120],guarantyRate[130],payDiscountAmt[80],topFinancingStartDate[130],topFinancingEndDate[130],originalContractExpDate[100],originalGuarantyContractNum[150],lcNum[90],remitPSum[70],noteCustomerNum[70],yhCurrencyCd[120],handlingOrgCd[70],handlingUserNum[100],contractSignPlace[120],bankTeamRole[70]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		C03_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>