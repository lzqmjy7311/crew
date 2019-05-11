<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign warningId=RequestParameters["warningId"]?default("")>

<@CommonQueryMacro.page title="�ͻ�ָ����Ϣ">
<table>
	<@CommonQueryMacro.CommonQuery id="C15" init="true" submitMode="current">
		<@CommonQueryMacro.DataTable id="C15Table" nowrap="true" height="305" readonly="true" fitColumns="false"
		fieldStr="customerNum[100],customerName[220],indexValue,indexType,indexDeadline,advanceAmount[100],advanceBalance[90],groupName[120],lastMSalAmount[120],lastTwoMSalAmount[120],lastThreeMSalAmount[120],lastMPubAmount[120],lastTwoMPubAmount[120],lastThreeMPubAmount[120],coreCustomerNum[100],creditAmount[90],creditBalance[90],normalAdvanceBal[130],mentionAdvanceBal[130],substdAdvanceBalance[130],doutfulAdvanceBal[130],lossAdvanceBal[130],custManagerId[130],overdueAdvanceBal[130],outsideGuaranteeAmount[130],outstandingAdvanceCount[130],handlingOrgCd[110],corporative[90],isOverdue[70],fiveLevel[70],classificationDate[130],coreHandlingOrgCd[90],depositBal[100],groupCustomerNum[100]" width="100%" hasFrame="true"/>
	</@CommonQueryMacro.CommonQuery>
</table>
<script>
	//ҳ���ʼ��
	function initCallGetter_post(){
		var warningId='${warningId}';
		C15_dataset.setParameter("warningId",warningId);
	}
</script>
</@CommonQueryMacro.page>