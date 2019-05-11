<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign typeId="${RequestParameters['typeId']?default('')}" />
<#assign fdDate="${RequestParameters['fdDate']?default('')}" />
<#assign customerNum="${RequestParameters['customerNum']?default('')}" />
<@CommonQueryMacro.page title="Ë°Îñ">
<@CommonQueryMacro.CommonQuery id="TDataOwingTaxes" init="true" submitMode="selected" navigate="false">

<table align="left" width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="companyName,taxEnterNo,legalName,legalCertNo,taxType,sumTaxAmt,newTaxAmt,belongOrg,rowDate" readonly="true" width="100%"/></br>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
var customerNum='${customerNum}';
function initCallGetter_post(){
	var typeId='${typeId}';
	var fdDate='${fdDate}';
	TDataOwingTaxes_dataset.setParameter("typeid",typeId);
	TDataOwingTaxes_dataset.setParameter("data",fdDate);
	TDataOwingTaxes_dataset.setParameter("relaId",customerNum);
	TDataOwingTaxes_dataset.flushData();
}
</script>
</@CommonQueryMacro.page>
