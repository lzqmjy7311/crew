<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="个人征信信息">
<table>
	<@CommonQueryMacro.CommonQuery id="L12" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="L12Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="fdCustname[200],fdCreditcardtype[120],fdCreditcard[100],fd24monMaxloanOverstatus[250],fdMaxloanOvernum[160],fdSumloanOvercount[160],fdCreditCardStatus[90],fd24monMaxcreditOverstatus[250],fd12monMaxcreditOvernum[260],fdCreditcardOverdraftAmt[80],fdMaxscreditcardOvernum[170],fdMaxcreditcardOvernum[160],fdMaxscreditcardOversum[160],fdMaxcreditcardOversum[160],fdMaxlfjyloanOversum[230],fdMaxjyloanOversum[250],fdFzamtsum[90],fdReportdate[100],fdHascredit[110],fdMaxloanstate[150],fdCreditlevel[70],fd3monBadLoanoverState[190],fd3yearBadLoanState[250]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//页面初始化
	function initCallGetter_post(){
		var warningId='${warningId}';
		L12_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>