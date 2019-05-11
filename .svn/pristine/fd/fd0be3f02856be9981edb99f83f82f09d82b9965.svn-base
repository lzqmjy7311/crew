<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="对公贷款借据明细">
<table>
	<@CommonQueryMacro.CommonQuery id="C01" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="C01Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="payoutInfoDetailId[250],customerNum[100],borrowNum[130],contractNum[130],loanAcct[130],loanBal[100],operateBrch[90],storeRate[70],creditBalance[100],bucketP[130],bocketI[130],inOweAccounts[80],outOweAccounts[80],totalReturnPrp[100],firstOvdueDate[110],firstPrimnessDate[110],firstBadDebtDate[110],addPeriodDate[80],bailSum[90],qxRevertDate[100],fourLevel[70],fiveLevel[70],discountSign[70],bankGuaranteeType[70],bankGuaranteeState[70],refundSum[70],reSponsionWithodrawalSum[100],undertakePaySum[70],untreadSum[70],financingInd[90],letterOfCreditState[90],postalOrderState[70],writeOffDate[80],expirationDate[80 ]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		C01_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>