<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="从合同信息">
<table>
	<@CommonQueryMacro.CommonQuery id="J17" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="J17Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="customerNum[100],fdCustName[200],contractNum[130],subcontractNum[130],subcontractTypeCd[140],superTopGuarantyId[170],currencyCd[70],subContractAmt[100],guarantyAmt[100],topGuarantyAmt[100],topCumulateGuarantyAmt[140],guaranteeTypeCd[100],guarantCustomerNum[170],warrantorName[150],guarantyRate[110],collateralTypeCd[130],subContractSignDate[70],startDate[70],expirationDate[70],registerOrg[70]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		J17_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>