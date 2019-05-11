<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="对公客户信息">
<table>
	<@CommonQueryMacro.CommonQuery id="J02" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable height="305" id="J02Table" readonly="true" fitColumns="false"
		fieldStr="custno[100],custname[200],contactCode[70],clientSubTpCd[90],custLevelTpCd[110],creditLevelTpCd[70],industryTpCd[70],econatureTpCd[70],businessScope[200],mainBusiness[150],establishedDt[150],scaleTpCd[70],conName[90],conPositionTpCd[90],legalPersonName[110],legalPersonIdTpCd[140],legalPersonIdNum[140],bankStockholderInd[100],onlineBankInd[100],hasExBizInd[100],listedCompInd[100],approvalNum[90],superorgTpCd[100],headName[100],stockHolderId[100],impowerContId[130],hostOrg[150]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		J02_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>