<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="信贷公司客户信息">
<table>
	<@CommonQueryMacro.CommonQuery id="J18" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="J18Table" height="305" readonly="true" fitColumns="false" nowrap="true" 
		fieldStr="customerNum[100],chineseName[200],englishName[100],businessLicenseNum[120],orgnNum[100],bizLicExpirationDate[110],pbcIndustryCd[130],loanCardNum[120],corporativeCertification[90],nationalTaxRegistrationNum[150],foundedDate[70],loanRelationDate[110],registeredCapital[100],customerSizeCd[100],listedCompanyInd[100],groupCustomerInd[130],basicAcctBank[150],openDate[70],ourBankNplRecord[120],debtTransferStockCustInd[120],creditCustomerInd[],industryLevelTwoCd,customerStatusCd,crbCustomerSizeCd,corpImpLevel,myStockholderInd,economyType,corpNature,profAssureCorp,farmingIndustrySign,imexManaInd[120],loanRelationDate[150],cooperationBankInd[110],guaCustomerInd[100],industryNum[110],financeLicenceNum[110],corScientificInd[140],corShutInd[120],govFinanceFlat[100],pawnLoanInd[120],govFinanceType[160],cooperateType[70],smallCorporationInd[100]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		J18_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>